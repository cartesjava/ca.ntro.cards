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

import ca.ntro.core.identifyers.ClassId;
import ca.ntro.core.identifyers.ObjectId;
import ca.ntro.core.reflection.observer.ObservationNtro;
import ca.ntro.core.services.AsserterJdk;
import ca.ntro.core.services.CollectionsJdk;
import ca.ntro.core.services.ExceptionThrowerDefault;
import ca.ntro.core.services.GraphWriterJdk;
import ca.ntro.core.services.JsonServiceJdk;
import ca.ntro.core.services.RandomJdk;
import ca.ntro.core.services.ReflectionServiceJdk;
import ca.ntro.core.services.StackAnalyzerJdk;
import ca.ntro.core.services.StorageService;
import ca.ntro.core.services.StorageServiceJdk;
import ca.ntro.core.services.Time;
import ca.ntro.core.services.TimeJdk;
import ca.ntro.core.task_graphs.task_graph.Task;

public class InitializerJdk 
       extends InitializerNtro {

	public void executeBlocking() {
		
		// FIXME!!!
		Ntro.registerExceptionThrower(new ExceptionThrowerDefault());
		Ntro.registerStackAnalyzer(new StackAnalyzerJdk());
		Ntro.registerReflectionService(new ReflectionServiceJdk());
		Ntro.registerGraphWriter(GraphWriterJdk.class);
		Ntro.registerCollections(new CollectionsJdk());
		Ntro.registerTime(provideTime());
		Ntro.registerAsserter(new AsserterJdk());
		Ntro.registerRandom(new RandomJdk());
		Ntro.registerJsonService(new JsonServiceJdk());
		Ntro.registerStorageService(provideStorageService());

	}

	protected Time provideTime() {
		return new TimeJdk();
	}
	
	protected StorageService provideStorageService() {
		return new StorageServiceJdk();
	}


	@Override
	protected Task provideInitializationTask(ObjectId objectId) {

		Task task = null;
		
		return task;
	}

	@Override
	protected Task provideInitializationTask(ClassId<? extends Object> classId) {

		return null;
	}







}
