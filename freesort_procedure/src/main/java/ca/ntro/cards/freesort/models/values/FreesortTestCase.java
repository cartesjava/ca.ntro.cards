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
package ca.ntro.cards.freesort.models.values;


import ca.ntro.cards.freesort.models.TriLibre;
import ca.ntro.cards.freesort.test_cases.descriptor.FreesortTestCaseDescriptor;
import ca.ntro.cards.common.test_cases.descriptor.CommonTestCaseDescriptor;
import ca.ntro.cards.freesort.models.FreesortProcedureDashboardModel;
import ca.ntro.cards.test_cases.ProcedureTestCase;
import ca.ntro.cards.test_cases.execution_trace.ProcedureExecutionTrace;

public class   FreesortTestCase<STUDENT_MODEL extends TriLibre> 

       extends ProcedureTestCase<TriLibre, STUDENT_MODEL, ProcedureExecutionTrace, FreesortProcedureDashboardModel> {

	@Override
	protected CommonTestCaseDescriptor newTestCaseDescriptor() {
		return new FreesortTestCaseDescriptor();
	}

}
