package ca.ntro.cards.fibonacci.models;

import ca.ntro.cards.fibonacci.frontend.views.FibonacciEfficiencySettingsView;
import ca.ntro.cards.fibonacci.models.world2d.FibonacciEfficiencyDrawingOptions;
import ca.ntro.cards.efficiency.models.EfficiencySettingsModel;

public class FibonacciEfficiencySettingsModel extends EfficiencySettingsModel<FibonacciEfficiencySettingsView, 
                                                                         FibonacciEfficiencyDrawingOptions> 

             implements FibonacciEfficiencyDrawingOptions {

	@Override
	public FibonacciEfficiencyDrawingOptions drawingOptions() {
		return this;
	}

	@Override
	public boolean useFourCardColors() {
		return getUseFourCardColors();
	}

	@Override
	public void displayOn(FibonacciEfficiencySettingsView settingsView) {
	}

}
