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
package ca.ntro.core.graphs.generics.hierarchical_graph;

import ca.ntro.core.graphs.common.Direction;
import ca.ntro.core.graphs.common.EdgeTypeNtro;
import ca.ntro.core.graphs.generics.graph.GenericEdge;
import ca.ntro.core.graphs.generics.graph.GenericEdgeNtro;
import ca.ntro.core.graphs.generics.graph.GenericNodeBuilderNtro;

public abstract class GenericHierarchicalNodeBuilderNtro<N extends GenericHierarchicalNode<N,E,SO>,
 									              E extends GenericEdge<N,E,SO>,
 									              SO extends HierarchicalSearchOptions,
 									              NB extends GenericHierarchicalNodeBuilder<N,E,SO,NB>>

       extends        GenericNodeBuilderNtro<N,E,SO,NB> 

	   implements     GenericHierarchicalNodeBuilder<N,E,SO,NB> {


	@Override
	public N node() {
		return getNode();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addSubNode(NB subNode) {
		EdgeTypeNtro edgeType = new EdgeTypeNtro(Direction.DOWN, "");

		// JSweet: local variable before casting
		GenericEdgeNtro<N, E, SO> edge = new GenericEdgeNtro<N,E,SO>(this.node(), edgeType, subNode.node());

		getEdgesByDirection().addEdge((E) edge);

		((GenericHierarchicalNodeBuilderNtro<N,E,SO,NB>) subNode).addParentNode(this.node());
	}

	@SuppressWarnings("unchecked")
	protected void addParentNode(N parentNode) {
		EdgeTypeNtro edgeType = new EdgeTypeNtro(Direction.UP, "");

		// JSweet: local variable before casting
		GenericEdgeNtro<N, E, SO> edge = new GenericEdgeNtro<N,E,SO>(this.node(), edgeType, parentNode);

		((GenericHierarchicalNodeBuilderNtro<N,E,SO,NB>) this).setIsStartNode(false);
		
		getGraphBuilder().removeStartNode(this.node());
		
		getEdgesByDirection().addEdge((E) edge);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected SO defaultSearchOptions() {
		HierarchicalSearchOptionsNtro options = new HierarchicalSearchOptionsNtro();
		return (SO) options;
	}
}
