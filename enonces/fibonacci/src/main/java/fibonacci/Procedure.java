package fibonacci;

import ca.ntro.app.NtroClientFx;
import ca.ntro.cards.fibonacci.FibonacciProcedureApp;

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
