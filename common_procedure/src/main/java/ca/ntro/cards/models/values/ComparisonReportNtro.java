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
package ca.ntro.cards.models.values;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.core.stream.Stream;
import ca.ntro.core.stream.StreamNtro;
import ca.ntro.core.stream.Visitor;

public class ComparisonReportNtro implements ComparisonReport {

	private static final long serialVersionUID = -349958575428922109L;
	
	private List<ErrorReport> errors = new ArrayList<>();

	@Override
	public boolean isSolution() {
		return errors.isEmpty();
	}

	@Override
	public Stream<ErrorReport> errors() {
		return new StreamNtro<ErrorReport>() {
			@Override
			public void forEach_(Visitor<ErrorReport> visitor) throws Throwable {
				for(ErrorReport error : errors) {
					visitor.visit(error);
				}
			}
		};
	}

	@Override
	public void addError(String message) {
		errors.add(new ErrorReportNtro(message));
	}

}
