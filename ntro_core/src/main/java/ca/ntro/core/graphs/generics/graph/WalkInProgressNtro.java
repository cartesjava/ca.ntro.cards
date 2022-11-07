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

public class      WalkInProgressNtro<N extends GenericNode<N,E,SO>, 
                                     E extends GenericEdge<N,E,SO>,
                                     SO extends SearchOptions> 

       extends    VisitedItemNtro<N,E,SO>

       implements WalkInProgress<N,E,SO> {
	
	private WalkId remainingWalk;
	private N currentNode;

	public WalkId getRemainingWalk() {
		return remainingWalk;
	}

	public void setRemainingWalk(WalkId remainingWalk) {
		this.remainingWalk = remainingWalk;
	}

	public N getCurrentNode() {
		return currentNode;
	}

	public void setCurrentNode(N currentNode) {
		this.currentNode = currentNode;
	}
	
	public WalkInProgressNtro() {
	}

	public WalkInProgressNtro(WalkNtro<N,E,SO> walked, WalkId remainingWalk, N currentNode) {
		super(walked);
		setRemainingWalk(remainingWalk);
		setCurrentNode(currentNode);
	}

	public WalkInProgressNtro(WalkNtro<N, E, SO> walked, WalkId remainingWalk) {
		super(walked);
		setRemainingWalk(remainingWalk);
	}

	@Override
	public WalkId remainingWalk() {
		return getRemainingWalk();
	}

	@Override
	public N currentNode() {
		return getCurrentNode();
	}

	@Override
	public boolean hasCurrentNode() {
		return getCurrentNode() != null;
	}
}
