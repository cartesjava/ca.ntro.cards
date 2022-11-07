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
package ca.ntro.cards.fibonacci.test_cases;

import ca.ntro.cards.common.test_cases.descriptor.AbstractTestCaseDescriptor;
import ca.ntro.cards.fibonacci.models.Calculateur;
import ca.ntro.cards.fibonacci.models.FibonacciProcedureDashboardModel;
import ca.ntro.cards.fibonacci.models.values.FibonacciTestCase;
import ca.ntro.cards.fibonacci.test_cases.execution_trace.FibonacciExecutionTrace;
import ca.ntro.cards.test_cases.ProcedureTestCaseDatabase;
import ca.ntro.cards.test_cases.execution_trace.ProcedureExecutionTrace;
import ca.ntro.core.initialization.Ntro;

public class   FibonacciTestCaseDatabase<STUDENT_MODEL extends Calculateur> 

       extends ProcedureTestCaseDatabase<Calculateur, 
                                         STUDENT_MODEL, 
                                         FibonacciTestCase, 
                                         FibonacciExecutionTrace,
                                         FibonacciProcedureDashboardModel> {

    @Override
    public void describeTestCasesToGenerate() {
    	for(int i = 0; i <= 6; i++) {
			AbstractTestCaseDescriptor descriptor = AbstractTestCaseDescriptor.create()
															  .category("recursif")
															  .testCaseId("rec" + String.format("%02d", i))
															  .inputSize(i);

			addTestCaseDescriptor(descriptor);

			descriptor = AbstractTestCaseDescriptor.create()
												   .category("dynamique")
												   .testCaseId("dyn" + String.format("%02d", i))
												   .inputSize(i);

			addTestCaseDescriptor(descriptor);
    	}

    	for(int i = 10; i <= 20 ; i = i+5) {
			AbstractTestCaseDescriptor descriptor = AbstractTestCaseDescriptor.create()
															  .category("recursif")
															  .testCaseId("rec" + String.format("%02d", i))
															  .inputSize(i);

			addTestCaseDescriptor(descriptor);

			descriptor = AbstractTestCaseDescriptor.create()
						 		                   .category("dynamique")
									               .testCaseId("dyn" + String.format("%02d", i))
									               .inputSize(i);

			addTestCaseDescriptor(descriptor);
    	}
    }

}
