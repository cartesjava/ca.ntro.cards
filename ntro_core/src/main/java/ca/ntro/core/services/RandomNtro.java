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
package ca.ntro.core.services;

import java.util.List;

public abstract class RandomNtro implements Random {

	@Override
	public <V> V choice(List<V> list) {
		V result = null;

		if(!list.isEmpty()) {
			result = list.get(nextInt(list.size()));
		}
		
		return result;
	}

	@Override
	public <V> V choice(V[] array) {
		V result = null;

		if(array.length > 0) {
			result = array[nextInt(array.length)];
		}

		return result;
	}

}
