/*
Copyright (C) (2022) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)

This file is part of "Cartes Java", teaching tools made for https://cartesjava.github.io/

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

*/
package ca.ntro.cards.cartesjava.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Value;

public class PersonnageGraphe extends CartesJavaModel<PersonnageGraphe> implements Value, Serializable {

	private static final long serialVersionUID = 1135958079857874576L;

	private String nom;
	private boolean personnagePrincipal;

	private List<FilmGraphe> films = new ArrayList<>();

	public List<FilmGraphe> getFilms() {
		return films;
	}

	public void setFilms(List<FilmGraphe> films) {
		this.films = films;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean getPersonnagePrincipal() {
		return personnagePrincipal;
	}

	public void setPersonnagePrincipal(boolean personnagePrincipal) {
		this.personnagePrincipal = personnagePrincipal;
	}

	@Override
	public void copyDataFrom(PersonnageGraphe other) {
		this.nom = other.nom;
		this.personnagePrincipal = other.personnagePrincipal;
		this.films = other.films;
	}

}
