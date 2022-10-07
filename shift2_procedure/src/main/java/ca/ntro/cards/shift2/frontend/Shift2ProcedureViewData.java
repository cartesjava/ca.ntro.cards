package ca.ntro.cards.shift2.frontend;

import ca.ntro.cards.common.models.values.cards.AbstractCard;
import ca.ntro.cards.shift2.models.world2d.Shift2Card2d;
import ca.ntro.cards.shift2.models.world2d.Shift2ProcedureDrawingOptions;
import ca.ntro.cards.shift2.models.world2d.Shift2ProcedureWorld2d;
import ca.ntro.cards.frontend.ProcedureViewData;
import ca.ntro.cards.models.world2d.ProcedureCard2d;

public class Shift2ProcedureViewData extends ProcedureViewData<Shift2ProcedureWorld2d, Shift2ProcedureDrawingOptions> {

	@Override
	protected Shift2ProcedureWorld2d newWorld2d() {
		return new Shift2ProcedureWorld2d();
	}

	@Override
	protected ProcedureCard2d newCard2d(String card2dId, AbstractCard card) {
		return new Shift2Card2d(card2dId, card);
	}

	@Override
	protected Shift2ProcedureDrawingOptions defaultDrawingOptions() {
		return new Shift2ProcedureDrawingOptions() {
			@Override
			public boolean useFourCardColors() {
				return true;
			}
		};
	}


}
