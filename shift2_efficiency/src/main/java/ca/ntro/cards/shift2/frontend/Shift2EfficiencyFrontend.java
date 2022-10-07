package ca.ntro.cards.shift2.frontend;

import ca.ntro.cards.shift2.frontend.views.Shift2EfficiencyDashboardView;
import ca.ntro.cards.shift2.frontend.views.Shift2EfficiencyMessagesView;
import ca.ntro.cards.shift2.frontend.views.Shift2EfficiencyRootView;
import ca.ntro.cards.shift2.frontend.views.Shift2EfficiencySettingsView;
import ca.ntro.cards.shift2.frontend.views.Shift2GraphsView;
import ca.ntro.cards.shift2.frontend.views.fragments.Shift2EfficiencyMessageFragment;
import ca.ntro.cards.shift2.models.Shift2EfficiencyDashboardModel;
import ca.ntro.cards.shift2.models.Shift2EfficiencySettingsModel;
import ca.ntro.cards.shift2.models.Shift2GraphsModel;
import ca.ntro.app.NtroApp;
import ca.ntro.cards.common.messages.MsgMessageToUser;
import ca.ntro.cards.efficiency.frontend.EfficiencyFrontend;

public class Shift2EfficiencyFrontend 

       extends EfficiencyFrontend<Shift2EfficiencyRootView,
                                  Shift2EfficiencySettingsView, 
                                  Shift2GraphsView, 
                                  Shift2EfficiencyDashboardView, 
                                  Shift2EfficiencyMessagesView,
                                  Shift2EfficiencyMessageFragment,
                                  Shift2EfficiencyViewData, 
                                  Shift2GraphsModel, 
                                  Shift2EfficiencyDashboardModel, 
                                  Shift2EfficiencySettingsModel> {

	@Override
	protected boolean isProd() {
		return true;
	}

	@Override
	protected Class<Shift2EfficiencyRootView> rootViewClass() {
		return Shift2EfficiencyRootView.class;
	}

	@Override
	protected Class<Shift2EfficiencySettingsView> settingsViewClass() {
		return Shift2EfficiencySettingsView.class;
	}

	@Override
	protected Class<Shift2GraphsView> canvasViewClass() {
		return Shift2GraphsView.class;
	}

	@Override
	protected Class<Shift2EfficiencyDashboardView> dashboardViewClass() {
		return Shift2EfficiencyDashboardView.class;
	}


	@Override
	protected Class<Shift2EfficiencyViewData> viewDataClass() {
		return Shift2EfficiencyViewData.class;
	}


	@Override
	protected Class<Shift2EfficiencyMessagesView> messagesViewClass() {
		return Shift2EfficiencyMessagesView.class;
	}

	@Override
	protected Class<Shift2EfficiencyMessageFragment> messageFragmentClass() {
		return Shift2EfficiencyMessageFragment.class;
	}

	@Override
	public void execute() {
		super.execute();
		
		MsgMessageToUser msgMessageToUser = NtroApp.newMessage(MsgMessageToUser.class);
		msgMessageToUser.setResourceKey("welcome");
		msgMessageToUser.send();
	}

}
