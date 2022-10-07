package ca.ntro.cards.examen2;

import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.cards.examen2.backend.Examen2GeneratorBackend;
import ca.ntro.cards.examen2.models.Examen2Model;
import ca.ntro.cards.examen2.models.gr1.Loup;
import ca.ntro.cards.examen2.models.gr1.Meute;
import ca.ntro.cards.examen2.models.gr1.Troupeau;
import ca.ntro.cards.examen2.models.gr1.Bovin;
import ca.ntro.cards.validator.GeneratorApp;
import ca.ntro.cards.validator.backend.GeneratorBackend;

public abstract class GenererExamen2 extends GeneratorApp<Examen2Model> {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class<? extends GeneratorBackend> backendClass() {
		return Examen2GeneratorBackend.class;
	}

	@Override
	protected void registerAdditonalModels(ModelRegistrar registrar) {
		registrar.registerValue(Loup.class);
		registrar.registerValue(Bovin.class);
		registrar.registerValue(Troupeau.class);
		registrar.registerValue(Meute.class);
	}


}
