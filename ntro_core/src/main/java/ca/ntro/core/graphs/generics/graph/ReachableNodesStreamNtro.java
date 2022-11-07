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

import ca.ntro.core.stream.StreamNtro;
import ca.ntro.core.stream.Visitor;

public class ReachableNodesStreamNtro<N extends GenericNode<N,E,SO>, 
                                      E extends GenericEdge<N,E,SO>,
                                      SO extends SearchOptions> 

       extends StreamNtro<VisitedNode<N,E,SO>>

	   implements ReachableNodesStream<N,E,SO> {
	
	private GenericNodeNtro<N,E,SO> node;
	private SO searchOptions;

	public GenericNodeNtro<N, E, SO> getNode() {
		return node;
	}

	public void setNode(GenericNodeNtro<N, E, SO> node) {
		this.node = node;
	}

	public SO getSearchOptions() {
		return searchOptions;
	}

	public ReachableNodesStreamNtro() {
	}

	public ReachableNodesStreamNtro(GenericNodeNtro<N, E, SO> genericNodeNtro, SO options) {
		setNode(genericNodeNtro);
		setSearchOptions(options);
	}

	public void setSearchOptions(SO searchOptions) {
		this.searchOptions = searchOptions;
	}

	@Override
	public void forEach_(Visitor<VisitedNode<N, E, SO>> visitor) throws Throwable {
		if(searchOptions.internal().searchStrategy() == SearchStrategy.DEPTH_FIRST_SEARCH) {

			node.visitReachableNodesDepthFirst(searchOptions, new WalkNtro<N,E,SO>(), visitor);

		}else {

			node.visitReachableNodesBreadthFirst(searchOptions, 
												 node.oneStepOptions(),
						                         new WalkNtro<N,E,SO>(), 
						                         visitor);
		}
	}

}
