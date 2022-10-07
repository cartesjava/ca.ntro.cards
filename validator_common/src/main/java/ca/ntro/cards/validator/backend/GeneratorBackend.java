package ca.ntro.cards.validator.backend;

import ca.ntro.app.tasks.backend.BackendTasks;
import ca.ntro.cards.validator.models.ValidatorModel;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.reflection.object_graph.Initialize;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

public class GeneratorBackend<MODEL extends ValidatorModel> extends CommonBackend<MODEL> {

	@Override
	protected void createAdditionnalTasks(BackendTasks tasks) {

		for(Class<? extends MODEL> modelClass : getModelClasses()) {

			tasks.task("generate" + Ntro.reflection().simpleName(modelClass))
			     .waitsFor(model(modelClass))
			     .thenExecutes(inputs -> {
			    	 
			    	 MODEL model = inputs.get(model(modelClass));
			    	 if(model instanceof Initialize) {
			    		 ((Initialize) model).initialiser();
			    	 }
			    	 
			    	 Database.writeTestCase(model);
			     });
		}
	}
}
