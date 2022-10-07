package ca.ntro.cards.naivesort.models.world2d;

import ca.ntro.cards.common.models.enums.Sorte;
import ca.ntro.cards.common.models.values.cards.AbstractCard;
import ca.ntro.cards.naivesort.NaivesortConstants;
import ca.ntro.cards.models.world2d.ProcedureCard2d;

public class NaivesortCard2d extends ProcedureCard2d<NaivesortProcedureWorld2d, NaivesortProcedureDrawingOptions> {

	public NaivesortCard2d() {
		super();
	}


	public NaivesortCard2d(String card2dId, AbstractCard card) {
		super(card2dId, card);
	}

	public NaivesortCard2d(int rank, Sorte suit) {
		super(rank, suit);
	}

	@Override
	protected double initialWidth() {
		return NaivesortConstants.INITIAL_CARD_WIDTH_MILIMETERS;
	}

	@Override
	protected double initialHeight() {
		return NaivesortConstants.INITIAL_CARD_HEIGHT_MILIMETERS;
	}



	@Override
	protected void flipCard() {
		super.flipCard();
		
		getWorld().registerFlippedCard(this);
	}


}
