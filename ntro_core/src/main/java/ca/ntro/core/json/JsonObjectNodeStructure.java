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
package ca.ntro.core.json;

import java.util.Map;

import ca.ntro.core.graphs.common.Direction;
import ca.ntro.core.graphs.common.EdgeType;
import ca.ntro.core.graphs.common.EdgeTypeNtro;
import ca.ntro.core.reflection.object_graph.GenericObjectNodeStructureNtro;
import ca.ntro.core.reflection.object_graph.ObjectNodeStructure;
import ca.ntro.core.reflection.object_graph.ReferenceEdge;
import ca.ntro.core.stream.Visitor;

public class JsonObjectNodeStructure 

       extends GenericObjectNodeStructureNtro<JsonObjectNodeNtro>

       implements ObjectNodeStructure {
	

	public JsonObjectNodeStructure(JsonObjectNodeNtro objectNode, JsonObjectGraphNtro graph, boolean isStartNode) {
		super(objectNode, graph, isStartNode);
	}

	@Override
	protected void _visitEdgeTypesForUserDefinedObject(Visitor<EdgeType> visitor, 
			                                           Object object) throws Throwable {
		
		Map<String, Object> jsonObject = (Map<String,Object>) object;
		
		for(String attributeName : jsonObject.keySet()) {

			if(!attributeName.equals(JsonObject.REFERENCE_KEY)
					&& !attributeName.equals(JsonObject.TYPE_KEY)) {

				visitor.visit(new EdgeTypeNtro(Direction.FORWARD, attributeName));
			}
		}
	}

	@Override
	protected void _visitEdgesByTypeForUserDefinedObject(EdgeType edgeType, 
			                                             Object object, 
			                                             Visitor<ReferenceEdge> visitor) throws Throwable {

		Map<String, Object> jsonObject = (Map<String,Object>) object;
		
		String attributeName = edgeType.name().toString();
		
		Object attributeValue = jsonObject.get(attributeName);

		_visitAttributeEdge(attributeName, attributeValue, visitor);

	}

}
