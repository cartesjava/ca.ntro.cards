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
package ca.ntro.cards.naivesort.backend;

import ca.ntro.app.tasks.backend.BackendTasks;
import ca.ntro.cards.naivesort.models.NaivesortEfficiencyDashboardModel;
import ca.ntro.cards.naivesort.models.NaivesortEfficiencySettingsModel;
import ca.ntro.cards.naivesort.models.NaivesortGraphsModel;
import ca.ntro.cards.naivesort.models.TriNaif;
import ca.ntro.cards.naivesort.models.values.NaivesortTestCase;
import ca.ntro.cards.naivesort.test_cases.NaivesortTestCaseDatabase;
import ca.ntro.cards.naivesort.test_cases.execution_trace.NaivesortExecutionTrace;
import ca.ntro.cards.efficiency.backend.EfficiencyBackend;
import ca.ntro.cards.test_cases.execution_trace.ProcedureExecutionTrace;

public class NaivesortEfficiencyBackend<STUDENT_MODEL extends TriNaif>

       extends EfficiencyBackend<TriNaif, 
                                 STUDENT_MODEL,
                                 NaivesortGraphsModel,            // CanvasModel
                                 NaivesortTestCase,
                                 NaivesortTestCaseDatabase,
                                 NaivesortExecutionTrace,
                                 NaivesortEfficiencyDashboardModel,
                                 NaivesortEfficiencySettingsModel> {



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
