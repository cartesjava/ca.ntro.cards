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
package ca.ntro.cards.common.test_cases.execution;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

import ca.ntro.cards.common.CommonConstants;
import ca.ntro.cards.common.models.CommonExecutableModel;
import ca.ntro.cards.common.test_cases.CommonTestCase;
import ca.ntro.cards.common.test_cases.descriptor.AbstractTestCaseDescriptor;
import ca.ntro.cards.common.test_cases.execution.handlers.DoneHandler;
import ca.ntro.cards.common.test_cases.execution.jobs.ExecutionJob;
import ca.ntro.cards.common.test_cases.execution.jobs.Job;
import ca.ntro.cards.common.test_cases.execution.signals.ExitSignal;
import ca.ntro.core.initialization.Ntro;

public class TestCaseJobEngine<EXECUTABLE_MODEL extends CommonExecutableModel,
                             STUDENT_MODEL extends EXECUTABLE_MODEL,
                             TEST_CASE extends CommonTestCase>  
       extends Thread {
	
	private Class<EXECUTABLE_MODEL> executableModelClass;
	private Class<STUDENT_MODEL> studentModelClass;
	private Class<TEST_CASE> testCaseClass;
	
	private Map<Long, TestCaseJobThread> threadById = new ConcurrentHashMap<>();

	private Set<Long> idleThreads = Collections.synchronizedSet(new HashSet<>());
	private Set<Long> runningThreads = Collections.synchronizedSet(new HashSet<>());
	private Set<Long> unresponsiveThreads = Collections.synchronizedSet(new HashSet<>());

	private Queue<Job> jobs = new ConcurrentLinkedQueue<>();

	private File dbDir = new File(CommonConstants.TEST_CASE_DATABASE_DIR);
	
	private boolean shouldQuit = false;
	
	public Class<EXECUTABLE_MODEL> executableModelClass() {
		return executableModelClass;
	}

	public void registerExecutableModelClass(Class<EXECUTABLE_MODEL> executableModelClass) {
		this.executableModelClass = executableModelClass;
	}

	public Class<STUDENT_MODEL> studentModelClass() {
		return studentModelClass;
	}

	public void registerStudentModelClass(Class<STUDENT_MODEL> studentModelClass) {
		this.studentModelClass = studentModelClass;
	}

	public Class<TEST_CASE> testCaseClass() {
		return testCaseClass;
	}

	public void registerTestCaseClass(Class<TEST_CASE> testCaseClass) {
		this.testCaseClass = testCaseClass;
	}

	public void addExecutionStep(long threadId) {
		TestCaseJobThread thread = threadById.get(threadId);
		
		if(thread != null) {
			thread.addExecutionStep();
		}
	}

	public void initialize(int numberOfThreads) {
		for(int i = 0; i < numberOfThreads; i++) {
			
			TestCaseJobThread thread = new TestCaseJobThread();
			thread.registerExecutionEngine(this);

			threadById.put(thread.getId(), thread);
		}
	}
	
	public void executeJob(Job job, DoneHandler doneHandler) {
		job.setExecutionEngine(this);
		job.setDoneHandler(doneHandler);
		
		jobs.add(job);
	}
	
	public void resetTestCasesDirectory() {
		resetDir(dbDir);
	}
	
	private void resetDir(File dir) {
		System.out.println("\n\n[DELETING DATA] " + dir.getAbsolutePath());
		if(dir.exists()) {
			deleteFiles(dir);
			dir.delete();
		}

		dir.mkdir();
	}

	public void resetStorageDirectory() {
		File storageDir = new File(CommonConstants.STORAGE_DIR);

		resetDir(storageDir);
	}

	private void deleteFiles(File dir) {

		for(File file : dir.listFiles()) {
			if(file.isDirectory()) {
				deleteFiles(file);
				file.delete();
			}else {
				file.delete();
			}
		}
	}

	@Override
	public void run() {
		startThreads();
		
		while(!shouldQuit) {
			
			try {
				
				updateJobs();

				sleep(CommonConstants.ENGINE_THREAD_SLEEP_TIME_MILISECONDS);

			} catch (InterruptedException e) {

				shouldQuit = true;

			}
		}
		
	}
	
	private void startThreads() {
		for(TestCaseJobThread thread : threadById.values()) {
			thread.start();
		}
	}

	private void updateJobs() {
		for(TestCaseJobThread thread : threadById.values()) {
			
			if(!jobs.isEmpty()) {

				Job job = jobs.remove();
				
				thread.pushSignal(job);
			}
		}
	}

	private void forceQuitThreads() {
		for(TestCaseJobThread thread : threadById.values()) {
			System.out.println(String.format("thread %s %s", thread.getId(), thread.getState()));
		}
		
	}

	public void shutdown() {
		for(TestCaseJobThread thread : threadById.values()) {
			thread.pushSignal(new ExitSignal());
		}
		
		this.shouldQuit = true;

	}

	public void forceShutdown() {
		System.out.println("forceShutdown");
	}

	public void notifyThreadIsIdle(long threadId) {
	}

	public void notifyThreadIsTerminated(long threadId) {
	}

	public void notifyThreadIsRunning(long threadId) {
	}

	public int numberOfThreads() {
		return threadById.size();
	}


}
