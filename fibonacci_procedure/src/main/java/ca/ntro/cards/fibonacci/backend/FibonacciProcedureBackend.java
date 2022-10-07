package ca.ntro.cards.fibonacci.backend;



import ca.ntro.app.tasks.backend.BackendTasks;
import static ca.ntro.app.tasks.backend.BackendTasks.*;
import ca.ntro.cards.backend.ProcedureBackend;
import ca.ntro.cards.fibonacci.messages.FibonacciMsgAcceptManualModel;
import ca.ntro.cards.fibonacci.models.Calculateur;
import ca.ntro.cards.fibonacci.models.values.FibonacciTestCase;
import ca.ntro.cards.fibonacci.test_cases.FibonacciTestCaseDatabase;
import ca.ntro.cards.fibonacci.test_cases.execution_trace.FibonacciExecutionTrace;
import ca.ntro.cards.messages.ProcedureMsgAcceptManualModel;
import ca.ntro.cards.fibonacci.models.FibonacciProcedureDashboardModel;
import ca.ntro.cards.fibonacci.models.FibonacciProcedureSettingsModel;

public class   FibonacciProcedureBackend<STUDENT_MODEL extends Calculateur>


       extends ProcedureBackend<Calculateur,       // ExecutableModel
                                STUDENT_MODEL,
                                STUDENT_MODEL,        // CanvasModel
                                FibonacciTestCase,
                                FibonacciTestCaseDatabase,
                                FibonacciExecutionTrace,
                                FibonacciProcedureDashboardModel,
                                FibonacciProcedureSettingsModel,
                                FibonacciMsgAcceptManualModel> {

	
	


}
