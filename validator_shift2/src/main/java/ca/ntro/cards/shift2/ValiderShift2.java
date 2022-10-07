package ca.ntro.cards.shift2;

import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.cards.shift2.models.Carte;
import ca.ntro.cards.shift2.models.MaCarte;
import ca.ntro.cards.shift2.models.Personnage;
import ca.ntro.cards.shift2.models.Shift2Model;
import ca.ntro.cards.validator.ValidatorApp;
import ca.ntro.cards.validator.backend.ValidatorBackend;

public abstract class ValiderShift2 extends ValidatorApp<Shift2Model> {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class<? extends ValidatorBackend> backendClass() {
		return ValidatorBackend.class;
	}

	@Override
	protected void registerAdditonalModels(ModelRegistrar registrar) {
		registrar.registerValue(Carte.class);
		registrar.registerValue(MaCarte.class);
		registrar.registerValue(Personnage.class);
	}



}
