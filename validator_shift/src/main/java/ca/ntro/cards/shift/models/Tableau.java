package ca.ntro.cards.shift.models;


public class Tableau extends ShiftModel<Tableau> {

	private static final long serialVersionUID = 2115209402455138334L;

	protected boolean insererAuDebut = true;

	protected int aDeplacer = 0;
	protected int i = -1;
	protected Carte[] cartes = new Carte[0];

	protected Carte memoireA = null;
	protected Carte memoireB = null;
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public Carte[] getCartes() {
		return cartes;
	}

	public void setCartes(Carte[] cartes) {
		this.cartes = cartes;
	}

	public boolean getInsererAuDebut() {
		return insererAuDebut;
	}

	public void setInsererAuDebut(boolean insererAuDebut) {
		this.insererAuDebut = insererAuDebut;
	}

	public int getADeplacer() {
		return aDeplacer;
	}

	public void setADeplacer(int aDeplacer) {
		this.aDeplacer = aDeplacer;
	}

	public Carte getMemoireA() {
		return memoireA;
	}

	public void setMemoireA(Carte memoireA) {
		this.memoireA = memoireA;
	}

	public Carte getMemoireB() {
		return memoireB;
	}

	public void setMemoireB(Carte memoireB) {
		this.memoireB = memoireB;
	}

    public void copyDataFrom(Tableau other) {
        cartes = new Carte[other.cartes.length];
        
        for(int i = 0; i < cartes.length; i++) {
        	cartes[i] = other.cartes[i];
        }
        
        this.i = other.i;
        this.aDeplacer = other.aDeplacer;
        this.insererAuDebut = other.insererAuDebut;
        this.memoireA = other.memoireA;
        this.memoireB = other.memoireB;
    }
}
