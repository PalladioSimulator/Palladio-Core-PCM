/**
 * Copyright (c) 2004-2006 FZI Forschungszentrum Informatik, 
 * 10-14 Haid-und-Neu Street, 76131 Karlsruhe, Germany
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package de.fzi.sissy.metamod;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Mircea Trifu
 *
 */
public class ModelAnnotationList implements Collection, Serializable {
	private ArrayList list;
	
	public ModelAnnotationList() {
		list = new ArrayList();
	}

	public boolean addUnique(Object obj) {
		if (!list.contains(obj))
			return list.add(obj);
		return false;
	}
	
	public boolean add(Object obj) {
		return list.add(obj);
	}
	
	public boolean addAll(Collection anotherList) {
		return list.addAll(anotherList);
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#size()
	 */
	public int size() {
		return list.size();
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#isEmpty()
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#contains(java.lang.Object)
	 */
	public boolean contains(Object arg0) {
		return list.contains(arg0);
	}

	public Iterator iterator() {
		return list.iterator();
	}
	
	/* (non-Javadoc)
	 * @see java.util.Collection#toArray()
	 */
	public Object[] toArray() {
		return list.toArray();
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#toArray(java.lang.Object[])
	 */
	public Object[] toArray(Object[] arg0) {
		return list.toArray(arg0);
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#remove(java.lang.Object)
	 */
	public boolean remove(Object arg0) {
		return list.remove(arg0);
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#containsAll(java.util.Collection)
	 */
	public boolean containsAll(Collection arg0) {
		return list.containsAll(arg0);
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#removeAll(java.util.Collection)
	 */
	public boolean removeAll(Collection arg0) {
		return list.removeAll(arg0);
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#retainAll(java.util.Collection)
	 */
	public boolean retainAll(Collection arg0) {
		return list.retainAll(arg0);
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#clear()
	 */
	public void clear() {
		list.clear();
	}
	
	public Object clone() {
		ModelAnnotationList res = new ModelAnnotationList();
		res.list = (ArrayList)list.clone();
		return res;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof ModelElementList)
			return list.equals(((ModelAnnotationList)obj).list);
		return false;
	}
	
	public int hashCode() {
		return list.hashCode();	
	}
	
	public String toString() {
		return list.toString();
	}

	// TODO OK check destroy()
	void destroy() {
		list.clear();
		list = null;
	}
}
