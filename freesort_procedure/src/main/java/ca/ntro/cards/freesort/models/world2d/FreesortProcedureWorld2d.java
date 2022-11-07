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
package ca.ntro.cards.freesort.models.world2d;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.NtroApp;
import ca.ntro.app.world2d.Object2d;
import ca.ntro.cards.common.models.values.cards.Carte;
import ca.ntro.cards.freesort.messages.FreesortMsgAcceptManualModel;
import ca.ntro.cards.freesort.models.TriLibre;
import ca.ntro.cards.models.world2d.ProcedureWorld2d;

public class FreesortProcedureWorld2d extends ProcedureWorld2d<FreesortProcedureWorld2d, FreesortProcedureDrawingOptions> {
	
	private FreesortMsgAcceptManualModel msgAcceptManualModel = NtroApp.newMessage(FreesortMsgAcceptManualModel.class);
	
	@Override
	public void buildAndSendManualModel() {

		List<FreesortCard2d> cards2d = new ArrayList<>();
		
		for(Object2d object2d : getObjects()) {

			if(object2d instanceof FreesortCard2d) {

				cards2d.add((FreesortCard2d) object2d);

			}
		}
		
		cards2d.sort((obj01, obj02) -> {
			return Double.compare(obj01.getTopLeftX(), obj02.getTopLeftX());
		});
		
		TriLibre manualModel = new TriLibre();
		
		Carte[] cards = new Carte[cards2d.size()];
		for(int i = 0; i < cards.length; i++) {
			cards[i] = (Carte) cards2d.get(i).getCard();
		}

		manualModel.setCartes(cards);
		
		
		msgAcceptManualModel.setManualModel(manualModel);
		msgAcceptManualModel.send();
	}

}
