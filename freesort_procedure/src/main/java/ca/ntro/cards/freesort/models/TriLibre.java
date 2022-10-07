package ca.ntro.cards.freesort.models;


import java.util.List;

import ca.ntro.cards.common.models.enums.Sorte;
import ca.ntro.cards.common.models.values.cards.AbstractCard;
import ca.ntro.cards.common.models.values.cards.CardHeap;
import ca.ntro.cards.common.models.values.cards.Carte;
import ca.ntro.cards.common.models.values.cards.NullCard;
import ca.ntro.cards.common.test_cases.descriptor.AbstractTestCaseDescriptor;
import ca.ntro.cards.freesort.FreesortConstants;
import ca.ntro.cards.freesort.frontend.FreesortProcedureViewData;
import ca.ntro.cards.freesort.frontend.views.FreesortVariablesView;
import ca.ntro.cards.freesort.models.world2d.FreesortProcedureDrawingOptions;
import ca.ntro.cards.freesort.models.world2d.FreesortProcedureWorld2d;
import ca.ntro.cards.models.ProcedureCardsModel;
import ca.ntro.cards.models.values.ComparisonReport;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.stream.Stream;
import ca.ntro.core.stream.StreamNtro;
import ca.ntro.core.stream.Visitor;

@SuppressWarnings({ "rawtypes", "serial" })

public class   TriLibre

       extends ProcedureCardsModel<TriLibre, 
                                   FreesortProcedureWorld2d, 
                                   FreesortProcedureDrawingOptions, 
                                   FreesortProcedureViewData,
                                   FreesortVariablesView> { 
	
	protected boolean siTrie = false;

	protected Carte[] cartes = new Carte[0];

	public Carte[] getCartes() {
		return cartes;
	}

	public void setCartes(Carte[] cartes) {
		this.cartes = cartes;
	}

	public boolean getSiTrie() {
		return siTrie;
	}

	public void setSiTrie(boolean siTrie) {
		this.siTrie = siTrie;
	}

	@Override
	public void copyDataFrom(TriLibre other) {
		cartes = new Carte[other.cartes.length];
		
		for(int i = 0; i < cartes.length; i++) {
			cartes[i] = other.cartes[i];
		}

		siTrie = isSorted();
	}

	private boolean isSorted() {
		boolean isSorted = true;

		for(int i = 1; i < cartes.length; i++) {
			if(cartes[i-1].compareTo(cartes[i]) > 0) {
				isSorted = false;
				break;
			}
		}
		
		return isSorted;
	}

	@Override
	public boolean isValidNextStep(TriLibre manualModel) {
		return true;
	}

	@Override
	public ComparisonReport compareToSolution(TriLibre solution) {
		ComparisonReport report = ComparisonReport.emptyReport();
		
		if(!isSorted()) {
			report.addError("Not sorted");
		}

		return report;
	}

	@Override
	protected void updateViewDataImpl(CardHeap cardHeap, FreesortProcedureViewData cardsViewData) {

		double cardWidth = FreesortConstants.INITIAL_CARD_WIDTH_MILIMETERS;
		double cardHeight = FreesortConstants.INITIAL_CARD_HEIGHT_MILIMETERS;

		for(int i = 0; i < cartes.length; i++) {

			double targetTopLeftX = cardWidth + cardWidth / 2 + i * cardWidth * 3 / 2;
			double targetTopLeftY = cardHeight * 2;
			
			AbstractCard card = (Carte) cartes[i];
			
			if(card == null) {
				card = new NullCard();
			}
			
			card = cardHeap.firstInstanceOf(card);
			String card2dId = cardHeap.newCard2dId(card);
			
			cardsViewData.addOrUpdateCard(card2dId, 
					                      card,
					                      targetTopLeftX,
					                      targetTopLeftY);

			cardsViewData.displayCardFaceUp(card);
		}
	}

	@Override
	public void initializeAsTestCase(AbstractTestCaseDescriptor descriptor) {
		if(descriptor.testCaseId().equals("ex01")) {
			
			cartes = new Carte[] {
					new Carte(2, Sorte.TREFLE),
			};


		}else if(descriptor.testCaseId().contentEquals("ex02")) {

			cartes = new Carte[] {
					new Carte(3, Sorte.TREFLE),
					new Carte(2, Sorte.TREFLE),
			};
			
		}else if(descriptor.testCaseId().contentEquals("ex03")) {

			cartes = new Carte[] {
					new Carte(1, Sorte.PIQUE),
					new Carte(2, Sorte.TREFLE),
					new Carte(3, Sorte.TREFLE),
			};
			
		}else if(descriptor.testCaseId().contentEquals("ex04")) {

			cartes = new Carte[] {
					new Carte(4, Sorte.TREFLE),
					new Carte(5, Sorte.CARREAU),
					new Carte(6, Sorte.CARREAU),
			};

		}else if(descriptor.testCaseId().contentEquals("ex05")) {

			cartes = new Carte[] {
					new Carte(1, Sorte.CARREAU),
					new Carte(2, Sorte.COEUR),
					new Carte(3, Sorte.CARREAU),
					new Carte(4, Sorte.COEUR),
					new Carte(5, Sorte.CARREAU),
					new Carte(6, Sorte.COEUR),
			};

		}else if(descriptor.testCaseId().contentEquals("ex05")) {

			cartes = new Carte[] {
					new Carte(1, Sorte.TREFLE),
					new Carte(2, Sorte.PIQUE),
					new Carte(3, Sorte.TREFLE),
					new Carte(4, Sorte.PIQUE),
					new Carte(5, Sorte.TREFLE),
					new Carte(6, Sorte.PIQUE),
			};
			
		}else if(descriptor.testCaseId().contentEquals("ex06")) {

			cartes = new Carte[] {
					new Carte(1, Sorte.COEUR),
					new Carte(1, Sorte.CARREAU),
					new Carte(1, Sorte.TREFLE),
					new Carte(1, Sorte.PIQUE),
					new Carte(2, Sorte.COEUR),
					new Carte(2, Sorte.CARREAU),
					new Carte(2, Sorte.TREFLE),
					new Carte(2, Sorte.PIQUE),
			};

		}else if(descriptor.testCaseId().contentEquals("ex07")) {

			cartes = new Carte[] {
					new Carte(7, Sorte.COEUR),
					new Carte(8, Sorte.COEUR),
					new Carte(7, Sorte.CARREAU),
					new Carte(8, Sorte.CARREAU),
					new Carte(7, Sorte.TREFLE),
					new Carte(8, Sorte.TREFLE),
					new Carte(7, Sorte.PIQUE),
					new Carte(8, Sorte.PIQUE),
			};

			
		}else if(descriptor.testCaseId().contentEquals("ex08")) {

			cartes = new Carte[] {
					new Carte(2, Sorte.CARREAU),
					new Carte(6, Sorte.CARREAU),
					new Carte(1, Sorte.COEUR),
					new Carte(5, Sorte.COEUR),
					new Carte(4, Sorte.TREFLE),
					new Carte(8, Sorte.TREFLE),
					new Carte(3, Sorte.PIQUE),
					new Carte(7, Sorte.PIQUE),
			};

			
		}
		

	}

	@Override
	public int testCaseSize() {
		return cartes.length;
	}
	
	@Override
	protected Carte cardById(String cardId) {
		Carte card = null;
		
		for(int i = 0; i < cartes.length; i++) {
			if(cartes[i].hasId(cardId)) {
				card = cartes[i];
				break;
			}
		}
		
		return card;
	}
	
	@Override
	protected Stream<Carte> cards() {
		return new StreamNtro<Carte>() {
			@Override
			public void forEach_(Visitor<Carte> visitor) throws Throwable {
				for(Carte card : cartes) {
					visitor.visit(card);
				}
			}
		};
	}

	@Override
	public void run() {
		triLibre();
	}

	public void triLibre() {
	}

	@Override
	public void displayOn(FreesortVariablesView variablesView) {
		variablesView.displayIfSorted(String.valueOf(siTrie));
	}

}
