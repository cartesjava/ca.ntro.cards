package ca.ntro.cards.shift2.models;

import ca.ntro.cards.shift2.frontend.views.Shift2ProcedureDashboardView;
import ca.ntro.cards.shift2.frontend.views.Shift2ReplayView;
import ca.ntro.cards.shift2.frontend.views.Shift2SelectionsView;
import ca.ntro.cards.shift2.frontend.views.fragments.Shift2TestCaseFragment;
import ca.ntro.cards.shift2.test_cases.Shift2TestCaseDatabase;
import ca.ntro.cards.shift2.test_cases.descriptor.Shift2TestCaseDescriptor;
import ca.ntro.cards.models.ProcedureDashboardModel;

public class Shift2ProcedureDashboardModel extends ProcedureDashboardModel<Shift2ProcedureDashboardView, 
                                                                         Tableau, 
                                                                         Shift2TestCaseDatabase,
                                                                         Shift2TestCaseDescriptor,
                                                                         Shift2ReplayView,
                                                                         Shift2SelectionsView,
                                                                         Shift2TestCaseFragment> {

	@Override
	protected String defaultTestCaseId() {
		return "ex01";
	}


}
