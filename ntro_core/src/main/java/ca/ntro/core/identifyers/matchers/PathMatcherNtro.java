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
package ca.ntro.core.identifyers.matchers;

import ca.ntro.core.path.Path;
import ca.ntro.core.path.PathPattern;

public class PathMatcherNtro implements PathMatcher {
	
	private PathPattern pattern;

	public PathMatcherNtro(String rawPattern) {
		this.pattern = PathPattern.fromRawPattern(rawPattern);
	}
	
	public PathMatcherNtro(PathPattern pattern) {
		this.pattern = pattern;
	}

	@Override
	public boolean matches(Path path) {
		return matches(path, pattern);
	}

	private boolean matches(Path path, PathPattern pattern) {
		if(pattern.isRootPath()) {
			return true;
		}
		
		if(path.isRootPath()) {
			return false;
		}
		
		if(lastNameMatches(path, pattern)) {
			PathPattern nextPattern = pattern.subPath(0, pattern.nameCount()-1);
			Path nextPath = path.subPath(0, path.nameCount()-1);
			
			return matches(nextPath, nextPattern);
		}
		
		if(pattern.lastName().equals(PathPattern.SUBPATH_WILDCARD)) {
			PathPattern nextPattern = pattern.subPath(0, pattern.nameCount()-1);
			
			if(matches(path, nextPattern)) {

				return true;

			}else {

				Path nextPath = path.subPath(0, path.nameCount()-1);

				return matches(nextPath, pattern);
			}
		}

		return false;
	}

	private boolean lastNameMatches(Path path, PathPattern pattern) {
		if(pattern.lastName().equals(path.lastName())) {
			return true;
		}
		
		if(pattern.lastName().equals(PathPattern.NAME_WILDCARD)
				&& path.nameCount() > 0) {
			return true;
		}
		
		return false;
	}
}
