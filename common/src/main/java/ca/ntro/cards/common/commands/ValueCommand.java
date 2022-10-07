package ca.ntro.cards.common.commands;

import ca.ntro.cards.common.models.values.cards.Carte;

public abstract class ValueCommand<C extends Comparable<C>> extends Command<C> {

	private C value;

	public ValueCommand(Carte card) {
		this.value = (C) card;
	}

	public C getValue() {
		return value;
	}

	public void setValue(C value) {
		this.value = value;
	}

}
