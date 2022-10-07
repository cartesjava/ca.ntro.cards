package ca.ntro.cards.shift.frontend;

import ca.ntro.cards.common.models.values.cards.AbstractCard;
import ca.ntro.cards.shift.models.world2d.ShiftCard2d;
import ca.ntro.cards.shift.models.world2d.ShiftProcedureDrawingOptions;
import ca.ntro.cards.shift.models.world2d.ShiftProcedureWorld2d;
import ca.ntro.cards.frontend.ProcedureViewData;
import ca.ntro.cards.models.world2d.ProcedureCard2d;

public class ShiftProcedureViewData extends ProcedureViewData<ShiftProcedureWorld2d, ShiftProcedureDrawingOptions> {

	@Override
	protected ShiftProcedureWorld2d newWorld2d() {
		return new ShiftProcedureWorld2d();
	}

	@Override
	protected ProcedureCard2d newCard2d(String card2dId, AbstractCard card) {
		return new ShiftCard2d(card2dId, card);
	}

	@Override
	protected ShiftProcedureDrawingOptions defaultDrawingOptions() {
		return new ShiftProcedureDrawingOptions() {
			@Override
			public boolean useFourCardColors() {
				return true;
			}
		};
	}


}
