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
package ca.ntro.core.wrappers.exception_catcher;

import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.wrappers.result.Result;
import ca.ntro.core.wrappers.result.ResultNtro;

public class ExceptionCatcher {
	
	public static <R extends Object> Result<R> executeBlocking(Runner<R> task){
		
		ResultNtro<R> result = new ResultNtro<R>(null);
		
		try {
			
			Ntro.exceptionService().enterCatchingMode();

			result.registerValue(task.run());

			Ntro.exceptionService().exitCatchingMode();

		} catch(Throwable t) {
			
			result.registerException(t);
		}

		if(Ntro.exceptionService().hasException()) {
			
			result.registerException(Ntro.exceptionService().exception());
		}
		
		return result;
	}

}
