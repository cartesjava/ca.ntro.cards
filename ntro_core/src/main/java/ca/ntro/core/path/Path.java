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
package ca.ntro.core.path;

public interface Path extends GenericPath<Path> {
	
    public static final String FILENAME_SEPARATOR = "¤";
    public static final String PATH_SEPARATOR = "/";
    public static final String HTML_ID_SEPARATOR = "-";
    public static final String CLASSNAME_SEPARATOR = ".";

	public static Path emptyPath() {
    	return new PathNtro();
	}

	public static Path rootPath() {
    	return new PathNtro();
	}

    public static Path fromRawPath(String rawPath) {
    	PathNtro path = new PathNtro();
    	
    	path.fromRawPath(rawPath);
    	
    	return path;
    }

	public static Path fromClassname(String rawClassname) {
    	PathNtro path = new PathNtro();
    	
    	path.fromClassname(rawClassname);
    	
    	return path;
	}

	public static Path fromKey(String rawKey) {
    	PathNtro path = new PathNtro();
    	
    	path.fromKey(rawKey);
    	
    	return path;
	}

	public static Path fromFilename(String rawFilename) {
    	PathNtro path = new PathNtro();
    	
    	path.fromFilename(rawFilename);
    	
    	return path;
	}

	public static Path fromSingleName(String id) {
    	PathNtro path = new PathNtro();
    	
    	path.fromSingleName(id);
    	
    	return path;
	}

	public static Path fromPath(GenericPath<?> otherPath) {
		PathNtro path = new PathNtro();
		
		path.fromGenericPath(otherPath);
		
		return path;
	}

}
