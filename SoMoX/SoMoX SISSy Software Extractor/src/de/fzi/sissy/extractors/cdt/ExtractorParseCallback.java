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
import org.eclipse.cdt.core.parser.ISourceElementCallbackDelegate;
import org.eclipse.cdt.core.parser.ast.IASTClassReference;
import org.eclipse.cdt.core.parser.ast.IASTClassSpecifier;
import org.eclipse.cdt.core.parser.ast.IASTDeclaration;
import org.eclipse.cdt.core.parser.ast.IASTField;
import org.eclipse.cdt.core.parser.ast.IASTFieldReference;
import org.eclipse.cdt.core.parser.ast.IASTFunction;
import org.eclipse.cdt.core.parser.ast.IASTFunctionReference;
import org.eclipse.cdt.core.parser.ast.IASTMethod;
import org.eclipse.cdt.core.parser.ast.IASTMethodReference;
import org.eclipse.cdt.core.parser.ast.IASTNode;
import org.eclipse.cdt.core.parser.ast.IASTParameterDeclaration;
import org.eclipse.cdt.core.parser.ast.IASTParameterReference;
import org.eclipse.cdt.core.parser.ast.IASTScope;
import org.eclipse.cdt.core.parser.ast.IASTTemplateDeclaration;
import org.eclipse.cdt.core.parser.ast.IASTVariable;
import org.eclipse.cdt.core.parser.ast.IASTVariableReference;
import org.eclipse.cdt.internal.core.parser.StructuralParseCallback;
import org.eclipse.cdt.internal.core.parser.ast.complete.ASTLinkageSpecification;
import org.eclipse.cdt.internal.core.parser.ast.complete.ASTScope;

import de.fzi.sissy.util.Debug;

/*
 * Created on 17.08.2004
 */

/**
 * @author phil
 */
public class ExtractorParseCallback extends StructuralParseCallback implements ASTMapper {

	private void addRef(ISourceElementCallbackDelegate ref) {
		
		//if (inclusionLevel == 0) {
						
			if (currentScope instanceof IASTFunction) {
				//System.out.println("Adding ref, scope: " + currentScope);
				
				RefCollector collector = (RefCollector) functionMap.get(currentScope);
				collector.addRef(ref);
				//System.out.println("#refs: " + collector.getRefs().size());
			}
			else if (currentScope instanceof IASTClassSpecifier) {
				//System.out.println("Adding ref, scope: " + currentScope);
				
				RefCollector collector = (RefCollector) classSpecifierMap.get(currentScope);
				collector.addRef(ref);
			}
		//}
	}

	private void addElement(IASTDeclaration element) {
		//if (inclusionLevel == 0) {
			if (currentScope instanceof ASTScope)
				((ASTScope) currentScope).addDeclaration(element);
			else if (currentScope instanceof ASTLinkageSpecification)
				((ASTLinkageSpecification) currentScope)
						.addDeclaration(element);
		//}
	}

	private void enterScope(IASTNode node) {
		if (node instanceof IASTScope) {
			if (node instanceof ASTScope) {
				((ASTScope) node).initDeclarations();
			}
			pushScope((IASTScope) node);
		}
	}

	private void exitScope(IASTNode node) {
		if (node instanceof IASTScope) {
			popScope();
		}
	}

	private void pushScope(IASTScope scope) {
		scopeStack.addFirst(currentScope);
		currentScope = scope;
	}

	private IASTScope popScope() {
		IASTScope oldScope = currentScope;
		currentScope = (scopeStack.size() > 0) ? (IASTScope) scopeStack
				.removeFirst() : null;
		return oldScope;
	}

	// maps IASTClassSpecifier objects to RefCollector objects
	private HashMap classSpecifierMap = new HashMap();
	
	public HashMap getClassSpecifierMap() {
		return classSpecifierMap;
	}
	
	// maps IASTFunction objects to RefCollector objects
	private HashMap functionMap = new HashMap();
	
	public HashMap getFunctionMap() {
		return functionMap;
	}

	public HashMap getReferenceMap() {
		return new HashMap();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#enterFunctionBody(org.eclipse.cdt.core.parser.ast.IASTFunction)
	 */
	public void enterFunctionBody(IASTFunction function) {
		//Debug.info("enter function: " + function.getName());
		System.out.println("enter function: " + Util.reduce(function.getFullyQualifiedName()));
		
		if(function.getOwnerTemplateDeclaration() == null) {
			addElement(function);
		}
		else if(function.getOwnerTemplateDeclaration() instanceof IASTTemplateDeclaration)
			addElement((IASTTemplateDeclaration)function.getOwnerTemplateDeclaration());
		
		if (functionMap.get(function) == null) {
			RefCollector collector = new RefCollector();
			functionMap.put(function, collector);
		}
		
		enterScope(function);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#enterMethodBody(org.eclipse.cdt.core.parser.ast.IASTMethod)
	 */
	public void enterMethodBody(IASTMethod method) {
		System.out.println("enter method (" + inclusionLevel + "): " + Util.reduce(method.getFullyQualifiedName()));
		if(method.getOwnerTemplateDeclaration() == null)
			addElement(method);
		else if(method.getOwnerTemplateDeclaration() instanceof IASTTemplateDeclaration)
			addElement((IASTTemplateDeclaration)method.getOwnerTemplateDeclaration());
	
		if (functionMap.get(method) == null) {
			RefCollector collector = new RefCollector();
			functionMap.put(method, collector);
		}
		
		enterScope(method);
	}
	
	public void exitFunctionBody(IASTFunction function) {
		//System.out.println("exit function: " + Util.reduce(function.getFullyQualifiedName()));
		exitScope(function);
	}

	public void exitMethodBody(IASTMethod method) {
		System.out.println("exit method: " + Util.reduce(method.getFullyQualifiedName()));
		exitScope(method);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#enterClassSpecifier(org.eclipse.cdt.core.parser.ast.IASTClassSpecifier)
	 */
	public void enterClassSpecifier(IASTClassSpecifier clss) {
		Debug.info("enter class: " + clss.getName());
		
		if (classSpecifierMap.get(clss) == null) {
			RefCollector collector = new RefCollector();
			classSpecifierMap.put(clss, collector);
		}
		
		enterScope(clss);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#exitClassSpecifier(org.eclipse.cdt.core.parser.ast.IASTClassSpecifier)
	 */
	public void exitClassSpecifier(IASTClassSpecifier classSpecification) {
		exitScope(classSpecification);
	}
	
	public void acceptClassReference(IASTClassReference reference) {
		//System.out.println("ClassReference.getName(): " + reference.getName());
		IASTClassSpecifier classSpec = (IASTClassSpecifier) reference.getReferencedElement();
		//System.out.println("referenced class: " + classSpec.getName());
		
		addRef(classSpec);
	}
	
	public void acceptFunctionReference(IASTFunctionReference reference) {
		//System.out.println("found " + reference.toString());
		IASTFunction fun = (IASTFunction) reference.getReferencedElement();
		//System.out.println("referenced function: " + fun.getName());
	
		addRef(fun);
	}
	
	public void acceptMethodReference(IASTMethodReference reference) {
		//System.out.println("found " + reference.toString());
		//System.out.println("MethodReference.getName(): " + reference.getName());
		IASTMethod method = (IASTMethod) reference.getReferencedElement();
		System.out.println("referenced method: " + method.getName());
	
		addRef(method);
	}
	
	public void acceptFieldReference(IASTFieldReference reference) {
		//System.out.println("found " + reference.toString());
		IASTField fld = (IASTField) reference.getReferencedElement();
		//System.out.println("referenced field: " + Util.reduce(fld.getFullyQualifiedName()));
	
		addRef(fld);
	}
	
	public void acceptVariableReference(IASTVariableReference reference) {
		//System.out.println("found " + reference.toString());
		IASTVariable var = (IASTVariable) reference.getReferencedElement();
		//System.out.println("referenced variable: " + var.getName());
		
		addRef(var);
	}

	public void acceptParameterReference(IASTParameterReference reference) {
		//System.out.println("found " + reference.toString());
		IASTParameterDeclaration paramDecl = (IASTParameterDeclaration) reference.getReferencedElement();
		//System.out.println("referenced parameter: " + paramDecl.getName());
		
		addRef(paramDecl);
	}
}