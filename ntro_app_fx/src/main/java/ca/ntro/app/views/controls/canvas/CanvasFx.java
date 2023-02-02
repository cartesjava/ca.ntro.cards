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

import ca.ntro.app.frontend.views.controls.canvas.Canvas;
import ca.ntro.app.frontend.views.controls.canvas.CanvasDrawingLambda;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CanvasFx extends ResizableCanvas implements Canvas<GraphicsContext, javafx.scene.canvas.Canvas, Image, Font, Color, CanvasFx> {
	
	private CanvasNtroFx canvasNtroFx = new CanvasNtroFx(new GraphicsContextFx(getGc()), this);

	@Override
	protected void initialize() {
	}

	@Override
	protected void onInitialSize(double initialWidth, double initialHeight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onNewSize(double oldWidth, double oldHeight, double newWidth, double newHeight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public javafx.scene.canvas.Canvas getRawCanvas() {
		return getCanvas();
	}


	@Override
	public double canvasWidth() {
		return getWidth();
	}

	@Override
	public double canvasHeight() {
		return getHeight();
	}

	@Override
	public void drawOnCanvas(CanvasDrawingLambda<GraphicsContext, javafx.scene.canvas.Canvas, Image, Font, Color, CanvasFx> lambda) {
		canvasNtroFx.drawOnCanvas(lambda);
	}

	@Override
	public void clearCanvas() {
		canvasNtroFx.clearCanvas();
	}


}
