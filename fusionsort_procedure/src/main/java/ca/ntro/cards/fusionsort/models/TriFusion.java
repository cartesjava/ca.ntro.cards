package ca.ntro.cards.fusionsort.models;


import ca.ntro.cards.common.models.enums.Sorte;
import ca.ntro.cards.common.models.values.cards.CardHeap;
import ca.ntro.cards.common.models.values.cards.Carte;
import ca.ntro.cards.common.test_cases.descriptor.AbstractTestCaseDescriptor;
import ca.ntro.cards.fusionsort.frontend.FusionsortProcedureViewData;
import ca.ntro.cards.fusionsort.frontend.views.FusionsortVariablesView;
import ca.ntro.cards.fusionsort.models.world2d.FusionsortProcedureDrawingOptions;
import ca.ntro.cards.fusionsort.models.world2d.FusionsortProcedureWorld2d;
import ca.ntro.cards.models.ProcedureCardsModel;
import ca.ntro.cards.models.values.ComparisonReport;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.stream.Stream;
import ca.ntro.core.stream.StreamNtro;
import ca.ntro.core.stream.Visitor;

               // TODO: renommer
public class   TriFusion<C extends Comparable<C>> 

       extends ProcedureCardsModel<TriFusion, 
                                   FusionsortProcedureWorld2d, 
                                   FusionsortProcedureDrawingOptions, 
                                   FusionsortProcedureViewData,
                                   FusionsortVariablesView> { 
	
	public TriFusion<C> gauche;
	public TriFusion<C> droite;
	public C[] tableau = (C[]) new Carte[0];
	
    public TriFusion<C> getGauche() {
		return gauche;
	}

	public void setGauche(TriFusion<C> gauche) {
		this.gauche = gauche;
	}

	public TriFusion<C> getDroite() {
		return droite;
	}

	public void setDroite(TriFusion<C> droite) {
		this.droite = droite;
	}

	public C[] getTableau() {
		return tableau;
	}

	public void setTableau(C[] tableau) {
		this.tableau = tableau;
	}
	
	public TriFusion() {
		
	}

	public TriFusion(int taille) {
		setTableau((C[]) new Carte[taille]);
}

	@Override
    public void copyDataFrom(TriFusion other) {
		tableau = (C[]) new Carte[other.tableau.length];
		for(int i = 0; i < tableau.length; i++) {
			//Card card = (Card) other.tableau[i];
			//Card clone = card.clone();
			tableau[i] = (C) other.tableau[i];
		}
		
		if(other.gauche != null) {
			gauche = new TriFusion<>();
			gauche.copyDataFrom(other.gauche);
		}
		
		if(other.droite != null) {
			droite = new TriFusion<>();
			droite.copyDataFrom(other.droite);
		}
    }

	@Override
	public boolean isValidNextStep(TriFusion manualModel) {
		boolean modified = false;

		// TODO: accepter ou rejeter les modifications manuelles
		//       retourner faux si c'est rejeté

		return modified;
	}

	@Override
	public ComparisonReport compareToSolution(TriFusion solution) {
		ComparisonReport report = ComparisonReport.emptyReport();
		return report;
	}

    @Override
    protected void updateViewDataImpl(CardHeap cardHeap, FusionsortProcedureViewData cardsViewData) {
        // TODO: créer des Carte2d pour afficher les cartes du modèle
    }

    @Override
    public void initializeAsTestCase(AbstractTestCaseDescriptor descriptor) {
        if(descriptor.testCaseId().equals("ex01")) {

			tableau = (C[]) new Carte[] {new Carte(2, Sorte.TREFLE), 
					                    new Carte(5, Sorte.TREFLE), 
					                    new Carte(5, Sorte.CARREAU), 
					                    new Carte(5, Sorte.COEUR), 
					                    new Carte(7, Sorte.PIQUE), 
					                    new Carte(2, Sorte.COEUR)};

        }

        // TODO: créer les autres cas de test
    }

    @Override
    public int testCaseSize() {
    	return tableau.length;
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
        trier();
    }

    // TODO: renommer
    public void trier() {
    }
    
    protected C[] nouveauTableau(int size) {
    	return (C[]) new Carte[size];
    }

    @Override
    public void displayOn(FusionsortVariablesView variablesView) {
        // TODO: afficher les attributs
    }



}
