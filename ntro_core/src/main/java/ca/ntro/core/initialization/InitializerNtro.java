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
package ca.ntro.core.initialization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.ntro.core.identifyers.ClassId;
import ca.ntro.core.identifyers.ObjectId;
import ca.ntro.core.identifyers.ServiceId;
import ca.ntro.core.services.TracerNtro;
import ca.ntro.core.task_graphs.task_graph.Task;
import ca.ntro.core.task_graphs.task_graph.TaskGraph;
import ca.ntro.core.values.ObjectMap;
import ca.ntro.core.values.ObjectMapNtro;
import ca.ntro.core.wrappers.future.Future;
import ca.ntro.core.wrappers.result.Result;
import ca.ntro.core.wrappers.result.ResultNtro;

public abstract class InitializerNtro 

       implements Initializer {
	
	private InitializerOptions options = new InitializerOptionsNtro();
	
	private Map<ServiceId<?>, Task> serviceTasks = new HashMap<>();
	
	private List<Service<?>> services(){

		List<Service<?>> initializedObjects = new ArrayList<>();

		initializedObjects.add(new TracerNtro());
		
		return initializedObjects;
	}

	private TaskGraph buildGraph() {
		
		TaskGraph graph = null;
		
		/*
		
		for(Service<?> service : services()) {
			
			Task thisObjectTask = new TaskJj();
			
			if(service instanceof ServiceDependant) {

				ServiceDependant serviceDepedant = (ServiceDependant) service;
				serviceDepedant.requestServices(serviceId -> {

					Task initializationTask = serviceTasks.get(serviceId);
					
					if(initializationTask == null) {
						initializationTask = createServiceTask(serviceId);
					}

					thisObjectTask.addPreviousTask(initializationTask);
				});
				
				thisObjectTask.addEntryTask(new GenericAtomicTask() {
					run(ObjectMap objectMap){
						((ServiceDependant) service).handleServices(objectMap);
					}
				});
				
			}
			
			if(service instanceof SubTaskDependant) {
				SubTaskDependant subTaskDependant = (SubTaskDependant) service;
				
				subTaskDependant.registerSubTasks((subTaskId, subTask) -> {
					thisObjectTask.addSubTask(subTask);
				});
				
				thisObjectTask.addExitTask(new GenericAtomicTask() {
					run(ObjectMap objectMap){
						((SubTaskDependant) service).handleSubTaskResults(subTaskResults);
					}
				});
			}
			
			graph.addSubTask(thisObjectTask);
		}
		
		*/

		return graph;
	}
	
	private Task createServiceTask(ServiceId<?> serviceId) {
		
		/*

		Task initializationTask = new TaskJj();
		

		initializationTask.addExitTask(new GenericAtomicTask() {

			run(ObjectMap objectMap){

				Class<?> serviceClass = serviceId._class();
				Service<?> serviceObj = (Service<?>) Factory.newInstance(serviceClass);
				
			}
		});
		
		return initializationTask;
		
		*/
		
		return null;
	}

	protected abstract Task provideInitializationTask(ObjectId objectId);
	protected abstract Task provideInitializationTask(ClassId<? extends Object> classId);
	
	private void initializeStaticImports(ObjectMap objectMap) {
		
		// XXX: place all static imports inside the same package
		//      as InitializerJj
		// T.registerTracer(objectMap.getSingleton(Tracer.serviceId()));
	}

	public Future<ObjectMap> execute() {
		
		//Future<ObjectMap> future = buildGraph().execute();
		Future<ObjectMap> future = null;
		
		/*
		future.handleValue(objectMap -> {
			initializeStaticImports(objectMap);
		});
		*/
		
		return future;
	}

	@Override
	public void executeBlocking() {
		/*
		
		ObjectMap objectMap = buildGraph().executeBlocking();
		
		initializeStaticImports(objectMap);
		
		return objectMap;
		*/
		
		// JSweet: typing error
		//Result<ObjectMap> resultNtro = new ResultNtro<>(new ObjectMapNtro());
		//return (Result<ObjectMap>) resultNtro;
		
	}

	public Initializer setOptions(InitializerOptions options) {
		this.options = options;

		return (Initializer) this;
	}
}
