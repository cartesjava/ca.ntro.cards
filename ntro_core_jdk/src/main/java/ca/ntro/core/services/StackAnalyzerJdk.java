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

import ca.ntro.core.initialization.Ntro;

public class StackAnalyzerJdk extends StackAnalyzer {

	@Override
	public void analyzeCall(Object calledClassOrObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> callerClass() {

		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		
		StackTraceElement callerElement = stackTrace[stackTrace.length - 1];
		
		String className = callerElement.getClassName();
		
		Class<?> callerClass = null;

		try {

			callerClass = Class.forName(className);

		} catch (ClassNotFoundException e) {
			
			Ntro.exceptionService().throwException(e);
		}
		
		return callerClass;
	}

}
