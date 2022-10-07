package ca.ntro.cards.shift;

import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.cards.shift.backend.ShiftGeneratorBackend;
import ca.ntro.cards.shift.models.Carte;
import ca.ntro.cards.shift.models.ShiftModel;
import ca.ntro.cards.validator.GeneratorApp;
import ca.ntro.cards.validator.backend.GeneratorBackend;

public abstract class GenererShift extends GeneratorApp<ShiftModel> {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class<? extends GeneratorBackend> backendClass() {
		return ShiftGeneratorBackend.class;
	}

	@Override
	protected void registerAdditonalModels(ModelRegistrar registrar) {
		registrar.registerValue(Carte.class);
	}


}
