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
package ca.ntro.core.services;

import java.util.Timer;
import java.util.TimerTask;

import ca.ntro.core.initialization.Ntro;

public class TimeJdk implements Time {

	@Override
	public void sleep(long milliseconds) {
		try {

			Thread.sleep(milliseconds);

		} catch (InterruptedException e) {

			Ntro.exceptionService().throwException(e);
		}
	}

	@Override
	public long nowMilliseconds() {
		return System.currentTimeMillis();
	}

	@Override
	public void runAfterDelay(long milliseconds, Runnable runnable) {
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				runnable.run();
			}

		}, milliseconds);
	}

	@Override
	public void runRepeatedly(long milliseconds, Runnable runnable) {
		new Timer().scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				runnable.run();
			}
			
			
		}, 0, milliseconds);
	}

	@Override
	public long nowNanoseconds() {
		return System.nanoTime();
	}

}
