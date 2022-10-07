package ca.ntro.cards.shift2.test_cases.execution_trace;

import ca.ntro.cards.shift2.models.Tableau;
import ca.ntro.cards.shift2.models.Shift2ProcedureDashboardModel;
import ca.ntro.cards.test_cases.execution_trace.ProcedureExecutionTrace;

public interface Shift2ExecutionTrace<EXECUTABLE_MODEL extends Tableau,
                                    DASHBOARD_MODEL  extends Shift2ProcedureDashboardModel> 

       extends ProcedureExecutionTrace<EXECUTABLE_MODEL, 
                                       DASHBOARD_MODEL> {

}
