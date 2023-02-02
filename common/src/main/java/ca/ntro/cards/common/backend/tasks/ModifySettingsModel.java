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
package ca.ntro.cards.common.backend.tasks;

import ca.ntro.app.tasks.backend.BackendTasks;

import ca.ntro.cards.common.messages.MsgToggleUseFourCardColors;
import ca.ntro.cards.common.models.CommonSettingsModel;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.SubTasksLambda;

public class ModifySettingsModel {

	public static <SETTINGS_MODEL extends CommonSettingsModel> 

	       void createTasks(BackendTasks tasks,
	    		            Class<SETTINGS_MODEL> settingsModelClass,
	    		            SubTasksLambda<BackendTasks> subTasksLambda) {
		
		tasks.taskGroup("ModifySettingsModel")
		
		     .waitsFor(model(settingsModelClass))
		
		     .andContains(subTasks -> {

		    	 toggleUseFourCardColors(subTasks, settingsModelClass);
		    	 
		    	 subTasksLambda.createSubTasks(subTasks);

		     });
	}

	private static <SETTINGS_MODEL extends CommonSettingsModel> 

	        void toggleUseFourCardColors(BackendTasks tasks,
	        		                     Class<SETTINGS_MODEL> settingsModelClass) {

		tasks.task("toggleUseFourCardColors")

		     .waitsFor(message(MsgToggleUseFourCardColors.class))
		     
		     .thenExecutes(inputs -> {
		    	 
		    	 CommonSettingsModel settingsModel = inputs.get(model(settingsModelClass));

		    	 settingsModel.toggleUseFourCardColors();

		     });
	}
}
