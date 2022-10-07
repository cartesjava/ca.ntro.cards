package ca.ntro.cards.shift2.models;

import ca.ntro.cards.shift2.frontend.views.Shift2EfficiencySettingsView;
import ca.ntro.cards.shift2.models.world2d.Shift2EfficiencyDrawingOptions;
import ca.ntro.cards.efficiency.models.EfficiencySettingsModel;

public class Shift2EfficiencySettingsModel extends EfficiencySettingsModel<Shift2EfficiencySettingsView, 
                                                                         Shift2EfficiencyDrawingOptions> 

             implements Shift2EfficiencyDrawingOptions {

	@Override
	public Shift2EfficiencyDrawingOptions drawingOptions() {
		return this;
	}

	@Override
	public boolean useFourCardColors() {
		return getUseFourCardColors();
	}

	@Override
	public void displayOn(Shift2EfficiencySettingsView settingsView) {
	}

}
