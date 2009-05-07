/**
 * 
 */
package de.uka.ipd.sdq.dialogs.stoex;

import de.uka.ipd.sdq.pcm.repository.impl.CollectionDataTypeImpl;

/**
 * @author roman
 * Container class for CollectionDataType with parent-object
 */
public class DataTypeContainer extends  CollectionDataTypeImpl{
	private Object parent;
	private Object object;

	public DataTypeContainer(Object object, Object parent) {
		this.parent = parent;
		this.object = object;
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
}
