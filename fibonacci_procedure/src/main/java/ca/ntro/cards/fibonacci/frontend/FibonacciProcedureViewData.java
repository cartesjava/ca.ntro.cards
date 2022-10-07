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
