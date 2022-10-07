package ca.ntro.cards.fibonacci;

import ca.ntro.cards.fibonacci.backend.FibonacciEfficiencyBackend;
import ca.ntro.cards.fibonacci.frontend.FibonacciEfficiencyFrontend;
import ca.ntro.cards.fibonacci.frontend.FibonacciEfficiencyViewData;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciEfficiencyDashboardView;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciEfficiencyMessagesView;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciEfficiencyRootView;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciEfficiencySettingsView;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciGraphsView;
import ca.ntro.cards.fibonacci.frontend.views.fragments.FibonacciEfficiencyMessageFragment;
import ca.ntro.cards.fibonacci.models.FibonacciEfficiencyDashboardModel;
import ca.ntro.cards.fibonacci.models.FibonacciEfficiencySettingsModel;
import ca.ntro.cards.fibonacci.models.FibonacciGraphsModel;
import ca.ntro.cards.fibonacci.models.Calculateur;
import ca.ntro.cards.fibonacci.models.values.FibonacciTestCase;
import ca.ntro.cards.fibonacci.test_cases.FibonacciTestCaseDatabase;
import ca.ntro.cards.fibonacci.test_cases.execution_trace.FibonacciExecutionTrace;
import ca.ntro.cards.common.models.enums.Attempt;
import ca.ntro.cards.efficiency.EfficiencyApp;

public abstract class   FibonacciEfficiencyApp<STUDENT_MODEL extends Calculateur>

                extends EfficiencyApp<Calculateur, 
                                      STUDENT_MODEL,
                                      FibonacciGraphsModel,
                                      FibonacciTestCase,
                                      FibonacciTestCaseDatabase,
                                      FibonacciExecutionTrace,
                                      FibonacciEfficiencyDashboardModel,
                                      FibonacciEfficiencySettingsModel,
                                      FibonacciEfficiencyBackend<STUDENT_MODEL>,
                                      FibonacciEfficiencyRootView,
                                      FibonacciGraphsView,
                                      FibonacciEfficiencyDashboardView,
                                      FibonacciEfficiencySettingsView,
                                      FibonacciEfficiencyMessagesView,
                                      FibonacciEfficiencyMessageFragment,
                                      FibonacciEfficiencyViewData,
                                      FibonacciEfficiencyFrontend> {

	@Override
	protected FibonacciEfficiencyFrontend createFrontend() {
		return new FibonacciEfficiencyFrontend();
	}

	@Override
	protected FibonacciEfficiencyBackend createBackend() {
		return new FibonacciEfficiencyBackend();
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected Class<Calculateur> executableModelClass() {
		return Calculateur.class;
	}

	@Override
	protected Class<STUDENT_MODEL> studentModelClass() {
		return studentClass();
	}
	
	// TODO: renommer
	protected abstract Class<STUDENT_MODEL> studentClass();

	@Override
	protected Class<FibonacciGraphsModel> canvasModelClass() {
		return FibonacciGraphsModel.class;
	}

	@Override
	protected Class<FibonacciTestCase> testCaseClass() {
		return FibonacciTestCase.class;
	}

	@Override
	protected Class<FibonacciTestCaseDatabase> testCasesModelClass() {
		return FibonacciTestCaseDatabase.class;
	}

	@Override
	protected Class<FibonacciEfficiencyDashboardModel> dashboardModelClass() {
		return FibonacciEfficiencyDashboardModel.class;
	}

	@Override
	protected Class<FibonacciEfficiencySettingsModel> settingsModelClass() {
		return FibonacciEfficiencySettingsModel.class;
	}

	@Override
	protected String initialTestCaseId() {
		return "ex01";
	}

	@Override
	protected Attempt initialAttempt() {
		return Attempt.SOLUTION;
	}
}
