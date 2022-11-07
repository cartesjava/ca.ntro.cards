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
package ca.ntro.cards.test_cases.execution_trace;

import ca.ntro.cards.common.test_cases.execution_trace.CommonExecutionTrace;
import ca.ntro.cards.models.ProcedureCardsModel;
import ca.ntro.cards.models.ProcedureDashboardModel;
import ca.ntro.cards.models.values.ComparisonReport;

public interface ProcedureExecutionTrace<EXECUTABLE_MODEL extends ProcedureCardsModel,
                                         DASHBOARD_MODEL  extends ProcedureDashboardModel> 

       extends CommonExecutionTrace<EXECUTABLE_MODEL, 
                                    DASHBOARD_MODEL> {

	ComparisonReport compareToSolution(ProcedureExecutionTrace<EXECUTABLE_MODEL, DASHBOARD_MODEL> executionTraceByMode);

	ComparisonReport evaluateCandidateSolution(EXECUTABLE_MODEL lastModel);

}
