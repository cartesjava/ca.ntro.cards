package ca.ntro.cards.shift2.models;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import ca.ntro.cards.validator.models.ValidatorModel;

public class Film extends Shift2Model<Film> {

	private static final long serialVersionUID = 3710180538800463658L;

	private String titre;

	private List<Personnage> personnages = new ArrayList<>();

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Personnage> getPersonnages() {
		return personnages;
	}

	public void setPersonnages(List<Personnage> personnages) {
		this.personnages = personnages;
	}

	@Override
	public void copyDataFrom(Film other) {
		this.titre = other.titre;
		this.personnages = other.personnages;
	}

}
