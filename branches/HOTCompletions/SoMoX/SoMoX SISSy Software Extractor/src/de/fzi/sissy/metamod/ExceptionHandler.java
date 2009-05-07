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
public class ExceptionHandler extends Statement {

	private BlockStatement guardedBlock;
	private BlockStatement finallyBlock;
	private ModelElementList catchBlocks;
	
	public ExceptionHandler() {
		super();
		catchBlocks = new ModelElementList();
	}
	
	public ModelElementList getCatchBlocks() {
		return catchBlocks; 
	}

	public void setCatchBlocks(ModelElementList catchBlocks) {
		this.catchBlocks = catchBlocks; 
		Iterator itr = catchBlocks.iterator();
		while (itr.hasNext()) {
			CatchBlock catchBlock = (CatchBlock)itr.next();
			catchBlock.setContainer(this);
		}
	}

	public void addCatchBlock(CatchBlock catchBlock) {
		this.catchBlocks.addUnique(catchBlock); 
		catchBlock.setContainer(this);
	}
	
	public BlockStatement getFinallyBlock() {
		return finallyBlock;
	}

	public void setFinallyBlock(BlockStatement statement) {
		finallyBlock = statement;
		statement.setContainer(this);
	}

	public BlockStatement getGuardedBlock() {
		return guardedBlock;
	}

	public void setGuardedBlock(BlockStatement statement) {
		guardedBlock = statement;
		statement.setContainer(this);
	}
	
	// TODO OK check destroy()
	void destroy() {
		super.destroy();
		catchBlocks.destroy();
		catchBlocks = null;
		guardedBlock = null;
		finallyBlock = null;
	}

	public void changeGuardedBlock(BlockStatement blockStatement) {
		this.setGuardedBlock(blockStatement);
		blockStatement.setContainer(this);
	}

	public void changeFinallyBlock(BlockStatement blockStatement) {
		this.setFinallyBlock(blockStatement);
		blockStatement.setContainer(this);
	}
	
	public void removeCatchBlock(CatchBlock catchBlock) {
		catchBlocks.remove(catchBlock);
	    ModelElementRepository.getWorkingRepository().removeElement(catchBlock);
	}

	public int getMaximumNestingLevel() {
		Iterator cb_itr = catchBlocks.iterator();
		
		int maxMNL = 0;
		
		while(cb_itr.hasNext()) {
			CatchBlock cb = (CatchBlock)cb_itr.next();
			
			int cbMNL = cb.getMaximumNestingLevel();
			
			if (cbMNL > maxMNL)
				maxMNL = cbMNL;
		}
		
		if (finallyBlock != null) {
			int fMNL = finallyBlock.getMaximumNestingLevel();
			if (fMNL > maxMNL)
				maxMNL = fMNL;
		}

		int gMNL = 0;
		if (guardedBlock != null)
			gMNL = guardedBlock.getMaximumNestingLevel();
		if (gMNL > maxMNL)
			maxMNL = gMNL;

		
		
		return 1 + maxMNL;
	}

	public int getNumberOfStatements() {
		Iterator cb_itr = catchBlocks.iterator();
		
		int sumNOS = 0;
		
		while(cb_itr.hasNext()) {
			CatchBlock cb = (CatchBlock)cb_itr.next();

			sumNOS += cb.getNumberOfStatements();
		}

		if (finallyBlock != null) {
			sumNOS += finallyBlock.getNumberOfStatements();
		}

		if (guardedBlock != null)
			sumNOS += guardedBlock.getNumberOfStatements();
		
		return 1 + sumNOS;
	}

	public int getNumberOfEdgesInCFG() {
		Iterator cb_itr = catchBlocks.iterator();
		
		int sumE = 0;
		
		while(cb_itr.hasNext()) {
			CatchBlock cb = (CatchBlock)cb_itr.next();

			sumE += cb.getNumberOfEdgesInCFG();
		}

		if (finallyBlock != null) {
			sumE += finallyBlock.getNumberOfEdgesInCFG();
		}

		if (guardedBlock != null)
			sumE += guardedBlock.getNumberOfEdgesInCFG();
		
		return sumE;
	}

	public int getNumberOfNodesInCFG() {
		Iterator cb_itr = catchBlocks.iterator();
		
		int sumN = 0;
		
		while(cb_itr.hasNext()) {
			CatchBlock cb = (CatchBlock)cb_itr.next();

			sumN += cb.getNumberOfNodesInCFG();
		}

		if (finallyBlock != null) {
			sumN += finallyBlock.getNumberOfNodesInCFG();
		}

		if (guardedBlock != null)
			sumN += guardedBlock.getNumberOfNodesInCFG();
		
		return sumN;
	}

	protected int countStatementObjects() {
		int tmp = 1;
		if (guardedBlock != null)
			tmp += guardedBlock.countStatementObjects();
		Iterator it = catchBlocks.iterator();
		while (it.hasNext()) {
			Statement st = (Statement)it.next();
			tmp += st.countStatementObjects();
		}
		if (finallyBlock != null)
			tmp += finallyBlock.countStatementObjects();
		return tmp;
	}
	
	/* (non-Javadoc)
	 * @see de.fzi.sissy.metamod.Statement#getStatementPosition(de.fzi.sissy.metamod.Statement)
	 */
	public int getStatementPosition(Statement st) {
		int pos = 1;
		if (getContainer() != null)
			pos = getContainer().getStatementPosition(this);
		if (st == this)
			return pos;
		if (guardedBlock == st)
			return pos + 1;
		Iterator it = catchBlocks.iterator();
		int i = 1;
		if (guardedBlock != null)
			i += guardedBlock.countStatementObjects();
		while (it.hasNext()) {
			Statement s = (Statement)it.next();
			if (st == s)
				return pos + i;
			i = i + s.countStatementObjects();
		}
		if (finallyBlock == st)
			return pos + i;
		return -1;
	}

	void simpleRemoveContainedStatement(Statement stmt) {
		if (guardedBlock == stmt)
			guardedBlock = null;
		else if (finallyBlock == stmt)
			finallyBlock = null;
		else
			catchBlocks.remove(stmt);
	}
}
