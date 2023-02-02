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

import ca.ntro.app.NtroClientFx;
import ca.ntro.cards.fibonacci.FibonacciProcedureApp;
import ca.ntro.cards.fibonacci.messages.FibonacciMsgAcceptManualModel;

@SuppressWarnings("rawtypes")
public class Procedure extends FibonacciProcedureApp<MonCalculateur, MonFibonacci> {

	public static void main(String[] args) {
		NtroClientFx.launch(args);
	}

	@Override
	protected Class<MonCalculateur> classeCalculateur() {
		return MonCalculateur.class;
	}

	@Override
	protected Class<MonFibonacci> classeFibonacci() {
		return MonFibonacci.class;
	}


}
