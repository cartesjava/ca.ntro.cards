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
package ca.ntro.cards.cartesjava.models;

import java.io.Serializable;

public class MaillonSimple<E> implements Serializable {

	private static final long serialVersionUID = 2767411799748862985L;

	private E valeur;

	private MaillonSimple<E> suivant = null;

	public E getValeur() {
		return valeur;
	}

	public void setValeur(E valeur) {
		this.valeur = valeur;
	}

	public MaillonSimple<E> getSuivant() {
		return suivant;
	}

	public MaillonSimple() {
	}

	public MaillonSimple(E e) {
		this.valeur = e;
	}

	public MaillonSimple<E> suivant() {
		return suivant;
	}

	public E valeur() {
		return valeur;
	}
	
	public void set(E e) {
		this.valeur = e;
	}
	
	public void setSuivant(MaillonSimple<E> suivant) {
		this.suivant = suivant;
	}
	
	public void insererApres(E e) {
		
		MaillonSimple<E> nouveau = new MaillonSimple<E>(e);
		
		if(suivant != null) {
			nouveau.setSuivant(suivant);
		}

		suivant = nouveau;
	}
}
