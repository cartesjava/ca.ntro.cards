package ca.ntro.cards.freesort.solution;

import ca.ntro.app.NtroClientFx;
import ca.ntro.cards.freesort.ProcedureTriLibre;

public class Procedure extends ProcedureTriLibre<MonTriLibre> {

	public static void main(String[] args) {
		NtroClientFx.launch(args);
	}

	@Override
	protected Class<MonTriLibre> classeTriLibre() {
		return MonTriLibre.class;
	}
}
