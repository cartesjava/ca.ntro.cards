package ca.ntro.cards.shift2.models.world2d;

import ca.ntro.cards.common.models.enums.Sorte;
import ca.ntro.cards.common.models.values.cards.AbstractCard;
import ca.ntro.cards.shift2.Shift2Constants;
import ca.ntro.cards.models.world2d.ProcedureCard2d;

public class Shift2Card2d extends ProcedureCard2d<Shift2ProcedureWorld2d, Shift2ProcedureDrawingOptions> {

	public Shift2Card2d() {
		super();
	}


	public Shift2Card2d(String card2dId, AbstractCard card) {
		super(card2dId, card);
	}

	public Shift2Card2d(int rank, Sorte suit) {
		super(rank, suit);
	}

	@Override
	protected double initialWidth() {
		return Shift2Constants.INITIAL_CARD_WIDTH_MILIMETERS;
	}

	@Override
	protected double initialHeight() {
		return Shift2Constants.INITIAL_CARD_HEIGHT_MILIMETERS;
	}

}
