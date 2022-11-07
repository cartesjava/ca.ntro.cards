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


import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.path.Path;
import ca.ntro.core.stream.Stream;
import ca.ntro.core.stream.StreamNtro;
import ca.ntro.core.stream.Visitor;

public abstract class ObjectGraphStructureNtro implements ObjectGraphStructure {

	private ObjectGraphNtro graph;
	private Object startObject;
	private LocalHeap localHeap;

	public ObjectGraphStructureNtro(Object o, ObjectGraphNtro graph) {
		setGraph(graph);
		setStartObject(o);
		localHeap = newLocalHeapInstance(graph);
	}

	public ObjectGraphStructureNtro() {
	}

	public Object getStartObject() {
		return startObject;
	}

	public void setStartObject(Object startObject) {
		this.startObject = startObject;
	}

	public LocalHeap getLocalHeap() {
		return localHeap;
	}

	public void setLocalHeap(LocalHeap localHeap) {
		this.localHeap = localHeap;
	}

	public ObjectGraphNtro getGraph() {
		return graph;
	}

	public void setGraph(ObjectGraphNtro graph) {
		this.graph = graph;
		localHeap = newLocalHeapInstance(graph);
	}

	protected abstract LocalHeap newLocalHeapInstance(ObjectGraphNtro graph);

	@Override
	public Stream<ObjectNode> startNodes() {
		return new StreamNtro<ObjectNode>() {

			@Override
			public void forEach_(Visitor<ObjectNode> visitor) throws Throwable {

				ObjectNode startNode = getLocalHeap().findOrCreateNode(getGraph(), Path.emptyPath(), getStartObject(), true); 

				visitor.visit(startNode);
			}
		};
	}

	@Override
	public String label() {
		return Ntro.reflection().simpleName(getStartObject().getClass());
	}

	public boolean isStartNode(ObjectNode objectNode) {
		return objectNode.object() == startObject;
	}

}
