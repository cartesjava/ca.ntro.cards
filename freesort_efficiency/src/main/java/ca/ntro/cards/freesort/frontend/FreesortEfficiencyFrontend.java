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

import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.SimpleTaskCreator;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.cards.freesort.frontend.views.FreesortEfficiencyDashboardView;
import ca.ntro.cards.freesort.frontend.views.FreesortEfficiencyMessagesView;
import ca.ntro.cards.freesort.frontend.views.FreesortEfficiencyRootView;
import ca.ntro.cards.freesort.frontend.views.FreesortEfficiencySettingsView;
import ca.ntro.cards.freesort.frontend.views.FreesortGraphsView;
import ca.ntro.cards.freesort.frontend.views.fragments.FreesortEfficiencyMessageFragment;
import ca.ntro.cards.freesort.models.FreesortEfficiencyDashboardModel;
import ca.ntro.cards.freesort.models.FreesortEfficiencySettingsModel;
import ca.ntro.cards.freesort.models.FreesortGraphsModel;
import ca.ntro.cards.efficiency.frontend.EfficiencyFrontend;

public class FreesortEfficiencyFrontend 

       extends EfficiencyFrontend<FreesortEfficiencyRootView,
                                  FreesortEfficiencySettingsView, 
                                  FreesortGraphsView, 
                                  FreesortEfficiencyDashboardView, 
                                  FreesortEfficiencyMessagesView,
                                  FreesortEfficiencyMessageFragment,
                                  FreesortEfficiencyViewData, 
                                  FreesortGraphsModel, 
                                  FreesortEfficiencyDashboardModel, 
                                  FreesortEfficiencySettingsModel> {

	@Override
	protected void registerAdditionnalEvents(EventRegistrar registrar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isProd() {
		return true;
	}

	@Override
	protected Class<FreesortEfficiencyRootView> rootViewClass() {
		return FreesortEfficiencyRootView.class;
	}

	@Override
	protected Class<FreesortEfficiencySettingsView> settingsViewClass() {
		return FreesortEfficiencySettingsView.class;
	}

	@Override
	protected Class<FreesortGraphsView> canvasViewClass() {
		return FreesortGraphsView.class;
	}

	@Override
	protected Class<FreesortEfficiencyDashboardView> dashboardViewClass() {
		return FreesortEfficiencyDashboardView.class;
	}

	@Override
	protected void registerAdditionnalViews(ViewRegistrarFx registrar) {
		
	}

	@Override
	protected Class<FreesortEfficiencyViewData> viewDataClass() {
		return FreesortEfficiencyViewData.class;
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
	protected Class<FreesortEfficiencyMessagesView> messagesViewClass() {
		return FreesortEfficiencyMessagesView.class;
	}

	@Override
	protected Class<FreesortEfficiencyMessageFragment> messageFragmentClass() {
		return FreesortEfficiencyMessageFragment.class;
	}



}
