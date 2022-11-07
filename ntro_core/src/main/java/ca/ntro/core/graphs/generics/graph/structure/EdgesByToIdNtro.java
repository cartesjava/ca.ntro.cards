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

public class EdgesByToIdNtro<N extends GenericNode<N,E,SO>, 
                             E extends GenericEdge<N,E,SO>,
                             SO extends SearchOptions> 

       implements EdgesByToId<N,E,SO> {

	

	private Map<String, E> edgesMap = new HashMap<>();

	public Map<String, E> getEdgesMap() {
		return edgesMap;
	}

	public void setEdgesMap(Map<String, E> edgesMap) {
		this.edgesMap = edgesMap;
	}

	@Override
	public boolean containsEdge(E edge) {
		return getEdgesMap().containsKey(edge.to().id().toKey().toString());
	}

	@Override
	public void addEdge(E edge) {
		getEdgesMap().put(edge.to().id().toKey().toString(), edge);
	}

	@Override
	public Stream<EdgeType> edgeTypes(Direction direction) {
		return new StreamNtro<EdgeType>() {

			@Override
			public void forEach_(Visitor<EdgeType> visitor) throws Throwable {

				for(E edge: edgesMap.values()) {

					visitor.visit(edge.type());
				}
			}
		};
	}

	@Override
	public Stream<E> edges(EdgeType edgeType) {
		return new StreamNtro<E>() {

			@Override
			public void forEach_(Visitor<E> visitor) throws Throwable {
				for(E edge: edgesMap.values()) {

					visitor.visit(edge);
				}
			}
		};
	}
}
