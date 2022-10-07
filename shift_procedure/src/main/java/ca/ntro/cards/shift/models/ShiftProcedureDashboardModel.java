package ca.ntro.cards.shift.models;

import ca.ntro.cards.shift.frontend.views.ShiftProcedureDashboardView;
import ca.ntro.cards.shift.frontend.views.ShiftReplayView;
import ca.ntro.cards.shift.frontend.views.ShiftSelectionsView;
import ca.ntro.cards.shift.frontend.views.fragments.ShiftTestCaseFragment;
import ca.ntro.cards.shift.test_cases.ShiftTestCaseDatabase;
import ca.ntro.cards.shift.test_cases.descriptor.ShiftTestCaseDescriptor;
import ca.ntro.cards.models.ProcedureDashboardModel;

public class ShiftProcedureDashboardModel extends ProcedureDashboardModel<ShiftProcedureDashboardView, 
                                                                         Tableau, 
                                                                         ShiftTestCaseDatabase,
                                                                         ShiftTestCaseDescriptor,
                                                                         ShiftReplayView,
                                                                         ShiftSelectionsView,
                                                                         ShiftTestCaseFragment> {

	@Override
	protected String defaultTestCaseId() {
		return "ex01";
	}


}
