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
package ca.ntro.cards.naivesort.frontend.views;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.cards.frontend.views.ProcedureMessagesView;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.stream.Stream;
import ca.ntro.core.stream.StreamNtro;
import ca.ntro.core.stream.Visitor;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class NaivesortProcedureMessagesView extends ProcedureMessagesView {
	
	@FXML
	private Pane leftSpace;

	@FXML
	private Pane rightSpace;

	@FXML
	private Pane topSpace;

	@FXML
	private Pane bottomSpace;

	@FXML
	private Pane messagesContainer;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Ntro.assertNotNull("leftSpace", leftSpace);
		Ntro.assertNotNull("rightSpace", rightSpace);
		Ntro.assertNotNull("topSpace", topSpace);
		Ntro.assertNotNull("bottomSpace", bottomSpace);
		Ntro.assertNotNull("messagesContainer", messagesContainer);
		
		super.initialize(location, resources);
	}

	@Override
	protected Stream<Pane> spaces() {
		return new StreamNtro<Pane>() {
			@Override
			public void forEach_(Visitor<Pane> visitor) throws Throwable {
				visitor.visit(leftSpace);
				visitor.visit(rightSpace);
				visitor.visit(topSpace);
				visitor.visit(bottomSpace);
			}
		};
	}

	@Override
	protected Pane messagesContainer() {
		return messagesContainer;
	}
	
}
