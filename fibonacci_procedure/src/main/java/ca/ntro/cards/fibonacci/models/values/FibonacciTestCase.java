package ca.ntro.cards.fibonacci.models.values;


import ca.ntro.cards.fibonacci.models.Calculateur;
import ca.ntro.cards.fibonacci.test_cases.descriptor.FibonacciTestCaseDescriptor;
import ca.ntro.cards.common.test_cases.descriptor.CommonTestCaseDescriptor;
import ca.ntro.cards.fibonacci.models.FibonacciProcedureDashboardModel;
import ca.ntro.cards.test_cases.ProcedureTestCase;
import ca.ntro.cards.test_cases.execution_trace.ProcedureExecutionTrace;

public class   FibonacciTestCase<STUDENT_MODEL extends Calculateur> 

       extends ProcedureTestCase<Calculateur, STUDENT_MODEL, ProcedureExecutionTrace, FibonacciProcedureDashboardModel> {


    @Override
    protected CommonTestCaseDescriptor newTestCaseDescriptor() {
        return new FibonacciTestCaseDescriptor();
    }


}
