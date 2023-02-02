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

import ca.ntro.core.graphs.generics.graph.GenericEdge;
import ca.ntro.core.graphs.generics.graph.GenericNode;
import ca.ntro.core.graphs.generics.graph.VisitedNode;
import ca.ntro.core.stream.Stream;

public interface GenericHierarchicalNode<N extends GenericHierarchicalNode<N,E,SO>,
                                         E extends GenericEdge<N,E,SO>,
                                         SO extends HierarchicalSearchOptions>

       extends   GenericNode<N,E,SO> {
	
	boolean hasSubNodes();
	boolean hasParent();

	N parent();
	
	Stream<VisitedNode<N,E,SO>> subNodes();
	Stream<VisitedNode<N,E,SO>> subNodes(SO options);

	Stream<VisitedNode<N,E,SO>> parentNodes();
	Stream<VisitedNode<N,E,SO>> parentNodes(SO options);
}
