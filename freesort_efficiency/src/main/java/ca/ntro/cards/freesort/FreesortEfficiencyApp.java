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
package ca.ntro.cards.freesort;


import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.cards.freesort.backend.FreesortEfficiencyBackend;
import ca.ntro.cards.freesort.frontend.FreesortEfficiencyFrontend;
import ca.ntro.cards.freesort.frontend.FreesortEfficiencyViewData;
import ca.ntro.cards.freesort.frontend.views.FreesortEfficiencyDashboardView;
import ca.ntro.cards.freesort.frontend.views.FreesortEfficiencyMessagesView;
import ca.ntro.cards.freesort.frontend.views.FreesortEfficiencyRootView;
import ca.ntro.cards.freesort.frontend.views.FreesortEfficiencySettingsView;
import ca.ntro.cards.freesort.frontend.views.FreesortGraphsView;
import ca.ntro.cards.freesort.frontend.views.fragments.FreesortEfficiencyMessageFragment;
import ca.ntro.cards.freesort.models.FreesortEfficiencyDashboardModel;
import ca.ntro.cards.freesort.models.FreesortEfficiencySettingsModel;
import ca.ntro.cards.freesort.models.FreesortGraphsModel;
import ca.ntro.cards.freesort.models.TriLibre;
import ca.ntro.cards.freesort.models.values.FreesortTestCase;
import ca.ntro.cards.freesort.test_cases.FreesortTestCaseDatabase;
import ca.ntro.cards.freesort.test_cases.execution_trace.FreesortExecutionTrace;
import ca.ntro.cards.efficiency.EfficiencyApp;
import ca.ntro.cards.test_cases.execution_trace.ProcedureExecutionTrace;

public abstract class   FreesortEfficiencyApp<STUDENT_MODEL extends TriLibre>

                extends EfficiencyApp<TriLibre, 
                                      STUDENT_MODEL,
                                      FreesortGraphsModel,
                                      FreesortTestCase,
                                      FreesortTestCaseDatabase,
                                      FreesortExecutionTrace,
                                      FreesortEfficiencyDashboardModel,
                                      FreesortEfficiencySettingsModel,
                                      FreesortEfficiencyBackend<STUDENT_MODEL>,
                                      FreesortEfficiencyRootView,
                                      FreesortGraphsView,
                                      FreesortEfficiencyDashboardView,
                                      FreesortEfficiencySettingsView,
                                      FreesortEfficiencyMessagesView,
                                      FreesortEfficiencyMessageFragment,
                                      FreesortEfficiencyViewData,
                                      FreesortEfficiencyFrontend> {

	@Override
	protected FreesortEfficiencyFrontend createFrontend() {
		return new FreesortEfficiencyFrontend();
	}

	@Override
	protected FreesortEfficiencyBackend createBackend() {
		return new FreesortEfficiencyBackend();
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected Class<TriLibre> executableModelClass() {
		return TriLibre.class;
	}

	@Override
	protected Class<STUDENT_MODEL> studentModelClass() {
		return classeTriNaif();
	}
	
	protected abstract Class<STUDENT_MODEL> classeTriNaif();

	@Override
	protected Class<FreesortGraphsModel> canvasModelClass() {
		return FreesortGraphsModel.class;
	}

	@Override
	protected Class<FreesortTestCase> testCaseClass() {
		return FreesortTestCase.class;
	}

	@Override
	protected Class<FreesortTestCaseDatabase> testCasesModelClass() {
		return FreesortTestCaseDatabase.class;
	}

	@Override
	protected Class<FreesortEfficiencyDashboardModel> dashboardModelClass() {
		return FreesortEfficiencyDashboardModel.class;
	}

	@Override
	protected Class<FreesortEfficiencySettingsModel> settingsModelClass() {
		return FreesortEfficiencySettingsModel.class;
	}

	@Override
	protected void registerAdditionnalModels(ModelRegistrar registrar) {
		
	}

	@Override
	protected void registerAdditionnalMessages(MessageRegistrar registrar) {
		
	}

	@Override
	protected String initialTestCaseId() {
		return "ex01";
	}
}
