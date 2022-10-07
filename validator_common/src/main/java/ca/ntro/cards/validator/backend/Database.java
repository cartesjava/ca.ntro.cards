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
    
    private static File testCaseFile(Class<?> modelClass) {
		return Paths.get(dbDir.getAbsolutePath(), Ntro.reflection().simpleName(modelClass) + ".bin").toFile();
    }

	public static void writeTestCase(ValidatorModel model) {
		if(!dbDir.exists()) {
			dbDir.mkdir();
		}
		

		File outFile = testCaseFile(model.getClass());

		Class<?> modelSuperClass = model.getClass().getSuperclass();
		
		ValidatorModel superModel = (ValidatorModel) Ntro.factory().newInstance(modelSuperClass);
		superModel.copyDataFrom(model);

		try {

			FileOutputStream fileOutput = new FileOutputStream(outFile);
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
		
		File inFile = testCaseFile(modelClass);

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
