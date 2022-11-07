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
package ca.ntro.core.graph_writer;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.core.stream.Stream;
import ca.ntro.core.stream.StreamNtro;
import ca.ntro.core.stream.Visitor;

public class      RecordSpecNtro 

       extends    RecordItemSpecNtro

       implements RecordSpec {

	private List<RecordItemSpec> items = new ArrayList<>();


	public List<RecordItemSpec> getItems() {
		return items;
	}

	public void setItems(List<RecordItemSpec> items) {
		this.items = items;
	}

	public void addItem(RecordItemSpec item) {
		getItems().add(item);
	}
	
	
	
	public RecordSpecNtro() {
		super();
	}

	public RecordSpecNtro(RecordSpecNtro parent) {
		super(parent);
	}
	

	@Override
	public boolean isRecord() {
		return true;
	}
	
	@Override
	public Stream<RecordItemSpec> items() {
		return new StreamNtro<RecordItemSpec>() {
			@Override
			public void forEach_(Visitor<RecordItemSpec> visitor) throws Throwable {
				for(RecordItemSpec item : getItems()) {
					visitor.visit(item);
				}
			}
		};
	}

	public RecordSpecNtro addSubRecord() {
		RecordSpecNtro subRecord = new RecordSpecNtro(this);
		
		getItems().add(subRecord);
		
		return subRecord;
	}

	public RecordItemSpecNtro addItem() {
		RecordItemSpecNtro newItem = new RecordItemSpecNtro(this);
		
		getItems().add(newItem);
		
		return newItem;
	}
}
