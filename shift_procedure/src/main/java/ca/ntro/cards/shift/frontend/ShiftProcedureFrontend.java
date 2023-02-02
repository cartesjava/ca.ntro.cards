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

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.SimpleTaskCreator;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.cards.shift.frontend.views.ShiftProcedureRootView;
import ca.ntro.cards.shift.frontend.views.ShiftProcedureSettingsView;
import ca.ntro.cards.shift.frontend.views.ShiftReplayView;
import ca.ntro.cards.shift.frontend.views.ShiftVariablesView;
import ca.ntro.cards.shift.frontend.views.fragments.ShiftProcedureMessageFragment;
import ca.ntro.cards.shift.frontend.views.fragments.ShiftTestCaseFragment;
import ca.ntro.cards.shift.models.Tableau;
import ca.ntro.cards.frontend.ProcedureFrontend;
import ca.ntro.cards.shift.models.ShiftProcedureDashboardModel;
import ca.ntro.cards.shift.models.ShiftProcedureSettingsModel;
import ca.ntro.cards.common.messages.MsgMessageToUser;
import ca.ntro.cards.shift.frontend.views.ShiftCardsView;
import ca.ntro.cards.shift.frontend.views.ShiftProcedureMessagesView;
import ca.ntro.cards.shift.frontend.views.ShiftSelectionsView;
import ca.ntro.cards.shift.frontend.views.ShiftProcedureDashboardView;

public class ShiftProcedureFrontend<STUDENT_MODEL extends Tableau>

       extends ProcedureFrontend<ShiftProcedureRootView,
                                 ShiftProcedureSettingsView, 
                                 ShiftCardsView, 
                                 ShiftProcedureDashboardView, 
                                 ShiftSelectionsView,
                                 ShiftTestCaseFragment,
                                 ShiftReplayView,
                                 ShiftVariablesView,
                                 ShiftProcedureMessagesView,
                                 ShiftProcedureMessageFragment,
                                 ShiftProcedureViewData, 
                                 STUDENT_MODEL, // CanvasModel
                                 ShiftProcedureDashboardModel, 
                                 ShiftProcedureSettingsModel> {


	@Override
	protected boolean isProd() {
		return false;
	}

	@Override
	protected Class<ShiftProcedureRootView> rootViewClass() {
		return ShiftProcedureRootView.class;
	}

	@Override
	protected Class<ShiftProcedureSettingsView> settingsViewClass() {
		return ShiftProcedureSettingsView.class;
	}

	@Override
	protected Class<ShiftCardsView> canvasViewClass() {
		return ShiftCardsView.class;
	}

	@Override
	protected Class<ShiftProcedureDashboardView> dashboardViewClass() {
		return ShiftProcedureDashboardView.class;
	}


	@Override
	protected Class<ShiftProcedureViewData> viewDataClass() {
		return ShiftProcedureViewData.class;
	}



	@Override
	protected Class<ShiftSelectionsView> selectionsViewClass() {
		return ShiftSelectionsView.class;
	}

	@Override
	protected Class<ShiftReplayView> replayControlsViewClass() {
		return ShiftReplayView.class;
	}

	@Override
	protected Class<ShiftVariablesView> variablesViewClass() {
		return ShiftVariablesView.class;
	}


	@Override
	protected Class<ShiftTestCaseFragment> testCaseFragmentClass() {
		return ShiftTestCaseFragment.class;
	}

	@Override
	protected Class<ShiftProcedureMessagesView> messagesViewClass() {
		return ShiftProcedureMessagesView.class;
	}

	@Override
	protected Class<ShiftProcedureMessageFragment> messageFragmentClass() {
		return ShiftProcedureMessageFragment.class;
	}

	@Override
	public void execute() {
		super.execute();

		MsgMessageToUser msgMessageToUser = NtroApp.newMessage(MsgMessageToUser.class);
		msgMessageToUser.setResourceKey("welcome");
		msgMessageToUser.send();
	}


}
