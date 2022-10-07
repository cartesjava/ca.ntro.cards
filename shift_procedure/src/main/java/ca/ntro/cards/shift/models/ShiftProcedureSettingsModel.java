package ca.ntro.cards.shift.models;

import ca.ntro.cards.shift.frontend.views.ShiftProcedureSettingsView;
import ca.ntro.cards.shift.models.world2d.ShiftProcedureDrawingOptions;
import ca.ntro.cards.models.ProcedureSettingsModel;

public class ShiftProcedureSettingsModel extends ProcedureSettingsModel<ShiftProcedureSettingsView, 
                                                                       ShiftProcedureDrawingOptions> 

       implements ShiftProcedureDrawingOptions {

	@Override
	public ShiftProcedureDrawingOptions drawingOptions() {
		return this;
	}

	@Override
	public boolean useFourCardColors() {
		return getUseFourCardColors();
	}

}
