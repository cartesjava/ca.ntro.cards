package ca.ntro.cards.common.test_cases.descriptor;

import java.io.Serializable;

import ca.ntro.app.models.Value;
import ca.ntro.cards.common.models.enums.Attempt;

public interface AbstractTestCaseDescriptor<ATTEMPT extends AbstractAttemptDescriptor> extends Value, Serializable {
	
	String category();

	String testCaseId();

	int inputSize();

	void copyTracesFrom(AbstractTestCaseDescriptor testCase);

	public static CommonTestCaseDescriptor create() {
		CommonTestCaseDescriptor descriptor = new CommonTestCaseDescriptor();
		return descriptor;
	}


}