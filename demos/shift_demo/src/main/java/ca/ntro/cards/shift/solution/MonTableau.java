package ca.ntro.cards.shift.solution;

import ca.ntro.cards.common.test_cases.execution.Execution;
import ca.ntro.cards.shift.models.Tableau;

public class MonTableau extends Tableau {
	
	@Override
	public void deplacerDecaler() {
		if(insererAuDebut) {

			insererAuDebut();

		}else {

			insererALaFin();
		}
	}
	
	private void insererALaFin() {

	}

	private void insererAuDebut() {
	}
}
