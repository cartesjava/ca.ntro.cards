package ca.ntro.cards.validator.backend;

import java.util.List;

import ca.ntro.app.backend.LocalBackendNtro;
import ca.ntro.app.models.Model;
import ca.ntro.app.tasks.backend.BackendTasks;
import ca.ntro.core.initialization.Ntro;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

public abstract class CommonBackend<MODEL extends Model> extends LocalBackendNtro {

	private List<Class<? extends MODEL>> modelClasses;

	public void registerModelClasses(List<Class<? extends MODEL>> modelClasses) {
		this.modelClasses = modelClasses;
	}
	
	protected List<Class<? extends MODEL>> getModelClasses(){
		return modelClasses;
		
	}

	@Override
	public void createTasks(BackendTasks tasks) {

		
		createAdditionnalTasks(tasks);
	}

	protected abstract void createAdditionnalTasks(BackendTasks tasks);

	@Override
	public void execute() {
		
	}
}
