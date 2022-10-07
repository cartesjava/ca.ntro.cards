package ca.ntro.cards.fibonacci.models;

import ca.ntro.cards.fibonacci.frontend.views.FibonacciProcedureSettingsView;
import ca.ntro.cards.fibonacci.models.world2d.FibonacciProcedureDrawingOptions;
import ca.ntro.cards.models.ProcedureSettingsModel;

public class FibonacciProcedureSettingsModel extends ProcedureSettingsModel<FibonacciProcedureSettingsView, 
                                                                       FibonacciProcedureDrawingOptions> 

       implements FibonacciProcedureDrawingOptions {

	@Override
	public FibonacciProcedureDrawingOptions drawingOptions() {
		return this;
	}

	@Override
	public boolean useFourCardColors() {
		return getUseFourCardColors();
	}

}
