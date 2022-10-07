package ca.ntro.cards.shift.models.world2d;

import ca.ntro.cards.common.models.enums.Sorte;
import ca.ntro.cards.common.models.values.cards.AbstractCard;
import ca.ntro.cards.shift.ShiftConstants;
import ca.ntro.cards.models.world2d.ProcedureCard2d;

public class ShiftCard2d extends ProcedureCard2d<ShiftProcedureWorld2d, ShiftProcedureDrawingOptions> {

	public ShiftCard2d() {
		super();
	}


	public ShiftCard2d(String card2dId, AbstractCard card) {
		super(card2dId, card);
	}

	public ShiftCard2d(int rank, Sorte suit) {
		super(rank, suit);
	}

	@Override
	protected double initialWidth() {
		return ShiftConstants.INITIAL_CARD_WIDTH_MILIMETERS;
	}

	@Override
	protected double initialHeight() {
		return ShiftConstants.INITIAL_CARD_HEIGHT_MILIMETERS;
	}

}
