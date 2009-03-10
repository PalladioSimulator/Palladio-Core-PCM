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
 * @author stammel
 *
 */
public class StatementTreeWalker {
	
	Statement currentStatement = null;
	boolean children_finished = false;
	
	public StatementTreeWalker(Statement statement) {
		currentStatement = statement;
	}
	
	public boolean next() {
		while(true) {	    
		    if (!children_finished) {
		    	ModelElementList children = getChildren(currentStatement);
		    	if (!children.isEmpty()) {
		    		// wenn kinder da sind ==> abstieg, tiefensuche
		    		currentStatement = (Statement) children.get(0);
		    		return true;
		    	}
		    } 
	    	
			// keine kinder ==> wenn nachfolgende geschwister da ==> nächsten nehmen
			Statement nextStatement = getNextSibling(currentStatement);
			if (nextStatement!=null) {
				currentStatement = nextStatement;
				children_finished = false;
				return true;
			}
			
			// keine weiteren Geschwister da ==> Aufstieg zum Eltern-Statement
			// mit children_finished == true;
			children_finished = true;
			Statement parent = currentStatement.getContainer();
			if (parent != null) {
				currentStatement = parent;
				// erneute Iteration !
			} else {
				// Wurzel wieder erreicht ==> fertig
				return false;
			}
			
		}
	}
	
	public Statement getStatement() {
		return currentStatement;
	}
	
	private ModelElementList getChildren(Statement statement) {
		if (statement instanceof SimpleStatement) {
			return new ModelElementList();
		} else if (statement instanceof JumpStatement) { 
			return new ModelElementList();
		} else if (statement instanceof BlockStatement) { 
			return ((BlockStatement)statement).getStatements();
		} else if (statement instanceof LoopStatement) { 
			ModelElementList result = new ModelElementList();
			Statement body =  ((LoopStatement)statement).getBody();
			result.add(body);
			return result;
		} else if (statement instanceof BranchStatement) { 
			return ((BranchStatement)statement).getBranches();
		} else if (statement instanceof ExceptionHandler) {
			ModelElementList result = new ModelElementList();
			ExceptionHandler eh = (ExceptionHandler)statement;
			result.add(eh.getGuardedBlock());
			result.addAll(eh.getCatchBlocks());
			if (eh.getFinallyBlock()!= null)
				result.add(eh.getFinallyBlock());
			return result;
		} 
		
		return null;
	}
	
	private Statement getNextSibling(Statement statement) {
		Statement container = statement.getContainer();
		
		if (container == null) 
			return null;
		
		ModelElementList children = getChildren(container);
		
		for (int i=0; i<children.size(); i++) {
			if (statement == children.get(i)) {
				if (i+1<children.size()) {
					return (Statement)children.get(i+1);
				}
			}
		}
		
		return null;
	}

}
