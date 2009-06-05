package de.uka.ipd.sdq.pcmbench.navigator;

import org.eclipse.core.resources.IProject;

public class LinkedRepositoriesNode
{
	private IProject parent;

	/**
	 * @return the parent
	 */
	public IProject getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(IProject parent) {
		this.parent = parent;
	}
	
	public LinkedRepositoriesNode(IProject parent)
	{
		this.parent = parent;
	}
}