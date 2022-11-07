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
package ca.ntro.app.tasks.system;

import java.util.Map;

import ca.ntro.app.tasks.ContainerTasks;
import ca.ntro.app.tasks.TaskGroupCreatorNtro;
import ca.ntro.app.tasks.TaskGroupDescriptor;
import ca.ntro.core.task_graphs.task_graph.Task;
import ca.ntro.core.task_graphs.task_graph.TaskGraph;
import ca.ntro.core.task_graphs.task_graph.TaskContainer;
import ca.ntro.core.task_graphs.task_graph.TaskGroup;

public class SystemTaskGroupCreatorNtro<O>

       extends TaskGroupCreatorNtro<O, SystemTasks> {

	public SystemTaskGroupCreatorNtro(Map<String, Task> orphanTasks, 
			                            TaskGraph graph, TaskContainer parent, 
			                            TaskGroup task) {

		super(orphanTasks, graph, parent, task);
	}


	@Override
	protected TaskGroupDescriptor<?> newTaskDescriptor(String id) {
		return new SystemTaskGroupDescriptorNtro<>(id);
	}


	@Override
	protected ContainerTasks<SystemTasks> newContainerTasks(Map<String, Task> orphanTasks, 
			                                                  TaskGraph graph, 
			                                                  TaskGroup task) {

		return new SystemContainerTasksNtro(orphanTasks, graph, task);
	}

}
