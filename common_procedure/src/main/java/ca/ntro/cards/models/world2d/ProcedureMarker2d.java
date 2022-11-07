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
import ca.ntro.app.frontend.views.controls.canvas.World2dGraphicsContext;
import ca.ntro.app.frontend.views.elements.Color;

public class   ProcedureMarker2d<WORLD2D  extends ProcedureWorld2d<WORLD2D, OPTIONS>,
                                 OPTIONS  extends ProcedureDrawingOptions>

       extends ProcedureObject2d<WORLD2D, OPTIONS> {
	
	private String id;
	private String color;
	
	private transient Color ntroColor;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
		this.ntroColor = NtroApp.colorFromString(color);
	}

	public ProcedureMarker2d(String id) {
		setId(id);
		setColor("#03cffc");
	}

	public ProcedureMarker2d(String id, String color) {
		setId(id);
		setColor(color);
	}

	@Override
	public String id() {
		return getId();
	}

	@Override
	public void draw(World2dGraphicsContext gc, OPTIONS options) {

		gc.setFill(ntroColor);
		gc.fillArc(getTopLeftX(), 
				   getTopLeftY(), 
				   getWidth(), 
				   getHeight(), 
				   0, 
				   360);

	}

	@Override
	public void initialize() {
		setWidth(25);
		setHeight(25);
	}
}
