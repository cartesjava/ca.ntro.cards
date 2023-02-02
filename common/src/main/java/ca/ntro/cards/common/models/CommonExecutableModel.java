/*
Copyright (C) (2022) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)

This file is part of "Cartes Java", teaching tools made for https://cartesjava.github.io/

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

*/
package ca.ntro.cards.common.models;

import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;

import ca.ntro.app.models.Watch;
import ca.ntro.app.models.WriteObjectGraph;
import ca.ntro.cards.common.frontend.CommonViewData;
import ca.ntro.cards.common.models.world2d.CommonDrawingOptions;
import ca.ntro.cards.common.models.world2d.CommonObject2d;
import ca.ntro.cards.common.models.world2d.CommonWorld2d;
import ca.ntro.cards.common.test_cases.descriptor.AbstractTestCaseDescriptor;
import ca.ntro.cards.common.test_cases.execution_trace.CommonExecutionTrace;

public abstract class CommonExecutableModel<CARDS_MODEL extends CommonExecutableModel,
                                            OBJECT2D    extends CommonObject2d<OBJECT2D, WORLD2D, OPTIONS>,
                                            WORLD2D     extends CommonWorld2d<OBJECT2D, WORLD2D, OPTIONS>,
                                            OPTIONS     extends CommonDrawingOptions,
                                            VIEW_DATA   extends CommonViewData<OBJECT2D, WORLD2D, OPTIONS>>



               extends CommonCanvasModel<CARDS_MODEL, OBJECT2D, WORLD2D, OPTIONS, VIEW_DATA> 

               implements Watch, WriteObjectGraph, Serializable {

	private static final long serialVersionUID = -6280486621314092815L;

	public abstract void initializeAsTestCase(AbstractTestCaseDescriptor descriptor);

	public abstract int testCaseSize();

	public void onBeforeRunning() {}

	public abstract void run();

	public void onAfterRunning() {}

}
