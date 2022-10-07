package ca.ntro.cards.shift;

import ca.ntro.cards.common.GenerateTestCases;
import ca.ntro.cards.shift.models.Tableau;
import ca.ntro.cards.shift.models.values.ShiftTestCase;
import ca.ntro.cards.shift.test_cases.ShiftTestCaseDatabase;
import ca.ntro.cards.shift.test_cases.execution_trace.ShiftExecutionTrace;
import ca.ntro.cards.shift.test_cases.execution_trace.ShiftExecutionTraceFull;

public abstract class ShiftGenerateTestCases<STUDENT_MODEL extends Tableau> 

       extends        GenerateTestCases<Tableau, 
                                        STUDENT_MODEL,
                                        ShiftTestCase,
                                        ShiftTestCaseDatabase,
                                        ShiftExecutionTrace> {

	
	@Override
	protected Class<ShiftTestCase> testCaseClass(){
		return ShiftTestCase.class;
	}

	@Override
	protected Class<ShiftTestCaseDatabase> testCaseDatabaseClass(){
		return ShiftTestCaseDatabase.class;
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
	protected Class<? extends ShiftExecutionTrace> executionTraceClass() {
		return ShiftExecutionTraceFull.class;
	}

}
