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
package ca.ntro.app.messages;

import java.util.HashSet;
import java.util.Set;

import ca.ntro.app.NtroApp;
import ca.ntro.app.tasks.TaskFactoryNtro;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.task_graphs.generic_task_graph.SimpleTaskOptions;
import ca.ntro.core.task_graphs.task_graph.SimpleTaskNtro;
import ca.ntro.core.task_graphs.task_graph.Task;
import ca.ntro.core.task_graphs.task_graph_trace.TaskTraceNtro;
import ca.ntro.core.task_graphs.task_graph_trace.TaskResultsMessageHandler;

import static ca.ntro.app.tasks.backend.BackendTasks.message;

public class MessageRegistrarNtro implements MessageRegistrar {
	
	private Set<Class<? extends Message>> messageClasses = new HashSet<>();

	public Set<Class<? extends Message>> getMessageClasses() {
		return messageClasses;
	}

	public void setMessageClasses(Set<Class<? extends Message>> messageClasses) {
		this.messageClasses = messageClasses;
	}

	@Override
	public <MSG extends Message> void registerMessage(Class<MSG> messageClass) {
		Ntro.factory().registerNamedClass(messageClass);
		getMessageClasses().add(messageClass);
	}

	public void addMessageHandlerTasks(TaskFactoryNtro<?> taskFactory) {
		for(Class<? extends Message> messageClass : getMessageClasses()) {
			
			Task messageHandler = taskFactory.orphanTask(message(messageClass).id(), 
								                          SimpleTaskOptions.taskClass(SimpleTaskNtro.class)
												                           .traceClass(TaskTraceNtro.class)
												                           .resultsClass(TaskResultsMessageHandler.class))
			                                  .getTask();
			
			NtroApp.messageService().registerMessageHandler(messageClass, messageHandler.asSimpleTask());

		}
	}
}
