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
package ca.ntro.cards.foo.frontend;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.SimpleTaskCreator;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.cards.foo.frontend.views.FooProcedureRootView;
import ca.ntro.cards.foo.frontend.views.FooProcedureSettingsView;
import ca.ntro.cards.foo.frontend.views.FooReplayView;
import ca.ntro.cards.foo.frontend.views.FooVariablesView;
import ca.ntro.cards.foo.frontend.views.fragments.FooProcedureMessageFragment;
import ca.ntro.cards.foo.frontend.views.fragments.FooTestCaseFragment;
import ca.ntro.cards.foo.models.FooCardsModel;
import ca.ntro.cards.frontend.ProcedureFrontend;
import ca.ntro.cards.foo.models.FooProcedureDashboardModel;
import ca.ntro.cards.foo.models.FooProcedureSettingsModel;
import ca.ntro.cards.common.messages.MsgMessageToUser;
import ca.ntro.cards.foo.frontend.views.FooCardsView;
import ca.ntro.cards.foo.frontend.views.FooProcedureMessagesView;
import ca.ntro.cards.foo.frontend.views.FooSelectionsView;
import ca.ntro.cards.foo.frontend.views.FooProcedureDashboardView;

public class FooProcedureFrontend<STUDENT_MODEL extends FooCardsModel>

       extends ProcedureFrontend<FooProcedureRootView,
                                 FooProcedureSettingsView, 
                                 FooCardsView, 
                                 FooProcedureDashboardView, 
                                 FooSelectionsView,
                                 FooTestCaseFragment,
                                 FooReplayView,
                                 FooVariablesView,
                                 FooProcedureMessagesView,
                                 FooProcedureMessageFragment,
                                 FooProcedureViewData, 
                                 STUDENT_MODEL, // CanvasModel
                                 FooProcedureDashboardModel, 
                                 FooProcedureSettingsModel> {


	@Override
	protected boolean isProd() {
		return false;
	}

	@Override
	protected Class<FooProcedureRootView> rootViewClass() {
		return FooProcedureRootView.class;
	}

	@Override
	protected Class<FooProcedureSettingsView> settingsViewClass() {
		return FooProcedureSettingsView.class;
	}

	@Override
	protected Class<FooCardsView> canvasViewClass() {
		return FooCardsView.class;
	}

	@Override
	protected Class<FooProcedureDashboardView> dashboardViewClass() {
		return FooProcedureDashboardView.class;
	}


	@Override
	protected Class<FooProcedureViewData> viewDataClass() {
		return FooProcedureViewData.class;
	}



	@Override
	protected Class<FooSelectionsView> selectionsViewClass() {
		return FooSelectionsView.class;
	}

	@Override
	protected Class<FooReplayView> replayControlsViewClass() {
		return FooReplayView.class;
	}

	@Override
	protected Class<FooVariablesView> variablesViewClass() {
		return FooVariablesView.class;
	}


	@Override
	protected Class<FooTestCaseFragment> testCaseFragmentClass() {
		return FooTestCaseFragment.class;
	}

	@Override
	protected Class<FooProcedureMessagesView> messagesViewClass() {
		return FooProcedureMessagesView.class;
	}

	@Override
	protected Class<FooProcedureMessageFragment> messageFragmentClass() {
		return FooProcedureMessageFragment.class;
	}

	@Override
	public void execute() {
		super.execute();

		MsgMessageToUser msgMessageToUser = NtroApp.newMessage(MsgMessageToUser.class);
		msgMessageToUser.setResourceKey("welcome");
		msgMessageToUser.send();
	}


}
