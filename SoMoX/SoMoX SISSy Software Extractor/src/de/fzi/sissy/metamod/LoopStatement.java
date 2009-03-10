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
public class LoopStatement extends Statement {

	private Statement body;
	
	public Statement getBody() {
		return body;
	}

	public void setBody(Statement statement) {
		body = statement;
		statement.setContainer(this);
	}

	public void changeBody(Statement statement) {
		this.setBody(statement);
		if (statement != null)
			statement.setContainer(this);
	}
	
	// TODO OK check destroy()
	void destroy() {
		super.destroy();
		body = null;
	}

	public int getMaximumNestingLevel() {
		return 1 + body.getMaximumNestingLevel();
	}

	public int getNumberOfStatements() {
		return 1 + body.getNumberOfStatements();
	}

	public int getNumberOfEdgesInCFG() {
		return 2 + body.getNumberOfEdgesInCFG();
	}

	public int getNumberOfNodesInCFG() {
		return 1 + body.getNumberOfNodesInCFG();
	}

	protected int countStatementObjects() {
		return 1 + body.countStatementObjects();
	}
	
	public int getStatementPosition(Statement st) {
		int pos = 1;
		if (getContainer() != null)
			pos = getContainer().getStatementPosition(this);
		if (st == this)
			return pos;
		if (st == body)
			return pos + 1;
		return -1;
	}

	void simpleRemoveContainedStatement(Statement stmt) {
		if (body == stmt)
			body = null;
	}
}
