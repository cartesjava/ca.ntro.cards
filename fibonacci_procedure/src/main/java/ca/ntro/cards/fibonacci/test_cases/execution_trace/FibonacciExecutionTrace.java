package ca.ntro.cards.fibonacci.test_cases.execution_trace;

import ca.ntro.cards.fibonacci.models.Calculateur;
import ca.ntro.cards.fibonacci.models.FibonacciProcedureDashboardModel;
import ca.ntro.cards.test_cases.execution_trace.ProcedureExecutionTrace;

public interface FibonacciExecutionTrace<EXECUTABLE_MODEL extends Calculateur,
                                    DASHBOARD_MODEL  extends FibonacciProcedureDashboardModel> 

       extends ProcedureExecutionTrace<EXECUTABLE_MODEL, 
                                       DASHBOARD_MODEL> {

}
