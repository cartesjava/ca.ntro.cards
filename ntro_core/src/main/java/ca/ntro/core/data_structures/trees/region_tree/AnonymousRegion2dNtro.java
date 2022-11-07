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

public class AnonymousRegion2dNtro implements AnonymousRegion2d {

	private double topLeftX;
	private double topLeftY;
	private double width;
	private double height;


	public double getTopLeftX() {
		return topLeftX;
	}

	public void setTopLeftX(double topLeftX) {
		this.topLeftX = topLeftX;
	}

	public double getTopLeftY() {
		return topLeftY;
	}

	public void setTopLeftY(double topLeftY) {
		this.topLeftY = topLeftY;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double topLeftX() {
		return getTopLeftX();
	}

	@Override
	public double topLeftY() {
		return getTopLeftY();
	}

	@Override
	public double width() {
		return getWidth();
	}

	@Override
	public double height() {
		return getHeight();
	}

	public AnonymousRegion2dNtro(double topLeftX, double topLeftY, double width, double height) {
		setTopLeftX(topLeftX);
		setTopLeftY(topLeftY);
		setWidth(width);
		setHeight(height);
	}

	@Override
	public boolean isContainedIn(AnonymousRegion2d otherRegion, double epsilon) {
		return isContainedIn(otherRegion.topLeftX(),
				             otherRegion.topLeftY(),
				             otherRegion.width(),
				             otherRegion.height(),
				             epsilon);
	}

	@Override
	public boolean isContainedIn(double topLeftX, 
			                     double topLeftY, 
			                     double width, 
			                     double height, 
			                     double epsilon) {

		return AnonymousRegion2d.isContainedIn(this.topLeftX, 
				                      this.topLeftY, 
				                      this.width, 
				                      this.height, 
				                      topLeftX, 
				                      topLeftY, 
				                      width, 
				                      height, 
				                      epsilon);
	}

	@Override
	public boolean intersectsWith(AnonymousRegion2d otherRegion, double epsilon) {
		return intersectsWith(otherRegion.topLeftX(),
				              otherRegion.topLeftY(),
				              otherRegion.width(),
				              otherRegion.height(),
				              epsilon);
	}

	@Override
	public boolean intersectsWith(double topLeftX, 
			                      double topLeftY, 
			                      double width, 
			                      double height, 
			                      double epsilon) {

		return AnonymousRegion2d.intersectsWith(this.topLeftX, 
				                       this.topLeftY, 
				                       this.width, 
				                       this.height, 
				                       topLeftX, 
				                       topLeftY, 
				                       width, 
				                       height, 
				                       epsilon);
	}


	@Override
	public boolean isEqualTo(AnonymousRegion2d otherRegion, double epsilon) {
		return isEqualTo(otherRegion.topLeftX(),
				         otherRegion.topLeftY(),
				         otherRegion.width(),
				         otherRegion.height(),
				         epsilon);
	}

	@Override
	public boolean isEqualTo(double topLeftX, 
			                 double topLeftY, 
			                 double width, 
			                 double height, 
			                 double epsilon) {
		
		return AnonymousRegion2d.isEqualTo(this.topLeftX, 
				                           this.topLeftY, 
				                           this.width, 
				                           this.height, 
				                           topLeftX, 
				                           topLeftY, 
				                           width, 
				                           height, 
				                           epsilon);
	}

}
