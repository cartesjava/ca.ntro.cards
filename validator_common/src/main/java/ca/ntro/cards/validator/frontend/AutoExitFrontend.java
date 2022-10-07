package ca.ntro.cards.validator.frontend;

import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import javafx.application.Platform;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.AppWrapperFx;
import ca.ntro.app.NtroApp;

public class AutoExitFrontend implements FrontendFx {

	@Override
	public void registerEvents(EventRegistrar registrar) {
		
	}

	@Override
	public void registerViews(ViewRegistrarFx registrar) {
		
	}

	@Override
	public void createTasks(FrontendTasks tasks) {
		/*
		tasks.task("initialize")
		     .waitsFor(modified(ModelA.class))
		     .thenExecutes(inputs -> {
		    	 
				 System.out.println("Frontend");

		     });
		 */
	}

	@Override
	public void execute() {
		AppWrapperFx.onExit();
		
		// XXX: must queue exiting, as file writing is also queued
		//      and we want files to write before exiting
		Platform.runLater(() -> {
			NtroApp.exit(() -> {
			});
		});

	}

}
