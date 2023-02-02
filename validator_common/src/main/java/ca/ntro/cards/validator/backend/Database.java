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
package ca.ntro.cards.validator.backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;

import ca.ntro.app.NtroApp;
import ca.ntro.cards.validator.models.ValidatorModel;
import ca.ntro.core.initialization.Ntro;

public class Database {

    private static File dbDir = new File("db");
    
    private static File dbTestCaseFile(Class<?> modelClass) {
		return Paths.get(dbDir.getAbsolutePath(), Ntro.reflection().simpleName(modelClass) + ".bin").toFile();
    }
    private static File jsonTestCaseFile(Class<?> modelClass) {
		return Paths.get(dbDir.getAbsolutePath(), Ntro.reflection().simpleName(modelClass) + ".json").toFile();
    }

	public static void writeTestCase(ValidatorModel model) {
		if(!dbDir.exists()) {
			dbDir.mkdir();
		}

		File dbOutFile = dbTestCaseFile(model.getClass());

		Class<?> modelSuperClass = model.getClass().getSuperclass();
		
		ValidatorModel superModel = (ValidatorModel) Ntro.factory().newInstance(modelSuperClass);
		superModel.copyDataFrom(model);

		try {

			FileOutputStream fileOutput = new FileOutputStream(dbOutFile);
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
			objectOutput.writeObject(superModel);

			objectOutput.close();

		} catch (IOException e) {
			
			Ntro.throwException(e);

		}
	}

	@SuppressWarnings("unchecked")
	public static <MODEL extends ValidatorModel> MODEL readTestCase(Class<MODEL> modelClass) {
		if(!dbDir.exists()) {
			System.out.println("\n\n\n[FATAL ERROR] ./db not found (test cases directory)");
			NtroApp.exit(() -> {});
		}
		
		File inFile = dbTestCaseFile(modelClass);

		MODEL testCase = null;

		try {

			FileInputStream fileInput = new FileInputStream(inFile);
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);
			testCase = (MODEL) objectInput.readObject();

			objectInput.close();

		} catch (IOException | ClassNotFoundException e) {
			
			Ntro.throwException(e);

		}
		
		return testCase;
	}

}
