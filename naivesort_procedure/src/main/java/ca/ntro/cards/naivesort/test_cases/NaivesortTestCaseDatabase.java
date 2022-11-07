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
package ca.ntro.cards.naivesort.test_cases;

import ca.ntro.cards.common.test_cases.descriptor.AbstractTestCaseDescriptor;
import ca.ntro.cards.naivesort.models.TriNaif;
import ca.ntro.cards.naivesort.models.NaivesortProcedureDashboardModel;
import ca.ntro.cards.naivesort.models.values.NaivesortTestCase;
import ca.ntro.cards.naivesort.test_cases.execution_trace.NaivesortExecutionTrace;
import ca.ntro.cards.test_cases.ProcedureTestCaseDatabase;
import ca.ntro.cards.test_cases.execution_trace.ProcedureExecutionTrace;
import ca.ntro.core.initialization.Ntro;

public class   NaivesortTestCaseDatabase<STUDENT_MODEL extends TriNaif> 

       extends ProcedureTestCaseDatabase<TriNaif, 
                                         STUDENT_MODEL, 
                                         NaivesortTestCase, 
                                         NaivesortExecutionTrace,
                                         NaivesortProcedureDashboardModel> {

	@Override
	public void describeTestCasesToGenerate() {

		AbstractTestCaseDescriptor descriptor = AbstractTestCaseDescriptor.create()
				                                          .category("exemples")
				                                          .testCaseId("ex01");
		
		addTestCaseDescriptor(descriptor);
		
		for(int i = 1; i <= 5; i++) {
			
			int size = i*5;

			descriptor = AbstractTestCaseDescriptor.create()
												   .random(size);

			addTestCaseDescriptor(descriptor);
		}
	}

}
