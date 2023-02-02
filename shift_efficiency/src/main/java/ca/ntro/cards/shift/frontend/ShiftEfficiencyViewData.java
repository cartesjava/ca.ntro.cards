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
