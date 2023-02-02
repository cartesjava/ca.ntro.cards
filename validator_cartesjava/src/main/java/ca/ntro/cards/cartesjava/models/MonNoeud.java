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

public class MonNoeud<C extends Comparable<C>> extends Noeud<C> {

	public MonNoeud() {
		super();
	}

	public MonNoeud(C valeur) {
		super(valeur);
	}

	public MonNoeud(C valeur, Noeud<C> parent) {
		super(valeur, parent);
	}


	@Override
	public void inserer(C valeur) {
		if(valeur.compareTo(getValeur()) < 0) {
			
			insererVersLaGauche(valeur);
			
		}else if(valeur.compareTo(getValeur()) > 0) {
			
			insererVersLaDroite(valeur);

		}else {

			memoriserNouvelleValeurIci(valeur);

		}
	}

	private void memoriserNouvelleValeurIci(C valeur) {
		setValeur(valeur);
	}

	private void insererVersLaGauche(C valeur) {
		if(getEnfantGauche() == null) {
			
			setEnfantGauche(new MonNoeud<C>(valeur,this));
			equilibrer();

		}else {
			
			getEnfantGauche().inserer(valeur);
			
		}

	}

	private void insererVersLaDroite(C valeur) {
		if(getEnfantDroit() == null) {
			
			setEnfantDroit(new MonNoeud<C>(valeur,this));
			equilibrer();
			
		}else {
			
			getEnfantDroit().inserer(valeur);
		}

	}

	@Override
	protected Noeud<C> nouveauNoeud(C valeur, Noeud<C> parent) {
		return new MonNoeud<C>(valeur, parent);
	}

	@Override
	protected Noeud<C> nouveauNoeud(C valeur) {
		return new MonNoeud<C>(valeur);
	}

}
