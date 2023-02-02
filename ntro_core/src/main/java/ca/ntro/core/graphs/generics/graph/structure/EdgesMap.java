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
package ca.ntro.core.graphs.generics.graph.structure;

import ca.ntro.core.graphs.generics.graph.GenericEdge;
import ca.ntro.core.graphs.common.Direction;
import ca.ntro.core.graphs.common.EdgeType;
import ca.ntro.core.graphs.generics.graph.GenericNode;
import ca.ntro.core.graphs.generics.graph.SearchOptions;
import ca.ntro.core.stream.Stream;

public interface EdgesMap<N extends GenericNode<N,E,SO>, 
                          E extends GenericEdge<N,E,SO>,
                          SO extends SearchOptions> {
	
	boolean containsEdge(E edge);

	void addEdge(E edge);

	Stream<EdgeType> edgeTypes(Direction direction);
	Stream<E> edges(EdgeType edgeType);

}
