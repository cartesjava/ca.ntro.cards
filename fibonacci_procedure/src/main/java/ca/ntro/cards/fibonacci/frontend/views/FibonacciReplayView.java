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
package ca.ntro.cards.fibonacci.frontend.views;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.cards.frontend.views.ProcedureReplayView;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FibonacciReplayView extends ProcedureReplayView {

	@FXML
	private Label numberOfStepsLabel;

	@FXML
	private Label currentStepLabel;

	@FXML
	private Label numberOfCardsLabel;


	@FXML
	private Button playButton;

	@FXML
	private Button pauseButton;

	@FXML
	private Button oneStepButton;

	@FXML
	private Button backStepButton;

	@FXML
	private Button rewindButton;

	@FXML
	private Button fastForwardButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Ntro.assertNotNull("numberOfStepsLabel", numberOfStepsLabel);
		Ntro.assertNotNull("currentStepLabel", currentStepLabel);
		Ntro.assertNotNull("numberOfCardsLabel", numberOfCardsLabel);
		Ntro.assertNotNull("playButton", playButton);
		Ntro.assertNotNull("pauseButton", pauseButton);
		Ntro.assertNotNull("oneStepButton", oneStepButton);
		Ntro.assertNotNull("backStepButton", backStepButton);
		Ntro.assertNotNull("rewindButton", rewindButton);
		Ntro.assertNotNull("fastForwardButton", fastForwardButton);
		
		
		
		super.initialize(location, resources);
	}

	@Override
	protected Label numberOfStepsLabel() {
		return numberOfStepsLabel;
	}

	@Override
	protected Label numberOfCardsLabel() {
		return numberOfCardsLabel;
	}

	@Override
	protected Button playButton() {
		return playButton;
	}

	@Override
	protected Button pauseButton() {
		return pauseButton;
	}

	@Override
	protected Button oneStepButton() {
		return oneStepButton;
	}

	@Override
	protected Button backStepButton() {
		return backStepButton;
	}

	@Override
	protected Label currentStepLabel() {
		return currentStepLabel;
	}

	@Override
	protected Button rewindButton() {
		return rewindButton;
	}

	@Override
	protected Button fastForwardButton() {
		return fastForwardButton;
	}

}
