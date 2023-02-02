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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.ntro.core.reflection.object_graph.Initialize;

public abstract class Model01 extends FooModel<Model01> implements Initialize {

	private static final long serialVersionUID = 8295201566647831760L;

	protected List<Object> maListe = new ArrayList<>();
	
	protected Map<String, Object> monMap = new HashMap<>();

	public List<Object> getMaListe() {
		return maListe;
	}

	public void setMaListe(List<Object> maListe) {
		this.maListe = maListe;
	}

	public Map<String, Object> getMonMap() {
		return monMap;
	}

	public void setMonMap(Map<String, Object> monMap) {
		this.monMap = monMap;
	}

	@Override
	public void copyDataFrom(Model01 other) {
		this.maListe = other.maListe;
		this.monMap = other.monMap;
	}

}
