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
package ca.ntro.cards.foo.frontend.views;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.cards.foo.frontend.views.fragments.FooTestCaseFragment;
import ca.ntro.cards.frontend.views.ProcedureSelectionsView;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class FooSelectionsView extends ProcedureSelectionsView<FooTestCaseFragment> {

	@FXML
	private Pane testCaseContainer;
	
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
		
		Ntro.assertNotNull("testCaseContainer", testCaseContainer);

		Ntro.assertNotNull("idContainer", idContainer);
		Ntro.assertNotNull("sizeContainer", sizeContainer);
		Ntro.assertNotNull("manualContainer", manualContainer);
		Ntro.assertNotNull("codeContainer", codeContainer);
		Ntro.assertNotNull("solutionContainer", solutionContainer);
		Ntro.assertNotNull("testCaseContainer", testCaseContainer);
		
		super.initialize(location, resources);
	}

	@Override
	protected Pane testCaseContainer() {
		return testCaseContainer;
	}

	@Override
	protected Pane idContainer() {
		return idContainer;
	}

	@Override
	protected Pane sizeContainer() {
		return sizeContainer;
	}

	@Override
	protected Pane manualContainer() {
		return manualContainer;
	}

	@Override
	protected Pane codeContainer() {
		return codeContainer;
	}

	@Override
	protected Pane solutionContainer() {
		return solutionContainer;
	}
}
