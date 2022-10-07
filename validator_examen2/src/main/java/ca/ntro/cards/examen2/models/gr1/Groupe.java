package ca.ntro.cards.examen2.models.gr1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Value;

public class Groupe implements Value, Serializable {

	private static final long serialVersionUID = 7652375886254187874L;

	private List<Object> membres = new ArrayList<>();
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
