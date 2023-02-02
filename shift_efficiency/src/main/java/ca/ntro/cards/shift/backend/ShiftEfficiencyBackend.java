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
package ca.ntro.cards.shift.backend;

import ca.ntro.cards.shift.models.ShiftEfficiencyDashboardModel;
import ca.ntro.cards.shift.models.ShiftEfficiencySettingsModel;
import ca.ntro.cards.shift.models.ShiftGraphsModel;
import ca.ntro.cards.shift.models.Tableau;
import ca.ntro.cards.shift.models.values.ShiftTestCase;
import ca.ntro.cards.shift.test_cases.ShiftTestCaseDatabase;
import ca.ntro.cards.shift.test_cases.execution_trace.ShiftExecutionTrace;
import ca.ntro.cards.efficiency.backend.EfficiencyBackend;

public class ShiftEfficiencyBackend<STUDENT_MODEL extends Tableau>

       extends EfficiencyBackend<Tableau, 
                                 STUDENT_MODEL,
                                 ShiftGraphsModel,            // CanvasModel
                                 ShiftTestCase,
                                 ShiftTestCaseDatabase,
                                 ShiftExecutionTrace,
                                 ShiftEfficiencyDashboardModel,
                                 ShiftEfficiencySettingsModel> {




}
