package ca.ntro.cards.validator.backend;

import ca.ntro.app.tasks.backend.BackendTasks;
import ca.ntro.cards.validator.models.ValidatorModel;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.reflection.object_graph.Initialize;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class ValidatorBackend<MODEL extends ValidatorModel> extends CommonBackend<MODEL> {

	@Override
	protected void createAdditionnalTasks(BackendTasks tasks) {

		for(Class<? extends MODEL> modelClass : getModelClasses()) {

			tasks.task("validate" + Ntro.reflection().simpleName(modelClass))
			     .waitsFor(model(modelClass))
			     .thenExecutes(inputs -> {

			    	 MODEL studentModel = inputs.get(model(modelClass));
			    	 if(studentModel instanceof Initialize) {
			    		 ((Initialize) studentModel).initialiser();
			    	 }
			    	 
			    	 MODEL testCase = Database.readTestCase(modelClass);
			    	 
			    	 if(Ntro.reflection().graphEquals(studentModel, testCase)) {

						 System.out.println("[OK]     votre modèle " + Ntro.reflection().simpleName(modelClass) + " est valide");

			    	 }else {

						 try {

							
							errorMessage(modelClass, new File(".").getCanonicalPath());
							

						} catch (IOException e) {

							errorMessage(modelClass, new File(".").getAbsolutePath());

						}
			    	 }
			     });
		}
	}

	private void errorMessage(Class<? extends MODEL> modelClass, 
			                  String curDirPath) {

		System.out.println("[ERREUR] votre modèle " 
		                   + Ntro.reflection().simpleName(modelClass) 
		                   + " contient des erreurs. Voir la visualisation de votre modèle: " 
		                   + curDirPath 
		                   + Paths.get("/_storage","graphs", Ntro.reflection().simpleName(modelClass) + ".png"));
	}

	@Override
	public void execute() {
		
		
	}

}
