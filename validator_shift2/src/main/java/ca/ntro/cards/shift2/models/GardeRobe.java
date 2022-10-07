package ca.ntro.cards.shift2.models;

import java.util.List;

public class GardeRobe extends Shift2Model<GardeRobe> {
	
	private String emplacement;
	private List<Object> contient;

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public List<Object> getContient() {
		return contient;
	}

	public void setContient(List<Object> contient) {
		this.contient = contient;
	}


	@Override
	public void copyDataFrom(GardeRobe other) {
		this.emplacement = other.emplacement;
		this.contient = other.contient;
	}

}
