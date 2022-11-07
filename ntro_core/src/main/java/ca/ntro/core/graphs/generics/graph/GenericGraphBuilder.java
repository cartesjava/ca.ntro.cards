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

import ca.ntro.core.graphs.common.NodeId;

public interface GenericGraphBuilder<N extends GenericNode<N,E,SO>,
                                     E extends GenericEdge<N,E,SO>,
                                     SO extends SearchOptions,
									 NB extends GenericNodeBuilder<N,E,SO,NB>,
									 GO extends GraphWriterOptions,
                                     G extends GenericGraph<N,E,SO,GO>> 

       extends GenericGraphStructure<N,E,SO> { 
	
	NB addNode(String nodeId);
	NB addNode(NodeId nodeId);
	NB addNode(N node);

	NB findNode(String nodeId);
	NB findNode(NodeId nodeId);

	E addEdge(NB fromNode, String edgeName, NB toNode);

	G graph();

	void setGraphName(String string);
}
