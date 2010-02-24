package de.uka.ipd.sdq.dialogs.stoex;

import de.uka.ipd.sdq.pcm.repository.impl.InnerDeclarationImpl;

/**
 * @author roman
 * Container class for InnerDeclaration with parent object
 */
public class InnerDeclarationContainer extends InnerDeclarationImpl{
	
	private Object parent;
	private Object object;

	public InnerDeclarationContainer(Object object, Object parent) {
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