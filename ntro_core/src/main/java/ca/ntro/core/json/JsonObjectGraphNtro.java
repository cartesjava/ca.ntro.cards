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
import ca.ntro.core.graphs.generics.graph.WalkId;
import ca.ntro.core.graphs.generics.graph.WalkInProgress;
import ca.ntro.core.path.Path;
import ca.ntro.core.reflection.object_graph.ObjectGraph;
import ca.ntro.core.reflection.object_graph.ObjectGraphNtro;
import ca.ntro.core.reflection.object_graph.ObjectGraphSearchOptions;
import ca.ntro.core.reflection.object_graph.ObjectGraphStructureNtro;
import ca.ntro.core.reflection.object_graph.ObjectNode;
import ca.ntro.core.reflection.object_graph.ReferenceEdge;

public abstract class   JsonObjectGraphNtro

       extends ObjectGraphNtro
       
       implements ObjectGraph {

	public JsonObjectGraphNtro(Object o) {
		super(o);
	}

	public JsonObjectGraphNtro(Object o, String graphName) {
		super(o, graphName);
	}

	@Override
	protected ObjectGraphStructureNtro newObjectGraphStructureInstance() {
		return new JsonObjectGraphStructure();
	}

	@Override
	public ObjectNode findNode(String rawPathToNode) {

		ObjectNode node = ((JsonObjectGraphStructure) getGraphStructure()).getLocalHeap().findNodeById(rawPathToNode);
		
		if(node == null) {

			WalkId walkId = WalkId.fromPath(Path.fromRawPath(rawPathToNode));
			
			WalkInProgress<ObjectNode, ReferenceEdge, ObjectGraphSearchOptions> lastOfWalk = walk(walkId).findFirst(walkInProgress -> {

						if(walkInProgress.remainingWalk().isEmpty()
								&& walkInProgress.hasCurrentNode()) {
							
							return true;
						}
						
						return false;
			});

			if(lastOfWalk != null) {
				node = lastOfWalk.currentNode();
			}
		}

		return node;
	}

	@Override
	public ObjectNode findNode(NodeId nodeId) {
		return findNode(nodeId.toKey().toString());
	}

}
