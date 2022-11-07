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
package ca.ntro.core.data_structures.trees.region_tree;

import ca.ntro.core.stream.Stream;

public interface RegionTree2d<R extends Region2d> {

	void add(R region);
	
	void remove(String id);
	void remove(R region);

	void onRegionMoved(String id);

	R get(String id);

	Stream<R> intersectWith(AnonymousRegion2d otherRestion);

	Stream<R> intersectWith(double topLeftX,
			                double topLeftY,
			                double width,
			                double height);

	Stream<R> containedIn(AnonymousRegion2d otherRegion);

	Stream<R> containedIn(double topLeftX,
			              double topLeftY,
			              double width,
			              double height);

	Stream<R> get(AnonymousRegion2d regionSpec);

	Stream<R> get(double topLeftX,
			      double topLeftY,
			      double width,
			      double height);

}
