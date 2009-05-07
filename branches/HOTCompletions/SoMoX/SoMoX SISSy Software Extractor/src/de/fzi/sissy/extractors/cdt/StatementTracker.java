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
package de.fzi.sissy.extractors.cdt;

import java.util.EmptyStackException;
import java.util.Stack;

import de.fzi.sissy.extractors.cdt.ast.IASTStatement;
import de.fzi.sissy.util.Debug;

public class StatementTracker {

    private static StatementTracker instance = null;
    
    protected StatementTracker() {
        stmtStack = new Stack();
    }
    
    public static StatementTracker getInstance() {
        if (instance == null)
            instance = new StatementTracker();
        return instance;
    }
    
    private Stack stmtStack = null;
    
    public void pushStatement(IASTStatement stmt) {
        if (stmt == null)
            Debug.cbinfo("pushing null!!");
        Debug.cbinfo("pushing statement");
        stmtStack.push(stmt);
    }
    
    public void popStatement() {
        Debug.cbinfo("popping statement");
        stmtStack.pop();
    }
    
    public IASTStatement getCurrentStatement() {
    	try {
    		return (IASTStatement) stmtStack.peek();
    	} catch (EmptyStackException ex) {
    		return null;
    	}
    }
    
    public void clearStack() {
    	stmtStack.clear();
    }
}
