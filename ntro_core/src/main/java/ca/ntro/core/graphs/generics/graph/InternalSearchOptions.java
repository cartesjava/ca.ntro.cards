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

import java.util.Set;

import ca.ntro.core.graphs.common.Direction;
import ca.ntro.core.stream.Stream;
import ca.ntro.core.wrappers.optionnal.Optionnal;

public interface InternalSearchOptions {

	SearchStrategy searchStrategy();
	Direction[] directions();
	Stream<Direction> directionStream();
	Optionnal<Integer> maxDistance();
	boolean sortEdgesByName();
	
	Set<String> visitedNodes();
	Set<String> visitedEdges();

	void copyOptions(InternalSearchOptions searchOptions);

}
