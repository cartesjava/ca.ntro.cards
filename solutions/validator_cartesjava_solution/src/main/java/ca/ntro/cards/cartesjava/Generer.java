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
package ca.ntro.cards.cartesjava;

import ca.ntro.app.NtroClientFx;
import ca.ntro.cards.cartesjava.GenererShift;
import ca.ntro.cards.cartesjava.models.MonTableau01;
import ca.ntro.cards.cartesjava.models.MonTableau02;
import ca.ntro.cards.cartesjava.models.MonTableau03;
import ca.ntro.cards.cartesjava.models.PersonnageObjet01;
import ca.ntro.cards.cartesjava.models.PersonnageObjet02;
import ca.ntro.cards.cartesjava.models.PersonnageObjet03;
import ca.ntro.cards.cartesjava.models.PersonnageTableau01;
import ca.ntro.cards.cartesjava.models.PersonnageTableau02;
import ca.ntro.cards.cartesjava.models.PersonnageTableau03;
import ca.ntro.cards.cartesjava.models.Arbre01;
import ca.ntro.cards.cartesjava.models.Carte01;
import ca.ntro.cards.cartesjava.models.Carte02;
import ca.ntro.cards.cartesjava.models.Carte03;
import ca.ntro.cards.cartesjava.models.CartesJavaModel;
import ca.ntro.cards.cartesjava.models.FilmGraphe01;
import ca.ntro.cards.cartesjava.models.FilmObjet01;
import ca.ntro.cards.cartesjava.models.FilmObjet02;
import ca.ntro.cards.cartesjava.models.FilmTableau01;
import ca.ntro.cards.cartesjava.models.FilmTableau02;
import ca.ntro.cards.cartesjava.models.ListeChaineeDouble01;
import ca.ntro.cards.cartesjava.models.ListeChaineeSimple01;
import ca.ntro.cards.validator.Validator;

public class Generer extends GenererShift {

	public static void main(String[] args) {
		NtroClientFx.launch(args);
	}

	@Override
	protected void validateModels(Validator<CartesJavaModel> validator) {
		validator.validateModel(Carte01.class);
		validator.validateModel(Carte02.class);
		validator.validateModel(Carte03.class);

		validator.validateModel(MonTableau01.class);
		validator.validateModel(MonTableau02.class);
		validator.validateModel(MonTableau03.class);


		validator.validateModel(FilmObjet01.class);
		validator.validateModel(FilmObjet02.class);
		validator.validateModel(PersonnageObjet01.class);
		validator.validateModel(PersonnageObjet02.class);
		validator.validateModel(PersonnageObjet03.class);

		validator.validateModel(FilmTableau01.class);
		validator.validateModel(FilmTableau02.class);

		validator.validateModel(PersonnageTableau01.class);
		validator.validateModel(PersonnageTableau02.class);
		validator.validateModel(PersonnageTableau03.class);

		validator.validateModel(FilmGraphe01.class);

		validator.validateModel(ListeChaineeSimple01.class);
		validator.validateModel(ListeChaineeDouble01.class);
		validator.validateModel(Arbre01.class);
	}
}
