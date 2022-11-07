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
package ca.ntro.cards.foo;

import ca.ntro.cards.common.GenerateTestCases;
import ca.ntro.cards.foo.models.FooCardsModel;
import ca.ntro.cards.foo.models.values.FooTestCase;
import ca.ntro.cards.foo.test_cases.FooTestCaseDatabase;
import ca.ntro.cards.foo.test_cases.execution_trace.FooExecutionTrace;
import ca.ntro.cards.foo.test_cases.execution_trace.FooExecutionTraceFull;

public abstract class FooGenerateTestCases<STUDENT_MODEL extends FooCardsModel> 

       extends        GenerateTestCases<FooCardsModel, 
                                        STUDENT_MODEL,
                                        FooTestCase,
                                        FooTestCaseDatabase,
                                        FooExecutionTrace> {

	
	@Override
	protected Class<FooTestCase> testCaseClass(){
		return FooTestCase.class;
	}

	@Override
	protected Class<FooTestCaseDatabase> testCaseDatabaseClass(){
		return FooTestCaseDatabase.class;
	}

	@Override
	protected Class<FooCardsModel> executableModelClass() {
		return FooCardsModel.class;
	}

	@Override
	protected boolean shouldWriteJson() {
		return false;
	}

	@Override
	protected Class<? extends FooExecutionTrace> executionTraceClass() {
		return FooExecutionTraceFull.class;
	}

}
