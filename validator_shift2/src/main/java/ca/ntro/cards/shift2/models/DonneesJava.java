package ca.ntro.cards.shift2.models;

import java.util.HashMap;
import java.util.Map;

import ca.ntro.core.reflection.object_graph.Initialize;

public abstract class DonneesJava extends Shift2Model<DonneesJava> implements Initialize {

	private static final long serialVersionUID = 1676784143197826598L;

	protected Map<String, Object> racine = new HashMap<>();

	public Map<String, Object> getRacine() {
		return racine;
	}

	public void setRacine(Map<String, Object> racine) {
		this.racine = racine;
	}

	@Override
	public void copyDataFrom(DonneesJava other) {
		this.racine = other.racine;
	}

}
