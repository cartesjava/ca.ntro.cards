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
package ca.ntro.cards.shift.frontend.views.fragments;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.cards.frontend.views.fragments.ProcedureTestCaseFragment;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class ShiftTestCaseFragment extends ProcedureTestCaseFragment {

	@FXML
	protected Label testCaseIdLabel;

	@FXML
	protected Label inputSizeLabel;

	@FXML
	protected Button manualButton;

	@FXML
	protected Button codeButton;

	@FXML
	protected Button solutionButton;

	@FXML 
	private Pane idContainer;

	@FXML 
	private Pane sizeContainer;

	@FXML 
	private Pane manualContainer;

	@FXML 
	private Pane codeContainer;

	@FXML 
	private Pane solutionContainer;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Ntro.assertNotNull("testCaseIdLabel", testCaseIdLabel);
		Ntro.assertNotNull("inputSizeLabel", inputSizeLabel);
		Ntro.assertNotNull("manualButton", manualButton);
		Ntro.assertNotNull("codeButton", codeButton);
		Ntro.assertNotNull("solutionButton", solutionButton);

		Ntro.assertNotNull("idContainer", idContainer);
		Ntro.assertNotNull("sizeContainer", sizeContainer);
		Ntro.assertNotNull("manualContainer", manualContainer);
		Ntro.assertNotNull("codeContainer", codeContainer);
		Ntro.assertNotNull("solutionContainer", solutionContainer);
		
		
		super.initialize(location, resources);
	}

	@Override
	protected Label testCaseIdLabel() {
		return testCaseIdLabel;
	}

	@Override
	protected Label inputSizeLabel() {
		return inputSizeLabel;
	}

	@Override
	protected Button manualButton() {
		return manualButton;
	}

	@Override
	protected Button codeButton() {
		return codeButton;
	}

	@Override
	protected Button solutionButton() {
		return solutionButton;
	}

	@Override
	public Pane idContainer() {
		return idContainer;
	}

	@Override
	public Pane sizeContainer() {
		return sizeContainer;
	}

	@Override
	public Pane manualContainer() {
		return manualContainer;
	}

	@Override
	public Pane codeContainer() {
		return codeContainer;
	}

	@Override
	public Pane solutionContainer() {
		return solutionContainer;
	}

}
