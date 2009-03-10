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

/**
 * @author Mircea Trifu
 *
 */
public class GlobalVariable extends Variable implements Referenceable {
	private Root root;
	
	private Package surroundingPackage;

	public GlobalVariable(String name) {
		super(name);
	}

	/**
	 * Do not call this method directly. Use Root.addGlobalVariable instead.
	 * @param root - the Root node
	 */
	void setRoot(Root root) {
		this.root = root;
	}

	public Root getRoot() {
		return root;
	}

	// TODO OK check destroy()
	void destroy() {
		super.destroy();
		root = null;
		surroundingPackage = null;
	}

	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitGlobalVariable(this);
	}
	
	public ModelElement getParent() {
		if (surroundingPackage != null)
			return surroundingPackage;
		return getRoot();
	}

	public Package getSurroundingPackage() {
		return surroundingPackage;
	}

	//is called by Package.addGlobalVariable()
	public void setSurroundingPackage(Package package1) {
		surroundingPackage = package1;
	}

	public void moveToFile(File file) {
	    super.moveToFile(file);
	}
	
	public void moveToPackage(Package pack) {
		surroundingPackage.simpleRemoveGlobalVariable(this);
		pack.simpleAddGlobalVariable(this);
		setSurroundingPackage(pack);
	}
}
