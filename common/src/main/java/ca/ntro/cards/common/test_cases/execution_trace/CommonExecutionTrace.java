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

import java.io.Serializable;

import ca.ntro.app.models.Value;
import ca.ntro.cards.common.models.CommonDashboardModel;
import ca.ntro.cards.common.models.CommonExecutableModel;
import ca.ntro.cards.common.test_cases.descriptor.AbstractAttemptDescriptor;

public interface CommonExecutionTrace<EXECUTABLE_MODEL extends CommonExecutableModel,
                                      DASHBOARD_MODEL  extends CommonDashboardModel> 

       extends   Value, Serializable {

	void pushReferenceTo(EXECUTABLE_MODEL model);
	void pushCloneOf(EXECUTABLE_MODEL model);
	
	int numberOfSteps();

	void stepForward();
	void stepBackward();

	void copyInitialModelInto(EXECUTABLE_MODEL target);
	void copyCurrentModelInto(EXECUTABLE_MODEL target);

	void truncateAfterCurrentStep();
	void rewindToFirstStep();
	void fastForwardToLastStep();

	AbstractAttemptDescriptor asAttemptDescriptor();

}
