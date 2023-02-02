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
package ca.ntro.core.task_graphs.generic_task_graph;

import ca.ntro.core.graph_writer.NodeSpecNtro;
import ca.ntro.core.graphs.hierarchical_dag.HierarchicalDagWriterOptions;
import ca.ntro.core.graphs.hierarchical_dag.InternalHierarchicalDagWriterNtro;

public class InternalTaskGraphWriterNtro<T  extends GenericTask<T,ST,ET,TG,G>,
                                          ST extends GenericSimpleTask<T,ST,ET,TG,G>,
                                          ET extends GenericExecutableTask<T,ST,ET,TG,G>,
                                          TG extends GenericTaskGroup<T,ST,ET,TG,G>,
                                          G  extends GenericTaskGraph<T,ST,ET,TG,G>> 

       extends InternalHierarchicalDagWriterNtro<GenericTaskGraphNode<T,ST,ET,TG,G>,
	                                             GenericTaskGraphEdge<T,ST,ET,TG,G>> 

       implements InternalTaskGraphWriter<T,ST,ET,TG,G> {

	@Override
	protected void adjustNodeSpecAttributes(GenericTaskGraphNode<T,ST,ET,TG,G> node, 
			                                HierarchicalDagWriterOptions options,
			                                NodeSpecNtro nodeSpec) {

		super.adjustNodeSpecAttributes(node, options, nodeSpec);
		
		
		if(node.task().isTaskGroup()) {

			nodeSpec.setColor("gray");

		}else {

			nodeSpec.setColor("white");

		}

		nodeSpec.setLabel(node.task().id());

	}

}
