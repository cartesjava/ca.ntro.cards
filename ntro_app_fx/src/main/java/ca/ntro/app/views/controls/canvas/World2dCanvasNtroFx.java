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

import ca.ntro.app.frontend.views.controls.canvas.World2dCanvasNtro;
import ca.ntro.app.world2d.Object2dFx;
import ca.ntro.app.world2d.DrawingOptions;
import ca.ntro.app.world2d.World2dFx;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class World2dCanvasNtroFx<OBJECT2D extends Object2dFx<OBJECT2D, WORLD2D, OPTIONS>,
                                 WORLD2D  extends World2dFx<OBJECT2D, WORLD2D, OPTIONS>, 
                                 OPTIONS extends DrawingOptions> 

       extends World2dCanvasNtro<GraphicsContext, 
                                 Canvas, 
                                 Image, 
                                 Font, 
                                 Color,
                                 AbstractWorld2dCanvasFx<OBJECT2D, WORLD2D, OPTIONS>,
                                 World2dGraphicsContextFx<OBJECT2D, WORLD2D, OPTIONS>,
                                 OBJECT2D,
                                 WORLD2D,
                                 OPTIONS> {
	
	private Canvas rawCanvas;

	public World2dCanvasNtroFx(World2dGraphicsContextFx<OBJECT2D, WORLD2D, OPTIONS> graphicsContext, Canvas rawCanvas) {
		setGraphicsContext(graphicsContext);
		this.rawCanvas = rawCanvas;
	}

	@Override
	public Canvas getRawCanvas() {
		return rawCanvas;
	}

	@Override
	public double canvasWidth() {
		return rawCanvas.getWidth();
	}

	@Override
	public double canvasHeight() {
		return rawCanvas.getHeight();
	}

	public void handleMouseEvent(MouseEvent event, MouseEventHandlerFx handler) {
		double x = event.getX();
		double y = event.getY();
		
		// FIXME: should simply memorize the transform outside
		//        of the graphicsContext
		setWorld2dTransform();

		double mxx = getGraphicsContext().getRawGraphicsContext().getTransform().getMxx();
		double myy = getGraphicsContext().getRawGraphicsContext().getTransform().getMyy();
		double tx = getGraphicsContext().getRawGraphicsContext().getTransform().getTx();
		double ty = getGraphicsContext().getRawGraphicsContext().getTransform().getTy();
		
		double worldX = (x - tx) / mxx;
		double worldY = (y - ty) / myy;
		
		World2dMouseEventFx mouseEventFx = new World2dMouseEventFx(event, 
				                                                   this,
				                                                   worldX,
				                                                   worldY);
		
		handler.handle(mouseEventFx);
	}




}
