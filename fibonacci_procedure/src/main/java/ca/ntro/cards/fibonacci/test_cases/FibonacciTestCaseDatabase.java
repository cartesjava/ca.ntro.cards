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
