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
package ca.ntro.cards.shift.frontend.views;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.cards.frontend.views.ProcedureVariablesView;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ShiftVariablesView extends ProcedureVariablesView {
	
	@FXML
	private Label insererAuDebutLabel;

	@FXML
	private Label aDeplacerLabel;

	@FXML
	private Label iLabel;

	@FXML
	private Label memoireALabel;

	@FXML
	private Label memoireBLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Ntro.assertNotNull("insererAuDebutLabel", insererAuDebutLabel);
		Ntro.assertNotNull("aDeplacerLabel);", aDeplacerLabel);
		Ntro.assertNotNull("iLabel", iLabel);
		Ntro.assertNotNull("memoireALabel", memoireALabel);
		Ntro.assertNotNull("memoireBLabel", memoireBLabel);

		super.initialize(location, resources);
	}
	
	public void displayInsererAuDebut(String value) {
		insererAuDebutLabel.setText(value);
	}
	
	public void displayADeplacer(String value) {
		aDeplacerLabel.setText(value);
	}
	
	public void displayI(String value) {
		iLabel.setText(value);
	}
	
	public void displayMemoireA(String value) {
		memoireALabel.setText(value);
	}

	public void displayMemoireB(String value) {
		memoireBLabel.setText(value);
	}
	

}
