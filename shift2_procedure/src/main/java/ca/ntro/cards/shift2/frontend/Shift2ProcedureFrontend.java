package ca.ntro.cards.shift2.frontend;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.SimpleTaskCreator;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.cards.shift2.frontend.views.Shift2ProcedureRootView;
import ca.ntro.cards.shift2.frontend.views.Shift2ProcedureSettingsView;
import ca.ntro.cards.shift2.frontend.views.Shift2ReplayView;
import ca.ntro.cards.shift2.frontend.views.Shift2VariablesView;
import ca.ntro.cards.shift2.frontend.views.fragments.Shift2ProcedureMessageFragment;
import ca.ntro.cards.shift2.frontend.views.fragments.Shift2TestCaseFragment;
import ca.ntro.cards.shift2.models.Tableau;
import ca.ntro.cards.frontend.ProcedureFrontend;
import ca.ntro.cards.shift2.models.Shift2ProcedureDashboardModel;
import ca.ntro.cards.shift2.models.Shift2ProcedureSettingsModel;
import ca.ntro.cards.common.messages.MsgMessageToUser;
import ca.ntro.cards.shift2.frontend.views.Shift2CardsView;
import ca.ntro.cards.shift2.frontend.views.Shift2ProcedureMessagesView;
import ca.ntro.cards.shift2.frontend.views.Shift2SelectionsView;
import ca.ntro.cards.shift2.frontend.views.Shift2ProcedureDashboardView;

public class Shift2ProcedureFrontend<STUDENT_MODEL extends Tableau>

       extends ProcedureFrontend<Shift2ProcedureRootView,
                                 Shift2ProcedureSettingsView, 
                                 Shift2CardsView, 
                                 Shift2ProcedureDashboardView, 
                                 Shift2SelectionsView,
                                 Shift2TestCaseFragment,
                                 Shift2ReplayView,
                                 Shift2VariablesView,
                                 Shift2ProcedureMessagesView,
                                 Shift2ProcedureMessageFragment,
                                 Shift2ProcedureViewData, 
                                 STUDENT_MODEL, // CanvasModel
                                 Shift2ProcedureDashboardModel, 
                                 Shift2ProcedureSettingsModel> {


	@Override
	protected boolean isProd() {
		return false;
	}

	@Override
	protected Class<Shift2ProcedureRootView> rootViewClass() {
		return Shift2ProcedureRootView.class;
	}

	@Override
	protected Class<Shift2ProcedureSettingsView> settingsViewClass() {
		return Shift2ProcedureSettingsView.class;
	}

	@Override
	protected Class<Shift2CardsView> canvasViewClass() {
		return Shift2CardsView.class;
	}

	@Override
	protected Class<Shift2ProcedureDashboardView> dashboardViewClass() {
		return Shift2ProcedureDashboardView.class;
	}


	@Override
	protected Class<Shift2ProcedureViewData> viewDataClass() {
		return Shift2ProcedureViewData.class;
	}



	@Override
	protected Class<Shift2SelectionsView> selectionsViewClass() {
		return Shift2SelectionsView.class;
	}

	@Override
	protected Class<Shift2ReplayView> replayControlsViewClass() {
		return Shift2ReplayView.class;
	}

	@Override
	protected Class<Shift2VariablesView> variablesViewClass() {
		return Shift2VariablesView.class;
	}


	@Override
	protected Class<Shift2TestCaseFragment> testCaseFragmentClass() {
		return Shift2TestCaseFragment.class;
	}

	@Override
	protected Class<Shift2ProcedureMessagesView> messagesViewClass() {
		return Shift2ProcedureMessagesView.class;
	}

	@Override
	protected Class<Shift2ProcedureMessageFragment> messageFragmentClass() {
		return Shift2ProcedureMessageFragment.class;
	}

	@Override
	public void execute() {
		super.execute();

		MsgMessageToUser msgMessageToUser = NtroApp.newMessage(MsgMessageToUser.class);
		msgMessageToUser.setResourceKey("welcome");
		msgMessageToUser.send();
	}


}
