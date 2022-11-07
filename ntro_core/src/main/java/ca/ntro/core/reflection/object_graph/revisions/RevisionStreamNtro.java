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
package ca.ntro.core.reflection.object_graph.revisions;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.core.stream.Stream;
import ca.ntro.core.stream.StreamNtro;
import ca.ntro.core.stream.Visitor;

public class RevisionStreamNtro 

       extends StreamNtro<Revision> {

	
	private List<Revision> revisions = new ArrayList<>();

	public List<Revision> getRevisions() {
		return revisions;
	}

	public void setRevisions(List<Revision> revisions) {
		this.revisions = revisions;
	}
	
	
	public void add(Revision revision) {
		getRevisions().add(revision);
	}
	
	public void addAll(Stream<Revision> revisions) {
		revisions.forEach(revision -> {
			getRevisions().add(revision);
		});
	}
	




	@Override
	public void forEach_(Visitor<Revision> visitor) throws Throwable {
		for(Revision revision : revisions) {
			visitor.visit(revision);
		}
	}
	

}
