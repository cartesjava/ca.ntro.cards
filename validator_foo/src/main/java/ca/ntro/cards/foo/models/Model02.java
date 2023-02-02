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
package ca.ntro.cards.foo.models;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.cards.foo.models.FooModel;

public abstract class Model02 extends FooModel<Model02> {

	private static final long serialVersionUID = 4201588695860622481L;

	protected List<Object> source = new ArrayList<>();
	protected List<Object> destination = new ArrayList<>();

	public List<Object> getSource() {
		return source;
	}

	public void setSource(List<Object> source) {
		this.source = source;
	}

	public List<Object> getDestination() {
		return destination;
	}

	public void setDestination(List<Object> destination) {
		this.destination = destination;
	}

	@Override
	public void copyDataFrom(Model02 other) {
		this.source = other.source;
		this.destination = other.destination;
	}

}
