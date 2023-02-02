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

import ca.ntro.app.frontend.views.controls.canvas.CanvasNtro;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CanvasNtroFx extends CanvasNtro<GraphicsContext, javafx.scene.canvas.Canvas, Image, Font, Color, CanvasFx> {
	
	private CanvasFx canvasFx;

	public CanvasFx getCanvasFx() {
		return canvasFx;
	}

	public void setCanvasFx(CanvasFx canvasFx) {
		this.canvasFx = canvasFx;
	}
	
	public CanvasNtroFx(GraphicsContextFx graphicsContext, CanvasFx canvasFx) {
		setGraphicsContext(graphicsContext);
		setCanvasFx(canvasFx);
	}

	@Override
	public javafx.scene.canvas.Canvas getRawCanvas() {
		return getCanvasFx().getRawCanvas();
	}

	@Override
	public double canvasWidth() {
		return getCanvasFx().canvasWidth();
	}

	@Override
	public double canvasHeight() {
		return getCanvasFx().canvasHeight();
	}

	@Override
	public void clearCanvas() {
		drawOnCanvas(gc -> {

			gc.clearRect(0,0,canvasWidth(), canvasHeight());

		});
	}

}
