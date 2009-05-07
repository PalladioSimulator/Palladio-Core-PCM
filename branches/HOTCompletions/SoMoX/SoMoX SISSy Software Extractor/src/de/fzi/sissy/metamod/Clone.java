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

import java.util.Iterator;

/**
 * @author Mircea Trifu
 * @author stammel
 *
 */
public class Clone extends ModelElementImplementation implements ModelElement, ModelAnnotation {
	private Root root;
	private ModelElementList instances;
	
	public Clone() {
		super();
		instances = new ModelElementList();
	}

	/**
	 * Do not call this method directly. Use Root.addPackage instead.
	 */
	void setRoot(Root root) {
		this.root = root;
	}

	public Root getRoot() {
		return root;
	}

	public ModelElementList getInstances() {
		return instances;
	}

	public void setInstances(ModelElementList instances) {
		this.instances.clear();
		Iterator itr = instances.iterator();
		while(itr.hasNext()) {
			CloneInstance ci = (CloneInstance) itr.next();
			this.instances.addUnique(ci);
			ci.setClone(this);
		}
		
		this.instances = instances;
	}

	public void addCloneInstance(CloneInstance ci) {
		this.instances.addUnique(ci);
		ci.setClone(this);
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.ModelElement#getParent()
	 */
	public ModelElement getParent() {
		return root;
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.ModelElement#acceptVisitor(de.fzi.sissy.metamod.ModelVisitor)
	 */
	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitClone(this);
	}

	// TODO OK check destroy()
	void destroy() {
		super.destroy();
		instances.destroy();
		instances = null;
		root = null;
	}	
}
