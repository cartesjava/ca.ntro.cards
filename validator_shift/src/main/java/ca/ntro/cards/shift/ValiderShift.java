package ca.ntro.cards.shift;

import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.cards.shift.models.Carte;
import ca.ntro.cards.shift.models.ShiftModel;
import ca.ntro.cards.validator.ValidatorApp;
import ca.ntro.cards.validator.backend.ValidatorBackend;

public abstract class ValiderShift extends ValidatorApp<ShiftModel> {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class<? extends ValidatorBackend> backendClass() {
		return ValidatorBackend.class;
	}

	@Override
	protected void registerAdditonalModels(ModelRegistrar registrar) {
		registrar.registerValue(Carte.class);
	}



}
