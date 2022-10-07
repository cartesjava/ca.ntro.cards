package ca.ntro.cards.fibonacci.models;

import ca.ntro.cards.fibonacci.frontend.views.FibonacciProcedureDashboardView;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciReplayView;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciSelectionsView;
import ca.ntro.cards.fibonacci.frontend.views.fragments.FibonacciTestCaseFragment;
import ca.ntro.cards.fibonacci.test_cases.FibonacciTestCaseDatabase;
import ca.ntro.cards.fibonacci.test_cases.descriptor.FibonacciTestCaseDescriptor;
import ca.ntro.cards.models.ProcedureDashboardModel;

public class FibonacciProcedureDashboardModel extends ProcedureDashboardModel<FibonacciProcedureDashboardView, 
                                                                         Calculateur, 
                                                                         FibonacciTestCaseDatabase,
                                                                         FibonacciTestCaseDescriptor,
                                                                         FibonacciReplayView,
                                                                         FibonacciSelectionsView,
                                                                         FibonacciTestCaseFragment> {

	@Override
	protected String defaultTestCaseId() {
		return "ex01";
	}


}
