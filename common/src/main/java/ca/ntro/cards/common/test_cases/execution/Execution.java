package ca.ntro.cards.common.test_cases.execution;

public class Execution {
	
	@SuppressWarnings("rawtypes")
	private static TestCaseJobEngine executionEngine;
	
	public static void registerExecutionEngine(TestCaseJobEngine executionEngine) {
		Execution.executionEngine = executionEngine;
	}

	public static void ajouterEtape() {
		if(executionEngine != null) {
			executionEngine.addExecutionStep(Thread.currentThread().getId());
		}
	}

	public static int determineNumberOfThreads(int defaultNumberOfThreads) {
		int numberOfThreads = defaultNumberOfThreads;

		try {
			int numberOfCpus = Runtime.getRuntime().availableProcessors();
			if(numberOfCpus >= 1) {
				numberOfThreads = numberOfCpus;
			}
		} finally {}
		
		return numberOfThreads;
	}

}
