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

import java.util.Map;

import ca.ntro.app.tasks.frontend.ClockDescriptor;
import ca.ntro.core.task_graphs.task_graph.Task;
import ca.ntro.core.task_graphs.task_graph.TaskGraph;
import ca.ntro.core.task_graphs.task_graph.TaskContainer;

public abstract class TaskCreatorNtro<O extends Object,
								      TD extends TaskDescriptor<?>,
								      TC extends TaskCreator<O,T>,
                                      T extends Task>


       implements     TaskCreator<O,T>,
                      WaitsFor<O,TD,TC,T> {
	
	private Map<String, Task> orphanTasks;
	private TaskGraph graph;
	private TaskContainer parent;
	private T task;

	public TaskContainer getParent() {
		return parent;
	}

	public void setParent(TaskContainer parent) {
		this.parent = parent;
	}

	public T getTask() {
		return task;
	}

	public void setTask(T task) {
		this.task = task;
	}

	public TaskGraph getGraph() {
		return graph;
	}

	public void setGraph(TaskGraph graph) {
		this.graph = graph;
	}

	public Map<String, Task> getOrphanTasks() {
		return orphanTasks;
	}

	public void setOrphanTasks(Map<String, Task> orphanTasks) {
		this.orphanTasks = orphanTasks;
	}


	public TaskCreatorNtro(Map<String, Task> orphanTasks,
			                      TaskGraph graph,
			                      TaskContainer parent, 
			                      T task) {
		setOrphanTasks(orphanTasks);
		setGraph(graph);
		setParent(parent);
		setTask(task);
	}
	

	protected abstract TD newTaskDescriptor(String id);

	@Override
	public TC waitsFor(String id) {
		return waitsFor(newTaskDescriptor(id));
	}

	@Override
	public TC waitsFor(TD descriptor) {
		Task previousTask = null;
		
		if(descriptor.id().equals("clock[nextTick]")) {
			
			previousTask = descriptor.newTask(getParent());
			
		}else {
			
			previousTask =  getParent().findTask(descriptor.id());
		}
		
		if(previousTask == null) {
			previousTask = getGraph().findTask(descriptor.id());
			
			if(previousTask == null) {
				previousTask = getOrphanTasks().get(descriptor.id());
			}

			if(previousTask != null) {
				addSubTask(previousTask);
			}
		}

		if(previousTask == null) {
			throw new RuntimeException("waitsFor must be called with a task that is already created (" + descriptor.id() + " not found)");
		}
		
		getTask().addPreviousTask(previousTask);

		return (TC) this;
	}

	private void addSubTask(Task subTask) {

		if(subTask.isSimpleTask()) {

			getParent().addTask(subTask.asSimpleTask());

		}else {

			getParent().addGroup(subTask.asTaskGroup());

		}

	}
}
