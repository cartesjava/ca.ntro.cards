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

public abstract class Noeud<C extends Comparable<C>> implements Serializable {

	private static final long serialVersionUID = 5294945827668308719L;

	protected abstract Noeud<C> nouveauNoeud(C valeur, Noeud<C> parent);
	protected abstract Noeud<C> nouveauNoeud(C valeur);

	public abstract void inserer(C valeur);
	
	protected Noeud<C> parent;
	protected Noeud<C> enfantGauche;
	protected Noeud<C> enfantDroit;
	protected C valeur;

	public Noeud<C> getEnfantGauche() {
		return enfantGauche;
	}
	public void setEnfantGauche(Noeud<C> enfantGauche) {
		this.enfantGauche = enfantGauche;
	}
	
	
	public Noeud<C> getEnfantDroit() {
		return enfantDroit;
	}

	public void setEnfantDroit(Noeud<C> enfantDroit) {
		this.enfantDroit = enfantDroit;
	}

	public C getValeur() {
		return valeur;
	}

	public void setValeur(C valeur) {
		this.valeur = valeur;
	}

	public Noeud() {
		super();
	}
	
	public Noeud(C valeur) {
		setValeur(valeur);
	}

	public Noeud(C valeur, Noeud<C> parent) {
		setValeur(valeur);
		enregistrerParent(parent);
	}

	protected int hauteur(Noeud<C> noeud) {
		int hauteur = 0;
		
		if(noeud != null) {
		
			int hauteurGauche = hauteur(noeud.enfantGauche());
			int hauteurDroite = hauteur(noeud.enfantDroit());
			
			hauteur =  1 + Math.max(hauteurGauche, hauteurDroite);
		}

		return hauteur;
	}

	protected void equilibrer() {

		int differenceHauteurs = hauteur(enfantGauche()) - hauteur(enfantDroit());
		
		if(differenceHauteurs >= 2) {
			
			rotationGaucheDroite();
			
		}else if(differenceHauteurs <= -2) {

			rotationDroiteGauche();

		}else if(parent() != null){
			parent().equilibrer();
		}
	}

	private void rotationGaucheDroite(){
		C prochaineValeurRacine = enfantGauche().valeur();
		C prochaineValeurDroite = valeur();
		Noeud<C> prochainEnfantGauche = enfantGauche().enfantGauche();
		Noeud<C> prochainEnfantDroiteGauche = enfantGauche().enfantDroit();
		Noeud<C> prochainEnfantDroiteDroite = enfantDroit();
		
		setValeur(prochaineValeurRacine);
		setEnfantDroit(nouveauNoeud(prochaineValeurDroite, this));
		setEnfantGauche(prochainEnfantGauche);
		if(prochainEnfantGauche != null) {
			prochainEnfantGauche.enregistrerParent(this);
		}

		enfantDroit().setEnfantGauche(prochainEnfantDroiteGauche);
		if(prochainEnfantDroiteGauche != null) {
			prochainEnfantDroiteGauche.enregistrerParent(enfantDroit());
		}
		enfantDroit().setEnfantDroit(prochainEnfantDroiteDroite);
		if(prochainEnfantDroiteDroite != null) {
			prochainEnfantDroiteDroite.enregistrerParent(enfantDroit());
		}
	}

	private void rotationDroiteGauche(){
		C prochaineValeurRacine = enfantDroit().valeur();
		C prochaineValeurGauche = valeur();
		Noeud<C> prochainEnfantDroit = enfantDroit().enfantDroit();
		Noeud<C> prochainEnfantGaucheDroite = enfantDroit().enfantGauche();
		Noeud<C> prochainEnfantGaucheGauche = enfantGauche();
		
		setValeur(prochaineValeurRacine);
		setEnfantGauche(nouveauNoeud(prochaineValeurGauche, this));
		setEnfantDroit(prochainEnfantDroit);
		if(prochainEnfantDroit != null) {
			prochainEnfantDroit.enregistrerParent(this);
		}

		enfantGauche().setEnfantDroit(prochainEnfantGaucheDroite);
		if(prochainEnfantGaucheDroite != null) {
			prochainEnfantGaucheDroite.enregistrerParent(enfantGauche());
		}
		enfantGauche().setEnfantGauche(prochainEnfantGaucheGauche);
		if(prochainEnfantGaucheGauche != null) {
			prochainEnfantGaucheGauche.enregistrerParent(enfantGauche());
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("<ul>");
		if(enfantDroit() != null) {
		builder.append(enfantDroit());
		}
		builder.append("<li>");
		builder.append(valeur());
		builder.append("</li>");
		if(enfantGauche() != null) {
			builder.append(enfantGauche());
		}
		builder.append("</ul>");
		
		return builder.toString();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		boolean siEgal = false;
		
		if(o instanceof Noeud) {
			siEgal = siEgal((Noeud<C>) o);
		}
		
		return siEgal;
	}
	
	private boolean siEgal(Noeud<C> n) {
		boolean siEgal = false;
		
		if(valeur() != null && valeur().equals(n.valeur())) {

			boolean gaucheEgal = false;
			boolean droiteEgal = false;
			
			if(enfantGauche() != null && enfantGauche().equals(n.enfantGauche())) {
				gaucheEgal = true;
			}else if(enfantGauche() == null && n.enfantGauche() == null) {
				gaucheEgal = true;
			}
			
			if(enfantDroit() != null && enfantDroit().equals(n.enfantDroit())) {
				droiteEgal = true;
			}else if(enfantDroit() == null && n.enfantDroit() == null) {
				droiteEgal = true;
			}

			siEgal = gaucheEgal && droiteEgal;
			
		}else if(valeur() == null && n.valeur() == null) {

			siEgal = true;
		}

		return siEgal;
	}

	public boolean siFeuille() {
		return enfantDroit() == null && enfantGauche() == null;
	}
	
	private void retirerEnfant(Noeud<C> aRetirer) {
		if(enfantDroit() == aRetirer) {
			
			setEnfantDroit(null);
			
		}else if(enfantGauche() == aRetirer) {
			
			setEnfantGauche(null);
		}
	}

	public void seRetirer() {
		if(siFeuille() && parent() != null){

			parent().retirerEnfant(this);

		}else {

			remplacerParDernierEnfant();

		}
	}
	
	private void remplacerParDernierEnfant() {
		
		Noeud<C> aRetirer = null;
		
		if(enfantDroit() != null && hauteur(enfantDroit()) > hauteur(enfantGauche())) {
			
			aRetirer = enfantDroit().enfantLePlusAGauche();
			
		}else if(enfantGauche() != null){

			aRetirer = enfantGauche().enfantLePlusADroite();
			
		}
		
		if(aRetirer != null) {

			setValeur(aRetirer.valeur());
			aRetirer.seRetirer();
		}
	}
	
	private Noeud<C> enfantLePlusADroite() {
		Noeud<C> lePlusADroite = this;
		
		if(enfantDroit() != null) {
			
			lePlusADroite = enfantDroit().enfantLePlusADroite();
		}
		
		return lePlusADroite;
	}

	private Noeud<C> enfantLePlusAGauche() {

		Noeud<C> lePlusAGauche = this;
		
		if(enfantGauche() != null) {

			lePlusAGauche = enfantGauche().enfantLePlusAGauche();
		}
		
		return lePlusAGauche;
	}

	public Noeud<C> parent() {
		return parent;
	}

	public Noeud<C> enfantGauche() {
		return getEnfantGauche();
	}

	public Noeud<C> enfantDroit() {
		return getEnfantDroit();
	}

	public C valeur() {
		return getValeur();
	}

	protected void enregistrerParent(Noeud<C> parent) {
		this.parent = parent;
	}

}
