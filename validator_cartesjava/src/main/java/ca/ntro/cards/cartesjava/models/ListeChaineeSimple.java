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


public class ListeChaineeSimple<E extends Object> extends ListeJava<E> {
	
	private int taille = 0;
	private MaillonSimple<E> tete = null;

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public MaillonSimple<E> getTete() {
		return tete;
	}

	public void setTete(MaillonSimple<E> tete) {
		this.tete = tete;
	}

	public ListeChaineeSimple() {
	}

	public ListeChaineeSimple(Class<E> typeElement) {
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
	
	private MaillonSimple<E> atteindreElement(int position) {
		MaillonSimple<E> element = tete;
		
		for(int i = 0; i < position; i++) {
			if(element != null) {
				element = element.suivant();
			}
		}

		return element;
	}

	@Override
	public void insert(int position, E e) {
		if(position == 0) {

			MaillonSimple<E> nouvelleTete = new MaillonSimple<E>(e);
			nouvelleTete.setSuivant(tete);

			tete = nouvelleTete;

		}else {
			
			MaillonSimple<E> element = atteindreElement(position - 1);
			element.insererApres(e);

		}

		taille++;
	}

	@Override
	public void set(int position, E e) {
		MaillonSimple<E> element = atteindreElement(position);
		
		element.set(e);
	}

	@Override
	public E get(int position) {
		MaillonSimple<E> element = atteindreElement(position);

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
		
		MaillonSimple<E> curseur = tete;
		
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
		
		if(tete != null && tete.valeur().equals(o)) {

			remove(0);
			
		}else if(tete != null){

			retirerValeurApresTete(o);

		}
	}

	private void retirerValeurApresTete(Object o) {

		MaillonSimple<E> curseur = tete;

		for(int i = 1; i < taille; i++) {

			MaillonSimple<E> suivant = curseur.suivant();

			if(suivant != null && suivant.valeur().equals(o)) {

				retirerElementApres(curseur);

			}else if(suivant != null) {

				curseur = suivant;

			}else {

				break;
			}
		}
	}
	
	private void retirerElementApres(MaillonSimple<E> curseur) {
		if(curseur.suivant() != null) {
			curseur.setSuivant(curseur.suivant().suivant());
		}
		
		taille--;
	}

	@Override
	public void remove(int position) {
		if(position == 0) {

			tete = tete.suivant();
			taille--;
			
		}else {

			MaillonSimple<E> curseur = atteindreElement(position - 1);
			retirerElementApres(curseur);
		}
	}

	@Override
	public void copyDataFrom(ListeJava<E> other) {
		ListeChaineeSimple otherList = (ListeChaineeSimple) other;
		setTaille(otherList.taille);
		setTete(otherList.tete);
	}

	@Override
	public void initialiser() {
	}
}