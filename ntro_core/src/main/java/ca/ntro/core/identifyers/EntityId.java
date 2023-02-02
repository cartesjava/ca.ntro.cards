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
package ca.ntro.core.identifyers;

import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.path.Path;

public class EntityId extends IdPathNtro {
	
	protected EntityId() {
		super();
	}
	
	public EntityId(Path entityPath) {
		setEntityPath(entityPath);
	}
	
	public EntityId(String rawId) {
		if(rawId.contains(Path.FILENAME_SEPARATOR)
				&& rawId.contains(Path.PATH_SEPARATOR)) {
			
			Ntro.exceptionService().throwException(new RuntimeException("rawId cannot contain both " + Path.FILENAME_SEPARATOR + " and " + Path.PATH_SEPARATOR));
		}
		
		if(rawId.contains(Path.FILENAME_SEPARATOR)) {
			
			setEntityPath(Path.fromFilename(rawId));
			
		}else {
			
			setEntityPath(Path.fromRawPath(rawId));
		}
	}

	@Override
	public String toString() {
		return getEntityPath().toRawPath();
	}

}
