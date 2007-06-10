package de.uka.ipd.sdq.sensorfactory.dao.db4o.util;

import java.util.AbstractList;
import java.util.Iterator;

import com.db4o.ObjectContainer;

public class PersistedLinkedListAdapter extends AbstractList {

	private MyList delegate = null;

	public PersistedLinkedListAdapter(PersistedLinkedList persistedLinkedList) {
		delegate = persistedLinkedList;
	}

	public boolean add(Object e) {
		return delegate.add(e);
	}

	public Object get(int index) {
		return delegate.get(index);
	}

	public Iterator iterator() {
		return delegate.iterator();
	}

	public int size() {
		return delegate.size();
	}
	
	
}
