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
package ca.ntro.cards.common.commands;

import ca.ntro.cards.common.models.values.cards.Carte;

public class AddCommand<C extends Comparable<C>> extends ValueCommand<C> {

	public AddCommand(Carte card) {
		super(card);
	}

	@Override
	public boolean isClear() {
		return false;
	}

	@Override
	public boolean isDelete() {
		return false;
	}

	@Override
	public boolean isInsert() {
		return false;
	}

	@Override
	public boolean isAdd() {
		return true;
	}

	@Override
	public boolean isGet() {
		return false;
	}

	@Override
	public AddCommand<C> add() {
		return this;
	}

	@Override
	public ClearCommand clear() {
		throw new RuntimeException("[FATAL] command is not a ClearCommand");
	}

	@Override
	public DeleteCommand delete() {
		throw new RuntimeException("[FATAL] command is not a DeleteCommand");
	}

	@Override
	public GetCommand<C> get() {
		throw new RuntimeException("[FATAL] command is not a GetCommand");
	}

	@Override
	public InsertCommand<C >insert() {
		throw new RuntimeException("[FATAL] command is not an InsertCommand");
	}

}
