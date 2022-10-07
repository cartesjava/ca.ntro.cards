package ca.ntro.cards.shift2.frontend.views;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.cards.shift2.frontend.views.fragments.Shift2TestCaseFragment;
import ca.ntro.cards.frontend.views.ProcedureSelectionsView;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class Shift2SelectionsView extends ProcedureSelectionsView<Shift2TestCaseFragment> {

	@FXML
	private Pane testCaseContainer;
	
	@FXML 
	private Pane idContainer;

	@FXML 
	private Pane sizeContainer;

	//@FXML 
	//private Pane manualContainer;

	@FXML 
	private Pane codeContainer;

	@FXML 
	private Pane solutionContainer;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Ntro.assertNotNull("testCaseContainer", testCaseContainer);

		Ntro.assertNotNull("idContainer", idContainer);
		Ntro.assertNotNull("sizeContainer", sizeContainer);
		//Ntro.assertNotNull("manualContainer", manualContainer);
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
		//return manualContainer;
		return null;
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
