package ca.ntro.cards.shift2.models.values;


import ca.ntro.cards.shift2.models.Tableau;
import ca.ntro.cards.shift2.test_cases.descriptor.Shift2TestCaseDescriptor;
import ca.ntro.cards.common.test_cases.descriptor.CommonTestCaseDescriptor;
import ca.ntro.cards.shift2.models.Shift2ProcedureDashboardModel;
import ca.ntro.cards.test_cases.ProcedureTestCase;
import ca.ntro.cards.test_cases.execution_trace.ProcedureExecutionTrace;

public class   Shift2TestCase<STUDENT_MODEL extends Tableau> 

       extends ProcedureTestCase<Tableau, STUDENT_MODEL, ProcedureExecutionTrace, Shift2ProcedureDashboardModel> {


    @Override
    protected CommonTestCaseDescriptor newTestCaseDescriptor() {
        return new Shift2TestCaseDescriptor();
    }


}
