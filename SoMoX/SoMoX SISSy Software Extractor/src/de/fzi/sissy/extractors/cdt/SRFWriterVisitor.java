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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.cdt.core.parser.ISourceElementCallbackDelegate;
import org.eclipse.cdt.core.parser.ast.ASTNotImplementedException;
import org.eclipse.cdt.core.parser.ast.IASTAbstractDeclaration;
import org.eclipse.cdt.core.parser.ast.IASTBaseSpecifier;
import org.eclipse.cdt.core.parser.ast.IASTClassSpecifier;
import org.eclipse.cdt.core.parser.ast.IASTDeclaration;
import org.eclipse.cdt.core.parser.ast.IASTElaboratedTypeSpecifier;
import org.eclipse.cdt.core.parser.ast.IASTEnumerationSpecifier;
import org.eclipse.cdt.core.parser.ast.IASTField;
import org.eclipse.cdt.core.parser.ast.IASTFunction;
import org.eclipse.cdt.core.parser.ast.IASTMethod;
import org.eclipse.cdt.core.parser.ast.IASTNamespaceDefinition;
import org.eclipse.cdt.core.parser.ast.IASTSimpleTypeSpecifier;
import org.eclipse.cdt.core.parser.ast.IASTTemplateParameter;
import org.eclipse.cdt.core.parser.ast.IASTTypeSpecifier;
import org.eclipse.cdt.core.parser.ast.IASTTypedefDeclaration;
import org.eclipse.cdt.core.parser.ast.IASTVariable;

import de.fzi.sissy.metamod.File;

/*
 * Created on 19.08.2004
 */

/**
 * @author phil
 */
public class SRFWriterVisitor implements ASTVisitor {

	private PrintWriter writer;
	private HashMap classMap;
	private HashMap funMap;
	
	/**
	 * @param filename
	 * @param mapper
	 * @throws IOException
	 */
	public SRFWriterVisitor(String filename, ASTMapper mapper) throws IOException {
		writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
		classMap = mapper.getClassSpecifierMap();
		funMap = mapper.getFunctionMap();
	}
	
	public void setASTMapper(ASTMapper mapper) {
		classMap = mapper.getClassSpecifierMap();
		funMap = mapper.getFunctionMap();
	}
	
	/**
	 * @param s
	 * @return
	 */
	private String reduce(String[] s) {
		StringBuffer buf = new StringBuffer();
		if (s.length > 0)
			buf.append(s[0]);

		for (int i = 1; i < s.length; i++) {
			buf.append("." + s[i]);
		}

		return buf.toString();
	}
	
	/**
	 * @param typeSpec
	 * @return
	 */
	private String getTypename(IASTTypeSpecifier typeSpec) {
		if (typeSpec instanceof IASTClassSpecifier) {
			IASTClassSpecifier classSpec = (IASTClassSpecifier) typeSpec;
			return reduce(classSpec.getFullyQualifiedName());
		}
		else if (typeSpec instanceof IASTElaboratedTypeSpecifier) {
			IASTElaboratedTypeSpecifier elabTypeSpec = (IASTElaboratedTypeSpecifier) typeSpec;
			return reduce(elabTypeSpec.getFullyQualifiedName());
		}
		else if (typeSpec instanceof IASTEnumerationSpecifier) {
			IASTEnumerationSpecifier enumSpec = (IASTEnumerationSpecifier) typeSpec;
			return reduce(enumSpec.getFullyQualifiedName());
		}
		else if (typeSpec instanceof IASTSimpleTypeSpecifier) {
			IASTSimpleTypeSpecifier simpleTypeSpec = (IASTSimpleTypeSpecifier) typeSpec;
			return simpleTypeSpec.getTypename();
		}
		else if (typeSpec instanceof IASTTemplateParameter) {
			IASTTemplateParameter templParam = (IASTTemplateParameter) typeSpec;
			return templParam.getIdentifier();
		}
		else if (typeSpec instanceof IASTTypedefDeclaration) {
			IASTTypedefDeclaration typedef = (IASTTypedefDeclaration) typeSpec;
			return reduce(typedef.getFullyQualifiedName());
		}
		else return "<no typename>";
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see ASTVisitor#visitIASTClassSpecifier(org.eclipse.cdt.core.parser.ast.IASTClassSpecifier)
	 */
	public void visitIASTClassSpecifier(IASTClassSpecifier specifier) {
		writer.println("Class " + reduce(specifier.getFullyQualifiedName()));

		Iterator iter = specifier.getBaseClauses();
		while (iter.hasNext()) {
			IASTBaseSpecifier baseSpec = (IASTBaseSpecifier) iter.next();
			writer.println("inheritsFrom "
					+ reduce(specifier.getFullyQualifiedName()) + " "
					+ baseSpec.getParentClassName());
		}
		
		try {
			iter = specifier.getDeclarations();
			while (iter.hasNext()) {
				IASTDeclaration decl = (IASTDeclaration) iter.next();
				if (decl instanceof IASTField) {
					IASTField fld = (IASTField) decl;
					writer.println("hasAttribute "
							+ reduce(specifier.getFullyQualifiedName()) + " "
							+ fld.getName());
				} else if (decl instanceof IASTMethod) {
					IASTMethod m = (IASTMethod) decl;
					writer.println("hasMethod "
							+ reduce(specifier.getFullyQualifiedName()) + " "
							+ m.getName());
				}
			}
		} catch (ASTNotImplementedException e) {
			e.printStackTrace();
		}
		
		RefCollector collector = (RefCollector) classMap.get(specifier);
		
		if (collector != null) {
			iter = collector.getRefs().iterator();
			while (iter.hasNext()) {
				ISourceElementCallbackDelegate elem = (ISourceElementCallbackDelegate) iter
						.next();
				if (elem instanceof IASTFunction) {
					IASTFunction fun = (IASTFunction) elem;
					writer.println("accesses "
							+ reduce(fun.getFullyQualifiedName()) + " "
							+ reduce(specifier.getFullyQualifiedName()));
				} else if (elem instanceof IASTField) {
					IASTField fld = (IASTField) elem;
					writer.println("usesAttribute "
							+ reduce(specifier.getFullyQualifiedName()) + " "
							+ reduce(fld.getFullyQualifiedName()));
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see ASTVisitor#visitIASTVariable(org.eclipse.cdt.core.parser.ast.IASTVariable)
	 */
	public void visitIASTVariable(IASTVariable variable) {
		writer.print("Variable " + reduce(variable.getFullyQualifiedName()));
		IASTAbstractDeclaration absDecl = variable.getAbstractDeclaration();
		IASTTypeSpecifier typeSpec = absDecl.getTypeSpecifier();
		writer.println(" " + getTypename(typeSpec));
	}

	/* (non-Javadoc)
	 * @see ASTVisitor#visitIASTField(org.eclipse.cdt.core.parser.ast.IASTField)
	 */
	public void visitIASTField(IASTField field) {
		writer.print("Attribute " + reduce(field.getFullyQualifiedName()));
		IASTAbstractDeclaration absDecl = field.getAbstractDeclaration();
		IASTTypeSpecifier typeSpec = absDecl.getTypeSpecifier();
		writer.println(" " + getTypename(typeSpec));
	}

	/* (non-Javadoc)
	 * @see ASTVisitor#visitIASTFunction(org.eclipse.cdt.core.parser.ast.IASTFunction)
	 */
	public void visitIASTFunction(IASTFunction function) {
		writer.println("Function " + reduce(function.getFullyQualifiedName())
				+ " " + function.getName() + " " + function.isStatic());

		IASTAbstractDeclaration absDecl = function.getReturnType();
		IASTTypeSpecifier typeSpec = absDecl.getTypeSpecifier();

		writer.println("returns " + reduce(function.getFullyQualifiedName())
				+ " " + getTypename(typeSpec));
		
		RefCollector collector = (RefCollector) funMap.get(function);
		
		if (collector != null) {
			Iterator iter = collector.getRefs().iterator();
			while (iter.hasNext()) {
				ISourceElementCallbackDelegate elem = (ISourceElementCallbackDelegate) iter
						.next();
				if (elem instanceof IASTFunction) {
					IASTFunction fun = (IASTFunction) elem;
					writer.println("calls "
							+ reduce(function.getFullyQualifiedName()) + " "
							+ reduce(fun.getFullyQualifiedName()));
				} else if (elem instanceof IASTField) {
					IASTField fld = (IASTField) elem;
					writer.println("usesAttribute "
							+ reduce(function.getFullyQualifiedName()) + " "
							+ reduce(fld.getFullyQualifiedName()));
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ASTVisitor#visitIASTMethod(org.eclipse.cdt.core.parser.ast.IASTMethod)
	 */
	public void visitIASTMethod(IASTMethod method) {
		writer.println("Method " + reduce(method.getFullyQualifiedName())
				+ " " + method.getName() + " " + method.isStatic());

		IASTAbstractDeclaration absDecl = method.getReturnType();
		IASTTypeSpecifier typeSpec = absDecl.getTypeSpecifier();

		writer.println("returns " + reduce(method.getFullyQualifiedName())
				+ " " + getTypename(typeSpec));
		
		RefCollector collector = (RefCollector) funMap.get(method);
		
		if (collector != null) {
			Iterator iter = collector.getRefs().iterator();
			while (iter.hasNext()) {
				ISourceElementCallbackDelegate elem = (ISourceElementCallbackDelegate) iter
						.next();
				if (elem instanceof IASTFunction) {
					IASTFunction fun = (IASTFunction) elem;
					writer.println("calls "
							+ reduce(method.getFullyQualifiedName()) + " "
							+ reduce(fun.getFullyQualifiedName()));
				} else if (elem instanceof IASTField) {
					IASTField fld = (IASTField) elem;
					writer.println("usesAttribute "
							+ reduce(method.getFullyQualifiedName()) + " "
							+ reduce(fld.getFullyQualifiedName()));
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see ASTVisitor#doneVisiting()
	 */
	public void doneVisiting() {
		writer.close();
	}

	/* (non-Javadoc)
	 * @see de.fzi.cdt.ASTVisitor#newFile(de.fzi.cdt.ASTMapper)
	 */
	public void newFile(File file, ASTMapper mapper) {
		setASTMapper(mapper);
	}

	/* (non-Javadoc)
	 * @see de.fzi.cdt.ASTVisitor#visitIASTTypedefDeclaration(org.eclipse.cdt.core.parser.ast.IASTTypedefDeclaration)
	 */
	public void visitIASTTypedefDeclaration(IASTTypedefDeclaration decl) {
		// TODO Auto-generated method stub
		
	}

	public void enterNamespaceDefinition(IASTNamespaceDefinition namespace) {
		// TODO Auto-generated method stub
		
	}

	public void exitNamespaceDefinition(IASTNamespaceDefinition namespace) {
		// TODO Auto-generated method stub
		
	}

}
