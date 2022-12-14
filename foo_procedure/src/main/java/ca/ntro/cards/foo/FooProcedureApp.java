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

import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.cards.ProcedureApp;
import ca.ntro.cards.foo.backend.FooProcedureBackend;
import ca.ntro.cards.foo.frontend.FooProcedureFrontend;
import ca.ntro.cards.foo.frontend.FooProcedureViewData;
import ca.ntro.cards.foo.frontend.views.FooCardsView;
import ca.ntro.cards.foo.frontend.views.FooProcedureMessagesView;
import ca.ntro.cards.foo.frontend.views.FooProcedureDashboardView;
import ca.ntro.cards.foo.frontend.views.FooProcedureRootView;
import ca.ntro.cards.foo.frontend.views.FooProcedureSettingsView;
import ca.ntro.cards.foo.frontend.views.fragments.FooProcedureMessageFragment;
import ca.ntro.cards.foo.messages.FooMsgAcceptManualModel;
import ca.ntro.cards.foo.models.FooCardsModel;
import ca.ntro.cards.foo.models.values.FooTestCase;
import ca.ntro.cards.foo.test_cases.FooTestCaseDatabase;
import ca.ntro.cards.foo.test_cases.descriptor.FooTestCaseDescriptor;
import ca.ntro.cards.foo.test_cases.execution_trace.FooExecutionTrace;
import ca.ntro.cards.messages.ProcedureMsgAcceptManualModel;
import ca.ntro.cards.test_cases.descriptor.ProcedureTestCaseDescriptor;
import ca.ntro.cards.foo.models.FooProcedureDashboardModel;
import ca.ntro.cards.foo.models.FooProcedureSettingsModel;

public abstract class   FooProcedureApp<STUDENT_MODEL extends FooCardsModel>

                extends ProcedureApp<FooCardsModel,           // executable model
                                     STUDENT_MODEL,
                                     STUDENT_MODEL,     // canvas model
                                     FooTestCase,
                                     FooTestCaseDescriptor,
                                     FooTestCaseDatabase,
                                     FooExecutionTrace,
                                     FooProcedureDashboardModel,
                                     FooProcedureSettingsModel,
                                     FooMsgAcceptManualModel,
                                     FooProcedureBackend<STUDENT_MODEL>,
                                     FooProcedureRootView,
                                     FooCardsView,
                                     FooProcedureDashboardView,
                                     FooProcedureSettingsView,
                                     FooProcedureMessagesView,
                                     FooProcedureMessageFragment,
                                     FooProcedureViewData,
                                     FooProcedureFrontend<STUDENT_MODEL>> {

                                    	   
    private String[] args;

	@Override
	public void registerArgs(String[] args) {
		this.args = args;
	}
	
	@Override
	protected Class<FooCardsModel> executableModelClass() {
		return FooCardsModel.class;
	}

	// TODO: renommer
	protected abstract Class<STUDENT_MODEL> studentClass();

	@Override
	protected Class<FooTestCase> testCaseClass() {
		return FooTestCase.class;
	}

	@Override
	protected Class<FooTestCaseDatabase> testCasesModelClass() {
		return FooTestCaseDatabase.class;
	}


	@Override
	protected Class<FooProcedureDashboardModel> dashboardModelClass() {
		return FooProcedureDashboardModel.class;
	}


	@Override
	protected Class<FooProcedureSettingsModel> settingsModelClass() {
		return FooProcedureSettingsModel.class;
	}

	@Override
	protected FooProcedureFrontend createFrontend() {
		return new FooProcedureFrontend();
	}


	@Override
	protected FooProcedureBackend createBackend() {
		return new FooProcedureBackend();
	}




	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected Class<STUDENT_MODEL> canvasModelClass() {
		return (Class<STUDENT_MODEL>) studentClass();
	}

	@Override
	protected Class<STUDENT_MODEL> studentModelClass() {
		return studentClass();
	}

	@Override
	protected Class<FooTestCaseDescriptor> testCaseDescriptorClass() {
		return FooTestCaseDescriptor.class;
	}

	@Override
	protected Class<FooMsgAcceptManualModel> msgAcceptManualModelClass() {
		return FooMsgAcceptManualModel.class;
	}

	@Override
	protected String initialTestCaseId() {
		return "ex01";
	}

}
