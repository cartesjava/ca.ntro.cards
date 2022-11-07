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
package ca.ntro.core.reflection.object_graph;

import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.json.JsonObject;

public class JsonObjectBuilder extends GenericObjectBuilderNtro<JsonObject> {
	
	
	public JsonObjectBuilder() {
		super();
	}

	public JsonObjectBuilder(ObjectGraphNtro graph) {
		super(graph);
	}

	public JsonObject emptyObjectFromNode(ObjectNode node) {
		JsonObject jsonObject = Ntro.json().newJsonObject();
		
		jsonObject.put(JsonObject.TYPE_KEY, Ntro.reflection().simpleName(node.type()));

		return jsonObject;
	}

	@Override
	protected void setAttribute(JsonObject object, String attributeName, Object attributeValue) {
		object.put(attributeName, attributeValue);
	}

	@Override
	protected Object newObjectReference(String referencedObjetId, Object referencedObject) {
		JsonObject objectReference = Ntro.json().newJsonObject();
		
		objectReference.put(JsonObject.REFERENCE_KEY, referencedObjetId);

		return objectReference;
	}
}
