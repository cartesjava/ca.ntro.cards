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
package ca.ntro.core.stream;

import java.util.List;
import java.util.Map;
import java.util.Set;

import ca.ntro.core.wrappers.result.Result;
import ca.ntro.core.wrappers.result.ResultNtro;

public interface Stream<I extends Object> {
	
	boolean isEmpty();

	int size();

	I get(int index);

	boolean ifAll(Matcher<I> matcher);

	boolean ifSome(Matcher<I> matcher);

	boolean ifNone(Matcher<I> matcher);

	void forEach(Visitor<I> visitor);

	void forEach_(Visitor<I> visitor) throws Throwable;
	
	I findFirst(Matcher<I> matcher);

	Stream<I> findAll(Matcher<I> matcher);

	Stream<I> append(Stream<I> other);

	<R> Stream<R> map(Mapper<I,R> mapper);

	List<I> collect();

	<R> Result<R> reduceToResult(R initialValue, ResultReducer<I,R> reducer);

	<R> Stream<R> reduceToStream(StreamReducer<I,R> reducer);

	<R> void applyReducer(ResultNtro<R> result, Reducer<I,R> reducer);
	
	public static <V extends Object> Stream<V> forSet(Set<V> set){
		// JSWeet: explicit class to avoid type errors
		return new StreamForSet<V>(set);
	}

	static <V> Stream<V> forMapValues(Map<?, V> map) {
		// JSWeet: explicit class to avoid type errors
		return new StreamForMapValues<V>(map);
	}

	static <K> Stream<K> forMapKeys(Map<K, ?> map) {
		// JSWeet: explicit class to avoid type errors
		return new StreamForMapKeys<K>(map);
	}

	static <O> Stream<O> fromList(List<O> list) {
		return new StreamNtro<O>() {
			@Override
			public void forEach_(Visitor<O> visitor) throws Throwable {
				for(O item : list) {
					visitor.visit(item);
				}
			}
		};
	}

}
