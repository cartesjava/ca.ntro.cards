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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.ntro.core.json.JsonObject;

public abstract class GenericObjectBuilderNtro<O> {

	private ObjectGraphNtro graph;
	private Map<String, Object> localHeap = new HashMap<>();


	public ObjectGraphNtro getGraph() {
		return graph;
	}

	public void setGraph(ObjectGraphNtro graph) {
		this.graph = graph;
	}

	public Map<String, Object> getLocalHeap() {
		return localHeap;
	}

	public void setLocalHeap(Map<String, Object> localHeap) {
		this.localHeap = localHeap;
	}

	public GenericObjectBuilderNtro() {
	}

	public GenericObjectBuilderNtro(ObjectGraphNtro graph) {
		setGraph(graph);
	}
	
	public void initialize() {
	}
	
	public O build() {
		ObjectNode startNode = getGraph().startNodes().findFirst(n -> true);

		return objectFromNode(startNode);
	}
	
	protected O objectFromNode(ObjectNode node) {
		
		String objectId = node.id().toKey().toString();

		if(getLocalHeap().containsKey(objectId)) {
			return (O) newObjectReference(objectId, getLocalHeap().get(objectId));
		}

		O object = emptyObjectFromNode(node);
		getLocalHeap().put(objectId, object);

		
		node.edges().forEach(edge -> {
			
			String attributeName = edge.type().name().toString();
			
			if(!attributeName.equals(JsonObject.REFERENCE_KEY)
					&& !attributeName.equals(JsonObject.TYPE_KEY)) {

				Object attributeValue = valueFromNode(edge.to());
				setAttribute(object, attributeName, attributeValue);
			}
		});

		if(object instanceof Initialize) {
			((Initialize) object).initialiser();
		}
		
		return object;
	}

	protected Object valueFromNode(ObjectNode node) {
		String objectId = node.id().toKey().toString();
		if(getLocalHeap().containsKey(objectId)) {
			return newObjectReference(objectId, getLocalHeap().get(objectId));
		}
		
		if(isReferenceNode(node)) {
			return valueFromNode(getReferencedNode(node));
		}
		
		Object value = null;
		
		if(node.isUserDefinedObject()) {

			value = objectFromNode(node);
			
		} else if(node.isList()){
			
			value = buildList(node);

		}else if(node.isMap()) {

			value = buildMap(node);
			
		}else {

			value = node.object();

		}

		getLocalHeap().put(node.id().toKey().toString(), value);
		
		return value;
	}

	protected boolean isReferenceNode(ObjectNode node) {
		boolean isReferenceNode = false;
		
		if(node.isMap()
				&& node.asMap().containsKey(JsonObject.REFERENCE_KEY)) {
			
			isReferenceNode = true;
		}
		
		return isReferenceNode;
	}

	protected ObjectNode getReferencedNode(ObjectNode objectReferenceNode) {

		String referencedObjectId = (String) objectReferenceNode.asMap().get(JsonObject.REFERENCE_KEY);
		
		ObjectNode referencedNode = getGraph().findNode(referencedObjectId);

		return referencedNode;
	}
	
	
	protected abstract Object newObjectReference(String referencedObjetId, Object referencedObject);

	private List<Object> buildList(ObjectNode listNode){
		List<Object> list = new ArrayList<>();

		String listId = listNode.id().toKey().toString();
		getLocalHeap().put(listId, list);

		listNode.edges().forEach(edge -> {
			
			String indexName = edge.type().name().toString();
			int index = Integer.valueOf(indexName);
			Object item = valueFromNode(edge.to());
			
			list.add(index, item);
		});
		
		return list;
	}

	private Map<String,Object> buildMap(ObjectNode mapNode){
		Map<String,Object> map = new HashMap<>();

		String mapId = mapNode.id().toKey().toString();
		getLocalHeap().put(mapId, map);
		
		mapNode.edges().forEach(edge -> {
			
			String key = edge.type().name().toString();
			Object value = valueFromNode(edge.to());
			
			map.put(key, value);
		});
		
		return map;
	}
	

	protected abstract O emptyObjectFromNode(ObjectNode node);
	protected abstract void setAttribute(O object, String attributeName, Object attributeValue);


}
