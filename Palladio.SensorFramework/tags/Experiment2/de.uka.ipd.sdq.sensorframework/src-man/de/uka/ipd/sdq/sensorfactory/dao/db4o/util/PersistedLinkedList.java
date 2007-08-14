package de.uka.ipd.sdq.sensorfactory.dao.db4o.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Iterator;
import com.db4o.ObjectContainer;
import com.db4o.types.Db4oList;

import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;

public class PersistedLinkedList<T extends IByteSerialisable> implements
		MyList<T> {

	public static final int PAGESIZE = 10000;
	private int size = 0;
	private ListElement<byte[]> last = null;
	private long headID = -1;
	private transient ObjectContainer db;
	private transient DataOutputStream storageStream = null;
	private transient ByteArrayOutputStream backgroundStorageStream = null;
	private String classFQN;
	private IDAOFactory dao;

	public PersistedLinkedList(IDAOFactory dao, ObjectContainer db) {
		this.db = db;
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.sensorfactory.dao.db4o.util.MyList#objectOnActivate(com.db4o.ObjectContainer)
	 */
	public void objectOnActivate(com.db4o.ObjectContainer arg0) {
		this.db = arg0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.sensorfactory.dao.db4o.util.MyList#add(E)
	 */
	public boolean add(T e) {
		try {
			if (last == null) {
				last = new ListElement<byte[]>(null);
				backgroundStorageStream = new ByteArrayOutputStream(
						1000);
				storageStream = new DataOutputStream(backgroundStorageStream);
				e.toBytes(storageStream);
				db.ext().set(last, 2);
				headID = db.ext().getID(last);
				classFQN = e.getClass().getName();
			} else {
				if (size % PAGESIZE == 0) {
					flushList();
					ListElement<byte[]> oldLast = last;
					ListElement<byte[]> newElement = new ListElement<byte[]>(
							null);
					db.ext().set(newElement, 2);
					backgroundStorageStream = new ByteArrayOutputStream(
							1000);
					storageStream = new DataOutputStream(backgroundStorageStream);

					last.setNext(newElement);
					db.ext().set(last, 1);
					last = newElement;
					db.deactivate(oldLast, 1);
				}
				e.toBytes(storageStream);
			}
			size++;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return true;
	}

	public void flushList() {
		if (size > 0 && backgroundStorageStream != null) /* Workaround: backgroundStorageStream is null if the list was
			recovered from the database */
			last.setData(backgroundStorageStream.toByteArray());
		db.set(last);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.sensorfactory.dao.db4o.util.MyList#get(int)
	 */
	public T get(int index) {
		Iterator it = this.iterator();
		for (int i = 0; i < index; i++)
			it.next();
		return (T) it.next();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.sensorfactory.dao.db4o.util.MyList#size()
	 */
	public int size() {
		return size;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.sensorfactory.dao.db4o.util.MyList#iterator()
	 */
	public Iterator<T> iterator() {
		try {
			return new PersistedLinkedListIterator<T>(
					dao,(Class<T>)Class.forName(classFQN),
					size, headID, db);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.sensorfactory.dao.db4o.util.MyList#getLast()
	 */
	public Object getLast() {
		return last;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.sensorfactory.dao.db4o.util.MyList#getHeadID()
	 */
	public long getHeadID() {
		return headID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.sensorfactory.dao.db4o.util.MyList#setHeadID(long)
	 */
	public void setHeadID(long long1) {
		this.headID = long1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.sensorfactory.dao.db4o.util.MyList#setLast(de.uka.ipd.sdq.sensorfactory.dao.db4o.util.ListElement)
	 */
	public void setLast(ListElement listElement) {
		this.last = listElement;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.sensorfactory.dao.db4o.util.MyList#getLastID()
	 */
	public long getLastID() {
		return db.ext().getID(last);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.sensorfactory.dao.db4o.util.MyList#setLast(long)
	 */
	public void setLast(long readLong) {
		last = db.ext().getByID(readLong);
	}

	public void setDAOFactory(IDAOFactory myDAOFactory) {
		this.dao = myDAOFactory;
	}
}
