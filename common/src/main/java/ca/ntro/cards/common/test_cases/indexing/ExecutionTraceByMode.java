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
package ca.ntro.cards.common.test_cases.indexing;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import ca.ntro.app.models.Value;
import ca.ntro.cards.common.models.CommonDashboardModel;
import ca.ntro.cards.common.models.CommonExecutableModel;
import ca.ntro.cards.common.models.enums.Attempt;
import ca.ntro.cards.common.test_cases.descriptor.AbstractAttemptDescriptor;
import ca.ntro.cards.common.test_cases.descriptor.CommonAttemptDescriptor;
import ca.ntro.cards.common.test_cases.descriptor.CommonTestCaseDescriptor;
import ca.ntro.cards.common.test_cases.execution_trace.CommonExecutionTrace;
import ca.ntro.cards.common.test_cases.execution_trace.CommonExecutionTraceFull;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.stream.Stream;
import ca.ntro.core.stream.StreamNtro;
import ca.ntro.core.stream.Visitor;

public class ExecutionTraceByMode<EXECUTABLE_MODEL extends CommonExecutableModel,
                                  DASHBOARD_MODEL  extends CommonDashboardModel> 

       implements Value, Serializable {
	
	
	private Class<? extends CommonExecutionTrace<EXECUTABLE_MODEL, DASHBOARD_MODEL>> executionTraceClass;
	
	private Map<String, CommonExecutionTrace<EXECUTABLE_MODEL, DASHBOARD_MODEL>> traceByMode = new HashMap<>();

	public Map<String, CommonExecutionTrace<EXECUTABLE_MODEL, DASHBOARD_MODEL>> getTraceByMode() {
		return traceByMode;
	}

	public void setTraceByMode(Map<String, CommonExecutionTrace<EXECUTABLE_MODEL, DASHBOARD_MODEL>> traceByMode) {
		this.traceByMode = traceByMode;
	}

	public void registerExecutionTraceClass(Class<? extends CommonExecutionTrace<EXECUTABLE_MODEL, DASHBOARD_MODEL>> executionTraceClass) {
		this.executionTraceClass = executionTraceClass;
	}

	public void pushReference(Attempt mode, EXECUTABLE_MODEL snapshot) {
		CommonExecutionTrace<EXECUTABLE_MODEL, DASHBOARD_MODEL> trace = traceByMode.get(mode.name());

		if(trace == null) {
			trace = Ntro.factory().newInstance(executionTraceClass);
			traceByMode.put(mode.name(), trace);
		}

		trace.pushReferenceTo(snapshot);
	}

	public CommonExecutionTrace<EXECUTABLE_MODEL, DASHBOARD_MODEL> trace(Attempt mode) {
		return traceByMode.get(mode.name());
	}
	
	public Stream<CommonExecutionTrace<EXECUTABLE_MODEL, DASHBOARD_MODEL>> stream(){
		return new StreamNtro<>() {

			@Override
			public void forEach_(Visitor<CommonExecutionTrace<EXECUTABLE_MODEL, DASHBOARD_MODEL>> visitor) throws Throwable {
				for(CommonExecutionTrace<EXECUTABLE_MODEL, DASHBOARD_MODEL> trace : traceByMode.values()) {
					visitor.visit(trace);
				}
			}
		};
	}

	public void addAttemptDescriptors(CommonTestCaseDescriptor testCaseDescriptor) {
		for(String attemptName : traceByMode.keySet()) {
			Attempt attempt = Attempt.valueOf(attemptName);

			testCaseDescriptor.addAttemptDescriptor(attempt, attemptDescriptor(testCaseDescriptor, attempt));
		}
	}

	public AbstractAttemptDescriptor attemptDescriptor(CommonTestCaseDescriptor testCaseDescriptor, Attempt attempt) {

		CommonAttemptDescriptor attemptDescriptor = (CommonAttemptDescriptor) traceByMode.get(attempt.name()).asAttemptDescriptor();
		attemptDescriptor.setParentTestCase(testCaseDescriptor);
		attemptDescriptor.setAttempt(attempt);

		return attemptDescriptor;
	}

}
