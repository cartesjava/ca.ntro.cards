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
package ca.ntro.cards.cartesjava.models;

import java.util.HashMap;
import java.util.Map;

public class DonneesJson extends CartesJavaModel<DonneesJson> {

	private static final long serialVersionUID = 8295201566647831760L;

	protected Map<String, Object> racine = new HashMap<>();

	public Map<String, Object> getRacine() {
		return racine;
	}

	public void setRacine(Map<String, Object> racine) {
		this.racine = racine;
	}

	@Override
	public void copyDataFrom(DonneesJson other) {
		this.racine = other.racine;
	}

}
