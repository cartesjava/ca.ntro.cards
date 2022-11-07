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
package ca.ntro.core.task_graphs.task_graph_trace;


public class TaskResultsCondition 
       
       extends TaskResultsNtro {
	
	private Object result = null;
	private boolean hasNext = false;

	@Override
	public void initialize() {
	}

	@Override
	public boolean hasResult() {
		return result != null;
	}

	@Override
	public Object result() {
		return result;
	}

	@Override
	public void notifyResultWasUsed() {
	}

	@Override
	public void notifyResultCouldNotBeUsed() {
	}

	@Override
	public boolean hasNext() {
		return hasNext;
	}

	@Override
	public void advanceToNext() {
		hasNext = false;
	}

	@Override
	public void registerNewResult(Object result) {
		hasNext = true;
		this.result = result;
	}



}
