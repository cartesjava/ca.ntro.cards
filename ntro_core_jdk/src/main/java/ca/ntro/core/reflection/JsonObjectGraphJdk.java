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

import ca.ntro.core.json.JsonObjectGraphNtro;
import ca.ntro.core.reflection.object_graph.ObjectBuilderNtro;
import ca.ntro.core.reflection.object_graph.ObjectGraphNtro;
import ca.ntro.core.reflection.object_graph.ObjectNode;

public class JsonObjectGraphJdk extends JsonObjectGraphNtro {

	public JsonObjectGraphJdk(Object o) {
		super(o);
	}

	public JsonObjectGraphJdk(Object o, String graphName) {
		super(o, graphName);
	}

	@Override
	protected ObjectBuilderNtro newObjectBuilder(ObjectGraphNtro graph) {
		return new ObjectBuilderJdk(graph);
	}



}
