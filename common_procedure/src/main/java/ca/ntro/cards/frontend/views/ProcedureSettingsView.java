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
package ca.ntro.cards.frontend.views;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.cards.common.frontend.views.CommonSettingsView;
import ca.ntro.cards.common.messages.MsgToggleUseFourCardColors;
import javafx.scene.control.ToggleButton;

public abstract class ProcedureSettingsView extends CommonSettingsView {

	protected abstract ToggleButton useFourCardColorsToggleButton();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);

		initializeUseFourCardColorsToggleButton();
	}

	private void initializeUseFourCardColorsToggleButton() {
		MsgToggleUseFourCardColors msgToggleUseFourCardColors = NtroApp.newMessage(MsgToggleUseFourCardColors.class);
		
		ToggleButton button = useFourCardColorsToggleButton();
		if(button != null) {
			button.setOnAction(evtFx -> {
				msgToggleUseFourCardColors.send();
			});
		}
	}

	public void displayUseFourCardColors(boolean useFourCardColors) {
		ToggleButton button = useFourCardColorsToggleButton();
		if(button != null) {
			button.setSelected(useFourCardColors);
		}
	}
}
