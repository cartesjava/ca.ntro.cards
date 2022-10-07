package ca.ntro.cards.shift2.models;

import ca.ntro.cards.shift2.frontend.views.Shift2ProcedureSettingsView;
import ca.ntro.cards.shift2.models.world2d.Shift2ProcedureDrawingOptions;
import ca.ntro.cards.models.ProcedureSettingsModel;

public class Shift2ProcedureSettingsModel extends ProcedureSettingsModel<Shift2ProcedureSettingsView, 
                                                                       Shift2ProcedureDrawingOptions> 

       implements Shift2ProcedureDrawingOptions {

	@Override
	public Shift2ProcedureDrawingOptions drawingOptions() {
		return this;
	}

	@Override
	public boolean useFourCardColors() {
		return getUseFourCardColors();
	}

}
