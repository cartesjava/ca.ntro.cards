package ca.ntro.cards.shift.models.values;


import ca.ntro.cards.shift.models.Tableau;
import ca.ntro.cards.shift.test_cases.descriptor.ShiftTestCaseDescriptor;
import ca.ntro.cards.common.test_cases.descriptor.CommonTestCaseDescriptor;
import ca.ntro.cards.shift.models.ShiftProcedureDashboardModel;
import ca.ntro.cards.test_cases.ProcedureTestCase;
import ca.ntro.cards.test_cases.execution_trace.ProcedureExecutionTrace;

public class   ShiftTestCase<STUDENT_MODEL extends Tableau> 

       extends ProcedureTestCase<Tableau, STUDENT_MODEL, ProcedureExecutionTrace, ShiftProcedureDashboardModel> {


    @Override
    protected CommonTestCaseDescriptor newTestCaseDescriptor() {
        return new ShiftTestCaseDescriptor();
    }


}
