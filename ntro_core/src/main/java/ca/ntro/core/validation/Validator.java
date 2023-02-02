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
package ca.ntro.core.validation;


import ca.ntro.core.exceptions.InvalidCharacterException;
import ca.ntro.core.util.ArrayUtils;

public class Validator {
	
	public static final String[] validKeyCharacters = {
			"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
			"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
			"0","1","2","3","4","5","6","7","8","9",
			".","-","_","@",":","[","]","¤"
			};

	public static void mustNotContainCharacter(String value, String[] invalidCharacters) throws InvalidCharacterException {
		for(String invalidCharacter : invalidCharacters) {
			if(value.contains(invalidCharacter)) {
				throw new InvalidCharacterException(invalidCharacter);
			}
		}
	}

	public static void mustContainOnlyValidCharacters(String id, String[] validCharacters) throws InvalidCharacterException {
		for(int i = 0; i < id.length(); i++) {
			String currentChar = String.valueOf(id.charAt(i));
			if(!ArrayUtils.containsString(validCharacters, currentChar)) {
				throw new InvalidCharacterException(currentChar);
			}
		}
	}

}