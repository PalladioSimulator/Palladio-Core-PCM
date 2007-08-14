package de.uka.ipd.sdq.sensorfactory.dao.db4o.util;

import java.util.AbstractList;
import java.util.Iterator;

import com.db4o.ObjectContainer;

public class PersistedLinkedListAdapter<T extends IByteSerialisable> extends AbstractList<T> {

	private MyList delegate = null;

	public PersistedLinkedListAdapter(PersistedLinkedList persistedLinkedList) {
		delegate = persistedLinkedList;
	}

	public boolean add(T e) {
		return delegate.add(e);
	}

	public T get(int index) {
		return (T)delegate.get(index);
	}

	public Iterator iterator() {
		return delegate.iterator();
	}

	public int size() {
		return delegate.size();
	}
	
	
}
