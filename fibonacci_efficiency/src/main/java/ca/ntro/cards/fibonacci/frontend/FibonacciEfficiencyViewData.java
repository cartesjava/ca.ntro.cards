package ca.ntro.cards.fibonacci.frontend;

import ca.ntro.cards.fibonacci.models.world2d.FibonacciEfficiencyDrawingOptions;
import ca.ntro.cards.fibonacci.models.world2d.FibonacciEfficiencyObject2d;
import ca.ntro.cards.fibonacci.models.world2d.FibonacciEfficiencyWorld2d;
import ca.ntro.cards.efficiency.frontend.EfficiencyViewData;

public class   FibonacciEfficiencyViewData 

       extends EfficiencyViewData<FibonacciEfficiencyObject2d, 
                                  FibonacciEfficiencyWorld2d,
                                  FibonacciEfficiencyDrawingOptions> {

	@Override
	protected FibonacciEfficiencyWorld2d newWorld2d() {
		return new FibonacciEfficiencyWorld2d();
	}

	@Override
	protected FibonacciEfficiencyDrawingOptions defaultDrawingOptions() {
		return new FibonacciEfficiencyDrawingOptions() {
			@Override
			public boolean useFourCardColors() {
				return true;
			}
		};
	}

}
