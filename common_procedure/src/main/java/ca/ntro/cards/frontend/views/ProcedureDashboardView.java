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

import ca.ntro.cards.common.frontend.views.CommonDashboardView;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public abstract class ProcedureDashboardView extends CommonDashboardView {
	
	protected abstract Pane selectionsContainer();

	protected abstract Pane replayControlsContainer();

	protected abstract Pane variablesContainer();


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
		
	}

	public void installSelectionsView(ProcedureSelectionsView selectionsView) {
		if(selectionsContainer() != null) {
			selectionsContainer().getChildren().clear();
			selectionsContainer().getChildren().add(selectionsView.rootNode());
		}
	}

	public void installReplayControlsView(ProcedureReplayView replayControlsView) {
		if(replayControlsContainer() != null) {
			replayControlsContainer().getChildren().clear();
			replayControlsContainer().getChildren().add(replayControlsView.rootNode());
		}
	}

	public void installVariablesView(ProcedureVariablesView variablesView) {
		if(variablesContainer() != null) {
			variablesContainer().getChildren().clear();
			variablesContainer().getChildren().add(variablesView.rootNode());
		}
	}

	public void clearTestCases() {
	}

	public void addTestCase(String testCaseId) {
	}


}
