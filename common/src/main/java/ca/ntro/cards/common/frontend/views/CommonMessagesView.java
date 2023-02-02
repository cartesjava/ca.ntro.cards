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
package ca.ntro.cards.common.frontend.views;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.cards.common.frontend.events.EvtHideMessages;
import ca.ntro.cards.common.frontend.views.fragments.CommonMessageFragment;
import ca.ntro.core.stream.Stream;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public abstract class CommonMessagesView extends ViewFx {
	
	protected abstract Stream<Pane> spaces();

	protected abstract Pane messagesContainer();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		initializeSpaces();
	}

	private void initializeSpaces() {
		EvtHideMessages evtHideMessages = NtroApp.newEvent(EvtHideMessages.class);
		
		if(spaces() != null) {
			spaces().forEach(space -> {
				space.addEventFilter(MouseEvent.MOUSE_CLICKED, evtFx -> {
					evtHideMessages.trigger();
				});
			});
		}
	}

	public void addMessage(CommonMessageFragment messageFragment) {
		messagesContainer().getChildren().add(messageFragment.rootNode());
	}

}
