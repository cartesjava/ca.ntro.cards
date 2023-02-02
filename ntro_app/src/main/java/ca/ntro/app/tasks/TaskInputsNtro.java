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
package ca.ntro.app.tasks;

import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.values.ObjectMap;

public class TaskInputsNtro implements TaskInputs {
	
	private ObjectMap inputs;

	public ObjectMap getInputs() {
		return inputs;
	}

	public void setInputs(ObjectMap inputs) {
		this.inputs = inputs;
	}
	
	
	


	public TaskInputsNtro(ObjectMap inputs) {
		setInputs(inputs);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <O> O get(TaskDescriptor<O> task) {
		return (O) get(task.id());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object get(String id) {
		Object result = getInputs().get(id);
		
		if(result == null) {
			Ntro.exceptionService().throwException(new RuntimeException("\n\n\tinput not found: " + id + "   Please check TaskGraph and correct dependancies\n\n"));
		}
		
		
		return result;
	}

}
