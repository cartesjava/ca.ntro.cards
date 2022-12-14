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
package ca.ntro.cards.freesort.frontend;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.SimpleTaskCreator;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.cards.freesort.frontend.views.FreesortProcedureRootView;
import ca.ntro.cards.freesort.frontend.views.FreesortProcedureSettingsView;
import ca.ntro.cards.freesort.frontend.views.FreesortReplayView;
import ca.ntro.cards.freesort.frontend.views.FreesortVariablesView;
import ca.ntro.cards.freesort.frontend.views.fragments.FreesortProcedureMessageFragment;
import ca.ntro.cards.freesort.frontend.views.fragments.FreesortTestCaseFragment;
import ca.ntro.cards.freesort.models.TriLibre;
import ca.ntro.cards.frontend.ProcedureFrontend;
import ca.ntro.cards.freesort.models.FreesortProcedureDashboardModel;
import ca.ntro.cards.freesort.models.FreesortProcedureSettingsModel;
import ca.ntro.cards.common.messages.MsgMessageToUser;
import ca.ntro.cards.freesort.frontend.views.FreesortCardsView;
import ca.ntro.cards.freesort.frontend.views.FreesortSelectionsView;
import ca.ntro.cards.freesort.frontend.views.FreesortProcedureDashboardView;
import ca.ntro.cards.freesort.frontend.views.FreesortProcedureMessagesView;

public class FreesortProcedureFrontend<STUDENT_MODEL extends TriLibre>

       extends ProcedureFrontend<FreesortProcedureRootView,
                                 FreesortProcedureSettingsView, 
                                 FreesortCardsView, 
                                 FreesortProcedureDashboardView, 
                                 FreesortSelectionsView,
                                 FreesortTestCaseFragment,
                                 FreesortReplayView,
                                 FreesortVariablesView,
                                 FreesortProcedureMessagesView,
                                 FreesortProcedureMessageFragment,
                                 FreesortProcedureViewData, 
                                 STUDENT_MODEL, // CanvasModel
                                 FreesortProcedureDashboardModel, 
                                 FreesortProcedureSettingsModel> {

	@Override
	protected void registerAdditionnalEvents(EventRegistrar registrar) {
		
	}

	@Override
	protected boolean isProd() {
		return false;
	}

	@Override
	protected Class<FreesortProcedureRootView> rootViewClass() {
		return FreesortProcedureRootView.class;
	}

	@Override
	protected Class<FreesortProcedureSettingsView> settingsViewClass() {
		return FreesortProcedureSettingsView.class;
	}

	@Override
	protected Class<FreesortCardsView> canvasViewClass() {
		return FreesortCardsView.class;
	}

	@Override
	protected Class<FreesortProcedureDashboardView> dashboardViewClass() {
		return FreesortProcedureDashboardView.class;
	}

	@Override
	protected void registerAdditionnalViews(ViewRegistrarFx registrar) {
		
	}

	@Override
	protected Class<FreesortProcedureViewData> viewDataClass() {
		return FreesortProcedureViewData.class;
	}

	@Override
	protected void addSubTasksToInitialization(FrontendTasks subTasks) {

	}

	@Override
	protected void addSubTasksToNavigation(FrontendTasks subTasks) {

	}

	@Override
	protected void addSubTasksToSettings(FrontendTasks subTasks) {

	}


	@Override
	protected Class<FreesortSelectionsView> selectionsViewClass() {
		return FreesortSelectionsView.class;
	}

	@Override
	protected Class<FreesortReplayView> replayControlsViewClass() {
		return FreesortReplayView.class;
	}

	@Override
	protected Class<FreesortVariablesView> variablesViewClass() {
		return FreesortVariablesView.class;
	}

	@Override
	protected void addSubTasksToCards(FrontendTasks subTasks) {
	}

	@Override
	protected Class<FreesortTestCaseFragment> testCaseFragmentClass() {
		return FreesortTestCaseFragment.class;
	}

	@Override
	protected Class<FreesortProcedureMessagesView> messagesViewClass() {
		return FreesortProcedureMessagesView.class;
	}

	@Override
	protected Class<FreesortProcedureMessageFragment> messageFragmentClass() {
		return FreesortProcedureMessageFragment.class;
	}

	@Override
	public void execute() {
		super.execute();

		MsgMessageToUser msgMessageToUser = NtroApp.newMessage(MsgMessageToUser.class);
		msgMessageToUser.setResourceKey("welcome");
		msgMessageToUser.send();
	}



}
