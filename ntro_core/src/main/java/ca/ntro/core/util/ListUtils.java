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

public class ListUtils {

	public static List<Object> fromString(String input){
		List<Object> result = new ArrayList<>();
		
		for(int i = 0; i < input.length(); i++) {
			result.add(input.charAt(i));
		}

		return result;
	}

	public static List<Object> fromArray(Object[] array){
		List<Object> result = new ArrayList<>();
		
		for(int i = 0; i < array.length; i++) {
			result.add(array[i]);
		}

		return result;
	}
	
	public static <V extends Object> List<V> subList(List<V> list, int beginIndex, int endIndexExclusive){
		List<V> result = new ArrayList<>();
		
		for(int i = beginIndex; i < endIndexExclusive; i++) {
			result.add(list.get(i));
		}
		
		return result;
	}

	public static <V extends Object> List<V> subList(List<V> list, int beginIndex){
		return subList(list, beginIndex, list.size());
	}

	public static boolean ifIndexValid(List<Object> list, int index) {
		return index >= list.size() && index < list.size();
	}

}
