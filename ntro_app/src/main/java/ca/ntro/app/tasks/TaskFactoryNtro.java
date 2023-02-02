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

import java.util.HashMap;

import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.task_graphs.generic_task_graph.SimpleTaskOptions;
import ca.ntro.core.task_graphs.task_graph.Task;
import ca.ntro.core.task_graphs.task_graph.TaskGraph;
import ca.ntro.core.task_graphs.task_graph.TaskGraphNtro;
import ca.ntro.core.task_graphs.task_graph_trace.TaskGraphTrace;

public abstract class TaskFactoryNtro<TASKS extends Tasks> 
 
       implements     ContainerTasks<TASKS>,
       				  OrphanTasks,
                      TasksExecutor {
	
	private ContainerTasksNtro<TASKS> tasks = newContainerTasksNtro();
	private TaskGraphTrace trace;

	public ContainerTasksNtro<TASKS> getTasks() {
		return tasks;
	}

	public void setTasks(ContainerTasksNtro<TASKS> tasks) {
		this.tasks = tasks;
	}

	public TaskGraphTrace getTrace() {
		return trace;
	}

	public void setTrace(TaskGraphTrace trace) {
		this.trace = trace;
	}
	
	

	public TaskFactoryNtro() {
		getTasks().setOrphanTasks(new HashMap<>());
		getTasks().setGraph(TaskGraph.newGraph());
		getTasks().setParent(getTasks().getGraph());
	}
	
	protected abstract String graphName();
	protected abstract ContainerTasksNtro<TASKS> newContainerTasksNtro();

	public void prepareToExecuteTasks() {
		if(getTrace() == null) {
			
			getTasks().getGraph().setGraphName(graphName());
			
			setTrace(getTasks().getGraph().newTrace());
		}
	}

	public void writeGraph() {
		getTasks().getGraph().write(Ntro.graphWriter());
	}
	
	@Override
	public void executeTasks() {
		if(getTrace() == null) {
			Ntro.exceptionService().throwException(new RuntimeException("Must first prepare all task graphs"));
		}
		
		getTrace().execute();
	}

	@Override
	public SimpleTaskCreator<?> orphanTask(String taskId, SimpleTaskOptions<?> options) {
		return orphanTask(new SimpleTaskDescriptorNtro<>(taskId), options);
	}

	@Override
	public <O> SimpleTaskCreator<O> orphanTask(SimpleTaskDescriptor<O> descriptor, SimpleTaskOptions options) {

		Task task = ((TaskGraphNtro) getTasks().getGraph()).newTaskInstance(descriptor.id(), options);
		
		getTasks().getOrphanTasks().put(task.id(), task);

		return new SimpleTaskCreatorNtro<>(getTasks().getOrphanTasks(), getTasks().getGraph(), getTasks().getParent(), task);
	}

	@Override
	public SimpleTaskCreator<?> task(String taskId) {
		return getTasks().task(taskId);
	}

	@Override
	public <O> SimpleTaskCreator<O> task(SimpleTaskDescriptor<O> descriptor) {
		return getTasks().task(descriptor);
	}

	@Override
	public TaskGroupCreator<?, TASKS> taskGroup(String taskGroupId) {
		return getTasks().taskGroup(taskGroupId);
	}

	@Override
	public <O> TaskGroupCreator<O, TASKS> taskGroup(TaskGroupDescriptor<O> descriptor) {
		return (TaskGroupCreator<O, TASKS>) getTasks().taskGroup(descriptor);
	}

}
