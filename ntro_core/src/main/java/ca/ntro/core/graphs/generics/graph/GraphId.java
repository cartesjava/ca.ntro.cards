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
package ca.ntro.core.graphs.generics.graph;

import ca.ntro.core.identifyers.StorageId;
import ca.ntro.core.path.Path;

public class GraphId extends StorageId {
	
	public static final String CATEGORY = "graphs";
	
	private static int nextGraphNumber = 0;
	
	public static GraphId fromGraphName(String graphName) {

		GraphId id = new GraphId();

		try {

			int graphNumber = Integer.parseInt(graphName);
			if(graphNumber < nextGraphNumber) {
				graphName = formatGraphNumber(++nextGraphNumber);
			}

		}catch(NumberFormatException e) {}
		
		id.setCategoryPath(Path.fromRawPath(CATEGORY));
		id.setEntityPath(Path.fromRawPath(graphName));

		return id;
	}
	
	private static String formatGraphNumber(int graphNumber) {
		StringBuilder builder = new StringBuilder();

		if(graphNumber < 10) {
			builder.append(0);
		}

		builder.append(graphNumber);
		
		return builder.toString();
	}

	public static GraphId newGraphId() {
		return fromGraphName(formatGraphNumber(++nextGraphNumber));
	}
}
