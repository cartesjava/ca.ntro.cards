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
import ca.ntro.cards.common.models.CommonCanvasModel;
import ca.ntro.cards.common.models.CommonExecutableModel;
import ca.ntro.cards.common.test_cases.CommonTestCase;
import ca.ntro.cards.common.test_cases.descriptor.AbstractTestCaseDescriptor;
import ca.ntro.core.stream.Stream;
import ca.ntro.core.stream.StreamNtro;
import ca.ntro.core.stream.Visitor;

public class TestCasesByCategory<STUDENT_MODEL extends CommonExecutableModel, 
                                 TEST_CASE     extends AbstractTestCaseDescriptor> 


       implements Value, Serializable {
	
	private Map<String, TestCasesBySize<STUDENT_MODEL, TEST_CASE>> byCategory = new HashMap<>();

	public Map<String, TestCasesBySize<STUDENT_MODEL, TEST_CASE>> getByCategory() {
		return byCategory;
	}

	public void setByCategory(Map<String, TestCasesBySize<STUDENT_MODEL, TEST_CASE>> byCategory) {
		this.byCategory = byCategory;
	}

	public void addTestCase(TEST_CASE testCase) {
		TestCasesBySize<STUDENT_MODEL, TEST_CASE> bySize = byCategory.get(testCase.category());

		if(bySize == null) {
			bySize = new TestCasesBySize<>();
			byCategory.put(testCase.category(), bySize);
		}
		
		bySize.addTestCase(testCase);
	}
	
	
	public Stream<TEST_CASE> inOrder(){
		return new StreamNtro<>(){
			@Override
			public void forEach_(Visitor<TEST_CASE> visitor) throws Throwable {
				List<String> categories = new ArrayList<>(byCategory.keySet());

				categories.sort((c1,c2) -> c1.compareTo(c2));
				
				for(String category : categories) {
					
					byCategory.get(category).inOrder().forEach(testCase -> {

						visitor.visit(testCase);
						
					});
				}
			}
		};
	}

	public int numberOfCategories() {
		return byCategory.size();
	}
	
	

}
