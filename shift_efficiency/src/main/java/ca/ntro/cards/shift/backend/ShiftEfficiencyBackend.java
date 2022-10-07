package ca.ntro.cards.shift.backend;

import ca.ntro.cards.shift.models.ShiftEfficiencyDashboardModel;
import ca.ntro.cards.shift.models.ShiftEfficiencySettingsModel;
import ca.ntro.cards.shift.models.ShiftGraphsModel;
import ca.ntro.cards.shift.models.Tableau;
import ca.ntro.cards.shift.models.values.ShiftTestCase;
import ca.ntro.cards.shift.test_cases.ShiftTestCaseDatabase;
import ca.ntro.cards.shift.test_cases.execution_trace.ShiftExecutionTrace;
import ca.ntro.cards.efficiency.backend.EfficiencyBackend;

public class ShiftEfficiencyBackend<STUDENT_MODEL extends Tableau>

       extends EfficiencyBackend<Tableau, 
                                 STUDENT_MODEL,
                                 ShiftGraphsModel,            // CanvasModel
                                 ShiftTestCase,
                                 ShiftTestCaseDatabase,
                                 ShiftExecutionTrace,
                                 ShiftEfficiencyDashboardModel,
                                 ShiftEfficiencySettingsModel> {




}
