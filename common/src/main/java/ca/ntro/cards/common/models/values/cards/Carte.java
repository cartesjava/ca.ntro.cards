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
import ca.ntro.app.frontend.views.elements.Color;
import ca.ntro.cards.common.models.enums.Sorte;
import ca.ntro.cards.common.models.world2d.CommonDrawingOptions;
import ca.ntro.core.identifyers.Identifiable;

public class   Carte<OPTIONS extends CommonDrawingOptions> 

       extends AbstractCard<OPTIONS> {

	private static final long serialVersionUID = 233385517377324484L;

	private long numero = 2;
	private Sorte sorte = Sorte.COEUR;

	public long getNumero() {
		return numero;
	}

	public void setNumero(long rank) {
		this.numero = rank;
	}
	public Sorte getSorte() {
		return sorte;
	}

	public void setSorte(Sorte suit) {
		this.sorte = suit;
	}

	public Carte() {
		super();
	}

	public Carte(long numero, Sorte sorte) {
		super();
		setNumero(numero);
		setSorte(sorte);
	}
	
	@Override
	public String id() {
		return String.valueOf(numero) + "_" + sorte.name();
	}

	@SuppressWarnings("rawtypes")
	private Color color(OPTIONS options) {
		return NtroApp.colorFromString(sorte.color(options));
	}


	@SuppressWarnings("rawtypes")
	public void drawFaceUp(World2dGraphicsContext gc, 
			               double topLeftX, 
			               double topLeftY, 
			               double width, 
			               double height, 
			               int levelOfDetails, 
			               OPTIONS options) {

		if(levelOfDetails > 5) {

			drawFaceUpHighDetails(gc, topLeftX, topLeftY, width, height, options);

		}else {

			drawFaceUpLowDetails(gc, topLeftX, topLeftY, width, height, options);
			
		}
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void drawFaceUpHighDetails(World2dGraphicsContext gc, 
			                     double topLeftX, 
			                     double topLeftY, 
			                     double width, 
			                     double height, 
			                     OPTIONS options) {
		
		gc.translate(topLeftX, topLeftY);
		
		gc.setFill(NtroApp.colorFromString("#fff0db"));
		gc.fillRect(0, 
					0,
					width, 
					height);
		
		gc.setFill(color(options));
		gc.setStroke(color(options));

		gc.strokeText(String.valueOf(numero) + " " + sorte.getSymbol(), width / 4, height / 3);
		gc.fillText(String.valueOf(numero) + " " + sorte.getSymbol(), width / 4, height / 3);

		gc.strokeRect(0, 
					  0,
					  width, 
					  height);
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void drawFaceUpLowDetails(World2dGraphicsContext gc, 
			                    double topLeftX, 
			                    double topLeftY, 
			                    double width, 
			                    double height, 
			                    OPTIONS options) {
		
		gc.setFill(color(options));

		gc.fillRect(topLeftX, 
					topLeftY,
					width, 
					height);
	}

	@Override
	public int compareTo(AbstractCard otherCard) {
		int result = 0;
		
		if(otherCard instanceof NullCard) {

			result = -1;

		}else {
			
			result = compareTo((Carte) otherCard);
			
		}
		
		return result;

	}

	private int compareTo(Carte otherCard) {
		int result = 0;
		
		if(sorte.equals(otherCard.sorte)) {

			result = Long.compare(numero, otherCard.numero);

		}else {
			
			result = Integer.compare(sorte.ordinal(), otherCard.sorte.ordinal());
			
		}

		return result;

	}

	@Override
	public boolean isNullCard() {
		return false;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		format(builder);
		
		return builder.toString();
	}
	
	@Override
	public void format(StringBuilder builder) {
		builder.append(numero);
		builder.append(sorte.getSymbol());
	}

	public boolean hasSuit(Sorte suit) {
		return this.sorte.equals(suit);
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == this) return true;
		if(other == null) return false;
		if(other instanceof Carte) {
			Carte otherCard = (Carte) other;
			
			return this.sorte.equals(otherCard.sorte)
					&& this.numero == otherCard.numero;
		}
		
		return false;
	}
	
	public Carte clone() {
		Carte clone = new Carte(numero, sorte);
		return clone;
	}
}
