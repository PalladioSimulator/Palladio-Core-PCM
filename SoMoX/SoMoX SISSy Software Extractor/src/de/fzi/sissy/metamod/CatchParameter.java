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
public class CatchParameter extends Variable implements Referenceable {
	private Function surroundingFunction;
	private boolean pRethrown;
	private CatchBlock catchBlock;

	public CatchParameter(String name) {
		super(name);
		pRethrown = false;
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
		catchBlock = null;
	}

	public void acceptVisitor(ModelVisitor visitor) {
		visitor.visitCatchParameter(this);
	}
	
	public ModelElement getParent() {
		if (getCatchBlock() != null)
			return getCatchBlock();
		return getSurroundingFunction();
	}

	public boolean isRethrown() {
		return pRethrown;
	}

	public void setRethrown(boolean rethrown) {
		pRethrown = rethrown;
	}

	public CatchBlock getCatchBlock() {
		return catchBlock;
	}

	// set by CatchBlock.setCatchParameter(...)
	public void setCatchBlock(CatchBlock block) {
		catchBlock = block;
		if (catchBlock != null)
			setSurroundingFunction(catchBlock.getSurroundingFunction());
	}

}
