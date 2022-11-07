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
package ca.ntro.cards.fibonacci;

import ca.ntro.cards.common.GenerateTestCases;
import ca.ntro.cards.fibonacci.models.Calculateur;
import ca.ntro.cards.fibonacci.models.values.FibonacciTestCase;
import ca.ntro.cards.fibonacci.test_cases.FibonacciTestCaseDatabase;
import ca.ntro.cards.fibonacci.test_cases.execution_trace.FibonacciExecutionTrace;
import ca.ntro.cards.fibonacci.test_cases.execution_trace.FibonacciExecutionTraceFull;

public abstract class FibonacciGenerateTestCases<STUDENT_MODEL extends Calculateur> 

       extends        GenerateTestCases<Calculateur, 
                                        STUDENT_MODEL,
                                        FibonacciTestCase,
                                        FibonacciTestCaseDatabase,
                                        FibonacciExecutionTrace> {

	
	@Override
	protected Class<FibonacciTestCase> testCaseClass(){
		return FibonacciTestCase.class;
	}

	@Override
	protected Class<FibonacciTestCaseDatabase> testCaseDatabaseClass(){
		return FibonacciTestCaseDatabase.class;
	}

	@Override
	protected Class<Calculateur> executableModelClass() {
		return Calculateur.class;
	}

	@Override
	protected boolean shouldWriteJson() {
		return true;
	}

	@Override
	protected Class<? extends FibonacciExecutionTrace> executionTraceClass() {
		return FibonacciExecutionTraceFull.class;
	}

}
