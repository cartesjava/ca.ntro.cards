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
import ca.ntro.core.reflection.object_graph.ObjectGraphNull;
import ca.ntro.core.reflection.object_graph.revisions.Revisions;
import ca.ntro.core.stream.Stream;

public class ReflectionServiceNull implements ReflectionService {

	@Override
	public ObjectGraph graphFromObject(Object o) {
		return new ObjectGraphNull();
	}

	@Override
	public boolean isList(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMap(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUserDefinedObject(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSimpleValue(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNull(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBoolean(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNumber(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isString(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean asBoolean(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String asString(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char asChar(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int asInt(Object objec) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long asLong(Object objec) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float asFloat(Object objec) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double asDouble(Object objec) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object asUserDefinedObject(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <V> V asUserDefinedObject(Object object, Class<V> _class) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> asList(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <I> List<I> asList(Object object, Class<I> itemClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> asMap(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <V> Map<String, V> asMap(Object object, Class<V> valueClass) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ObjectGraph graphFromObject(Object o, String graphName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String simpleName(Class<?> _class) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object clone(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean graphEquals(Object a, Object b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ObjectGraph graphFromJsonObject(JsonObject jsonObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjectGraph graphFromJsonObject(JsonObject jsonObject, String graphName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object objectFromGraph(ObjectGraph objectGraph) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObject jsonObjectFromGraph(ObjectGraph objectGraph) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObject toJsonObject(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object fromJsonObject(JsonObject jsonObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Method getMethodByName(Class<?> _class, String methodName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean graphEquals(Object a, JsonObject b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean graphEquals(JsonObject a, Object b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean graphEquals(JsonObject a, JsonObject b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Revisions revisionsFromTo(Object source, Object target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ifClassImplements(Class<?> _class, Class<?> _interface) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isArray(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

}
