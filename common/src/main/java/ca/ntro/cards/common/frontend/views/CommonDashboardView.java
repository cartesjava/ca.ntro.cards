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
import ca.ntro.cards.common.frontend.events.EvtShowMenu;
import ca.ntro.cards.common.frontend.events.EvtShowMessages;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public abstract class CommonDashboardView extends ViewFx {

	
	protected abstract Label fpsLabel();

	protected abstract Button menuButton();

	protected abstract Button messageButton();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		EvtShowMenu evtShowMenu = NtroApp.newEvent(EvtShowMenu.class);

		if(menuButton() != null) {
			menuButton().setFocusTraversable(false);

			menuButton().setOnAction(evtFx -> {
				evtShowMenu.trigger();
			});
		}
		
		EvtShowMessages evtShowMessages = NtroApp.newEvent(EvtShowMessages.class);
		
		if(messageButton() != null) {
			messageButton().setFocusTraversable(false);
			
			messageButton().setOnAction(evtFx -> {
				evtShowMessages.trigger();
			});
		}
	}

	public void displayFps(String fps) {
		if(fpsLabel() != null) {
			fpsLabel().setText(fps);
		}
	}
}
