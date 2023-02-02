package ca.ntro.cards.cartesjava.models;

import ca.ntro.core.reflection.object_graph.Initialize;

public class ListeChaineeSimple01 extends ListeChaineeSimple<Character> {

	public ListeChaineeSimple01() {
		super();
	}

	public ListeChaineeSimple01(Class<Character> typeElement) {
		super(typeElement);
	}

	@Override
	public void initialiser() {
		add('z');
		add('r');
		add('w');
	}

}
