package de.uka.ipd.sdq.probespec.framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Registry<T> implements Iterable<T> {

	private List<T> registeredItems;

	public Registry() {
		registeredItems = new ArrayList<T>();
	}

	public void register(T item) {
		registeredItems.add(item);
	}

	public void unregister(T item) {
		registeredItems.remove(item);
	}

	@Override
	public Iterator<T> iterator() {
		return registeredItems.iterator();
	}

}
