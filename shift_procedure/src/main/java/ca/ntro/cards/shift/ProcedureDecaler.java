package ca.ntro.cards.shift;

import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.cards.ProcedureApp;
import ca.ntro.cards.shift.backend.ShiftProcedureBackend;
import ca.ntro.cards.shift.frontend.ShiftProcedureFrontend;
import ca.ntro.cards.shift.frontend.ShiftProcedureViewData;
import ca.ntro.cards.shift.frontend.views.ShiftCardsView;
import ca.ntro.cards.shift.frontend.views.ShiftProcedureMessagesView;
import ca.ntro.cards.shift.frontend.views.ShiftProcedureDashboardView;
import ca.ntro.cards.shift.frontend.views.ShiftProcedureRootView;
import ca.ntro.cards.shift.frontend.views.ShiftProcedureSettingsView;
import ca.ntro.cards.shift.frontend.views.fragments.ShiftProcedureMessageFragment;
import ca.ntro.cards.shift.messages.ShiftMsgAcceptManualModel;
import ca.ntro.cards.shift.models.Tableau;
import ca.ntro.cards.shift.models.values.ShiftTestCase;
import ca.ntro.cards.shift.test_cases.ShiftTestCaseDatabase;
import ca.ntro.cards.shift.test_cases.descriptor.ShiftTestCaseDescriptor;
import ca.ntro.cards.shift.test_cases.execution_trace.ShiftExecutionTrace;
import ca.ntro.cards.messages.ProcedureMsgAcceptManualModel;
import ca.ntro.cards.test_cases.descriptor.ProcedureTestCaseDescriptor;
import ca.ntro.cards.shift.models.ShiftProcedureDashboardModel;
import ca.ntro.cards.shift.models.ShiftProcedureSettingsModel;

public abstract class   ProcedureDecaler<STUDENT_MODEL extends Tableau>

                extends ProcedureApp<Tableau,           // executable model
                                     STUDENT_MODEL,
                                     STUDENT_MODEL,     // canvas model
                                     ShiftTestCase,
                                     ShiftTestCaseDescriptor,
                                     ShiftTestCaseDatabase,
                                     ShiftExecutionTrace,
                                     ShiftProcedureDashboardModel,
                                     ShiftProcedureSettingsModel,
                                     ShiftMsgAcceptManualModel,
                                     ShiftProcedureBackend<STUDENT_MODEL>,
                                     ShiftProcedureRootView,
                                     ShiftCardsView,
                                     ShiftProcedureDashboardView,
                                     ShiftProcedureSettingsView,
                                     ShiftProcedureMessagesView,
                                     ShiftProcedureMessageFragment,
                                     ShiftProcedureViewData,
                                     ShiftProcedureFrontend<STUDENT_MODEL>> {

                                    	   
    private String[] args;

	@Override
	public void registerArgs(String[] args) {
		this.args = args;
	}
	
	@Override
	protected Class<Tableau> executableModelClass() {
		return Tableau.class;
	}

	protected abstract Class<STUDENT_MODEL> classeMonTableau();

	@Override
	protected Class<ShiftTestCase> testCaseClass() {
		return ShiftTestCase.class;
	}

	@Override
	protected Class<ShiftTestCaseDatabase> testCasesModelClass() {
		return ShiftTestCaseDatabase.class;
	}


	@Override
	protected Class<ShiftProcedureDashboardModel> dashboardModelClass() {
		return ShiftProcedureDashboardModel.class;
	}


	@Override
	protected Class<ShiftProcedureSettingsModel> settingsModelClass() {
		return ShiftProcedureSettingsModel.class;
	}

	@Override
	protected ShiftProcedureFrontend createFrontend() {
		return new ShiftProcedureFrontend();
	}


	@Override
	protected ShiftProcedureBackend createBackend() {
		return new ShiftProcedureBackend();
	}




	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected Class<STUDENT_MODEL> canvasModelClass() {
		return (Class<STUDENT_MODEL>) classeMonTableau();
	}

	@Override
	protected Class<STUDENT_MODEL> studentModelClass() {
		return classeMonTableau();
	}

	@Override
	protected Class<ShiftTestCaseDescriptor> testCaseDescriptorClass() {
		return ShiftTestCaseDescriptor.class;
	}

	@Override
	protected Class<ShiftMsgAcceptManualModel> msgAcceptManualModelClass() {
		return ShiftMsgAcceptManualModel.class;
	}

	@Override
	protected String initialTestCaseId() {
		return "ex01";
	}

}
