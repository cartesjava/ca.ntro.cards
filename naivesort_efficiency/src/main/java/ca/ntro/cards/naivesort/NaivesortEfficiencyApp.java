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
package ca.ntro.cards.naivesort;


import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.cards.naivesort.backend.NaivesortEfficiencyBackend;
import ca.ntro.cards.naivesort.frontend.NaivesortEfficiencyFrontend;
import ca.ntro.cards.naivesort.frontend.NaivesortEfficiencyViewData;
import ca.ntro.cards.naivesort.frontend.views.NaivesortEfficiencyDashboardView;
import ca.ntro.cards.naivesort.frontend.views.NaivesortEfficiencyMessagesView;
import ca.ntro.cards.naivesort.frontend.views.NaivesortEfficiencyRootView;
import ca.ntro.cards.naivesort.frontend.views.NaivesortEfficiencySettingsView;
import ca.ntro.cards.naivesort.frontend.views.NaivesortGraphsView;
import ca.ntro.cards.naivesort.frontend.views.fragments.NaivesortEfficiencyMessageFragment;
import ca.ntro.cards.naivesort.models.NaivesortEfficiencyDashboardModel;
import ca.ntro.cards.naivesort.models.NaivesortEfficiencySettingsModel;
import ca.ntro.cards.naivesort.models.NaivesortGraphsModel;
import ca.ntro.cards.naivesort.models.TriNaif;
import ca.ntro.cards.naivesort.models.values.NaivesortTestCase;
import ca.ntro.cards.naivesort.test_cases.NaivesortTestCaseDatabase;
import ca.ntro.cards.naivesort.test_cases.execution_trace.NaivesortExecutionTrace;
import ca.ntro.cards.efficiency.EfficiencyApp;
import ca.ntro.cards.test_cases.execution_trace.ProcedureExecutionTrace;

public abstract class   NaivesortEfficiencyApp<STUDENT_MODEL extends TriNaif>

                extends EfficiencyApp<TriNaif, 
                                      STUDENT_MODEL,
                                      NaivesortGraphsModel,
                                      NaivesortTestCase,
                                      NaivesortTestCaseDatabase,
                                      NaivesortExecutionTrace,
                                      NaivesortEfficiencyDashboardModel,
                                      NaivesortEfficiencySettingsModel,
                                      NaivesortEfficiencyBackend<STUDENT_MODEL>,
                                      NaivesortEfficiencyRootView,
                                      NaivesortGraphsView,
                                      NaivesortEfficiencyDashboardView,
                                      NaivesortEfficiencySettingsView,
                                      NaivesortEfficiencyMessagesView,
                                      NaivesortEfficiencyMessageFragment,
                                      NaivesortEfficiencyViewData,
                                      NaivesortEfficiencyFrontend> {

	@Override
	protected NaivesortEfficiencyFrontend createFrontend() {
		return new NaivesortEfficiencyFrontend();
	}

	@Override
	protected NaivesortEfficiencyBackend createBackend() {
		return new NaivesortEfficiencyBackend();
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected Class<TriNaif> executableModelClass() {
		return TriNaif.class;
	}

	@Override
	protected Class<STUDENT_MODEL> studentModelClass() {
		return classeTriNaif();
	}
	
	protected abstract Class<STUDENT_MODEL> classeTriNaif();

	@Override
	protected Class<NaivesortGraphsModel> canvasModelClass() {
		return NaivesortGraphsModel.class;
	}

	@Override
	protected Class<NaivesortTestCase> testCaseClass() {
		return NaivesortTestCase.class;
	}

	@Override
	protected Class<NaivesortTestCaseDatabase> testCasesModelClass() {
		return NaivesortTestCaseDatabase.class;
	}

	@Override
	protected Class<NaivesortEfficiencyDashboardModel> dashboardModelClass() {
		return NaivesortEfficiencyDashboardModel.class;
	}

	@Override
	protected Class<NaivesortEfficiencySettingsModel> settingsModelClass() {
		return NaivesortEfficiencySettingsModel.class;
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
