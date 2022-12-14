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
package ca.ntro.cards.common;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import ca.ntro.cards.common.models.CommonExecutableModel;
import ca.ntro.cards.common.test_cases.CommonTestCase;
import ca.ntro.cards.common.test_cases.CommonTestCaseDatabase;
import ca.ntro.cards.common.test_cases.execution.Execution;
import ca.ntro.cards.common.test_cases.execution.TestCaseJobEngine;
import ca.ntro.cards.common.test_cases.execution_trace.CommonExecutionTrace;
import ca.ntro.core.NtroJdk;
import ca.ntro.core.initialization.Ntro;

public abstract class GenerateTestCases<EXECUTABLE_MODEL   extends CommonExecutableModel,
                                        STUDENT_MODEL      extends EXECUTABLE_MODEL,
                                        TEST_CASE          extends CommonTestCase,
                                        TEST_CASE_DATABASE extends CommonTestCaseDatabase,
                                        EXECUTION_TRACE    extends CommonExecutionTrace> {


	private TestCaseJobEngine<EXECUTABLE_MODEL, STUDENT_MODEL, TEST_CASE> executionEngine = new TestCaseJobEngine<>();
	private TEST_CASE_DATABASE testCaseDatabase = Ntro.factory().newInstance(testCaseDatabaseClass());
	
	private int numberOfThreads;
	
	private long startTime;
	private long endTime;
	
	private Set<String> tasksDone = Collections.synchronizedSet(new HashSet<>());

	public void generateTestCases() {
		
		numberOfThreads = Execution.determineNumberOfThreads(CommonConstants.DEFAULT_NUMBER_OF_EXECUTION_THREADS);
		
		System.out.println("\n\n[INIT]");
		System.out.flush();

		initialize();
		
		System.out.println("\n\n[GENERATING TEST CASES]");
		System.out.println(String.format("\n... using %s threads", numberOfThreads));
		System.out.flush();
		
		startTime = System.currentTimeMillis();
		
		testCaseDatabase.createTestCaseGenerationTasks();
		
		testCaseDatabase.onCreationDone(() -> {

			endTime = System.currentTimeMillis();
			
			System.out.println(String.format("\n... creation done in %.2f seconds\n", (endTime - startTime) / 1E3));
			System.out.flush();
			
			startTime = System.currentTimeMillis();
			
			tasksDone.add("creation");
			quitWhenAllDone();
			
		});

		testCaseDatabase.onWritingDone(() -> {

			endTime = System.currentTimeMillis();
			
			System.out.println(String.format("... writing done in %.2f seconds\n", (endTime - startTime) / 1E3));
			System.out.flush();

			tasksDone.add("writing");
			quitWhenAllDone();
			
		});

		testCaseDatabase.runTestCaseGenerationTasks();
	}

	private void quitWhenAllDone() {
		if(tasksDone.contains("creation")
				&& tasksDone.contains("writing")) {

			endTime = System.currentTimeMillis();

			executionEngine.shutdown();

		}
	}



	protected abstract Class<EXECUTABLE_MODEL> executableModelClass();
	protected abstract Class<STUDENT_MODEL> studentModelClass();
	protected abstract Class<TEST_CASE> testCaseClass();
	protected abstract Class<TEST_CASE_DATABASE> testCaseDatabaseClass();
	protected abstract Class<? extends EXECUTION_TRACE> executionTraceClass();
	protected abstract boolean shouldWriteJson();

	private void initialize() {
		NtroJdk.initializer().executeBlocking();
		
		initializeExecutionEngine();
		
		initializeTestCaseDatabase();

	}


	private void initializeExecutionEngine() {
		Execution.registerExecutionEngine(executionEngine);

		executionEngine.registerExecutableModelClass(executableModelClass());
		executionEngine.registerStudentModelClass(studentModelClass());
		executionEngine.registerTestCaseClass(testCaseClass());
		
		executionEngine.initialize(numberOfThreads);
		
		executionEngine.resetTestCasesDirectory();
		executionEngine.resetStorageDirectory();
	}

	@SuppressWarnings("unchecked")
	private void initializeTestCaseDatabase() {

		testCaseDatabase.registerExecutableModelClass(executableModelClass());
		testCaseDatabase.registerStudentModelClass(studentModelClass());
		testCaseDatabase.registerTestCaseClass(testCaseClass());
		testCaseDatabase.setExecutionTraceClass(executionTraceClass());
		testCaseDatabase.registerShouldWriteJson(shouldWriteJson());

		
		testCaseDatabase.registerExecutionEngine(executionEngine);
	}
}
