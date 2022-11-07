package ca.ntro.cards.shift.solution;

import ca.ntro.app.NtroClientFx;
import ca.ntro.cards.shift.ProcedureDecaler;
import ca.ntro.cards.shift.messages.ShiftMsgAcceptManualModel;

@SuppressWarnings("rawtypes")
public class Procedure extends ProcedureDecaler<MonTableau> {

	public static void main(String[] args) {
		NtroClientFx.launch(args);
	}

	@Override
	protected Class<MonTableau> classeMonTableau() {
		return MonTableau.class;
	}


}
