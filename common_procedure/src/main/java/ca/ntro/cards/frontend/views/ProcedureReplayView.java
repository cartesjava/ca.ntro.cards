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
package ca.ntro.cards.frontend.views;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.cards.common.messages.MsgStopExecutionReplay;
import ca.ntro.cards.frontend.events.EvtStartExecutionReplay;
import ca.ntro.cards.messages.MsgExecutionFastForwardToLastStep;
import ca.ntro.cards.messages.MsgExecutionRewindToFirstStep;
import ca.ntro.cards.messages.MsgExecutionStepBack;
import ca.ntro.cards.messages.MsgExecutionStepForward;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public abstract class ProcedureReplayView extends ViewFx {

	protected abstract Label numberOfStepsLabel();

	protected abstract Label currentStepLabel();

	protected abstract Label numberOfCardsLabel();

	protected abstract Button playButton();

	protected abstract Button pauseButton();

	protected abstract Button oneStepButton();

	protected abstract Button backStepButton();

	protected abstract Button rewindButton();

	protected abstract Button fastForwardButton();


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		EvtStartExecutionReplay           evtStartCodeExecution   = NtroApp.newEvent(EvtStartExecutionReplay.class);
		MsgStopExecutionReplay            msgStopCodeExecution    = NtroApp.newMessage(MsgStopExecutionReplay.class);
		MsgExecutionStepBack              msgExecutionStepBack    = NtroApp.newMessage(MsgExecutionStepBack.class);
		MsgExecutionStepForward           msgExecutionStepForward = NtroApp.newMessage(MsgExecutionStepForward.class);
		MsgExecutionRewindToFirstStep     msgRewind               = NtroApp.newMessage(MsgExecutionRewindToFirstStep.class);
		MsgExecutionFastForwardToLastStep msgFastForward          = NtroApp.newMessage(MsgExecutionFastForwardToLastStep.class);
		
		playButton().setOnAction(evtFx -> {

			evtStartCodeExecution.trigger();

		});

		pauseButton().setOnAction(evtFx -> {

			msgStopCodeExecution.send();

		});

		oneStepButton().setOnAction(evtFx -> {
			
			msgExecutionStepForward.send();

		});
		
		backStepButton().setOnAction(evtFx -> {
			
			msgExecutionStepBack.send();
			
		});
		
		if(rewindButton() != null) {
			rewindButton().setOnAction(evtFx -> {
				msgRewind.send();
			});
		}
		
		if(fastForwardButton() != null) {
			fastForwardButton().setOnAction(evtFx -> {
				msgFastForward.send();
			});
		}

	}

	public void disableExecutionButtons() {
		playButton().setDisable(true);
		pauseButton().setDisable(true);
		oneStepButton().setDisable(true);
		fastForwardButton().setDisable(true);
		rewindButton().setDisable(true);
	}

	public void displayNumberOfSteps(String numberOfSteps) {
		if(numberOfStepsLabel() != null) {
			numberOfStepsLabel().setText(numberOfSteps);
		}
	}

	public void displayCurrentStep(String currentStep) {
		if(currentStepLabel() != null) {
			currentStepLabel().setText(currentStep);
		}
	}

	public void displayNumberOfCards(String numberOfCards) {
		if(numberOfCardsLabel() != null) {
			numberOfCardsLabel().setText(numberOfCards);
		}
	}



}
