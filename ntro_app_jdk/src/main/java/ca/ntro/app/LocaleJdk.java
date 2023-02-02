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
package ca.ntro.app;

import java.util.Locale;

public class LocaleJdk implements ca.ntro.app.Locale {
	
	private Locale locale;

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	
	public LocaleJdk() {
		Locale currentLocale = Locale.getDefault();
		setLocale(new Locale(currentLocale.getLanguage(), currentLocale.getCountry(), currentLocale.getVariant()));
	}

	
	public LocaleJdk(String language) {
		Locale currentLocale = Locale.getDefault();
		setLocale(new Locale(language, currentLocale.getCountry(), currentLocale.getVariant()));
	}

	public LocaleJdk(String language, String country) {
		Locale currentLocale = Locale.getDefault();
		setLocale(new Locale(language, country, currentLocale.getVariant()));
	}

	public LocaleJdk(String language, String country, String variant) {
		setLocale(new Locale(language, country, variant));
	}
	
	

	@Override
	public String toString() {
		return getLocale().toString();
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		return toString().equals(o.toString());
	}
	
	

}
