package ca.ntro.cards.shift2.backend;



import ca.ntro.app.tasks.backend.BackendTasks;
import static ca.ntro.app.tasks.backend.BackendTasks.*;
import ca.ntro.cards.backend.ProcedureBackend;
import ca.ntro.cards.shift2.messages.Shift2MsgAcceptManualModel;
import ca.ntro.cards.shift2.models.Tableau;
import ca.ntro.cards.shift2.models.values.Shift2TestCase;
import ca.ntro.cards.shift2.test_cases.Shift2TestCaseDatabase;
import ca.ntro.cards.shift2.test_cases.execution_trace.Shift2ExecutionTrace;
import ca.ntro.cards.messages.ProcedureMsgAcceptManualModel;
import ca.ntro.cards.shift2.models.Shift2ProcedureDashboardModel;
import ca.ntro.cards.shift2.models.Shift2ProcedureSettingsModel;

public class   Shift2ProcedureBackend<STUDENT_MODEL extends Tableau>


       extends ProcedureBackend<Tableau,       // ExecutableModel
                                STUDENT_MODEL,
                                STUDENT_MODEL,        // CanvasModel
                                Shift2TestCase,
                                Shift2TestCaseDatabase,
                                Shift2ExecutionTrace,
                                Shift2ProcedureDashboardModel,
                                Shift2ProcedureSettingsModel,
                                Shift2MsgAcceptManualModel> {

	
	


}
