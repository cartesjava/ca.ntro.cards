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
package ca.ntro.core.initialization;

import ca.ntro.core.graph_writer.GraphWriter;
import ca.ntro.core.graph_writer.GraphWriterNull;
import ca.ntro.core.services.Asserter;
import ca.ntro.core.services.AsserterNull;
import ca.ntro.core.services.Collections;
import ca.ntro.core.services.CollectionsNull;
import ca.ntro.core.services.ExceptionService;
import ca.ntro.core.services.ExceptionThrowerDefault;
import ca.ntro.core.services.FactoryService;
import ca.ntro.core.services.FactoryServiceDefault;
import ca.ntro.core.services.JsonService;
import ca.ntro.core.services.JsonServiceNull;
import ca.ntro.core.services.Random;
import ca.ntro.core.services.RandomNull;
import ca.ntro.core.services.ReflectionService;
import ca.ntro.core.services.ReflectionServiceNull;
import ca.ntro.core.services.Time;
import ca.ntro.core.services.TimeNull;
import ca.ntro.core.services.StackAnalyzer;
import ca.ntro.core.services.StackAnalyzerNull;
import ca.ntro.core.services.StorageService;
import ca.ntro.core.services.StorageServiceNull;

public class Ntro {

	/* <Factory> */
	
	private static FactoryService factoryService = new FactoryServiceDefault();
	
	static void registerFactoryService(FactoryService factoryService){
		Ntro.factoryService = factoryService;
	}

	public static FactoryService factory(){
		return Ntro.factoryService;
	}

	/* </Factory> */

	
	
	
	/* <ExceptionService> */
	
	private static ExceptionService exceptionService = new ExceptionThrowerDefault();
	
	static void registerExceptionThrower(ExceptionService exceptionService){
		Ntro.exceptionService = exceptionService;
	}

	public static ExceptionService exceptionService(){
		return Ntro.exceptionService;
	}

	public static void throwException(String message){
		exceptionService().throwException(new RuntimeException(message));
	}

	public static void throwException(Throwable t){
		exceptionService().throwException(t);
	}

	/* </ExceptionService> */
	

	
	
	
	
	
	/* <Asserter> */
	
	private static Asserter asserter = new AsserterNull();
	
	static void registerAsserter(Asserter asserter){
		Ntro.asserter = asserter;
	}

	public static Asserter asserter(){
		return Ntro.asserter;
	}
	
	public static void assertNotNull(String message, Object value) {
		Ntro.asserter.assertNotNull(message, value);
	}

	/* </Asserter> */
	

	
	
	/* <ReflectionService> */
	
	private static ReflectionService reflectionService = new ReflectionServiceNull();
	
	static void registerReflectionService(ReflectionService reflectionService){
		Ntro.reflectionService = reflectionService;
	}

	public static ReflectionService reflection(){
		return Ntro.reflectionService;
	}

	/* </ReflectionService> */
	
	
	
	
	
	/* <StackAnalyzer> */
	
	private static StackAnalyzer stackAnalyzer = new StackAnalyzerNull();
	
	static void registerStackAnalyzer(StackAnalyzer stackAnalyzer){
		Ntro.stackAnalyzer = stackAnalyzer;
	}

	public static StackAnalyzer stackAnalyzer(){
		return Ntro.stackAnalyzer;
	}

	/* </StackAnalyzer> */
	
	
	

	/* <GraphWriter> */
	
	private static Class<? extends GraphWriter> graphWriterClass = GraphWriterNull.class;

	static void registerGraphWriter(Class<? extends GraphWriter> graphWriterClass){
		Ntro.graphWriterClass = graphWriterClass;
	}

	public static GraphWriter graphWriter(){
		return Ntro.factory().newInstance(graphWriterClass);
	}

	/* </GraphWriter> */
	
	
	

	/* <Collections> */
	
	private static Collections collections = new CollectionsNull();

	static void registerCollections(Collections collections){
		Ntro.collections = collections;
	}

	public static Collections collections(){
		return Ntro.collections;
	}

	/* </Collections> */

	
	
	
	/* <Time> */
	
	private static Time time = new TimeNull();

	static void registerTime(Time time){
		Ntro.time = time;
	}

	public static Time time(){
		return Ntro.time;
	}

	/* </Time> */
	
	
	
	
	/* <Random> */
	
	private static Random random = new RandomNull();

	static void registerRandom(Random random){
		Ntro.random = random;
	}

	public static Random random(){
		return Ntro.random;
	}

	/* </Random> */
	
	
	
	
	
	
	/* <JsonService> */
	
	private static JsonService jsonService = new JsonServiceNull();

	static void registerJsonService(JsonService jsonService){
		Ntro.jsonService = jsonService;
	}

	public static JsonService json(){
		return Ntro.jsonService;
	}

	/* </JsonService> */
	
	
	

	/* <Storage> */
	
	private static StorageService storageService = new StorageServiceNull();

	static void registerStorageService(StorageService storageService){
		Ntro.storageService = storageService;
	}

	public static StorageService storage(){
		return Ntro.storageService;
	}

	/* </Storage> */
	
	
}
