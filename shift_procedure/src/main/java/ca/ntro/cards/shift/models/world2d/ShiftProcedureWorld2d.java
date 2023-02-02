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
package ca.ntro.cards.shift.models.world2d;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.NtroApp;
import ca.ntro.app.world2d.Object2d;
import ca.ntro.cards.common.CommonConstants;
import ca.ntro.cards.common.models.values.cards.AbstractCard;
import ca.ntro.cards.common.models.values.cards.Carte;
import ca.ntro.cards.shift.ShiftConstants;
import ca.ntro.cards.shift.messages.ShiftMsgAcceptManualModel;
import ca.ntro.cards.shift.models.Tableau;
import ca.ntro.cards.messages.ProcedureMsgAcceptManualModel;
import ca.ntro.cards.models.world2d.ProcedureObject2d;
import ca.ntro.cards.models.world2d.ProcedureWorld2d;

public class ShiftProcedureWorld2d extends ProcedureWorld2d<ShiftProcedureWorld2d, ShiftProcedureDrawingOptions> {
    
    private ShiftMsgAcceptManualModel msgManualExecutionStep = NtroApp.newMessage(ShiftMsgAcceptManualModel.class);
    
    @Override
    public void buildAndSendManualModel() {
     	
    	List<ShiftCard2d> cards2d = new ArrayList<>();
		
		for(Object2d object2d : getObjects()) {

			if(object2d instanceof ShiftCard2d) {

				cards2d.add((ShiftCard2d) object2d);

			}
		}
		
		cards2d.sort((obj01, obj02) -> {
			return Double.compare(obj01.getTopLeftX(), obj02.getTopLeftX());
		});
    	
    	
		//double markerTopLeftX = 10 + cardWidth + cardWidth / 2 + getIndicePlusPetit() * cardWidth * 3 / 2;
		double cardWidth = ShiftConstants.INITIAL_CARD_WIDTH_MILIMETERS;
		double cardHeight = ShiftConstants.INITIAL_CARD_HEIGHT_MILIMETERS;

		Object2d marker2d = objectById("i");
		int indexOfI = (int) Math.round((marker2d.topLeftX() - 10 - cardWidth - cardWidth / 2) * 2 / 3 / cardWidth);
		
		marker2d = objectById("toRemove");
		int indexOfToRemove = (int) Math.round((marker2d.topLeftX() - 10 - cardWidth - cardWidth / 2) * 2 / 3 / cardWidth);
        
        Tableau manualModel = new Tableau();
        
        Carte[] cartes = new Carte[cards2d.size()];
        for(int i = 0; i < cartes.length; i++) {
        	AbstractCard card = cards2d.get(i).getCard();
        	
        	if(card instanceof Carte) {
        	
        		cartes[i] = (Carte) card;
        		
        	}else {
        		
        		cartes[i] = null;
        	}      	
        }
        
        manualModel.setI(indexOfI);
        manualModel.setADeplacer(indexOfToRemove);
        manualModel.setCartes(cartes);
        
        msgManualExecutionStep.setManualModel(manualModel);
        msgManualExecutionStep.send();
    }

}
