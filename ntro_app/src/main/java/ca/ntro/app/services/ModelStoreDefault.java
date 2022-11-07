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
package ca.ntro.app.services;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import ca.ntro.app.NtroApp;
import ca.ntro.app.models.Model;
import ca.ntro.app.models.Watch;
import ca.ntro.app.models.WriteObjectGraph;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.json.JsonObject;
import ca.ntro.core.path.Path;
import ca.ntro.core.reflection.object_graph.Initialize;
import ca.ntro.core.reflection.object_graph.ObjectGraph;
import ca.ntro.core.reflection.observer.Observable;
import ca.ntro.core.reflection.observer.ObservationNtro;
import ca.ntro.core.stream.Stream;
import ca.ntro.core.stream.StreamNtro;
import ca.ntro.core.stream.Visitor;

public class ModelStoreDefault implements ModelStore {
	
	private boolean areDiskOperationsEnabled = true;
	
	private Map<Class<?>, Object> previousModels = new ConcurrentHashMap<>();
	private Map<Class<?>, Object> currentModels = new ConcurrentHashMap<>();

	@Override
	public <M extends Model> M load(Class<?> modelClass) {
		
		M model = (M) currentModels.get(modelClass);
		
		if(model == null) {

			model = (M) loadFromFile(modelClass);

		}
		
		if(model == null) {
			
			model = (M) Ntro.factory().newInstance(modelClass);

		}

		previousModels.put(modelClass, Ntro.reflection().clone(model));
		currentModels.put(modelClass, model);
		
		return model;
	}
	
	private <M extends Model> void initialize(M model) {
		if(model instanceof Initialize) {
			((Initialize) model).initialiser();
		}
	}


	private synchronized <M extends Model> M loadFromFile(Class<?> modelClass) {
		M model = null;

		Path filePath = filePathFromClass(modelClass);
		
		if(Ntro.storage().ifFileExists(filePath)) {
			
			String jsonString = Ntro.storage().readTextFile(filePath);
			JsonObject jsonObject = Ntro.json().fromJsonString(jsonString);
			model = (M) Ntro.reflection().graphFromJsonObject(jsonObject).buildObject();
		}

		return model;
	}

	private Path filePathFromClass(Class<?> modelClass) {
		return Path.fromRawPath("/models/" + Ntro.reflection().simpleName(modelClass) + ".json");
	}

	@Override
	public void save(Object model) {
		Object previousModel = previousModels.get(model.getClass());
		
		if(model instanceof Watch
				&& areDiskOperationsEnabled) {

			writeModelFile(model);

		}else if(model instanceof Watch){

			writeModelFile(model);
			
		}else {

			pushObservation(model.getClass(), previousModel, model);

		}
	}

	private synchronized void writeModelFile(Path filePath, Object model) {

		ObjectGraph graph = Ntro.reflection().graphFromObject(model);
		
		JsonObject jsonObject = graph.buildJsonObject();
		String jsonString = jsonObject.toJsonString(true);
		Ntro.storage().writeTextFile(filePath, jsonString);

	}

	private void writeModelFile(Object model) {
		writeModelFile(filePathFromClass(model.getClass()), model);
	}

	@Override
	public void writeModelFiles() {
		for(Object model : currentModels.values()) {
			writeModelFile(model);
		}
	}


	@Override
	public void writeGraphs() {
		for(Object model : currentModels.values()) {
			if(model instanceof WriteObjectGraph) {
				writeModelGraph(model);
			}
		}
	}

	private void writeModelGraph(Object model) {
		ObjectGraph graph = Ntro.reflection().graphFromObject(model);
		graph.write(Ntro.graphWriter());
	}


	@Override
	public void watch(Class<?> modelClass) {
		
		Path filePath = filePathFromClass(modelClass);

		Object model = load(modelClass);

		createModelFileIfNeeded(filePath, modelClass, model);
		
		pushFirstObservation(modelClass);

		if(Ntro.reflection().ifClassImplements(modelClass, Watch.class)) {

			Ntro.storage().watchFile(filePathFromClass(modelClass), () -> {
				onModelFileChanged(modelClass);
			});
		}
	}

	private void createModelFileIfNeeded(Path filePath, Class<?> modelClass, Object model) {
		if(!Ntro.storage().ifFileExists(filePath)) {
			writeModelFile(filePath, model);
		}
	}

	private void onModelFileChanged(Class<?> modelClass) {
		Object previousModel = currentModels.get(modelClass);
		Object currentModel = loadFromFile(modelClass);

		pushObservation(modelClass, previousModel, currentModel);
	}
	
	private void pushFirstObservation(Class<?> modelClass) {
		Object previousModel = Ntro.factory().newInstance(modelClass);
		Object currentModel = load(modelClass);

		pushObservation(modelClass, previousModel, currentModel);
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void pushObservation(Class<?> modelClass, Object previousModel, Object currentModel) {
		currentModels.put(modelClass, currentModel);
		
		if(previousModel != null) {

			ObservationNtro observation = new ObservationNtro<>();
			observation.setPreviousValue((Observable) previousModel);

			// XXX: clone currentModel to simulate that the observation
			//      is received after serialization and deserialization
			observation.setCurrentValue((Observable) Ntro.reflection().clone(currentModel));
			//observation.setCurrentValue((Observable) currentModel);

			//Revisions revisions = Ntro.reflection().revisionsFromTo(initialModel, currentModel);

			NtroApp.messageService().receiveObservationFromServer(Ntro.reflection().simpleName(modelClass), observation);
			NtroApp.messageService().pushObservationToClients(Ntro.reflection().simpleName(modelClass), observation);

		}
	}


	@Override
	public Stream<Model> modelStream() {
		return new StreamNtro<Model>() {
			@Override
			public void forEach_(Visitor<Model> visitor) throws Throwable {
				for(Object model : currentModels.values()) {
					visitor.visit((Model) model);
				}
			}
		};
	}

	@Override
	public void suspendDiskOperations() {
		this.areDiskOperationsEnabled = false;
	}

	@Override
	public void resumeDiskOperations() {
		this.areDiskOperationsEnabled = true;
	}

	@Override
	public <M extends Model> void delete(Class<M> modelClass) {
		deleteModelFile(modelClass);
	}

	private synchronized void deleteModelFile(Class<?> modelClass) {
		Path filePath = filePathFromClass(modelClass);
		if(Ntro.storage().ifFileExists(filePath)) {
			Ntro.storage().deleteTextFile(filePath);
		}
	}

}
