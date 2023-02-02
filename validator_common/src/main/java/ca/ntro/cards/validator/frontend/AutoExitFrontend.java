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
package ca.ntro.cards.validator.frontend;

import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import javafx.application.Platform;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.AppWrapperFx;
import ca.ntro.app.NtroApp;

public class AutoExitFrontend implements FrontendFx {

	@Override
	public void registerEvents(EventRegistrar registrar) {
		
	}

	@Override
	public void registerViews(ViewRegistrarFx registrar) {
		
	}

	@Override
	public void createTasks(FrontendTasks tasks) {
		/*
		tasks.task("initialize")
		     .waitsFor(modified(ModelA.class))
		     .thenExecutes(inputs -> {
		    	 
				 System.out.println("Frontend");

		     });
		 */
	}

	@Override
	public void execute() {
		AppWrapperFx.onExit();
		
		// XXX: must queue exiting, as file writing is also queued
		//      and we want files to write before exiting
		Platform.runLater(() -> {
			NtroApp.exit(() -> {
			});
		});

	}

}
