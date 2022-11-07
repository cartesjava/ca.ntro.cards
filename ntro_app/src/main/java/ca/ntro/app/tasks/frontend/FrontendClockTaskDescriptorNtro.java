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

import ca.ntro.core.clock.TickNtro;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.task_graphs.generic_task_graph.SimpleTaskOptions;
import ca.ntro.core.task_graphs.task_graph.ExecutableTask;
import ca.ntro.core.task_graphs.task_graph.ExecutableTaskNtro;
import ca.ntro.core.task_graphs.task_graph.Task;
import ca.ntro.core.task_graphs.task_graph.TaskContainer;
import ca.ntro.core.task_graphs.task_graph_trace.TaskResultsEventHandler;
import ca.ntro.core.task_graphs.task_graph_trace.TaskTraceNtro;

public class FrontendClockTaskDescriptorNtro<O>

       extends FrontendSimpleTaskDescriptorNtro<O> {
	
	private long lastTick = Ntro.time().nowNanoseconds();

	public FrontendClockTaskDescriptorNtro(String id) {
		super(id);
	}

	@Override
	public Task newTask(TaskContainer graph) {

		ExecutableTask task = graph.newTask(getId(), 
				                            SimpleTaskOptions.taskClass(ExecutableTaskNtro.class) 
				                                             .traceClass(TaskTraceNtro.class)
				                                             .resultsClass(TaskResultsEventHandler.class));
		
		
		task.execute((inputs, notifyer) -> {
			
			Ntro.time().runRepeatedly(1, () -> {
				
				long tick = Ntro.time().nowNanoseconds();
				
				double elapsed = (tick - lastTick) / 1E9;
				
				lastTick = tick;
				
				notifyer.addResult(new TickNtro(elapsed));
			});
		});
		
		return task;
	}

}
