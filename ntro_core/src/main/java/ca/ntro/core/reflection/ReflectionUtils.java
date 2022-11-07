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
package ca.ntro.core.reflection;

public class ReflectionUtils {

	public static boolean isUserDefinedMethod(Object object, String methodName) {
		boolean isUserDefined = true;
		
		if(methodName.equals("getClass")) {

			isUserDefined = false;
			
		} else if(object instanceof String && 
				(methodName.equals("getChars")
						|| methodName.equals("getBytes"))) {
			
			isUserDefined = false;
		}

		return isUserDefined;
	}

	public static boolean isGetterName(String methodName) {
		return methodName.startsWith("get")
				&& methodName.length() > 3;
	}


	public static String attributeNameFromGetterName(String methodName) {

		String rawAttributeName = methodName.substring(3);
		String attributeName = rawAttributeName.substring(0,1).toLowerCase();
		attributeName += rawAttributeName.substring(1);
		
		return attributeName;
	}

	public static String getterNameFromAttributeName(String attributeName) {
		return accessorNameFromAttributeName("get", attributeName);
	}

	public static String setterNameFromAttributeName(String attributeName) {
		return accessorNameFromAttributeName("set", attributeName);
	}

	public static String accessorNameFromAttributeName(String accessor, String attributeName) {
		
		String accessorName = accessor;
		
		accessorName += attributeName.substring(0,1).toUpperCase();
		accessorName += attributeName.substring(1);
		
		return accessorName;
	}
}
