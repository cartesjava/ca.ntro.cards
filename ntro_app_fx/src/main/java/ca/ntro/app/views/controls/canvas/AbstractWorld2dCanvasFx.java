/*
Copyright (C) (2020) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)

This file is part of Ntro, an application framework designed with teaching in mind.

This is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

*/
package ca.ntro.app.views.controls.canvas;

import ca.ntro.app.frontend.views.controls.canvas.World2dCanvas;
import ca.ntro.app.world2d.Object2dFx;
import ca.ntro.app.world2d.DrawingOptions;
import ca.ntro.app.world2d.World2dFx;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public interface AbstractWorld2dCanvasFx<OBJECT2D extends Object2dFx<OBJECT2D, WORLD2D, OPTIONS>,
                                         WORLD2D  extends World2dFx<OBJECT2D, WORLD2D, OPTIONS>,
                                         OPTIONS extends DrawingOptions> 

       extends World2dCanvas<GraphicsContext, 
                             Canvas, 
                             Image, 
                             Font, 
                             Color,
                             AbstractWorld2dCanvasFx<OBJECT2D, WORLD2D, OPTIONS>,
                             World2dGraphicsContextFx<OBJECT2D, WORLD2D, OPTIONS>,
                             OBJECT2D,
                             WORLD2D,
                             OPTIONS> {


}
