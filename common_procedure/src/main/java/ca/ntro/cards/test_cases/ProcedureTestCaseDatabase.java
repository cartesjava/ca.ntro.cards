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
package ca.ntro.cards.test_cases;

import ca.ntro.cards.common.models.CommonExecutableModel;
import ca.ntro.cards.common.models.enums.Attempt;
import ca.ntro.cards.common.test_cases.CommonTestCaseDatabase;
import ca.ntro.cards.common.test_cases.CommonTestCase;
import ca.ntro.cards.models.ProcedureCardsModel;
import ca.ntro.cards.models.ProcedureDashboardModel;
import ca.ntro.cards.test_cases.descriptor.ProcedureTestCaseDescriptor;
import ca.ntro.cards.test_cases.execution_trace.ProcedureExecutionTrace;

public abstract class ProcedureTestCaseDatabase<EXECUTABLE_MODEL extends ProcedureCardsModel, 
                                                STUDENT_MODEL    extends EXECUTABLE_MODEL,
                                                TEST_CASE        extends ProcedureTestCase,
                                                EXECUTION_TRACE  extends ProcedureExecutionTrace,
                                                DASHBOARD_MODEL  extends ProcedureDashboardModel> 

       extends CommonTestCaseDatabase<EXECUTABLE_MODEL, 
                                      STUDENT_MODEL, 
                                      TEST_CASE,
                                      EXECUTION_TRACE> {


	public void updateCardsModel(String testCaseId, Attempt attempt, ProcedureCardsModel cardsModel) {
		TEST_CASE testCase = testCaseById(testCaseId);

		testCase.updateCardsModel(attempt, cardsModel);
	}

	public void addOrUpdateTestCases(DASHBOARD_MODEL dashboardModel) {
		testCases().forEach(testCase -> {

			dashboardModel.addOrUpdateTestCase((ProcedureTestCaseDescriptor) testCase.asTestCaseDescriptor());

		});
	}

	public void addOrUpdateTestCase(String testCaseId, DASHBOARD_MODEL dashboardModel) {
		TEST_CASE testCase = testCaseById(testCaseId);

		dashboardModel.addOrUpdateTestCase((ProcedureTestCaseDescriptor) testCase.asTestCaseDescriptor());
	}

	public void pushManualExecutionStep(String testCaseId, STUDENT_MODEL cardsModel) {
		TEST_CASE testCase = testCaseById(testCaseId);

		testCase.pushManualExecutionStep(cardsModel);
	}



}
