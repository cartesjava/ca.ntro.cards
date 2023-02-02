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
package ca.ntro.cards.common.frontend.utils;

import ca.ntro.core.initialization.Ntro;

public class FpsCounter {

	private static long RECOMPUTE_AT_EVERY_X_MILISECONDS = 200;

	private long lastTimestamp = Ntro.time().nowMilliseconds();
	private long framesDisplaySinceLastTimestamp = 0;

	private double currentFps = 0;
	
	public double currentFps() {
		return currentFps;
	}

	public void onNewFrame() {
		framesDisplaySinceLastTimestamp++;

		computeFpsIfNeeded();
	}

	private void computeFpsIfNeeded() {
		long now = Ntro.time().nowMilliseconds();
		long elapsedMilliseconds = now - lastTimestamp;

		if(elapsedMilliseconds > RECOMPUTE_AT_EVERY_X_MILISECONDS) {
			computeFps(elapsedMilliseconds);

			framesDisplaySinceLastTimestamp = 0;
			lastTimestamp = now;
		}
	}

	private void computeFps(long elapsedMilliseconds) {
		double elapsedSeconds = elapsedMilliseconds / 1E3;
		currentFps = framesDisplaySinceLastTimestamp / elapsedSeconds;
	}
	

}
