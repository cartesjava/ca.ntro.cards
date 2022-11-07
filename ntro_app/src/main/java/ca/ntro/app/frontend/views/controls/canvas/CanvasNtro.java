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
package ca.ntro.app.frontend.views.controls.canvas;

public abstract class CanvasNtro<RAW_GC extends Object,
                                 RAW_CANVAS extends Object,
                                 RAW_IMAGE extends Object,
                                 RAW_FONT extends Object,
                                 RAW_COLOR extends Object,
                                 CANVAS extends Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS>>

       implements Canvas<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS> {
	
	private InternalGraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS> graphicsContext;

	public InternalGraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS> getGraphicsContext() {
		return graphicsContext;
	}

	public void setGraphicsContext(InternalGraphicsContext<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS> graphicsContext) {
		this.graphicsContext = graphicsContext;
	}

	@Override
	public void drawOnCanvas(CanvasDrawingLambda<RAW_GC, RAW_CANVAS, RAW_IMAGE, RAW_FONT, RAW_COLOR, CANVAS> lambda) {
		graphicsContext.save();

		graphicsContext.setTransform(1.0, 0, 0, 1.0, 0, 0); 

		lambda.draw(graphicsContext);
		
		graphicsContext.restore();
	}
}
