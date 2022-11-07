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
package ca.ntro.core.graphs.generics.graph;


import ca.ntro.core.graph_writer.GraphWriter;
import ca.ntro.core.graphs.common.NodeId;
import ca.ntro.core.stream.Stream;

public interface GenericGraph<N extends GenericNode<N,E,SO>, 
                              E extends GenericEdge<N,E,SO>,
                              SO extends SearchOptions,
                              GO extends GraphWriterOptions> {

	GraphId id();
	String label();

	void write(GraphWriter writer);
	void write(GO options, GraphWriter writer);

	SO defaultSearchOptions();
	GO defaultGraphWriterOptions();

	N findNode(String nodeId);
	N findNode(NodeId nodeId);

	Stream<N> startNodes();

	Stream<N> nodes();
	Stream<E> edges();

	Stream<VisitedNode<N,E,SO>> visitNodes();
	Stream<VisitedNode<N,E,SO>> visitNodes(SO options);

	Stream<VisitedEdge<N,E,SO>> visitEdges();
	Stream<VisitedEdge<N,E,SO>> visitEdges(SO options);

	Stream<WalkInProgress<N,E,SO>> walk(WalkId walk);
	Stream<WalkInProgress<N,E,SO>> walk(WalkId walk, SO options);

}
