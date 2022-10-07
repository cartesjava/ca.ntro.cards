package ca.ntro.cards.shift.test_cases.execution_trace;

import ca.ntro.cards.shift.models.Tableau;
import ca.ntro.cards.shift.models.ShiftProcedureDashboardModel;
import ca.ntro.cards.test_cases.execution_trace.ProcedureExecutionTraceFull;

public class ShiftExecutionTraceFull<EXECUTABLE_MODEL extends Tableau,
                                    DASHBOARD_MODEL  extends ShiftProcedureDashboardModel> 

       extends ProcedureExecutionTraceFull<EXECUTABLE_MODEL, 
                                           DASHBOARD_MODEL>

       implements ShiftExecutionTrace<EXECUTABLE_MODEL, DASHBOARD_MODEL> {

}
