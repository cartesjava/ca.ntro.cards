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

import java.util.HashSet;
import java.util.Set;

import ca.ntro.core.graphs.common.Direction;
import ca.ntro.core.stream.Stream;
import ca.ntro.core.stream.StreamNtro;
import ca.ntro.core.stream.Visitor;
import ca.ntro.core.wrappers.optionnal.Optionnal;

public class InternalSearchOptionsNtro implements InternalSearchOptions {

	private SearchStrategy searchStrategy = SearchStrategy.DEPTH_FIRST_SEARCH;
	private Optionnal<Integer> maxDistance = Optionnal.none(Integer.class);
	private Direction[] directions = new Direction[] {Direction.BACKWARD, Direction.FORWARD};
	private boolean sortEdgesByName = false;
	
	private Set<String> visitedNodes = new HashSet<>();
	private Set<String> visitedEdges = new HashSet<>();

	public SearchStrategy getSearchStrategy() {
		return searchStrategy;
	}

	public void setSearchStrategy(SearchStrategy searchStrategy) {
		this.searchStrategy = searchStrategy;
	}

	public Optionnal<Integer> getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(Optionnal<Integer> maxDistance) {
		this.maxDistance = maxDistance;
	}

	public void setMaxDistance(int maxDistance) {
		this.maxDistance = Optionnal.fromValue(maxDistance);
	}

	public Direction[] getDirections() {
		return directions;
	}

	public void setDirections(Direction[] directions) {
		this.directions = directions;
	}

	public boolean getSortEdgesByName() {
		return sortEdgesByName;
	}

	public void setSortEdgesByName(boolean sortEdgesByName) {
		this.sortEdgesByName = sortEdgesByName;
	}

	public Set<String> getVisitedNodes() {
		return visitedNodes;
	}

	public void setVisitedNodes(Set<String> visitedNodes) {
		this.visitedNodes = visitedNodes;
	}

	public Set<String> getVisitedEdges() {
		return visitedEdges;
	}

	public void setVisitedEdges(Set<String> visitedEdges) {
		this.visitedEdges = visitedEdges;
	}

	@Override
	public SearchStrategy searchStrategy() {
		return getSearchStrategy();
	}

	@Override
	public Direction[] directions() {
		return getDirections();
	}

	@Override
	public Optionnal<Integer> maxDistance() {
		return getMaxDistance();
	}

	@Override
	public boolean sortEdgesByName() {
		return getSortEdgesByName();
	}

	@Override
	public void copyOptions(InternalSearchOptions searchOptions) {
		setSearchStrategy(searchOptions.searchStrategy());
		setMaxDistance(searchOptions.maxDistance());
		setDirections(searchOptions.directions());
		setSortEdgesByName(searchOptions.sortEdgesByName());
		setVisitedNodes(searchOptions.visitedNodes());
		setVisitedEdges(searchOptions.visitedEdges());
	}

	@Override
	public Set<String> visitedNodes() {
		return getVisitedNodes();
	}

	@Override
	public Set<String> visitedEdges() {
		return getVisitedEdges();
	}

	@Override
	public Stream<Direction> directionStream() {
		return new StreamNtro<Direction>() {
			@Override
			public void forEach_(Visitor<Direction> visitor) throws Throwable {
				
				for(Direction direction : directions()) {
					visitor.visit(direction);
				}
			}
		};
	}
}
