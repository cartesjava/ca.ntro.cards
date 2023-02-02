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
package ca.ntro.core.graphs.directed_graph;

import ca.ntro.core.graphs.generics.directed_graph.DirectedGraphWriterOptions;
import ca.ntro.core.graphs.generics.directed_graph.DirectedGraphSearchOptions;
import ca.ntro.core.graphs.generics.directed_graph.GenericDirectedGraphBuilder;
import ca.ntro.core.graphs.graph.EdgeFactory;
import ca.ntro.core.graphs.graph.EdgeFactoryNtro;
import ca.ntro.core.graphs.graph.NodeFactory;
import ca.ntro.core.graphs.graph.NodeFactoryNtro;

public interface DirectedGraphBuilder<N extends  DirectedNode<N,E>, 
                                      E extends  DirectedEdge<N,E>>

       extends GenericDirectedGraphBuilder<N,
                                           E,
                                           DirectedGraphSearchOptions,
                                           DirectedNodeBuilder<N,E>,
                                           DirectedGraphWriterOptions,
                                           DirectedGraph<N,E>> {

	static <N extends DirectedNodeNtro<N,E>, E extends DirectedEdgeNtro<N,E>> 

	      DirectedGraphBuilder<N,E> newBuilder(DirectedNodeFactory<N,E> nodeFactory, DirectedEdgeFactory<N,E> edgeFactory) {
		
		DirectedGraphBuilderNtro<N,E> builder = new DirectedGraphBuilderNtro<N,E>();
		
		builder.setNodeFactory(nodeFactory);
		builder.setEdgeFactory(edgeFactory);

		builder.initialize();

		return builder;
	}

	static <N extends DirectedNodeNtro<N,E>, E extends DirectedEdgeNtro<N,E>> 

	      DirectedGraphBuilder<N,E> newBuilder(Class<N> nodeClass, Class<E> edgeClass) {

		// JSweet: class instead of lambda to avoid typing errors
		DirectedNodeFactoryNtro<N,E> nodeFactory = new DirectedNodeFactoryNtro<>();
		nodeFactory.setNodeClass(nodeClass);
		
		DirectedEdgeFactoryNtro<N,E> edgeFactory = new DirectedEdgeFactoryNtro<N,E>();
		edgeFactory.setEdgeClass(edgeClass);
		
		return newBuilder(nodeFactory, edgeFactory);
	}

}
