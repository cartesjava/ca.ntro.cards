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
package ca.ntro.app;

import ca.ntro.app.session.Session;

public class ServerRegistrarNtro implements ServerRegistrar {
	
	private int port = 8001;
	private String serverName = "localhost";
	private Class<? extends Session> sessionClass;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public Class<? extends Session> getSessionClass() {
		return sessionClass;
	}

	public void setSessionClass(Class<? extends Session> sessionClass) {
		this.sessionClass = sessionClass;
	}

	@Override
	public void registerPort(int port) {
		setPort(port);
	}

	@Override
	public void registerName(String serverName) {
		setServerName(serverName);
	}

	@Override
	public void registerSessionClass(Class<? extends Session> sessionClass) {
		setSessionClass(sessionClass);
	}

}
