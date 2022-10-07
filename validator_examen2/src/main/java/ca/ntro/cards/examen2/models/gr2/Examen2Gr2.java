package ca.ntro.cards.examen2.models.gr2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.ntro.cards.examen2.models.Examen2Model;
import ca.ntro.core.reflection.object_graph.Initialize;

public abstract class Examen2Gr2 extends Examen2Model<Examen2Gr2> implements Initialize {

	private static final long serialVersionUID = 8295201566647831760L;

	protected Map<String, Object> vehicules = new HashMap<>();
	protected List<Object> groupes = new ArrayList<>();

	public Map<String, Object> getVehicules() {
		return vehicules;
	}

	public void setVehicules(Map<String, Object> vehicules) {
		this.vehicules = vehicules;
	}

	public List<Object> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Object> groupes) {
		this.groupes = groupes;
	}

	@Override
	public void copyDataFrom(Examen2Gr2 other) {
		this.vehicules = other.vehicules;
		this.groupes = other.groupes;
	}

}
