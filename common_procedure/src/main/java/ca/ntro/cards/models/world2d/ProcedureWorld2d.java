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
package ca.ntro.cards.models.world2d;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.controls.canvas.World2dMouseEventFx;
import ca.ntro.cards.common.frontend.events.EvtMoveViewport;
import ca.ntro.cards.common.models.world2d.CommonWorld2d;
import javafx.scene.input.MouseEvent;

public abstract class ProcedureWorld2d<WORLD2D  extends ProcedureWorld2d<WORLD2D, OPTIONS>,
                                       OPTIONS  extends ProcedureDrawingOptions>

       extends CommonWorld2d<ProcedureObject2d<WORLD2D,OPTIONS>, WORLD2D, OPTIONS> {

	private ProcedureObject2d<WORLD2D, OPTIONS> draggedObject2d = null;

	private double anchorX;
	private double anchorY;
	private EvtMoveViewport evtMoveViewport = NtroApp.newEvent(EvtMoveViewport.class);

	@Override
	protected void onMouseEventNotConsumed(World2dMouseEventFx mouseEvent) {
		MouseEvent evtFx = mouseEvent.rawMouseEvent();
		double worldX = mouseEvent.worldX();
		double worldY = mouseEvent.worldY();

		if(draggedObject2d != null 
				&& evtFx.getEventType().equals(MouseEvent.MOUSE_DRAGGED)
				&& evtFx.isPrimaryButtonDown()) {

			draggedObject2d.dragTo(worldX, worldY);

		}else if(draggedObject2d != null 
				&& evtFx.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
			
			forgetDraggedObject2d();

		}else if(draggedObject2d == null 
				&& evtFx.getEventType().equals(MouseEvent.MOUSE_PRESSED)
				&& evtFx.isMiddleButtonDown()) {
			
			anchorX = evtFx.getX();
			anchorY = evtFx.getY();

		}else if(draggedObject2d == null 
				&& evtFx.getEventType().equals(MouseEvent.MOUSE_DRAGGED)
				&& evtFx.isMiddleButtonDown()) {
			
			evtMoveViewport.setIncrementX(mouseEvent.widthInWorld(anchorX - evtFx.getX()));
			evtMoveViewport.setIncrementY(mouseEvent.heightInWorld(anchorY - evtFx.getY()));

			anchorX = evtFx.getX();
			anchorY = evtFx.getY();
			
			evtMoveViewport.trigger();
		}
	}

	protected void forgetDraggedObject2d() {
		draggedObject2d = null;
		buildAndSendManualModel();
	}

	public void registerDraggedObject2d(ProcedureObject2d<WORLD2D, OPTIONS> object2d) {
		this.draggedObject2d = object2d;
	}

	public abstract void buildAndSendManualModel();
}
