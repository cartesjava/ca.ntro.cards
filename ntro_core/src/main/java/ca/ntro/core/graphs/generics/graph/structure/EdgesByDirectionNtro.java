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


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ca.ntro.core.graphs.common.Direction;
import ca.ntro.core.graphs.common.EdgeType;
import ca.ntro.core.graphs.generics.graph.GenericEdge;
import ca.ntro.core.graphs.generics.graph.GenericNode;
import ca.ntro.core.graphs.generics.graph.SearchOptions;

public class      EdgesByDirectionNtro<N extends GenericNode<N,E,SO>, 
                                       E extends GenericEdge<N,E,SO>,
                                       SO extends SearchOptions,
                                       SUBMAP extends EdgesByType<N,E,SO>> 

       extends    EdgesMapNtro<N,E,SO, SUBMAP>

       implements EdgesByDirection<N,E,SO> {

	@SuppressWarnings("unchecked")
	@Override
	protected SUBMAP createSubMap() {
		EdgesByTypeNtro<N, E, SO, EdgesByToId<N, E, SO>> subMap = new EdgesByTypeNtro<N,E,SO, EdgesByToId<N,E,SO>>();
		return (SUBMAP) subMap;
	}

	@Override
	protected Collection<SUBMAP> subMapsForDirection(Direction direction) {
		List<SUBMAP> subMaps = new ArrayList<>();
		subMaps.add(getEdgesMap().get(direction.name()));

		return subMaps;
	}

	@Override
	protected String getSubMapKey(E edge) {
		return edge.type().direction().name();
	}

	@Override
	protected String getSubMapKey(EdgeType edgeName) {
		return edgeName.direction().name();
	}




}
