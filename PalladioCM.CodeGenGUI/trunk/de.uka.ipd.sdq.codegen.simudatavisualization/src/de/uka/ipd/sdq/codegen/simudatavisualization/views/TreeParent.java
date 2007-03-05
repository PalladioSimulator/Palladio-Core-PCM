package de.uka.ipd.sdq.codegen.simudatavisualization.views;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author admin
 *
 */
public class TreeParent extends TreeObject {

	private Collection children;
	
	public TreeParent(String name) {
		super(name);
		children = new ArrayList();
	}
	
	public TreeParent(String name, Collection children) {
		super(name);
		this.children = children;
	}
	
	public void addChild(TreeObject child) {
		children.add(child);
		child.setParent(this);
	}
	
	public void removeChild(TreeObject child) {
		children.remove(child);
		child.setParent(null);
	}
	
	public TreeObject [] getChildren() {
		return (TreeObject [])children.toArray(new TreeObject[children.size()]);
	}
	
	public boolean hasChildren() {
		return children.size()>0;
	}
}
