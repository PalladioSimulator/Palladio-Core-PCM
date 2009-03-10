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
public class JumpStatement extends Statement {

	private boolean pJump, pThrow, pReturn;
	
	public JumpStatement() {
		super();
	}

	public void setJump() {
		pJump = true;
		pThrow = false;
		pReturn = false;		
	}
	
	public void setThrow() {
		pJump = false;
		pThrow = true;
		pReturn = false;		
	}

	public void setReturn() {
		pJump = false;
		pThrow = false;
		pReturn = true;		
	}

	public boolean isJump() {
		return pJump;		
	}
	
	public boolean isThrow() {
		return pThrow;		
	}

	public boolean isReturn() {
		return pReturn;		
	}

	public int getMaximumNestingLevel() {
		return 0;
	}

	public int getNumberOfStatements() {
		return 1;
	}

	public int getNumberOfEdgesInCFG() {
		return 1;
	}

	public int getNumberOfNodesInCFG() {
		return 1;
	}

	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Statement#getStatementPosition(de.fzi.sissy.metamod.Statement)
	 */
	public int getStatementPosition(Statement st) {
		if ((st == this) && (getContainer() != null))
			return getContainer().getStatementPosition(this);
		return -1;
	}
}
