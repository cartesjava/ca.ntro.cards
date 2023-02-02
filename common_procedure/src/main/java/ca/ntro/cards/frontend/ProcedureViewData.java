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
package ca.ntro.cards.frontend;

import java.util.HashSet;
import java.util.Set;

import ca.ntro.app.NtroApp;
import ca.ntro.cards.common.CommonConstants;
import ca.ntro.cards.common.frontend.CommonViewData;
import ca.ntro.cards.common.models.values.cards.AbstractCard;
import ca.ntro.cards.common.models.values.cards.CardHeap;
import ca.ntro.cards.common.models.values.cards.Carte;
import ca.ntro.cards.common.models.world2d.CommonObject2d;
import ca.ntro.cards.messages.MsgExecutionStepForward;
import ca.ntro.cards.models.world2d.ProcedureCard2d;
import ca.ntro.cards.models.world2d.ProcedureDrawingOptions;
import ca.ntro.cards.models.world2d.ProcedureMarker2d;
import ca.ntro.cards.models.world2d.ProcedureObject2d;
import ca.ntro.cards.models.world2d.ProcedureWorld2d;
import ca.ntro.core.stream.Stream;

public abstract class   ProcedureViewData<WORLD2D  extends ProcedureWorld2d<WORLD2D, OPTIONS>,
                                          OPTIONS  extends ProcedureDrawingOptions>

                extends CommonViewData<ProcedureObject2d<WORLD2D, OPTIONS>, WORLD2D, OPTIONS> {

	private boolean isExecutionReplayInProgress = false;
	private double timeSinceLastReplayStep;
	private MsgExecutionStepForward msgExecutionStepForward = NtroApp.newMessage(MsgExecutionStepForward.class);

	public void onTimePasses(double secondsElapsed) {
		if(isExecutionReplayInProgress) {

			timeSinceLastReplayStep -= secondsElapsed;
			
			if(timeSinceLastReplayStep < 0) {
				timeSinceLastReplayStep = CommonConstants.SECONDS_BETWEEN_EXECUTION_STEPS;
				msgExecutionStepForward.send();
			}
		}

		super.onTimePasses(secondsElapsed);
	}

	public void startExecutionReplay() {
		isExecutionReplayInProgress = true;
		timeSinceLastReplayStep = CommonConstants.SECONDS_BETWEEN_EXECUTION_STEPS;
	}

	public void stopExecutionReplay() {
		isExecutionReplayInProgress = false;
	}

	public void addOrUpdateMarker(String markerId, 
			                      String color, 
			                      double topLeftX, 
			                      double topLeftY) {
		
		ProcedureMarker2d<WORLD2D, OPTIONS> marker2d = null;

		marker2d = (ProcedureMarker2d) world2d().objectById(markerId);

		if(marker2d == null) {
			marker2d = new ProcedureMarker2d(markerId, color);
			world2d().addObject2d(marker2d);
		}
		
		marker2d.setTopLeftX(topLeftX);
		marker2d.setTopLeftY(topLeftY);
	}

	public void addOrUpdateMarker(String markerId, 
			                      double topLeftX, 
			                      double topLeftY) {

		addOrUpdateMarker(markerId, "#03cffc", topLeftX, topLeftY);
	}

	public void setCardFaceUp(String cardId, boolean faceUp) {

		ProcedureCard2d card2d = (ProcedureCard2d) world2d().objectById(cardId);

		if(card2d != null) {
			card2d.setFaceUp(faceUp);
		}
	}

	public void setCardFaceUp(AbstractCard card, boolean faceUp) {
		setCardFaceUp(card.id(), faceUp);
	}

	public void displayCardFaceDown(String card2dId) {
		setCardFaceUp(card2dId, false);
	}

	public void displayCardFaceDown(AbstractCard card) {
		setCardFaceUp(card.id(), false);
	}

	public void displayCardFaceUp(String card2dId) {
		setCardFaceUp(card2dId, true);
	}

	public void displayCardFaceUp(AbstractCard card) {
		setCardFaceUp(card.id(), true);
	}

	public void removeNullCards() {
		Set<String> toRemove = new HashSet<>();
		
		for(CommonObject2d object2d : world2d.getObjects()) {
			if(object2d instanceof ProcedureCard2d) {
				if(((ProcedureCard2d) object2d).isNullCard()) {
					toRemove.add(object2d.id());
				}
			}
		}
		
		world2d.removeObject2dIn(toRemove);

	}

	public void addOrUpdateCard(AbstractCard card, double topLeftX, double topLeftY) {
		addOrUpdateCard(card.id(), card, topLeftX, topLeftY);
	}

	public void addOrUpdateCard(String card2dId, 
			                    AbstractCard card, 
			                    double topLeftX, 
			                    double topLeftY) {
		
		boolean animateCard = true;

		ProcedureCard2d card2d = (ProcedureCard2d) world2d().objectById(card2dId);
		
		if(card2d == null) {
			card2d = newCard2d(card2dId, card);
			world2d().addObject2d(card2d);
			animateCard = false;
		}
		
		if(card2d.isNullCard()) {
			animateCard = false;
		}
		
		if(animateCard) {

			card2d.setTarget(topLeftX, topLeftY);
			
		}else {
			
			card2d.setTopLeftX(topLeftX);
			card2d.setTopLeftY(topLeftY);

		}
	}

	protected abstract ProcedureCard2d newCard2d(String card2dId, AbstractCard card);

	public void removeCardsNotIn(Set<String> ids) {
		world2d.removeObject2dNotIn(ids);
	}


}
