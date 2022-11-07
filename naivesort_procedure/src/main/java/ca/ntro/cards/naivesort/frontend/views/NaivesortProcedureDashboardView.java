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
package ca.ntro.cards.naivesort.frontend.views;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.cards.frontend.views.ProcedureDashboardView;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class NaivesortProcedureDashboardView extends ProcedureDashboardView {
	
	@FXML
	private Label fpsLabel;

	@FXML
	private Button menuButton;

	@FXML
	private Button messageButton;

	@FXML
	private VBox selectionsContainer;

	@FXML
	private VBox replayControlsContainer;

	@FXML
	private VBox variablesContainer;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Ntro.assertNotNull("menuButton", menuButton);
		Ntro.assertNotNull("messageButton", messageButton);
		Ntro.assertNotNull("fpsLabel", fpsLabel);
		Ntro.assertNotNull("selectionsContainer", selectionsContainer);
		Ntro.assertNotNull("replayControlsContainer", replayControlsContainer);
		Ntro.assertNotNull("variablesContainer", variablesContainer);
		
		super.initialize(location, resources);
		
	}

	@Override
	protected Label fpsLabel() {
		return fpsLabel;
	}

	@Override
	protected Button menuButton() {
		return menuButton;
	}

	@Override
	protected Pane selectionsContainer() {
		return selectionsContainer;
	}

	@Override
	protected Pane replayControlsContainer() {
		return replayControlsContainer;
	}

	@Override
	protected Pane variablesContainer() {
		return variablesContainer;
	}

	@Override
	protected Button messageButton() {
		return messageButton;
	}


}
