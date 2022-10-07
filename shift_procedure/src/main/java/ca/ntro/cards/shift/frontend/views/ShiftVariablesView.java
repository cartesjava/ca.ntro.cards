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
