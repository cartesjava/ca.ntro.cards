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
package ca.ntro.cards.efficiency.frontend;

import ca.ntro.cards.common.frontend.CommonViewData;
import ca.ntro.cards.efficiency.models.world2d.EfficiencyDrawingOptions;
import ca.ntro.cards.efficiency.models.world2d.EfficiencyObject2d;
import ca.ntro.cards.efficiency.models.world2d.EfficiencyWorld2d;

public abstract class   EfficiencyViewData<OBJECT2D extends EfficiencyObject2d<OBJECT2D, WORLD2D, OPTIONS>,
                                          WORLD2D  extends EfficiencyWorld2d<OBJECT2D, WORLD2D, OPTIONS>,
                                          OPTIONS  extends EfficiencyDrawingOptions> 

                extends CommonViewData<OBJECT2D, WORLD2D, OPTIONS> {

}
