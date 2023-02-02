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
package ca.ntro.cards.frontend.events;

import ca.ntro.app.frontend.events.EventNtro;
import ca.ntro.app.frontend.views.controls.canvas.World2dMouseEvent;
import ca.ntro.app.views.controls.canvas.World2dMouseEventFx;
import ca.ntro.cards.common.frontend.views.CommonCanvasView;
import javafx.scene.input.MouseEvent;

public class MouseEvtOnPreviewCanvas extends EventNtro {
	
	private World2dMouseEventFx world2dMouseEventFx;

	public World2dMouseEventFx getWorld2dMouseEventFx() {
		return world2dMouseEventFx;
	}

	public void setWorld2dMouseEventFx(World2dMouseEventFx world2dMouseEventFx) {
		this.world2dMouseEventFx = world2dMouseEventFx;
	}


	public void applyTo(CommonCanvasView gameView) {
		gameView.mouseEvtOnTabletop(world2dMouseEventFx);
	}

}
