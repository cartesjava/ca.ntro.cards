package ca.ntro.cards.models;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.ntro.app.models.Model;
import ca.ntro.app.models.WriteObjectGraph;
import ca.ntro.app.models.Watch;
import ca.ntro.cards.common.models.CommonExecutableModel;
import ca.ntro.cards.common.models.enums.Sorte;
import ca.ntro.cards.common.models.identifyers.IdNotUniqueException;
import ca.ntro.cards.common.models.values.cards.CardHeap;
import ca.ntro.cards.common.models.values.cards.Carte;
import ca.ntro.cards.frontend.ProcedureViewData;
import ca.ntro.cards.frontend.views.ProcedureVariablesView;
import ca.ntro.cards.models.values.ComparisonReport;
import ca.ntro.cards.models.world2d.ProcedureDrawingOptions;
import ca.ntro.cards.models.world2d.ProcedureObject2d;
import ca.ntro.cards.models.world2d.ProcedureWorld2d;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.reflection.object_graph.Initialize;
import ca.ntro.core.stream.Stream;

public abstract class      ProcedureCardsModel<CARDS_MODEL    extends ProcedureCardsModel,
                                               WORLD2D        extends ProcedureWorld2d<WORLD2D, OPTIONS>,
                                               OPTIONS        extends ProcedureDrawingOptions,
                                               VIEW_DATA      extends ProcedureViewData<WORLD2D, OPTIONS>,
                                               VARIABLES_VIEW extends ProcedureVariablesView>

                extends    CommonExecutableModel<CARDS_MODEL, ProcedureObject2d<WORLD2D, OPTIONS>, WORLD2D, OPTIONS, VIEW_DATA>

                implements Model, Watch, Initialize, WriteObjectGraph {


	protected Carte cardById(String cardId) {
		return cards().findFirst(card -> card.hasId(cardId));
	}
	
	protected abstract Stream<Carte> cards();
	
	@Override
	public void initialiser() {
	}

	public abstract boolean isValidNextStep(CARDS_MODEL nextStep);
	
	public abstract ComparisonReport compareToSolution(CARDS_MODEL solution);

	public void updateViewData(VIEW_DATA viewData) {
		
		CardHeap cardHeap = new CardHeap();

		updateViewDataImpl(cardHeap, viewData);
		
		viewData.removeCardsNotIn(cardHeap.card2dIds());
	}
	
	protected abstract void updateViewDataImpl(CardHeap cardHeap, VIEW_DATA viewData);
	
	public abstract void displayOn(VARIABLES_VIEW variablesView);
	

	protected Carte[] randomArrayOfUniqueCards(int size) {
		return randomArrayOfUniqueCards(size, List.of(Sorte.values()));
	}

	protected Carte[] randomArrayOfUniqueCards(int size, List<Sorte> suits) {
		List<Carte> randomList = randomListOfUniqueCards(size, suits);

		Carte[] array = new Carte[size];
		
		for(int i = 0; i < size; i++) {
			array[i] = randomList.get(i);
		}
		
		return array;
	}

	protected List<Carte> randomListOfUniqueCards(int size) {
		return randomListOfUniqueCards(size, List.of(Sorte.values()));
	}

	protected List<Carte> randomListOfUniqueCards(int size, List<Sorte> suits) {
		List<Carte> orderedList = orderedListOfRandomCards(size, suits);

		List<Carte> randomList = new ArrayList<>();
		
		while(!orderedList.isEmpty()) {
			int choosenCardIndex = Ntro.random().nextInt(orderedList.size());
			Carte choosenCard = orderedList.get(choosenCardIndex);
			
			randomList.add(choosenCard);
			orderedList.remove(choosenCardIndex);
		}
		
		return randomList;
	}

	protected List<Carte> orderedListOfRandomCards(int size) {
		return orderedListOfRandomCards(size, List.of(Sorte.values()));
	}

	protected List<Carte> orderedListOfRandomCards(int size, List<Sorte> suits) {
		List<Carte> orderedList = new ArrayList<>();
		
		Map<Sorte, Integer> numberOfCardsBySuit = new HashMap<>();
		int sum = 0;
		for(Sorte suit : suits) {
			int numberOfCardsThisSuit = size / Sorte.values().length;
			if(numberOfCardsThisSuit == 0
					&& Ntro.random().nextBoolean()) {

				numberOfCardsThisSuit = 1;
			}

			numberOfCardsBySuit.put(suit, numberOfCardsThisSuit);
			sum += numberOfCardsThisSuit;
		}
		
		while(sum < size) {
			int numberOfCardsFirstSuit = numberOfCardsBySuit.get(suits.get(0));
			sum++;
			numberOfCardsFirstSuit++;
			numberOfCardsBySuit.put(suits.get(0), numberOfCardsFirstSuit);
		}

		for(Sorte suit : suits) {
			for(int i = 0; i < numberOfCardsBySuit.get(suit); i++) {
				orderedList.add(new Carte(i+1, suit));
			}
		}

		return orderedList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		format(builder);
		
		return builder.toString();

	}
	
	public void format(StringBuilder builder) {
		cards().forEach(card -> {
			builder.append(System.lineSeparator());
			card.format(builder);
		});
	}

}
