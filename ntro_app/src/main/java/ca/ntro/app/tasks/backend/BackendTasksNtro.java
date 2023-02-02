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
package ca.ntro.app.tasks.backend;

import ca.ntro.app.tasks.ContainerTasks;
import ca.ntro.app.tasks.SimpleTaskCreator;
import ca.ntro.app.tasks.TaskGroupCreator;

public class BackendTasksNtro implements BackendTasks {

	private ContainerTasks<BackendTasks> containerTasks;

	public ContainerTasks<BackendTasks> getContainerTasks() {
		return containerTasks;
	}

	public void setContainerTasks(ContainerTasks<BackendTasks> containerTasks) {
		this.containerTasks = containerTasks;
	}

	public BackendTasksNtro() {
	}

	public BackendTasksNtro(ContainerTasks<BackendTasks> containerTasks) {
		setContainerTasks(containerTasks);
	}

	@Override
	public SimpleTaskCreator<?> task(String taskId) {
		return getContainerTasks().task(taskId);
	}

	@Override
	public <O> SimpleTaskCreator<O> task(BackendSimpleTaskDescriptor<O> descriptor) {
		return getContainerTasks().task(descriptor);
	}

	@Override
	public TaskGroupCreator<?, BackendTasks> taskGroup(String taskGroupId) {
		return getContainerTasks().taskGroup(taskGroupId);
	}

	@Override
	public <O> TaskGroupCreator<O, BackendTasks> taskGroup(BackendTaskGroupDescriptor<O> descriptor) {
		return getContainerTasks().taskGroup(descriptor);
	}

}
