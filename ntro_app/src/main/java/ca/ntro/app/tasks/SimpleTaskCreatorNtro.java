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

import ca.ntro.core.task_graphs.task_graph.ExecutableTask;
import ca.ntro.core.task_graphs.task_graph.Task;
import ca.ntro.core.task_graphs.task_graph.TaskGraph;
import ca.ntro.core.task_graphs.task_graph.TaskContainer;
import ca.ntro.core.values.ObjectMap;

public class   SimpleTaskCreatorNtro<O extends Object>

       extends TaskCreatorNtro<O, 
                               SimpleTaskDescriptor<?>, 
                               SimpleTaskCreator<O>,
                               Task>

       implements SimpleTaskCreator<O> {
	

	public SimpleTaskCreatorNtro(Map<String, Task> orphanTasks,
			               TaskGraph graph, 
			               TaskContainer parent, 
			               Task task) {

		super(orphanTasks, graph, parent, task);
	}

	@Override
	public SimpleTaskCreator<O> executes(BlockingFrontendExecutor executor) {
		if(getTask().isSimpleTask()
				&& getTask().asSimpleTask().isExecutableTask()) {

			getTask().asSimpleTask().asExecutableTask().execute((results, notifyer) -> {

				executeTask(executor, results);

				notifyer.addResult(true);
			});
		}

		return this;
	}

	protected void executeTask(BlockingFrontendExecutor executor, ObjectMap results) {
		executor.execute(new TaskInputsNtro(results));
	}


	@Override
	public SimpleTaskCreator<O> thenExecutes(BlockingFrontendExecutor executor) {
		return executes(executor);
	}

	@Override
	public SimpleTaskCreator<O> thenExecutesAndReturnsValue(TypedBlockingFrontendExecutor<?> executor) {
		return executesAndReturnsCreatedValue(executor);
	}

	@Override
	public SimpleTaskCreator<O> executesAndReturnsCreatedValue(TypedBlockingFrontendExecutor<?> executor) {

		if(getTask().isSimpleTask()
				&& getTask().asSimpleTask().isExecutableTask()) {
			
			getTask().asSimpleTask().asExecutableTask().execute((results, notifyer) -> {
				
				Object value = executeTaskForValue(executor, results);

				notifyer.addResult(value);
			});
		}

		return this;
	}

	protected Object executeTaskForValue(TypedBlockingFrontendExecutor<?> executor, ObjectMap results) {
		return executor.execute(new TaskInputsNtro(results));
	}

	@Override
	public SimpleTaskCreator<O> andLaterExecutes(BlockingFrontendExecutor executor) {
		throw new RuntimeException("[FATAL ERROR] andLaterExecutes not yet supported");
		// return this;
	}

	@Override
	protected SimpleTaskDescriptor<?> newTaskDescriptor(String id) {
		return new SimpleTaskDescriptorNtro<>(id);
	}

}
