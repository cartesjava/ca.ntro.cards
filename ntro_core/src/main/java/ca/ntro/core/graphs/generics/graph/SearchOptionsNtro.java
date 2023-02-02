/*
Copyright (C) (2020) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)

This file is part of Ntro, an application framework designed with teaching in mind.

This is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

*/
package ca.ntro.core.graphs.generics.graph;

public class      SearchOptionsNtro

       implements SearchOptions {
	
	private InternalSearchOptionsNtro internalSearchOptions = new InternalSearchOptionsNtro();

	public InternalSearchOptionsNtro getInternalSearchOptions() {
		return internalSearchOptions;
	}

	public void setInternalSearchOptions(InternalSearchOptionsNtro internalSearchOptions) {
		this.internalSearchOptions = internalSearchOptions;
	}

	public SearchOptionsNtro() {
	}

	public SearchOptionsNtro(InternalSearchOptions options) {
			setInternalSearchOptions(new InternalSearchOptionsNtro());
			copyOptions(options);
	}

	@Override
	public void setSearchStrategy(SearchStrategy searchStrategy) {
		getInternalSearchOptions().setSearchStrategy(searchStrategy);
	}

	@Override
	public void setMaxDistance(int maxDistance) {
		getInternalSearchOptions().setMaxDistance(maxDistance);
	}

	@Override
	public void setSortEdgesByName(boolean sortEdgesByName) {
		getInternalSearchOptions().setSortEdgesByName(sortEdgesByName);
	}

	@Override
	public void copyOptions(InternalSearchOptions searchOptions) {
		getInternalSearchOptions().copyOptions(searchOptions);
	}

	@Override
	public InternalSearchOptionsNtro internal() {
		return getInternalSearchOptions();
	}
}
