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

import java.io.Serializable;

import ca.ntro.app.models.Value;

public abstract class Command<C extends Comparable<C>> implements Value, Serializable {
	
	public abstract boolean isClear();
	public abstract boolean isDelete();
	public abstract boolean isInsert();
	public abstract boolean isAdd();
	public abstract boolean isGet();

	public abstract AddCommand<C> add();
	public abstract ClearCommand clear();
	public abstract DeleteCommand delete();
	public abstract GetCommand<C> get();
	public abstract InsertCommand<C> insert();


}
