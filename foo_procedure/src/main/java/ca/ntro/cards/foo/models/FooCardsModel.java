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
package ca.ntro.cards.foo.models;


import ca.ntro.cards.common.models.values.cards.CardHeap;
import ca.ntro.cards.common.models.values.cards.Carte;
import ca.ntro.cards.common.test_cases.descriptor.AbstractTestCaseDescriptor;
import ca.ntro.cards.foo.frontend.FooProcedureViewData;
import ca.ntro.cards.foo.frontend.views.FooVariablesView;
import ca.ntro.cards.foo.models.world2d.FooProcedureDrawingOptions;
import ca.ntro.cards.foo.models.world2d.FooProcedureWorld2d;
import ca.ntro.cards.models.ProcedureCardsModel;
import ca.ntro.cards.models.values.ComparisonReport;
import ca.ntro.core.stream.Stream;
import ca.ntro.core.stream.StreamNtro;
import ca.ntro.core.stream.Visitor;

               // TODO: renommer
public class   FooCardsModel<C extends Comparable<C>> 

       extends ProcedureCardsModel<FooCardsModel, 
                                   FooProcedureWorld2d, 
                                   FooProcedureDrawingOptions, 
                                   FooProcedureViewData,
                                   FooVariablesView> { 

    @Override
    public void copyDataFrom(FooCardsModel other) {
        // TODO: copier les données telles quelles

    }

	@Override
	public boolean isValidNextStep(FooCardsModel manualModel) {
		boolean modified = false;

		// TODO: accepter ou rejeter les modifications manuelles
		//       retourner faux si c'est rejeté

		return modified;
	}

	@Override
	public ComparisonReport compareToSolution(FooCardsModel solution) {
		
		ComparisonReport report = ComparisonReport.emptyReport();
		
		// TODO: compare to a solution and report every error
		//       the testcase is passed if there is no error
		//       to report

		return report;
	}


    @Override
    protected void updateViewDataImpl(CardHeap cardHeap, FooProcedureViewData cardsViewData) {
        // TODO: créer des Carte2d pour afficher les cartes du modèle
    }

    @Override
    public void initializeAsTestCase(AbstractTestCaseDescriptor descriptor) {
        if(descriptor.testCaseId().equals("ex01")) {

            // TODO: créer le case de test ex01

        }

        // TODO: créer les autres cas de test
    }

    @Override
    public int testCaseSize() {
        // TODO: 
    	return 0;
    }
    
    @Override
    protected Stream<Carte> cards() {
        return new StreamNtro<Carte>() {
            @Override
            public void forEach_(Visitor<Carte> visitor) throws Throwable {
                // TODO: visiter chaque carte
            }
        };
    }


    @Override
    public void run() {
    	// TODO: adapter au besoin
        studentMain();
    }

    // TODO: renommer
    public void studentMain() {
    }

    @Override
    public void displayOn(FooVariablesView variablesView) {
        // TODO: afficher les attributs
    }




}
