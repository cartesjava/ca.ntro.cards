package ca.ntro.cards.examen2.models.gr2;

import java.io.Serializable;
import java.util.List;

import ca.ntro.app.models.Value;

public class Groupe implements Value, Serializable {
	
	private static final long serialVersionUID = 2068341846339754164L;

	private List<Object> membres;
	
	private String nom;

	public List<Object> getMembres() {
		return membres;
	}

	public void setMembres(List<Object> membres) {
		this.membres = membres;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


}
