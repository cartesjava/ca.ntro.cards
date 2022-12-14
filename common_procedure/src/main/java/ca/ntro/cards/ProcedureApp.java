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
package ca.ntro.cards;

import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.cards.backend.ProcedureBackend;
import ca.ntro.cards.common.CommonApp;
import ca.ntro.cards.common.backend.CommonBackend;
import ca.ntro.cards.common.frontend.CommonFrontend;
import ca.ntro.cards.common.messages.MsgToggleUseFourCardColors;
import ca.ntro.cards.common.models.enums.Attempt;
import ca.ntro.cards.common.test_cases.descriptor.CommonAttemptDescriptor;
import ca.ntro.cards.frontend.ProcedureViewData;
import ca.ntro.cards.frontend.views.ProcedureCanvasView;
import ca.ntro.cards.frontend.views.ProcedureDashboardView;
import ca.ntro.cards.frontend.views.ProcedureMessagesView;
import ca.ntro.cards.frontend.views.ProcedureRootView;
import ca.ntro.cards.frontend.views.ProcedureSettingsView;
import ca.ntro.cards.frontend.views.fragments.ProcedureMessageFragment;
import ca.ntro.cards.messages.MsgChangeTestCaseAttempt;
import ca.ntro.cards.messages.MsgExecutionFastForwardToLastStep;
import ca.ntro.cards.messages.MsgExecutionRewindToFirstStep;
import ca.ntro.cards.messages.MsgExecutionStepBack;
import ca.ntro.cards.messages.MsgExecutionStepForward;
import ca.ntro.cards.messages.ProcedureMsgAcceptManualModel;
import ca.ntro.cards.models.ProcedureCardsModel;
import ca.ntro.cards.models.ProcedureDashboardModel;
import ca.ntro.cards.models.ProcedureSettingsModel;
import ca.ntro.cards.test_cases.ProcedureTestCase;
import ca.ntro.cards.test_cases.ProcedureTestCaseDatabase;
import ca.ntro.cards.test_cases.descriptor.ProcedureTestCaseDescriptor;
import ca.ntro.cards.test_cases.execution_trace.ProcedureExecutionTrace;
import ca.ntro.cards.test_cases.execution_trace.ProcedureExecutionTraceFull;

public abstract class ProcedureApp<EXECUTABLE_MODEL        extends ProcedureCardsModel,
							       STUDENT_MODEL           extends EXECUTABLE_MODEL,
	                               CANVAS_MODEL            extends ProcedureCardsModel,
                                   TEST_CASE               extends ProcedureTestCase,
                                   TEST_CASE_DESCRIPTOR    extends ProcedureTestCaseDescriptor,
                                   TEST_CASES_MODEL        extends ProcedureTestCaseDatabase,
                                   EXECUTION_TRACE         extends ProcedureExecutionTrace,
                                   DASHBOARD_MODEL         extends ProcedureDashboardModel,
                                   SETTINGS_MODEL          extends ProcedureSettingsModel,
                                   MSG_ACCEPT_MANUAL_MODEL extends ProcedureMsgAcceptManualModel,
                                                                                                      
                                   BACKEND extends ProcedureBackend<EXECUTABLE_MODEL, 
                                                                    STUDENT_MODEL,
                                                                    CANVAS_MODEL,
                                                                    TEST_CASE, 
                                                                    TEST_CASES_MODEL, 
                                                                    EXECUTION_TRACE,
                                                                    DASHBOARD_MODEL, 
                                                                    SETTINGS_MODEL,
                                                                    MSG_ACCEPT_MANUAL_MODEL>,
                                   
                                   ROOT_VIEW        extends ProcedureRootView, 
                                   CANVAS_VIEW      extends ProcedureCanvasView, 
                                   DASHBOARD_VIEW   extends ProcedureDashboardView,
                                   SETTINGS_VIEW    extends ProcedureSettingsView,
                                   MESSAGES_VIEW    extends ProcedureMessagesView,
                                   MESSAGE_FRAGMENT extends ProcedureMessageFragment,
                                   VIEW_DATA        extends ProcedureViewData,
                                     
                                   FRONTEND extends CommonFrontend<ROOT_VIEW, 
                                                                   SETTINGS_VIEW, 
                                                                   CANVAS_VIEW, 
                                                                   DASHBOARD_VIEW, 
                                                                   MESSAGES_VIEW,
                                                                   MESSAGE_FRAGMENT,
                                                                   VIEW_DATA,
                                                                   CANVAS_MODEL,
                                                                   DASHBOARD_MODEL,
                                                                   SETTINGS_MODEL>>

       extends CommonApp<EXECUTABLE_MODEL,
                         STUDENT_MODEL,
                         CANVAS_MODEL,
                         TEST_CASE,
                         TEST_CASES_MODEL,
                         EXECUTION_TRACE,
                         DASHBOARD_MODEL,
                         SETTINGS_MODEL,
                         BACKEND,
                         ROOT_VIEW,
                         CANVAS_VIEW,
                         DASHBOARD_VIEW,
                         SETTINGS_VIEW,
                         MESSAGES_VIEW,
                         MESSAGE_FRAGMENT,
                         VIEW_DATA,
                         FRONTEND> {
                                                                	 
    protected abstract Class<TEST_CASE_DESCRIPTOR> testCaseDescriptorClass();

    @Override
	protected void additionnalBackendInitialization(BACKEND backend) {
    	backend.setMsgAcceptManualModelClass(msgAcceptManualModelClass());
    }

	protected abstract Class<MSG_ACCEPT_MANUAL_MODEL> msgAcceptManualModelClass();

	@Override
	public void registerModels(ModelRegistrar registrar) {
		super.registerModels(registrar);
		
		registrar.registerValue(testCaseDescriptorClass());
		registrar.registerValue(CommonAttemptDescriptor.class);
	}

	@Override
	public void registerMessages(MessageRegistrar registrar) {
		super.registerMessages(registrar);

		registrar.registerMessage(MsgToggleUseFourCardColors.class);

		registrar.registerMessage(MsgExecutionRewindToFirstStep.class);
		registrar.registerMessage(MsgExecutionStepBack.class);
		registrar.registerMessage(MsgExecutionStepForward.class);
		registrar.registerMessage(MsgExecutionFastForwardToLastStep.class);

		registrar.registerMessage(MsgChangeTestCaseAttempt.class);
		registrar.registerMessage(msgAcceptManualModelClass());

	}

	@Override
	protected Class<? extends EXECUTION_TRACE> executionTraceClass() {
		return (Class<? extends EXECUTION_TRACE>) ProcedureExecutionTraceFull.class;
	}

	
	@Override
	protected void registerAdditionnalMessages(MessageRegistrar registrar) {
	}

	@Override
	protected void registerAdditionnalModels(ModelRegistrar registrar) {
	}

	@Override
	protected Attempt initialAttempt() {
		return Attempt.SOLUTION;
	}

}
