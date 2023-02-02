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

import java.util.List;
import java.util.Map;

import ca.ntro.core.graphs.generics.directed_graph.GenericDirectedNode;

public interface ObjectNode 

       extends   GenericDirectedNode<ObjectNode, 
                                     ReferenceEdge,
                                     ObjectGraphSearchOptions> ,

                 GenericObjectNode {

	boolean isNull();
	boolean isList();
	boolean isMap();
	boolean isUserDefinedObject();
	boolean isSimpleValue();
	
	ObjectNodeSimpleValue asSimpleValue();

	List<Object>       asList();
	<I> List<I>        asList(Class<I> itemClass);

	Map<String,Object> asMap();
	<V> Map<String,V>  asMap(Class<V> valueClass);

	Object             asUserDefinedObject();
	<V> V              asUserDefinedObject(Class<V> _class);
	
	

}

