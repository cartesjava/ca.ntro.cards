package ca.ntro.cards.validator;

import java.io.File;

import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.cards.validator.backend.GeneratorBackend;
import ca.ntro.cards.validator.models.ValidatorModel;

@SuppressWarnings("rawtypes")
public abstract class GeneratorApp<MODEL extends ValidatorModel> extends CommonApp<MODEL, GeneratorBackend> {

	protected void run() {
		File dbDir = new File("db");
		if(dbDir.exists()) {
			for(File dbFile : dbDir.listFiles()) {
				dbFile.delete();
			}
		}

		super.run();
	}

	

}
