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
package ca.ntro.cards.common.frontend.tasks;

import ca.ntro.app.tasks.SubTasksLambda;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.cards.common.frontend.events.EvtQuit;
import ca.ntro.cards.common.frontend.views.CommonSettingsView;
import ca.ntro.cards.common.models.CommonSettingsModel;
import ca.ntro.core.reflection.observer.Modified;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.NtroApp;

public class Settings {

	public static <SETTINGS_VIEW extends CommonSettingsView,
	               SETTINGS_MODEL extends CommonSettingsModel> 
	
	       void createTasks(FrontendTasks tasks,
	    		            Class<SETTINGS_VIEW> settingsViewClass,
	    		            Class<SETTINGS_MODEL> settingsModelClass,
	    		            SubTasksLambda<FrontendTasks> subTasksLambda) {

		tasks.taskGroup("Settings")
		
		     .waitsFor("Initialization")

		     .andContains(subTasks -> {
		    	 
		    	 quit(subTasks);

		    	 displaySettingsModel(subTasks,
		    			              settingsViewClass,
		    			              settingsModelClass);
		    	 
		    	 subTasksLambda.createSubTasks(subTasks);

		     });
	}

	private static void quit(FrontendTasks tasks) {
		tasks.task("quit")
		
		     .waitsFor(event(EvtQuit.class))
		     
		     .thenExecutes(inputs -> {
		    	 
		    	 NtroApp.exit(() -> {
		    		 
		    	 });

		     });
	}

	private static <SETTINGS_VIEW extends CommonSettingsView,
	                SETTINGS_MODEL extends CommonSettingsModel> 
	
	void displaySettingsModel(FrontendTasks tasks,
			                  Class<SETTINGS_VIEW> settingsViewClass,
			                  Class<SETTINGS_MODEL> settingsModelClass) {

		tasks.task("displaySettingsModel")
		
		     .waitsFor(modified(settingsModelClass))
		     
		     .thenExecutes(inputs -> {
		    	 
		    	 SETTINGS_VIEW            settingsView  = inputs.get(created(settingsViewClass));
		    	 Modified<SETTINGS_MODEL> settingsModel = inputs.get(modified(settingsModelClass));
		    	 
		    	 settingsModel.currentValue().displayOn(settingsView);

		     });
	}
}
