/*
Copyright (C) (2022) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)

This file is part of "Cartes Java", teaching tools made for https://cartesjava.github.io/

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

*/
package ca.ntro.cards.naivesort.models;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.cards.common.models.enums.Sorte;
import ca.ntro.cards.common.models.values.cards.AbstractCard;
import ca.ntro.cards.common.models.values.cards.CardHeap;
import ca.ntro.cards.common.models.values.cards.Carte;
import ca.ntro.cards.common.models.values.cards.NullCard;
import ca.ntro.cards.common.test_cases.descriptor.AbstractTestCaseDescriptor;
import ca.ntro.cards.naivesort.NaivesortConstants;
import ca.ntro.cards.naivesort.frontend.NaivesortProcedureViewData;
import ca.ntro.cards.naivesort.frontend.views.NaivesortVariablesView;
import ca.ntro.cards.naivesort.models.world2d.NaivesortProcedureDrawingOptions;
import ca.ntro.cards.naivesort.models.world2d.NaivesortProcedureWorld2d;
import ca.ntro.cards.models.ProcedureCardsModel;
import ca.ntro.cards.models.values.ComparisonReport;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.stream.Stream;
import ca.ntro.core.stream.StreamNtro;
import ca.ntro.core.stream.Visitor;

public class   TriNaif<C extends Comparable<C>> 

       extends ProcedureCardsModel<TriNaif, 
                                   NaivesortProcedureWorld2d, 
                                   NaivesortProcedureDrawingOptions, 
                                   NaivesortProcedureViewData,
                                   NaivesortVariablesView> { 
                	
                	
	protected int indicePlusPetit = -1;
	protected int indiceCandidat = -1;
	protected int indiceProchainVide = 0;
	
	protected C[] source = (C[]) new Carte[0];
	protected C[] cible = (C[]) new Carte[0];


	public int getIndicePlusPetit() {
		return indicePlusPetit;
	}

	public void setIndicePlusPetit(int indicePlusPetit) {
		this.indicePlusPetit = indicePlusPetit;
	}

	public int getIndiceCandidat() {
		return indiceCandidat;
	}

	public void setIndiceCandidat(int indiceCandidat) {
		this.indiceCandidat = indiceCandidat;
	}

	public int getIndiceProchainVide() {
		return indiceProchainVide;
	}

	public void setIndiceProchainVide(int indiceProchainVide) {
		this.indiceProchainVide = indiceProchainVide;
	}

	public C[] getSource() {
		return source;
	}

	public void setSource(C[] source) {
		this.source = source;
	}

	public C[] getCible() {
		return cible;
	}

	public void setCible(C[] cible) {
		this.cible = cible;
	}

	@Override
	public void copyDataFrom(TriNaif other) {
		source = (C[]) new Carte[other.source.length];
		cible = (C[]) new Carte[other.cible.length];

		for(int i = 0; i < other.source.length; i++) {
			source[i] = (C) other.source[i];
		}

		for(int i = 0; i < other.cible.length; i++) {
			cible[i] = (C) other.cible[i];
		}
		
		indicePlusPetit = other.indicePlusPetit;
		indiceCandidat = other.indiceCandidat;
		indiceProchainVide = other.indiceProchainVide;
		
	}

	@Override
	public boolean isValidNextStep(TriNaif nextModel) {
		boolean isValid = true;
		
		int lastNonEmpty = -1;
		for(int i = 0; i < nextModel.cible.length; i++) {
			if(nextModel.cible[i] != null) {
				lastNonEmpty = i;
			}
		}

		if(nextModel.indiceProchainVide != lastNonEmpty + 1) {
			isValid = false;
		}
		
		if(nextModel.indiceProchainVide - indiceProchainVide > 1) {
			isValid = false;
		}
		
		return isValid;
	}

	@Override
	public ComparisonReport compareToSolution(TriNaif solution) {
		ComparisonReport report = ComparisonReport.emptyReport();
		
		if(cible.length != solution.cible.length) {
			report.addError("Pas la bonne taille pour cible (devrait être " + solution.cible.length + ")");
		}

		for(int i = 0; i < cible.length; i++) {
			if(!solution.cible[i].equals(cible[i])) {
				report.addError("Pas la bonne carte " + i + " " + cible[i] + " devrait être " + solution.cible.length);
			}
		}

		return report;
	}

	@Override
	protected void updateViewDataImpl(CardHeap cardHeap, NaivesortProcedureViewData cardsViewData) {
		double cardWidth = NaivesortConstants.INITIAL_CARD_WIDTH_MILIMETERS;
		double cardHeight = NaivesortConstants.INITIAL_CARD_HEIGHT_MILIMETERS;
		
		List<AbstractCard> topCards = new ArrayList<>();
		List<AbstractCard> bottomCards = new ArrayList<>();
		
		String smallestCardId = null;
		String candidateCardId = null;

		for(int i = 0; i < source.length; i++) {

			double targetTopLeftX = cardWidth + cardWidth / 2 + i * cardWidth * 3 / 2;
			double targetTopLeftY = cardHeight * 2;
			
			AbstractCard card = (Carte) source[i];
			
			if(card == null) {
				card = new NullCard();
			}

			card = cardHeap.firstInstanceOf(card);
			String card2dId = cardHeap.newCard2dId(card);
			
			cardsViewData.addOrUpdateCard(card2dId, 
					                      card,
					                      targetTopLeftX,
					                      targetTopLeftY);

			bottomCards.add(card);
			cardsViewData.displayCardFaceDown(card2dId);
			
			if(i == getIndicePlusPetit()) {
				smallestCardId = card2dId;
			}
			
			if(i == getIndiceCandidat()) {
				candidateCardId = card2dId;
				
			}
		}

		for(int i = 0; i < cible.length; i++) {

			double targetTopLeftX = cardWidth + cardWidth / 2 + i * cardWidth * 3 / 2;
			double targetTopLeftY = cardHeight / 2;
			
			AbstractCard card = (Carte) cible[i];
			
			if(card == null) {
				card = new NullCard();
			}

			card = cardHeap.firstInstanceOf(card);
			String card2dId = cardHeap.newCard2dId(card);

			cardsViewData.addOrUpdateCard(card2dId, 
					                      card,
					                      targetTopLeftX,
					                      targetTopLeftY);
			topCards.add(card);
			
			if(i <= getIndiceProchainVide()) {

				cardsViewData.displayCardFaceUp(card2dId);

			}else {

				cardsViewData.displayCardFaceDown(card2dId);
			}
		}

		double markerTopLeftX = 10 + cardWidth + cardWidth / 2 + getIndicePlusPetit() * cardWidth * 3 / 2;
		double markerTopLeftY = cardHeight * 3 + cardHeight / 3;
		
		cardsViewData.addOrUpdateMarker("smallestElement", markerTopLeftX, markerTopLeftY);
		cardHeap.addMarkerId("smallestElement");
		
		if(smallestCardId != null) {
			cardsViewData.displayCardFaceUp(smallestCardId);
		}
		
		if(candidateCardId != null) {
			cardsViewData.displayCardFaceUp(candidateCardId);
		}
	}

	@Override
	public void initializeAsTestCase(AbstractTestCaseDescriptor descriptor) {
		
		if(descriptor.testCaseId().equals("ex01")) {
			
			source = (C[]) new Carte[] {new Carte(2, Sorte.TREFLE), 
					                   new Carte(5, Sorte.TREFLE), 
					                   new Carte(5, Sorte.CARREAU), 
					                   new Carte(5, Sorte.COEUR), 
					                   new Carte(7, Sorte.PIQUE), 
					                   new Carte(2, Sorte.COEUR)};

			//source = (C[]) new Carte[] {new Carte(2, Sorte.COEUR)};

		}else {
			
			source = (C[]) randomArrayOfUniqueCards(descriptor.inputSize());

		}
		
		cible = (C[]) new Carte[source.length];

		for(int i = 0; i < source.length; i++) {
			cible[i] = null;
		}
	}



	@Override
	public int testCaseSize() {
		return source.length;
	}

	@Override
	protected Stream<Carte> cards() {
		return new StreamNtro<Carte>() {
			@Override
			public void forEach_(Visitor<Carte> visitor) throws Throwable {
				visitList(visitor, source);
				visitList(visitor, cible);
			}

			private void visitList(Visitor<Carte> visitor, C[] listToVisit) throws Throwable {
				for(C card : listToVisit) {
					visitor.visit((Carte) card);
				}
			}
		};
	}

	@Override
	public void run() {
		trier();
	}

	public void trier() {
	}

	@Override
	public void displayOn(NaivesortVariablesView variablesView) {
		variablesView.displayIndexOfSmallest(String.valueOf(indicePlusPetit));
		variablesView.displayIndexOfCandidate(String.valueOf(indiceCandidat));
		variablesView.displayIndexOfNextEmpty(String.valueOf(indiceProchainVide));
	}



}
