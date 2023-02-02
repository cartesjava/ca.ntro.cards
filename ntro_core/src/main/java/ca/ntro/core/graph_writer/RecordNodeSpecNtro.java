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


import ca.ntro.core.graphs.generics.graph.GenericNode;

public class RecordNodeSpecNtro 
 
       extends NodeSpecNtro 
       
       implements RecordNodeSpec {
	

	private RecordSpecNtro record = new RecordSpecNtro();

	public RecordSpecNtro getRecord() {
		return record;
	}

	public void setRecord(RecordSpecNtro record) {
		this.record = record;
	}

	public RecordNodeSpecNtro() {
		super();
	}

	public RecordNodeSpecNtro(GenericNode<?, ?, ?> node) {
		super(node);
	}

	@Override
	public RecordSpec record() {
		return getRecord();
	}

	@Override
	public String shape() {
		return "record";
	}

	@Override
	public String label() {
		return labelFromRecordSpec(getRecord());
	}

	private String labelFromRecordSpec(RecordSpec recordSpec) {
		StringBuilder builder = new StringBuilder();

		recordSpec.items().forEach(item -> {
			if(builder.length() > 0) {
				builder.append("|");
			}

			if(item.isRecord()) {
				builder.append('{');
				builder.append(labelFromRecordSpec(item.asRecord()));
				builder.append('}');

			}else {
				if(item.hasPort()) {
					builder.append('<');
					builder.append(item.port());
					builder.append('>');
				}
				
				if(item.hasValue()) {
					builder.append(item.value());
				}
			}
		});

		return builder.toString();
	}
}
