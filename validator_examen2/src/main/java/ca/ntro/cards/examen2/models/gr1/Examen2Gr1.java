package ca.ntro.cards.examen2.models.gr1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.ntro.cards.examen2.models.Examen2Model;
import ca.ntro.core.reflection.object_graph.Initialize;

public abstract class Examen2Gr1 extends Examen2Model<Examen2Gr1> implements Initialize {

	private static final long serialVersionUID = 8295201566647831760L;

	protected Map<String, Object> animaux = new HashMap<>();
	protected List<Object> groupes = new ArrayList<>();

	public List<Object> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Object> groupes) {
		this.groupes = groupes;
	}

	public Map<String, Object> getAnimaux() {
		return animaux;
	}

	public void setAnimaux(Map<String, Object> animaux) {
		this.animaux = animaux;
	}

	@Override
	public void copyDataFrom(Examen2Gr1 other) {
		this.animaux = other.animaux;
		this.groupes = other.groupes;
	}

}
