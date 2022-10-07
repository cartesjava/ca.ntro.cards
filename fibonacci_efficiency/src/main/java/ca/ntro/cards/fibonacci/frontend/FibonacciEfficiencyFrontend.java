package ca.ntro.cards.fibonacci.frontend;

import ca.ntro.cards.fibonacci.frontend.views.FibonacciEfficiencyDashboardView;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciEfficiencyMessagesView;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciEfficiencyRootView;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciEfficiencySettingsView;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciGraphsView;
import ca.ntro.cards.fibonacci.frontend.views.fragments.FibonacciEfficiencyMessageFragment;
import ca.ntro.cards.fibonacci.models.FibonacciEfficiencyDashboardModel;
import ca.ntro.cards.fibonacci.models.FibonacciEfficiencySettingsModel;
import ca.ntro.cards.fibonacci.models.FibonacciGraphsModel;
import ca.ntro.app.NtroApp;
import ca.ntro.cards.common.messages.MsgMessageToUser;
import ca.ntro.cards.efficiency.frontend.EfficiencyFrontend;

public class FibonacciEfficiencyFrontend 

       extends EfficiencyFrontend<FibonacciEfficiencyRootView,
                                  FibonacciEfficiencySettingsView, 
                                  FibonacciGraphsView, 
                                  FibonacciEfficiencyDashboardView, 
                                  FibonacciEfficiencyMessagesView,
                                  FibonacciEfficiencyMessageFragment,
                                  FibonacciEfficiencyViewData, 
                                  FibonacciGraphsModel, 
                                  FibonacciEfficiencyDashboardModel, 
                                  FibonacciEfficiencySettingsModel> {

	@Override
	protected boolean isProd() {
		return true;
	}

	@Override
	protected Class<FibonacciEfficiencyRootView> rootViewClass() {
		return FibonacciEfficiencyRootView.class;
	}

	@Override
	protected Class<FibonacciEfficiencySettingsView> settingsViewClass() {
		return FibonacciEfficiencySettingsView.class;
	}

	@Override
	protected Class<FibonacciGraphsView> canvasViewClass() {
		return FibonacciGraphsView.class;
	}

	@Override
	protected Class<FibonacciEfficiencyDashboardView> dashboardViewClass() {
		return FibonacciEfficiencyDashboardView.class;
	}


	@Override
	protected Class<FibonacciEfficiencyViewData> viewDataClass() {
		return FibonacciEfficiencyViewData.class;
	}


	@Override
	protected Class<FibonacciEfficiencyMessagesView> messagesViewClass() {
		return FibonacciEfficiencyMessagesView.class;
	}

	@Override
	protected Class<FibonacciEfficiencyMessageFragment> messageFragmentClass() {
		return FibonacciEfficiencyMessageFragment.class;
	}

	@Override
	public void execute() {
		super.execute();
		
		MsgMessageToUser msgMessageToUser = NtroApp.newMessage(MsgMessageToUser.class);
		msgMessageToUser.setResourceKey("welcome");
		msgMessageToUser.send();
	}

}
