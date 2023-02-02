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

import ca.ntro.core.stream.Stream;

public interface GenericTaskContainer<T  extends GenericTask<T,ST,ET,TG,G>,
                                      ST extends GenericSimpleTask<T,ST,ET,TG,G>,
                                      ET extends GenericExecutableTask<T,ST,ET,TG,G>,
                                      TG extends GenericTaskGroup<T,ST,ET,TG,G>,
                                      G  extends GenericTaskGraph<T,ST,ET,TG,G>> {

	T findTask(String id);
	
	ST newTask(String id);
	<TT extends ST> TT newTask(String id, SimpleTaskOptions<TT> options);

	void addTask(ST simpleTask);

	TG newGroup(String id);
	<GG extends TG> GG newGroup(String id, TaskGroupOptions<GG> options);

	void addGroup(TG taskGroup);

	Stream<T> tasks();
	Stream<T> startTasks();
	Stream<T> endTasks();

}
