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
package ca.ntro.cards.common.backend;

import ca.ntro.app.NtroApp;
import ca.ntro.app.backend.LocalBackendNtro;
import ca.ntro.app.tasks.backend.BackendTasks;
import ca.ntro.cards.common.CommonConstants;
import ca.ntro.cards.common.backend.tasks.ModifyCanvasModel;
import ca.ntro.cards.common.backend.tasks.ModifyDashboardModel;
import ca.ntro.cards.common.backend.tasks.ModifySettingsModel;
import ca.ntro.cards.common.messages.MsgStartExecutionEngine;
import ca.ntro.cards.common.models.CommonCanvasModel;
import ca.ntro.cards.common.models.CommonDashboardModel;
import ca.ntro.cards.common.models.CommonExecutableModel;
import ca.ntro.cards.common.models.CommonSettingsModel;
import ca.ntro.cards.common.models.enums.Attempt;
import ca.ntro.cards.common.test_cases.CommonTestCase;
import ca.ntro.cards.common.test_cases.CommonTestCaseDatabase;
import ca.ntro.cards.common.test_cases.execution.Execution;
import ca.ntro.cards.common.test_cases.execution.TestCaseJobEngine;
import ca.ntro.cards.common.test_cases.execution_trace.CommonExecutionTrace;
import ca.ntro.core.initialization.Ntro;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

public abstract class CommonBackend<EXECUTABLE_MODEL   extends CommonExecutableModel,
                                    STUDENT_MODEL      extends EXECUTABLE_MODEL,
                                    CANVAS_MODEL       extends CommonCanvasModel,
                                    TEST_CASE          extends CommonTestCase,
                                    TEST_CASE_DATABASE extends CommonTestCaseDatabase,
                                    EXECUTION_TRACE    extends CommonExecutionTrace,
                                    DASHBOARD_MODEL    extends CommonDashboardModel,
                                    SETTINGS_MODEL     extends CommonSettingsModel>

       extends LocalBackendNtro {

	private TestCaseJobEngine<EXECUTABLE_MODEL, STUDENT_MODEL, TEST_CASE> testCaseJobEngine = new TestCaseJobEngine<>();
	private TEST_CASE_DATABASE testCaseDatabase;
	
	private Class<EXECUTABLE_MODEL> executableModelClass;
	private Class<STUDENT_MODEL> studentModelClass;
	private Class<CANVAS_MODEL> canvasModelClass;
	private Class<TEST_CASE> testCaseClass;
	private Class<TEST_CASE_DATABASE> testCaseDatabaseClass;
	private Class<DASHBOARD_MODEL> dashboardModelClass;
	private Class<SETTINGS_MODEL> settingsModelClass;
	private Class<? extends EXECUTION_TRACE> executionTraceFullClass;
	
	protected TEST_CASE_DATABASE testCaseDatabase() {
		return testCaseDatabase;
	}

	public Class<STUDENT_MODEL> getStudentModelClass() {
		return studentModelClass;
	}

	public void setStudentModelClass(Class<STUDENT_MODEL> studentModelClass) {
		this.studentModelClass = studentModelClass;
	}

	public void setExecutableModelClass(Class<EXECUTABLE_MODEL> executableModelClass) {
		this.executableModelClass = executableModelClass;
	}

	public void setDashboardModelClass(Class<DASHBOARD_MODEL> dashboardModelClass) {
		this.dashboardModelClass = dashboardModelClass;
	}

	public void setSettingsModelClass(Class<SETTINGS_MODEL> settingsModelClass) {
		this.settingsModelClass = settingsModelClass;
	}

	public void setTestCaseClass(Class<TEST_CASE> testCaseClass) {
		this.testCaseClass = testCaseClass;
	}

	public void setTestCasesModelClass(Class<TEST_CASE_DATABASE> testCasesModelClass) {
		this.testCaseDatabaseClass = testCasesModelClass;
	}

	public Class<EXECUTABLE_MODEL> getExecutableModelClass() {
		return executableModelClass;
	}

	public Class<TEST_CASE> getTestCaseClass() {
		return testCaseClass;
	}

	public Class<TEST_CASE_DATABASE> getTestCasesModelClass() {
		return testCaseDatabaseClass;
	}

	public Class<DASHBOARD_MODEL> getDashboardModelClass() {
		return dashboardModelClass;
	}

	public Class<SETTINGS_MODEL> getSettingsModelClass() {
		return settingsModelClass;
	}

	public Class<CANVAS_MODEL> getCanvasModelClass() {
		return canvasModelClass;
	}

	public void setCanvasModelClass(Class<CANVAS_MODEL> canvasModelClass) {
		this.canvasModelClass = canvasModelClass;
	}
	
	public TestCaseJobEngine<EXECUTABLE_MODEL, STUDENT_MODEL, TEST_CASE> getTestCaseJobEngine() {
		return testCaseJobEngine;
	}

	public void setTestCaseJobEngine(TestCaseJobEngine<EXECUTABLE_MODEL, STUDENT_MODEL, TEST_CASE> testCaseJobEngine) {
		this.testCaseJobEngine = testCaseJobEngine;
	}

	public TEST_CASE_DATABASE getTestCaseDatabase() {
		return testCaseDatabase;
	}

	public void setTestCaseDatabase(TEST_CASE_DATABASE testCaseDatabase) {
		this.testCaseDatabase = testCaseDatabase;
	}

	public Class<? extends EXECUTION_TRACE> getExecutionTraceFullClass() {
		return executionTraceFullClass;
	}

	public void setExecutionTraceFullClass(Class<? extends EXECUTION_TRACE> executionTraceFullClass) {
		this.executionTraceFullClass = executionTraceFullClass;
	}

	public void initializeTestCaseDatabase() {

		testCaseDatabase = Ntro.factory().newInstance(testCaseDatabaseClass);
		testCaseDatabase.registerExecutableModelClass(executableModelClass);
		testCaseDatabase.registerStudentModelClass(studentModelClass);
		testCaseDatabase.registerTestCaseClass(testCaseClass);
		testCaseDatabase.registerShouldWriteJson(false);
		
		testCaseDatabase.registerExecutionEngine(testCaseJobEngine);
		
		Execution.registerExecutionEngine(testCaseJobEngine);

	}

	public abstract void earlyModelInitialization(String initialTestCaseId, Attempt initialAttempt);

	@Override
	public void createTasks(BackendTasks tasks) {
		
		ModifyCanvasModel.createTasks(tasks, 
				                      canvasModelClass,
				                      subTasks -> {
				                    	 
				                    	 addSubTasksToModifyCanvasModel(subTasks);
				                    	 
				                     });

		ModifyDashboardModel.createTasks(tasks,
				                         dashboardModelClass,
				                         testCaseDatabase,
				                          subTasks -> {

				                        	addSubTasksToModifyDashboardModel(subTasks);

				                        });
		


		ModifySettingsModel.createTasks(tasks,
				                        settingsModelClass,
				                        subTasks -> {
				                        	
				                        	addSubTasksToModifySettingsModel(subTasks);

				                        });
		
		
		 createAdditionalTasks(tasks);

	}

	protected abstract void addSubTasksToModifyCanvasModel(BackendTasks subTasks);
	protected abstract void addSubTasksToModifyDashboardModel(BackendTasks subTasks);
	protected abstract void addSubTasksToModifySettingsModel(BackendTasks subTasks);
	
	protected abstract void createAdditionalTasks(BackendTasks tasks);

	@Override
	public void execute() {

		int numberOfThreads = Execution.determineNumberOfThreads(CommonConstants.DEFAULT_NUMBER_OF_EXECUTION_THREADS);
		if(numberOfThreads > 2) {
			numberOfThreads -= 2;
		}else if(numberOfThreads == 2) {
			numberOfThreads = 1;
		}

		testCaseJobEngine.registerExecutableModelClass(executableModelClass);
		testCaseJobEngine.registerStudentModelClass(studentModelClass);
		testCaseJobEngine.registerTestCaseClass(testCaseClass);
		testCaseJobEngine.initialize(numberOfThreads);

	}

}
