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
package ca.ntro.cards.common.test_cases.descriptor;

import ca.ntro.cards.common.models.enums.Attempt;

public class CommonAttemptDescriptor implements AbstractAttemptDescriptor {

	private static final long serialVersionUID = -1330131719442951296L;

	private Attempt attempt;
	private int numberOfSteps;
	private int currentStep;
	private boolean isASolution;
	private boolean isLoaded;
	
	private CommonTestCaseDescriptor parentTestCase;

	public Attempt getAttempt() {
		return attempt;
	}

	public void setAttempt(Attempt attempt) {
		this.attempt = attempt;
	}

	public CommonTestCaseDescriptor getParentTestCase() {
		return parentTestCase;
	}

	public void setParentTestCase(CommonTestCaseDescriptor parentTestCase) {
		this.parentTestCase = parentTestCase;
	}

	public int getNumberOfSteps() {
		return numberOfSteps;
	}

	public void setNumberOfSteps(int numberOfSteps) {
		this.numberOfSteps = numberOfSteps;
	}

	public int getCurrentStep() {
		return currentStep;
	}

	public void setCurrentStep(int currentStep) {
		this.currentStep = currentStep;
	}


	public void setIsASolution(boolean isASolution) {
		this.isASolution = isASolution;
	}

	public void setIsLoaded(boolean isLoaded) {
		this.isLoaded = isLoaded;
	}

	public boolean getIsASolution() {
		return isASolution;
	}

	public boolean getIsLoaded() {
		return isLoaded;
	}

	@Override
	public int numberOfSteps() {
		return getNumberOfSteps();
	}

	@Override
	public int currentStep() {
		return getCurrentStep();
	}

	@Override
	public boolean isCurrentAttempt() {
		return parentTestCase.isCurrentAttempt(attempt);
	}

	@Override
	public boolean isASolution() {
		return getIsASolution();
	}

	@Override
	public boolean isLoaded() {
		return getIsLoaded();
	}


}
