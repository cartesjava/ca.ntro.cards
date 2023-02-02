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
package ca.ntro.app.frontend;

import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.services.Window;
import ca.ntro.app.services.WindowNull;
import ca.ntro.app.tasks.frontend.FrontendTasks;

public class DefaultFrontendFx implements Frontend<ViewRegistrarFx> {
	
	private Window window = new WindowNull();

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}

	public DefaultFrontendFx() {
	}

	public DefaultFrontendFx(Window window) {
		setWindow(window);
	}

	@Override
	public void registerEvents(EventRegistrar registrar) {
	}

	@Override
	public void registerViews(ViewRegistrarFx registrar) {
	}

	@Override
	public void createTasks(FrontendTasks tasks) {
	}

	@Override
	public void execute() {
		//getWindow().resize(600,400);
		//getWindow().show();
		System.out.println("[INFO] Ntro default frontend. Please register a frontend");
	}
}
