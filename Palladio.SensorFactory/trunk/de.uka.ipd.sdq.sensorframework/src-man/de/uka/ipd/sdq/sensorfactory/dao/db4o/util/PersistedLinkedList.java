package de.uka.ipd.sdq.sensorfactory.dao.db4o.util;

import java.util.AbstractList;
import java.util.Iterator;
import com.db4o.ObjectContainer;
import com.db4o.types.Db4oList;

public class PersistedLinkedList implements MyList {

	private int size = 0;
	private ListElement last = null;
	private long headID = -1;
	private transient ObjectContainer db;
	
	public PersistedLinkedList(ObjectContainer db) {
		this.db = db;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.dao.db4o.util.MyList#objectOnActivate(com.db4o.ObjectContainer)
	 */
	public void objectOnActivate(com.db4o.ObjectContainer arg0) {
		this.db = arg0;
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.dao.db4o.util.MyList#add(E)
	 */
	public boolean add(Object e) {
		if (last == null) {
			last = new ListElement(e);
			db.ext().set(last,2);
			headID = db.ext().getID(last);
		} else {
			ListElement oldLast = last;
			ListElement newElement = new ListElement(e);
			db.ext().set(newElement,2);
			
			last.setNext(newElement);
			db.ext().set(last,1);
			last = newElement;
			db.deactivate(oldLast, 1);
			// db.ext().purge(oldLast);
		} 
		size++;
		return true;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.dao.db4o.util.MyList#get(int)
	 */
	public Object get(int index) {
		Iterator it = this.iterator();
		for (int i=0; i<index; i++)
			it.next();
		return it.next();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.dao.db4o.util.MyList#size()
	 */
	public int size() {
		return size;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.dao.db4o.util.MyList#iterator()
	 */
	public Iterator iterator() {
		return new PersistedLinkedListIterator(headID,db);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.dao.db4o.util.MyList#getLast()
	 */
	public Object getLast() {
		return last;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.dao.db4o.util.MyList#getHeadID()
	 */
	public long getHeadID() {
		return headID;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.dao.db4o.util.MyList#setHeadID(long)
	 */
	public void setHeadID(long long1) {
		this.headID = long1;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.dao.db4o.util.MyList#setLast(de.uka.ipd.sdq.sensorfactory.dao.db4o.util.ListElement)
	 */
	public void setLast(ListElement listElement) {
		this.last = listElement;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.dao.db4o.util.MyList#getLastID()
	 */
	public long getLastID() {
		return db.ext().getID(last);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.dao.db4o.util.MyList#setLast(long)
	 */
	public void setLast(long readLong) {
		last = db.ext().getByID(readLong);
	}
}
