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

import ca.ntro.core.path.Path;
import ca.ntro.core.services.StorageServiceJdk;
import ca.ntro.core.storage.FileWatcher;
import javafx.application.Platform;

public class StorageServiceFx extends StorageServiceJdk {
	
	// FIXME: this should be done in a ThreadService

	@Override
	public void writeTextFile(Path filePath, String content) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				writeTextFileSync(filePath, content);
			}
		});
	}

	@Override
	protected void callWatcher(FileWatcher watcher) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				watcher.fileChanged();
			}
		});
	}
	

}
