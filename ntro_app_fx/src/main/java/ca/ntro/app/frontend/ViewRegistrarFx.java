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

import java.util.HashMap;
import java.util.Map;

import ca.ntro.app.Locale;
import ca.ntro.app.NtroApp;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.app.tasks.frontend.FrontendTaskFactory;
import ca.ntro.app.tasks.frontend.FrontendTasksNtro;
import ca.ntro.app.views.ViewLoaderFx;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.task_graphs.generic_task_graph.SimpleTaskOptions;
import ca.ntro.core.task_graphs.task_graph.ExecutableTaskNtro;
import ca.ntro.core.task_graphs.task_graph_trace.TaskTraceNtro;
import ca.ntro.core.task_graphs.task_graph_trace.TaskResultsCondition;

public class ViewRegistrarFx implements ViewRegistrar, ViewRegistrarAccessor {

	private String cssPath;
	private Map<Locale, String> resourcesPaths = new HashMap<>();
	private Map<Class<? extends View<?>>, String> fxmlPaths = new HashMap<>();
	private Map<Class<? extends View<?>>, View<?>> views = new HashMap<>();


	public <V extends View<?>> void registerView(Class<V> viewClass, String fxmlPath) {
		fxmlPaths.put(viewClass, fxmlPath);
	}

	public void registerDefaultResources(String resourcesPath) {
		resourcesPaths.put(NtroApp.currentLocale(), resourcesPath);
	}

	public void registerResources(Locale locale, String resourcesPath) {
		resourcesPaths.put(locale, resourcesPath);
	}

	public void registerStylesheet(String cssPath) {
		this.cssPath = cssPath;
	}

	public void registerViewData(Class<? extends ViewData> viewDataClass) {
		Ntro.factory().registerNamedClass(viewDataClass);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <V extends View<?>> V view(Class<V> viewClass) {
		return (V) views.get(viewClass);
	}

	@Override
	public void addViewLoaderTasks(FrontendTaskFactory tasks) {

		for(Map.Entry<Class<? extends View<?>>, String> entry : fxmlPaths.entrySet()) {

			Class<? extends View<?>> viewClass = entry.getKey();
			String fxmlPath = entry.getValue();
			
			tasks.orphanTask(viewLoader(viewClass).id(), 
					             SimpleTaskOptions.taskClass(ExecutableTaskNtro.class)
					                              .traceClass(TaskTraceNtro.class)
					                              .resultsClass(TaskResultsCondition.class))

				     .executesAndReturnsCreatedValue(inputs -> {

						ViewLoaderFx<? extends View<?>> viewLoader = new ViewLoaderFx<>();

						viewLoader.setFxmlPath(fxmlPath);
						if(cssPath !=null) {
							viewLoader.setCssPath(cssPath);
						}
						
						String resourcesPath = resourcesPaths.get(NtroApp.currentLocale());
						if(resourcesPath != null) {
							viewLoader.setResourcesPath(resourcesPath);
						}
						
						return viewLoader;
				 });
		}
	}
}
