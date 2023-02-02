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
package ca.ntro.cards.common.messages;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.messages.MessageNtro;
import ca.ntro.cards.common.frontend.views.CommonMessagesView;
import ca.ntro.cards.common.frontend.views.fragments.CommonMessageFragment;

public class MsgMessageToUser extends MessageNtro {
	
	private String resourceKey;

	public String getResourceKey() {
		return resourceKey;
	}

	public void setResourceKey(String resourceKey) {
		this.resourceKey = resourceKey;
	}

	public void displayOn(CommonMessagesView messageView , 
			              ViewLoader<? extends CommonMessageFragment> viewLoaderMessageFragment) {
		
		CommonMessageFragment messageFragment = viewLoaderMessageFragment.createView();
		
		messageFragment.displayMessageForResourceKey(resourceKey);
		
		messageView.addMessage(messageFragment);

	}
}
