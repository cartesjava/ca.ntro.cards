package ca.ntro.cards.fibonacci.models.world2d;

import ca.ntro.cards.common.models.enums.Sorte;
import ca.ntro.cards.common.models.values.cards.AbstractCard;
import ca.ntro.cards.fibonacci.FibonacciConstants;
import ca.ntro.cards.models.world2d.ProcedureCard2d;

public class FibonacciCard2d extends ProcedureCard2d<FibonacciProcedureWorld2d, FibonacciProcedureDrawingOptions> {

	public FibonacciCard2d() {
		super();
	}


	public FibonacciCard2d(String card2dId, AbstractCard card) {
		super(card2dId, card);
	}

	public FibonacciCard2d(int rank, Sorte suit) {
		super(rank, suit);
	}

	@Override
	protected double initialWidth() {
		return FibonacciConstants.INITIAL_CARD_WIDTH_MILIMETERS;
	}

	@Override
	protected double initialHeight() {
		return FibonacciConstants.INITIAL_CARD_HEIGHT_MILIMETERS;
	}

}
