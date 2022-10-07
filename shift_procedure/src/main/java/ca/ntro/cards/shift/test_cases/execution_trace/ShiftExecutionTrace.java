package ca.ntro.cards.shift.test_cases.execution_trace;

import ca.ntro.cards.shift.models.Tableau;
import ca.ntro.cards.shift.models.ShiftProcedureDashboardModel;
import ca.ntro.cards.test_cases.execution_trace.ProcedureExecutionTrace;

public interface ShiftExecutionTrace<EXECUTABLE_MODEL extends Tableau,
                                    DASHBOARD_MODEL  extends ShiftProcedureDashboardModel> 

       extends ProcedureExecutionTrace<EXECUTABLE_MODEL, 
                                       DASHBOARD_MODEL> {

}
