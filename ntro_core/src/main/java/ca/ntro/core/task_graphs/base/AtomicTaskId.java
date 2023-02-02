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
package ca.ntro.core.task_graphs.base;

import ca.ntro.core.identifyers.Id;
import ca.ntro.core.identifyers.Key;

public class AtomicTaskId implements Id {
	
	private Key key;

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public static AtomicTaskId fromKey(Key key) {
		AtomicTaskId id = new AtomicTaskId();

		id.setKey(key);
		
		return id;
	}

	public static AtomicTaskId fromKey(String key) {
		return fromKey(new Key(key));
	}

	@Override
	public Key toKey() {
		return getKey();
	}

}
