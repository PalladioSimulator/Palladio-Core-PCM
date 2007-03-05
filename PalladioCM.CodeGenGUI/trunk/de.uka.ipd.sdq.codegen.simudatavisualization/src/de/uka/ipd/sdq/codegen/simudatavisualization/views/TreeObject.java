package de.uka.ipd.sdq.codegen.simudatavisualization.views;

import java.util.Collection;

import org.eclipse.core.runtime.IAdaptable;

import de.uka.ipd.sdq.codegen.simudatavisualization.views.TreeParent;

/**
 * The content provider class is responsible for providing objects to the view.
 * It can wrap existing objects in adapters or simply return objects as-is.
 * These objects may be sensitive to the current input of the view, or ignore it
 * and always show the same content (like Task List, for example).
 */
public class TreeObject implements IAdaptable {

	private String name;
	private Collection container;

	private TreeParent parent;

	public TreeObject(String name) {
		this.name = name;
	}
	
	public TreeObject(Collection container, String name) {
		this.name = name;
		this.container = container;
	}

	public String getName() {
		return name;
	}

	public void setParent(TreeParent parent) {
		this.parent = parent;
	}

	public TreeParent getParent() {
		return parent;
	}

	public String toString() {
		return getName();
	}

	public Collection getContainer() {
		return container;
	}
	
	public void setContainer(Collection container) {
		this.container = container;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}
}
