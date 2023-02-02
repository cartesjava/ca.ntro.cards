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

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import ca.ntro.cards.validator.models.ValidatorModel;
import ca.ntro.core.reflection.object_graph.Initialize;

public class FilmTableau extends CartesJavaModel<FilmTableau> implements Initialize {

	private static final long serialVersionUID = 3710180538800463658L;

	private String titre;
	private int annee;

	private List<PersonnageObjet> personnages = new ArrayList<>();

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public List<PersonnageObjet> getPersonnages() {
		return personnages;
	}

	public void setPersonnages(List<PersonnageObjet> personnages) {
		this.personnages = personnages;
	}

	@Override
	public void copyDataFrom(FilmTableau other) {
		this.titre = other.titre;
		this.annee = other.annee;
		this.personnages = other.personnages;
	}

	@Override
	public void initialiser() {
	}

}
