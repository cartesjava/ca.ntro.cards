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
package ca.ntro.core.graphs.common;

import ca.ntro.core.stream.Stream;
import ca.ntro.core.stream.StreamNtro;
import ca.ntro.core.stream.Visitor;

public enum Direction {

	FORWARD, BACKWARD, UP, DOWN;

	public boolean equalsUndirected(Direction other) {
		if(this == other) {
			return true;
		}
		
		if(this == FORWARD && other == BACKWARD) {
			return true;
		}

		if(this == BACKWARD && other == FORWARD) {
			return true;
		}
		
		return false;
		
	}
	
	public static Stream<Direction> asStream(){
		return new StreamNtro<Direction>() {
			@Override
			public void forEach_(Visitor<Direction> visitor) throws Throwable {
				for(Direction direction : Direction.values()) {
					visitor.visit(direction);
				}
			}
		};
		
	}
}
