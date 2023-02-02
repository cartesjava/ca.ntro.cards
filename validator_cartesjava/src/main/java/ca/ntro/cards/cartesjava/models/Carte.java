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
package ca.ntro.cards.cartesjava.models;

import java.io.Serializable;

import ca.ntro.app.models.Value;
import ca.ntro.cards.validator.models.ValidatorModel;
import ca.ntro.core.reflection.object_graph.Initialize;

public class Carte extends CartesJavaModel<Carte> implements Value, Serializable, Initialize {

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
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		format(builder);
		
		return builder.toString();
	}
	
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

	@Override
	public void copyDataFrom(Carte other) {
		setSorte(other.sorte);
		setNumero(other.numero);
	}

	@Override
	public void initialiser() {

	}

}
