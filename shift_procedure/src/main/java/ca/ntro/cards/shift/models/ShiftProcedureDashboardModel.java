/*
Copyright (C) (2022) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)

This file is part of "Cartes Java", teaching tools made for https://cartesjava.github.io/

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

*/
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
