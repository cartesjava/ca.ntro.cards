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

import ca.ntro.cards.frontend.views.ProcedureVariablesView;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FibonacciVariablesView extends ProcedureVariablesView {
	
	@FXML
	private Label isRecursiveLabel;

	@FXML
	private Label answerLabel;

	@FXML
	private Label goldenRatioLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Ntro.assertNotNull("isRecursiveLabel", isRecursiveLabel);
		Ntro.assertNotNull("answerLabel", answerLabel);
		Ntro.assertNotNull("goldenRatioLabel", goldenRatioLabel);

		super.initialize(location, resources);
	}

	public void displayIsRecursive(String value) {
		isRecursiveLabel.setText(value);
	}

	public void displayAnswerLabel(String value) {
		answerLabel.setText(value);
	}

	public void displayGoldenRatio(String value) {
		goldenRatioLabel.setText(value);
	}

}
