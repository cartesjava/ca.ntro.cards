/*
Copyright (C) (2022) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)

This file is part of "Cartes Java", teaching tools made for https://cartesjava.github.io/

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

*/
package ca.ntro.cards.validator.backend;

import java.util.List;

import ca.ntro.app.backend.LocalBackendNtro;
import ca.ntro.app.models.Model;
import ca.ntro.app.tasks.backend.BackendTasks;
import ca.ntro.core.initialization.Ntro;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

public abstract class CommonBackend<MODEL extends Model> extends LocalBackendNtro {

	private List<Class<? extends MODEL>> modelClasses;

	public void registerModelClasses(List<Class<? extends MODEL>> modelClasses) {
		this.modelClasses = modelClasses;
	}
	
	protected List<Class<? extends MODEL>> getModelClasses(){
		return modelClasses;
		
	}

	@Override
	public void createTasks(BackendTasks tasks) {

		
		createAdditionnalTasks(tasks);
	}

	protected abstract void createAdditionnalTasks(BackendTasks tasks);

	@Override
	public void execute() {
		
	}
}
