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
package ca.ntro.core.services;

import ca.ntro.core.files.LocalTextFile;
import ca.ntro.core.initialization.ServiceRequester;
import ca.ntro.core.path.Path;
import ca.ntro.core.initialization.ServiceDependant;
import ca.ntro.core.values.ServiceMap;

public class LoggerNtro extends Logger implements ServiceDependant {

	private Path traceFilePath = Path.emptyPath();                        // TODO: actual file path
	private Path exceptionFilePath = Path.emptyPath();                    // TODO: actual file path

	private FileOpener fileOpener = new FileOpenerNull();

	@Override
	public void requestServices(ServiceRequester requester) {
		requester.requestService(fileOpener.serviceId());
	}

	@Override
	public void handleServices(ServiceMap services) {
		fileOpener = services.getService(fileOpener.serviceId());
	}

	@Override
	public void exception(Throwable e) {

		LocalTextFile exceptionFile = fileOpener.openLocalTextFile(exceptionFilePath);

		// TODO: better formatting
		exceptionFile.append(e.getMessage()).handleException(e2 -> {
			e2.printStackTrace();
		});
	}

	@Override
	public void trace(String message) {

		LocalTextFile traceFile = fileOpener.openLocalTextFile(traceFilePath);

		traceFile.append(message).handleException(e -> {
			exception(e);
		});
	}
}
