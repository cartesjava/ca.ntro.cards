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

import ca.ntro.app.views.ViewFx;

public abstract class CommonRootView extends ViewFx {
	
	private CommonSettingsView menuView;
	private CommonCanvasView canvasView;
	private CommonMessagesView messagesView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void registerSettingsView(CommonSettingsView menuView) {
		this.menuView = menuView;
	}
	
	public void registerCanvasView(CommonCanvasView canvasView) {
		this.canvasView = canvasView;
	}
	
	public void installSubViews() {
		rootNode().getChildren().add(canvasView.rootNode());
		rootNode().getChildren().add(menuView.rootNode());
		rootNode().getChildren().add(messagesView.rootNode());

		hideMenu();
		hideMessages();
	}

	public void showMenu() {
		menuView.rootNode().setVisible(true);
	}

	public void hideMenu() {
		menuView.rootNode().setVisible(false);
	}

	public void showMessages() {
		messagesView.rootNode().setVisible(true);
	}

	public void hideMessages() {
		messagesView.rootNode().setVisible(false);
	}

	public void registerMessagesView(CommonMessagesView messagesView) {
		this.messagesView = messagesView;
	}

}
