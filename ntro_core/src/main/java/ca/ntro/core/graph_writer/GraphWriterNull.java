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

import ca.ntro.core.graphs.generics.graph.GraphId;
import ca.ntro.core.graphs.generics.graph.GraphWriterOptions;

public class GraphWriterNull implements GraphWriter {

	@Override
	public void initialize(GraphId id, GraphWriterOptions options) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNode(NodeSpec nodeSpec) throws GraphWriterException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCluster(NodeSpec clusterSpec) throws GraphWriterException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSubCluster(NodeSpec clusterSpec, NodeSpec subClusterSpec) throws GraphWriterException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSubNode(NodeSpec clusterSpec, NodeSpec subNodeSpec) throws GraphWriterException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEdge(EdgeSpec edgeSpec) throws GraphWriterException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writePng() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeSvg() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeDot() {
		// TODO Auto-generated method stub
		
	}

}
