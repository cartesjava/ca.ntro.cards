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
package ca.ntro.core.data_structures.trees.region_tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ca.ntro.core.stream.Stream;

public class RegionTree2dNtro<R extends Region2d> implements RegionTree2d<R> {
	
	
	private Map<String, R> regionsById = new HashMap<>();
	
	private RegionTreeNode2dNtro<R> rootNode;
	
	private double epsilon;

	public Map<String, R> getRegionsById() {
		return regionsById;
	}

	public void setRegionsById(Map<String, R> regionsById) {
		this.regionsById = regionsById;
	}

	public RegionTreeNode2dNtro<R> getRootNode() {
		return rootNode;
	}

	public void setRootNode(RegionTreeNode2dNtro<R> rootNode) {
		this.rootNode = rootNode;
	}

	public double getEpsilon() {
		return epsilon;
	}

	public void setEpsilon(double epsilon) {
		this.epsilon = epsilon;
	}

	public RegionTree2dNtro(double topLeftX, 
			                double topLeftY, 
			                double width, 
			                double height,
			                double epsilon) {
		
		rootNode = new RegionTreeNode2dNtro<R>(topLeftX,
				                               topLeftY,
				                               width,
				                               height);
		
		setEpsilon(epsilon);
	}

	@Override
	public void add(R region) {
		regionsById.put(region.id(), region);
	}

	@Override
	public void remove(String id) {
		R region = get(id);
		
		if(region != null) {
			regionsById.remove(id);
			remove(region);
		}
	}

	@Override
	public void remove(R region) {
		Set<String> toRemove = new HashSet<>();
		
		
	}

	@Override
	public void onRegionMoved(String id) {
		R region = get(id);

		if(region != null) {
			remove(id);
			add(region);
		}
	}

	@Override
	public R get(String id) {
		return regionsById.get(id);
	}

	@Override
	public Stream<R> intersectWith(AnonymousRegion2d otherRegion) {
		return rootNode.intersectWith(otherRegion, epsilon);
	}

	@Override
	public Stream<R> intersectWith(double topLeftX, 
			                       double topLeftY, 
			                       double width, 
			                       double height) {

		return rootNode.intersectWith(topLeftX, topLeftY, width, height, epsilon);
	}

	@Override
	public Stream<R> containedIn(AnonymousRegion2d otherRegion) {
		return rootNode.containedIn(otherRegion, epsilon);
	}

	@Override
	public Stream<R> containedIn(double topLeftX, 
			                     double topLeftY, 
			                     double width, 
			                     double height) {

		return rootNode.containedIn(topLeftX, topLeftY, width, height, epsilon);
	}

	@Override
	public Stream<R> get(AnonymousRegion2d regionSpec) {
		return rootNode.get(regionSpec, epsilon);
	}

	@Override
	public Stream<R> get(double topLeftX, double topLeftY, double width, double height) {
		return rootNode.get(topLeftX, topLeftY, width, height, epsilon);
	}

}
