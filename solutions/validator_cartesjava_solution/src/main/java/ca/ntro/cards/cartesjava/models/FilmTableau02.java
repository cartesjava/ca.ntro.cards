package ca.ntro.cards.cartesjava.models;

import java.util.ArrayList;
import java.util.List;

public class FilmTableau02 extends FilmTableau {

	@Override
	public void initialiser() {
		setTitre("Bons Baisers de Russie");
		setAnnee(1963);

		PersonnageObjet rosa = new PersonnageObjet();
		rosa.setNom("Rosa Klebb");
		rosa.setPersonnagePrincipal(false);

		PersonnageObjet bond = new PersonnageObjet();
		bond.setNom("James Bond");
		bond.setPersonnagePrincipal(true);

		List<PersonnageObjet> personnagesBaisers = new ArrayList<>();
		personnagesBaisers.add(bond);
		personnagesBaisers.add(rosa);
		
		setPersonnages(personnagesBaisers);
	}

}
