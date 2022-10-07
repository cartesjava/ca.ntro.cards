package ca.ntro.cards.shift2;

import ca.ntro.cards.common.GenerateTestCases;
import ca.ntro.cards.shift2.models.Tableau;
import ca.ntro.cards.shift2.models.values.Shift2TestCase;
import ca.ntro.cards.shift2.test_cases.Shift2TestCaseDatabase;
import ca.ntro.cards.shift2.test_cases.execution_trace.Shift2ExecutionTrace;
import ca.ntro.cards.shift2.test_cases.execution_trace.Shift2ExecutionTraceFull;

public abstract class Shift2GenerateTestCases<STUDENT_MODEL extends Tableau> 

       extends        GenerateTestCases<Tableau, 
                                        STUDENT_MODEL,
                                        Shift2TestCase,
                                        Shift2TestCaseDatabase,
                                        Shift2ExecutionTrace> {

	
	@Override
	protected Class<Shift2TestCase> testCaseClass(){
		return Shift2TestCase.class;
	}

	@Override
	protected Class<Shift2TestCaseDatabase> testCaseDatabaseClass(){
		return Shift2TestCaseDatabase.class;
	}

	@Override
	protected Class<Tableau> executableModelClass() {
		return Tableau.class;
	}

	@Override
	protected boolean shouldWriteJson() {
		return false;
	}

	@Override
	protected Class<? extends Shift2ExecutionTrace> executionTraceClass() {
		return Shift2ExecutionTraceFull.class;
	}

}
