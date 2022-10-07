package ca.ntro.cards.fibonacci.test_cases.execution_trace;

import ca.ntro.cards.fibonacci.models.Calculateur;
import ca.ntro.cards.fibonacci.models.FibonacciProcedureDashboardModel;
import ca.ntro.cards.test_cases.execution_trace.ProcedureExecutionTraceFull;

public class FibonacciExecutionTraceFull<EXECUTABLE_MODEL extends Calculateur,
                                    DASHBOARD_MODEL  extends FibonacciProcedureDashboardModel> 

       extends ProcedureExecutionTraceFull<EXECUTABLE_MODEL, 
                                           DASHBOARD_MODEL>

       implements FibonacciExecutionTrace<EXECUTABLE_MODEL, DASHBOARD_MODEL> {

}
