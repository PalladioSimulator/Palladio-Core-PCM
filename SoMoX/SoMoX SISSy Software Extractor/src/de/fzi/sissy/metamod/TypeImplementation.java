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
abstract class TypeImplementation extends ReferenceableImplementation implements Type {
	private Root root;
	private boolean pReferenceType;
	private Package surroundingPackage;
	
	public TypeImplementation(String name) {
		super(name);
		//default: ValueType
		pReferenceType = false;
	}

	public void setSurroundingPackage(Package pack) {
	    surroundingPackage = pack;
	}
	
	public Package getSurroundingPackage() {
	    return surroundingPackage;
	}
	
	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Type#getQualifiedName()
	 */
	public String getQualifiedName() {
		return getSimpleName();
	}
	
	/**
	 * Do not call this method directly. Use Root.addType instead.
	 * @param root - the Root node
	 */
	public void setRoot(Root root) {
		this.root = root;
	}

	public Root getRoot() {
		return root;
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Type#isReferenceType()
	 */
	public boolean isReferenceType() {
		return pReferenceType;
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Type#isReferenceType()
	 */
	public void setReferenceType() {
		pReferenceType = true;
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Type#isValueType()
	 */
	public boolean isValueType() {
		return !pReferenceType;
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Type#isValueType()
	 */
	public void setValueType() {
		pReferenceType = false;
	}

	// TODO OK check destroy()
	void destroy() {
		super.destroy();
		root = null;
		surroundingPackage = null;
	}
	
	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitType(this);
	}

	public void toggleReferenceType() {
		pReferenceType = !pReferenceType;
	}


}
