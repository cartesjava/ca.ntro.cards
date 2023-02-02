package ca.ntro.cards.cartesjava.models;

public class ListeChaineeDouble01 extends ListeChaineeDouble<Character> {
	
	public ListeChaineeDouble01() {
		super();
	}

	public ListeChaineeDouble01(Class<Character> typeElement) {
		super(typeElement);
	}

	@Override
	public void initialiser() {
		add('z');
		add('r');
		add('w');
	}

}
