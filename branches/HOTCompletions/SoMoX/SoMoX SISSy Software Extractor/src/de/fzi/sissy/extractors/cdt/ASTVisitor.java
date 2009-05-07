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
import org.eclipse.cdt.core.parser.ast.IASTClassSpecifier;
import org.eclipse.cdt.core.parser.ast.IASTField;
import org.eclipse.cdt.core.parser.ast.IASTFunction;
import org.eclipse.cdt.core.parser.ast.IASTMethod;
import org.eclipse.cdt.core.parser.ast.IASTNamespaceDefinition;
import org.eclipse.cdt.core.parser.ast.IASTTypedefDeclaration;
import org.eclipse.cdt.core.parser.ast.IASTVariable;

import de.fzi.sissy.metamod.File;

/*
 * Created on 19.08.2004
 */

/**
 * @author phil
 * 
 * TODO: struct, union, enum, ...
 */
public interface ASTVisitor {

	/**
	 * @param specifier
	 */
	void visitIASTClassSpecifier(IASTClassSpecifier specifier);

	/**
	 * @param variable
	 */
	void visitIASTVariable(IASTVariable variable);

	/**
	 * @param field
	 */
	void visitIASTField(IASTField field);

	/**
	 * @param function
	 */
	void visitIASTFunction(IASTFunction function);

	/**
	 * @param method
	 */
	void visitIASTMethod(IASTMethod method);

	void newFile(File file, ASTMapper mapper);
	
	/**
	 * 
	 */
	void doneVisiting();

	/**
	 * @param declaration
	 */
	void visitIASTTypedefDeclaration(IASTTypedefDeclaration decl);
	
	void enterNamespaceDefinition(IASTNamespaceDefinition namespace);
	void exitNamespaceDefinition(IASTNamespaceDefinition namespace);
}
