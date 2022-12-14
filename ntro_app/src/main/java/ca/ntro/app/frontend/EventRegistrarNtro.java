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
package ca.ntro.app.frontend;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import java.util.HashSet;
import java.util.Set;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.events.EventNtro;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTaskFactory;
import ca.ntro.core.task_graphs.generic_task_graph.SimpleTaskOptions;
import ca.ntro.core.task_graphs.task_graph.SimpleTask;
import ca.ntro.core.task_graphs.task_graph.SimpleTaskNtro;
import ca.ntro.core.task_graphs.task_graph_trace.TaskTraceNtro;
import ca.ntro.core.task_graphs.task_graph_trace.TaskResultsEventHandler;

public class EventRegistrarNtro implements EventRegistrar {
	
	private Set<Class<? extends EventNtro>> events = new HashSet<>();

	@Override
	public <E extends EventNtro> void registerEvent(Class<E> eventClass) {
		events.add(eventClass);
	}

	public void addEventHandlerTasks(FrontendTaskFactory tasks) {
		for(Class<? extends EventNtro> eventClass : events) {
			
			SimpleTask eventHandler = (SimpleTask) tasks.orphanTask(event(eventClass), 
					                                                SimpleTaskOptions.taskClass(SimpleTaskNtro.class)
					                                                                 .traceClass(TaskTraceNtro.class)
					                                                                 .resultsClass(TaskResultsEventHandler.class))

					                                    .getTask();
			
			NtroApp.eventService().registerEventHandler(eventClass, eventHandler);
		}
		
	}

}
