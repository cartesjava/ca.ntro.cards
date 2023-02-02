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

import java.util.HashMap;
import java.util.Map;

import ca.ntro.core.path.Path;

public class ObjectId<O extends Object> extends StorageId {
	
	private static final Map<Class<?>, Long> nextObjectIds = new HashMap<>();
	private static long nextObjectId(Class<?> _class) {
		Long nextObjectId = nextObjectIds.get(_class);
		
		if(nextObjectId == null) {

			nextObjectId = 1L;
			nextObjectIds.put(_class, 2L);

		}else {
			
			nextObjectIds.put(_class, nextObjectId + 1);
		}
		
		return nextObjectId;
	}

	public static final String CATEGORY = "objects";
	
	private Class<O> _class;
	private long objectId;
	
	protected ObjectId(Class<O> _class) {
		super();

		this._class = _class;
		
		this.objectId = nextObjectId(_class);
	}
	

	public Class<O> _class(){
		return _class;
	}

	public long objectId(){
		return objectId;
	}

	public String objectName(){
		StringBuilder builder = new StringBuilder();
		
		builder.append(_class.getSimpleName());
		builder.append("@");
		builder.append(objectId);
		
		return builder.toString();
	}
	

	@SuppressWarnings("unchecked")
	public static <O extends Object> ObjectId<O> fromObject(O object, String id){
		ObjectId<O> objectId = new ObjectId<O>((Class<O>) object.getClass());
		
		Path categoryPath = Path.fromRawPath(CATEGORY);
		categoryPath.append(Path.fromClassname(objectId._class().getName()));

		objectId.setCategoryPath(categoryPath);
		objectId.setEntityPath(Path.fromRawPath(id));

		return objectId;
	}
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
		if(o == this) return true;
		if(o instanceof ObjectId) {
			ObjectId c = (ObjectId) o;
			
			if(_class != null ? !_class.equals(c._class) : c._class != null) {
				return false;
			}

			return super.equals(c);
		}

		return false;
	}
}
