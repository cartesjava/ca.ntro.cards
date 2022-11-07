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
package ca.ntro.cards.naivesort;

import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.cards.ProcedureApp;
import ca.ntro.cards.naivesort.backend.NaivesortProcedureBackend;
import ca.ntro.cards.naivesort.frontend.NaivesortProcedureFrontend;
import ca.ntro.cards.naivesort.frontend.NaivesortProcedureViewData;
import ca.ntro.cards.naivesort.frontend.views.NaivesortCardsView;
import ca.ntro.cards.naivesort.frontend.views.NaivesortProcedureDashboardView;
import ca.ntro.cards.naivesort.frontend.views.NaivesortProcedureMessagesView;
import ca.ntro.cards.naivesort.frontend.views.NaivesortProcedureRootView;
import ca.ntro.cards.naivesort.frontend.views.NaivesortProcedureSettingsView;
import ca.ntro.cards.naivesort.frontend.views.fragments.NaivesortProcedureMessageFragment;
import ca.ntro.cards.naivesort.messages.NaivesortMsgAcceptManualModel;
import ca.ntro.cards.naivesort.models.TriNaif;
import ca.ntro.cards.naivesort.models.values.NaivesortTestCase;
import ca.ntro.cards.naivesort.test_cases.NaivesortTestCaseDatabase;
import ca.ntro.cards.naivesort.test_cases.descriptor.NaivesortTestCaseDescriptor;
import ca.ntro.cards.naivesort.test_cases.execution_trace.NaivesortExecutionTrace;
import ca.ntro.cards.test_cases.descriptor.ProcedureTestCaseDescriptor;
import ca.ntro.cards.naivesort.models.NaivesortProcedureDashboardModel;
import ca.ntro.cards.naivesort.models.NaivesortProcedureSettingsModel;

public abstract class   ProcedureTriNaif<STUDENT_MODEL extends TriNaif>

                extends ProcedureApp<TriNaif,           // executable model
                                     STUDENT_MODEL,
                                     STUDENT_MODEL,     // canvas model
                                     NaivesortTestCase,
                                     NaivesortTestCaseDescriptor,
                                     NaivesortTestCaseDatabase,
                                     NaivesortExecutionTrace,
                                     NaivesortProcedureDashboardModel,
                                     NaivesortProcedureSettingsModel,
                                     NaivesortMsgAcceptManualModel,
                                     NaivesortProcedureBackend<STUDENT_MODEL>,
                                     NaivesortProcedureRootView,
                                     NaivesortCardsView,
                                     NaivesortProcedureDashboardView,
                                     NaivesortProcedureSettingsView,
                                     NaivesortProcedureMessagesView,
                                     NaivesortProcedureMessageFragment,
                                     NaivesortProcedureViewData,
                                     NaivesortProcedureFrontend<STUDENT_MODEL>> {

                                    	   
    private String[] args;

	@Override
	public void registerArgs(String[] args) {
		this.args = args;
	}
	

	@Override
	protected Class<TriNaif> executableModelClass() {
		return TriNaif.class;
	}


	protected abstract Class<STUDENT_MODEL> classeTriNaif();

	@Override
	protected Class<NaivesortTestCase> testCaseClass() {
		return NaivesortTestCase.class;
	}

	@Override
	protected Class<NaivesortTestCaseDatabase> testCasesModelClass() {
		return NaivesortTestCaseDatabase.class;
	}


	@Override
	protected Class<NaivesortProcedureDashboardModel> dashboardModelClass() {
		return NaivesortProcedureDashboardModel.class;
	}


	@Override
	protected Class<NaivesortProcedureSettingsModel> settingsModelClass() {
		return NaivesortProcedureSettingsModel.class;
	}

	@Override
	protected NaivesortProcedureFrontend createFrontend() {
		return new NaivesortProcedureFrontend();
	}


	@Override
	protected NaivesortProcedureBackend createBackend() {
		return new NaivesortProcedureBackend();
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
		return (Class<STUDENT_MODEL>) classeTriNaif();
	}

	@Override
	protected Class<STUDENT_MODEL> studentModelClass() {
		return classeTriNaif();
	}

	@Override
	protected Class<NaivesortTestCaseDescriptor> testCaseDescriptorClass() {
		return NaivesortTestCaseDescriptor.class;
	}

	@Override
	protected Class<NaivesortMsgAcceptManualModel> msgAcceptManualModelClass() {
		return NaivesortMsgAcceptManualModel.class;
	}

	@Override
	protected String initialTestCaseId() {
		return "ex01";
	}
}
