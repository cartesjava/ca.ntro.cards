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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.path.Path;
import ca.ntro.core.storage.FileWatcher;

public class   StorageServiceJdk 

       extends StorageServiceNtro {
	

	@Override
	public String readTextFile(Path filePath) {
		StringBuilder builder = new StringBuilder();
		
		try {

			Scanner scanner = new Scanner(new FileInputStream(toFile(filePath)));
			while(scanner.hasNextLine()) {

				builder.append(scanner.nextLine());
				builder.append(System.lineSeparator());
			}
			
			scanner.close();

		} catch (FileNotFoundException e) {
			
			Ntro.throwException(e);
		}
		
		
		return builder.toString();
	}

	@Override
	public void writeTextFile(Path filePath, String content) {
		new Thread() {

			@Override
			public void run() {
				writeTextFileSync(filePath, content);
			}

		}.start();
	}
	
	protected void writeTextFileSync(Path filePath, String content) {
		File file = toFile(filePath);
		

		createParentDirectories(file);

		try {

			FileOutputStream out = new FileOutputStream(file);
			
			out.write(content.getBytes());
			out.close();

		} catch (IOException e) {

			Ntro.throwException(e);
		}
	}
	
	
	

	private void createParentDirectories(File file) {
		if(file.getParentFile() != null) {
			file.getParentFile().mkdirs();
		}
	}
	
	

	@Override
	public boolean ifFileExists(Path filePath) {
		return toFile(filePath).exists();
	}
	
	private File toFile(Path filePath) {
		return Paths.get("_storage", filePath.toRawPath()).toFile();
	}

	@Override
	public void watchFile(Path filePath, FileWatcher watcher) {

			// FIXME: should use a NtroThread service
			new Thread() {

				@Override
				public void run() {
					
					try {

						WatchService watchService = FileSystems.getDefault().newWatchService();
						File parentDirectory = toFile(filePath).getParentFile();
						if(parentDirectory != null) {
							
							if(!parentDirectory.exists()) {
								parentDirectory.mkdirs();
							}

							parentDirectory.toPath().register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

							boolean poll = true;
							
							while(poll) {
								WatchKey key = watchService.take();
								for(WatchEvent<?> event : key.pollEvents()) {

									callWatcher(watcher);
								}

								poll = key.reset();
							}
						}

					} catch (IOException | InterruptedException e) {
						
						Ntro.throwException(e);
					}
				}

			}.start();
	}

	protected void callWatcher(FileWatcher watcher) {
		// FIXME: should use a Thread service
		watcher.fileChanged();
	}

	@Override
	public void deleteTextFile(Path filePath) {
		toFile(filePath).delete();
	}
	

}
