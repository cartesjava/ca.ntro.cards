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
package ca.ntro.cards.common.test_cases.execution.jobs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import ca.ntro.cards.common.models.CommonExecutableModel;
import ca.ntro.cards.common.test_cases.CommonTestCase;
import ca.ntro.cards.common.test_cases.descriptor.AbstractTestCaseDescriptor;
import ca.ntro.cards.common.test_cases.execution_trace.CommonExecutionTraceFull;
import ca.ntro.core.initialization.Ntro;

public class ReadingJob<EXECUTABLE_MODEL extends CommonExecutableModel,
                                  STUDENT_MODEL extends EXECUTABLE_MODEL,
                                  TEST_CASE extends CommonTestCase>  


       extends Job<EXECUTABLE_MODEL, STUDENT_MODEL, TEST_CASE> {
    	   
    private File testCaseFile;
    private TEST_CASE testCase;

	public File getTestCaseFile() {
		return testCaseFile;
	}

	public void setTestCaseFile(File testCaseFile) {
		this.testCaseFile = testCaseFile;
	}

	public TEST_CASE getTestCase() {
		return testCase;
	}

	public void setTestCase(TEST_CASE testCase) {
		this.testCase = testCase;
	}

	@Override
	public void runImpl() {
		try {

			FileInputStream fileInput = new FileInputStream(testCaseFile);
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);
			testCase = (TEST_CASE) objectInput.readObject();

			objectInput.close();

		} catch (IOException | ClassNotFoundException e) {
			
			Ntro.throwException(e);

		}
	}

	public void registerFile(File testCaseFile) {
		this.testCaseFile = testCaseFile;
	}

	public String testCaseId() {
		return testCaseFile.getName();
	}
	
	


}
