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
package ca.ntro.cards.common.test_cases.execution.jobs;

import ca.ntro.cards.common.models.CommonExecutableModel;
import ca.ntro.cards.common.models.enums.Attempt;
import ca.ntro.cards.common.test_cases.CommonTestCase;
import ca.ntro.cards.common.test_cases.execution.TestCaseJobEngine;
import ca.ntro.cards.common.test_cases.execution.handlers.DoneHandler;
import ca.ntro.cards.common.test_cases.execution.signals.Signal;

public abstract class Job<EXECUTABLE_MODEL extends CommonExecutableModel,
                          STUDENT_MODEL extends EXECUTABLE_MODEL,
                          TEST_CASE extends CommonTestCase>  

       extends Signal {
	
	private TEST_CASE testCase;
	private TestCaseJobEngine<EXECUTABLE_MODEL, STUDENT_MODEL, TEST_CASE> executionEngine;
	private DoneHandler doneHandler;
	
	private Attempt attempt = Attempt.SOLUTION;

	public TEST_CASE getTestCase() {
		return testCase;
	}

	public void setTestCase(TEST_CASE testCase) {
		this.testCase = testCase;
	}

	public TestCaseJobEngine<EXECUTABLE_MODEL, STUDENT_MODEL, TEST_CASE> getExecutionEngine() {
		return executionEngine;
	}

	public void setExecutionEngine(TestCaseJobEngine<EXECUTABLE_MODEL, STUDENT_MODEL, TEST_CASE> executionEngine) {
		this.executionEngine = executionEngine;
	}

	public DoneHandler getDoneHandler() {
		return doneHandler;
	}

	public void setDoneHandler(DoneHandler doneHandler) {
		this.doneHandler = doneHandler;
	}

	public Attempt getAttempt() {
		return attempt;
	}

	public void setAttempt(Attempt attempt) {
		this.attempt = attempt;
	}

	protected String id() {
		return getTestCase().getTestCaseId();
	}

	public void run() {
		runImpl();
		doneHandler.done();
	}

	public abstract void runImpl();

	public void addExecutionStep() {
		testCase.addExecutionStep(attempt);
	}

	public void failsWith(Throwable t) {
	}

}
