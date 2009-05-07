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

import org.eclipse.cdt.core.parser.ast.ASTNotImplementedException;
import org.eclipse.cdt.core.parser.ast.IASTAbstractTypeSpecifierDeclaration;
import org.eclipse.cdt.core.parser.ast.IASTClassSpecifier;
import org.eclipse.cdt.core.parser.ast.IASTCompilationUnit;
import org.eclipse.cdt.core.parser.ast.IASTDeclaration;
import org.eclipse.cdt.core.parser.ast.IASTField;
import org.eclipse.cdt.core.parser.ast.IASTFunction;
import org.eclipse.cdt.core.parser.ast.IASTMember;
import org.eclipse.cdt.core.parser.ast.IASTMethod;
import org.eclipse.cdt.core.parser.ast.IASTNamespaceDefinition;
import org.eclipse.cdt.core.parser.ast.IASTOffsetableElement;
import org.eclipse.cdt.core.parser.ast.IASTTypeSpecifier;
import org.eclipse.cdt.core.parser.ast.IASTTypedefDeclaration;
import org.eclipse.cdt.core.parser.ast.IASTVariable;

/*
 * Created on 19.08.2004
 */

/**
 * @author phil
 */
public class ASTWalker {

	private ASTVisitor v;
	
	/**
	 * @param visitor
	 */
	public ASTWalker(ASTVisitor visitor) {
		v = visitor;
	}
	
	/**
	 * @param cu
	 */
	public int walk(IASTCompilationUnit cu) {
		try {
			int loc = 0;
			
			Iterator iter = cu.getDeclarations();
			while (iter.hasNext()) {
				IASTDeclaration	decl = (IASTDeclaration) iter.next();
			
				if (decl instanceof IASTOffsetableElement) {
					int lines = ((IASTOffsetableElement) decl).getEndingLine()
						- ((IASTOffsetableElement) decl).getStartingLine() + 1;
					// Do not count negative lines (if there is an error)
					if (lines > 0)
						loc += lines;
				}
				
				walkIASTDeclaration(decl);
			}
			//v.doneVisiting();
			
			return loc;
		} catch (ASTNotImplementedException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * TODO: IASTEnumerationSpecifier, IASTElaboratedTypeSpecifier, IASTSimpleTypeSpecifier
	 * @param decl
	 * @throws ASTNotImplementedException
	 */
	private void walkIASTDeclaration(IASTDeclaration decl) throws ASTNotImplementedException {
		if (decl instanceof IASTAbstractTypeSpecifierDeclaration) {
			IASTAbstractTypeSpecifierDeclaration absTypeSpec = (IASTAbstractTypeSpecifierDeclaration) decl;
			IASTTypeSpecifier typeSpec = absTypeSpec.getTypeSpecifier();
			
			if (typeSpec instanceof IASTClassSpecifier) {
				walkIASTClassSpecifier((IASTClassSpecifier) typeSpec);
			}
		}
		else if (decl instanceof IASTTypedefDeclaration) {
			v.visitIASTTypedefDeclaration((IASTTypedefDeclaration) decl);
		}
		else if (decl instanceof IASTFunction) {
			IASTFunction fun = (IASTFunction) decl;
			
			if (fun instanceof IASTMethod)
				walkIASTMethod((IASTMethod) fun);
			else
				walkIASTFunction(fun);
		}
		else if (decl instanceof IASTVariable) {
			IASTVariable var = (IASTVariable) decl;
			
			if (var instanceof IASTField)
				walkIASTField((IASTField) var);
			else
				walkIASTVariable(var);
		}
		else if (decl instanceof IASTNamespaceDefinition) {
			walkIASTNamespaceDefinition((IASTNamespaceDefinition) decl);
		}
	}

	/**
	 * @param definition
	 * @throws ASTNotImplementedException
	 */
	private void walkIASTNamespaceDefinition(IASTNamespaceDefinition definition) throws ASTNotImplementedException {
		v.enterNamespaceDefinition(definition);
		
		Iterator iter = definition.getDeclarations();
		while (iter.hasNext()) {
			IASTDeclaration	decl = (IASTDeclaration) iter.next();
			walkIASTDeclaration(decl);
		}
		
		v.exitNamespaceDefinition(definition);
	}

	/**
	 * @param specifier
	 * @throws ASTNotImplementedException
	 */
	private void walkIASTClassSpecifier(IASTClassSpecifier specifier) throws ASTNotImplementedException {
		v.visitIASTClassSpecifier(specifier);
		
		Iterator iter = specifier.getDeclarations();
		while (iter.hasNext()) {
			IASTDeclaration decl = (IASTDeclaration) iter.next();
			walkIASTDeclaration(decl);
		}
	}

	/**
	 * @param member
	 * @throws ASTNotImplementedException
	 */
	private void walkIASTMember(IASTMember member) throws ASTNotImplementedException {
		if (member instanceof IASTMethod) {
			walkIASTMethod((IASTMethod) member);
		}
		else if (member instanceof IASTField) {
			walkIASTField((IASTField) member);
		}
	}
	
	/**
	 * @param method
	 * @throws ASTNotImplementedException
	 */
	private void walkIASTMethod(IASTMethod method) throws ASTNotImplementedException {
		v.visitIASTMethod(method);
		
		Iterator iter = method.getDeclarations();
		while (iter.hasNext()) {
			IASTDeclaration decl = (IASTDeclaration) iter.next();
			walkIASTDeclaration(decl);
		}
	}

	/**
	 * @param field
	 */
	private void walkIASTField(IASTField field) {
		v.visitIASTField(field);
	}
	
	/**
	 * @param function
	 * @throws ASTNotImplementedException
	 */
	private void walkIASTFunction(IASTFunction function) throws ASTNotImplementedException {
		v.visitIASTFunction(function);
		
		Iterator iter = function.getDeclarations();
		while (iter.hasNext()) {
			IASTDeclaration decl = (IASTDeclaration) iter.next();
			walkIASTDeclaration(decl);
		}
	}
	
	/**
	 * @param variable
	 */
	private void walkIASTVariable(IASTVariable variable) {
		v.visitIASTVariable(variable);
	}

}
