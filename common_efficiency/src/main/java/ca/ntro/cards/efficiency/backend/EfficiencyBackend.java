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
package ca.ntro.cards.efficiency.backend;

import ca.ntro.app.NtroApp;
import ca.ntro.app.tasks.backend.BackendTasks;
import ca.ntro.cards.common.backend.CommonBackend;
import ca.ntro.cards.common.models.enums.Attempt;
import ca.ntro.cards.common.test_cases.CommonTestCase;
import ca.ntro.cards.common.test_cases.CommonTestCaseDatabase;
import ca.ntro.cards.efficiency.models.EfficiencyDashboardModel;
import ca.ntro.cards.efficiency.models.EfficiencyGraphsModel;
import ca.ntro.cards.efficiency.models.EfficiencySettingsModel;
import ca.ntro.cards.models.ProcedureCardsModel;
import ca.ntro.cards.test_cases.execution_trace.ProcedureExecutionTrace;

public abstract class EfficiencyBackend <EXECUTABLE_MODEL extends ProcedureCardsModel,
                                         STUDENT_MODEL    extends EXECUTABLE_MODEL,
                                         CANVAS_MODEL     extends EfficiencyGraphsModel,
                                         TEST_CASE        extends CommonTestCase,
                                         TEST_CASES_MODEL extends CommonTestCaseDatabase,
                                         EXECUTION_TRACE  extends ProcedureExecutionTrace,
                                         DASHBOARD_MODEL  extends EfficiencyDashboardModel,
                                         SETTINGS_MODEL   extends EfficiencySettingsModel>

       extends        CommonBackend<EXECUTABLE_MODEL,
                                    STUDENT_MODEL,
                                    CANVAS_MODEL, 
                                    TEST_CASE, 
                                    TEST_CASES_MODEL, 
                                    EXECUTION_TRACE,
                                    DASHBOARD_MODEL, 
                                    SETTINGS_MODEL> {

	@Override
	public void earlyModelInitialization(String initialTestCaseId, Attempt initialAttempt) {
		
		CANVAS_MODEL canvasModel = NtroApp.models().load(getCanvasModelClass());
		
		canvasModel.clear();
	}

	@Override
	protected void addSubTasksToModifyCanvasModel(BackendTasks subTasks) {
	}

	@Override
	protected void addSubTasksToModifyDashboardModel(BackendTasks subTasks) {
	}

	@Override
	protected void addSubTasksToModifySettingsModel(BackendTasks subTasks) {
	}


	@Override
	protected void createAdditionalTasks(BackendTasks tasks) {
	}

}
