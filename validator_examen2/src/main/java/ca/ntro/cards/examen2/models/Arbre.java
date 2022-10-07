package ca.ntro.cards.examen2.models;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.core.reflection.object_graph.Initialize;

public abstract class Arbre extends Examen2Model<Arbre> implements Initialize {

	private static final long serialVersionUID = 1418431208450635339L;
	
	private Arbre gauche = null;
	private Arbre droite = null;
	private int n;


	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public Arbre getGauche() {
		return gauche;
	}

	public void setGauche(Arbre gauche) {
		this.gauche = gauche;
	}

	public Arbre getDroite() {
		return droite;
	}

	public void setDroite(Arbre droite) {
		this.droite = droite;
	}

	@Override
	public void copyDataFrom(Arbre other) {
		this.n = other.n;
		this.gauche = other.gauche;
		this.droite = other.droite;
	}


}
