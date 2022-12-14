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

import ca.ntro.app.messages.MessageRegistrarNtro;
import ca.ntro.app.models.ModelRegistrarNtro;
import ca.ntro.app.services.Window;
import ca.ntro.app.services.WindowNull;
import ca.ntro.app.tasks.TaskFactoryNtro;
import ca.ntro.app.tasks.frontend.FrontendTaskFactory;
import ca.ntro.core.task_graphs.generic_task_graph.SimpleTaskOptions;
import ca.ntro.core.task_graphs.task_graph.ExecutableTaskNtro;
import ca.ntro.core.task_graphs.task_graph_trace.TaskTraceNtro;
import ca.ntro.core.task_graphs.task_graph_trace.TaskResultsCondition;


public abstract class FrontendRegistrarNtro<VR extends ViewRegistrar> 

       implements     FrontendRegistrar<VR>,
                      FrontendExecutor {

	
	private EventRegistrarNtro eventRegistrar = new EventRegistrarNtro();
	private FrontendTaskFactory taskFactory = new FrontendTaskFactory();
	private VR viewRegistrar = newViewRegistrarInstance();
	private Window window = new WindowNull();
	private Frontend<VR> frontend = defaultFrontend(window);
	
	private MessageRegistrarNtro messageRegistrar;
	private ModelRegistrarNtro modelRegistrar;

	

	public EventRegistrarNtro getEventRegistrar() {
		return eventRegistrar;
	}

	public void setEventRegistrar(EventRegistrarNtro eventRegistrar) {
		this.eventRegistrar = eventRegistrar;
	}

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
		this.frontend = defaultFrontend(window);
	}

	public FrontendTaskFactory getTaskFactory() {
		return taskFactory;
	}
	public void setTaskFactory(FrontendTaskFactory taskCreator) {
		this.taskFactory = taskCreator;
	}
	public VR getViewRegistrar() {
		return viewRegistrar;
	}

	public void setViewRegistrar(VR viewRegistrar) {
		this.viewRegistrar = viewRegistrar;
	}

	public Frontend<VR> getFrontend() {
		return frontend;
	}

	public void setFrontend(Frontend<VR> frontend) {
		this.frontend = frontend;
	}

	public MessageRegistrarNtro getMessageRegistrar() {
		return messageRegistrar;
	}

	public void setMessageRegistrar(MessageRegistrarNtro messageRegistrar) {
		this.messageRegistrar = messageRegistrar;
	}

	public ModelRegistrarNtro getModelRegistrar() {
		return modelRegistrar;
	}

	public void setModelRegistrar(ModelRegistrarNtro modelRegistrar) {
		this.modelRegistrar = modelRegistrar;
	}

	protected abstract VR newViewRegistrarInstance();
	protected abstract Frontend<VR> defaultFrontend(Window window);
	

	@Override
	public void registerFrontend(Frontend<VR> frontend) {
		frontend.registerEvents(getEventRegistrar());
		frontend.registerViews(getViewRegistrar());
		
		addWindowTask();

		getViewRegistrar().addViewLoaderTasks(getTaskFactory());
		getEventRegistrar().addEventHandlerTasks(getTaskFactory());
		getModelRegistrar().addModelObserverTasks(getTaskFactory());
		getMessageRegistrar().addMessageHandlerTasks(getTaskFactory());

		frontend.createTasks(getTaskFactory().asTasks());
		
		setFrontend(frontend);
	}
	
	private void addWindowTask() {
		getTaskFactory().orphanTask(window(),
					                SimpleTaskOptions.taskClass(ExecutableTaskNtro.class)
					                                 .traceClass(TaskTraceNtro.class)
					                                 .resultsClass(TaskResultsCondition.class))

		                .executesAndReturnsCreatedValue(inputs -> {

		                	return getWindow();
		                });
	}

	public void prepareToExecuteTasks() {

		getTaskFactory().prepareToExecuteTasks();
	}

	public void writeGraph() {
		getTaskFactory().writeGraph();
	}

	@Override
	public void executeTasks() {

		getTaskFactory().executeTasks();

		getFrontend().execute();

	}

}
