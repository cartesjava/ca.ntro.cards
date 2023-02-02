package ca.ntro.cards.cartesjava.models;

import java.util.ArrayList;
import java.util.List;

public class FilmTableau01 extends FilmTableau {

	@Override
	public void initialiser() {
		setTitre("Dr. No");
		setAnnee(1962);

		PersonnageObjet drNo = new PersonnageObjet();
		drNo.setNom("Docteur No");
		drNo.setPersonnagePrincipal(false);

		PersonnageObjet bond = new PersonnageObjet();
		bond.setNom("James Bond");
		bond.setPersonnagePrincipal(true);

		List<PersonnageObjet> personnagesDrNo = new ArrayList<>();
		personnagesDrNo.add(bond);
		personnagesDrNo.add(drNo);
		
		setPersonnages(personnagesDrNo);

	}

}
