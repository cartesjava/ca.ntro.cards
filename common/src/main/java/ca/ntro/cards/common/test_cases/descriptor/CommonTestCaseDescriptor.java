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

import java.util.HashMap;
import java.util.Map;

import ca.ntro.cards.common.models.enums.Attempt;

public class CommonTestCaseDescriptor<ATTEMPT extends AbstractAttemptDescriptor> implements AbstractTestCaseDescriptor<ATTEMPT> {

	private static final long serialVersionUID = -6757195432385501062L;

	private static long nextId = 0;
	private static String nextId() {
		nextId++;
		return String.format("%02d", nextId);
	}

	private String category;
	private String testCaseId;
	private int inputSize;

	private Map<String, ATTEMPT> attempts = new HashMap<>();
	private ATTEMPT currentAttempt;
	
	private CurrentAttemptHolder parentModel; 

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTestCaseId() {
		return testCaseId;
	}

	public void setTestCaseId(String testCaseId) {
		this.testCaseId = testCaseId;
	}

	public int getInputSize() {
		return inputSize;
	}

	public void setInputSize(int size) {
		this.inputSize = size;
	}

	public Map<String, ATTEMPT> getAttempts() {
		return attempts;
	}

	public void setAttempts(Map<String, ATTEMPT> attempts) {
		this.attempts = attempts;
	}

	@Override
	public String category() {
		return getCategory();
	}

	@Override
	public String testCaseId() {
		return getTestCaseId();
	}

	public CurrentAttemptHolder getParentModel() {
		return parentModel;
	}

	public void setParentModel(CurrentAttemptHolder parentModel) {
		this.parentModel = parentModel;
	}

	@Override
	public int inputSize() {
		return getInputSize();
	}

	public CommonTestCaseDescriptor testCaseId(String testCaseId) {
		setTestCaseId(testCaseId);
		return this;
	}

	public CommonTestCaseDescriptor random(int size) {
		setCategory("random");
		setInputSize(size);
		setTestCaseId(nextId());

		return this;
	}

	public CommonTestCaseDescriptor category(String category) {
		setCategory(category);

		return this;
	}

	public CommonTestCaseDescriptor inputSize(int inputSize) {
		setInputSize(inputSize);

		return this;
	}

	public ATTEMPT attempt(Attempt attempt) {
		return attempts.get(attempt.name());
	}

	public boolean isCurrentAttempt(Attempt attempt) {
		return parentModel.isCurrentAttempt(getTestCaseId(), attempt);
	}

	@SuppressWarnings("unchecked")
	public void addAttemptDescriptor(Attempt attempt, AbstractAttemptDescriptor descriptor) {
		attempts.put(attempt.name(), (ATTEMPT) descriptor);
	}

	public void setLoaded(boolean isLoaded) {
		for(ATTEMPT attempt : attempts.values()) {
			((CommonAttemptDescriptor) attempt).setIsLoaded(isLoaded);
		}
	}

	public void setIsSolution(boolean isSolution) {
		for(ATTEMPT attempt : attempts.values()) {
			((CommonAttemptDescriptor) attempt).setIsASolution(isSolution);
		}
	}

	public void copyTracesFrom(AbstractTestCaseDescriptor testCase) {
	}



}
