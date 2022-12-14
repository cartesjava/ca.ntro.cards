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
package ca.ntro.cards.common.frontend.tasks;

import ca.ntro.app.tasks.SimpleTaskCreator;
import ca.ntro.app.tasks.SubTasksLambda;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.cards.common.CommonConstants;
import ca.ntro.cards.common.frontend.DashboardSubViewsLambda;
import ca.ntro.cards.common.frontend.views.CommonCanvasView;
import ca.ntro.cards.common.frontend.views.CommonDashboardView;
import ca.ntro.cards.common.frontend.views.CommonMessagesView;
import ca.ntro.cards.common.frontend.views.CommonRootView;
import ca.ntro.cards.common.frontend.views.CommonSettingsView;
import ca.ntro.cards.common.messages.MsgStartExecutionEngine;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.services.Window;

public class Initialization {

	public static <ROOT_VIEW      extends CommonRootView, 
	               CANVAS_VIEW    extends CommonCanvasView,
	               SETTINGS_VIEW  extends CommonSettingsView,
	               MESSAGES_VIEW  extends CommonMessagesView,
	               DASHBOARD_VIEW extends CommonDashboardView> 
	
	void createTasks(FrontendTasks tasks,
			         Class<ROOT_VIEW> rootViewClass,
			         Class<CANVAS_VIEW> cardsViewClass,
			         Class<SETTINGS_VIEW> settingsViewClass,
			         Class<MESSAGES_VIEW> messagesViewClass,
			         Class<DASHBOARD_VIEW> dashboardViewClass,
			         SubTasksLambda<FrontendTasks> addDashboardSubViewLoadersLabmda,
			         DashboardSubViewsLambda dashboadSubViewsLamba,
			         SubTasksLambda<FrontendTasks> subTaskLambda) {

		tasks.taskGroup("Initialization")
		
		     .waitsFor(window())

		     .contains(subTasks -> {
		    	 
		    	 createRootView(subTasks,
		    			        rootViewClass);

		    	 createCardsView(subTasks,
		    			         cardsViewClass);

		    	 createSettingsView(subTasks,
		    			            settingsViewClass);

		    	 createMessagesView(subTasks,
		    			            messagesViewClass);

		    	 createDashboardView(subTasks,
		    			             dashboardViewClass);
		    	 
		    	 installRootView(subTasks,
		    			         rootViewClass);

		    	 registerCanvasView(subTasks,
		    			           rootViewClass,
		    			           cardsViewClass);

		    	 registerSettingsView(subTasks,
		    			              rootViewClass,
		    			              settingsViewClass);

		    	 registerMessagesView(subTasks,
		    			              rootViewClass,
		    			              messagesViewClass);
		    	 
		    	 installRootSubViews(subTasks,
		    			             rootViewClass);
		    	 
		    	 installDashboardView(subTasks,
		    			              cardsViewClass,
		    			              dashboardViewClass);
		    	 
		    	 addDashboardSubViewLoadersLabmda.createSubTasks(subTasks);
		    	 
		    	 installDashboardSubViews(subTasks, dashboadSubViewsLamba);

		    	 showWindow(subTasks);
		    	 
		    	 subTaskLambda.createSubTasks(subTasks);

		     });
	}

	private static <ROOT_VIEW extends CommonRootView> void createRootView(FrontendTasks tasks,
			                                                        Class<ROOT_VIEW> rootViewClass) {

		tasks.task(create(rootViewClass))
		
		     .waitsFor(viewLoader(rootViewClass))
		     
		     .thenExecutesAndReturnsValue(inputs -> {
		    	 
		    	 ViewLoader<ROOT_VIEW> rootViewLoader = inputs.get(viewLoader(rootViewClass));

		    	 return rootViewLoader.createView();
		     });
	}

	private static <CARDS_VIEW extends CommonCanvasView> void createCardsView(FrontendTasks tasks,
			                                                           Class<CARDS_VIEW> cardsViewClass) {

		tasks.task(create(cardsViewClass))
		
		     .waitsFor(viewLoader(cardsViewClass))
		     
		     .thenExecutesAndReturnsValue(inputs -> {
		    	 
		    	 ViewLoader<CARDS_VIEW> cardsViewLoader = inputs.get(viewLoader(cardsViewClass));
		    	 
		    	 return cardsViewLoader.createView();
		     });
		
	}

	private static <SETTINGS_VIEW extends CommonSettingsView> void createSettingsView(FrontendTasks tasks,
			                                                                    Class<SETTINGS_VIEW> settingsViewClass) {

		tasks.task(create(settingsViewClass))
		
		     .waitsFor(viewLoader(settingsViewClass))
		     
		     .thenExecutesAndReturnsValue(inputs -> {
		    	 
		    	 ViewLoader<SETTINGS_VIEW> settingsViewLoader = inputs.get(viewLoader(settingsViewClass));
		    	 
		    	 return settingsViewLoader.createView();
		     });
		
	}

	private static <MESSAGES_VIEW extends CommonMessagesView> void createMessagesView(FrontendTasks tasks,
			                                                                          Class<MESSAGES_VIEW> messagesViewClass) {

		tasks.task(create(messagesViewClass))
		
		     .waitsFor(viewLoader(messagesViewClass))
		     
		     .thenExecutesAndReturnsValue(inputs -> {
		    	 
		    	 ViewLoader<MESSAGES_VIEW> messagesViewLoader = inputs.get(viewLoader(messagesViewClass));
		    	 
		    	 return messagesViewLoader.createView();
		     });
		
	}

	private static <DASHBOARD_VIEW extends CommonDashboardView> void createDashboardView(FrontendTasks tasks,
			                                                                       Class<DASHBOARD_VIEW> dashboardViewClass) {

		tasks.task(create(dashboardViewClass))
		
		     .waitsFor(viewLoader(dashboardViewClass))
		     
		     .thenExecutesAndReturnsValue(inputs -> {
		    	 
		    	 ViewLoader<DASHBOARD_VIEW> dashboardViewLoader = inputs.get(viewLoader(dashboardViewClass));
		    	 
		    	 return dashboardViewLoader.createView();
		     });
		
	}

	private static <ROOT_VIEW extends CommonRootView> void installRootView(FrontendTasks tasks,
			                                                         Class<ROOT_VIEW> rootViewClass) {

		tasks.task("installRootView")

		     .waitsFor(created(rootViewClass))
		     
		     .thenExecutes(inputs -> {
		    	 
		    	 ROOT_VIEW rootView = inputs.get(created(rootViewClass));
		    	 Window    window   = inputs.get(window());
		    	 
		    	 window.installRootView(rootView);
		     });
	}

	private static <ROOT_VIEW extends CommonRootView,
	                CARDS_VIEW extends CommonCanvasView> void registerCanvasView(FrontendTasks tasks,
	                		                                             Class<ROOT_VIEW> rootViewClass,
	                		                                             Class<CARDS_VIEW> cardsViewClass) {

		tasks.task("registerCanvasView")
		
		     .waitsFor("installRootView")

		     .waitsFor(created(cardsViewClass))
		     
		     .thenExecutes(inputs -> {
		    	 
		    	 ROOT_VIEW  rootView   = inputs.get(created(rootViewClass));
		    	 CARDS_VIEW cardsView = inputs.get(created(cardsViewClass));
		    	 
		    	 rootView.registerCanvasView(cardsView);
		     });
	}

	private static <ROOT_VIEW extends CommonRootView,
	                SETTINGS_VIEW extends CommonSettingsView> 

	        void registerSettingsView(FrontendTasks tasks,
	        		                  Class<ROOT_VIEW> rootViewClass,
	        		                  Class<SETTINGS_VIEW> settingsViewClass) {

		tasks.task("registerSettingsView")
		
		     .waitsFor("installRootView")

		     .waitsFor(created(settingsViewClass))
		     
		     .thenExecutes(inputs -> {
		    	 
		    	 ROOT_VIEW     rootView     = inputs.get(created(rootViewClass));
		    	 SETTINGS_VIEW settingsView = inputs.get(created(settingsViewClass));

		    	 rootView.registerSettingsView(settingsView);
		     });
	}

	private static <ROOT_VIEW     extends CommonRootView,
	                MESSAGES_VIEW extends CommonMessagesView> 

	        void registerMessagesView(FrontendTasks tasks,
	        		                  Class<ROOT_VIEW> rootViewClass,
	        		                  Class<MESSAGES_VIEW> messagesViewClass) {

		tasks.task("registerMessagesView")
		
		     .waitsFor("installRootView")

		     .waitsFor(created(messagesViewClass))
		     
		     .thenExecutes(inputs -> {
		    	 
		    	 ROOT_VIEW     rootView     = inputs.get(created(rootViewClass));
		    	 MESSAGES_VIEW messagesView = inputs.get(created(messagesViewClass));

		    	 rootView.registerMessagesView(messagesView);
		     });
	}

	private static <ROOT_VIEW extends CommonRootView> void installRootSubViews(FrontendTasks tasks, 
			                                                         Class<ROOT_VIEW> rootViewClass) {

		tasks.task("installRootSubViews")

		     .waitsFor("registerCanvasView")
		
		     .waitsFor("registerSettingsView")

		     .thenExecutes(inputs -> {
		    	 
		    	 ROOT_VIEW rootView = inputs.get(created(rootViewClass));

		    	 rootView.installSubViews();
		     });
	}

	private static <CARDS_VIEW extends CommonCanvasView,
	                DASHBOARD_VIEW extends CommonDashboardView> 
	
	        void installDashboardView(FrontendTasks tasks,
	        		                  Class<CARDS_VIEW> cardsViewClass,
	        		                  Class<DASHBOARD_VIEW> dashboardViewClass) {

		tasks.task("installDashboardView")
		
		     .waitsFor("registerCanvasView")

		     .waitsFor(created(dashboardViewClass))
		     
		     .thenExecutes(inputs -> {
		    	 
		    	 CARDS_VIEW     cardsView     = inputs.get(created(cardsViewClass));
		    	 DASHBOARD_VIEW dashboardView = inputs.get(created(dashboardViewClass));
		    	 
		    	 cardsView.displayDashboardView(dashboardView);
		     });
	}

	private static void installDashboardSubViews(FrontendTasks tasks, 
			                                     DashboardSubViewsLambda dashboadSubViewsLamba) {
		
		SimpleTaskCreator<?> taskCreator = tasks.task("installDashboardSubViews")
		
		                                        .waitsFor("installDashboardView");
		
		dashboadSubViewsLamba.completeTaskDefinition(taskCreator);
		
	}

	private static void showWindow(FrontendTasks tasks) {
		tasks.task("showWindow")
		
		     .waitsFor("installDashboardSubViews")
		     
		     .thenExecutes(inputs -> {

		    	 Window window = inputs.get(window());
		    	 
		    	 window.resize(CommonConstants.INITIAL_WINDOW_WIDTH, 
		    			       CommonConstants.INITIAL_WINDOW_HEIGHT);
		    	 
		    	 window.show();
		    	 
		    	 MsgStartExecutionEngine msgStartExecutionEngine = NtroApp.newMessage(MsgStartExecutionEngine.class);
		    	 msgStartExecutionEngine.send();
		     });
	}

}
