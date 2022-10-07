package ca.ntro.cards.validator;

import ca.ntro.cards.validator.backend.ValidatorBackend;
import ca.ntro.cards.validator.models.ValidatorModel;

@SuppressWarnings("rawtypes")
public abstract class   ValidatorApp<MODEL extends ValidatorModel> 

                extends CommonApp<MODEL, 
                                  ValidatorBackend> {


}
