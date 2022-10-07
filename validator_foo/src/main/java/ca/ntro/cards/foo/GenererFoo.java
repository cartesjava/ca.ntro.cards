package ca.ntro.cards.foo;

import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.cards.foo.backend.FooGeneratorBackend;
import ca.ntro.cards.foo.models.FooModel;
import ca.ntro.cards.validator.GeneratorApp;
import ca.ntro.cards.validator.backend.GeneratorBackend;

public abstract class GenererFoo extends GeneratorApp<FooModel> {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class<? extends GeneratorBackend> backendClass() {
		return FooGeneratorBackend.class;
	}

	@Override
	protected void registerAdditonalModels(ModelRegistrar registrar) {
	}


}
