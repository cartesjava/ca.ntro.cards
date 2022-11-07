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
package ca.ntro.app.world2d;

import ca.ntro.app.frontend.views.controls.canvas.Canvas;
import ca.ntro.app.frontend.views.controls.canvas.GraphicsContext;
import ca.ntro.app.models.Value;
import ca.ntro.core.data_structures.trees.region_tree.Region2d;

public interface Object2d<RAW_GC extends Object,
                          RAW_CANVAS extends Object, 
                          RAW_IMAGE extends Object,
                          RAW_FONT extends Object,
                          RAW_COLOR extends Object,
                          CANVAS extends Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS>,

                          GC extends GraphicsContext<RAW_GC, 
                                                     RAW_CANVAS, 
                                                     RAW_IMAGE,
                                                     RAW_FONT,
                                                     RAW_COLOR,
                                                     CANVAS>,

						  OBJECT2D extends Object2dNtro<RAW_GC, 
														RAW_CANVAS, 
														RAW_IMAGE,
														RAW_FONT,
														RAW_COLOR,
														CANVAS,
													    GC,
														OBJECT2D,
														WORLD2D,
														OPTIONS>,

					      WORLD2D  extends World2d<RAW_GC, 
											       RAW_CANVAS, 
											       RAW_IMAGE, 
												   RAW_FONT,
												   RAW_COLOR,
												   CANVAS,
												   GC,
												   OBJECT2D,
												   WORLD2D,
												   OPTIONS>,

					      OPTIONS extends DrawingOptions> 

      extends Region2d, Value {
                                                    	 
                                                    	 
     WORLD2D world();

	 double speedX(); 
	 double speedY(); 

}
