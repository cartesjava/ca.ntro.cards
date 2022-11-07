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

import java.lang.reflect.Method;

import ca.ntro.core.reflection.object_graph.ObjectGraphNtro;
import ca.ntro.core.reflection.object_graph.ObjectNodeNtro;
import ca.ntro.core.reflection.object_graph.ObjectNodeStructureNtro;
import ca.ntro.core.stream.Stream;
import ca.ntro.core.stream.StreamNtro;
import ca.ntro.core.stream.Visitor;
import ca.ntro.core.wrappers.result.ResultNtro;

public class ObjectNodeStructureJdk extends ObjectNodeStructureNtro {

	public ObjectNodeStructureJdk(ObjectNodeNtro node, ObjectGraphNtro graph, boolean isStartNode) {
		super(node, graph, isStartNode);
	}

	@Override
	protected <R> void _reduceMethodNames(Object object, ResultNtro<R> result, MethodNameReducer<R> reducer) {
		if(result.hasException()) {
			return;
		}
		
		for(Method method : object.getClass().getMethods()) {
			
			try {

				result.registerValue(reducer.reduceMethodName(result.value(), method.getName()));

			} catch (Throwable e) {
				
				result.registerException(e);
				break;
			}
		}
	}

	@Override
	protected Object invokeGetter(Object object, String getterName) throws Throwable {

		Method method = object.getClass().getMethod(getterName);

		Object returnValue = method.invoke(object);

		return returnValue;
	}

	@Override
	protected Stream<String> methodNames(Object object) {
		return new StreamNtro<String>() {

			@Override
			public void forEach_(Visitor<String> visitor) throws Throwable {
				for(Method method : object.getClass().getMethods()) {

					visitor.visit(method.getName());
				}
			}
		};
	}

}
