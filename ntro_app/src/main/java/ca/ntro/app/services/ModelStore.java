package ca.ntro.app.services;

import ca.ntro.app.models.Model;
import ca.ntro.core.stream.Stream;

public interface ModelStore {
	
	void watch(Class<?> modelClass);
	
	<M extends Model> M load(Class<?> modelClass);

	void save(Object model);
	<M extends Model> void delete(Class<M> modelClass);

	void suspendDiskOperations();
	void resumeDiskOperations();
	
	void writeModelFiles();
	void writeGraphs();

	Stream<Model> modelStream();

}
