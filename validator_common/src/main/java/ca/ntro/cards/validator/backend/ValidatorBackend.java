/*
Copyright (C) (2022) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)

This file is part of "Cartes Java", teaching tools made for https://cartesjava.github.io/

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

*/
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
