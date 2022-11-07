package ca.ntro.cards.fibonacci.solution;

import ca.ntro.cards.common.test_cases.execution.Execution;
import ca.ntro.cards.fibonacci.models.Calculateur;
import ca.ntro.cards.fibonacci.models.Fibonacci;

public class MonCalculateur extends Calculateur {
	
	public static void main(String[] args) {
		MonCalculateur monCalculateur = new MonCalculateur();
		monCalculateur.setN(10);
		monCalculateur.setSiRecursif(true);
		monCalculateur.construireGraphe();

		System.out.println("réponse: " + monCalculateur.getTete().getReponse());
	}
	

	@Override
	public void construireGraphe() {
		if(siRecursif) {

			construireGrapheRecursivement();
			
		}else {

			constuireGrapheDynamiquement();

		}
	}

	private void construireGrapheRecursivement() {
	}


	private void constuireGrapheDynamiquement() {
	}
}
