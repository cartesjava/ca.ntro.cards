package ca.ntro.cards.shift2.models.world2d;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.NtroApp;
import ca.ntro.app.world2d.Object2d;
import ca.ntro.cards.common.CommonConstants;
import ca.ntro.cards.common.models.values.cards.AbstractCard;
import ca.ntro.cards.common.models.values.cards.Carte;
import ca.ntro.cards.shift2.Shift2Constants;
import ca.ntro.cards.shift2.messages.Shift2MsgAcceptManualModel;
import ca.ntro.cards.shift2.models.Tableau;
import ca.ntro.cards.messages.ProcedureMsgAcceptManualModel;
import ca.ntro.cards.models.world2d.ProcedureObject2d;
import ca.ntro.cards.models.world2d.ProcedureWorld2d;

public class Shift2ProcedureWorld2d extends ProcedureWorld2d<Shift2ProcedureWorld2d, Shift2ProcedureDrawingOptions> {
    
    private Shift2MsgAcceptManualModel msgManualExecutionStep = NtroApp.newMessage(Shift2MsgAcceptManualModel.class);
    
    @Override
    public void buildAndSendManualModel() {
     	
    	List<Shift2Card2d> cards2d = new ArrayList<>();
		
		for(Object2d object2d : getObjects()) {

			if(object2d instanceof Shift2Card2d) {

				cards2d.add((Shift2Card2d) object2d);

			}
		}
		
		cards2d.sort((obj01, obj02) -> {
			return Double.compare(obj01.getTopLeftX(), obj02.getTopLeftX());
		});
    	
    	
		//double markerTopLeftX = 10 + cardWidth + cardWidth / 2 + getIndicePlusPetit() * cardWidth * 3 / 2;
		double cardWidth = Shift2Constants.INITIAL_CARD_WIDTH_MILIMETERS;
		double cardHeight = Shift2Constants.INITIAL_CARD_HEIGHT_MILIMETERS;

		Object2d marker2d = objectById("i");
		int indexOfI = (int) Math.round((marker2d.topLeftX() - 10 - cardWidth - cardWidth / 2) * 2 / 3 / cardWidth);
		
		marker2d = objectById("toRemove");
		int indexOfToRemove = (int) Math.round((marker2d.topLeftX() - 10 - cardWidth - cardWidth / 2) * 2 / 3 / cardWidth);
        
        Tableau manualModel = new Tableau();
        
        //List<Carte> cards = new ArrayList<>();
        Carte[] cards = new Carte[cards2d.size()];
        for(int i = 0; i < cards2d.size(); i++) {
        	AbstractCard card = cards2d.get(i).getCard();
        	
        	if(card instanceof Carte) {
        	
        		//cards.add((Carte) card);
        		cards[i] = (Carte) card;
        		
        	}else {
        		
        		//cards.add(null);
        		cards[i] = null;
        	}      	
        }
        
        manualModel.setI(indexOfI);
        manualModel.setADeplacer(indexOfToRemove);
        manualModel.setCartes(cards);
        
        msgManualExecutionStep.setManualModel(manualModel);
        msgManualExecutionStep.send();
    }

}
