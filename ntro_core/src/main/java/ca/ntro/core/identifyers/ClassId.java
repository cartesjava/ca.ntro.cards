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

import ca.ntro.core.path.Path;

public class ClassId<O extends Object> extends IdPathNtro {
	
	private Class<O> _class;
	
	protected ClassId(Class<O> _class) {
		super();

		this._class = _class;
	}

	public Class<O> _class(){
		return _class;
	}

	public static <O extends Object> ClassId<O> fromClass(Class<O> _class){
		ClassId<O> classId = new ClassId<O>(_class);
		
		classId.setEntityPath(Path.fromClassname(_class.getName()));

		return classId;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
		if(o == this) return true;
		if(o instanceof ClassId) {
			ClassId<?> c = (ClassId<?>) o;
			
			if(_class != null ? !_class.equals(c._class) : c._class != null) {
				return false;
			}

			return super.equals(c);
		}

		return false;
	}
}
