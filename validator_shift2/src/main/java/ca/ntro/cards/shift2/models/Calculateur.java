package ca.ntro.cards.shift2.models;

import ca.ntro.core.reflection.object_graph.Initialize;

public class Calculateur extends Shift2Model<Calculateur> implements Initialize {
	private static final long serialVersionUID = -8785951526269181120L;

	private int n;
	private Factoriel tete;
	
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public Factoriel getTete() {
		return tete;
	}
	public void setTete(Factoriel tete) {
		this.tete = tete;
	}

	@Override
	public void copyDataFrom(Calculateur other) {
		this.tete = other.tete;
		this.n = other.n;
	}

	@Override
	public void initialiser() {
		n = 4;
		tete = new Factoriel();
		tete.setN(n);
		
		tete.calculerFactoriel();
		
	}
}
