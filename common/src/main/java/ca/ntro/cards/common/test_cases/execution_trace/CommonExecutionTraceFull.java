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
package ca.ntro.cards.common.test_cases.execution_trace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.ntro.app.NtroApp;
import ca.ntro.cards.common.messages.MsgStopExecutionReplay;
import ca.ntro.cards.common.models.CommonDashboardModel;
import ca.ntro.cards.common.models.CommonExecutableModel;
import ca.ntro.cards.common.test_cases.descriptor.AbstractAttemptDescriptor;
import ca.ntro.cards.common.test_cases.descriptor.CommonAttemptDescriptor;
import ca.ntro.core.initialization.Ntro;

public abstract class CommonExecutionTraceFull<EXECUTABLE_MODEL extends CommonExecutableModel,
                                               DASHBOARD_MODEL  extends CommonDashboardModel> 

       implements CommonExecutionTrace<EXECUTABLE_MODEL, DASHBOARD_MODEL> {

	private static final long serialVersionUID = 5676175797895217768L;

	private List<EXECUTABLE_MODEL> trace = Collections.synchronizedList(new ArrayList<>());
	private int current = 0;
	
	private transient boolean isSolution = false;
	private transient boolean isLoaded = false;
	
	protected void registerIsSolution(boolean isSolution) {
		this.isSolution = isSolution;
		this.isLoaded = true;
	}

	public List<EXECUTABLE_MODEL> getTrace() {
		return trace;
	}

	public void setTrace(List<EXECUTABLE_MODEL> trace) {
		this.trace = trace;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	@Override
	public void pushReferenceTo(EXECUTABLE_MODEL model) {
		trace.add(model);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void pushCloneOf(EXECUTABLE_MODEL model) {
		trace.add((EXECUTABLE_MODEL) Ntro.reflection().clone(model));
	}
	
	public EXECUTABLE_MODEL currentModel() {
		EXECUTABLE_MODEL currentModel = null;
		
		if(isValidIndex()) {
			currentModel = trace.get(current);
		}
		
		return currentModel;
	}

	private boolean isValidIndex() {
		return current >= 0 && current < trace.size();
	}

	private boolean isValidIndex(int index) {
		return index >= 0 && index < trace.size();
	}
	
	public void stepForward() {
		if(isValidIndex(current + 1)) {

			current++;

		}else {

			MsgStopExecutionReplay msgStopCodeExecution = NtroApp.newMessage(MsgStopExecutionReplay.class);
			msgStopCodeExecution.send();
		}
	}

	public void stepBackward() {
		if(isValidIndex(current - 1)) {
			
			current--;
			
		}else {

			MsgStopExecutionReplay msgStopCodeExecution = NtroApp.newMessage(MsgStopExecutionReplay.class);
			msgStopCodeExecution.send();

		}
	}

	@Override
	public int numberOfSteps() {
		return trace.size();
	}

	@Override
	public void truncateAfterCurrentStep() {
		if(isValidIndex(current+1)) {
			trace = trace.subList(0, current+1);
			current = trace.size() - 1;
		}
	}

	@Override
	public void rewindToFirstStep() {
		current = 0;
	}

	@Override
	public void fastForwardToLastStep() {
		current = trace.size() - 1;
	}

	@Override
	public AbstractAttemptDescriptor asAttemptDescriptor() {
		CommonAttemptDescriptor attempt = new CommonAttemptDescriptor();
		
		attempt.setCurrentStep(current);
		attempt.setIsASolution(isSolution);
		attempt.setIsLoaded(isLoaded);
		attempt.setNumberOfSteps(trace.size());

		return attempt;
	}

	@Override
	public void copyInitialModelInto(EXECUTABLE_MODEL target) {
		EXECUTABLE_MODEL initialModel = trace.get(0);
		target.copyDataFrom(initialModel);
	}

	protected EXECUTABLE_MODEL lastModel() {
		return trace.get(trace.size()-1);
	}

}
