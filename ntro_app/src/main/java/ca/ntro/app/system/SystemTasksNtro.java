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
package ca.ntro.app.system;

import ca.ntro.app.tasks.system.SystemTaskFactory;

public class SystemTasksNtro {

	private SystemTaskFactory taskFactory = new SystemTaskFactory();

	public SystemTaskFactory getTaskFactory() {
		return taskFactory;
	}

	public void setTaskFactory(SystemTaskFactory taskFactory) {
		this.taskFactory = taskFactory;
	}
	
	public void prepareToExecuteTasks() {

		getTaskFactory().prepareToExecuteTasks();
	}

	public void executeTasks() {
		
		getTaskFactory().executeTasks();

	}

	public void writeGraph() {
		getTaskFactory().writeGraph();
	}

}
