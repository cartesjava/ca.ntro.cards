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
package ca.ntro.core.graphs.graph;

import ca.ntro.core.graphs.generics.graph.GenericGraphBuilder;
import ca.ntro.core.graphs.generics.graph.GraphWriterOptions;

public interface GraphBuilder<N extends Node<N,E>,
                              E extends Edge<N,E>>

       extends   GenericGraphBuilder<N,E, GraphSearchOptions, NodeBuilder<N,E>, GraphWriterOptions, Graph<N,E>> {

	static <N extends NodeNtro<N,E>, E extends EdgeNtro<N,E>> 

	      GraphBuilder<N,E> newBuilder(NodeFactory<N,E> nodeFactory, EdgeFactory<N,E> edgeFactory) {
		
		GraphBuilderNtro<N,E> builder = new GraphBuilderNtro<N,E>();
		
		builder.setNodeFactory(nodeFactory);
		builder.setEdgeFactory(edgeFactory);

		builder.initialize();

		return builder;
	}

	static <N extends NodeNtro<N,E>, E extends EdgeNtro<N,E>> 

	      GraphBuilder<N,E> newBuilder(Class<N> nodeClass, Class<E> edgeClass) {

		// JSweet: class instead of lambda to avoid typing errors
		NodeFactoryNtro<N,E> nodeFactory = new NodeFactoryNtro<>();
		nodeFactory.setNodeClass(nodeClass);
		
		EdgeFactoryNtro<N,E> edgeFactory = new EdgeFactoryNtro<N,E>();
		edgeFactory.setEdgeClass(edgeClass);
		
		return newBuilder(nodeFactory, edgeFactory);
	}


}
