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
package ca.ntro.cards.freesort.backend;



import ca.ntro.app.tasks.backend.BackendTasks;
import static ca.ntro.app.tasks.backend.BackendTasks.*;
import ca.ntro.cards.backend.ProcedureBackend;
import ca.ntro.cards.freesort.messages.FreesortMsgAcceptManualModel;
import ca.ntro.cards.freesort.models.TriLibre;
import ca.ntro.cards.freesort.models.values.FreesortTestCase;
import ca.ntro.cards.freesort.test_cases.FreesortTestCaseDatabase;
import ca.ntro.cards.freesort.test_cases.execution_trace.FreesortExecutionTrace;
import ca.ntro.cards.freesort.models.FreesortProcedureDashboardModel;
import ca.ntro.cards.freesort.models.FreesortProcedureSettingsModel;

public class   FreesortProcedureBackend<STUDENT_MODEL extends TriLibre>


       extends ProcedureBackend<TriLibre,       // ExecutableModel
                                STUDENT_MODEL,
                                STUDENT_MODEL,        // CanvasModel
                                FreesortTestCase,
                                FreesortTestCaseDatabase,
                                FreesortExecutionTrace,
                                FreesortProcedureDashboardModel,
                                FreesortProcedureSettingsModel,
                                FreesortMsgAcceptManualModel> {

	
	

	@Override
	protected void addSubTasksToAccessTestCaseDatabase(BackendTasks subTasks) {
	}

}
