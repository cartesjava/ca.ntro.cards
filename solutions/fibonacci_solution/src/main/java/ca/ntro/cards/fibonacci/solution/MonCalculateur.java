/*
Copyright (C) (2022) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)

This file is part of "Cartes Java", teaching tools made for https://cartesjava.github.io/

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

*/
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
			//setSomme(tete.calculerSommeRecursivement());
			
		}else {

			constuireGrapheDynamiquement();
			calculerSommeDynamiquement();

		}
	}

	private void construireGrapheRecursivement() {
		tete = new MonFibonacci();
		tete.setN(n);
		Execution.ajouterEtape();

		tete.construireGrapheRecursivement();
	}

	private void calculerSommeDynamiquement() {
		long somme = 0;
		
		Fibonacci curseur = tete;
		
		for(int i = 0; i < getN(); i++) {

			somme += curseur.getReponse();

			curseur = curseur.getMoinsUn();
		}

		//setSomme(somme);
	}

	private void constuireGrapheDynamiquement() {
		if(n >= 0) {
			tete = new MonFibonacci();
			tete.setN(0);
			tete.calculerReponseEtNombreOr();
			Execution.ajouterEtape();
		}

		if(n >= 1) {

			MonFibonacci nouvelleTete = new MonFibonacci();
			nouvelleTete.setN(1);
			nouvelleTete.setMoinsUn(tete);
			tete = nouvelleTete;
			Execution.ajouterEtape();

			tete.calculerReponseEtNombreOr();
			Execution.ajouterEtape();
		}

		for(int i = 2; i <= n; i++) {
			MonFibonacci nouvelleTete = new MonFibonacci();
			nouvelleTete.setN(i);
			nouvelleTete.setMoinsUn(tete);
			nouvelleTete.setMoinsDeux(tete.getMoinsUn());
			tete = nouvelleTete;
			Execution.ajouterEtape();
			
			tete.calculerReponseEtNombreOr();
			Execution.ajouterEtape();
		}
	}
}
