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
package ca.ntro.cards.foo;

import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.cards.foo.backend.FooGeneratorBackend;
import ca.ntro.cards.foo.models.FooModel;
import ca.ntro.cards.validator.GeneratorApp;
import ca.ntro.cards.validator.backend.GeneratorBackend;

public abstract class GenererFoo extends GeneratorApp<FooModel> {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class<? extends GeneratorBackend> backendClass() {
		return FooGeneratorBackend.class;
	}

	@Override
	protected void registerAdditonalModels(ModelRegistrar registrar) {
	}


}
