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
package ca.ntro.cards.common.models.values.cards;

import java.io.Serializable;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.views.controls.canvas.World2dGraphicsContext;
import ca.ntro.app.models.Value;
import ca.ntro.cards.common.models.identifyers.IdFactory;
import ca.ntro.cards.common.models.world2d.CommonDrawingOptions;
import ca.ntro.core.identifyers.Identifiable;

public abstract class AbstractCard<OPTIONS extends CommonDrawingOptions> 


       implements Value, Identifiable, Comparable<AbstractCard>, Serializable {

	private static final long serialVersionUID = 7116211713513539219L;

	@SuppressWarnings("rawtypes")
	public void drawFaceDown(World2dGraphicsContext gc, 
			                    double topLeftX, 
			                    double topLeftY, 
			                    double width, 
			                    double height, 
			                    int levelOfDetails, 
			                    OPTIONS options) {

		if(levelOfDetails > 5) {

			drawFaceDownHighDetails(gc, topLeftX, topLeftY, width, height, options);

		}else {

			drawFaceDownLowDetails(gc, topLeftX, topLeftY, width, height, options);

		}
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void drawFaceDownLowDetails(World2dGraphicsContext gc, 
			                            double topLeftX, 
			                            double topLeftY, 
			                            double width, 
			                            double height, 
			                            OPTIONS options) {
		
		gc.setFill(NtroApp.colorFromString("#aaaaaa"));
		gc.fillRect(topLeftX, 
					topLeftY,
					width, 
					height);
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void drawFaceDownHighDetails(World2dGraphicsContext gc, 
			                  double topLeftX, 
			                  double topLeftY, 
			                  double width, 
			                  double height, 
			                  OPTIONS options) {
		
		gc.setFill(NtroApp.colorFromString("#999999"));
		gc.fillRect(topLeftX, 
					topLeftY,
					width, 
					height);

		gc.setStroke(NtroApp.colorFromString("#000000"));
		gc.strokeRect(topLeftX, 
					  topLeftY,
					  width, 
					  height);
	}


	public abstract void drawFaceUp(World2dGraphicsContext gc, 
			                           double topLeftX, 
			                           double topLeftY, 
			                           double width, 
			                           double height, 
			                           int levelOfDetails, 
			                           OPTIONS options);

	public abstract boolean isNullCard();

	@Override
	public boolean hasId(String id) {
		return String.valueOf(this.id()).equals(id);
	}

	public abstract void format(StringBuilder builder);

}
