package ca.ntro.cards.freesort.frontend.views;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.cards.frontend.views.ProcedureVariablesView;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FreesortVariablesView extends ProcedureVariablesView {
	
	@FXML
	private Label ifSortedLabel;


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Ntro.assertNotNull("ifSortedLabel", ifSortedLabel);

		super.initialize(location, resources);
	}

	public void displayIfSorted(String value) {
		ifSortedLabel.setText(value);
	}

}
