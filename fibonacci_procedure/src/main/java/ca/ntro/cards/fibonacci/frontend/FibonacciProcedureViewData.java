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
package ca.ntro.cards.fibonacci.frontend;

import ca.ntro.cards.common.models.values.cards.AbstractCard;
import ca.ntro.cards.fibonacci.models.world2d.FibonacciCard2d;
import ca.ntro.cards.fibonacci.models.world2d.FibonacciProcedureDrawingOptions;
import ca.ntro.cards.fibonacci.models.world2d.FibonacciProcedureWorld2d;
import ca.ntro.cards.frontend.ProcedureViewData;
import ca.ntro.cards.models.world2d.ProcedureCard2d;

public class FibonacciProcedureViewData extends ProcedureViewData<FibonacciProcedureWorld2d, FibonacciProcedureDrawingOptions> {

	@Override
	protected FibonacciProcedureWorld2d newWorld2d() {
		return new FibonacciProcedureWorld2d();
	}

	@Override
	protected ProcedureCard2d newCard2d(String card2dId, AbstractCard card) {
		return new FibonacciCard2d(card2dId, card);
	}

	@Override
	protected FibonacciProcedureDrawingOptions defaultDrawingOptions() {
		return new FibonacciProcedureDrawingOptions() {
			@Override
			public boolean useFourCardColors() {
				return true;
			}
		};
	}


}
