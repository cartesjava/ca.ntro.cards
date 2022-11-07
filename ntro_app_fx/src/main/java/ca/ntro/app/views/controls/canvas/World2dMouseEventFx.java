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

import ca.ntro.app.frontend.views.controls.canvas.World2dGraphicsContext;
import ca.ntro.app.frontend.views.controls.canvas.World2dMouseEvent;
import javafx.scene.input.MouseEvent;

public class World2dMouseEventFx implements World2dMouseEvent<MouseEvent> {
	
	private MouseEvent rawMouseEvent;
	private World2dCanvasNtroFx world2dCanvasFx;
	private double worldX;
	private double worldY;

	@SuppressWarnings("rawtypes")
	public World2dMouseEventFx(MouseEvent rawMouseEvent, 
			                   World2dCanvasNtroFx world2dCanvasFx, 
			                   double worldX, 
			                   double worldY) {
		
		this.rawMouseEvent = rawMouseEvent;
		this.world2dCanvasFx = world2dCanvasFx;
		this.worldX = worldX;
		this.worldY = worldY;
	}

	@Override
	public MouseEvent rawMouseEvent() {
		return rawMouseEvent;
	}

	@Override
	public double canvasX() {
		return rawMouseEvent.getX();
	}

	@Override
	public double canvasY() {
		return rawMouseEvent.getY();
	}

	@Override
	public double worldX() {
		return worldX;
	}

	@Override
	public double worldY() {
		return worldY;
	}

	@Override
	public double worldWidth() {
		return world2dCanvasFx.worldWidth();
	}

	@Override
	public double worldHeight() {
		return world2dCanvasFx.worldHeight();
	}

	@Override
	public double viewportTopLeftX() {
		return world2dCanvasFx.viewportTopLeftX();
	}

	@Override
	public double viewportTopLeftY() {
		return world2dCanvasFx.viewportTopLeftY();
	}

	@Override
	public double viewportWidth() {
		return world2dCanvasFx.viewportWidth();
	}

	@Override
	public double viewportHeight() {
		return world2dCanvasFx.getViewportHeight();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public double widthOnScreen(double widthInWorld) {
		return ((World2dGraphicsContext) world2dCanvasFx.getGraphicsContext()).widthOnScreen(widthInWorld);

	}

	@Override
	public double heightOnScreen(double heightInWorld) {
		return ((World2dGraphicsContext) world2dCanvasFx.getGraphicsContext()).heightOnScreen(heightInWorld);
	}

	@Override
	public double widthInWorld(double widthOnScreen) {
		return ((World2dGraphicsContext) world2dCanvasFx.getGraphicsContext()).widthInWorld(widthOnScreen);
	}

	@Override
	public double heightInWorld(double heightOnScreen) {
		return ((World2dGraphicsContext) world2dCanvasFx.getGraphicsContext()).heightInWorld(heightOnScreen);
	}

}
