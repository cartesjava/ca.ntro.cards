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
package ca.ntro.core.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.List;


import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.reflection.object_graph.ObjectBuilderNtro;
import ca.ntro.core.reflection.object_graph.ObjectGraphNtro;

public class ObjectBuilderJdk extends ObjectBuilderNtro {

	public ObjectBuilderJdk(ObjectGraphNtro graph) {
		super(graph);
	}

	@Override
	protected void setAttribute(Object object, String attributeName, Object attributeValue) {
		String setterName = ReflectionUtils.setterNameFromAttributeName(attributeName);
		
		invokeSetter(object, setterName, attributeValue);
	}

	public static void invokeSetter(Object object, String setterName, Object attributeValue) {

		try {

			Method method = Ntro.reflection().getMethodByName(object.getClass(), setterName);
			
			if(method == null) {
				Ntro.throwException("[FATAL] setter not found: " + setterName(object, setterName));
			}
			
			attributeValue = convertValueAccordingToSetterType(method, attributeValue);

			method.invoke(object, attributeValue);

		} catch (IllegalArgumentException e) {
			
			Ntro.throwException("[FATAL] cannot invoke setter " + setterName(object, setterName) + " with parameter of type " + attributeValue.getClass());

		} catch (SecurityException | IllegalAccessException | InvocationTargetException e) {

			Ntro.throwException(e);
		}
	}

	
	private static Object convertValueAccordingToSetterType(Method method, Object attributeValue) {
		Object result = attributeValue;

		Class<?> paramType = null;

		if(method.getParameterTypes().length > 0) {
			
			paramType = method.getParameterTypes()[0];

		}else {
			
			Ntro.throwException("[FATAL] setter must have a least one input parameter " + method.getName());

		}

		if(paramType != null
				&& paramType.isArray()
				&& attributeValue != null
				&& attributeValue instanceof List) {
			
			result = convertListToArray(paramType, (List<?>) attributeValue);

		}else if(paramType != null
				&& paramType.isEnum()
				&& attributeValue != null
				&& attributeValue instanceof String) {

			result = convertStringToEnum((Class<? extends Enum>) paramType, (String) attributeValue);

		}else if(paramType != null
				&& paramType.equals(Long.class)
				&& attributeValue != null
				&& attributeValue instanceof Integer) {

			result = convertIntegerToLong((Class<? extends Long>) paramType, (Integer) attributeValue);

		}
		
		return result;
	}

	private static Long convertIntegerToLong(Class<? extends Long> paramType, Integer attributeValue) {
		return (long)((int) attributeValue);
	}

	private static Object convertListToArray(Class<?> arrayType, List<?> list) {

		Class<?>  componentType = arrayType.getComponentType();
		
		Object array = Array.newInstance(componentType, list.size());
		
		for(int i = 0; i < list.size(); i++) {
			Object value = list.get(i);

			if(componentType.isArray()
					&& value != null
					&& value instanceof List) {
				
				value = convertListToArray(componentType, (List<?>) value);
			}

			Array.set(array, i, value);
		}

		return array;
	}

	private static <T extends Enum> T convertStringToEnum(Class<T> enumType, String name) {
		return (T) Enum.valueOf(enumType, name.toUpperCase());
	}

	private static String setterName(Object object, String setterName) {
		return Ntro.reflection().simpleName(object.getClass()) + "." + setterName;
	}


}
