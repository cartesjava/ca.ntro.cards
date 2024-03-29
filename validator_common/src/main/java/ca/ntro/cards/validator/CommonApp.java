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
package ca.ntro.cards.validator;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.NtroApp;
import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.Model;
import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.app.models.Value;
import ca.ntro.cards.validator.backend.CommonBackend;
import ca.ntro.cards.validator.frontend.AutoExitFrontend;
import ca.ntro.cards.validator.models.ValidatorModel;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.reflection.object_graph.Initialize;

@SuppressWarnings("rawtypes")
public abstract class CommonApp<MODEL extends ValidatorModel,
                                BACKEND extends CommonBackend> implements NtroClientFx, Validator<MODEL> {
	
	private List<Class<? extends MODEL>> modelClasses = new ArrayList<>();
	private List<Class<? extends Value>> valueClasses = new ArrayList<>();

	protected List<Class<? extends MODEL>> getModelClasses(){
		return modelClasses;
	}

	protected List<Class<? extends Value>> getValueClasses(){
		return valueClasses;
	}
	
	protected abstract void validateModels(Validator<MODEL> validator);
	
	@Override
	public void validateModel(Class<? extends MODEL> modelClass) {
		modelClasses.add(modelClass);
	}

	@Override
	public void registerValue(Class<? extends Value> valueClass) {
		valueClasses.add(valueClass);
	}

	public CommonApp() {
		run();
	}

	protected void run() {
		validateModels(this);

		if(modelClasses == null || modelClasses.isEmpty()) {
			System.out.println("\n\n\n[FATAL ERROR] please register at least one model class");
			NtroApp.exit(() -> {});
		}

		// XXX: delete Initialize models, initilize must be called on a fresh instance
		for(Class<? extends MODEL> modelClass : getModelClasses()) {
			if(Ntro.reflection().ifClassImplements(modelClass, Initialize.class)) {
				NtroApp.models().delete(modelClass);
			}
		}
	}

	@Override
	public void registerModels(ModelRegistrar registrar) {
		
		for(Class<? extends Model> modelClass : modelClasses) {

			registrar.registerModel(modelClass);
		}

		for(Class<? extends Value> valueClass : valueClasses) {

			registrar.registerValue(valueClass);
		}
		
		registerAdditonalModels(registrar);
	}

	protected abstract void registerAdditonalModels(ModelRegistrar registrar);

	protected abstract Class<? extends BACKEND> backendClass();

	@SuppressWarnings("unchecked")
	@Override
	public void registerBackend(BackendRegistrar registrar) {

		BACKEND backend = Ntro.factory().newInstance(backendClass());
		
		backend.registerModelClasses(getModelClasses());
		
		registrar.registerBackend(backend);
	}

	@Override
	public void registerFrontend(FrontendRegistrarFx registrar) {
		registrar.registerFrontend(new AutoExitFrontend());
	}

	@Override
	public void registerMessages(MessageRegistrar registrar) {
	}

	@Override
	public void registerArgs(String[] args) {
	}

}
