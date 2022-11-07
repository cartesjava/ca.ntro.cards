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

import ca.ntro.cards.common.models.CommonDashboardModel;
import ca.ntro.cards.common.models.CommonExecutableModel;
import ca.ntro.cards.common.models.enums.Attempt;
import ca.ntro.cards.common.test_cases.descriptor.CommonAttemptDescriptor;

public class CommonExecutionTraceSizeOnly<EXECUTABLE_MODEL extends CommonExecutableModel,
                                          DASHBOARD_MODEL  extends CommonDashboardModel> 

       implements CommonExecutionTrace<EXECUTABLE_MODEL, DASHBOARD_MODEL> {
    	   
    	   private int size = 0;
    	   

	@Override
	public void pushReferenceTo(EXECUTABLE_MODEL model) {
		size++;
	}

	@Override
	public void pushCloneOf(EXECUTABLE_MODEL model) {
		size++;
	}

	@Override
	public void copyCurrentModelInto(EXECUTABLE_MODEL model) {
	}

	@Override
	public void copyInitialModelInto(EXECUTABLE_MODEL target) {
	}

	@Override
	public void stepForward() {
	}

	@Override
	public void stepBackward() {
	}

	@Override
	public int numberOfSteps() {
		return size;
	}

	@Override
	public void truncateAfterCurrentStep() {
	}

	@Override
	public void rewindToFirstStep() {
	}

	@Override
	public void fastForwardToLastStep() {
	}

	@Override
	public CommonAttemptDescriptor asAttemptDescriptor() {
		return null;
	}


}
