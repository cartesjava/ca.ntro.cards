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
