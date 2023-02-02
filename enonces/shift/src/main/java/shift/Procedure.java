package shift;

import ca.ntro.app.NtroClientFx;
import ca.ntro.cards.shift.ProcedureDecaler;

public class Procedure extends ProcedureDecaler<MonTableau> {
	
	public static void main(String[] args) {
		NtroClientFx.launch(args);
	}

	@Override
	protected Class<MonTableau> classeMonTableau() {
		return MonTableau.class;
	}

}
