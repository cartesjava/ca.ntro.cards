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

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import ca.ntro.core.json.JsonObject;
import ca.ntro.core.reflection.object_graph.ObjectGraph;
import ca.ntro.core.reflection.object_graph.revisions.Revisions;
import ca.ntro.core.stream.Stream;

public interface ReflectionService {
	
	String simpleName(Class<?> _class);

	Object clone(Object o);

	boolean graphEquals(Object a, Object b);
	boolean graphEquals(Object a, JsonObject b);
	boolean graphEquals(JsonObject a, Object b);
	boolean graphEquals(JsonObject a, JsonObject b);

	ObjectGraph graphFromObject(Object o);
	ObjectGraph graphFromObject(Object o, String graphName);

	ObjectGraph graphFromJsonObject(JsonObject jsonObject);
	ObjectGraph graphFromJsonObject(JsonObject jsonObject, String graphName);

	Object objectFromGraph(ObjectGraph objectGraph);
	JsonObject jsonObjectFromGraph(ObjectGraph objectGraph);

	JsonObject toJsonObject(Object o);
	Object     fromJsonObject(JsonObject jsonObject);
	
	boolean ifClassImplements(Class<?> _class, Class<?> _interface);
	
	boolean isList(Object object);
	boolean isArray(Object object);
	boolean isMap(Object object);
	boolean isUserDefinedObject(Object object);

	boolean isSimpleValue(Object object);

	boolean isNull(Object object);
	boolean isBoolean(Object object);
	boolean isNumber(Object object);
	boolean isString(Object object);

	boolean asBoolean(Object object);

	String asString(Object object);

	char    asChar(Object object);
	int     asInt(Object object);
	long    asLong(Object object);
	float   asFloat(Object object);
	double  asDouble(Object object);

	Object asUserDefinedObject(Object object);
	<V> V asUserDefinedObject(Object object, Class<V> _class);
	
	List<Object> asList(Object object);
	<I> List<I> asList(Object object, Class<I> itemClass);

	Map<String,Object> asMap(Object object);
	<V> Map<String,V>  asMap(Object object, Class<V> valueClass);

	Method getMethodByName(Class<?> _class, String methodName);

	Revisions revisionsFromTo(Object source, Object target);

}
