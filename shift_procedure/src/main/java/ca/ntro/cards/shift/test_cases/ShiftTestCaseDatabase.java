package ca.ntro.cards.shift.test_cases;

import ca.ntro.cards.common.test_cases.descriptor.AbstractTestCaseDescriptor;
import ca.ntro.cards.shift.models.Tableau;
import ca.ntro.cards.shift.models.ShiftProcedureDashboardModel;
import ca.ntro.cards.shift.models.values.ShiftTestCase;
import ca.ntro.cards.shift.test_cases.execution_trace.ShiftExecutionTrace;
import ca.ntro.cards.test_cases.ProcedureTestCaseDatabase;
import ca.ntro.cards.test_cases.execution_trace.ProcedureExecutionTrace;
import ca.ntro.core.initialization.Ntro;

public class   ShiftTestCaseDatabase<STUDENT_MODEL extends Tableau> 

       extends ProcedureTestCaseDatabase<Tableau, 
                                         STUDENT_MODEL, 
                                         ShiftTestCase, 
                                         ShiftExecutionTrace,
                                         ShiftProcedureDashboardModel> {

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

        descriptor = AbstractTestCaseDescriptor.create()
                                               .category("exemples")
                                               .testCaseId("ex04");
        
        addTestCaseDescriptor(descriptor);

        // examen2
		for(int i = 0; i < 6; i++) {
			
			descriptor = AbstractTestCaseDescriptor.create()
											       .random(3 + i%2);

			addTestCaseDescriptor(descriptor);
		}

    }

}
