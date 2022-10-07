package ca.ntro.cards.shift.models;


import ca.ntro.cards.common.models.enums.Sorte;
import ca.ntro.cards.common.models.values.cards.AbstractCard;
import ca.ntro.cards.common.models.values.cards.CardHeap;
import ca.ntro.cards.common.models.values.cards.Carte;
import ca.ntro.cards.common.models.values.cards.NullCard;
import ca.ntro.cards.common.test_cases.descriptor.AbstractTestCaseDescriptor;
import ca.ntro.cards.shift.ShiftConstants;
import ca.ntro.cards.shift.frontend.ShiftProcedureViewData;
import ca.ntro.cards.shift.frontend.views.ShiftVariablesView;
import ca.ntro.cards.shift.models.world2d.ShiftProcedureDrawingOptions;
import ca.ntro.cards.shift.models.world2d.ShiftProcedureWorld2d;
import ca.ntro.cards.models.ProcedureCardsModel;
import ca.ntro.cards.models.values.ComparisonReport;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.stream.Stream;
import ca.ntro.core.stream.StreamNtro;
import ca.ntro.core.stream.Visitor;

public class   Tableau

       extends ProcedureCardsModel<Tableau, 
                                   ShiftProcedureWorld2d, 
                                   ShiftProcedureDrawingOptions, 
                                   ShiftProcedureViewData,
                                   ShiftVariablesView> {
	 
	
	public static final int MARGIN_LEFT = 200;
	
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

	@Override
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

	@Override
	public boolean isValidNextStep(Tableau manualModel) {
		boolean modified = false;

		return modified;
	}

	@Override
	public ComparisonReport compareToSolution(Tableau solution) {
		
		ComparisonReport report = ComparisonReport.emptyReport();

		if(cartes == null && solution.cartes != null) {
			
			report.addError("cartes ne devrait pas être null");

		//}else if(cartes.size() != solution.cartes.size()) {
		}else if(cartes.length != solution.cartes.length) {

			//report.addError("Pas la bonne taille pour cible (devrait être " + solution.cartes.size() + ")");
			report.addError("Pas la bonne taille pour cible (devrait être " + solution.cartes.length + ")");

		}else if(cartes != null && solution.cartes != null) {

			//for(int i = 0; i < cartes.size(); i++) {
			for(int i = 0; i < cartes.length; i++) {
				
				//if(cartes.get(i) == null && solution.cartes.get(i) != null) {
				if(cartes[i] == null && solution.cartes[i] != null) {

					//report.addError("Pas la bonne carte " + i + " " + cartes.get(i) + " ne devrait pas être null");
					report.addError("Pas la bonne carte " + i + " " + cartes[i] + " ne devrait pas être null");

				//}else if(cartes.get(i) != null
						//&& !cartes.get(i).equals(solution.cartes.get(i))) {
				}else if(cartes[i] != null
						&& !cartes[i].equals(solution.cartes[i])) {

					//report.addError("Pas la bonne carte " + i + " " + cartes.get(i) + " devrait être " + solution.cartes.get(i));
					report.addError("Pas la bonne carte " + i + " " + cartes[i] + " devrait être " + solution.cartes[i]);
				}

			}
		}

		return report;
	}

    @Override
    protected void updateViewDataImpl(CardHeap cardHeap, ShiftProcedureViewData cardsViewData) {
    	double cardWidth = ShiftConstants.INITIAL_CARD_WIDTH_MILIMETERS;
		double cardHeight = ShiftConstants.INITIAL_CARD_HEIGHT_MILIMETERS;
		
		displayMemoryCard(cardsViewData, cardHeap, memoireA, i, 0, cardWidth, cardHeight);
		displayMemoryCard(cardsViewData, cardHeap, memoireB, i, 1, cardWidth, cardHeight);
		
		for(int i = 0; i < cartes.length; i++) {

			double targetTopLeftX = MARGIN_LEFT + cardWidth + cardWidth / 2 + i * cardWidth * 3 / 2;
			double targetTopLeftY = cardHeight * 3;
			
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

	private void displayMemoryCard(ShiftProcedureViewData cardsViewData,
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

		i = -1;
		memoireA = null;
		memoireB = null;
    	
        if(descriptor.testCaseId().equals("ex01")) {

        	/*
			cartes = new Carte[] {new Carte(2, Sorte.COEUR)};
			aDeplacer = 0;
			insererAuDebut = true;
			*/
        	
			cartes = new Carte[] {new Carte(2, Sorte.TREFLE), 
	                    		  new Carte(5, Sorte.TREFLE), 
	                    		  new Carte(3, Sorte.CARREAU), 
	                    		  new Carte(5, Sorte.COEUR), 
	                    		  new Carte(7, Sorte.PIQUE), 
	                    		  new Carte(2, Sorte.COEUR)};
			aDeplacer = 3;
			insererAuDebut = true;

        }else if(descriptor.testCaseId().equals("ex02")) {

        	cartes = randomArrayOfUniqueCards(3);
        	
        	memoireB = cartes[1];
        	cartes[1] = null;
        	
        	i = 1;
			aDeplacer = 2;
			//insererAuDebut = true;

        }else if(descriptor.testCaseId().equals("ex03")) {

        	cartes = randomArrayOfUniqueCards(5);
        	
        	memoireA = cartes[3];
        	memoireB = cartes[0];
        	cartes[3] = null;
        	cartes[0] = null;
        	
        	i = 2;
			aDeplacer = 0;
			//insererAuDebut = true;

        }else if(descriptor.testCaseId().equals("ex04")) {

        	cartes = randomArrayOfUniqueCards(3);
        	
        	memoireA = cartes[1];
        	memoireB = cartes[2];
        	cartes[2] = null;
        	cartes[1] = null;
        	
        	i = 3;
			//aDeplacer = -1;
			aDeplacer = 1;
			//insererAuDebut = true;


        }else if(descriptor.category().equals("random")) {
        	
        	cartes = randomArrayOfUniqueCards(descriptor.inputSize());
        	insererAuDebut = Ntro.random().nextBoolean();
        	
        	if(insererAuDebut) {

        		aDeplacer = cartes.length - Ntro.random().nextInt(2) - 1;

        	}else {

        		aDeplacer = Ntro.random().nextInt(3);
        	}
        	
        	if(aDeplacer < 0) {
        		aDeplacer = 0;
        	}
        	
        	if(aDeplacer >= cartes.length) {
        		aDeplacer = cartes.length - 1;
        	}
        }
    }

    @Override
    public int testCaseSize() {
        
    	return cartes.length;
    }
    
    @Override
    protected Stream<Carte> cards() {
        return new StreamNtro<Carte>() {
            @Override
            public void forEach_(Visitor<Carte> visitor) throws Throwable {
                for(int i = 0; i < cartes.length; i++) {
                	visitor.visit(cartes[i]);
                }
            }
        };
    }


    @Override
    public void run() {
        deplacerDecaler();
    }

    public void deplacerDecaler() {
    }

    @Override
    public void displayOn(ShiftVariablesView variablesView) {
    	variablesView.displayADeplacer(String.valueOf(aDeplacer));
    	variablesView.displayI(String.valueOf(i));
    	variablesView.displayInsererAuDebut(String.valueOf(insererAuDebut));
    	variablesView.displayMemoireA(String.valueOf(memoireA));
    	variablesView.displayMemoireB(String.valueOf(memoireB));
    }
	
}
