package ca.ntro.cards.shift2.models;

import java.util.HashMap;

public class NtroHashMap<K extends Object, V extends Object> extends HashMap<K,V> {

	private static final long serialVersionUID = 3892568467564928066L;
	
	@Override
	public int hashCode() {
		return System.identityHashCode(this);
	}

}
