package ca.ntro.cards.shift2.frontend;

import ca.ntro.cards.shift2.models.world2d.Shift2EfficiencyDrawingOptions;
import ca.ntro.cards.shift2.models.world2d.Shift2EfficiencyObject2d;
import ca.ntro.cards.shift2.models.world2d.Shift2EfficiencyWorld2d;
import ca.ntro.cards.efficiency.frontend.EfficiencyViewData;

public class   Shift2EfficiencyViewData 

       extends EfficiencyViewData<Shift2EfficiencyObject2d, 
                                  Shift2EfficiencyWorld2d,
                                  Shift2EfficiencyDrawingOptions> {

	@Override
	protected Shift2EfficiencyWorld2d newWorld2d() {
		return new Shift2EfficiencyWorld2d();
	}

	@Override
	protected Shift2EfficiencyDrawingOptions defaultDrawingOptions() {
		return new Shift2EfficiencyDrawingOptions() {
			@Override
			public boolean useFourCardColors() {
				return true;
			}
		};
	}

}
