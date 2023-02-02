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

import ca.ntro.core.graphs.common.NodeId;
import ca.ntro.core.graphs.generics.graph.GenericNodeStructure;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.reflection.object_graph.GenericObjectNode;
import ca.ntro.core.reflection.object_graph.LocalHeap;
import ca.ntro.core.reflection.object_graph.ObjectGraphNtro;
import ca.ntro.core.reflection.object_graph.ObjectGraphSearchOptions;
import ca.ntro.core.reflection.object_graph.ObjectGraphSearchOptionsNtro;
import ca.ntro.core.reflection.object_graph.ObjectNodeNtro;
import ca.ntro.core.reflection.object_graph.ObjectNodeSimpleValue;
import ca.ntro.core.reflection.object_graph.ObjectNode;
import ca.ntro.core.reflection.object_graph.ReferenceEdge;
import ca.ntro.core.reflection.object_graph.revisions.Revision;
import ca.ntro.core.reflection.object_graph.revisions.Revisions;
import ca.ntro.core.services.ReflectionServiceJdk;

public class ObjectNodeJdk extends ObjectNodeNtro {
	
	
	private ObjectNodeStructureJdk nodeStructure;

	public ObjectNodeStructureJdk getNodeStructure() {
		return nodeStructure;
	}

	public void setNodeStructure(ObjectNodeStructureJdk nodeStructure) {
		this.nodeStructure = nodeStructure;
	}


	public ObjectNodeJdk(ObjectGraphNtro graph, LocalHeap localHeap, Object object, NodeId nodeId, boolean isStartNode) {
		super(graph, localHeap, object, nodeId);
		
		convertEnumToStringIfNecessary();
		
		setNodeStructure(new ObjectNodeStructureJdk((ObjectNodeNtro) this, (ObjectGraphNtro) getGraph(), isStartNode));
	}

	private void convertEnumToStringIfNecessary() {
		if(object() != null
				&& ((ReflectionServiceJdk) Ntro.reflection()).isEnum(object())) {

			setObject(String.valueOf(object()));
		}
	}

	@Override
	protected ObjectGraphSearchOptions defaultSearchOptions() {
		return new ObjectGraphSearchOptionsNtro();
	}

	@Override
	protected GenericNodeStructure<ObjectNode, ReferenceEdge, ObjectGraphSearchOptions> nodeStructure() {
		return getNodeStructure();
	}

	@Override
	protected void applyRevisionToUserDefinedObject(Object object, String attributeName, Revision revision) {
		
		if(revision.isUpdate()) {

			String setterName = ReflectionUtils.setterNameFromAttributeName(attributeName);

			ObjectBuilderJdk.invokeSetter(object, setterName, revision.asUpdate().value());
			
		}else {

			Ntro.throwException("[FATAL] only update is supported on user-defined object");
		}

		
	}

}
