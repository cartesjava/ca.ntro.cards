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

import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.cards.common.backend.CommonBackend;
import ca.ntro.cards.common.commands.AddCommand;
import ca.ntro.cards.common.commands.ClearCommand;
import ca.ntro.cards.common.commands.DeleteCommand;
import ca.ntro.cards.common.commands.GetCommand;
import ca.ntro.cards.common.commands.InsertCommand;
import ca.ntro.cards.common.frontend.CommonFrontend;
import ca.ntro.cards.common.frontend.CommonViewData;
import ca.ntro.cards.common.frontend.views.CommonCanvasView;
import ca.ntro.cards.common.frontend.views.CommonDashboardView;
import ca.ntro.cards.common.frontend.views.CommonMessagesView;
import ca.ntro.cards.common.frontend.views.CommonRootView;
import ca.ntro.cards.common.frontend.views.CommonSettingsView;
import ca.ntro.cards.common.frontend.views.fragments.CommonMessageFragment;
import ca.ntro.cards.common.messages.MsgMessageToUser;
import ca.ntro.cards.common.messages.MsgRefreshDashboard;
import ca.ntro.cards.common.messages.MsgStartExecutionEngine;
import ca.ntro.cards.common.messages.MsgStopExecutionReplay;
import ca.ntro.cards.common.messages.MsgToggleUseFourCardColors;
import ca.ntro.cards.common.models.CommonCanvasModel;
import ca.ntro.cards.common.models.CommonDashboardModel;
import ca.ntro.cards.common.models.CommonExecutableModel;
import ca.ntro.cards.common.models.CommonSettingsModel;
import ca.ntro.cards.common.models.enums.Attempt;
import ca.ntro.cards.common.models.values.cards.AbstractCard;
import ca.ntro.cards.common.models.values.cards.Carte;
import ca.ntro.cards.common.test_cases.CommonTestCase;
import ca.ntro.cards.common.test_cases.CommonTestCaseDatabase;
import ca.ntro.cards.common.test_cases.descriptor.CommonTestCaseDescriptor;
import ca.ntro.cards.common.test_cases.execution_trace.CommonExecutionTrace;
import ca.ntro.cards.common.test_cases.execution_trace.CommonExecutionTraceFull;
import ca.ntro.cards.common.test_cases.execution_trace.CommonExecutionTraceSizeOnly;
import ca.ntro.cards.common.test_cases.indexing.TestCaseById;
import ca.ntro.cards.common.test_cases.indexing.TestCasesByCategory;
import ca.ntro.cards.common.test_cases.indexing.TestCasesBySize;

public abstract class CommonApp<EXECUTABLE_MODEL   extends CommonExecutableModel,
                                STUDENT_MODEL      extends EXECUTABLE_MODEL,
                                CANVAS_MODEL       extends CommonCanvasModel,
                                TEST_CASE          extends CommonTestCase,
                                TEST_CASE_DATABASE extends CommonTestCaseDatabase,
                                EXECUTION_TRACE    extends CommonExecutionTrace,
                                DASHBOARD_MODEL    extends CommonDashboardModel,
                                SETTINGS_MODEL     extends CommonSettingsModel,
                                                                                                      
                                BACKEND extends CommonBackend<EXECUTABLE_MODEL, 
                                                              STUDENT_MODEL,
                                                              CANVAS_MODEL,
                                                              TEST_CASE, 
                                                              TEST_CASE_DATABASE, 
                                                              EXECUTION_TRACE,
                                                              DASHBOARD_MODEL, 
                                                              SETTINGS_MODEL>,
                                   
                                ROOT_VIEW        extends CommonRootView, 
                                CARDS_VIEW       extends CommonCanvasView, 
                                DASHBOARD_VIEW   extends CommonDashboardView,
                                SETTINGS_VIEW    extends CommonSettingsView,
                                MESSAGES_VIEW    extends CommonMessagesView,
                                MESSAGE_FRAGMENT extends CommonMessageFragment,
                                VIEW_DATA        extends CommonViewData,
                                     
                                FRONTEND extends CommonFrontend<ROOT_VIEW, 
                                                                SETTINGS_VIEW, 
                                                                CARDS_VIEW, 
                                                                DASHBOARD_VIEW, 
                                                                MESSAGES_VIEW,
                                                                MESSAGE_FRAGMENT,
                                                                VIEW_DATA,
                                                                CANVAS_MODEL,
                                                                DASHBOARD_MODEL,
                                                                SETTINGS_MODEL>>

                implements NtroClientFx {

	@Override
	public void registerModels(ModelRegistrar registrar) {
		registrar.registerValue(executableModelClass());
		registrar.registerValue(studentModelClass());
		registrar.registerModel(canvasModelClass());

		registrar.registerModel(dashboardModelClass());
		registrar.registerModel(settingsModelClass());

		registrar.registerValue(testCasesModelClass());
		registrar.registerValue(testCaseClass());

		registrar.registerValue(Carte.class);
		registrar.registerValue(AbstractCard.class);

		registrar.registerValue(CommonTestCaseDescriptor.class);
		registrar.registerValue(TestCaseById.class);
		registrar.registerValue(TestCasesByCategory.class);
		registrar.registerValue(TestCasesBySize.class);

		registrar.registerValue(CommonExecutionTraceFull.class);
		registrar.registerValue(CommonExecutionTraceSizeOnly.class);
		
		registrar.registerValue(AddCommand.class);
		registrar.registerValue(ClearCommand.class);
		registrar.registerValue(DeleteCommand.class);
		registrar.registerValue(GetCommand.class);
		registrar.registerValue(InsertCommand.class);

		registerAdditionnalModels(registrar);
	}


	@Override
	public void registerMessages(MessageRegistrar registrar) {
		registrar.registerMessage(MsgToggleUseFourCardColors.class);
		registrar.registerMessage(MsgRefreshDashboard.class);
		registrar.registerMessage(MsgStopExecutionReplay.class);
		registrar.registerMessage(MsgStartExecutionEngine.class);
		registrar.registerMessage(MsgMessageToUser.class);

		registerAdditionnalMessages(registrar);
	}

	@Override
	public void registerFrontend(FrontendRegistrarFx registrar) {
		FRONTEND frontend = createFrontend();
		
		frontend.setCanvasModelClass(canvasModelClass());
		frontend.setDashboardModelClass(dashboardModelClass());
		frontend.setSettingsModelClass(settingsModelClass());
		
		registrar.registerFrontend(frontend);
	}



	@Override
	public void registerBackend(BackendRegistrar registrar) {
		BACKEND backend = createBackend();
		
		backend.setExecutableModelClass(executableModelClass());
		backend.setStudentModelClass(studentModelClass());
		backend.setCanvasModelClass(canvasModelClass());
		backend.setTestCaseClass(testCaseClass());
		backend.setTestCasesModelClass(testCasesModelClass());
		backend.setDashboardModelClass(dashboardModelClass());
		backend.setSettingsModelClass(settingsModelClass());
		backend.setExecutionTraceFullClass(executionTraceClass());
		
		backend.initializeTestCaseDatabase();
		backend.earlyModelInitialization(initialTestCaseId(), initialAttempt());
		
		additionnalBackendInitialization(backend);

		registrar.registerBackend(backend);

	}

	protected abstract void additionnalBackendInitialization(BACKEND backend);

	protected abstract Class<EXECUTABLE_MODEL> executableModelClass();
	protected abstract Class<STUDENT_MODEL> studentModelClass();
	protected abstract Class<CANVAS_MODEL> canvasModelClass();
	protected abstract Class<TEST_CASE> testCaseClass();
	protected abstract Class<TEST_CASE_DATABASE> testCasesModelClass();
	protected abstract Class<DASHBOARD_MODEL> dashboardModelClass();
	protected abstract Class<SETTINGS_MODEL> settingsModelClass();

	protected abstract Class<? extends EXECUTION_TRACE> executionTraceClass();

	protected abstract void registerAdditionnalModels(ModelRegistrar registrar);
	protected abstract void registerAdditionnalMessages(MessageRegistrar registrar);

	protected abstract FRONTEND createFrontend();
	protected abstract BACKEND createBackend();
	
	protected abstract String initialTestCaseId();
	protected abstract Attempt initialAttempt();

}
