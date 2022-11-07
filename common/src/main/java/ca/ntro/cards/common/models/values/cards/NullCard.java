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

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.views.controls.canvas.World2dGraphicsContext;
import ca.ntro.cards.common.models.identifyers.IdFactory;
import ca.ntro.cards.common.models.world2d.CommonDrawingOptions;

public class NullCard<OPTIONS extends CommonDrawingOptions> extends AbstractCard<OPTIONS> {
	
	private long id = -1;
	
	public NullCard() {
		super();
		
		this.id = IdFactory.nextId();
	}

	@Override
	public int compareTo(AbstractCard otherCard) {
		if(otherCard instanceof NullCard) {
			return 0;
			
		}else {

			return +1;
			
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void drawFaceUp(World2dGraphicsContext gc, 
			               double topLeftX, 
			               double topLeftY, 
			               double width, 
			               double height, 
			               int levelOfDetails, 
			               OPTIONS options) {

			gc.setFill(NtroApp.colorFromString("#ffffff"));

			gc.fillRect(topLeftX, 
					    topLeftY,
					    width,
					    height);

			gc.strokeRect(topLeftX, 
					      topLeftY,
					      width,
					      height);

			/*
			gc.strokeArc(getTopLeftX() + getWidth()/2 - getWidth()/8, 
					     getTopLeftY() + getHeight()/2 - getWidth()/8,
					     getWidth()/4,
					     getWidth()/4,
					     0,
					     360);
					     */
			
			/*
			gc.fillText("null", 
					    getTopLeftX() + getWidth() / 2 - 16, 
					    getTopLeftY() + getHeight() / 2);
			*/

		
	}

	@Override
	public boolean isNullCard() {
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		format(builder);
		
		return builder.toString();
	}

	@Override
	public void format(StringBuilder builder) {
		builder.append("NullCard");
	}

	@Override
	public String id() {
		return String.valueOf(id);
	}

}
