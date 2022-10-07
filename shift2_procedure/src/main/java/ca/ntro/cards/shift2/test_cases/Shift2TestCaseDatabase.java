package ca.ntro.cards.shift2.test_cases;

import ca.ntro.cards.common.test_cases.descriptor.AbstractTestCaseDescriptor;
import ca.ntro.cards.shift2.models.Tableau;
import ca.ntro.cards.shift2.models.Shift2ProcedureDashboardModel;
import ca.ntro.cards.shift2.models.values.Shift2TestCase;
import ca.ntro.cards.shift2.test_cases.execution_trace.Shift2ExecutionTrace;
import ca.ntro.cards.test_cases.ProcedureTestCaseDatabase;
import ca.ntro.cards.test_cases.execution_trace.ProcedureExecutionTrace;
import ca.ntro.core.initialization.Ntro;

public class   Shift2TestCaseDatabase<STUDENT_MODEL extends Tableau> 

       extends ProcedureTestCaseDatabase<Tableau, 
                                         STUDENT_MODEL, 
                                         Shift2TestCase, 
                                         Shift2ExecutionTrace,
                                         Shift2ProcedureDashboardModel> {

    @Override
    public void describeTestCasesToGenerate() {
        
        AbstractTestCaseDescriptor descriptor = AbstractTestCaseDescriptor.create()
                                                          .category("exemples")
                                                          .testCaseId("ex01");
        
        addTestCaseDescriptor(descriptor);

        descriptor = AbstractTestCaseDescriptor.create()
                                               .category("exemples")
                                               .testCaseId("ex02");
        
        addTestCaseDescriptor(descriptor);

        descriptor = AbstractTestCaseDescriptor.create()
                                               .category("exemples")
                                               .testCaseId("ex03");
        
        addTestCaseDescriptor(descriptor);

        /*
		for(int i = 1; i <= 5; i++) {
			
			int size = 5 + Ntro.random().nextInt(5);

			descriptor = AbstractTestCaseDescriptor.create()
												   .random(size);

			addTestCaseDescriptor(descriptor);
		}
		*/

    }

}
