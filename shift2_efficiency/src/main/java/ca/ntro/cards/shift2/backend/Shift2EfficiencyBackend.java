package ca.ntro.cards.shift2.backend;

import ca.ntro.cards.shift2.models.Shift2EfficiencyDashboardModel;
import ca.ntro.cards.shift2.models.Shift2EfficiencySettingsModel;
import ca.ntro.cards.shift2.models.Shift2GraphsModel;
import ca.ntro.cards.shift2.models.Tableau;
import ca.ntro.cards.shift2.models.values.Shift2TestCase;
import ca.ntro.cards.shift2.test_cases.Shift2TestCaseDatabase;
import ca.ntro.cards.shift2.test_cases.execution_trace.Shift2ExecutionTrace;
import ca.ntro.cards.efficiency.backend.EfficiencyBackend;

public class Shift2EfficiencyBackend<STUDENT_MODEL extends Tableau>

       extends EfficiencyBackend<Tableau, 
                                 STUDENT_MODEL,
                                 Shift2GraphsModel,            // CanvasModel
                                 Shift2TestCase,
                                 Shift2TestCaseDatabase,
                                 Shift2ExecutionTrace,
                                 Shift2EfficiencyDashboardModel,
                                 Shift2EfficiencySettingsModel> {




}
