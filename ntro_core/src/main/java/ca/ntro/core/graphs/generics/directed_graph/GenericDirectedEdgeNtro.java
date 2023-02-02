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
package ca.ntro.core.graphs.generics.directed_graph;

import ca.ntro.core.graphs.common.Direction;
import ca.ntro.core.graphs.common.EdgeTypeNtro;
import ca.ntro.core.graphs.generics.graph.GenericEdgeNtro;

public class      GenericDirectedEdgeNtro<N extends GenericDirectedNode<N,E,SO>, 
                                          E extends GenericDirectedEdge<N,E,SO>,
                                          SO extends DirectedGraphSearchOptions>

       extends    GenericEdgeNtro<N,E,SO>

       implements GenericDirectedEdge<N,E,SO> {

	public GenericDirectedEdgeNtro() {
	}

	public GenericDirectedEdgeNtro(N fromNode, EdgeTypeNtro edgeType, N toNode) {
		super(fromNode, edgeType, toNode);
	}

	public GenericDirectedEdgeNtro(N fromNode, String edgeName, N toNode) {
		super(fromNode, new EdgeTypeNtro(Direction.FORWARD, edgeName), toNode);
	}


}
