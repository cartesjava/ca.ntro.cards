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


public abstract class RevisionNtro 

       extends        RevisionStreamNtro

       implements Revision, Revisions {
	
	private String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RevisionNtro() {

	}

	public RevisionNtro(String name) {
		setName(name);
	}
	
	
	@Override
	public Update asUpdate() {
		return (Update) this;
	}

	@Override
	public Delete asDelete() {
		return (Delete) this;
	}

	@Override
	public Insert asInsert() {
		return (Insert) this;
	}

	@Override
	public Clear asClear() {
		return (Clear) this;
	}


	public abstract String revisionType();
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(revisionType());
		builder.append("(\"");
		builder.append(name());
		builder.append("\")");
		
		return builder.toString();
	}
	
	
	@Override
	public Revisions subRevisions() {
		return this;
	}

	@Override
	public String name() {
		return getName();
	}

	@Override
	public boolean targets(String name) {
		return getName().equals(name);
	}
	
	

}
