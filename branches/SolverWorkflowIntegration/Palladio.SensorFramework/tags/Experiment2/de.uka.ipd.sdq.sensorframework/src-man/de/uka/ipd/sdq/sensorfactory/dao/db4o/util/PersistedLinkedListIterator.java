package de.uka.ipd.sdq.sensorfactory.dao.db4o.util;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import com.db4o.ObjectContainer;

import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;

public class PersistedLinkedListIterator<T extends IByteSerialisable> implements Iterator<T> {

	ListElement<byte[]> current = null;
	private ObjectContainer db;
	long pos = 0;
	private long size;
	private Class<T> myClass = null;
	private DataInputStream currentDataStream = null;
	private IDAOFactory dao;
	
	public PersistedLinkedListIterator(IDAOFactory dao, Class<T> myClass, long listsize, long headID, ObjectContainer db) {
		this.db = db;
		this.current = db.ext().getByID(headID);
		this.size = listsize;
		this.myClass = myClass;
		this.dao = dao;
		db.activate(current, 2);
	}

	public boolean hasNext() {
		return pos < size;
	}

	public T next() {
		if (pos % PersistedLinkedList.PAGESIZE == 0) {
			byte[] data = current.getData();
			current = current.getNext();
			if (current != null)
				db.activate(current, 2);
			currentDataStream = new DataInputStream( new ByteArrayInputStream(data) );
		}
		IByteSerialisable o = null;
		try {
			o = myClass.getConstructor(IDAOFactory.class).newInstance(dao);
			o.fromBytes(currentDataStream);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pos++;
		return (T) o;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
