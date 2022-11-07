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
package ca.ntro.cards.shift;

import ca.ntro.cards.shift.backend.ShiftEfficiencyBackend;
import ca.ntro.cards.shift.frontend.ShiftEfficiencyFrontend;
import ca.ntro.cards.shift.frontend.ShiftEfficiencyViewData;
import ca.ntro.cards.shift.frontend.views.ShiftEfficiencyDashboardView;
import ca.ntro.cards.shift.frontend.views.ShiftEfficiencyMessagesView;
import ca.ntro.cards.shift.frontend.views.ShiftEfficiencyRootView;
import ca.ntro.cards.shift.frontend.views.ShiftEfficiencySettingsView;
import ca.ntro.cards.shift.frontend.views.ShiftGraphsView;
import ca.ntro.cards.shift.frontend.views.fragments.ShiftEfficiencyMessageFragment;
import ca.ntro.cards.shift.models.ShiftEfficiencyDashboardModel;
import ca.ntro.cards.shift.models.ShiftEfficiencySettingsModel;
import ca.ntro.cards.shift.models.ShiftGraphsModel;
import ca.ntro.cards.shift.models.Tableau;
import ca.ntro.cards.shift.models.values.ShiftTestCase;
import ca.ntro.cards.shift.test_cases.ShiftTestCaseDatabase;
import ca.ntro.cards.shift.test_cases.execution_trace.ShiftExecutionTrace;
import ca.ntro.cards.common.models.enums.Attempt;
import ca.ntro.cards.efficiency.EfficiencyApp;

public abstract class   ShiftEfficiencyApp<STUDENT_MODEL extends Tableau>

                extends EfficiencyApp<Tableau, 
                                      STUDENT_MODEL,
                                      ShiftGraphsModel,
                                      ShiftTestCase,
                                      ShiftTestCaseDatabase,
                                      ShiftExecutionTrace,
                                      ShiftEfficiencyDashboardModel,
                                      ShiftEfficiencySettingsModel,
                                      ShiftEfficiencyBackend<STUDENT_MODEL>,
                                      ShiftEfficiencyRootView,
                                      ShiftGraphsView,
                                      ShiftEfficiencyDashboardView,
                                      ShiftEfficiencySettingsView,
                                      ShiftEfficiencyMessagesView,
                                      ShiftEfficiencyMessageFragment,
                                      ShiftEfficiencyViewData,
                                      ShiftEfficiencyFrontend> {

	@Override
	protected ShiftEfficiencyFrontend createFrontend() {
		return new ShiftEfficiencyFrontend();
	}

	@Override
	protected ShiftEfficiencyBackend createBackend() {
		return new ShiftEfficiencyBackend();
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected Class<Tableau> executableModelClass() {
		return Tableau.class;
	}

	@Override
	protected Class<STUDENT_MODEL> studentModelClass() {
		return studentClass();
	}
	
	// TODO: renommer
	protected abstract Class<STUDENT_MODEL> studentClass();

	@Override
	protected Class<ShiftGraphsModel> canvasModelClass() {
		return ShiftGraphsModel.class;
	}

	@Override
	protected Class<ShiftTestCase> testCaseClass() {
		return ShiftTestCase.class;
	}

	@Override
	protected Class<ShiftTestCaseDatabase> testCasesModelClass() {
		return ShiftTestCaseDatabase.class;
	}

	@Override
	protected Class<ShiftEfficiencyDashboardModel> dashboardModelClass() {
		return ShiftEfficiencyDashboardModel.class;
	}

	@Override
	protected Class<ShiftEfficiencySettingsModel> settingsModelClass() {
		return ShiftEfficiencySettingsModel.class;
	}

	@Override
	protected String initialTestCaseId() {
		return "ex01";
	}

	@Override
	protected Attempt initialAttempt() {
		return Attempt.SOLUTION;
	}
}
