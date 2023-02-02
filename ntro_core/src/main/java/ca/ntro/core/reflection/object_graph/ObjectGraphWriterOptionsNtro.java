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
package ca.ntro.core.reflection.object_graph;

import ca.ntro.core.graphs.generics.directed_graph.DirectedGraphWriterOptionsNtro;

public class      ObjectGraphWriterOptionsNtro 

       extends    DirectedGraphWriterOptionsNtro 
       
       implements ObjectGraphWriterOptions {
	
	/*
	private boolean objectAsStructure = true;
	private boolean stringAsSimpleValue = true;
	private boolean mapAsSimpleValue = true;
	private boolean listAsSimpleValue = true;
	*/

	private boolean objectAsStructure = true;
	private boolean stringAsSimpleValue = true;
	private boolean mapAsSimpleValue = false;
	private boolean listAsSimpleValue = false;

	public boolean getObjectAsStructure() {
		return objectAsStructure;
	}

	public void setObjectAsStructure(boolean objectAsStructure) {
		this.objectAsStructure = objectAsStructure;
		
		setStringAsSimpleValue(true);
		setListAsSimpleValue(true);
		setMapAsSimpleValue(true);
	}

	public boolean getStringAsSimpleValue() {
		return stringAsSimpleValue;
	}

	public void setStringAsSimpleValue(boolean stringAsSimpleValue) {
		this.stringAsSimpleValue = stringAsSimpleValue;
	}

	public boolean getMapAsSimpleValue() {
		return mapAsSimpleValue;
	}

	public void setMapAsSimpleValue(boolean mapAsSimpleValue) {
		this.mapAsSimpleValue = mapAsSimpleValue;
	}

	public boolean getListAsSimpleValue() {
		return listAsSimpleValue;
	}

	public void setListAsSimpleValue(boolean listAsSimpleValue) {
		this.listAsSimpleValue = listAsSimpleValue;
	}

	@Override
	public boolean objectAsStructure() {
		return getObjectAsStructure();
	}

	@Override
	public boolean stringAsSimpleValue() {
		return getStringAsSimpleValue();
	}

	@Override
	public boolean mapAsSimpleValue() {
		return getMapAsSimpleValue();
	}

	@Override
	public boolean listAsSimpleValue() {
		return getListAsSimpleValue();
	}

	@Override
	public Double ranksep() {
		return 1.0;
	}

	@Override
	public Double nodesep() {
		return 1.0;
	}

}
