package ca.ntro.cards.naivesort.solution;

import ca.ntro.app.NtroClientFx;
import ca.ntro.cards.naivesort.ProcedureTriNaif;
import ca.ntro.cards.naivesort.messages.NaivesortMsgAcceptManualModel;

@SuppressWarnings("rawtypes")
public class Procedure extends ProcedureTriNaif<MonTriNaif> {

	public static void main(String[] args) {
		NtroClientFx.launch(args);
	}

	@Override
	protected Class<MonTriNaif> classeTriNaif() {
		return MonTriNaif.class;
	}


}
