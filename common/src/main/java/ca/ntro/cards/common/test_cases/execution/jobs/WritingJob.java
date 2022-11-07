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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;

import ca.ntro.cards.common.CommonConstants;
import ca.ntro.cards.common.models.CommonExecutableModel;
import ca.ntro.cards.common.test_cases.CommonTestCase;
import ca.ntro.core.initialization.Ntro;

public class WritingJob<EXECUTABLE_MODEL extends CommonExecutableModel,
                                    STUDENT_MODEL extends EXECUTABLE_MODEL,
                                    TEST_CASE extends CommonTestCase>  


       extends Job<EXECUTABLE_MODEL, STUDENT_MODEL, TEST_CASE> {
    	   
    	   
    private boolean shouldWriteJson = false;
    private File dbDir = new File(CommonConstants.TEST_CASE_DATABASE_DIR);

	@Override
	public void runImpl() {
		
		if(shouldWriteJson) {
			writeJson();
		}
		
		writeBin();
		
		getDoneHandler().done();
	}

	private void writeJson() {
		File outFile = testCaseFile("json");
		
		try {

			FileOutputStream fileOutput = new FileOutputStream(outFile);
			fileOutput.write(Ntro.reflection().toJsonObject(getTestCase()).toJsonString().getBytes());
			fileOutput.close();

		} catch (IOException e) {
			
			Ntro.throwException(e);
		}
	}

	private File testCaseFile(String extension) {
		return Paths.get(dbDir.getAbsolutePath(), getTestCase().getTestCaseId() + "." + extension).toFile();
	}

	private void writeBin() {
		File outFile = testCaseFile("bin");

		try {

			FileOutputStream fileOutput = new FileOutputStream(outFile);
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
			objectOutput.writeObject(getTestCase());

			objectOutput.close();

		} catch (IOException e) {
			
			Ntro.throwException(e);

		}
	}

	public void registerShouldWriteJson(boolean shouldWriteJson) {
		this.shouldWriteJson = shouldWriteJson;
	}

}
