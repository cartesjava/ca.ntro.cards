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

import ca.ntro.cards.foo.backend.FooEfficiencyBackend;
import ca.ntro.cards.foo.frontend.FooEfficiencyFrontend;
import ca.ntro.cards.foo.frontend.FooEfficiencyViewData;
import ca.ntro.cards.foo.frontend.views.FooEfficiencyDashboardView;
import ca.ntro.cards.foo.frontend.views.FooEfficiencyMessagesView;
import ca.ntro.cards.foo.frontend.views.FooEfficiencyRootView;
import ca.ntro.cards.foo.frontend.views.FooEfficiencySettingsView;
import ca.ntro.cards.foo.frontend.views.FooGraphsView;
import ca.ntro.cards.foo.frontend.views.fragments.FooEfficiencyMessageFragment;
import ca.ntro.cards.foo.models.FooEfficiencyDashboardModel;
import ca.ntro.cards.foo.models.FooEfficiencySettingsModel;
import ca.ntro.cards.foo.models.FooGraphsModel;
import ca.ntro.cards.foo.models.FooCardsModel;
import ca.ntro.cards.foo.models.values.FooTestCase;
import ca.ntro.cards.foo.test_cases.FooTestCaseDatabase;
import ca.ntro.cards.foo.test_cases.execution_trace.FooExecutionTrace;
import ca.ntro.cards.common.models.enums.Attempt;
import ca.ntro.cards.efficiency.EfficiencyApp;

public abstract class   FooEfficiencyApp<STUDENT_MODEL extends FooCardsModel>

                extends EfficiencyApp<FooCardsModel, 
                                      STUDENT_MODEL,
                                      FooGraphsModel,
                                      FooTestCase,
                                      FooTestCaseDatabase,
                                      FooExecutionTrace,
                                      FooEfficiencyDashboardModel,
                                      FooEfficiencySettingsModel,
                                      FooEfficiencyBackend<STUDENT_MODEL>,
                                      FooEfficiencyRootView,
                                      FooGraphsView,
                                      FooEfficiencyDashboardView,
                                      FooEfficiencySettingsView,
                                      FooEfficiencyMessagesView,
                                      FooEfficiencyMessageFragment,
                                      FooEfficiencyViewData,
                                      FooEfficiencyFrontend> {

	@Override
	protected FooEfficiencyFrontend createFrontend() {
		return new FooEfficiencyFrontend();
	}

	@Override
	protected FooEfficiencyBackend createBackend() {
		return new FooEfficiencyBackend();
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected Class<FooCardsModel> executableModelClass() {
		return FooCardsModel.class;
	}

	@Override
	protected Class<STUDENT_MODEL> studentModelClass() {
		return studentClass();
	}
	
	// TODO: renommer
	protected abstract Class<STUDENT_MODEL> studentClass();

	@Override
	protected Class<FooGraphsModel> canvasModelClass() {
		return FooGraphsModel.class;
	}

	@Override
	protected Class<FooTestCase> testCaseClass() {
		return FooTestCase.class;
	}

	@Override
	protected Class<FooTestCaseDatabase> testCasesModelClass() {
		return FooTestCaseDatabase.class;
	}

	@Override
	protected Class<FooEfficiencyDashboardModel> dashboardModelClass() {
		return FooEfficiencyDashboardModel.class;
	}

	@Override
	protected Class<FooEfficiencySettingsModel> settingsModelClass() {
		return FooEfficiencySettingsModel.class;
	}

	@Override
	protected String initialTestCaseId() {
		return "ex01";
	}

	@Override
	protected Attempt initialAttempt() {
		return Attempt.SOLUTION;
	}
}
