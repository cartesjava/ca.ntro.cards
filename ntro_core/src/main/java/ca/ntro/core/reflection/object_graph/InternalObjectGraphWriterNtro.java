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

import ca.ntro.core.graph_writer.GraphWriter;
import ca.ntro.core.graph_writer.NodeSpecNtro;
import ca.ntro.core.graph_writer.RecordNodeSpecNtro;
import ca.ntro.core.graphs.generics.directed_graph.GenericInternalDirectedGraphWriterNtro;
import ca.ntro.core.graphs.generics.graph.GenericGraph;

public class InternalObjectGraphWriterNtro       

       extends   GenericInternalDirectedGraphWriterNtro<ObjectNode, 
                                                       ReferenceEdge, 
                                                       ObjectGraphSearchOptions,
                                                       ObjectGraphWriterOptions> 

      implements InternalObjectGraphWriter {

	@Override
	protected void adjustNodeSpecAttributes(ObjectNode node, 
			                                ObjectGraphWriterOptions options,
			                                NodeSpecNtro nodeSpec) {
		
		if(!options.objectAsStructure()) {
			super.adjustNodeSpecAttributes(node, options, nodeSpec);
		}
	}
	
	@Override
	protected void writeNodes(GenericGraph<ObjectNode,ReferenceEdge,ObjectGraphSearchOptions,ObjectGraphWriterOptions> graph, 
			                  ObjectGraphWriterOptions options,
			                  GraphWriter writer) {
		
		if(!options.objectAsStructure()) {

			super.writeNodes(graph, options, writer);

		}else {
			
			ObjectStructureWriter objectStructureWriter = new ObjectStructureWriter(graph, this, options, writer);

			objectStructureWriter.writeNodes();
			objectStructureWriter.writeEdges();
		}
		
	}

	protected RecordNodeSpecNtro recordNodeSpec(ObjectNode node, ObjectGraphWriterOptions options) {
		RecordNodeSpecNtro recordSpec = new RecordNodeSpecNtro(node);
		
		adjustNodeSpecAttributes(node, options, recordSpec);
		
		return recordSpec;
	}

	@Override
	protected void writeEdges(GenericGraph<ObjectNode,ReferenceEdge,ObjectGraphSearchOptions,ObjectGraphWriterOptions> graph, 
			                  ObjectGraphWriterOptions options,
			                  GraphWriter writer) {
		
		if(!options.objectAsStructure()) {
			super.writeEdges(graph, options, writer);
		}
	}
}
