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

public class VisitedNodeNtro <N extends GenericNode<N,E,SO>, 
                              E extends GenericEdge<N,E,SO>,
                              SO extends SearchOptions> 

       extends VisitedItemNtro<N,E,SO>

       implements VisitedNode<N,E,SO> {
	
	private GenericNodeNtro<N,E,SO> node;

	public GenericNodeNtro<N,E,SO> getNode() {
		return node;
	}

	public void setNode(GenericNodeNtro<N,E,SO> node) {
		this.node = node;
	}
	
	public VisitedNodeNtro() {
	}
	
	public VisitedNodeNtro(WalkNtro<N,E,SO> walked, GenericNodeNtro<N,E,SO> node) {
		super(walked);
		setNode(node);
	}

	@SuppressWarnings("unchecked")
	@Override
	public N node() {
		return (N) getNode();
	}
}
