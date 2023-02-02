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
package ca.ntro.app.tasks.backend;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ca.ntro.app.NtroApp;
import ca.ntro.app.tasks.BlockingFrontendExecutor;
import ca.ntro.app.tasks.SimpleTaskCreatorNtro;
import ca.ntro.app.tasks.TaskInputsNtro;
import ca.ntro.app.tasks.TypedBlockingFrontendExecutor;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.json.JsonObject;
import ca.ntro.core.path.Path;
import ca.ntro.core.reflection.observer.ObservationNtro;
import ca.ntro.core.task_graphs.task_graph.Task;
import ca.ntro.core.task_graphs.task_graph.TaskGraph;
import ca.ntro.core.task_graphs.task_graph.TaskContainer;
import ca.ntro.core.reflection.object_graph.ObjectGraph;
import ca.ntro.core.reflection.observer.Observable;
import ca.ntro.core.values.ObjectMap;
import ca.ntro.core.values.ObjectMapNtro;

public class   BackendSimpleTaskCreatorNtro<O> 

       extends     SimpleTaskCreatorNtro<O> 

       implements  BackendSimpleTaskCreator<O> {


	public BackendSimpleTaskCreatorNtro(Map<String, Task> orphanTasks, 
			                            TaskGraph graph, TaskContainer parent, 
			                            Task task) {

		super(orphanTasks, graph, parent, task);
	}
	
	@Override
	protected void executeTask(BlockingFrontendExecutor executor, ObjectMap results) {
		createContextAndExecute(executor, results);
	}

	private class ExecutionContext {
		
		
		private ObjectMapNtro newResults = new ObjectMapNtro();
		private Set<Object> models = new HashSet<>();

		ObjectMap newResults() {
			return newResults;
		}
		
		void aquireLock() {
		}
		
		
		void loadModels(ObjectMap results) {

			results.ids().forEach(id -> {

				if(id.startsWith("model[")) {
					
					String modelClassname = id.replace("model[", "");
					modelClassname = modelClassname.replace("]", "");
					
					Class<?> modelClass = Ntro.factory().namedClass(modelClassname);
					
					Object model = NtroApp.models().load(modelClass);

					models.add(model);
					
					newResults.registerObject(id, model);

				}else {

					newResults.registerObject(id, results.get(id));
				}
			});
		}
		

		void saveModels() {
			for(Object localModel : models) {
				NtroApp.models().save(localModel);
			}
		}

		void releaseLock() {
		}
	}
	
	private synchronized void createContextAndExecute(BlockingFrontendExecutor executor, ObjectMap results) {
		ExecutionContext context = new ExecutionContext();
		
		context.aquireLock();

		context.loadModels(results);

		executor.execute(new TaskInputsNtro(context.newResults()));
		
		context.saveModels();
		
		context.releaseLock();
	}

	@Override
	protected Object executeTaskForValue(TypedBlockingFrontendExecutor<?> executor, ObjectMap results) {
		return createContextAndExecuteForValue(executor, results);
	}

	private synchronized Object createContextAndExecuteForValue(TypedBlockingFrontendExecutor<?> executor, ObjectMap results) {
		ExecutionContext context = new ExecutionContext();
		
		context.aquireLock();

		context.loadModels(results);

		Object result = executor.execute(new TaskInputsNtro(context.newResults()));

		context.saveModels();
		
		context.releaseLock();
		
		return result;
	}

}
