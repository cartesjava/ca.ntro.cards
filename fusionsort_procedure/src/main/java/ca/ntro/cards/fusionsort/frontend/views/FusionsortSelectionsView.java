package ca.ntro.cards.fusionsort.frontend.views;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.cards.fusionsort.frontend.views.fragments.FusionsortTestCaseFragment;
import ca.ntro.cards.frontend.views.ProcedureSelectionsView;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class FusionsortSelectionsView extends ProcedureSelectionsView<FusionsortTestCaseFragment> {
	
	@FXML
	private Pane testCaseContainer;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Ntro.assertNotNull("testCaseContainer", testCaseContainer);
		
		super.initialize(location, resources);
	}

	@Override
	protected Pane testCaseContainer() {
		return testCaseContainer;
	}

	@Override
	protected Pane idContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Pane sizeContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Pane manualContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Pane codeContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Pane solutionContainer() {
		// TODO Auto-generated method stub
		return null;
	}
}