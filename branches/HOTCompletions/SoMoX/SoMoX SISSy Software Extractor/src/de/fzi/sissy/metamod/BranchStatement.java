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

import de.fzi.sissy.util.Debug;

/**
 * @author Mircea Trifu
 * @author stammel
 *
 */
public class BranchStatement extends Statement {

	private ModelElementList branches;
	
	private boolean compNodes, compEdges;
	
    public BranchStatement() {
 
		/*
		 * When you create a BranchStatement:
		 * for missing else/default-Block there must be added an empty BlockStatement !!!
		 * (for correct calculation of CFG-measures)
		 */

    	super();
    	branches = new ModelElementList();
    	
    	// Rekursionstest:
    	compNodes = false;
		compEdges = false;
    }
	
	public ModelElementList getBranches() {
		return branches; 
	}

	public void setBranches(ModelElementList branches) {
		this.branches = branches; 
		Iterator itr = branches.iterator();
		while (itr.hasNext()) {
			Statement branch = (Statement)itr.next();
			branch.setContainer(this);
		}
		
	}

	public void addBranch(Statement statement) {
		this.branches.addUnique(statement); 
		statement.setContainer(this);
	}
	
	// TODO OK check destroy()
	void destroy() {
		super.destroy();
		branches.destroy();
		branches = null;
	}
	
	public void insertBranch(Statement statement, int position) {
		branches.add(position, statement);
		statement.setContainer(this);
	}

	public void removeBranch(Statement statement) {
		branches.remove(statement); 
		ModelElementRepository.getWorkingRepository().removeElement(statement);
	}
	
	public int getMaximumNestingLevel() {
		Iterator br_itr = branches.iterator();
		
		int maxMNL = 0;
		
		while(br_itr.hasNext()) {
			Statement branch = (Statement)br_itr.next();

			int bMNL = branch.getMaximumNestingLevel();
			
			if (bMNL > maxMNL)
				maxMNL = bMNL;
		}
		
		return 1 + maxMNL;
	}

	public int getNumberOfStatements() {
		Iterator br_itr = branches.iterator();
		
		int sumNOS = 0;
		
		while(br_itr.hasNext()) {
			Statement branch = (Statement)br_itr.next();

			sumNOS += branch.getNumberOfStatements();
		}
		
		return 1 + sumNOS;
	}

	public int getNumberOfEdgesInCFG() {
		// for missing else/default-Block there
		// must be added an empty BlockStatement !!!
		if (this.compEdges) 
			Debug.warning("Rekursion in Branch for Edges in CFG");

		this.compEdges = true; 

		Iterator br_itr = branches.iterator();
		
		int sumE = 0;
		
		while(br_itr.hasNext()) {
			Statement branch = (Statement)br_itr.next();

			sumE += branch.getNumberOfEdgesInCFG();
		}

		this.compEdges = false; 
		
		// number of branches + sum of all edges of all branches
		return branches.size() + sumE;
	}

	public int getNumberOfNodesInCFG() {
		// for missing else/default-Block there
		// must be added an empty BlockStatement !!!
		if (this.compNodes) 
			Debug.warning("Rekursion in Branch for Nodes in CFG");

		this.compNodes = true; 
				
		Iterator br_itr = branches.iterator();
		
		int sumN = 0;
		
		while(br_itr.hasNext()) {
			Statement branch = (Statement)br_itr.next();

			sumN += branch.getNumberOfNodesInCFG();
		}

		this.compNodes = false;
		
		return 1 + sumN;
	}

	protected int countStatementObjects() {
		int tmp = 1;
		Iterator it = branches.iterator();
		while (it.hasNext()) {
			Statement st = (Statement)it.next();
			tmp += st.countStatementObjects();
		}
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
		Iterator it = branches.iterator();
		int i = 1;
		while (it.hasNext()) {
			Statement s = (Statement)it.next();
			if (st == s)
				return pos + i;
			i = i + s.countStatementObjects();
		}
		return -1;
	}

	void simpleRemoveContainedStatement(Statement stmt) {
		branches.remove(stmt);
	}
}
