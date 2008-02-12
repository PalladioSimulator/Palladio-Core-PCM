package de.uka.ipd.sdq.sensorframework.dao.db4o.util;

import java.util.AbstractList;
import java.util.Iterator;

public class PersistedLinkedListAdapter<T extends IByteSerialisable> extends AbstractList<T> {

	private MyList delegate = null;

	public PersistedLinkedListAdapter(PersistedLinkedList persistedLinkedList) {
		delegate = persistedLinkedList;
	}

	@Override
	public boolean add(T e) {
		return delegate.add(e);
	}

	@Override
	public T get(int index) {
		return (T)delegate.get(index);
	}

	@Override
	public Iterator iterator() {
		return delegate.iterator();
	}

	@Override
	public int size() {
		return delegate.size();
	}
	
	
}
