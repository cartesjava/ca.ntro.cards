package ca.ntro.cards.shift.models;

import java.io.Serializable;

import ca.ntro.app.models.Value;

public class Carte implements Value, Serializable {

	private static final long serialVersionUID = 233385517377324484L;

	private long numero = 2;
	private Sorte sorte = Sorte.COEUR;

	public long getNumero() {
		return numero;
	}

	public void setNumero(long rank) {
		this.numero = rank;
	}
	public Sorte getSorte() {
		return sorte;
	}

	public void setSorte(Sorte suit) {
		this.sorte = suit;
	}

	public Carte() {
		super();
	}

	public Carte(long numero, Sorte sorte) {
		super();
		setNumero(numero);
		setSorte(sorte);
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		format(builder);
		
		return builder.toString();
	}
	
	public void format(StringBuilder builder) {
		builder.append(numero);
		builder.append(sorte.getSymbol());
	}

	public boolean hasSuit(Sorte suit) {
		return this.sorte.equals(suit);
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == this) return true;
		if(other == null) return false;
		if(other instanceof Carte) {
			Carte otherCard = (Carte) other;
			
			return this.sorte.equals(otherCard.sorte)
					&& this.numero == otherCard.numero;
		}
		
		return false;
	}
	
	public Carte clone() {
		Carte clone = new Carte(numero, sorte);
		return clone;
	}
}
