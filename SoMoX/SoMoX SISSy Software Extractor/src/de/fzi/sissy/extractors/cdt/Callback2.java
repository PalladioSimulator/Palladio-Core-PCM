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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.eclipse.cdt.core.parser.CodeReader;
import org.eclipse.cdt.core.parser.IProblem;
import org.eclipse.cdt.core.parser.ISourceElementCallbackDelegate;
import org.eclipse.cdt.core.parser.ISourceElementRequestor;
import org.eclipse.cdt.core.parser.ast.ASTNotImplementedException;
import org.eclipse.cdt.core.parser.ast.IASTASMDefinition;
import org.eclipse.cdt.core.parser.ast.IASTAbstractDeclaration;
import org.eclipse.cdt.core.parser.ast.IASTAbstractTypeSpecifierDeclaration;
import org.eclipse.cdt.core.parser.ast.IASTClassReference;
import org.eclipse.cdt.core.parser.ast.IASTClassSpecifier;
import org.eclipse.cdt.core.parser.ast.IASTCodeScope;
import org.eclipse.cdt.core.parser.ast.IASTCompilationUnit;
import org.eclipse.cdt.core.parser.ast.IASTDeclaration;
import org.eclipse.cdt.core.parser.ast.IASTElaboratedTypeSpecifier;
import org.eclipse.cdt.core.parser.ast.IASTEnumerationReference;
import org.eclipse.cdt.core.parser.ast.IASTEnumerationSpecifier;
import org.eclipse.cdt.core.parser.ast.IASTEnumeratorReference;
import org.eclipse.cdt.core.parser.ast.IASTExpression;
import org.eclipse.cdt.core.parser.ast.IASTField;
import org.eclipse.cdt.core.parser.ast.IASTFieldReference;
import org.eclipse.cdt.core.parser.ast.IASTFunction;
import org.eclipse.cdt.core.parser.ast.IASTFunctionReference;
import org.eclipse.cdt.core.parser.ast.IASTInclusion;
import org.eclipse.cdt.core.parser.ast.IASTLinkageSpecification;
import org.eclipse.cdt.core.parser.ast.IASTMacro;
import org.eclipse.cdt.core.parser.ast.IASTMethod;
import org.eclipse.cdt.core.parser.ast.IASTMethodReference;
import org.eclipse.cdt.core.parser.ast.IASTNamespaceDefinition;
import org.eclipse.cdt.core.parser.ast.IASTNamespaceReference;
import org.eclipse.cdt.core.parser.ast.IASTNode;
import org.eclipse.cdt.core.parser.ast.IASTParameterDeclaration;
import org.eclipse.cdt.core.parser.ast.IASTParameterReference;
import org.eclipse.cdt.core.parser.ast.IASTReference;
import org.eclipse.cdt.core.parser.ast.IASTScope;
import org.eclipse.cdt.core.parser.ast.IASTTemplateDeclaration;
import org.eclipse.cdt.core.parser.ast.IASTTemplateInstantiation;
import org.eclipse.cdt.core.parser.ast.IASTTemplateParameterReference;
import org.eclipse.cdt.core.parser.ast.IASTTemplateSpecialization;
import org.eclipse.cdt.core.parser.ast.IASTTypedefDeclaration;
import org.eclipse.cdt.core.parser.ast.IASTTypedefReference;
import org.eclipse.cdt.core.parser.ast.IASTUsingDeclaration;
import org.eclipse.cdt.core.parser.ast.IASTUsingDirective;
import org.eclipse.cdt.core.parser.ast.IASTVariable;
import org.eclipse.cdt.core.parser.ast.IASTVariableReference;
import org.eclipse.cdt.internal.core.parser.InternalParserUtil;
import org.eclipse.cdt.internal.core.parser.ast.complete.ASTBinaryExpression;
import org.eclipse.cdt.internal.core.parser.ast.complete.ASTConditionalExpression;
import org.eclipse.cdt.internal.core.parser.ast.complete.ASTEmptyExpression;
import org.eclipse.cdt.internal.core.parser.ast.complete.ASTExpression;
import org.eclipse.cdt.internal.core.parser.ast.complete.ASTIdExpression;
import org.eclipse.cdt.internal.core.parser.ast.complete.ASTLinkageSpecification;
import org.eclipse.cdt.internal.core.parser.ast.complete.ASTLiteralExpression;
import org.eclipse.cdt.internal.core.parser.ast.complete.ASTNewExpression;
import org.eclipse.cdt.internal.core.parser.ast.complete.ASTScope;
import org.eclipse.cdt.internal.core.parser.ast.complete.ASTTypeIdExpression;
import org.eclipse.cdt.internal.core.parser.ast.complete.ASTUnaryExpression;
import org.eclipse.cdt.internal.core.parser.ast.complete.ASTUnaryIdExpression;
import org.eclipse.cdt.internal.core.parser.ast.complete.ASTUnaryTypeIdExpression;
import org.eclipse.cdt.internal.core.parser.ast.complete.ASTVariableReference;

import de.fzi.sissy.extractors.cdt.ast.ExtendedReference;
import de.fzi.sissy.util.Debug;

/**
 * @author haller
 */
public class Callback2 implements ISourceElementRequestor, ASTMapper {

	protected IASTCompilationUnit compUnit = null;
	protected List inclusions = new ArrayList();
	protected List macros = new ArrayList();
	protected List importedGlobalFunctions = new ArrayList();
	protected List importedGlobalVariables = new ArrayList();
	
    protected StatementTracker tracker = StatementTracker.getInstance();
	
    public Iterator getInclusions() {
		return inclusions.iterator();
	}

	public Iterator getMacros() {
		return macros.iterator();
	}

	public Iterator getDeclarations() {
		try {
			return compUnit.getDeclarations();
		} catch (ASTNotImplementedException ne) {
			return null;
		}
	}

	public IASTCompilationUnit getCompilationUnit() {
		return compUnit;
	}

	protected LinkedList scopeStack = new LinkedList();
	protected IASTScope currentScope = null;
	protected int inclusionLevel = 0;

	public int getInclusionLevel() { return inclusionLevel; }
	
	private void addElement(IASTDeclaration element) {
		if (inclusionLevel == 0) {
			if (currentScope instanceof ASTScope) {
				Debug.cbinfo("adding declaration: " + element + " to " + currentScope);
				((ASTScope) currentScope).addDeclaration(element);
			}
			else if (currentScope instanceof ASTLinkageSpecification)
				((ASTLinkageSpecification) currentScope)
						.addDeclaration(element);
		}
	}

	public IASTScope getCurrentScope() { return currentScope; }
	
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
	
	//TODO: Don't use this any more!
	private void addRef(ISourceElementCallbackDelegate ref) {
		if (inclusionLevel == 0) {
			if (currentScope instanceof IASTFunction) {
				//System.out.println("Adding ref, scope: " + currentScope);

				RefCollector collector = (RefCollector) functionMap
						.get(currentScope);
				collector.addRef(ref);
			} else if (currentScope instanceof IASTClassSpecifier) {
				//System.out.println("Adding ref, scope: " + currentScope);

				RefCollector collector = (RefCollector) classSpecifierMap
						.get(currentScope);
				collector.addRef(ref);
			}
		}
	}
	
	private boolean extendedReferences = false;
	
	public void setExtendedReferences(boolean use) {
		extendedReferences = use;
	}
	
	private void extractReferences(ASTExpression expr, boolean write) {
		Iterator refs = expr.getReferences().iterator();
		while (refs.hasNext()) {
			IASTReference ref = (IASTReference) refs.next();
			ExtendedReference extRef = new ExtendedReference(ref, write);
			
			if (extendedReferences)
				addReferenceToCurrentStatement(extRef);
		}
	}
	
	public void processExpression(ASTEmptyExpression expr, boolean write) {
		extractReferences(expr, write);
	}
	
	public void processExpression(ASTIdExpression expr, boolean write) {
		extractReferences(expr, write);
	}
	
	public void processExpression(ASTUnaryIdExpression expr, boolean write) {
		extractReferences(expr, write);
		processExpression(expr.getLHSExpression(), write);
	}
	
	public void processExpression(ASTLiteralExpression expr, boolean write) {
		extractReferences(expr, write);
	}
	
	public void processExpression(ASTNewExpression expr, boolean write) {
		extractReferences(expr, write);
	}
	
	public void processExpression(ASTTypeIdExpression expr, boolean write) {
		extractReferences(expr, write);
	}
	
	public void processExpression(ASTUnaryExpression expr, boolean write) {
		extractReferences(expr, write);
		
		if ((expr.getExpressionKind() == IASTExpression.Kind.UNARY_DECREMENT)
				|| (expr.getExpressionKind() == IASTExpression.Kind.UNARY_INCREMENT))
			processExpression(expr.getLHSExpression(), true);
		else {
			processExpression(expr.getLHSExpression(), write);
		}
	}
	
	public void processExpression(ASTBinaryExpression expr, boolean write) {
		extractReferences(expr, write);
		
		Debug.cbinfo("expr: " + expr.getReferences().size());
		Debug.cbinfo("lhs: " + ((ASTExpression) expr.getLHSExpression()).getReferences().size());
		Debug.cbinfo("rhs: " + ((ASTExpression) expr.getRHSExpression()).getReferences().size());
		
		if ((expr.getExpressionKind() == IASTExpression.Kind.ASSIGNMENTEXPRESSION_AND)
				|| (expr.getExpressionKind() == IASTExpression.Kind.ASSIGNMENTEXPRESSION_DIV)
				|| (expr.getExpressionKind() == IASTExpression.Kind.ASSIGNMENTEXPRESSION_LSHIFT)
				|| (expr.getExpressionKind() == IASTExpression.Kind.ASSIGNMENTEXPRESSION_MINUS)
				|| (expr.getExpressionKind() == IASTExpression.Kind.ASSIGNMENTEXPRESSION_MOD)
				|| (expr.getExpressionKind() == IASTExpression.Kind.ASSIGNMENTEXPRESSION_MULT)
				|| (expr.getExpressionKind() == IASTExpression.Kind.ASSIGNMENTEXPRESSION_NORMAL)
				|| (expr.getExpressionKind() == IASTExpression.Kind.ASSIGNMENTEXPRESSION_OR)
				|| (expr.getExpressionKind() == IASTExpression.Kind.ASSIGNMENTEXPRESSION_PLUS)
				|| (expr.getExpressionKind() == IASTExpression.Kind.ASSIGNMENTEXPRESSION_RSHIFT)
				|| (expr.getExpressionKind() == IASTExpression.Kind.ASSIGNMENTEXPRESSION_XOR)
				|| (expr.getExpressionKind() == IASTExpression.Kind.POSTFIX_DECREMENT)
				|| (expr.getExpressionKind() == IASTExpression.Kind.POSTFIX_INCREMENT)) {
			IASTExpression left = expr.getLHSExpression();
			IASTExpression right = expr.getRHSExpression();
			processExpression(left, true);
			processExpression(right, write);
		}
		else {
			IASTExpression left = expr.getLHSExpression();
			IASTExpression right = expr.getRHSExpression();
			processExpression(left, write);
			processExpression(right, write);
		}
	}
	
	public void processExpression(ASTConditionalExpression expr, boolean write) {
		extractReferences(expr, write);
		
		// dreiteiliger Ausdruck (? :)
		processExpression(expr.getLHSExpression(), write);
		processExpression(expr.getRHSExpression(), write);
		processExpression(expr.getThirdExpression(), write);
	}
	
	public void processExpression(ASTUnaryTypeIdExpression expr, boolean write) {
		extractReferences(expr, write);
		
		processExpression(expr.getLHSExpression(), write);
	}
	
	public void processExpression(IASTExpression expr, boolean write) {
		Debug.cbinfo("processing expression: " + expr);
		
		if (expr instanceof ASTEmptyExpression)
			processExpression((ASTEmptyExpression)expr, write);
		
		else if (expr instanceof ASTIdExpression)
			processExpression((ASTIdExpression)expr, write);
		
		else if (expr instanceof ASTUnaryIdExpression)
			processExpression((ASTUnaryIdExpression)expr, write);
		
		else if (expr instanceof ASTLiteralExpression)
			processExpression((ASTLiteralExpression)expr, write);

		else if (expr instanceof ASTNewExpression)
			processExpression((ASTNewExpression)expr, write);
		
		else if (expr instanceof ASTTypeIdExpression)
			processExpression((ASTTypeIdExpression)expr, write);
		
		else if (expr instanceof ASTUnaryExpression)
			processExpression((ASTUnaryExpression)expr, write);
		
		else if (expr instanceof ASTBinaryExpression)
			processExpression((ASTBinaryExpression)expr, write);
		
		else if (expr instanceof ASTConditionalExpression)
			processExpression((ASTConditionalExpression)expr, write);

		else if (expr instanceof ASTUnaryTypeIdExpression)
			processExpression((ASTUnaryTypeIdExpression)expr, write);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptProblem(org.eclipse.cdt.core.parser.IProblem)
	 */
	public boolean acceptProblem(IProblem problem) {
		//TODO: siehe auch DefaultProblemHandler (immer true oder immer false?)
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptMacro(org.eclipse.cdt.core.parser.ast.IASTMacro)
	 */
	public void acceptMacro(IASTMacro macro) {
		if(inclusionLevel == 0)
			macros.add(macro);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptVariable(org.eclipse.cdt.core.parser.ast.IASTVariable)
	 */
	public void acceptVariable(IASTVariable variable) {
		Debug.cbinfo("accept variable: " + variable.getName());
		addElement(variable);
        
		addRef(variable);  // obsolet?
        
        ASTVariableReference ref = new ASTVariableReference(variable.getStartingOffset(), variable);
        addReferenceToCurrentStatement(ref);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptFunctionDeclaration(org.eclipse.cdt.core.parser.ast.IASTFunction)
	 */
	public void acceptFunctionDeclaration(IASTFunction function) {
		//TODO: Support for function prototype declarations:
		// check if function has body
		// if not => prototype: add to importedGlobalFunctions
		
		// Note: "extern" is not supported in CDT 2.1
        // (see e-mail on cdt-core-dev list)
        
		IASTAbstractDeclaration decl = function.getReturnType();
		Debug.cbinfo(decl);
		Debug.cbinfo(decl.getParameters());
		
		Iterator params = decl.getParameters();
		while (params.hasNext()) {
			Object p = (Object) params.next();
			Debug.cbinfo(p.getClass());
			Debug.cbinfo(p);
		}
		
		if (function.getOwnerTemplateDeclaration() == null)
			addElement(function);
		else if (function.getOwnerTemplateDeclaration() instanceof IASTTemplateDeclaration)
			addElement((IASTTemplateDeclaration) function
					.getOwnerTemplateDeclaration());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptUsingDirective(org.eclipse.cdt.core.parser.ast.IASTUsingDirective)
	 */
	public void acceptUsingDirective(IASTUsingDirective usageDirective) {

    }

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptUsingDeclaration(org.eclipse.cdt.core.parser.ast.IASTUsingDeclaration)
	 */
	public void acceptUsingDeclaration(IASTUsingDeclaration usageDeclaration) {

    }

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptASMDefinition(org.eclipse.cdt.core.parser.ast.IASTASMDefinition)
	 */
	public void acceptASMDefinition(IASTASMDefinition asmDefinition) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptTypedefDeclaration(org.eclipse.cdt.core.parser.ast.IASTTypedefDeclaration)
	 */
	public void acceptTypedefDeclaration(IASTTypedefDeclaration typedef) {
		Debug.cbinfo("adding typedef decl: " + typedef.getName());
        addElement(typedef);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptEnumerationSpecifier(org.eclipse.cdt.core.parser.ast.IASTEnumerationSpecifier)
	 */
	public void acceptEnumerationSpecifier(IASTEnumerationSpecifier enumeration) {
		enterScope(enumeration);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptElaboratedForewardDeclaration(org.eclipse.cdt.core.parser.ast.IASTElaboratedTypeSpecifier)
	 */
	public void acceptElaboratedForewardDeclaration(IASTElaboratedTypeSpecifier elaboratedType) {
		Debug.cbinfo(elaboratedType);
		enterScope(elaboratedType);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptAbstractTypeSpecDeclaration(org.eclipse.cdt.core.parser.ast.IASTAbstractTypeSpecifierDeclaration)
	 */
	public void acceptAbstractTypeSpecDeclaration(
			IASTAbstractTypeSpecifierDeclaration abstractDeclaration) {
		Debug.cbinfo(abstractDeclaration);
		
		if (abstractDeclaration.getOwnerTemplateDeclaration() == null)
			addElement(abstractDeclaration);
		else if (abstractDeclaration.getOwnerTemplateDeclaration() instanceof IASTTemplateDeclaration)
			addElement((IASTTemplateDeclaration) abstractDeclaration
					.getOwnerTemplateDeclaration());
	}


	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptAbstractTypeSpecDeclaration(org.eclipse.cdt.core.parser.ast.IASTAbstractTypeSpecifierDeclaration)
	 */
	public void acceptExpression(
			IASTExpression expression) {
		processExpression(expression, false);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#enterFunctionBody(org.eclipse.cdt.core.parser.ast.IASTFunction)
	 */
	public void enterFunctionBody(IASTFunction function) {
		if (function.getOwnerTemplateDeclaration() == null)
			addElement(function);
		else if (function.getOwnerTemplateDeclaration() instanceof IASTTemplateDeclaration)
			addElement((IASTTemplateDeclaration) function
					.getOwnerTemplateDeclaration());
		
		if (functionMap.get(function) == null) {
			RefCollector collector = new RefCollector();
			functionMap.put(function, collector);
		}
		
		enterScope(function);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#exitFunctionBody(org.eclipse.cdt.core.parser.ast.IASTFunction)
	 */
	public void exitFunctionBody(IASTFunction function) {
		function.setHasFunctionBody(true);
		exitScope(function);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#enterCodeBlock(org.eclipse.cdt.core.parser.ast.IASTCodeScope)
	 */
	public void enterCodeBlock(IASTCodeScope scope) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#exitCodeBlock(org.eclipse.cdt.core.parser.ast.IASTCodeScope)
	 */
	public void exitCodeBlock(IASTCodeScope scope) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#enterCompilationUnit(org.eclipse.cdt.core.parser.ast.IASTCompilationUnit)
	 */
	public void enterCompilationUnit(IASTCompilationUnit compilationUnit) {
		enterScope(compilationUnit);
	}

	// Stack of named inclusions
	Stack inclStack = new Stack();
	
	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#enterInclusion(org.eclipse.cdt.core.parser.ast.IASTInclusion)
	 */
	public void enterInclusion(IASTInclusion inclusion) {
		inclStack.push(inclusion.getFullFileName());

		if (inclusionLevel == 0)
			inclusions.add(inclusion);

		inclusionLevel++;

		Debug.cbinfo("new inclusion level: " + inclusionLevel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#enterNamespaceDefinition(org.eclipse.cdt.core.parser.ast.IASTNamespaceDefinition)
	 */
	public void enterNamespaceDefinition(IASTNamespaceDefinition namespaceDefinition) {
		addElement(namespaceDefinition);
		enterScope(namespaceDefinition);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#enterClassSpecifier(org.eclipse.cdt.core.parser.ast.IASTClassSpecifier)
	 */
	public void enterClassSpecifier(IASTClassSpecifier classSpecification) {
		Debug.cbinfo("enter class: " + classSpecification.getName());
		
		if (classSpecifierMap.get(classSpecification) == null) {
			RefCollector collector = new RefCollector();
			classSpecifierMap.put(classSpecification, collector);
		}
		
		enterScope(classSpecification);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#enterLinkageSpecification(org.eclipse.cdt.core.parser.ast.IASTLinkageSpecification)
	 */
	public void enterLinkageSpecification(IASTLinkageSpecification linkageSpec) {
		addElement(linkageSpec);
		enterScope(linkageSpec);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#enterTemplateDeclaration(org.eclipse.cdt.core.parser.ast.IASTTemplateDeclaration)
	 */
	public void enterTemplateDeclaration(IASTTemplateDeclaration declaration) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#enterTemplateSpecialization(org.eclipse.cdt.core.parser.ast.IASTTemplateSpecialization)
	 */
	public void enterTemplateSpecialization(IASTTemplateSpecialization specialization) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#enterTemplateInstantiation(org.eclipse.cdt.core.parser.ast.IASTTemplateInstantiation)
	 */
	public void enterTemplateInstantiation(IASTTemplateInstantiation instantiation) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptMethodDeclaration(org.eclipse.cdt.core.parser.ast.IASTMethod)
	 */
	public void acceptMethodDeclaration(IASTMethod method) {
		if (method.getOwnerTemplateDeclaration() == null)
			addElement(method);
		else if (method.getOwnerTemplateDeclaration() instanceof IASTTemplateDeclaration)
			addElement((IASTTemplateDeclaration) method
					.getOwnerTemplateDeclaration());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#enterMethodBody(org.eclipse.cdt.core.parser.ast.IASTMethod)
	 */
	public void enterMethodBody(IASTMethod method) {
		Debug.cbinfo("enter method (" + inclusionLevel + "): " + Util.reduce(method.getFullyQualifiedName()) + " (" + method + ")");
		
		if (method.getOwnerTemplateDeclaration() == null)
			addElement(method);
		else if (method.getOwnerTemplateDeclaration() instanceof IASTTemplateDeclaration)
			addElement((IASTTemplateDeclaration) method
					.getOwnerTemplateDeclaration());
		
		if (functionMap.get(method) == null) {
			RefCollector collector = new RefCollector();
			functionMap.put(method, collector);
		}
		
		enterScope(method);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#exitMethodBody(org.eclipse.cdt.core.parser.ast.IASTMethod)
	 */
	public void exitMethodBody(IASTMethod method) {
		//System.out.println("exit method: " + Util.reduce(method.getFullyQualifiedName()));
		
		method.setHasFunctionBody(true);
		exitScope(method);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptField(org.eclipse.cdt.core.parser.ast.IASTField)
	 */
	public void acceptField(IASTField field) {
		addElement(field);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptClassReference(org.eclipse.cdt.core.parser.ast.IASTClassReference)
	 */
	public void acceptClassReference(IASTClassReference reference) {
		IASTClassSpecifier classSpec = (IASTClassSpecifier) reference.getReferencedElement();
		addRef(classSpec);
        
		if (!extendedReferences)
			addReferenceToCurrentStatement(reference);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptTypedefReference(org.eclipse.cdt.core.parser.ast.IASTTypedefReference)
	 */
	public void acceptTypedefReference(IASTTypedefReference reference) {
		IASTTypedefDeclaration typeDefDecl = (IASTTypedefDeclaration) reference.getReferencedElement();
		addRef(typeDefDecl);
        
		if (!extendedReferences)
			addReferenceToCurrentStatement(reference);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptNamespaceReference(org.eclipse.cdt.core.parser.ast.IASTNamespaceReference)
	 */
	public void acceptNamespaceReference(IASTNamespaceReference reference) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptEnumerationReference(org.eclipse.cdt.core.parser.ast.IASTEnumerationReference)
	 */
	public void acceptEnumerationReference(IASTEnumerationReference reference) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptVariableReference(org.eclipse.cdt.core.parser.ast.IASTVariableReference)
	 */
	public void acceptVariableReference(IASTVariableReference reference) {
		IASTVariable var = (IASTVariable) reference.getReferencedElement();
        Debug.cbinfo("referenced variable: " + var.getName());
        addRef(var);
        
        if (!extendedReferences)
        	addReferenceToCurrentStatement(reference);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptFunctionReference(org.eclipse.cdt.core.parser.ast.IASTFunctionReference)
	 */
	public void acceptFunctionReference(IASTFunctionReference reference) {
		IASTFunction fun = (IASTFunction) reference.getReferencedElement();
        Debug.cbinfo("referenced function: " + fun.getName());
        addRef(fun);
        
        if (!extendedReferences)
        	addReferenceToCurrentStatement(reference);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptFieldReference(org.eclipse.cdt.core.parser.ast.IASTFieldReference)
	 */
	public void acceptFieldReference(IASTFieldReference reference) {
		IASTField fld = (IASTField) reference.getReferencedElement();
		addRef(fld);
        
		if (!extendedReferences)
			addReferenceToCurrentStatement(reference);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptMethodReference(org.eclipse.cdt.core.parser.ast.IASTMethodReference)
	 */
	public void acceptMethodReference(IASTMethodReference reference) {
		IASTMethod method = (IASTMethod) reference.getReferencedElement();
		Debug.cbinfo("referenced method: " + method.getName());
		addRef(method);
		
		if (!extendedReferences)
			addReferenceToCurrentStatement(reference);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptEnumeratorReference(org.eclipse.cdt.core.parser.ast.IASTEnumeratorReference)
	 */
	public void acceptEnumeratorReference(IASTEnumeratorReference reference) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptParameterReference(org.eclipse.cdt.core.parser.ast.IASTParameterReference)
	 */
	public void acceptParameterReference(IASTParameterReference reference) {
		IASTParameterDeclaration paramDecl = (IASTParameterDeclaration) reference.getReferencedElement();
		addRef(paramDecl);
        
		if (!extendedReferences)
			addReferenceToCurrentStatement(reference);
	}

	private void addReferenceToCurrentStatement(IASTReference ref) {
		// add reference to current statement
        if ((tracker.getCurrentStatement() != null) && (inclusionLevel == 0))
            tracker.getCurrentStatement().addReference(ref);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptTemplateParameterReference(org.eclipse.cdt.core.parser.ast.IASTTemplateParameterReference)
	 */
	public void acceptTemplateParameterReference(IASTTemplateParameterReference reference) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#acceptFriendDeclaration(org.eclipse.cdt.core.parser.ast.IASTDeclaration)
	 */
	public void acceptFriendDeclaration(IASTDeclaration declaration) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#exitTemplateDeclaration(org.eclipse.cdt.core.parser.ast.IASTTemplateDeclaration)
	 */
	public void exitTemplateDeclaration(IASTTemplateDeclaration declaration) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#exitTemplateSpecialization(org.eclipse.cdt.core.parser.ast.IASTTemplateSpecialization)
	 */
	public void exitTemplateSpecialization(IASTTemplateSpecialization specialization) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#exitTemplateExplicitInstantiation(org.eclipse.cdt.core.parser.ast.IASTTemplateInstantiation)
	 */
	public void exitTemplateExplicitInstantiation(IASTTemplateInstantiation instantiation) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#exitLinkageSpecification(org.eclipse.cdt.core.parser.ast.IASTLinkageSpecification)
	 */
	public void exitLinkageSpecification(IASTLinkageSpecification linkageSpec) {
		exitScope(linkageSpec);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#exitClassSpecifier(org.eclipse.cdt.core.parser.ast.IASTClassSpecifier)
	 */
	public void exitClassSpecifier(IASTClassSpecifier classSpecification) {
		exitScope(classSpecification);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#exitNamespaceDefinition(org.eclipse.cdt.core.parser.ast.IASTNamespaceDefinition)
	 */
	public void exitNamespaceDefinition(IASTNamespaceDefinition namespaceDefinition) {
		exitScope(namespaceDefinition);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#exitInclusion(org.eclipse.cdt.core.parser.ast.IASTInclusion)
	 */
	public void exitInclusion(IASTInclusion inclusion) {
		// pop inclusion stack only if the inclusion we are exiting is on top
		// (avoid multiple exiting and decrementing of level)
		
		if (((String)inclStack.peek()).equals(inclusion.getFullFileName())) {
			inclStack.pop();
			inclusionLevel--;
			Debug.cbinfo("new inclusion level: " + inclusionLevel);
		}
		// else do nothing
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#exitCompilationUnit(org.eclipse.cdt.core.parser.ast.IASTCompilationUnit)
	 */
	public void exitCompilationUnit(IASTCompilationUnit compilationUnit) {
		this.compUnit = compilationUnit;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#createReader(java.lang.String, java.util.Iterator)
	 */
	public CodeReader createReader(String finalPath, Iterator workingCopies) {
		return InternalParserUtil.createFileReader(finalPath);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.ISourceElementRequestor#parserTimeout()
	 */
	public boolean parserTimeout() {
		return false;
	}

	// is reference a write access?
	HashMap referenceInfo = new HashMap();
	
	/* (non-Javadoc)
	 * @see de.fzi.sissy.extractors.cdt.ASTMapper#getReferenceMap()
	 */
	public HashMap getReferenceMap() {
		return referenceInfo;
	}

	public void setIsWriteAccess(IASTReference ref) {
		referenceInfo.put(ref, new Boolean(true));
	}
}
