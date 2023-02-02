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
package ca.ntro.core.json;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.bson.Document;
import org.bson.json.JsonWriterSettings;

public class JsonObjectJdk implements JsonObject {
	
	private Document document;

	public JsonObjectJdk(String jsonString) {
		document = Document.parse(jsonString);
	}

	public JsonObjectJdk() {
		document = new Document();
	}

	@Override
	public String toJsonString(boolean prettyPrint) {
		JsonWriterSettings settings = JsonWriterSettings.builder().indent(prettyPrint).build();

		return document.toJson(settings);
	}

	@Override
	public int size() {
		return document.size();
	}

	@Override
	public boolean isEmpty() {
		return document.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return document.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return document.containsValue(value);
	}

	@Override
	public Object get(Object key) {
		return document.get(key);
	}

	@Override
	public Object put(String key, Object value) {
		return document.put(key, value);
	}

	@Override
	public Object remove(Object key) {
		return document.remove(key);
	}

	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {
		document.putAll(m);
	}

	@Override
	public void clear() {
		document.clear();
	}

	@Override
	public Set<String> keySet() {
		return document.keySet();
	}

	@Override
	public Collection<Object> values() {
		return document.values();
	}

	@Override
	public Set<Entry<String, Object>> entrySet() {
		return document.entrySet();
	}

	@Override
	public String toJsonString() {
		return toJsonString(true);
	}

}
