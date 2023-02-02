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

public class MonCalculateurPourGeneration extends Calculateur {
	
	public static void main(String[] args) {
		MonCalculateurPourGeneration monCalculateur = new MonCalculateurPourGeneration();
		monCalculateur.setSiRecursif(true);
		monCalculateur.setN(10000);
		monCalculateur.construireGraphe();
		System.out.println(monCalculateur.tete.getReponse());
	}
	
	@Override
	public void construireGraphe() {
		if(siRecursif) {

			construireGrapheRecursivement();
			//setSomme(calculerSommeRecursivement(tete));

		}else {

			constuireGrapheDynamiquement();
			calculerSommeDynamiquement();

		}
	}


	private void calculerSommeDynamiquement() {
		//setSomme(0);
		
		Fibonacci curseur = tete;
		
		while(curseur != null) {
			//setSomme(getSomme() + curseur.getReponse());
			curseur = curseur.getMoinsUn();
		}
	}

	private long calculerSommeRecursivement(Fibonacci curseur) {
		long somme;

		if(curseur.getN() == 0) {
			
			somme = curseur.getReponse();
			
		}else {
			
			somme = curseur.getReponse() + calculerSommeRecursivement(curseur.getMoinsUn());
			
		}
		
		return somme;
	}

	private void construireGrapheRecursivement() {
		tete = new Fibonacci();
		tete.setN(n);
		Execution.ajouterEtape();

		construireGrapheRecursivement(tete);
	}

	private void construireGrapheRecursivement(Fibonacci curseur) {
		if(curseur.getN() == 0) {
			
			calculerReponseEtNombreOr(curseur);
			Execution.ajouterEtape();

		}else if(curseur.getN() == 1){
			
			curseur.setMoinsUn(new Fibonacci());
			Execution.ajouterEtape();

			curseur.getMoinsUn().setN(0);
			construireGrapheRecursivement(curseur.getMoinsUn());
			calculerReponseEtNombreOr(curseur);
			Execution.ajouterEtape();

		}else {
			
			curseur.setMoinsUn(new Fibonacci());
			Execution.ajouterEtape();

			curseur.getMoinsUn().setN(curseur.getN()-1);
			construireGrapheRecursivement(curseur.getMoinsUn());
			curseur.setMoinsDeux(curseur.getMoinsUn().getMoinsUn());
			calculerReponseEtNombreOr(curseur);
			Execution.ajouterEtape();
		}
	}
	
	private void calculerReponseEtNombreOr(Fibonacci curseur) {
		if(curseur.getN() == 0) {

			curseur.setReponse(0l);
			curseur.setNombreOr(0);

		}else if(curseur.getN() == 1) {
			
			curseur.setReponse(1l);
			curseur.setNombreOr(0);
			
		}else {
			
			curseur.setReponse(curseur.getMoinsUn().getReponse() + curseur.getMoinsDeux().getReponse());
			curseur.setNombreOr(Double.valueOf(curseur.getReponse()) / Double.valueOf(curseur.getMoinsUn().getReponse()));

		}
	}
	

	private void constuireGrapheDynamiquement() {
		if(n >= 0) {
			tete = new Fibonacci();
			tete.setN(0);
			calculerReponseEtNombreOr(tete);
			Execution.ajouterEtape();
		}

		if(n >= 1) {

			Fibonacci nouvelleTete = new Fibonacci();
			nouvelleTete.setN(1);
			nouvelleTete.setMoinsUn(tete);
			tete = nouvelleTete;
			Execution.ajouterEtape();

			calculerReponseEtNombreOr(tete);
			Execution.ajouterEtape();
		}

		for(int i = 2; i <= n; i++) {
			Fibonacci nouvelleTete = new Fibonacci();
			nouvelleTete.setN(i);
			nouvelleTete.setMoinsUn(tete);
			nouvelleTete.setMoinsDeux(tete.getMoinsUn());
			tete = nouvelleTete;
			Execution.ajouterEtape();
			
			calculerReponseEtNombreOr(tete);
			Execution.ajouterEtape();
		}
	}
}
