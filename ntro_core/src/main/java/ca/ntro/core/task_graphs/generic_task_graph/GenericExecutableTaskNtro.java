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
package ca.ntro.core.task_graphs.generic_task_graph;

import ca.ntro.core.task_graphs.handlers.CancelHandler;
import ca.ntro.core.task_graphs.handlers.ExecuteHandler;
import ca.ntro.core.wrappers.future.ExceptionHandler;

public abstract class GenericExecutableTaskNtro<T  extends GenericTask<T,ST,ET,TG,G>,
                                                ST extends GenericSimpleTask<T,ST,ET,TG,G>,
                                                ET extends GenericExecutableTask<T,ST,ET,TG,G>,
                                                TG extends GenericTaskGroup<T,ST,ET,TG,G>,
                                                G  extends GenericTaskGraph<T,ST,ET,TG,G>> 

       extends        GenericSimpleTaskNtro<T,ST,ET,TG,G>

       implements     GenericExecutableTask<T,ST,ET,TG,G> {
	
	
	private ExecuteHandler executeHandler;
	private CancelHandler cancelHandler;
	private ExceptionHandler exceptionHandler;

	public ExecuteHandler getExecuteHandler() {
		return executeHandler;
	}

	public void setExecuteHandler(ExecuteHandler executeHandler) {
		this.executeHandler = executeHandler;
	}

	public CancelHandler getCancelHandler() {
		return cancelHandler;
	}

	public void setCancelHandler(CancelHandler cancelHandler) {
		this.cancelHandler = cancelHandler;
	}

	public ExceptionHandler getExceptionHandler() {
		return exceptionHandler;
	}

	public void setExceptionHandler(ExceptionHandler exceptionHandler) {
		this.exceptionHandler = exceptionHandler;
	}

	@Override
	public boolean isExecutableTask() {
		return true;
	}

	@Override
	public void execute(ExecuteHandler executeHandler) {
		setExecuteHandler(executeHandler);
	}

	@Override
	public void cancel(CancelHandler cancelHandler) {
		setCancelHandler(cancelHandler);
	}

	@Override
	public void handleException(ExceptionHandler exceptionHandler) {
		setExceptionHandler(exceptionHandler);
	}

}
