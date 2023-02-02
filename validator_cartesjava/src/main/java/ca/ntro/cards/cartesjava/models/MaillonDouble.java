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

public class MaillonDouble<E> implements Serializable {

	private static final long serialVersionUID = -6831819160978397522L;

	private E valeur;

	private MaillonDouble<E> suivant = this;
	private MaillonDouble<E> precedent = this;

	public E getValeur() {
		return valeur;
	}

	public void setValeur(E valeur) {
		this.valeur = valeur;
	}

	public MaillonDouble<E> getSuivant() {
		return suivant;
	}

	public MaillonDouble<E> getPrecedent() {
		return precedent;
	}

	public MaillonDouble() {
	}

	public MaillonDouble(E e) {
		this.valeur = e;
	}

	public MaillonDouble(MaillonDouble<E> precedent, E e, MaillonDouble<E> suivant) {
		this.precedent = precedent;
		this.valeur = e;
		this.suivant = suivant;
	}


	public MaillonDouble<E> suivant() {
		return suivant;
	}

	public MaillonDouble<E> precedent() {
		return precedent;
	}

	public E valeur() {
		return valeur;
	}
	
	public void set(E e) {
		this.valeur = e;
	}
	
	public void setSuivant(MaillonDouble<E> suivant) {
		this.suivant = suivant;
	}
	
	public void setPrecedent(MaillonDouble<E> precedent) {
		this.precedent = precedent;
	}
	
	public void insererAvant(E e) {
		if(valeur == null) {
			valeur = e;
		}else {
			insererElementAvant(e);
		}
	}

	private void insererElementApres(E e) {
		
		// this : b
		// this.suivant : d
		// nouveau c

		MaillonDouble<E> nouveau = new MaillonDouble<E>(this.precedent, e, this);
		
		// c -> d
		nouveau.setSuivant(this.suivant);
		
		// c <- d
		this.suivant.setPrecedent(nouveau);
		
		// b <- c
		nouveau.setPrecedent(this);
		
		// b -> c
		// À LA FIN!	
		this.setSuivant(nouveau);

	}

	private void insererElementAvant(E e) {
		MaillonDouble<E> nouveau = new MaillonDouble<E>(this.precedent, e, this);
		if(precedent != this) {
			this.precedent.setSuivant(nouveau);
		}

		this.precedent = nouveau;

		if(this.suivant == this) {
			this.suivant = nouveau;
		}
	}

	public boolean contient(Object o) {
		boolean contient = false;
		
		if(valeur != null && valeur.equals(o)) {
			contient = true;

		}else if(valeur == null && o == null) {
			contient = true;
		}
		
		return contient;
	}

}
