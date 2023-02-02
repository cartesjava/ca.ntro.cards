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
package ca.ntro.cards.common.frontend;


import ca.ntro.app.frontend.ViewData;
import ca.ntro.app.views.controls.canvas.World2dMouseEventFx;
import ca.ntro.cards.common.frontend.utils.FpsCounter;
import ca.ntro.cards.common.frontend.views.CommonCanvasView;
import ca.ntro.cards.common.frontend.views.CommonDashboardView;
import ca.ntro.cards.common.models.world2d.CommonDrawingOptions;
import ca.ntro.cards.common.models.world2d.CommonObject2d;
import ca.ntro.cards.common.models.world2d.CommonWorld2d;

public abstract class CommonViewData<OBJECT2D extends CommonObject2d<OBJECT2D, WORLD2D, OPTIONS>,
                                     WORLD2D  extends CommonWorld2d<OBJECT2D, WORLD2D, OPTIONS>,
                                     OPTIONS  extends CommonDrawingOptions>

       implements     ViewData {
	
	protected WORLD2D              world2d = newWorld2d();
	private   FpsCounter           fpsCounter = new FpsCounter();
	private   OPTIONS options = defaultDrawingOptions();
	
	protected abstract WORLD2D newWorld2d();

	protected abstract OPTIONS defaultDrawingOptions();

	protected WORLD2D world2d() {
		return world2d;
	}
	
	public void setDrawingOptions(OPTIONS options) {
		this.options = options;
	}

	public void onTimePasses(double secondsElapsed) {

		world2d.onTimePasses(secondsElapsed);
	}

	public void displayOn(CommonCanvasView canvasView, 
			              CommonDashboardView dashboardView) {

		fpsCounter.onNewFrame();

		canvasView.clearCanvas();
		canvasView.displayViewport();
		canvasView.displayWorld2d(world2d, options);

		dashboardView.displayFps(String.format("FPS %.0f", fpsCounter.currentFps()));
	}

	public void dispatchMouseEvent(World2dMouseEventFx world2dMouseEventFx) {
		world2d.dispatchMouseEvent(world2dMouseEventFx);
	}


}
