package ca.ntro.cards.shift.frontend;

import ca.ntro.cards.shift.models.world2d.ShiftEfficiencyDrawingOptions;
import ca.ntro.cards.shift.models.world2d.ShiftEfficiencyObject2d;
import ca.ntro.cards.shift.models.world2d.ShiftEfficiencyWorld2d;
import ca.ntro.cards.efficiency.frontend.EfficiencyViewData;

public class   ShiftEfficiencyViewData 

       extends EfficiencyViewData<ShiftEfficiencyObject2d, 
                                  ShiftEfficiencyWorld2d,
                                  ShiftEfficiencyDrawingOptions> {

	@Override
	protected ShiftEfficiencyWorld2d newWorld2d() {
		return new ShiftEfficiencyWorld2d();
	}

	@Override
	protected ShiftEfficiencyDrawingOptions defaultDrawingOptions() {
		return new ShiftEfficiencyDrawingOptions() {
			@Override
			public boolean useFourCardColors() {
				return true;
			}
		};
	}

}
