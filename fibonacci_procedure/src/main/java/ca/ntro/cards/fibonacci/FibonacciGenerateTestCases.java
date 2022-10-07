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
