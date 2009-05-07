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

import java.util.Iterator;

import de.fzi.sissy.extractors.cdt.ast.ASTCompoundStatement;
import de.fzi.sissy.extractors.cdt.ast.ASTExpressionStatement;
import de.fzi.sissy.extractors.cdt.ast.ASTForStatement;
import de.fzi.sissy.extractors.cdt.ast.ASTIfStatement;
import de.fzi.sissy.extractors.cdt.ast.ASTOtherStatement;
import de.fzi.sissy.extractors.cdt.ast.ASTReturnStatement;
import de.fzi.sissy.extractors.cdt.ast.ASTSwitchStatement;
import de.fzi.sissy.extractors.cdt.ast.ASTWhileStatement;
import de.fzi.sissy.extractors.cdt.ast.IASTStatement;
import de.fzi.sissy.metamod.Field;
import de.fzi.sissy.metamod.Method;
import de.fzi.sissy.metamod.Type;
import de.fzi.sissy.metamod.Class;

/**
 * @author phil
 */
public class Util {

	public static String reduce(String[] s) {
		StringBuffer buf = new StringBuffer();
		if (s.length > 0)
			buf.append(s[0]);

		for (int i = 1; i < s.length; i++) {
			buf.append("." + s[i]);
		}

		return buf.toString();
	}
	
	public static String shortSummary(Type t) {
		StringBuffer buf = new StringBuffer();
		buf.append(t.getSimpleName());
		if (t instanceof Class) {
			Class c = (Class) t;
			
			Iterator supertypes = c.getDirectSuperClasses().iterator();
			if (supertypes.hasNext()) {
				Type supertype = (Type) supertypes.next();
				buf.append(" : " + supertype.getSimpleName());
			}
			
			while (supertypes.hasNext()) {
				Type supertype = (Type) supertypes.next();
				buf.append(", " + supertype.getSimpleName());
			}
			
			int cnt = 3;
			Iterator fields = c.getFields().iterator();
			while (fields.hasNext() && cnt > 0) {
				Field fld = (Field) fields.next();
				if (fld.getTypeDeclaration() != null) {
					buf.append("\n  " + fld.getType().getSimpleName() + " " + fld.getSimpleName());
					cnt--;
				}
			}
			if (fields.hasNext())
				buf.append("\n  ...");

			cnt = 3;
			Iterator methods = c.getMethods().iterator();
			while (methods.hasNext() && cnt > 0) {
				Method m = (Method) methods.next();
				if (m.getReturnTypeDeclaration() != null) {
					buf.append("\n  " + m.getReturnType().getSimpleName() + " " + m.getSimpleName() + "()");
					cnt--;
				}
			}
			if (methods.hasNext())
				buf.append("\n  ...");
		}
		return buf.toString();
	}
	
	public static void printCFG(IASTStatement stmt) {
		printStmtAtLevel(0, stmt);
	}
	
	private static void printStmtAtLevel(int level, IASTStatement stmt) {
		if (stmt instanceof ASTCompoundStatement) {
			Iterator stmts = ((ASTCompoundStatement)stmt).getStatements().iterator();
			while (stmts.hasNext()) {
				IASTStatement stm = (IASTStatement) stmts.next();
				printStmtAtLevel(level, stm);
			}
		}
		else if (stmt instanceof ASTIfStatement) {
			printAtLevel(level, "if");
			printAtLevel(level+2, "cond: " + ((ASTIfStatement)stmt).getExpression());
			printAtLevel(level+2, "then:");
			printStmtAtLevel(level+4, ((ASTIfStatement)stmt).getThen());
			if (((ASTIfStatement)stmt).getElse() != null) {
				printAtLevel(level+2, "else:");
				printStmtAtLevel(level+4, ((ASTIfStatement)stmt).getElse());
			}
		}
		else if (stmt instanceof ASTExpressionStatement) {
			printAtLevel(level, ((ASTExpressionStatement)stmt).toString());
		}
		else if (stmt instanceof ASTWhileStatement) {
			printAtLevel(level, "while");
			printAtLevel(level+2, "cond: " + ((ASTWhileStatement)stmt).getGuard());
			printAtLevel(level+2, "body:");
			printStmtAtLevel(level+4, ((ASTWhileStatement)stmt).getBody());
		}
		else if (stmt instanceof ASTForStatement) {
			printAtLevel(level, "for");
			printAtLevel(level+2, "init:");
			printStmtAtLevel(level+4, ((ASTForStatement)stmt).getInit());
			printAtLevel(level+2, "test: " + ((ASTForStatement)stmt).getGuard());
			printAtLevel(level+2, "update:");
			printStmtAtLevel(level+4, ((ASTForStatement)stmt).getUpdate());
			printAtLevel(level+2, "body:");
			printStmtAtLevel(level+4, ((ASTForStatement)stmt).getBody());
		}
		else if (stmt instanceof ASTSwitchStatement) {
			printAtLevel(level, "switch");
			printAtLevel(level+2, "cond: " + ((ASTSwitchStatement)stmt).getConditionExpression());
			Iterator cases = ((ASTCompoundStatement)((ASTSwitchStatement)stmt).getBody()).getStatements().iterator();
			while (cases.hasNext()) {
				IASTStatement kase = (IASTStatement) cases.next();
				//TODO
			}
		}
		else if (stmt instanceof ASTOtherStatement
				|| stmt instanceof ASTReturnStatement) {
			printAtLevel(level, stmt.toString());
		}
	}
	
	private static void printAtLevel(int level, String s) {
		for (int i = 0; i < level; i++)
			System.out.print(" ");
		System.out.println(s);
	}
}