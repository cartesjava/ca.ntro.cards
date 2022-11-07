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
import ca.ntro.cards.common.messages.MsgStartExecutionEngine;
import ca.ntro.cards.common.models.CommonDashboardModel;
import ca.ntro.cards.common.models.CommonExecutableModel;
import ca.ntro.cards.common.test_cases.CommonTestCaseDatabase;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.SubTasksLambda;

public class ModifyDashboardModel {

	public static <EXECUTABLE_MODEL extends CommonExecutableModel,
	               DASHBOARD_MODEL extends CommonDashboardModel,
                   TEST_CASE_DATABASE extends CommonTestCaseDatabase>
	
	       void createTasks(BackendTasks tasks,
			                Class<DASHBOARD_MODEL> dashboardModelClass,
						    TEST_CASE_DATABASE testCaseDatabase,
			                SubTasksLambda<BackendTasks> subTasksLambda) {
		
		
		tasks.taskGroup("ModifyDashboardModel")
		
		     .waitsFor(model(dashboardModelClass))
		
		     .andContains(subTasks -> {
		    	 
		    	 startExecutionEngine(subTasks, dashboardModelClass, testCaseDatabase);
		    	 
		    	 subTasksLambda.createSubTasks(subTasks);

		     });
	}

	public static <DASHBOARD_MODEL extends CommonDashboardModel,
			       TEST_CASE_DATABASE extends CommonTestCaseDatabase>
	
	       void startExecutionEngine(BackendTasks tasks, 
	    		                     Class<DASHBOARD_MODEL> dashboardModelClass, 
	    		                     TEST_CASE_DATABASE testCaseDatabase){

		tasks.task("startExecutionEngine")
		
		     .waitsFor(message(MsgStartExecutionEngine.class))

		     .thenExecutes(inputs -> {
		    	 
		    	 DASHBOARD_MODEL dashboardModel = inputs.get(model(dashboardModelClass));
		    	 
		    	 dashboardModel.loadDbFromDir(testCaseDatabase);
		    	 testCaseDatabase.startEngine();
		     });
		
	}
	
	
	




}
