package ca.ntro.cards.shift.frontend;

import ca.ntro.cards.shift.frontend.views.ShiftEfficiencyDashboardView;
import ca.ntro.cards.shift.frontend.views.ShiftEfficiencyMessagesView;
import ca.ntro.cards.shift.frontend.views.ShiftEfficiencyRootView;
import ca.ntro.cards.shift.frontend.views.ShiftEfficiencySettingsView;
import ca.ntro.cards.shift.frontend.views.ShiftGraphsView;
import ca.ntro.cards.shift.frontend.views.fragments.ShiftEfficiencyMessageFragment;
import ca.ntro.cards.shift.models.ShiftEfficiencyDashboardModel;
import ca.ntro.cards.shift.models.ShiftEfficiencySettingsModel;
import ca.ntro.cards.shift.models.ShiftGraphsModel;
import ca.ntro.app.NtroApp;
import ca.ntro.cards.common.messages.MsgMessageToUser;
import ca.ntro.cards.efficiency.frontend.EfficiencyFrontend;

public class ShiftEfficiencyFrontend 

       extends EfficiencyFrontend<ShiftEfficiencyRootView,
                                  ShiftEfficiencySettingsView, 
                                  ShiftGraphsView, 
                                  ShiftEfficiencyDashboardView, 
                                  ShiftEfficiencyMessagesView,
                                  ShiftEfficiencyMessageFragment,
                                  ShiftEfficiencyViewData, 
                                  ShiftGraphsModel, 
                                  ShiftEfficiencyDashboardModel, 
                                  ShiftEfficiencySettingsModel> {

	@Override
	protected boolean isProd() {
		return true;
	}

	@Override
	protected Class<ShiftEfficiencyRootView> rootViewClass() {
		return ShiftEfficiencyRootView.class;
	}

	@Override
	protected Class<ShiftEfficiencySettingsView> settingsViewClass() {
		return ShiftEfficiencySettingsView.class;
	}

	@Override
	protected Class<ShiftGraphsView> canvasViewClass() {
		return ShiftGraphsView.class;
	}

	@Override
	protected Class<ShiftEfficiencyDashboardView> dashboardViewClass() {
		return ShiftEfficiencyDashboardView.class;
	}


	@Override
	protected Class<ShiftEfficiencyViewData> viewDataClass() {
		return ShiftEfficiencyViewData.class;
	}


	@Override
	protected Class<ShiftEfficiencyMessagesView> messagesViewClass() {
		return ShiftEfficiencyMessagesView.class;
	}

	@Override
	protected Class<ShiftEfficiencyMessageFragment> messageFragmentClass() {
		return ShiftEfficiencyMessageFragment.class;
	}

	@Override
	public void execute() {
		super.execute();
		
		MsgMessageToUser msgMessageToUser = NtroApp.newMessage(MsgMessageToUser.class);
		msgMessageToUser.setResourceKey("welcome");
		msgMessageToUser.send();
	}

}
