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

import ca.ntro.core.graphs.hierarchical_dag.HierarchicalDagWriterOptionsNtro;

public class GenericTaskGraphWriterOptionsNtro<T  extends GenericTask<T,ST,ET,TG,G>,
                                                ST extends GenericSimpleTask<T,ST,ET,TG,G>,
                                                ET extends GenericExecutableTask<T,ST,ET,TG,G>,
                                                TG extends GenericTaskGroup<T,ST,ET,TG,G>,
                                                G  extends GenericTaskGraph<T,ST,ET,TG,G>> 

       extends   HierarchicalDagWriterOptionsNtro
       
       implements GenericTaskGraphWriterOptions<T,ST,ET,TG,G> {

	@Override
	public TG rootTaskGroup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int maxDepth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String overlap() {
		return "false";
	}


}
