/*
Copyright (C) (2020) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)

This file is part of Ntro, an application framework designed with teaching in mind.

This is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

*/
package ca.ntro.app.views;

import ca.ntro.app.frontend.View;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

public abstract class ViewFx implements View<Pane>, Initializable {
	
	private Pane pane;

	void setPane(Pane pane) {
		this.pane = pane;
	}

	@Override
	public Pane rootNode() {
		return pane;
	}

}
