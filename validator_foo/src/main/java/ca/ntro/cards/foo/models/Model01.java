package ca.ntro.cards.foo.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.ntro.core.reflection.object_graph.Initialize;

public abstract class Model01 extends FooModel<Model01> implements Initialize {

	private static final long serialVersionUID = 8295201566647831760L;

	protected List<Object> maListe = new ArrayList<>();
	
	protected Map<String, Object> monMap = new HashMap<>();

	public List<Object> getMaListe() {
		return maListe;
	}

	public void setMaListe(List<Object> maListe) {
		this.maListe = maListe;
	}

	public Map<String, Object> getMonMap() {
		return monMap;
	}

	public void setMonMap(Map<String, Object> monMap) {
		this.monMap = monMap;
	}

	@Override
	public void copyDataFrom(Model01 other) {
		this.maListe = other.maListe;
		this.monMap = other.monMap;
	}

}
