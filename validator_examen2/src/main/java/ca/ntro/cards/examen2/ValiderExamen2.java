package ca.ntro.cards.examen2;

import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.cards.examen2.models.Examen2Model;
import ca.ntro.cards.validator.ValidatorApp;
import ca.ntro.cards.validator.backend.ValidatorBackend;

public abstract class ValiderExamen2 extends ValidatorApp<Examen2Model> {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class<? extends ValidatorBackend> backendClass() {
		return ValidatorBackend.class;
	}

	@Override
	protected void registerAdditonalModels(ModelRegistrar registrar) {
	}



}
