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
public class BlockStatement extends Statement {

	private ModelElementList statements;
	private Function function;
	
	private boolean compNodes, compEdges, compAggreg;
	
	public BlockStatement() {
		super();
		statements = new ModelElementList();
		// rekursionstest:
		compNodes = false;
		compEdges = false;
		compAggreg = false;
	}
	
	public ModelElementList getStatements() {
		return statements; 
	}

	public void setStatements(ModelElementList statements) {
		this.statements = statements; 
		Iterator itr = statements.iterator();
		while (itr.hasNext()) {
			Statement statement = (Statement)itr.next();
			statement.setContainer(this);
		}
	}

	public void addStatement(Statement statement) {
		this.statements.addUnique(statement); 
		statement.setContainer(this);
	}
	
	public Function getFunction() {
		return function; 
	}

	// is called i. e. by Function.setBody(...)
	public void setFunction(Function function) {
		this.function = function; 
	}

	// TODO OK check destroy()
	void destroy() {
		super.destroy();
		statements.destroy();
		statements = null;
		function = null;
	}

	public void insertStatement(Statement statement, int position) {
		statements.add(position, statement);
		statement.setContainer(this);
	}

	public void removeStatement(Statement statement) {
		statements.remove(statement);
		ModelElementRepository.getWorkingRepository().removeElement(statement);
	}

	public int getMaximumNestingLevel() {
		Iterator s_itr = statements.iterator();
		
		int maxMNL = 0;
		
		while(s_itr.hasNext()) {
			Statement statement = (Statement)s_itr.next();

			int sMNL = statement.getMaximumNestingLevel();
			
			if (sMNL > maxMNL)
				maxMNL = sMNL;
		}
		
		return maxMNL;
	}

	public int getNumberOfStatements() {
		Iterator s_itr = statements.iterator();
		
		int sumNOS = 0;
		
		while(s_itr.hasNext()) {
			Statement statement = (Statement)s_itr.next();

			sumNOS += statement.getNumberOfStatements();
		}
		
		return sumNOS;
	}
	
	/* Reimplemented by mtrifu. See below:
	public int getNumberOfEdgesInCFG() {
		if (this.compEdges)
			Debug.warning("NumberOfEdges Rekursion");
		
	
		if (this.statements.isEmpty())
			return 0;
			
		compEdges = true;
		
		Iterator s_itr = calculateCFGAggregates().iterator();
		
		int sumE = 0;
		
		while(s_itr.hasNext()) {
			Statement statement = (Statement)s_itr.next();

			sumE += statement.getNumberOfEdgesInCFG();
		}
		
		compEdges = false;
		
		return sumE;
	}

	public int getNumberOfNodesInCFG() {
		if (this.compNodes)
			Debug.warning("NumberOfNodes Rekursion");

		compNodes = true;
		
		Iterator s_itr = calculateCFGAggregates().iterator();
		
		int sumN = 0;
		
		while(s_itr.hasNext()) {
			Statement statement = (Statement)s_itr.next();

			sumN += statement.getNumberOfNodesInCFG();
		}
		
		compNodes = false;
		
		return sumN;
	}

	private ModelElementList calculateCFGAggregates() {
		// We have to aggregate all SimpleStatements which are
		// in a consegutive order inside the BlockStatement.
		// If there is a JumpStatement and SimpleStatements are
		// directly preceeding it, we have to aggregate all these
		// Statements to one node.
		if (this.compAggreg)
			Debug.warning("CFGAggreg Rekursion");
		
		compAggreg = true;
		
		ModelElementList cfg_aggregates = new ModelElementList();
		
		Iterator s_itr = statements.iterator();
		
		Statement lastStatement = null;
		int lastStatement_NumberOfEdgesInCFG = 0;
		int lastStatement_NumberOfNodesInCFG = 0;
		
		nextStatement:
		while(s_itr.hasNext()) {
			Statement currentStatement = (Statement)s_itr.next();
			int currentStatement_NumberOfEdgesInCFG = currentStatement.getNumberOfEdgesInCFG();
			int currentStatement_NumberOfNodesInCFG = currentStatement.getNumberOfNodesInCFG();

			if (lastStatement != null) 
			if ((lastStatement_NumberOfEdgesInCFG==1)&&
			   	(lastStatement_NumberOfNodesInCFG==1)&&
			   	(currentStatement_NumberOfEdgesInCFG==1)&&
			   	(currentStatement_NumberOfNodesInCFG==1)) {
				
				// we can aggregate this two statements:
				// skip current statement
				continue nextStatement;			
			}

			// empty statements are also ignored:
			if ((currentStatement_NumberOfEdgesInCFG==0)&&
				(currentStatement_NumberOfNodesInCFG==0)) {
				continue nextStatement;			
			}
			
			cfg_aggregates.add(currentStatement);
			lastStatement = currentStatement;
			lastStatement_NumberOfEdgesInCFG = currentStatement_NumberOfEdgesInCFG;
			lastStatement_NumberOfNodesInCFG = currentStatement_NumberOfNodesInCFG;
		}
	
		compAggreg = false;
		
		return cfg_aggregates;
	}*/
	
	public int getNumberOfEdgesInCFG() {
		if (this.compEdges)
			Debug.warning("NumberOfEdges Rekursion");
					
		compEdges = true;
		
		Iterator s_itr = statements.iterator();
		
		int sumE = 0, lastE = 0, noE = 0;
		
		while(s_itr.hasNext()) {
			Statement statement = (Statement)s_itr.next();
			lastE = noE;
			noE = statement.getNumberOfEdgesInCFG();
			if ((lastE != 1) || (noE != 1))
				sumE += noE;				
		}
		
		compEdges = false;
		
		return sumE;
	}
	
	public int getNumberOfNodesInCFG() {
		if (this.compNodes)
			Debug.warning("NumberOfNodes Rekursion");

		compNodes = true;
		
		Iterator s_itr = statements.iterator();
		
		int sumN = 0, lastE = 0, noE = 0, noN = 0;
		
		while(s_itr.hasNext()) {
			Statement statement = (Statement)s_itr.next();
			lastE = noE;
			noE = statement.getNumberOfEdgesInCFG();
			noN = statement.getNumberOfNodesInCFG();
			if (((lastE != 1) || (noE != 1)) && (noE != 0))
				sumN += noN;				
		}
		
		compNodes = false;
		
		return sumN;
	}
	
	protected int countStatementObjects() {
		int tmp = 1;
		Iterator it = statements.iterator();
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
		Iterator it = statements.iterator();
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
		statements.remove(stmt);
	}
}
