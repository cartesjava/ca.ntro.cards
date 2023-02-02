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
