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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class TaskResultsQueue 
       
       extends TaskResultsNtro {
	
	private Object result = null;
	private List<Object> queue = new LinkedList<>();
	

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
	public abstract void notifyResultWasUsed();

	@Override
	public abstract void notifyResultCouldNotBeUsed();
	

	@Override
	public boolean hasNext() {
		return !queue.isEmpty();
	}
	
	@Override
	public void advanceToNext() {
		if(!hasResult() && hasNext()) {
			result = queue.get(0);
			queue = queue.subList(1, queue.size());
		}
	}

	protected void consumeResult() {
		result = null;
	}
	
	@Override
	public void registerNewResult(Object result) {
		queue.add(result);
	}
}
