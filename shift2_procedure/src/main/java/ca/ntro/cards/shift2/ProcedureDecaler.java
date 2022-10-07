package ca.ntro.cards.shift2;

import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.cards.ProcedureApp;
import ca.ntro.cards.shift2.backend.Shift2ProcedureBackend;
import ca.ntro.cards.shift2.frontend.Shift2ProcedureFrontend;
import ca.ntro.cards.shift2.frontend.Shift2ProcedureViewData;
import ca.ntro.cards.shift2.frontend.views.Shift2CardsView;
import ca.ntro.cards.shift2.frontend.views.Shift2ProcedureMessagesView;
import ca.ntro.cards.shift2.frontend.views.Shift2ProcedureDashboardView;
import ca.ntro.cards.shift2.frontend.views.Shift2ProcedureRootView;
import ca.ntro.cards.shift2.frontend.views.Shift2ProcedureSettingsView;
import ca.ntro.cards.shift2.frontend.views.fragments.Shift2ProcedureMessageFragment;
import ca.ntro.cards.shift2.messages.Shift2MsgAcceptManualModel;
import ca.ntro.cards.shift2.models.Tableau;
import ca.ntro.cards.shift2.models.values.CarteIncomplete;
import ca.ntro.cards.shift2.models.values.Shift2TestCase;
import ca.ntro.cards.shift2.test_cases.Shift2TestCaseDatabase;
import ca.ntro.cards.shift2.test_cases.descriptor.Shift2TestCaseDescriptor;
import ca.ntro.cards.shift2.test_cases.execution_trace.Shift2ExecutionTrace;
import ca.ntro.cards.messages.ProcedureMsgAcceptManualModel;
import ca.ntro.cards.test_cases.descriptor.ProcedureTestCaseDescriptor;
import ca.ntro.cards.shift2.models.Shift2ProcedureDashboardModel;
import ca.ntro.cards.shift2.models.Shift2ProcedureSettingsModel;

public abstract class   ProcedureDecaler<STUDENT_MODEL extends Tableau, 
                                         STUDENT_CARD extends CarteIncomplete>

                extends ProcedureApp<Tableau,           // executable model
                                     STUDENT_MODEL,
                                     STUDENT_MODEL,     // canvas model
                                     Shift2TestCase,
                                     Shift2TestCaseDescriptor,
                                     Shift2TestCaseDatabase,
                                     Shift2ExecutionTrace,
                                     Shift2ProcedureDashboardModel,
                                     Shift2ProcedureSettingsModel,
                                     Shift2MsgAcceptManualModel,
                                     Shift2ProcedureBackend<STUDENT_MODEL>,
                                     Shift2ProcedureRootView,
                                     Shift2CardsView,
                                     Shift2ProcedureDashboardView,
                                     Shift2ProcedureSettingsView,
                                     Shift2ProcedureMessagesView,
                                     Shift2ProcedureMessageFragment,
                                     Shift2ProcedureViewData,
                                     Shift2ProcedureFrontend<STUDENT_MODEL>> {

                                    	   
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

	protected abstract Class<STUDENT_CARD> classeMaCarte();

	@Override
	protected Class<Shift2TestCase> testCaseClass() {
		return Shift2TestCase.class;
	}

	@Override
	protected Class<Shift2TestCaseDatabase> testCasesModelClass() {
		return Shift2TestCaseDatabase.class;
	}


	@Override
	protected Class<Shift2ProcedureDashboardModel> dashboardModelClass() {
		return Shift2ProcedureDashboardModel.class;
	}


	@Override
	protected Class<Shift2ProcedureSettingsModel> settingsModelClass() {
		return Shift2ProcedureSettingsModel.class;
	}

	@Override
	protected Shift2ProcedureFrontend createFrontend() {
		return new Shift2ProcedureFrontend();
	}


	@Override
	protected Shift2ProcedureBackend createBackend() {
		return new Shift2ProcedureBackend();
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
	protected Class<Shift2TestCaseDescriptor> testCaseDescriptorClass() {
		return Shift2TestCaseDescriptor.class;
	}

	@Override
	protected Class<Shift2MsgAcceptManualModel> msgAcceptManualModelClass() {
		return Shift2MsgAcceptManualModel.class;
	}

	@Override
	protected String initialTestCaseId() {
		return "ex01";
	}

	@Override
	protected void registerAdditionnalModels(ModelRegistrar registrar) {
		super.registerAdditionnalModels(registrar);
		
		registrar.registerValue(classeMaCarte());
	}

}
