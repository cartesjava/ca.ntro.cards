/*
Copyright (C) (2020) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)

This file is part of Ntro, an application framework designed with teaching in mind.

This is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

*/
package ca.ntro.core.files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import ca.ntro.core.wrappers.future.Future;
import ca.ntro.core.wrappers.future.FutureNtro;

public class LocalTextFileJdk implements LocalTextFile {
	
	private File file;
	
	public LocalTextFileJdk(File file) {
		this.file = file;
	}

	@Override
	public Future<Void> append(String value) {

		FutureNtro<Void> future = new FutureNtro<Void>();

		try {

			FileWriter writer = new FileWriter(file);
			writer.write(value);
			writer.close();
			
			future.registerValue(null);

		} catch (IOException e) {

			future.registerException(e);
		}
		
		return future;
	}
}