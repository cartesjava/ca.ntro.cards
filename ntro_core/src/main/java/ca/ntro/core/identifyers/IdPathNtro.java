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

import ca.ntro.core.path.Filepath;
import ca.ntro.core.path.Path;

public class IdPathNtro implements Id {

	private Path entityPath;

	protected IdPathNtro() {
	}
	
	public IdPathNtro(String id) {
		setEntityPath(Path.fromSingleName(id));
	}

	public IdPathNtro(Path path) {
		setEntityPath(path);
	}

	protected void setEntityPath(Path entityPath) {
		this.entityPath = entityPath;
	}

	protected Path getEntityPath() {
		return this.entityPath;
	}

	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
		if(o == this) return true;
		if(o instanceof IdPathNtro) {
			IdPathNtro i = (IdPathNtro) o;
			
			if(entityPath != null ? !entityPath.equals(i.entityPath) : i.entityPath != null) {
				return false;
			}

			return true;
		}
		
		return false;
	}

	@Override
	public String toString() {
		return getEntityPath().toFilename();
	}

	public Key toKey() {
		return new Key(getEntityPath().toRawPath());
	}

	public String toHtmlId() {
		return toFilepath().toHtmlId();
	}

	public Filepath toFilepath() {
		return Filepath.fromSingleName(getEntityPath().toFilename());
	}
}
