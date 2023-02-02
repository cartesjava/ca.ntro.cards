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
package ca.ntro.core.util;

import java.util.ArrayList;
import java.util.List;

public class Splitter {

	public static List<String> split(String value, String separator) {
		List<String> segments = new ArrayList<>();
		
		StringBuilder input = new StringBuilder(value);
		StringBuilder buffer = new StringBuilder();
		
		while(input.length() > 0) {
			boolean separatorFound = true;
			for(int i = 0; i < separator.length(); i++) {
				if(input.charAt(i) != separator.charAt(i)) {
					separatorFound = false;
					break;
				}
			}
			
			if(separatorFound) {
				segments.add(buffer.toString());
				input.delete(0, separator.length());
				buffer.delete(0, buffer.length());
				
				if(input.length() == 0) {
					segments.add("");
				}

			}else {
				buffer.append(input.charAt(0));
				input.deleteCharAt(0);
			}
		}

		if(buffer.length() > 0) {
			segments.add(buffer.toString());
		}

		return segments;
	}

}
