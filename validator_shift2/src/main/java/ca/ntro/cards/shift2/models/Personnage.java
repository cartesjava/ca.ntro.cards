package ca.ntro.cards.shift2.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Value;

public class Personnage implements Value, Serializable {

	private static final long serialVersionUID = 1135958079857874576L;

	private String nom;

	private List<Film> films = new ArrayList<>();

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
