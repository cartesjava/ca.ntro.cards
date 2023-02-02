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
package ca.ntro.app.tasks.frontend;

import java.util.Map;

import ca.ntro.app.tasks.ContainerTasksNtro;
import ca.ntro.app.tasks.SimpleTaskCreator;
import ca.ntro.app.tasks.TaskGroupCreator;
import ca.ntro.core.task_graphs.task_graph.Task;
import ca.ntro.core.task_graphs.task_graph.TaskGraph;
import ca.ntro.core.task_graphs.task_graph.TaskContainer;
import ca.ntro.core.task_graphs.task_graph.TaskGroup;

public class FrontendContainerTasksNtro 

       extends ContainerTasksNtro<FrontendTasks>

       implements FrontendContainerTasks {
	
	private FrontendTasksNtro frontendTasks = new FrontendTasksNtro(this);


	public FrontendTasksNtro getFrontendTasks() {
		return frontendTasks;
	}

	public void setFrontendTasks(FrontendTasksNtro frontendTasks) {
		this.frontendTasks = frontendTasks;
	}
	
	public FrontendContainerTasksNtro() {
		super();
	}
	
	public FrontendContainerTasksNtro(Map<String, Task> orphanTasks, 
			                          TaskGraph graph, 
			                          TaskGroup task) {

		super(orphanTasks, graph, task);
	}
	


	@Override
	protected <O> TaskGroupCreator<O, FrontendTasks> newTaskGroupCreator(Map<String, Task> orphanTasks, 
			                                                             TaskGraph graph, 
			                                                             TaskContainer parent, 
			                                                             TaskGroup group) {

		return new FrontendTaskGroupCreatorNtro(orphanTasks, graph, parent, group);
	}

	@Override
	public FrontendTasks asTasks() {
		return getFrontendTasks();
	}
}
