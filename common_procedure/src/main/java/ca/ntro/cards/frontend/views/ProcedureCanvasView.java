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
package ca.ntro.cards.frontend.views;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.controls.canvas.World2dCanvasFx;
import ca.ntro.cards.common.frontend.views.CommonCanvasView;
import ca.ntro.cards.common.models.world2d.CommonDrawingOptions;
import ca.ntro.cards.common.models.world2d.CommonWorld2d;
import ca.ntro.cards.frontend.events.MouseEvtOnPreviewCanvas;
import javafx.scene.input.MouseEvent;

public abstract class ProcedureCanvasView extends CommonCanvasView {

	@SuppressWarnings("rawtypes")
	protected abstract World2dCanvasFx previewCanvas();

	protected abstract double initialPreviewCanvasScreenHeight();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);

		initializePreviewCanvas();
	}

	@SuppressWarnings("unchecked")
	private void initializePreviewCanvas() {

		double screenHeight = initialPreviewCanvasScreenHeight();
		double screenWidth = screenHeight * initialWorldWidth() / initialWorldHeight();

		previewCanvas().setWidth(screenWidth);
		previewCanvas().setHeight(screenHeight);

		previewCanvas().setWorldWidth(initialWorldWidth());
		previewCanvas().setWorldHeight(initialWorldHeight());

		previewCanvas().relocateResizeViewport(0, 0, initialWorldWidth(), initialWorldHeight());

		MouseEvtOnPreviewCanvas mouseEvtOnTabletop = NtroApp.newEvent(MouseEvtOnPreviewCanvas.class);
		
		previewCanvas().addMouseEventFilter(MouseEvent.ANY, world2dMouseEventFx -> {
			
			mouseEvtOnTabletop.setWorld2dMouseEventFx(world2dMouseEventFx);
			mouseEvtOnTabletop.trigger();

		});
	}

	@SuppressWarnings("unchecked")
	public void displayWorld2d(CommonWorld2d world2d, CommonDrawingOptions options) {
		super.displayWorld2d(world2d, options);
		previewCanvas().displayWorld2d(world2d, options);
	}

	public void clearCanvas() {
		super.clearCanvas();
		previewCanvas().clearCanvas();
	}

	@SuppressWarnings("unchecked")
	public void displayViewport() {
		previewCanvas().drawOnWorld(gc -> {

			gc.strokeRect(mainCanvas().viewportTopLeftX(),
					      mainCanvas().viewportTopLeftY(),
					      mainCanvas().viewportWidth(),
					      mainCanvas().viewportHeight());
		});
	}

}
