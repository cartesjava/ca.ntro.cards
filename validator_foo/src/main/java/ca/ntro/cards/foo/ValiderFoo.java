package ca.ntro.cards.foo;

import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.cards.foo.models.FooModel;
import ca.ntro.cards.validator.ValidatorApp;
import ca.ntro.cards.validator.backend.ValidatorBackend;

public abstract class ValiderFoo extends ValidatorApp<FooModel> {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class<? extends ValidatorBackend> backendClass() {
		return ValidatorBackend.class;
	}

	@Override
	protected void registerAdditonalModels(ModelRegistrar registrar) {
	}



}
