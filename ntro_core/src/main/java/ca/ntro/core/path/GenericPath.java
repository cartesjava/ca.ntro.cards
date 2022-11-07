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

import ca.ntro.core.json.JsonSerializable;

public interface GenericPath<I extends GenericPath<I>> extends JsonSerializable {

	void addName(String name);
	int nameCount();
	String name(int index);

	void append(I otherPath);
	boolean isPrefixOf(I otherPath);
	boolean startsWith(I path);
	boolean startsWith(String rawPath);
	boolean isRootPath();
	String lastName();

	I clone();
	I subPath(int beginIndex);
	I subPath(int beginIndex, int endIndexExclusive);
	I parent();

	String toRawPath();
	String toHtmlId();
	String toFilename();
	String toKey();
	I removePrefix(String rawPrefix);
	I removePrefix(I prefix);
	String toClassname();

}
