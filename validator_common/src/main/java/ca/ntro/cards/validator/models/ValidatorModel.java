package ca.ntro.cards.validator.models;

import java.io.Serializable;

import ca.ntro.app.models.Model;
import ca.ntro.app.models.WriteObjectGraph;

public abstract class ValidatorModel<MODEL extends ValidatorModel> implements Model, WriteObjectGraph, Serializable {

	private static final long serialVersionUID = 1418431208450635339L;
	
	public abstract void copyDataFrom(MODEL other);

}
