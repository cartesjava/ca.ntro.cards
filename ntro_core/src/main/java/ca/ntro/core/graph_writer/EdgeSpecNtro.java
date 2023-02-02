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

import ca.ntro.core.graphs.generics.graph.GenericEdge;
import ca.ntro.core.path.Path;

public class EdgeSpecNtro implements EdgeSpec {

	private NodeSpec fromSpec;
	private String fromPort;

	private GenericEdge<?,?,?> edge;

	private NodeSpec toSpec;
	private String toPort;

	public NodeSpec getFromSpec() {
		return fromSpec;
	}

	public void setFromSpec(NodeSpec fromSpec) {
		this.fromSpec = fromSpec;
	}

	public NodeSpec getToSpec() {
		return toSpec;
	}

	public void setToSpec(NodeSpec toSpec) {
		this.toSpec = toSpec;
	}

	public GenericEdge<?,?,?> getEdge() {
		return edge;
	}

	public void setEdge(GenericEdge<?,?,?> edge) {
		this.edge = edge;
	}

	public String getFromPort() {
		return fromPort;
	}

	public void setFromPort(String fromPort) {
		this.fromPort = fromPort;
	}

	public String getToPort() {
		return toPort;
	}

	public void setToPort(String toPort) {
		this.toPort = toPort;
	}

	public EdgeSpecNtro() {

	}

	public EdgeSpecNtro(NodeSpec fromSpec, GenericEdge<?,?,?> edge, NodeSpec toSpec) {
		setFromSpec(fromSpec);
		setEdge(edge);
		setToSpec(toSpec);
	}

	public EdgeSpecNtro(NodeSpec fromSpec, 
			            String fromPort, 
			            GenericEdge<?,?,?> edge, 
			            NodeSpec toSpec,
			            String toPort) {
		setFromSpec(fromSpec);
		setFromPort(fromPort);

		setEdge(edge);

		setToSpec(toSpec);
		setToPort(toPort);
	}

	@Override
	public String id() {
		Path path = Path.fromSingleName(getFromSpec().id());
		path.addName(edge.type().name().toString());
		path.addName(getToSpec().id());

		return path.toKey();
	}

	@Override
	public String label() {
		return edge.type().label();
	}

	@Override
	public NodeSpec from() {
		return getFromSpec();
	}

	@Override
	public boolean hasFromPort() {
		return getFromPort() != null;
	}

	@Override
	public String fromPort() {
		return getFromPort();
	}

	@Override
	public NodeSpec to() {
		return getToSpec();
	}

	@Override
	public boolean hasToPort() {
		return getToPort() != null;
	}

	@Override
	public String toPort() {
		return getToPort();
	}
}
