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
package ca.ntro.app.services;

import ca.ntro.app.frontend.events.EventNtro;
import ca.ntro.core.task_graphs.task_graph.SimpleTask;

public interface EventService {

	<E extends EventNtro> E newEvent(Class<E> eventClass);

	<E extends EventNtro> void registerEventHandler(Class<E> eventClass, SimpleTask eventHandler);

}
