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

import org.eclipse.cdt.core.parser.ast.IASTExpression;


/**
 * @author phil
 */
public class ASTForStatement extends ASTAbstractStatement implements IASTLoopStatement {

	private IASTStatement init = null;
	//private IASTExpression test = null;
	private IASTStatement update = null;
	private IASTStatement body = null;
	
	public ASTForStatement(IASTStatement init, IASTExpression test,
			IASTStatement update, IASTStatement body) {
		this.init = init;
		//this.test = test;
		this.update = update;
		this.body = body;
	}
	
    public ASTForStatement() {
    }

    public void setInit(IASTStatement stmt) {
        init = stmt;
    }
    public IASTStatement getInit() {
		return init;
	}
	public void setGuard(IASTExpression expr) {
        //test = expr;
    }
	public IASTExpression getGuard() {
		return /*test;*/ null;
	}
	public void setUpdate(IASTStatement stmt) {
        update = stmt;
    }
	public IASTStatement getUpdate() {
		return update;
	}
	public void setBody(IASTStatement stmt) {
        body = stmt;
    }
	public IASTStatement getBody() {
		return body;
	}
	
	public String toString() {
		return "for (" + init.toString() + "; " /*+ test.toString()*/ + "; "
		+ update.toString() + ")\n" + body.toString();
	}
}
