/*
Copyright (C) (2022) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)

This file is part of "Cartes Java", teaching tools made for https://cartesjava.github.io/

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

*/
package ca.ntro.cards.models;


import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.cards.common.models.CommonDashboardModel;
import ca.ntro.cards.common.models.enums.Attempt;
import ca.ntro.cards.common.test_cases.descriptor.AbstractAttemptDescriptor;
import ca.ntro.cards.common.test_cases.descriptor.AbstractTestCaseDescriptor;
import ca.ntro.cards.common.test_cases.descriptor.CommonTestCaseDescriptor;
import ca.ntro.cards.common.test_cases.descriptor.CurrentAttemptHolder;
import ca.ntro.cards.common.test_cases.indexing.TestCaseById;
import ca.ntro.cards.common.test_cases.indexing.TestCasesByCategory;
import ca.ntro.cards.frontend.views.ProcedureDashboardView;
import ca.ntro.cards.frontend.views.ProcedureReplayView;
import ca.ntro.cards.frontend.views.ProcedureSelectionsView;
import ca.ntro.cards.frontend.views.fragments.ProcedureTestCaseFragment;
import ca.ntro.cards.test_cases.ProcedureTestCaseDatabase;
import ca.ntro.cards.test_cases.descriptor.ProcedureAttemptDescriptor;
import ca.ntro.cards.test_cases.descriptor.ProcedureTestCaseDescriptor;

public abstract class ProcedureDashboardModel<DASHBOARD_VIEW     extends ProcedureDashboardView,
								              CARDS_MODEL        extends ProcedureCardsModel, 
                                              TEST_CASE_DATABASE extends ProcedureTestCaseDatabase,
                                              TEST_CASE          extends ProcedureTestCaseDescriptor,
                                              REPLAY_VIEW        extends ProcedureReplayView,
                                              SELECTIONS_VIEW    extends ProcedureSelectionsView,
                                              TEST_CASE_FRAGMENT extends ProcedureTestCaseFragment>

       extends CommonDashboardModel<DASHBOARD_VIEW, TEST_CASE, TEST_CASE_DATABASE> 

       implements CurrentAttemptHolder {
    	   
    	   
    private long version = 0;
    	   
    private TestCaseById<CARDS_MODEL, TEST_CASE> byId = new TestCaseById<>();
    private TestCasesByCategory<CARDS_MODEL, TEST_CASE> byCategory = new TestCasesByCategory<>();

	private Attempt currentAttempt = Attempt.SOLUTION;
	private String currentTestCaseId = defaultTestCaseId();

	public String getCurrentTestCaseId() {
		return currentTestCaseId;
	}

	public void setCurrentTestCaseId(String currentTestCaseId) {
		this.currentTestCaseId = currentTestCaseId;
	}

	public Attempt getCurrentMode() {
		return currentAttempt;
	}

	public void setCurrentMode(Attempt currentMode) {
		this.currentAttempt = currentMode;
	}

	public TestCaseById<CARDS_MODEL, TEST_CASE> getById() {
		return byId;
	}

	public void setById(TestCaseById<CARDS_MODEL, TEST_CASE> byId) {
		this.byId = byId;
	}

	public TestCasesByCategory<CARDS_MODEL, TEST_CASE> getByCategory() {
		return byCategory;
	}

	public void setByCategory(TestCasesByCategory<CARDS_MODEL, TEST_CASE> byCategory) {
		this.byCategory = byCategory;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	protected abstract String defaultTestCaseId();

	public void loadCurrentTestCase(TEST_CASE_DATABASE testCaseDatabase) {
		TEST_CASE descriptor = (TEST_CASE) testCaseDatabase.loadTestCase(currentTestCaseId);
		
		descriptor.setParentModel(this);

		addOrUpdateTestCase(descriptor);
	}

	public void updateCardsModel(TEST_CASE_DATABASE testCaseDatabase, CARDS_MODEL cardsModel) {
		testCaseDatabase.updateCardsModel(currentTestCaseId, currentAttempt, cardsModel);
	}

	public void displayOn(REPLAY_VIEW replayView) {
		TEST_CASE testCase = byId.testCaseById(currentTestCaseId);
		AbstractAttemptDescriptor attempt = testCase.attempt(currentAttempt);

		replayView.displayNumberOfCards(String.valueOf(testCase.inputSize()));
		replayView.displayCurrentStep(String.valueOf(attempt.currentStep() + 1));
		replayView.displayNumberOfSteps(String.valueOf(attempt.numberOfSteps()));
	}

	@Override
	public void displayOn(DASHBOARD_VIEW dashboardView) {
	}

	@Override
	public void addOrUpdateTestCase(TEST_CASE testCaseDescriptor) {
		
		testCaseDescriptor.setParentModel(this);

		TEST_CASE storedTestCase = byId.addOrUpdateTestCase(testCaseDescriptor);
		byCategory.addTestCase(storedTestCase);
		
		version++;
	}
	
	public void changeTestCaseAttempt(String testCaseId, Attempt attempt) {
		this.currentTestCaseId = testCaseId;
		this.currentAttempt = attempt;
	}

	public void displayOn(SELECTIONS_VIEW selectionsView, 
			              ProcedureDashboardModel previousModel,
			              ViewLoader<TEST_CASE_FRAGMENT> testCaseFragmentLoader) {

		if(selectionsView.hasEarlierVersion(version)) {
			
			selectionsView.memorizeVersion(version);
			
			byCategory.inOrder().reduceToResult(0, (testCaseIndex, testCaseDescriptor) -> {
				
				if(!previousModel.containsTestCase(testCaseDescriptor)) {

					TEST_CASE_FRAGMENT newFragment = testCaseFragmentLoader.createView();
					
					testCaseDescriptor.displayOn(newFragment);

					selectionsView.insertTestCase(testCaseIndex, newFragment);

				}else {
					
					TEST_CASE_FRAGMENT existingFragment = (TEST_CASE_FRAGMENT) selectionsView.testCaseFragment(testCaseDescriptor.testCaseId());

					testCaseDescriptor.displayOn(existingFragment);
					
				}
				
				return testCaseIndex+1;

			}).throwException();
		}
	}

	public int numberOfTestCases() {
		return byId.size();
	}

	public boolean containsTestCase(TEST_CASE testCaseDescriptor) {
		return containsTestCase(testCaseDescriptor.getTestCaseId());
	}

	public boolean containsTestCase(String testCaseId) {
		return byId.testCaseById(testCaseId) != null;
	}

	public void initialize() {
		byId.testCases().forEach(testCase -> {
			testCase.setLoaded(false);
			testCase.setIsSolution(false);
		});

		version = 0;
	}

	public void stepBackward(TEST_CASE_DATABASE testCaseDatabase) {
		testCaseDatabase.stepBackward(currentTestCaseId, currentAttempt);
		
		testCaseDatabase.addOrUpdateTestCase(currentTestCaseId, this);
	}

	public void stepForward(TEST_CASE_DATABASE testCaseDatabase) {
		testCaseDatabase.stepForward(currentTestCaseId, currentAttempt);

		testCaseDatabase.addOrUpdateTestCase(currentTestCaseId, this);
	}

	public void rewindToFirstStep(TEST_CASE_DATABASE testCaseDatabase) {
		testCaseDatabase.rewindToFirstStep(currentTestCaseId, currentAttempt);

		testCaseDatabase.addOrUpdateTestCase(currentTestCaseId, this);
	}

	public void fastFowardToLastStep(TEST_CASE_DATABASE testCaseDatabase) {
		testCaseDatabase.fastForwardToLastStep(currentTestCaseId, currentAttempt);

		testCaseDatabase.addOrUpdateTestCase(currentTestCaseId, this);
	}

	public void pushManualExecutionStep(TEST_CASE_DATABASE testCaseDatabase, CARDS_MODEL cardsModel) {
		testCaseDatabase.pushManualExecutionStep(currentTestCaseId, cardsModel);

		testCaseDatabase.addOrUpdateTestCase(currentTestCaseId, this);
	}

	public void updateCurrentTestCase(TEST_CASE_DATABASE testCaseDatabase) {
		testCaseDatabase.addOrUpdateTestCase(currentTestCaseId, this);
	}
	


	@Override
	public void loadDbFromDir(TEST_CASE_DATABASE testCaseDatabase) {
		testCaseDatabase.loadFromDbDir(currentTestCaseId);
	}

	@Override
	public boolean isCurrentAttempt(String testCaseId, Attempt attempt) {
		return currentTestCaseId.equals(testCaseId) && currentAttempt.equals(attempt);
	}

}

