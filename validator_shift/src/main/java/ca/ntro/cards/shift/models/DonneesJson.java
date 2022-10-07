package ca.ntro.cards.shift.models;

import java.util.HashMap;
import java.util.Map;

public class DonneesJson extends ShiftModel<DonneesJson> {

	private static final long serialVersionUID = 8295201566647831760L;

	protected Map<String, Object> racine = new HashMap<>();

	public Map<String, Object> getRacine() {
		return racine;
	}

	public void setRacine(Map<String, Object> racine) {
		this.racine = racine;
	}

	@Override
	public void copyDataFrom(DonneesJson other) {
		this.racine = other.racine;
	}

}
