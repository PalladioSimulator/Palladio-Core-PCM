package de.uka.ipd.sdq.sensorfactory.dao.db4o.util;

import java.util.Iterator;

public interface MyList<E extends IByteSerialisable> {

	public abstract void objectOnActivate(com.db4o.ObjectContainer arg0);

	public abstract boolean add(E e);

	public abstract E get(int index);

	public abstract int size();

	public abstract Iterator<E> iterator();

	public abstract Object getLast();

	public abstract long getHeadID();

	public abstract void setHeadID(long long1);

	public abstract void setLast(ListElement listElement);

	public abstract long getLastID();

	public abstract void setLast(long readLong);

	public abstract void flushList();

}