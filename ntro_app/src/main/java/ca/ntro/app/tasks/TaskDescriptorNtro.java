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
package ca.ntro.app.tasks;

import ca.ntro.core.task_graphs.task_graph.Task;
import ca.ntro.core.task_graphs.task_graph.TaskContainer;
import ca.ntro.core.task_graphs.task_graph.TaskGraph;

public class TaskDescriptorNtro<O>  implements TaskDescriptor<O> {
	
	private Class<O> type = null;
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Class<O> getType() {
		return type;
	}

	public void setType(Class<O> type) {
		this.type = type;
	}

	public TaskDescriptorNtro(String id) {
		setId(id);
	}

	public TaskDescriptorNtro(String id, Class<?> type) {
		setId(id);
	}



	@Override
	public String id() {
		return getId();
	}

	@Override
	public boolean hasType() {
		return getType() != null;
	}

	@Override
	public Class<O> type() {
		return getType();
	}

	@Override
	public Task newTask(TaskContainer parent) {
		return null;
	}

}
