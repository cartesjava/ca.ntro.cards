package ca.ntro.cards.examen2.models.gr2;

import java.io.Serializable;

import ca.ntro.app.models.Value;

public class Vehicule implements Value, Serializable {

	private static final long serialVersionUID = 3454473885806311965L;
	
	private int kilometrage;
	private Groupe membreDe;

	public int getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}

	public Groupe getMembreDe() {
		return membreDe;
	}

	public void setMembreDe(Groupe membreDe) {
		this.membreDe = membreDe;
	}
}
