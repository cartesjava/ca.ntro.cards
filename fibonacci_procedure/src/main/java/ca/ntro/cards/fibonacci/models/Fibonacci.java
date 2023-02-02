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
package ca.ntro.cards.fibonacci.models;

import java.io.Serializable;

import ca.ntro.app.models.Value;
import ca.ntro.core.initialization.Ntro;

public class Fibonacci implements Value, Serializable {
	private static final long serialVersionUID = -4600983718989896732L;

	protected Fibonacci moinsUn;
	protected Fibonacci moinsDeux;

	protected int n;
	protected Long reponse;
	protected double nombreOr;

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public Fibonacci getMoinsUn() {
		return moinsUn;
	}

	public void setMoinsUn(Fibonacci moinsUn) {
		this.moinsUn = moinsUn;
	}

	public Fibonacci getMoinsDeux() {
		return moinsDeux;
	}

	public void setMoinsDeux(Fibonacci moinsDeux) {
		this.moinsDeux = moinsDeux;
	}

	public double getNombreOr() {
		return nombreOr;
	}

	public void setNombreOr(double nombreOr) {
		this.nombreOr = nombreOr;
	}
	
	public Long getReponse() {
		return reponse;
	}

	public void setReponse(Long reponse) {
		this.reponse = reponse;
	}

	public void construireGrapheRecursivement() {
	}

	public void calculerReponseEtNombreOr() {
	}

	public long calculerSommeRecursivement() {
		return 0;
	}

	public void copyDataFrom(Fibonacci other) {
		if(other.moinsUn != null
				&& other.moinsUn != other) {

			this.moinsUn = new Fibonacci();
			this.moinsUn.copyDataFrom(other.moinsUn);
			this.moinsDeux = this.moinsUn.moinsUn;

		}else {

			this.moinsUn = null;
			this.moinsDeux = null;
		}
		

		this.n = other.n;
		this.reponse = other.reponse;
		this.nombreOr = other.nombreOr;

	}

}
