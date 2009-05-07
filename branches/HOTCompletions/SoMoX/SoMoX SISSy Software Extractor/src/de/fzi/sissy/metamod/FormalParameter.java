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
public class FormalParameter extends Variable implements Referenceable {
	private Function surroundingFunction;

	private boolean pPassedByReference;

	public FormalParameter(String name) {
		super(name);

		//default ist PassedByValue
		this.pPassedByReference = false;
	}

	/**
	 * Do not call this method directly. Use Function.addFormalParameter instead.
	 */
	void setSurroundingFunction(Function surroundingFunction) {
		this.surroundingFunction = surroundingFunction;
	}

	public Function getSurroundingFunction() {
		return surroundingFunction;
	}	

	public Class getSurroundingClass() {
		if (surroundingFunction instanceof Member)
			return ((Member)surroundingFunction).getSurroundingClass();
		return null;
	}

	// TODO OK check destroy()
	void destroy() {
		super.destroy();
		surroundingFunction = null;
	}

	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitFormalParameter(this);
	}
	
	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.ModelElement#getParent()
	 */
	public ModelElement getParent() {
		return getSurroundingFunction();
	}

	public void setPassedByReference() {
		this.pPassedByReference = true;
	}
	
	public void setPassedByValue() {
		this.pPassedByReference = false;
	}


	public boolean isPassedByReference() {
		return this.pPassedByReference;
	}
	
	public boolean isPassedByValue() {
		return !this.pPassedByReference;
	}

	public void togglePassedByReference() {
		pPassedByReference = !pPassedByReference;    
	}
}
