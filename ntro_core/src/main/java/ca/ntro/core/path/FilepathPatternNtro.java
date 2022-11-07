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

import ca.ntro.core.util.ArrayUtils;
import ca.ntro.core.validation.Validator;

public class FilepathPatternNtro extends GenericPathNtro<FilepathPattern, FilepathPatternNtro> implements FilepathPattern {

	@Override
	protected FilepathPatternNtro newInstance() {
		return new FilepathPatternNtro();
	}

	@Override
	protected String[] validNameCharacters() {
		String[] validNameCharacters = Validator.validKeyCharacters;

		validNameCharacters = ArrayUtils.addString(validNameCharacters, Path.FILENAME_SEPARATOR);
		validNameCharacters = ArrayUtils.addString(validNameCharacters, PathPattern.NAME_WILDCARD);

		return validNameCharacters;
	}

	@Override
	public FilepathPattern directoryPattern() {
		return parent();
	}

	@Override
	public String filenamePattern() {
		return lastName();
	}
}
