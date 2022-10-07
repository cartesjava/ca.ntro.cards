package ca.ntro.cards.shift2.models;

import java.io.Serializable;

import ca.ntro.app.models.Value;

public class Factoriel implements Value, Serializable {

	private static final long serialVersionUID = -6634474788240839519L;

	private int n;
	private long reponse;
	private Factoriel moinsUn;

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public long getReponse() {
		return reponse;
	}

	public void setReponse(long reponse) {
		this.reponse = reponse;
	}

	public Factoriel getMoinsUn() {
		return moinsUn;
	}

	public void setMoinsUn(Factoriel moinsUn) {
		this.moinsUn = moinsUn;
	}

	public void calculerFactoriel() {
		if(n == 0) {

			reponse = 1;

		}else {
			
			moinsUn = new Factoriel();
			moinsUn.setN(n-1);
			moinsUn.calculerFactoriel();
			
			reponse = n * moinsUn.reponse;
		}
		
	}
}
