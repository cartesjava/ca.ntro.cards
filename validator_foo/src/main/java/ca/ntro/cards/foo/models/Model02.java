package ca.ntro.cards.foo.models;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.cards.foo.models.FooModel;

public abstract class Model02 extends FooModel<Model02> {

	private static final long serialVersionUID = 4201588695860622481L;

	protected List<Object> source = new ArrayList<>();
	protected List<Object> destination = new ArrayList<>();

	public List<Object> getSource() {
		return source;
	}

	public void setSource(List<Object> source) {
		this.source = source;
	}

	public List<Object> getDestination() {
		return destination;
	}

	public void setDestination(List<Object> destination) {
		this.destination = destination;
	}

	@Override
	public void copyDataFrom(Model02 other) {
		this.source = other.source;
		this.destination = other.destination;
	}

}
