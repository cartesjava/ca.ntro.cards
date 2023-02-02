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
