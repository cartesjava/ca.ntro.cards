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

import ca.ntro.app.frontend.views.controls.canvas.CanvasDrawingLambda;
import ca.ntro.app.frontend.views.controls.canvas.World2dCanvas;
import ca.ntro.app.world2d.Object2dFx;
import ca.ntro.app.world2d.DrawingOptions;
import ca.ntro.app.world2d.World2dFx;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public abstract class World2dCanvasFx<OBJECT2D extends Object2dFx<OBJECT2D, WORLD2D, OPTIONS>,
                                      WORLD2D  extends World2dFx<OBJECT2D, WORLD2D, OPTIONS>,
                                      OPTIONS extends DrawingOptions> 

       extends  Canvas 

       implements World2dCanvas<GraphicsContext, 
                                Canvas, 
                                Image, 
                                Font, 
                                Color,
                                AbstractWorld2dCanvasFx<OBJECT2D, WORLD2D, OPTIONS>,
                                World2dGraphicsContextFx<OBJECT2D, WORLD2D, OPTIONS>,
                                OBJECT2D,
                                WORLD2D,
                                OPTIONS>,
       
                  AbstractWorld2dCanvasFx<OBJECT2D, WORLD2D, OPTIONS> {
	
	private World2dCanvasNtroFx<OBJECT2D, WORLD2D, OPTIONS> canvasNtroFx = new World2dCanvasNtroFx<OBJECT2D,WORLD2D, OPTIONS>(new World2dGraphicsContextFx<OBJECT2D, WORLD2D, OPTIONS>(getGraphicsContext2D(), this), this);

	public <T extends MouseEvent> void addMouseEventFilter(EventType<T> eventType, MouseEventHandlerFx handler) {
		addEventFilter(eventType, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				canvasNtroFx.handleMouseEvent(event, handler);
			}
		});
	}

	@Override
	public Canvas getRawCanvas() {
		return this;
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
	public double worldWidth() {
		return canvasNtroFx.worldWidth();
	}

	@Override
	public double worldHeight() {
		return canvasNtroFx.worldHeight();
	}

	@Override
	public double viewportWidth() {
		return canvasNtroFx.getViewportWidth();
	}

	@Override
	public double viewportHeight() {
		return canvasNtroFx.getViewportHeight();
	}

	@Override
	public void drawOnWorld(CanvasDrawingLambda<GraphicsContext, Canvas, Image, Font, Color, AbstractWorld2dCanvasFx<OBJECT2D, WORLD2D, OPTIONS>> lambda) {
		canvasNtroFx.drawOnWorld(lambda);
	}

	@Override
	public void drawOnViewport(CanvasDrawingLambda<GraphicsContext, Canvas, Image, Font, Color, AbstractWorld2dCanvasFx<OBJECT2D, WORLD2D, OPTIONS>> lambda) {
		canvasNtroFx.drawOnViewport(lambda);
	}

	@Override
	public void drawOnCanvas(CanvasDrawingLambda<GraphicsContext, Canvas, Image, Font, Color, AbstractWorld2dCanvasFx<OBJECT2D, WORLD2D, OPTIONS>> lambda) {
		canvasNtroFx.drawOnCanvas(lambda);
	}

	@Override
	public void clearViewport() {
		canvasNtroFx.clearViewport();
	}

	@Override
	public void clearWorld() {
		canvasNtroFx.clearWorld();
	}
	
	@Override
	public void clearCanvas() {
		canvasNtroFx.clearCanvas();
	}

	@Override
	public void displayWorld2d(WORLD2D world2d, OPTIONS options) {
		canvasNtroFx.displayWorld2d(world2d, options);
	}

	@Override
	public double viewportTopLeftX() {
		return canvasNtroFx.getViewportTopLeftX();
	}

	@Override
	public double viewportTopLeftY() {
		return canvasNtroFx.getViewportTopLeftY();
	}

	@Override
	public void resizeViewport(double incrementX, double incrementY) {
		canvasNtroFx.resizeViewport(incrementX, incrementY);
	}

	@Override
	public void relocateViewport(double topLeftX, double topLeftY) {
		canvasNtroFx.relocateViewport(topLeftX, topLeftY);
	}

	@Override
	public void relocateResizeViewport(double topLeftX, double topLeftY, double width, double height) {
		canvasNtroFx.relocateResizeViewport(topLeftX, topLeftY, width, height);
	}

	public void setWorldWidth(double worldWidth) {
		canvasNtroFx.setWorldWidth(worldWidth);
	}

	public void setWorldHeight(double worldHeight) {
		canvasNtroFx.setWorldHeight(worldHeight);
	}


}
