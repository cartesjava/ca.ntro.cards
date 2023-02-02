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

import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.cards.ProcedureApp;
import ca.ntro.cards.fibonacci.backend.FibonacciProcedureBackend;
import ca.ntro.cards.fibonacci.frontend.FibonacciProcedureFrontend;
import ca.ntro.cards.fibonacci.frontend.FibonacciProcedureViewData;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciCardsView;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciProcedureMessagesView;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciProcedureDashboardView;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciProcedureRootView;
import ca.ntro.cards.fibonacci.frontend.views.FibonacciProcedureSettingsView;
import ca.ntro.cards.fibonacci.frontend.views.fragments.FibonacciProcedureMessageFragment;
import ca.ntro.cards.fibonacci.messages.FibonacciMsgAcceptManualModel;
import ca.ntro.cards.fibonacci.models.Calculateur;
import ca.ntro.cards.fibonacci.models.Fibonacci;
import ca.ntro.cards.fibonacci.models.values.FibonacciTestCase;
import ca.ntro.cards.fibonacci.test_cases.FibonacciTestCaseDatabase;
import ca.ntro.cards.fibonacci.test_cases.descriptor.FibonacciTestCaseDescriptor;
import ca.ntro.cards.fibonacci.test_cases.execution_trace.FibonacciExecutionTrace;
import ca.ntro.cards.messages.ProcedureMsgAcceptManualModel;
import ca.ntro.cards.test_cases.descriptor.ProcedureTestCaseDescriptor;
import ca.ntro.cards.fibonacci.models.FibonacciProcedureDashboardModel;
import ca.ntro.cards.fibonacci.models.FibonacciProcedureSettingsModel;

public abstract class   FibonacciProcedureApp<STUDENT_MODEL extends Calculateur, STUDENT_FIBONACCI extends Fibonacci>

                extends ProcedureApp<Calculateur,           // executable model
                                     STUDENT_MODEL,
                                     STUDENT_MODEL,     // canvas model
                                     FibonacciTestCase,
                                     FibonacciTestCaseDescriptor,
                                     FibonacciTestCaseDatabase,
                                     FibonacciExecutionTrace,
                                     FibonacciProcedureDashboardModel,
                                     FibonacciProcedureSettingsModel,
                                     FibonacciMsgAcceptManualModel,
                                     FibonacciProcedureBackend<STUDENT_MODEL>,
                                     FibonacciProcedureRootView,
                                     FibonacciCardsView,
                                     FibonacciProcedureDashboardView,
                                     FibonacciProcedureSettingsView,
                                     FibonacciProcedureMessagesView,
                                     FibonacciProcedureMessageFragment,
                                     FibonacciProcedureViewData,
                                     FibonacciProcedureFrontend<STUDENT_MODEL>> {

                                    	   
    private String[] args;

	@Override
	public void registerArgs(String[] args) {
		this.args = args;
	}
	
	@Override
	protected Class<Calculateur> executableModelClass() {
		return Calculateur.class;
	}

	// TODO: renommer
	protected abstract Class<STUDENT_MODEL> classeCalculateur();

	// TODO: renommer
	protected abstract Class<STUDENT_FIBONACCI> classeFibonacci();

	@Override
	protected Class<FibonacciTestCase> testCaseClass() {
		return FibonacciTestCase.class;
	}

	@Override
	protected Class<FibonacciTestCaseDatabase> testCasesModelClass() {
		return FibonacciTestCaseDatabase.class;
	}


	@Override
	protected Class<FibonacciProcedureDashboardModel> dashboardModelClass() {
		return FibonacciProcedureDashboardModel.class;
	}


	@Override
	protected Class<FibonacciProcedureSettingsModel> settingsModelClass() {
		return FibonacciProcedureSettingsModel.class;
	}

	@Override
	protected FibonacciProcedureFrontend createFrontend() {
		return new FibonacciProcedureFrontend();
	}


	@Override
	protected FibonacciProcedureBackend createBackend() {
		return new FibonacciProcedureBackend();
	}




	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected Class<STUDENT_MODEL> canvasModelClass() {
		return (Class<STUDENT_MODEL>) classeCalculateur();
	}

	@Override
	protected Class<STUDENT_MODEL> studentModelClass() {
		return classeCalculateur();
	}

	@Override
	protected Class<FibonacciTestCaseDescriptor> testCaseDescriptorClass() {
		return FibonacciTestCaseDescriptor.class;
	}

	@Override
	protected Class<FibonacciMsgAcceptManualModel> msgAcceptManualModelClass() {
		return FibonacciMsgAcceptManualModel.class;
	}

	@Override
	protected String initialTestCaseId() {
		return "rec01";
	}

	@Override
	protected void registerAdditionnalModels(ModelRegistrar registrar) {
		super.registerAdditionnalModels(registrar);
		
		registrar.registerValue(classeFibonacci());
		registrar.registerValue(Fibonacci.class);
	}

}
