package de.uka.ipd.sdq.sensorfactory.dao.db4o.util;

import java.util.Iterator;

import com.db4o.ObjectContainer;

public class PersistedLinkedListIterator<T> implements Iterator<T> {

	ListElement<T> current = null;
	private ObjectContainer db;
	
	public PersistedLinkedListIterator(long headID, ObjectContainer db) {
		this.db = db;
		this.current = db.ext().getByID(headID);
		db.activate(current, 2);
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public T next() {
		T data = current.getData();
		current = current.getNext();
		if (current != null)
			db.activate(current, 2);
		return data;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
