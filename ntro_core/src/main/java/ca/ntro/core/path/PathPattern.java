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

public interface PathPattern extends GenericPath<PathPattern> {

	public static final String NAME_WILDCARD = "*";
	public static final String SUBPATH_WILDCARD = "**";

	public static PathPattern fromPathPattern(GenericPath<?> otherPath) {
		PathPatternNtro pathPattern = new PathPatternNtro();

		pathPattern.fromGenericPath(otherPath);

		return pathPattern;
	}

	public static PathPattern fromFilenamePattern(String rawFilename) {
		PathPatternNtro pathPattern = new PathPatternNtro();
		
		pathPattern.fromFilename(rawFilename);

		return pathPattern;
	}

	public static PathPattern fromRawPattern(String rawPattern) {
		PathPatternNtro pathPattern = new PathPatternNtro();
		
		pathPattern.fromRawPath(rawPattern);

		return pathPattern;
	}

	public static PathPattern newInstance() {
		return new PathPatternNtro();
	}

}
