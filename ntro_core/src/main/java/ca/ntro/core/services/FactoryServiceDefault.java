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

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import ca.ntro.core.initialization.Ntro;

public class FactoryServiceDefault implements FactoryService {
	
	private Map<String, Class<?>> namedClasses = new HashMap<>();

	@Override
	public <O> O newInstance(Class<O> _class) {
		O result = null;

		try {

			result = (O) _class.getDeclaredConstructor().newInstance();

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {

			
			Ntro.exceptionService().throwException(e);

		}

		return result;
	}

	@Override
	public Object newInstance(String className) {
		Object result = null;
		
		Class<?> _class = namedClass(className);
		
		if(_class != null) {
			result = newInstance(_class);
		}

		return result;
	}

	@Override
	public Class<?> namedClass(String className) {
		Class<?> namedClass = namedClasses.get(className);

		if(namedClass == null) {
			Ntro.exceptionService().throwException(new RuntimeException("Class not found '" + className + "'. Please register every user-defined class (View, Model, Value, Message and Event)"));
		}
		
		return namedClass;
	}

	@Override
	public void registerNamedClass(String className, Class<?> _class) {
		namedClasses.put(className, _class);
	}

	@Override
	public void registerNamedClass(Class<?> _class) {
		registerNamedClass(Ntro.reflection().simpleName(_class), _class);
	}

}
