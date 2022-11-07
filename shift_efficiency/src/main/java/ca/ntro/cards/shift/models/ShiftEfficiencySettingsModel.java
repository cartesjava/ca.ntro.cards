/*
Copyright (C) (2022) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)

This file is part of "Cartes Java", teaching tools made for https://cartesjava.github.io/

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

*/
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
