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
package ca.ntro.core.graphs.hierarchical_graph;

import ca.ntro.core.graphs.generics.hierarchical_graph.GenericHierarchicalGraphBuilder;
import ca.ntro.core.graphs.generics.hierarchical_graph.HierarchicalGraphWriterOptions;

public interface HierarchicalGraphBuilder<N extends HierarchicalGraphNode<N,E>,
                                          E extends HierarchicalGraphEdge<N,E>>

       extends GenericHierarchicalGraphBuilder<N,
                                               E,
                                               HierarchicalGraphSearchOptions,
                                               HierarchicalGraphNodeBuilder<N,E>,
                                               HierarchicalGraphWriterOptions,
                                               HierarchicalGraph<N,E>> {

	static <N extends HierarchicalGraphNodeNtro<N,E>, E extends HierarchicalGraphEdgeNtro<N,E>> 

	      HierarchicalGraphBuilder<N,E> newBuilder(HierarchicalNodeFactory<N,E> nodeFactory, HierarchicalEdgeFactory<N,E> edgeFactory) {
		
		HierarchicalGraphBuilderNtro<N,E> builder = new HierarchicalGraphBuilderNtro<N,E>();
		
		builder.setNodeFactory(nodeFactory);
		builder.setEdgeFactory(edgeFactory);
		
		builder.initialize();

		return builder;
	}

	static <N extends HierarchicalGraphNodeNtro<N,E>, E extends HierarchicalGraphEdgeNtro<N,E>> 

	      HierarchicalGraphBuilder<N,E> newBuilder(Class<N> nodeClass, Class<E> edgeClass) {

	    
		HierarchicalNodeFactoryNtro<N,E> nodeFactory = new HierarchicalNodeFactoryNtro<N, E>();
		nodeFactory.setNodeClass(nodeClass);
		
		HierarchicalEdgeFactoryNtro<N,E> edgeFactory = new HierarchicalEdgeFactoryNtro<N,E>();
		edgeFactory.setEdgeClass(edgeClass);

		return newBuilder(nodeFactory, edgeFactory);
	}
}
