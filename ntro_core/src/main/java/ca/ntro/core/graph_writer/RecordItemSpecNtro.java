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

public class RecordItemSpecNtro implements RecordItemSpec {
	
	private String portName;
	private String value;
	private RecordSpecNtro parent;
	

	public String getPortName() {
		return portName;
	}

	public void setPortName(String portName) {
		this.portName = portName;
	}

	public RecordSpecNtro getParent() {
		return parent;
	}

	public void setParent(RecordSpecNtro parent) {
		this.parent = parent;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
	

	public RecordItemSpecNtro() {
	}
	
	public RecordItemSpecNtro(RecordSpecNtro parent) {
		setParent(parent);
	}
	
	
	



	public boolean hasParent() {
		return getParent() != null;
	}
	
	public RecordSpecNtro parent() {
		return getParent();
	}

	@Override
	public boolean hasPort() {
		return getPortName() != null;
	}

	@Override
	public String port() {
		String port;
		
		if(hasParent()
				&& parent().hasPort()) {

			port = parent().port() + "_" + getPortName();

		}else {
			
			port = getPortName();
			
		}
		
		return port;
	}

	@Override
	public boolean hasValue() {
		return getValue() != null;
	}

	@Override
	public String value() {
		return getValue();
	}

	@Override
	public boolean isRecord() {
		return false;
	}

	@Override
	public RecordSpec asRecord() {
		return (RecordSpec) this;
	}
}
