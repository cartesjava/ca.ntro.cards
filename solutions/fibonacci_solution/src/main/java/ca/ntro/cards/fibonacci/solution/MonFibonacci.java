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
import ca.ntro.cards.fibonacci.models.Fibonacci;

public class MonFibonacci extends Fibonacci {

	public long calculerSommeRecursivement() {
		long somme;

		if(getN() == 0) {
			
			somme = getReponse();
			
		}else {
			
			somme = getReponse() + getMoinsUn().calculerSommeRecursivement();
			
		}
		
		return somme;
	}

	@Override
	public void calculerReponseEtNombreOr() {
		if(n == 0) {

			setReponse(0l);
			setNombreOr(0);

		}else if(n == 1) {
			
			setReponse(1l);
			setNombreOr(0);
			
		}else {
			
			setReponse(getMoinsUn().getReponse() + getMoinsDeux().getReponse());
			setNombreOr(Double.valueOf(getReponse()) / Double.valueOf(getMoinsUn().getReponse()));

		}
	}

	@Override
	public void construireGrapheRecursivement() {
		if(n == 0) {
			
			calculerReponseEtNombreOr();
			Execution.ajouterEtape();

		}else if(n == 1){
			
			setMoinsUn(new MonFibonacci());
			Execution.ajouterEtape();

			getMoinsUn().setN(0);
			getMoinsUn().construireGrapheRecursivement();
			calculerReponseEtNombreOr();
			Execution.ajouterEtape();

		}else {
			
			setMoinsUn(new MonFibonacci());
			Execution.ajouterEtape();

			getMoinsUn().setN(n -1);
			getMoinsUn().construireGrapheRecursivement();
			setMoinsDeux(getMoinsUn().getMoinsUn());
			calculerReponseEtNombreOr();
			Execution.ajouterEtape();
		}
	}
}
