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

import ca.ntro.app.tasks.SubTasksLambda;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.cards.common.frontend.events.EvtQuit;
import ca.ntro.cards.common.frontend.views.CommonMessagesView;
import ca.ntro.cards.common.frontend.views.CommonSettingsView;
import ca.ntro.cards.common.frontend.views.fragments.CommonMessageFragment;
import ca.ntro.cards.common.messages.MsgMessageToUser;
import ca.ntro.cards.common.models.CommonSettingsModel;
import ca.ntro.core.reflection.observer.Modified;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.ViewLoader;

public class Messages {

	public static <MESSAGES_VIEW extends CommonMessagesView,
	               MESSAGE_FRAGMENT extends CommonMessageFragment> 
	
	       void createTasks(FrontendTasks tasks,
	    		            Class<MESSAGES_VIEW> messagesViewClass,
	    		            Class<MESSAGE_FRAGMENT> messageFragmentClass,
	    		            SubTasksLambda<FrontendTasks> subTasksLambda) {

		tasks.taskGroup("Messages")
		
		     .waitsFor("Initialization")

		     .andContains(subTasks -> {
		    	 
		    	 displayMessageToUser(subTasks, messagesViewClass, messageFragmentClass);
		    	 
		    	 subTasksLambda.createSubTasks(subTasks);

		     });
	}

	public static <MESSAGES_VIEW extends CommonMessagesView,
	               MESSAGE_FRAGMENT extends CommonMessageFragment> 
	
	       void displayMessageToUser(FrontendTasks tasks,
	    		                     Class<MESSAGES_VIEW> messagesViewClass,
	    		                     Class<MESSAGE_FRAGMENT> messageFragmentClass) {

		tasks.task("displayMessageToUser")
		
		     .waitsFor(viewLoader(messageFragmentClass))

		     .waitsFor(message(MsgMessageToUser.class))
		     
		     .thenExecutes(inputs -> {
		    	 
		    	 MESSAGES_VIEW                messageView               = inputs.get(created(messagesViewClass));
		    	 MsgMessageToUser             msgMessageToUser          = inputs.get(message(MsgMessageToUser.class));
		    	 ViewLoader<MESSAGE_FRAGMENT> viewLoaderMessageFragment = inputs.get(viewLoader(messageFragmentClass));
		    	 
		    	 msgMessageToUser.displayOn(messageView, viewLoaderMessageFragment);

		     });

	}
}
