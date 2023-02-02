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
	
	private void decalerDebutTroisEtapes() {
		
		memoireA = cartes[aDeplacer];
		cartes[aDeplacer] = null;
		
		Execution.ajouterEtape();
		
		for(i = aDeplacer; i > 0 ; i--) {

			//Execution.ajouterEtape();

			cartes[i] = cartes[i-1];
			cartes[i-1] = null;
			
			//Execution.ajouterEtape();
		}
		
		Execution.ajouterEtape();
		
		cartes[0] = memoireA;
		memoireA = null;

		Execution.ajouterEtape();
	}

	private void decalerFinTroisEtapes() {
		
		memoireA = cartes[aDeplacer];
		cartes[aDeplacer] = null;
		
		Execution.ajouterEtape();
		
		for(int i = aDeplacer; i < cartes.length - 1; i++) {

			cartes[i] = cartes[i+1];
			cartes[i+1] = null;
		}
		
		Execution.ajouterEtape();
		
		cartes[cartes.length - 1] = memoireA;
		memoireA = null;

		Execution.ajouterEtape();
	}
	
	private void insererALaFin() {

		memoireA = cartes[aDeplacer];
		cartes[aDeplacer] = null;
		Execution.ajouterEtape();

		for(i = aDeplacer; i < cartes.length -1; i++) {

			Execution.ajouterEtape();
							
			cartes[i] = cartes[i+1];
			cartes[i+1] = null;
			Execution.ajouterEtape();	
		}
		
		Execution.ajouterEtape();

		cartes[cartes.length-1] = memoireA;
		memoireA = null;
		Execution.ajouterEtape();

	}

	private void insererAuDebut() {
		memoireA = cartes[aDeplacer];
		cartes[aDeplacer] = null;
		Execution.ajouterEtape();
		
		for(i = 0; i < cartes.length; i++) {

			Execution.ajouterEtape();
			
			memoireB = cartes[i];
			cartes[i] = null;

			Execution.ajouterEtape();
			
			cartes[i] = memoireA;
			memoireA = null;

			Execution.ajouterEtape();
			
			memoireA = memoireB;
			memoireB = null;

			Execution.ajouterEtape();
		}
	}
}
