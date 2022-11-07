package ca.ntro.cards.foo.solution;

import ca.ntro.app.NtroClientFx;
import ca.ntro.cards.foo.FooProcedureApp;
import ca.ntro.cards.foo.messages.FooMsgAcceptManualModel;

@SuppressWarnings("rawtypes")
public class Procedure extends FooProcedureApp<MonFooCardsModel> {

	public static void main(String[] args) {
		NtroClientFx.launch(args);
	}

	@Override
	protected Class<MonFooCardsModel> studentClass() {
		return MonFooCardsModel.class;
	}


}
