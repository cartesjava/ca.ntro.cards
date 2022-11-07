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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ca.ntro.core.graphs.generics.graph.GenericEdge;
import ca.ntro.core.graphs.common.Direction;
import ca.ntro.core.graphs.common.EdgeType;
import ca.ntro.core.graphs.generics.graph.GenericNode;
import ca.ntro.core.graphs.generics.graph.SearchOptions;
import ca.ntro.core.stream.Stream;
import ca.ntro.core.stream.StreamNtro;
import ca.ntro.core.stream.Visitor;

public abstract class EdgesMapNtro<N extends GenericNode<N,E,SO>, 
                                   E extends GenericEdge<N,E,SO>,
                                   SO extends SearchOptions,
                                   SUBMAP extends EdgesMap<N,E,SO>>

	   implements     EdgesMap<N,E,SO> {
	
	private Map<String, SUBMAP> edgesMap = new HashMap<>();

	public Map<String, SUBMAP> getEdgesMap() {
		return edgesMap;
	}

	public void setEdgesMap(Map<String, SUBMAP> edgesMap) {
		this.edgesMap = edgesMap;
	}

	protected abstract SUBMAP createSubMap();
	protected abstract Collection<SUBMAP> subMapsForDirection(Direction direction);

	protected abstract String getSubMapKey(E edge);
	protected abstract String getSubMapKey(EdgeType edgeName);
	
	@Override
	public boolean containsEdge(E edge) {
		boolean contains = false;
		
		SUBMAP subMap = getEdgesMap().get(getSubMapKey(edge));
		
		if(subMap != null) {
			contains = subMap.containsEdge(edge);
		}


		return contains;
	}


	@Override
	public void addEdge(E edge) {
		SUBMAP subMap = getEdgesMap().get(getSubMapKey(edge));

		if(subMap == null) {
			subMap = createSubMap();
			getEdgesMap().put(getSubMapKey(edge), subMap);
		}

		subMap.addEdge(edge);
	}

	@Override
	public Stream<EdgeType> edgeTypes(Direction direction) {
		return new StreamNtro<EdgeType>() {
			@Override
			public void forEach_(Visitor<EdgeType> visitor) throws Throwable {

				for(SUBMAP subMap : subMapsForDirection(direction)) {

					if(subMap != null) {

						subMap.edgeTypes(direction).forEach_(visitor);
					}
				}
			}
		};
	}

	@Override
	public Stream<E> edges(EdgeType edgeType) {
		return new StreamNtro<E>() {
			@Override
			public void forEach_(Visitor<E> visitor) throws Throwable {

				SUBMAP subMap = getEdgesMap().get(getSubMapKey(edgeType));
				
				if(subMap != null) {

					subMap.edges(edgeType).forEach_(visitor);
				}
			}
		};
	}
}
