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
package ca.ntro.cards.test_cases;

import ca.ntro.cards.common.models.enums.Attempt;
import ca.ntro.cards.common.test_cases.CommonTestCase;
import ca.ntro.cards.common.test_cases.descriptor.AbstractTestCaseDescriptor;
import ca.ntro.cards.common.test_cases.descriptor.CommonTestCaseDescriptor;
import ca.ntro.cards.models.ProcedureCardsModel;
import ca.ntro.cards.models.ProcedureDashboardModel;
import ca.ntro.cards.models.values.ComparisonReport;
import ca.ntro.cards.test_cases.descriptor.ProcedureTestCaseDescriptor;
import ca.ntro.cards.test_cases.execution_trace.ProcedureExecutionTrace;

public abstract class  ProcedureTestCase<EXECUTABLE_MODEL extends ProcedureCardsModel,
                                         STUDENT_MODEL    extends EXECUTABLE_MODEL,
                                         EXECUTION_TRACE  extends ProcedureExecutionTrace,
                                         DASHBOARD_MODEL  extends ProcedureDashboardModel> 

       extends CommonTestCase<EXECUTABLE_MODEL, 
                              STUDENT_MODEL, 
                              EXECUTION_TRACE,
                              DASHBOARD_MODEL> {

	public void updateCardsModel(Attempt attempt, EXECUTABLE_MODEL cardsModel) {
		executionTraceByMode(attempt).copyCurrentModelInto(cardsModel);
	}

	public void pushManualExecutionStep(STUDENT_MODEL model) {
		executionTraceByMode(Attempt.MANUAL).truncateAfterCurrentStep();
		executionTraceByMode(Attempt.MANUAL).pushCloneOf(model);
		executionTraceByMode(Attempt.MANUAL).stepForward();
	}

	@Override
	public void checkSolution() {
		ComparisonReport report = ((ProcedureExecutionTrace) executionTraceByMode(Attempt.CODE)).compareToSolution((ProcedureExecutionTrace) executionTraceByMode(Attempt.SOLUTION));

		setPassed(report.isSolution());
	}

}
