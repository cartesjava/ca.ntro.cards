package ca.ntro.cards.arraylist.models.world2d;

import ca.ntro.cards.common.models.enums.Sorte;
import ca.ntro.cards.common.models.values.cards.AbstractCard;
import ca.ntro.cards.arraylist.ArraylistConstants;
import ca.ntro.cards.models.world2d.ProcedureCard2d;

public class ArraylistCard2d extends ProcedureCard2d<ArraylistProcedureWorld2d, ArraylistProcedureDrawingOptions> {

	public ArraylistCard2d() {
		super();
	}


	public ArraylistCard2d(String card2dId, AbstractCard card) {
		super(card2dId, card);
	}

	public ArraylistCard2d(int rank, Sorte suit) {
		super(rank, suit);
	}

	@Override
	protected double initialWidth() {
		return ArraylistConstants.INITIAL_CARD_WIDTH_MILIMETERS;
	}

	@Override
	protected double initialHeight() {
		return ArraylistConstants.INITIAL_CARD_HEIGHT_MILIMETERS;
	}

}
