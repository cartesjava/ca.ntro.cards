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

public interface AnonymousRegion2d {

	double topLeftX();
	double topLeftY();
	double width();
	double height();
	
	boolean isContainedIn(AnonymousRegion2d otherRegion, double epsilon);
	boolean isContainedIn(double topLeftX, 
			              double topLeftY, 
			              double width, 
			              double height,
			              double epsilon);

	boolean intersectsWith(AnonymousRegion2d otherRegion, double epsilon);

	boolean intersectsWith(double topLeftX, 
			               double topLeftY, 
			               double width, 
			               double height, 
			               double epsilon);
	
	boolean isEqualTo(AnonymousRegion2d otherRegion, double epsilon);

	boolean isEqualTo(double topLeftX, 
			          double topLeftY, 
			          double width, 
			          double height, 
			          double epsilon);

	public static boolean isContainedIn(double topLeftX01,
			                            double topLeftY01,
			                            double width01,
			                            double height01,
			                            double topLeftX02,
			                            double topLeftY02,
			                            double width02,
			                            double height02, 
			                            double epsilon) {

		return isContainedInOneAxis(topLeftX01, 
				                    width01, 
				                    topLeftX02, 
				                    width02, 
				                    epsilon)

				&& isContainedInOneAxis(topLeftY01, 
						                height01, 
						                topLeftY02, 
						                height02, 
						                epsilon);
	}

	private static boolean isContainedInOneAxis(double coord1, 
			                                    double size1, 
			                                    double coord2, 
			                                    double size2,
			                                    double epsilon) {

		return coord1 + epsilon > coord2
				&& coord1 + size1 < coord2 + size2 + epsilon;
	}
	
	
	public static boolean intersectsWith(double topLeftX01, 
			                             double topLeftY01, 
			                             double width01, 
			                             double height01, 
			                             double topLeftX02,
			                             double topLeftY02,
			                             double width02,
			                             double height02, 
			                             double epsilon) {

		return intersectsWithOneAxis(topLeftX01, 
				                     width01, 
				                     topLeftX02, 
				                     width02, 
				                     epsilon)

				&& intersectsWithOneAxis(topLeftY01, 
						                 height01, 
						                 topLeftX02, 
						                 height02, 
						                 epsilon);
	}
	

	private static boolean intersectsWithOneAxis(double coord1, 
			                                     double size1, 
			                                     double coord2, 
			                                     double size2, 
			                                     double epsilon) {

		return (coord1 + epsilon > coord2
				&& coord1 < coord2 + size2 + epsilon)

				|| 
				
				(coord1 + size1 + epsilon > coord2
				&& coord1 + size1 < coord2 + size2 + epsilon);
	}

	public static boolean isEqualTo(double topLeftX01, 
			                        double topLeftY01, 
			                        double width01, 
			                        double height01, 
			                        double topLeftX02,
			                        double topLeftY02,
			                        double width02,
			                        double height02, 
			                        double epsilon) {

		return isEqualToOneAxis(topLeftX01, 
				                width01, 
				                topLeftX02, 
				                width02, 
				                epsilon)

				&& isEqualToOneAxis(topLeftY01, 
						            height01, 
						            topLeftX02, 
						            height02, 
						            epsilon);
	}

	private static boolean isEqualToOneAxis(double coord1, 
			                                double size1, 
			                                double coord2, 
			                                double size2, 
			                                double epsilon) {

		return Math.abs(coord1 - coord2) < epsilon
				&& Math.abs(size1 - size2) < epsilon;
	}
	
}
