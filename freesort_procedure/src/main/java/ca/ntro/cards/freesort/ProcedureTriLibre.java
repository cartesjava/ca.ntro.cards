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
package ca.ntro.cards.freesort;

import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.cards.ProcedureApp;
import ca.ntro.cards.freesort.backend.FreesortProcedureBackend;
import ca.ntro.cards.freesort.frontend.FreesortProcedureFrontend;
import ca.ntro.cards.freesort.frontend.FreesortProcedureViewData;
import ca.ntro.cards.freesort.frontend.views.FreesortCardsView;
import ca.ntro.cards.freesort.frontend.views.FreesortProcedureDashboardView;
import ca.ntro.cards.freesort.frontend.views.FreesortProcedureMessagesView;
import ca.ntro.cards.freesort.frontend.views.FreesortProcedureRootView;
import ca.ntro.cards.freesort.frontend.views.FreesortProcedureSettingsView;
import ca.ntro.cards.freesort.frontend.views.fragments.FreesortProcedureMessageFragment;
import ca.ntro.cards.freesort.messages.FreesortMsgAcceptManualModel;
import ca.ntro.cards.freesort.models.TriLibre;
import ca.ntro.cards.freesort.models.values.FreesortTestCase;
import ca.ntro.cards.freesort.test_cases.FreesortTestCaseDatabase;
import ca.ntro.cards.freesort.test_cases.descriptor.FreesortTestCaseDescriptor;
import ca.ntro.cards.freesort.test_cases.execution_trace.FreesortExecutionTrace;
import ca.ntro.cards.test_cases.descriptor.ProcedureTestCaseDescriptor;
import ca.ntro.cards.freesort.models.FreesortProcedureDashboardModel;
import ca.ntro.cards.freesort.models.FreesortProcedureSettingsModel;

public abstract class   ProcedureTriLibre<STUDENT_MODEL extends TriLibre>

                extends ProcedureApp<TriLibre,           // executable model
                                     STUDENT_MODEL,
                                     STUDENT_MODEL,     // canvas model
                                     FreesortTestCase,
                                     FreesortTestCaseDescriptor,
                                     FreesortTestCaseDatabase,
                                     FreesortExecutionTrace,
                                     FreesortProcedureDashboardModel,
                                     FreesortProcedureSettingsModel,
                                     FreesortMsgAcceptManualModel,
                                     FreesortProcedureBackend<STUDENT_MODEL>,
                                     FreesortProcedureRootView,
                                     FreesortCardsView,
                                     FreesortProcedureDashboardView,
                                     FreesortProcedureSettingsView,
                                     FreesortProcedureMessagesView,
                                     FreesortProcedureMessageFragment,
                                     FreesortProcedureViewData,
                                     FreesortProcedureFrontend<STUDENT_MODEL>> {

                                    	   
    private String[] args;

	@Override
	public void registerArgs(String[] args) {
		this.args = args;
	}
	

	@Override
	protected Class<TriLibre> executableModelClass() {
		return TriLibre.class;
	}


	protected abstract Class<STUDENT_MODEL> classeTriLibre();

	@Override
	protected Class<FreesortTestCase> testCaseClass() {
		return FreesortTestCase.class;
	}

	@Override
	protected Class<FreesortTestCaseDatabase> testCasesModelClass() {
		return FreesortTestCaseDatabase.class;
	}


	@Override
	protected Class<FreesortProcedureDashboardModel> dashboardModelClass() {
		return FreesortProcedureDashboardModel.class;
	}


	@Override
	protected Class<FreesortProcedureSettingsModel> settingsModelClass() {
		return FreesortProcedureSettingsModel.class;
	}

	@Override
	protected FreesortProcedureFrontend createFrontend() {
		return new FreesortProcedureFrontend();
	}


	@Override
	protected FreesortProcedureBackend createBackend() {
		return new FreesortProcedureBackend();
	}


	@Override
	protected void registerAdditionnalModels(ModelRegistrar registrar) {
	}

	@Override
	protected void registerAdditionnalMessages(MessageRegistrar registrar) {

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected Class<STUDENT_MODEL> canvasModelClass() {
		return (Class<STUDENT_MODEL>) classeTriLibre();
	}

	@Override
	protected Class<STUDENT_MODEL> studentModelClass() {
		return classeTriLibre();
	}

	@Override
	protected Class<FreesortTestCaseDescriptor> testCaseDescriptorClass() {
		return FreesortTestCaseDescriptor.class;
	}

	@Override
	protected Class<FreesortMsgAcceptManualModel> msgAcceptManualModelClass() {
		return FreesortMsgAcceptManualModel.class;
	}

	@Override
	protected String initialTestCaseId() {
		return "ex01";
	}

}
