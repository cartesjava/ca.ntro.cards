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
package ca.ntro.app.world2d;

import ca.ntro.app.frontend.views.controls.canvas.Canvas;
import ca.ntro.app.frontend.views.controls.canvas.GraphicsContext;
import ca.ntro.app.frontend.views.controls.canvas.World2dGraphicsContext;
import ca.ntro.core.data_structures.trees.region_tree.AnonymousRegion2d;

public abstract class Object2dNtro<RAW_GC extends Object,
                                   RAW_CANVAS extends Object, 
                                   RAW_IMAGE extends Object,
                                   RAW_FONT extends Object,
                                   RAW_COLOR extends Object,
                                   CANVAS extends Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS>,
                                   

                                   GC extends GraphicsContext<RAW_GC, 
                                                              RAW_CANVAS, 
                                                              RAW_IMAGE,
                                                              RAW_FONT,
                                                              RAW_COLOR,
                                                              CANVAS>,

							   OBJECT2D extends Object2dNtro<RAW_GC, 
														     RAW_CANVAS, 
														     RAW_IMAGE,
														     RAW_FONT,
														     RAW_COLOR,
														     CANVAS,
													         GC,
														     OBJECT2D,
														     WORLD2D,
														     OPTIONS>,

							   WORLD2D  extends World2d<RAW_GC, 
														RAW_CANVAS, 
														RAW_IMAGE, 
														RAW_FONT,
														RAW_COLOR,
														CANVAS,
														GC,
														OBJECT2D,
														WORLD2D,
														OPTIONS>,
							   
							   OPTIONS extends DrawingOptions> 
                                                          
        implements Object2d<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS, GC, OBJECT2D, WORLD2D, OPTIONS> {
                                                            	  
	private WORLD2D world;
	private double topLeftX;
	private double topLeftY;
	private double width; 
	private double height;
	private double speedX;
	private double speedY;

	public WORLD2D getWorld() {
		return world;
	}

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

	public double getSpeedX() {
		return speedX;
	}

	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}

	public double getSpeedY() {
		return speedY;
	}

	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}

	public void setWorld(WORLD2D world) {
		this.world = world;
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

	@Override
	public WORLD2D world() {
		return (WORLD2D) getWorld();
	}

	@Override
	public double speedX() {
		return getSpeedX();
	}

	@Override
	public double speedY() {
		return getSpeedY();
	}

	public void onTimePasses(double secondsElapsed) {
		topLeftX += speedX * secondsElapsed;
		topLeftY += speedY * secondsElapsed;
	}
	
	public boolean collidesWith(OBJECT2D other) {
		return other.collidesWith(topLeftX, topLeftY, width, height);
	}

	public boolean collidesWith(double topLeftX, double topLeftY, double width, double height) {
		return collidesOneAxis(this.topLeftX, this.width, topLeftX, width)
				&& collidesOneAxis(this.topLeftY, this.height, topLeftY, height);
	}
	
	private boolean collidesOneAxis(double coord1, double size1, double coord2, double size2) {
		return (coord1 < coord2 && coord1 + size1 >= coord2)
				|| (coord2 <= coord1 && coord2 + size2 >= coord1);
	}
	
	@SuppressWarnings("rawtypes")
	public abstract void draw(World2dGraphicsContext gc, OPTIONS options);

	public abstract void initialize();

	public void copyDataFrom(OBJECT2D object2d) {
		setTopLeftX(object2d.getTopLeftX());
		setTopLeftY(object2d.getTopLeftY());
		setWidth(object2d.getWidth());
		setHeight(object2d.getHeight());
		setSpeedX(object2d.getSpeedX());
		setSpeedY(object2d.getSpeedY());
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

	public boolean hasId(String id) {
		return id().equals(id);
	}

}
