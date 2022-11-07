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
package ca.ntro.core.task_graphs.task_graph;

import ca.ntro.core.task_graphs.generic_task_graph.GenericTaskGraph;
import ca.ntro.core.task_graphs.generic_task_graph.SimpleTaskOptions;
import ca.ntro.core.task_graphs.generic_task_graph.TaskGroupOptions;
import ca.ntro.core.task_graphs.task_graph_trace.TaskTraceNtro;
import ca.ntro.core.task_graphs.task_graph_trace.TaskResultsCondition;

public interface TaskGraph extends GenericTaskGraph<Task, 
                                                      SimpleTask, 
                                                      ExecutableTask, 
                                                      TaskGroup, 
                                                      TaskGraph>,
                                    TaskContainer {

	public static TaskGraph newGraph() {
		
		TaskGraphNtro graph = new TaskGraphNtro();
		
		
		graph.setDefaultSimpleTaskOptions(SimpleTaskOptions.taskClass(SimpleTaskNtro.class)
				                                           .traceClass(TaskTraceNtro.class)
				                                           .resultsClass(TaskResultsCondition.class));

		graph.setDefaultTaskGroupOptions(TaskGroupOptions.taskGroupClass(TaskGroupNtro.class));
		
		graph.initialize();
		
		return graph;
	}


}
