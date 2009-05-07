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
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.cdt.core.parser.ISourceElementCallbackDelegate;
import org.eclipse.cdt.core.parser.ast.*;

/*
 * Created on 15.08.2004
 */

/**
 * @author phil
 */
public class CompilationUnitPrinter {
	
	private HashMap fmap;
	private HashMap cmap;
	
	public CompilationUnitPrinter(HashMap fmap, HashMap cmap) {
		this.fmap = fmap;
		this.cmap = cmap;
	}
	
	public void print(IASTCompilationUnit cu) {
		try {
			Iterator iter = cu.getDeclarations();
			
			while (iter.hasNext()) {
				IASTDeclaration	decl = (IASTDeclaration) iter.next();
				printFull(decl, 0);				
			}
		} catch (ASTNotImplementedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param decl
	 * @param off
	 * @throws ASTNotImplementedException
	 */
	private void printFull(IASTDeclaration decl, int off) throws ASTNotImplementedException {
		if (decl instanceof IASTAbstractTypeSpecifierDeclaration) {
			printFull((IASTAbstractTypeSpecifierDeclaration) decl, off);
		}
		else if (decl instanceof IASTFunction) {
			printFull((IASTFunction) decl, off);
		}
		else if (decl instanceof IASTField) {
			print((IASTField) decl, off);
		}
		else if (decl instanceof IASTVariable) {
			print((IASTVariable) decl, off);
		}
	}
	
	/**
	 * @param decl
	 * @param off
	 * @throws ASTNotImplementedException
	 */
	private void print(IASTDeclaration decl, int off) throws ASTNotImplementedException {
		if (decl instanceof IASTAbstractTypeSpecifierDeclaration) {
			print((IASTAbstractTypeSpecifierDeclaration) decl, off);
		}
		else if (decl instanceof IASTFunction) {
			print((IASTFunction) decl, off);
		}
		else if (decl instanceof IASTField) {
			print((IASTField) decl, off);
		}
		else if (decl instanceof IASTVariable) {
			print((IASTVariable) decl, off);
		}
	}
	
	private void printFull(IASTAbstractTypeSpecifierDeclaration typeDecl, int off) throws ASTNotImplementedException {
		for (int i = 0; i < off; i++)
			System.out.print(" ");
		
		System.out.println("IASTAbstractTypeSpecifierDeclaration");
		
		IASTTypeSpecifier typeSpec = typeDecl.getTypeSpecifier();
		
		printFull(typeSpec, off+2);
	}

	private void print(IASTAbstractTypeSpecifierDeclaration typeDecl, int off) throws ASTNotImplementedException {
		for (int i = 0; i < off; i++)
			System.out.print(" ");
		
		System.out.println("IASTAbstractTypeSpecifierDeclaration");
		
		IASTTypeSpecifier typeSpec = typeDecl.getTypeSpecifier();
		
		print(typeSpec, off+2);
	}
	
	/**
	 * @param typeSpec
	 * @param off
	 * @throws ASTNotImplementedException
	 */
	private void printFull(IASTTypeSpecifier typeSpec, int off) throws ASTNotImplementedException {
		if (typeSpec instanceof IASTClassSpecifier) {
			IASTClassSpecifier classSpec = (IASTClassSpecifier) typeSpec;
			printFull(classSpec, off);
		}
		else if (typeSpec instanceof IASTElaboratedTypeSpecifier) {
			IASTElaboratedTypeSpecifier elabTypeSpec = (IASTElaboratedTypeSpecifier) typeSpec;
			for (int i = 0; i < off; i++)
				System.out.print(" ");
			System.out.println("IASTElaboratedTypeSpecifier " + elabTypeSpec.getName());
		}
		else if (typeSpec instanceof IASTSimpleTypeSpecifier) {
			IASTSimpleTypeSpecifier simpleTypeSpec = (IASTSimpleTypeSpecifier) typeSpec;
			for (int i = 0; i < off; i++)
				System.out.print(" ");
			System.out.println("IASTSimpleTypeSpecifier " + simpleTypeSpec.getTypename());
		}
	}

	/**
	 * @param typeSpec
	 * @param off
	 * @throws ASTNotImplementedException
	 */
	private void print(IASTTypeSpecifier typeSpec, int off) throws ASTNotImplementedException {
		if (typeSpec instanceof IASTClassSpecifier) {
			IASTClassSpecifier classSpec = (IASTClassSpecifier) typeSpec;
			print(classSpec, off);
		}
		else if (typeSpec instanceof IASTElaboratedTypeSpecifier) {
			IASTElaboratedTypeSpecifier elabTypeSpec = (IASTElaboratedTypeSpecifier) typeSpec;
			for (int i = 0; i < off; i++)
				System.out.print(" ");
			System.out.println("IASTElaboratedTypeSpecifier " + elabTypeSpec.getName());
		}
		else if (typeSpec instanceof IASTSimpleTypeSpecifier) {
			IASTSimpleTypeSpecifier simpleTypeSpec = (IASTSimpleTypeSpecifier) typeSpec;
			for (int i = 0; i < off; i++)
				System.out.print(" ");
			System.out.println("IASTSimpleTypeSpecifier " + simpleTypeSpec.getTypename());
		}
	}
	
	/**
	 * @param classSpec
	 * @param off
	 * @throws ASTNotImplementedException
	 */
	private void printFull(IASTClassSpecifier classSpec, int off) throws ASTNotImplementedException {
		for (int i = 0; i < off; i++)
			System.out.print(" ");
		System.out.println("IASTClassSpecifier " + classSpec.getName());
		
		Iterator iter = classSpec.getDeclarations();
		
		while (iter.hasNext()) {
			IASTDeclaration decl = (IASTDeclaration) iter.next();
			printFull(decl, off+2);
		}
		
		for (int i = 0; i < off + 2; i++)
			System.out.print(" ");
		System.out.println("references:");
		
		RefCollector collector = (RefCollector) cmap.get(classSpec);
		iter = collector.getRefs().iterator();
		while (iter.hasNext()) {
			ISourceElementCallbackDelegate elem = (ISourceElementCallbackDelegate) iter.next();
			print(elem, off+4);
		}
	}
	
	/**
	 * @param classSpec
	 * @param off
	 * @throws ASTNotImplementedException
	 */
	private void print(IASTClassSpecifier classSpec, int off) throws ASTNotImplementedException {
		for (int i = 0; i < off; i++)
			System.out.print(" ");
		System.out.println("IASTClassSpecifier " + classSpec.getName());
	}
	
	private void printFull(IASTFunction fun, int off) throws ASTNotImplementedException {
		for (int i = 0; i < off; i++)
			System.out.print(" ");
		
		IASTAbstractDeclaration decl = fun.getReturnType();
		IASTTypeSpecifier typeSpec = decl.getTypeSpecifier();
		
		System.out.println("Function " + getTypename(typeSpec) + " " + fun.getName());
		
		for (int i = 0; i < off + 2; i++)
			System.out.print(" ");
		System.out.println("references:");
		
		RefCollector collector = (RefCollector) fmap.get(fun);
		Iterator iter = collector.getRefs().iterator();
		while (iter.hasNext()) {
			ISourceElementCallbackDelegate elem = (ISourceElementCallbackDelegate) iter.next();
			print(elem, off+4);
		}
	}
	
	private void print(IASTFunction fun, int off) {
		for (int i = 0; i < off; i++)
			System.out.print(" ");
		
		IASTAbstractDeclaration decl = fun.getReturnType();
		IASTTypeSpecifier typeSpec = decl.getTypeSpecifier();
		
		System.out.println("Function " + getTypename(typeSpec) + " " + fun.getName());
	}
	
	private void print(ISourceElementCallbackDelegate elem, int off) throws ASTNotImplementedException {
		if (elem instanceof IASTField)
			print((IASTField) elem, off);
		else if (elem instanceof IASTVariable)
			print((IASTVariable) elem, off);
		else if (elem instanceof IASTFunction)
			print((IASTFunction) elem, off);
		else if (elem instanceof IASTClassSpecifier)
			print((IASTClassSpecifier) elem, off);
	}
	
	private void print(IASTField fld, int off) {
		for (int i = 0; i < off; i++)
			System.out.print(" ");
		
		IASTAbstractDeclaration decl = fld.getAbstractDeclaration();
		IASTTypeSpecifier typeSpec = decl.getTypeSpecifier();
		
		System.out.println("Field " + getTypename(typeSpec) + " " + fld.getName());
	}
	
	private void print(IASTVariable var, int off) throws ASTNotImplementedException {
		for (int i = 0; i < off; i++)
			System.out.print(" ");
		
		IASTAbstractDeclaration decl = var.getAbstractDeclaration();
		IASTTypeSpecifier typeSpec = decl.getTypeSpecifier();
		
		System.out.println("Variable " + getTypename(typeSpec) + " " + var.getName());
	}
	
	private String getTypename(IASTTypeSpecifier typeSpec) {
		if (typeSpec instanceof IASTClassSpecifier) {
			IASTClassSpecifier classSpec = (IASTClassSpecifier) typeSpec;
			return classSpec.getName();
		}
		else if (typeSpec instanceof IASTElaboratedTypeSpecifier) {
			IASTElaboratedTypeSpecifier elabTypeSpec = (IASTElaboratedTypeSpecifier) typeSpec;
			return elabTypeSpec.getName();
		}
		else if (typeSpec instanceof IASTEnumerationSpecifier) {
			IASTEnumerationSpecifier enumSpec = (IASTEnumerationSpecifier) typeSpec;
			return enumSpec.getName();
		}
		else if (typeSpec instanceof IASTScopedTypeSpecifier) {
			IASTScopedTypeSpecifier scTypeSpec = (IASTScopedTypeSpecifier) typeSpec;
			return scTypeSpec.toString();
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
			return typedef.getName();
		}
		else return "";
	}

}