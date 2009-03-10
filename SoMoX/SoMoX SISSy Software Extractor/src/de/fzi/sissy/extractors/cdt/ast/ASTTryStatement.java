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
package de.fzi.sissy.extractors.cdt.ast;

/**
 * @author phil
 */
public class ASTTryStatement extends ASTAbstractStatement {

	private IASTStatement tryStmt = null;
	private ASTCompoundStatement catchStmts = null;
	
	public ASTTryStatement(IASTStatement tryStmt, ASTCompoundStatement compStmt) {
		this.tryStmt = tryStmt;
		catchStmts = compStmt;
	}
	
    public ASTTryStatement() {
    }

    public void setTry(IASTStatement stmt) {
        tryStmt = stmt;
    }
    public IASTStatement getTry() { return tryStmt; }
	public void setCatches(ASTCompoundStatement stmts) {
        catchStmts = stmts;
    }
	public ASTCompoundStatement getCatches() { return catchStmts; }
	
	public String toString() {
		return "try\n" + tryStmt.toString() + "\ncatch(...) {}";
	}
}
