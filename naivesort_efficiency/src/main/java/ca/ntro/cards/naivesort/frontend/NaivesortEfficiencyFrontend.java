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
import ca.ntro.cards.naivesort.frontend.views.NaivesortEfficiencyDashboardView;
import ca.ntro.cards.naivesort.frontend.views.NaivesortEfficiencyMessagesView;
import ca.ntro.cards.naivesort.frontend.views.NaivesortEfficiencyRootView;
import ca.ntro.cards.naivesort.frontend.views.NaivesortEfficiencySettingsView;
import ca.ntro.cards.naivesort.frontend.views.NaivesortGraphsView;
import ca.ntro.cards.naivesort.frontend.views.controls.NaivesortEfficiencyMainCanvas;
import ca.ntro.cards.naivesort.frontend.views.fragments.NaivesortEfficiencyMessageFragment;
import ca.ntro.cards.naivesort.models.NaivesortEfficiencyDashboardModel;
import ca.ntro.cards.naivesort.models.NaivesortEfficiencySettingsModel;
import ca.ntro.cards.naivesort.models.NaivesortGraphsModel;
import ca.ntro.cards.efficiency.frontend.EfficiencyFrontend;

public class NaivesortEfficiencyFrontend 

       extends EfficiencyFrontend<NaivesortEfficiencyRootView,
                                  NaivesortEfficiencySettingsView, 
                                  NaivesortGraphsView, 
                                  NaivesortEfficiencyDashboardView, 
                                  NaivesortEfficiencyMessagesView,
                                  NaivesortEfficiencyMessageFragment,
                                  NaivesortEfficiencyViewData, 
                                  NaivesortGraphsModel, 
                                  NaivesortEfficiencyDashboardModel, 
                                  NaivesortEfficiencySettingsModel> {

	@Override
	protected void registerAdditionnalEvents(EventRegistrar registrar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isProd() {
		return true;
	}

	@Override
	protected Class<NaivesortEfficiencyRootView> rootViewClass() {
		return NaivesortEfficiencyRootView.class;
	}

	@Override
	protected Class<NaivesortEfficiencySettingsView> settingsViewClass() {
		return NaivesortEfficiencySettingsView.class;
	}

	@Override
	protected Class<NaivesortGraphsView> canvasViewClass() {
		return NaivesortGraphsView.class;
	}

	@Override
	protected Class<NaivesortEfficiencyDashboardView> dashboardViewClass() {
		return NaivesortEfficiencyDashboardView.class;
	}

	@Override
	protected void registerAdditionnalViews(ViewRegistrarFx registrar) {
		
	}

	@Override
	protected Class<NaivesortEfficiencyViewData> viewDataClass() {
		return NaivesortEfficiencyViewData.class;
	}

	@Override
	protected void addSubTasksToInitialization(FrontendTasks subTasks) {
		
	}

	@Override
	protected void addSubTasksToViewData(FrontendTasks subTasks) {
		
	}


	@Override
	protected void addSubTasksToNavigation(FrontendTasks subTasks) {
		
	}

	@Override
	protected void addSubTasksToSettings(FrontendTasks subTasks) {
		
	}

	@Override
	protected void addSubTasksToDashboard(FrontendTasks subTasks) {
		
	}

	@Override
	protected void createAdditionnalTasks(FrontendTasks tasks) {
		
	}

	@Override
	protected Class<NaivesortEfficiencyMessagesView> messagesViewClass() {
		return NaivesortEfficiencyMessagesView.class;
	}

	@Override
	protected Class<NaivesortEfficiencyMessageFragment> messageFragmentClass() {
		return NaivesortEfficiencyMessageFragment.class;
	}



}
