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

import ca.ntro.core.initialization.ServiceRequester;
import ca.ntro.core.initialization.ServiceDependant;
import ca.ntro.core.values.ServiceMap;

public class TracerNtro extends Tracer implements ServiceDependant {
	
	private Logger logger = new LoggerNull();
	private StackAnalyzer stackAnalyzer = new StackAnalyzerNull();

	@Override
	public void requestServices(ServiceRequester registrar) {
		registrar.requestService(logger.serviceId());
		registrar.requestService(stackAnalyzer.serviceId());
	}

	@Override
	public void handleServices(ServiceMap services) {
		logger = services.getService(logger.serviceId());
		stackAnalyzer = services.getService(stackAnalyzer.serviceId());
	}

	@Override
	public void trace(Object calledClassOrObject, Object[] arguments) {

		// TODO: actual stacktrace analysis
		stackAnalyzer.analyzeCall(calledClassOrObject);

		logger.trace("TODO");
	}

}
