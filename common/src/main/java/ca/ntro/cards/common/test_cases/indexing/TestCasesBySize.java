/*
Copyright (C) (2022) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)

This file is part of "Cartes Java", teaching tools made for https://cartesjava.github.io/

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

*/
package ca.ntro.cards.common.test_cases.indexing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.ntro.app.models.Value;
import ca.ntro.cards.common.models.CommonExecutableModel;
import ca.ntro.cards.common.test_cases.descriptor.AbstractTestCaseDescriptor;
import ca.ntro.core.stream.Stream;
import ca.ntro.core.stream.StreamNtro;
import ca.ntro.core.stream.Visitor;

public class     TestCasesBySize<STUDENT_MODEL extends CommonExecutableModel, 
                                 TEST_CASE     extends AbstractTestCaseDescriptor> 

       implements Value, Serializable {
	
	
	private Map<String, TestCaseById<STUDENT_MODEL, TEST_CASE>> bySize = new HashMap<>();

	public Map<String, TestCaseById<STUDENT_MODEL, TEST_CASE>> getBySize() {
		return bySize;
	}

	public void setBySize(Map<String, TestCaseById<STUDENT_MODEL, TEST_CASE>> bySize) {
		this.bySize = bySize;
	}

	public void addTestCase(TEST_CASE testCase) {
		String sizeKey = String.valueOf(testCase.inputSize());
		
		TestCaseById<STUDENT_MODEL, TEST_CASE> byId = bySize.get(sizeKey);
		
		if(byId == null) {
			byId = new TestCaseById<>();
			bySize.put(sizeKey, byId);
		}

		byId.addTestCase(testCase);
	}
	
	public Stream<TEST_CASE> inOrder(){
		return new StreamNtro<>() {

			@Override
			public void forEach_(Visitor<TEST_CASE> visitor) throws Throwable {
				List<String> sizes = new ArrayList<>(bySize.keySet());
				
				sizes.sort((s1,s2) -> Integer.valueOf(s1).compareTo(Integer.valueOf(s2)));
				
				for(String size : sizes) {
					
					bySize.get(size).inOrder().forEach(testCase -> {
						
						visitor.visit(testCase);

					});
				}
			}
		};
	}
}
