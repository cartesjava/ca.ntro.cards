package ca.ntro.cards.shift.models;

import ca.ntro.cards.shift.frontend.views.ShiftEfficiencySettingsView;
import ca.ntro.cards.shift.models.world2d.ShiftEfficiencyDrawingOptions;
import ca.ntro.cards.efficiency.models.EfficiencySettingsModel;

public class ShiftEfficiencySettingsModel extends EfficiencySettingsModel<ShiftEfficiencySettingsView, 
                                                                         ShiftEfficiencyDrawingOptions> 

             implements ShiftEfficiencyDrawingOptions {

	@Override
	public ShiftEfficiencyDrawingOptions drawingOptions() {
		return this;
	}

	@Override
	public boolean useFourCardColors() {
		return getUseFourCardColors();
	}

	@Override
	public void displayOn(ShiftEfficiencySettingsView settingsView) {
	}

}
