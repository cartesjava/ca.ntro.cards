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
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import ca.ntro.app.views.ViewFx;
import ca.ntro.cards.frontend.views.fragments.ProcedureTestCaseFragment;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public abstract class ProcedureSelectionsView<TEST_CASE_FRAGMENT extends ProcedureTestCaseFragment> extends ViewFx {

	protected abstract Pane idContainer();

	protected abstract Pane sizeContainer();

	protected abstract Pane manualContainer();

	protected abstract Pane codeContainer();

	protected abstract Pane solutionContainer();
	
	protected abstract Pane testCaseContainer();
	
	private Map<String, TEST_CASE_FRAGMENT> testCaseFragmentById = new HashMap<>();
	
	private long version = -1;
	
	private double idLeftX = -1;
	private double sizeLeftX = -1;
	private double manualLeftX = -1;
	private double codeLeftX = -1;
	private double solutionLeftX = -1;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void clearTestCases() {
		testCaseContainer().getChildren().clear();
	}

	public void insertTestCase(int index, TEST_CASE_FRAGMENT testCaseFragment) {
		testCaseFragmentById.put(testCaseFragment.testCaseId(), testCaseFragment);
		testCaseContainer().getChildren().add(index, testCaseFragment.rootNode());

		if(idContainer() != null) {
			testCaseFragment.idContainer().translateXProperty().bind(idContainer().layoutXProperty());
			testCaseFragment.idContainer().minWidthProperty().bind(idContainer().widthProperty());
			testCaseFragment.idContainer().maxWidthProperty().bind(idContainer().widthProperty());
		}
		
		if(sizeContainer() != null) {
			testCaseFragment.sizeContainer().translateXProperty().bind(sizeContainer().layoutXProperty());
			testCaseFragment.sizeContainer().minWidthProperty().bind(sizeContainer().widthProperty());
			testCaseFragment.sizeContainer().maxWidthProperty().bind(sizeContainer().widthProperty());
		}

		if(manualContainer() != null) {
			testCaseFragment.manualContainer().translateXProperty().bind(manualContainer().layoutXProperty());
			testCaseFragment.manualContainer().minWidthProperty().bind(manualContainer().widthProperty());
			testCaseFragment.manualContainer().maxWidthProperty().bind(manualContainer().widthProperty());
		}

		if(codeContainer() != null) {
			testCaseFragment.codeContainer().translateXProperty().bind(codeContainer().layoutXProperty());
			testCaseFragment.codeContainer().minWidthProperty().bind(codeContainer().widthProperty());
			testCaseFragment.codeContainer().maxWidthProperty().bind(codeContainer().widthProperty());
		}

		if(solutionContainer() != null) {
			testCaseFragment.solutionContainer().translateXProperty().bind(solutionContainer().layoutXProperty());
			testCaseFragment.solutionContainer().minWidthProperty().bind(solutionContainer().widthProperty());
			testCaseFragment.solutionContainer().maxWidthProperty().bind(solutionContainer().widthProperty());
		}
		
		
		
		
	}
	
	public TEST_CASE_FRAGMENT testCaseFragment(String testCaseId) {
		return testCaseFragmentById.get(testCaseId);
	}

	public boolean hasEarlierVersion(long version) {
		return this.version < version;
	}

	public void memorizeVersion(long version) {
		this.version = version;
	}

}
