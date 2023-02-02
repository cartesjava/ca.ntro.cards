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
package ca.ntro.cards.common.models.values.cards;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CardHeap {
	
	private Map<String, AbstractCard> firstInstanceById = new HashMap<>();
	private Map<String, Integer> indexById = new HashMap<>();
	private Set<String> card2dIds = new HashSet<>();
	
	public void addMarkerId(String markerId) {
		card2dIds.add(markerId);
	}

	public String newCard2dId(AbstractCard card) {
		Integer index = indexById.get(card.id());
		if(index == null) {
			index = 0;
		}
		
		indexById.put(card.id(),index + 1);
		
		String card2dId = card.id() + "_" + index;
		
		card2dIds.add(card2dId);
		
		return card2dId;
	}
	
	public AbstractCard firstInstanceOf(AbstractCard card) {

		AbstractCard firstInstance = firstInstanceById.get(card.id());

		if(firstInstance == null) {
			firstInstance = card;
			firstInstanceById.put(card.id(), firstInstance);
		}
		
		return firstInstance;
	}

	public Set<String> card2dIds() {
		return card2dIds;
	}
	
}
