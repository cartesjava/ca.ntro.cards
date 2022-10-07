package ca.ntro.cards.shift2.models;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ca.ntro.cards.common.models.enums.Sorte;
import ca.ntro.cards.common.models.values.cards.AbstractCard;
import ca.ntro.cards.common.models.values.cards.CardHeap;
import ca.ntro.cards.common.models.values.cards.Carte;
import ca.ntro.cards.common.models.values.cards.NullCard;
import ca.ntro.cards.common.test_cases.descriptor.AbstractTestCaseDescriptor;
import ca.ntro.cards.common.test_cases.execution.Execution;
import ca.ntro.cards.shift2.Shift2Constants;
import ca.ntro.cards.shift2.frontend.Shift2ProcedureViewData;
import ca.ntro.cards.shift2.frontend.views.Shift2VariablesView;
import ca.ntro.cards.shift2.models.world2d.Shift2ProcedureDrawingOptions;
import ca.ntro.cards.shift2.models.world2d.Shift2ProcedureWorld2d;
import ca.ntro.cards.models.ProcedureCardsModel;
import ca.ntro.cards.models.values.ComparisonReport;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.stream.Stream;
import ca.ntro.core.stream.StreamNtro;
import ca.ntro.core.stream.Visitor;

public class   Tableau

       extends ProcedureCardsModel<Tableau, 
                                   Shift2ProcedureWorld2d, 
                                   Shift2ProcedureDrawingOptions, 
                                   Shift2ProcedureViewData,
                                   Shift2VariablesView> {
	 
	private String nomExemple;
	
	public static final int MARGIN_LEFT = 200;
	
	protected boolean insererAuDebut = true;

	protected int aDeplacer = 0;
	protected int i = -1;
	//protected List<Carte> cartes = new LinkedList<>();
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
	//public List<Carte> getCartes() {
		return cartes;
	}

	public void setCartes(Carte[] cartes) {
	//public void setCartes(List<Carte> cartes) {
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

	@Override
    public void copyDataFrom(Tableau other) {
        //cartes = new LinkedList<>();
		cartes = new Carte[other.cartes.length];
        
        //for(int i = 0; i < other.cartes.size(); i++) {
        for(int i = 0; i < other.cartes.length; i++) {

        	//cartes.add(i, other.cartes.get(i));
        	cartes[i] = other.cartes[i];
        }
        
        this.i = other.i;
        this.aDeplacer = other.aDeplacer;
        this.insererAuDebut = other.insererAuDebut;
        this.memoireA = other.memoireA;
        this.memoireB = other.memoireB;
        
        this.nomExemple = other.nomExemple;
    }

	@Override
	public boolean isValidNextStep(Tableau manualModel) {
		boolean modified = false;

		return modified;
	}

	@Override
	public ComparisonReport compareToSolution(Tableau solution) {
		
		ComparisonReport report = ComparisonReport.emptyReport();
		
		if(!Ntro.reflection().graphEquals(this, solution)) {
			report.addError("Résultat différent de la solution selon graphEquals");
		}


		

		return report;
	}

    @Override
    protected void updateViewDataImpl(CardHeap cardHeap, Shift2ProcedureViewData cardsViewData) {
    	double cardWidth = Shift2Constants.INITIAL_CARD_WIDTH_MILIMETERS;
		double cardHeight = Shift2Constants.INITIAL_CARD_HEIGHT_MILIMETERS;
		
		displayMemoryCard(cardsViewData, cardHeap, memoireA, i, 0, cardWidth, cardHeight);
		displayMemoryCard(cardsViewData, cardHeap, memoireB, i, 1, cardWidth, cardHeight);
		
		//for(int i = 0; i < cartes.size(); i++) {
		for(int i = 0; i < cartes.length; i++) {

			double targetTopLeftX = MARGIN_LEFT + cardWidth + cardWidth / 2 + i * cardWidth * 3 / 2;
			double targetTopLeftY = cardHeight * 3;
			
			//AbstractCard card = cartes.get(i);
			AbstractCard card = cartes[i];
			
			if(card == null) {
				card = new NullCard();
			}

			card = cardHeap.firstInstanceOf(card);
			String card2dId = cardHeap.newCard2dId(card);
			
			cardsViewData.addOrUpdateCard(card2dId,
					                      card,
					                      targetTopLeftX,
					                      targetTopLeftY);
			
			cardsViewData.displayCardFaceUp(card2dId);
		}
		
		double markerHeight = 25;
		
		double markerTopLeftX = MARGIN_LEFT + 10 + cardWidth + cardWidth / 2 + getADeplacer() * cardWidth * 3 / 2;
		double markerTopLeftY = cardHeight * 3 - cardHeight / 3 - markerHeight;
		
		cardsViewData.addOrUpdateMarker("toRemove", "#ff1122", markerTopLeftX, markerTopLeftY);
		cardHeap.addMarkerId("toRemove");
		
		markerTopLeftX = MARGIN_LEFT + 10 + cardWidth + cardWidth / 2 + getI() * cardWidth * 3 / 2;
		markerTopLeftY = cardHeight * 4 + cardHeight / 3;
		
		cardsViewData.addOrUpdateMarker("i", markerTopLeftX, markerTopLeftY);
		cardHeap.addMarkerId("i");
    }

	private void displayMemoryCard(Shift2ProcedureViewData cardsViewData,
								   CardHeap cardHeap,
								   AbstractCard memoryCard, 
							       double offsetX,
							       double offsetY,
			                       double cardWidth, 
			                       double cardHeight) {

		if(memoryCard == null) {
			memoryCard = new NullCard();
		}

		memoryCard = cardHeap.firstInstanceOf(memoryCard);
		String card2dId = cardHeap.newCard2dId(memoryCard);

		double targetTopLeftX = MARGIN_LEFT + cardWidth + cardWidth / 2 + offsetX * cardWidth * 3 / 2;
		double targetTopLeftY = cardHeight * 3 + cardHeight * offsetY + cardHeight * 2 + offsetY * cardHeight / 4;

		cardsViewData.addOrUpdateCard(card2dId, 
				                      memoryCard,
									  targetTopLeftX,
									  targetTopLeftY);

		cardsViewData.displayCardFaceUp(card2dId);
	}

    @Override
    public void initializeAsTestCase(AbstractTestCaseDescriptor descriptor) {
    	this.nomExemple = descriptor.testCaseId();

		i = -1;
		aDeplacer = 0;
		memoireA = null;
		memoireB = null;
		//cartes = new LinkedList<>();
		cartes = new Carte[descriptor.inputSize()];
		for(int i = 0; i < descriptor.inputSize(); i++) {
			//cartes.add(i, null);
			cartes[i] = null;
		}
    }

    @Override
    public int testCaseSize() {
        
    	//return cartes.size();
    	return cartes.length;
    }
    
    @Override
    protected Stream<Carte> cards() {
        return new StreamNtro<Carte>() {
            @Override
            public void forEach_(Visitor<Carte> visitor) throws Throwable {
                //for(int i = 0; i < cartes.size(); i++) {
                for(int i = 0; i < cartes.length; i++) {
                	//visitor.visit(cartes.get(i));
                	visitor.visit(cartes[i]);
                }
            }
        };
    }


    @Override
    public void run() {
        construireModele(this.nomExemple);
    }

    public void construireModele(String nomExemple) {
    }

    @Override
    public void displayOn(Shift2VariablesView variablesView) {
    	variablesView.displayADeplacer(String.valueOf(aDeplacer));
    	variablesView.displayI(String.valueOf(i));
    	variablesView.displayInsererAuDebut(String.valueOf(insererAuDebut));
    	variablesView.displayMemoireA(String.valueOf(memoireA));
    	variablesView.displayMemoireB(String.valueOf(memoireB));
    }
	
}
