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

import ca.ntro.core.graphs.common.NodeId;
import ca.ntro.core.reflection.object_graph.LocalHeap;
import ca.ntro.core.reflection.object_graph.LocalHeapNtro;
import ca.ntro.core.reflection.object_graph.ObjectGraphNtro;
import ca.ntro.core.reflection.object_graph.ObjectNode;

public class LocalJsonHeap  
       
       extends LocalHeapNtro {

	public LocalJsonHeap(ObjectGraphNtro graph) {
		super(graph);
	}

	@Override
	protected ObjectNode createNode(ObjectGraphNtro graph, 
			                        LocalHeap localHeap, 
			                        Object object, 
			                        NodeId nodeId, 
			                        boolean isStartNode) {

		return new JsonObjectNodeNtro(graph, localHeap, object, nodeId, isStartNode);
	}

	@Override
	public ObjectNode findNodeInHeap(Object object) {
		ObjectNode node = null;
		
		node = super.findNodeInHeap(object);
		
		if(node == null) {
			
			if(object instanceof Map) {

				Map map = (Map) object;

				String referencedNodeId = (String) map.get(JsonObject.REFERENCE_KEY);

				if(referencedNodeId != null) {
					
					node = findNodeById(referencedNodeId);
					
					if(node == null) {
						node = getGraph().findNode(referencedNodeId);
					}
				}
			}
		}
		
		return node;
	}
}
