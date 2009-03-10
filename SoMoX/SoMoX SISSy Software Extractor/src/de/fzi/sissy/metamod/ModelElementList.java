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

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Mircea Trifu
 *
 */
public class ModelElementList implements Collection, Cloneable, Externalizable {
	private transient ArrayList list;
	private transient ModelElementRepository mer;
	private ArrayList idList = null;
	
	public ModelElementList() {
		setList(new ArrayList());
	}
    
    public ModelElementList(Collection coll) {
        setList(new ArrayList());
        addAll(coll);
    }

	private void setList(ArrayList list) {
		this.list = list;
	}

	private ArrayList getList() {
		if (idList != null) {
			list = new ArrayList();
			Iterator it = idList.iterator();
			while (it.hasNext()) {
				int elementId = ((Integer)it.next()).intValue();
				list.add(mer.getModelElementById(elementId));
			}
			idList.clear();
			idList = null;
			mer = null;
		}
		return list;
	}

	public boolean addUnique(Object obj) {
		if (!getList().contains(obj))
			return getList().add(obj);
		return false;
	}
	
	public boolean add(Object obj) {
		return getList().add(obj);
	}
	
	public void add(int index, Object obj) {
		getList().add(index, obj);
	}
	
	public void addUnique(int index, Object obj) {
	    if (!getList().contains(obj))
			getList().add(index, obj);
	}
	
	public boolean addAll(Collection newList) {
		return getList().addAll(newList);
	}

	public Object get(int index) {
		return getList().get(index);
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#size()
	 */
	public int size() {
		return getList().size();
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#isEmpty()
	 */
	public boolean isEmpty() {
		return getList().isEmpty();
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#contains(java.lang.Object)
	 */
	public boolean contains(Object arg0) {
		return getList().contains(arg0);
	}

	public Iterator iterator() {
		return getList().iterator();
	}
	
	/* (non-Javadoc)
	 * @see java.util.Collection#toArray()
	 */
	public Object[] toArray() {
		return getList().toArray();
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#toArray(java.lang.Object[])
	 */
	public Object[] toArray(Object[] arg0) {
		return getList().toArray(arg0);
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#remove(java.lang.Object)
	 */
	public boolean remove(Object arg0) {
		return getList().remove(arg0);
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#containsAll(java.util.Collection)
	 */
	public boolean containsAll(Collection arg0) {
		return getList().containsAll(arg0);
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#removeAll(java.util.Collection)
	 */
	public boolean removeAll(Collection arg0) {
		return getList().removeAll(arg0);
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#retainAll(java.util.Collection)
	 */
	public boolean retainAll(Collection arg0) {
		return getList().retainAll(arg0);
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#clear()
	 */
	public void clear() {
		getList().clear();
	}
	
	public Object clone() {
		ModelElementList res = new ModelElementList();
		res.setList((ArrayList)getList().clone());
		return res;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof ModelElementList)
			return getList().equals(((ModelElementList)obj).getList());
		return false;
	}
	
	public int hashCode() {
		return getList().hashCode();	
	}
	
	public String toString() {
		return getList().toString();
	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
	 */
	public void writeExternal(ObjectOutput out) throws IOException {
		Iterator it = getList().iterator();
		idList = new ArrayList();
		while (it.hasNext()) {
			idList.add(new Integer(((ModelElement)it.next()).getUniqueId()));
		}
		out.writeObject(idList);
		idList = null;		
	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
	 */
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		idList = (ArrayList)in.readObject();
		mer = ModelElementRepository.getWorkingRepository();		
	}

	// TODO check destroy() - etwas anzupassen bzgl. idList oder mer ??
	void destroy() {
		getList().clear();
		setList(null);
	}
	
	public ModelElementList filter(String clsName) {
		ModelElementList result = new ModelElementList();
		try {
			java.lang.Class cls = java.lang.Class.forName(clsName);
			Iterator it = getList().iterator();
			while (it.hasNext()) {
				ModelElement elem = (ModelElement)it.next();
				if (cls.isInstance(elem))
					result.add(elem);
			}
		} catch (ClassNotFoundException ex) {}
		return result;
	}

	public int indexOf(Object obj) {
	    return getList().indexOf(obj);
	}
	
	public void replaceObject(Object oldObject, Object newObject) {
	    if (indexOf(oldObject) == -1)
	        return;
	    getList().set(indexOf(oldObject), newObject);
	}
	
	public ModelElement findByName(String name) {
		Iterator it = getList().iterator();
		while (it.hasNext()) {
			Object o = it.next();
			if(o instanceof NamedModelElement)
			{
				if(((NamedModelElement)o).getSimpleName().equals(name)) return (ModelElement)o;
			}
		}
		return null;		
	}
}
