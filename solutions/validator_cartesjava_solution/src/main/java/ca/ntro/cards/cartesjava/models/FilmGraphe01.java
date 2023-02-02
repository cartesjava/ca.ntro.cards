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

import ca.ntro.core.reflection.object_graph.Initialize;

public class FilmGraphe01 extends FilmGraphe implements Initialize {

	@Override
	public void initialiser() {
		setTitre("Dr. No");
		setAnnee(1962);
		
		PersonnageGraphe drNo = new PersonnageGraphe();
		drNo.setNom("Docteur No");
		drNo.setPersonnagePrincipal(false);
		drNo.setFilms(List.of(new FilmGraphe[] {this}));
		
		FilmGraphe baisers = new FilmGraphe();
		baisers.setTitre("Bons Baisers de Russie");
		baisers.setAnnee(1963);

		PersonnageGraphe rosa = new PersonnageGraphe();
		rosa.setNom("Rosa Klebb");
		rosa.setPersonnagePrincipal(false);
		rosa.setFilms(List.of(new FilmGraphe[] {baisers}));

		PersonnageGraphe bond = new PersonnageGraphe();
		bond.setNom("James Bond");
		bond.setPersonnagePrincipal(true);
		bond.setFilms(List.of(new FilmGraphe[] {this, baisers}));
		
		List<PersonnageGraphe> personnagesDrNo = new ArrayList<>();
		personnagesDrNo.add(bond);
		personnagesDrNo.add(drNo);

		List<PersonnageGraphe> personnagesBaisers = new ArrayList<>();
		personnagesBaisers.add(bond);
		personnagesBaisers.add(rosa);
		
		setPersonnages(personnagesDrNo);
		baisers.setPersonnages(personnagesBaisers);
	}

}
