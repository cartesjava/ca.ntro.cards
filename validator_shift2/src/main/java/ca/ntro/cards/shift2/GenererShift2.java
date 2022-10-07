package ca.ntro.cards.shift2;

import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.cards.shift2.backend.Shift2GeneratorBackend;
import ca.ntro.cards.shift2.models.Carte;
import ca.ntro.cards.shift2.models.GardeRobe;
import ca.ntro.cards.shift2.models.MaCarte;
import ca.ntro.cards.shift2.models.Factoriel;
import ca.ntro.cards.shift2.models.Personnage;
import ca.ntro.cards.shift2.models.Shift2Model;
import ca.ntro.cards.validator.GeneratorApp;
import ca.ntro.cards.validator.backend.GeneratorBackend;

public abstract class GenererShift2 extends GeneratorApp<Shift2Model> {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class<? extends GeneratorBackend> backendClass() {
		return Shift2GeneratorBackend.class;
	}

	@Override
	protected void registerAdditonalModels(ModelRegistrar registrar) {
		registrar.registerValue(Carte.class);
		registrar.registerValue(MaCarte.class);
		registrar.registerValue(Personnage.class);
		registrar.registerValue(GardeRobe.class);
		registrar.registerValue(Factoriel.class);
	}


}
