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
package ntro.core.services;

import java.util.Timer;
import java.util.TimerTask;

import ca.ntro.core.services.TimeJdk;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;

public class TimeFx extends TimeJdk {

	@Override
	public void runAfterDelay(long milliseconds, Runnable runnable) {
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				Platform.runLater(runnable);
			}

		}, milliseconds);
	}

	@Override
	public void runRepeatedly(long milliseconds, Runnable runnable) {
		if(milliseconds <= 1) {
			
			new AnimationTimer() {

				@Override
				public void handle(long now) {
					runnable.run();
				}
			}.start();
			
		}else {
			new Timer().scheduleAtFixedRate(new TimerTask() {

				@Override
				public void run() {
					Platform.runLater(runnable);
				}
				
			}, 0, milliseconds);
		}
	}

}
