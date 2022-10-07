package ca.ntro.cards.shift.backend;



import ca.ntro.app.tasks.backend.BackendTasks;
import static ca.ntro.app.tasks.backend.BackendTasks.*;
import ca.ntro.cards.backend.ProcedureBackend;
import ca.ntro.cards.shift.messages.ShiftMsgAcceptManualModel;
import ca.ntro.cards.shift.models.Tableau;
import ca.ntro.cards.shift.models.values.ShiftTestCase;
import ca.ntro.cards.shift.test_cases.ShiftTestCaseDatabase;
import ca.ntro.cards.shift.test_cases.execution_trace.ShiftExecutionTrace;
import ca.ntro.cards.messages.ProcedureMsgAcceptManualModel;
import ca.ntro.cards.shift.models.ShiftProcedureDashboardModel;
import ca.ntro.cards.shift.models.ShiftProcedureSettingsModel;

public class   ShiftProcedureBackend<STUDENT_MODEL extends Tableau>


       extends ProcedureBackend<Tableau,       // ExecutableModel
                                STUDENT_MODEL,
                                STUDENT_MODEL,        // CanvasModel
                                ShiftTestCase,
                                ShiftTestCaseDatabase,
                                ShiftExecutionTrace,
                                ShiftProcedureDashboardModel,
                                ShiftProcedureSettingsModel,
                                ShiftMsgAcceptManualModel> {

	
	


}
