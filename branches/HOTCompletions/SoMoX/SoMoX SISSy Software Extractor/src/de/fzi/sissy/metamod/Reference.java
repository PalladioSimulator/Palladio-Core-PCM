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
 * @author stammel
 *
 */
public class Reference extends TypeDecoratorImplementation implements Referenceable {

	private boolean pExplicit;

	/**
	 * @param decoratedType
	 * @param name
	 */
	public Reference(Type referencedType, String name) {
		super(referencedType, name);
		setReferenceType();
		//default: implicit
		this.pExplicit = false;
	}

	public ModelElement getParent() {
		return this.getRoot();
	}

	public void acceptVisitor(ModelVisitor visitor) {
	    visitor.visitReference(this);
	}

	public boolean isExplicit() {
		return this.pExplicit;
	}

	public boolean isImplicit() {
		return !this.pExplicit;
	}

	public void setExplicit() {
		this.pExplicit = true;
	}

	public void setImplicit() {
		this.pExplicit = false;
	}

	public Type getReferencedType() {
		return this.getDecoratedType();
	}
	
	// TODO OK check destroy()
	public void destroy() {
		super.destroy();
	}

	public void toggleExplicit() {
		pExplicit = !pExplicit;
	}
}
