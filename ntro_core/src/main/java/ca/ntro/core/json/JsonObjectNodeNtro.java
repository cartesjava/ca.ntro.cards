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

import ca.ntro.core.graphs.common.NodeId;
import ca.ntro.core.graphs.generics.graph.GenericNodeStructure;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.reflection.object_graph.LocalHeap;
import ca.ntro.core.reflection.object_graph.ObjectGraphNtro;
import ca.ntro.core.reflection.object_graph.ObjectGraphSearchOptions;
import ca.ntro.core.reflection.object_graph.ObjectNode;
import ca.ntro.core.reflection.object_graph.ObjectNodeNtro;
import ca.ntro.core.reflection.object_graph.ReferenceEdge;
import ca.ntro.core.reflection.object_graph.revisions.Revision;

public class JsonObjectNodeNtro 

       extends ObjectNodeNtro {
	
	private JsonObjectNodeStructure nodeStructure;

	public JsonObjectNodeStructure getNodeStructure() {
		return nodeStructure;
	}

	public void setNodeStructure(JsonObjectNodeStructure nodeStructure) {
		this.nodeStructure = nodeStructure;
	}



	public JsonObjectNodeNtro(ObjectGraphNtro graph, 
			              LocalHeap localHeap, 
			              Object object, 
			              NodeId nodeId,
			              boolean isStartNode) {

		super(graph, localHeap, object, nodeId);
		
		setNodeStructure(new JsonObjectNodeStructure((JsonObjectNodeNtro) this, (JsonObjectGraphNtro) getGraph(), isStartNode));
	}

	@Override
	protected GenericNodeStructure<ObjectNode, ReferenceEdge, ObjectGraphSearchOptions> nodeStructure() {
		return getNodeStructure();
	}

	@Override
	public boolean isUserDefinedObject() {
		boolean isUserDefinedObject = false;

		if(isMap()
				&& asMap().get(JsonObject.TYPE_KEY) != null) {
			
			isUserDefinedObject = true;
		}

		return isUserDefinedObject;
	}

	@Override
	public Class<?> type() {
		Class<?> type = null;

		String className = (String) asMap().get(JsonObject.TYPE_KEY);

		if(className != null) {

			type = Ntro.factory().namedClass(className);

		}else {

			String referencedObjectId = (String) asMap().get(JsonObject.REFERENCE_KEY);
			ObjectNode referencedObjectNode = getGraph().findNode(referencedObjectId);
			
			type = referencedObjectNode.type();
			
		}

		return type;
	}

	@Override
	protected void applyRevisionToUserDefinedObject(Object object, String attributeName, Revision revision) {
		if(revision.isUpdate()) {
			
			asMap().put(attributeName, revision.asUpdate().value());
			
		}else {

			Ntro.throwException("[FATAL] only update is supported on user-defined object");
		}

	}

}
