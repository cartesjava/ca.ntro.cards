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
package ca.ntro.cards.fibonacci.models;


import java.util.HashSet;
import java.util.Set;

import ca.ntro.cards.common.models.enums.Sorte;
import ca.ntro.cards.common.models.values.cards.AbstractCard;
import ca.ntro.cards.common.models.values.cards.CardHeap;
import ca.ntro.cards.common.models.values.cards.Carte;
import ca.ntro.cards.common.models.values.cards.NullCard;
import ca.ntro.cards.common.test_cases.descriptor.AbstractTestCaseDescriptor;
import ca.ntro.cards.fibonacci.FibonacciConstants;
import ca.ntro.cards.fibonacci.frontend.FibonacciProcedureViewData;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciVariablesView;
import ca.ntro.cards.fibonacci.models.world2d.FibonacciProcedureDrawingOptions;
import ca.ntro.cards.fibonacci.models.world2d.FibonacciProcedureWorld2d;
import ca.ntro.cards.models.ProcedureCardsModel;
import ca.ntro.cards.models.values.ComparisonReport;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.stream.Stream;
import ca.ntro.core.stream.StreamNtro;
import ca.ntro.core.stream.Visitor;

public class   Calculateur

       extends ProcedureCardsModel<Calculateur, 
                                   FibonacciProcedureWorld2d, 
                                   FibonacciProcedureDrawingOptions, 
                                   FibonacciProcedureViewData,
                                   FibonacciVariablesView> { 

	private static final long serialVersionUID = -2233433533957028485L;

	public static final int MARGIN_LEFT = 10;
	public static final double EPSILON = 0.001;

	protected boolean siRecursif = true;
	protected int n;
	protected Fibonacci tete;

	public boolean getSiRecursif() {
		return siRecursif;
	}

	public void setSiRecursif(boolean siRecursif) {
		this.siRecursif = siRecursif;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public Fibonacci getTete() {
		return tete;
	}

	public void setTete(Fibonacci tete) {
		this.tete = tete;
	}

	@Override
    public void copyDataFrom(Calculateur other) {
		//this.somme = other.somme;
		this.n = other.n;
		this.siRecursif = other.siRecursif;
		if(other.tete != null) {
			this.tete = (Fibonacci) Ntro.reflection().clone(other.tete);
			//this.tete = new Fibonacci();
			//this.tete.copyDataFrom(other.tete);

		}else {
			this.tete = null;
		}
    }

	@Override
	public boolean isValidNextStep(Calculateur manualModel) {
		boolean modified = false;

		return modified;
	}

	@Override
	public ComparisonReport compareToSolution(Calculateur solution) {
		
		ComparisonReport report = ComparisonReport.emptyReport();
		
		if(!Ntro.reflection().graphEquals(this, solution)) {
			
			report.addError("Non valide selon graphEquals");
		}

		return report;
	}


    @Override
    protected void updateViewDataImpl(CardHeap cardHeap, FibonacciProcedureViewData cardsViewData) {
    	double cardWidth = FibonacciConstants.INITIAL_CARD_WIDTH_MILIMETERS;
		double cardHeight = FibonacciConstants.INITIAL_CARD_HEIGHT_MILIMETERS;

		int i = 0;
		Fibonacci cursor = tete;
		Set<Fibonacci> visited = new HashSet<>();

		while(cursor != null) {
			visited.add(cursor);

			AbstractCard card = null;

			if(cursor.reponse != null) {
				
				if(cursor.moinsUn != null
						&& cursor.reponse.equals(cursor.moinsUn.reponse)) {

					card = new Carte(cursor.reponse, Sorte.CARREAU);
					
				}else {

					card = new Carte(cursor.reponse, Sorte.COEUR);
				}
				
				
			}else {

				card = new NullCard();
			}

			double targetTopLeftX = MARGIN_LEFT + cardWidth + cardWidth / 2 + i * cardWidth * 3 / 2;
			double targetTopLeftY = cardHeight * 3;

			card = cardHeap.firstInstanceOf(card);
			String card2dId = cardHeap.newCard2dId(card);
			
			cardsViewData.addOrUpdateCard(card2dId,
										  card,
										  targetTopLeftX,
										  targetTopLeftY);
			
			cardsViewData.displayCardFaceUp(card2dId);
			
			
			if(!visited.contains(cursor.getMoinsUn())) {
				i++;
				cursor = cursor.getMoinsUn();
			}else {
				cursor = null;
			}
		}
    }

    @Override
    public void initializeAsTestCase(AbstractTestCaseDescriptor descriptor) {
    	n = descriptor.inputSize();
    	if(descriptor.category().equals("recursif")) {
    		siRecursif = true;
    	}else {
    		siRecursif = false;
    	}
    }

    @Override
    public int testCaseSize() {
    	return n;
    }
    
    @Override
    protected Stream<Carte> cards() {
        return new StreamNtro<Carte>() {
            @Override
            public void forEach_(Visitor<Carte> visitor) throws Throwable {
				Fibonacci cursor = tete;
				
				while(cursor != null) {
					if(cursor.reponse != null) {
						visitor.visit(new Carte(tete.reponse, Sorte.COEUR));
					}
					cursor = cursor.getMoinsUn();
				}
            }
        };
    }


    @Override
    public void run() {
        construireGraphe();
    }

    public void construireGraphe() {
    }

    @Override
    public void displayOn(FibonacciVariablesView variablesView) {
    	variablesView.displayIsRecursive(String.valueOf(siRecursif));

    	if(tete != null
    			&& tete.getReponse() != null) {

			variablesView.displayAnswerLabel(String.valueOf(tete.getReponse()));
			variablesView.displayGoldenRatio(String.format("%.08f", tete.getNombreOr()));

    	}else if(tete != null
    			&& tete.getMoinsUn() != null
    			&& tete.getMoinsUn().getReponse() != null) {

			variablesView.displayAnswerLabel(String.valueOf(tete.getMoinsUn().getReponse()));
			variablesView.displayGoldenRatio(String.format("%.08f", tete.getMoinsUn().getNombreOr()));

    	}else {
			variablesView.displayAnswerLabel("");
			variablesView.displayGoldenRatio("");
    	}
    }

}
