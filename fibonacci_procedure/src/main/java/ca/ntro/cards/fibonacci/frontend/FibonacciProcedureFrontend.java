package ca.ntro.cards.fibonacci.frontend;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.SimpleTaskCreator;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciProcedureRootView;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciProcedureSettingsView;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciReplayView;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciVariablesView;
import ca.ntro.cards.fibonacci.frontend.views.fragments.FibonacciProcedureMessageFragment;
import ca.ntro.cards.fibonacci.frontend.views.fragments.FibonacciTestCaseFragment;
import ca.ntro.cards.fibonacci.models.Calculateur;
import ca.ntro.cards.frontend.ProcedureFrontend;
import ca.ntro.cards.fibonacci.models.FibonacciProcedureDashboardModel;
import ca.ntro.cards.fibonacci.models.FibonacciProcedureSettingsModel;
import ca.ntro.cards.common.messages.MsgMessageToUser;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciCardsView;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciProcedureMessagesView;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciSelectionsView;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciProcedureDashboardView;

public class FibonacciProcedureFrontend<STUDENT_MODEL extends Calculateur>

       extends ProcedureFrontend<FibonacciProcedureRootView,
                                 FibonacciProcedureSettingsView, 
                                 FibonacciCardsView, 
                                 FibonacciProcedureDashboardView, 
                                 FibonacciSelectionsView,
                                 FibonacciTestCaseFragment,
                                 FibonacciReplayView,
                                 FibonacciVariablesView,
                                 FibonacciProcedureMessagesView,
                                 FibonacciProcedureMessageFragment,
                                 FibonacciProcedureViewData, 
                                 STUDENT_MODEL, // CanvasModel
                                 FibonacciProcedureDashboardModel, 
                                 FibonacciProcedureSettingsModel> {


	@Override
	protected boolean isProd() {
		return false;
	}

	@Override
	protected Class<FibonacciProcedureRootView> rootViewClass() {
		return FibonacciProcedureRootView.class;
	}

	@Override
	protected Class<FibonacciProcedureSettingsView> settingsViewClass() {
		return FibonacciProcedureSettingsView.class;
	}

	@Override
	protected Class<FibonacciCardsView> canvasViewClass() {
		return FibonacciCardsView.class;
	}

	@Override
	protected Class<FibonacciProcedureDashboardView> dashboardViewClass() {
		return FibonacciProcedureDashboardView.class;
	}


	@Override
	protected Class<FibonacciProcedureViewData> viewDataClass() {
		return FibonacciProcedureViewData.class;
	}



	@Override
	protected Class<FibonacciSelectionsView> selectionsViewClass() {
		return FibonacciSelectionsView.class;
	}

	@Override
	protected Class<FibonacciReplayView> replayControlsViewClass() {
		return FibonacciReplayView.class;
	}

	@Override
	protected Class<FibonacciVariablesView> variablesViewClass() {
		return FibonacciVariablesView.class;
	}


	@Override
	protected Class<FibonacciTestCaseFragment> testCaseFragmentClass() {
		return FibonacciTestCaseFragment.class;
	}

	@Override
	protected Class<FibonacciProcedureMessagesView> messagesViewClass() {
		return FibonacciProcedureMessagesView.class;
	}

	@Override
	protected Class<FibonacciProcedureMessageFragment> messageFragmentClass() {
		return FibonacciProcedureMessageFragment.class;
	}

	@Override
	public void execute() {
		super.execute();

		MsgMessageToUser msgMessageToUser = NtroApp.newMessage(MsgMessageToUser.class);
		msgMessageToUser.setResourceKey("welcome");
		msgMessageToUser.send();
	}


}
