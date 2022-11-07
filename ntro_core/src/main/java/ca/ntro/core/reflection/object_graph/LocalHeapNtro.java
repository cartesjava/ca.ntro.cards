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

import java.util.HashMap;
import java.util.Map;

import ca.ntro.core.graphs.common.NodeId;
import ca.ntro.core.graphs.common.NodeIdNtro;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.path.Path;

public abstract class LocalHeapNtro implements LocalHeap {

	private ObjectGraphNtro graph;
	private Map<Object, Map<ObjectNode, Object>> heap = new HashMap<>();
	private Map<String, ObjectNode> nodesById = new HashMap<>();

	public ObjectGraphNtro getGraph() {
		return graph;
	}

	public void setGraph(ObjectGraphNtro graph) {
		this.graph = graph;
	}

	public LocalHeapNtro(ObjectGraphNtro graph) {
		this.graph = graph;
	}

	@Override
	public ObjectNode findOrCreateNode(ObjectGraphNtro graph, Path attributePath, Object object, boolean isStartNode) {

		ObjectNode node;
		
		if(Ntro.reflection().isSimpleValue(object)) {

			node = createNode(graph, attributePath, object, isStartNode);

		}else {

			node = findNodeInHeap(object);

			if(node == null) {

			    node = createNode(graph, attributePath, object, isStartNode);

				addNodeToHeap(node);
			}
		}
		
		return node;
	}

	@Override
	public ObjectNode findNodeInHeap(Object object) {

		ObjectNode node = null;
		
		Map<ObjectNode, Object> objectByNode = heap.get(object);
		
		if(objectByNode != null) {

			for(Map.Entry<ObjectNode, Object> entry : objectByNode.entrySet()) {

				if(entry.getValue() == object) {
					node = entry.getKey();
					break;
				}
			}
		}
		
		return node;

	}


	private ObjectNode createNode(ObjectGraphNtro graph, Path attributePath, Object object, boolean isStartNode) {
		ObjectNode node;

		//NodeId nodeId = new NodeIdNtro(attributePath.toKey());
		NodeId nodeId = new NodeIdNtro(attributePath.toRawPath());
		node = createNode(graph, this, object, nodeId, isStartNode);

		return node;
	}

	protected abstract ObjectNode createNode(ObjectGraphNtro graph, LocalHeap localHeap, Object object, NodeId nodeId, boolean isStartNode);


	protected void addNodeToHeap(ObjectNode node) {

		Object object = node.object();

		Map<ObjectNode, Object> objectByNode = heap.get(object);

		if(objectByNode == null) {
			objectByNode = new HashMap<>();
			heap.put(object, objectByNode);
		}

		objectByNode.put(node, object);

		nodesById.put(node.id().toKey().toString(), node);
	}

	@Override
	public ObjectNode findNodeById(String nodeId) {
		return nodesById.get(nodeId);
	}
}
