package ca.ntro.cards.validator;

import ca.ntro.app.models.Value;
import ca.ntro.cards.validator.models.ValidatorModel;

public interface Validator<MODEL extends ValidatorModel> {
	
	void registerValue(Class<? extends Value> valueClass);
	void validateModel(Class<? extends MODEL> modelClass);

}
