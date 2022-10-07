package ca.ntro.cards.shift2;

import ca.ntro.cards.shift2.backend.Shift2EfficiencyBackend;
import ca.ntro.cards.shift2.frontend.Shift2EfficiencyFrontend;
import ca.ntro.cards.shift2.frontend.Shift2EfficiencyViewData;
import ca.ntro.cards.shift2.frontend.views.Shift2EfficiencyDashboardView;
import ca.ntro.cards.shift2.frontend.views.Shift2EfficiencyMessagesView;
import ca.ntro.cards.shift2.frontend.views.Shift2EfficiencyRootView;
import ca.ntro.cards.shift2.frontend.views.Shift2EfficiencySettingsView;
import ca.ntro.cards.shift2.frontend.views.Shift2GraphsView;
import ca.ntro.cards.shift2.frontend.views.fragments.Shift2EfficiencyMessageFragment;
import ca.ntro.cards.shift2.models.Shift2EfficiencyDashboardModel;
import ca.ntro.cards.shift2.models.Shift2EfficiencySettingsModel;
import ca.ntro.cards.shift2.models.Shift2GraphsModel;
import ca.ntro.cards.shift2.models.Tableau;
import ca.ntro.cards.shift2.models.values.Shift2TestCase;
import ca.ntro.cards.shift2.test_cases.Shift2TestCaseDatabase;
import ca.ntro.cards.shift2.test_cases.execution_trace.Shift2ExecutionTrace;
import ca.ntro.cards.common.models.enums.Attempt;
import ca.ntro.cards.efficiency.EfficiencyApp;

public abstract class   Shift2EfficiencyApp<STUDENT_MODEL extends Tableau>

                extends EfficiencyApp<Tableau, 
                                      STUDENT_MODEL,
                                      Shift2GraphsModel,
                                      Shift2TestCase,
                                      Shift2TestCaseDatabase,
                                      Shift2ExecutionTrace,
                                      Shift2EfficiencyDashboardModel,
                                      Shift2EfficiencySettingsModel,
                                      Shift2EfficiencyBackend<STUDENT_MODEL>,
                                      Shift2EfficiencyRootView,
                                      Shift2GraphsView,
                                      Shift2EfficiencyDashboardView,
                                      Shift2EfficiencySettingsView,
                                      Shift2EfficiencyMessagesView,
                                      Shift2EfficiencyMessageFragment,
                                      Shift2EfficiencyViewData,
                                      Shift2EfficiencyFrontend> {

	@Override
	protected Shift2EfficiencyFrontend createFrontend() {
		return new Shift2EfficiencyFrontend();
	}

	@Override
	protected Shift2EfficiencyBackend createBackend() {
		return new Shift2EfficiencyBackend();
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected Class<Tableau> executableModelClass() {
		return Tableau.class;
	}

	@Override
	protected Class<STUDENT_MODEL> studentModelClass() {
		return studentClass();
	}
	
	// TODO: renommer
	protected abstract Class<STUDENT_MODEL> studentClass();

	@Override
	protected Class<Shift2GraphsModel> canvasModelClass() {
		return Shift2GraphsModel.class;
	}

	@Override
	protected Class<Shift2TestCase> testCaseClass() {
		return Shift2TestCase.class;
	}

	@Override
	protected Class<Shift2TestCaseDatabase> testCasesModelClass() {
		return Shift2TestCaseDatabase.class;
	}

	@Override
	protected Class<Shift2EfficiencyDashboardModel> dashboardModelClass() {
		return Shift2EfficiencyDashboardModel.class;
	}

	@Override
	protected Class<Shift2EfficiencySettingsModel> settingsModelClass() {
		return Shift2EfficiencySettingsModel.class;
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
