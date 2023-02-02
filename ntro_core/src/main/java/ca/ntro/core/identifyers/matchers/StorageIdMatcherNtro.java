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

import ca.ntro.core.exceptions.InvalidCharacterException;
import ca.ntro.core.identifyers.StorageId;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.path.Filepath;
import ca.ntro.core.path.FilepathPattern;
import ca.ntro.core.path.Path;
import ca.ntro.core.path.PathPattern;
import ca.ntro.core.wrappers.exception_catcher.ExceptionCatcher;
import ca.ntro.core.wrappers.result.Result;

public class StorageIdMatcherNtro implements StorageIdMatcher {

	private PathMatcher entityPathMatcher;
	private PathMatcher categoryPathMatcher;
	
	public StorageIdMatcherNtro(String rawPattern) {
		FilepathPattern filepathPattern = FilepathPattern.fromRawPattern(rawPattern);
		
		PathPattern categoryPathPattern = extractCategoryPathPattern(filepathPattern);

		PathPattern entityPath = PathPattern.fromFilenamePattern(filepathPattern.filenamePattern());
		
		this.entityPathMatcher = new PathMatcherNtro(entityPath);
		this.categoryPathMatcher = new PathMatcherNtro(categoryPathPattern);
	}

	private PathPattern extractCategoryPathPattern(FilepathPattern filepathPattern) {
		PathPattern categoryPath = null;

		Result<PathPattern> categoryPathResult = ExceptionCatcher.executeBlocking(() -> {
			return PathPattern.fromPathPattern(filepathPattern.directoryPattern());
		});
		
		if(categoryPathResult.hasException()) {
			
			if(categoryPathResult.exception() instanceof InvalidCharacterException) {

				InvalidCharacterException e = (InvalidCharacterException) categoryPathResult.exception();
				Ntro.exceptionService().throwException(new RuntimeException("rawPattern must not contain character " + e.invalidCharacter()));
				
			}else {

				Ntro.exceptionService().throwException(categoryPathResult.exception());

			}
			
			categoryPath = PathPattern.newInstance();

		}else {
			
			categoryPath = categoryPathResult.value();
		}

		return categoryPath;
	}

	public StorageIdMatcherNtro(PathMatcher entityPathMatcher, PathMatcher categoryPathMatcher) {
		this.entityPathMatcher = entityPathMatcher;
		this.categoryPathMatcher = categoryPathMatcher;
	}

	@Override
	public boolean matches(StorageId id) {

		Filepath filepath = id.toFilepath();
		Path categoryPath = Path.fromPath(filepath.directory());
		Path entityPath = Path.fromFilename(filepath.filename());
		
		return entityPathMatcher.matches(entityPath) 
				&& categoryPathMatcher.matches(categoryPath);
	}
}
