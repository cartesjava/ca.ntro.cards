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
