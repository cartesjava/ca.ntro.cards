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
import ca.ntro.core.graphs.generics.hierarchical_graph.GenericHierarchicalNode;

public class NodeSpecNtro implements NodeSpec {
	
	private GenericNode<?,?,?> node;
	private String color;
	private String shape;
	private String label;
	private String margin;

	public GenericNode<?,?,?> getNode() {
		return node;
	}

	public void setNode(GenericNode<?,?,?> node) {
		this.node = node;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getMargin() {
		return margin;
	}

	public void setMargin(String margin) {
		this.margin = margin;
	}
	
	

	public NodeSpecNtro() {
	}

	public NodeSpecNtro(GenericNode<?,?,?> node) {
		setNode(node);
	}



	@Override
	public String id() {
		return node.id().toKey().toString();
	}

	@Override
	public String label() {
		String label = null;

		if(getLabel() == null) {
			
			label = node.label();
			
		}else {
			
			label = getLabel();
		}

		return label;
	}

	@Override
	public String color() {
		return getColor();
	}

	@Override
	public String shape() {
		return getShape();
	}

	@Override
	public boolean isCluster() {
		boolean isCluster = false;
		
		if(getNode() instanceof GenericHierarchicalNode<?,?,?>) {
			isCluster = ((GenericHierarchicalNode<?,?,?>) getNode()).hasSubNodes();
		}

		return isCluster;
	}

	@Override
	public String margin() {
		return getMargin();
	}
}
