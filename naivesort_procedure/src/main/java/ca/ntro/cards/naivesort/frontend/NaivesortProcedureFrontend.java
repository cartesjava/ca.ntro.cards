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
package ca.ntro.cards.naivesort.frontend;

import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.SimpleTaskCreator;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.cards.naivesort.frontend.views.NaivesortProcedureRootView;
import ca.ntro.cards.naivesort.frontend.views.NaivesortProcedureSettingsView;
import ca.ntro.cards.naivesort.frontend.views.NaivesortReplayView;
import ca.ntro.cards.naivesort.frontend.views.NaivesortVariablesView;
import ca.ntro.cards.naivesort.frontend.views.fragments.NaivesortProcedureMessageFragment;
import ca.ntro.cards.naivesort.frontend.views.fragments.NaivesortTestCaseFragment;
import ca.ntro.cards.naivesort.models.TriNaif;
import ca.ntro.cards.frontend.ProcedureFrontend;
import ca.ntro.cards.naivesort.models.NaivesortProcedureDashboardModel;
import ca.ntro.cards.naivesort.models.NaivesortProcedureSettingsModel;
import ca.ntro.cards.naivesort.frontend.views.NaivesortCardsView;
import ca.ntro.cards.naivesort.frontend.views.NaivesortSelectionsView;
import ca.ntro.cards.naivesort.frontend.views.NaivesortProcedureDashboardView;
import ca.ntro.cards.naivesort.frontend.views.NaivesortProcedureMessagesView;

public class NaivesortProcedureFrontend<STUDENT_MODEL extends TriNaif>

       extends ProcedureFrontend<NaivesortProcedureRootView,
                                 NaivesortProcedureSettingsView, 
                                 NaivesortCardsView, 
                                 NaivesortProcedureDashboardView, 
                                 NaivesortSelectionsView,
                                 NaivesortTestCaseFragment,
                                 NaivesortReplayView,
                                 NaivesortVariablesView,
                                 NaivesortProcedureMessagesView,
                                 NaivesortProcedureMessageFragment,
                                 NaivesortProcedureViewData, 
                                 STUDENT_MODEL, // CanvasModel
                                 NaivesortProcedureDashboardModel, 
                                 NaivesortProcedureSettingsModel> {

	@Override
	protected void registerAdditionnalEvents(EventRegistrar registrar) {
		
	}

	@Override
	protected boolean isProd() {
		return false;
	}

	@Override
	protected Class<NaivesortProcedureRootView> rootViewClass() {
		return NaivesortProcedureRootView.class;
	}

	@Override
	protected Class<NaivesortProcedureSettingsView> settingsViewClass() {
		return NaivesortProcedureSettingsView.class;
	}

	@Override
	protected Class<NaivesortCardsView> canvasViewClass() {
		return NaivesortCardsView.class;
	}

	@Override
	protected Class<NaivesortProcedureDashboardView> dashboardViewClass() {
		return NaivesortProcedureDashboardView.class;
	}

	@Override
	protected void registerAdditionnalViews(ViewRegistrarFx registrar) {
		
	}

	@Override
	protected Class<NaivesortProcedureViewData> viewDataClass() {
		return NaivesortProcedureViewData.class;
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
	protected Class<NaivesortSelectionsView> selectionsViewClass() {
		return NaivesortSelectionsView.class;
	}

	@Override
	protected Class<NaivesortReplayView> replayControlsViewClass() {
		return NaivesortReplayView.class;
	}

	@Override
	protected Class<NaivesortVariablesView> variablesViewClass() {
		return NaivesortVariablesView.class;
	}

	@Override
	protected void addSubTasksToCards(FrontendTasks subTasks) {
	}

	@Override
	protected Class<NaivesortTestCaseFragment> testCaseFragmentClass() {
		return NaivesortTestCaseFragment.class;
	}

	@Override
	protected Class<NaivesortProcedureMessagesView> messagesViewClass() {
		return NaivesortProcedureMessagesView.class;
	}

	@Override
	protected Class<NaivesortProcedureMessageFragment> messageFragmentClass() {
		return NaivesortProcedureMessageFragment.class;
	}


}
