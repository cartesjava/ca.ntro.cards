package ca.ntro.cards.fibonacci.backend;

import ca.ntro.cards.fibonacci.models.FibonacciEfficiencyDashboardModel;
import ca.ntro.cards.fibonacci.models.FibonacciEfficiencySettingsModel;
import ca.ntro.cards.fibonacci.models.FibonacciGraphsModel;
import ca.ntro.cards.fibonacci.models.Calculateur;
import ca.ntro.cards.fibonacci.models.values.FibonacciTestCase;
import ca.ntro.cards.fibonacci.test_cases.FibonacciTestCaseDatabase;
import ca.ntro.cards.fibonacci.test_cases.execution_trace.FibonacciExecutionTrace;
import ca.ntro.cards.efficiency.backend.EfficiencyBackend;

public class FibonacciEfficiencyBackend<STUDENT_MODEL extends Calculateur>

       extends EfficiencyBackend<Calculateur, 
                                 STUDENT_MODEL,
                                 FibonacciGraphsModel,            // CanvasModel
                                 FibonacciTestCase,
                                 FibonacciTestCaseDatabase,
                                 FibonacciExecutionTrace,
                                 FibonacciEfficiencyDashboardModel,
                                 FibonacciEfficiencySettingsModel> {




}
