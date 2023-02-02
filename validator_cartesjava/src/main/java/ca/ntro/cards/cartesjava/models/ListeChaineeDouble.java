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


public class ListeChaineeDouble<E extends Object> extends ListeJava<E> implements Serializable {
	
	private int taille = 0;
	private MaillonDouble<E> tete = null;

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public MaillonDouble<E> getTete() {
		return tete;
	}

	public void setTete(MaillonDouble<E> tete) {
		this.tete = tete;
	}

	public ListeChaineeDouble() {
		super();
	}

	public ListeChaineeDouble(Class<E> typeElement) {
		super(typeElement);
	}

	@Override
	public void add(E e) {
		insert(size(), e);
	}

	@Override
	public void addAll(E[] valeurs_a_ajouter) {
		for(E e : valeurs_a_ajouter) {
			add(e);
		}
	}
	
	private MaillonDouble<E> atteindreElement(int position) {
		MaillonDouble<E> element = null;
		
		if(position < taille/2) {
			element = atteindreElementVersAvant(position);
		}else {
			element = atteindreElementVersArriere(taille - position);
		}

		return element;
	}

	private MaillonDouble<E> atteindreElementVersAvant(int distance) {
		MaillonDouble<E> element = tete;
		
		for(int i = 0; i < distance; i++) {
			if(element != null) {
				element = element.suivant();
			}
		}
		
		return element;
	}

	private MaillonDouble<E> atteindreElementVersArriere(int distance) {
		MaillonDouble<E> element = tete;

		for(int i = 0; i < distance; i++) {
			if(element != null) {
				element = element.precedent();
			}
		}

		return element;
	}

	@Override
	public void insert(int position, E e) {
		if(position == 0) {
			
			MaillonDouble<E> nouvelleTete = new MaillonDouble<E>(e);

			if(tete != null) {
				
				nouvelleTete.setSuivant(tete);
				nouvelleTete.setPrecedent(tete.precedent());
				
				tete.getPrecedent().setSuivant(nouvelleTete);
				tete.setPrecedent(nouvelleTete);
			}
			
			tete = nouvelleTete;

		}else {

			MaillonDouble<E> element = atteindreElement(position);
			
			element.insererAvant(e);
		}

		taille++;
	}
	@Override
	public void set(int position, E e) {
		MaillonDouble<E> element = atteindreElement(position);
		
		element.set(e);
	}
	@Override
	public E get(int position) {
		MaillonDouble<E> element = atteindreElement(position);

		return element.valeur();
	}
	@Override
	public void clear() {
		tete = null;
		taille = 0;
	}
	@Override
	public int size() {
		return taille;
	}
	@Override
	public boolean isEmpty() {
		return taille == 0;
	}
	@Override
	public boolean contains(Object o) {
		int indice = indexOf(o);
		boolean contains = false;
		
		if(indice >= 0) {
			contains = true;
			
		}

		return contains;
	}


	@Override
	public int indexOf(Object o) {
		int indice = -1;
		
		MaillonDouble<E> curseur = tete;
		
		for(int i = 0; i < taille; i++) {
			if(curseur != null && curseur.valeur().equals(o)) {
				indice = i;
				break;
				
			}else if(curseur != null) {
				curseur = curseur.suivant();
			}else {
				break;
			}
		}

		return indice;
	}

	@Override
	public void removeValue(Object o) {

		MaillonDouble<E> curseur = tete;
		
		for(int i = 0; i < taille; i++) {
			if(curseur != null && curseur.valeur().equals(o)) {
				retirerElement(curseur);
				break;
			}else if(curseur != null){
				curseur = curseur.suivant();
			}else {
				break;
			}
		}
	}
	
	private void retirerElement(MaillonDouble<E> element) {
		element.precedent().setSuivant(element.suivant());
		element.suivant().setPrecedent(element.precedent());
		
		if(element == tete) {
			tete = element.suivant();
		}
		
		taille--;
	}

	@Override
	public void remove(int position) {
		MaillonDouble<E> element = atteindreElement(position);
		
		retirerElement(element);
	}

	@Override
	public void copyDataFrom(ListeJava<E> other) {
		ListeChaineeDouble otherList = (ListeChaineeDouble) other;
		setTaille(otherList.taille);
		setTete(otherList.tete);
	}

	@Override
	public void initialiser() {
	}

}
