/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.stoex.util;

import de.uka.ipd.sdq.stoex.*;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.Atom;
import de.uka.ipd.sdq.stoex.BoolLiteral;
import de.uka.ipd.sdq.stoex.BooleanExpression;
import de.uka.ipd.sdq.stoex.BooleanOperatorExpression;
import de.uka.ipd.sdq.stoex.CompareExpression;
import de.uka.ipd.sdq.stoex.Comparison;
import de.uka.ipd.sdq.stoex.DoubleLiteral;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.FunctionLiteral;
import de.uka.ipd.sdq.stoex.IfElse;
import de.uka.ipd.sdq.stoex.IfElseExpression;
import de.uka.ipd.sdq.stoex.IntLiteral;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.NegativeExpression;
import de.uka.ipd.sdq.stoex.NotExpression;
import de.uka.ipd.sdq.stoex.NumericLiteral;
import de.uka.ipd.sdq.stoex.Parenthesis;
import de.uka.ipd.sdq.stoex.Power;
import de.uka.ipd.sdq.stoex.PowerExpression;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.stoex.Product;
import de.uka.ipd.sdq.stoex.ProductExpression;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.StoexPackage;
import de.uka.ipd.sdq.stoex.StringLiteral;
import de.uka.ipd.sdq.stoex.Term;
import de.uka.ipd.sdq.stoex.TermExpression;
import de.uka.ipd.sdq.stoex.Unary;
import de.uka.ipd.sdq.stoex.Variable;
import de.uka.ipd.sdq.stoex.VariableReference;
import de.uka.ipd.sdq.units.UnitCarryingElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.stoex.StoexPackage
 * @generated
 */
public class StoexSwitch<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007-2009, SDQ, IPD, U Karlsruhe";
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StoexPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoexSwitch() {
		if (modelPackage == null) {
			modelPackage = StoexPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case StoexPackage.VARIABLE_REFERENCE: {
				VariableReference variableReference = (VariableReference)theEObject;
				T result = caseVariableReference(variableReference);
				if (result == null) result = caseAbstractNamedReference(variableReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.ABSTRACT_NAMED_REFERENCE: {
				AbstractNamedReference abstractNamedReference = (AbstractNamedReference)theEObject;
				T result = caseAbstractNamedReference(abstractNamedReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.NAMESPACE_REFERENCE: {
				NamespaceReference namespaceReference = (NamespaceReference)theEObject;
				T result = caseNamespaceReference(namespaceReference);
				if (result == null) result = caseAbstractNamedReference(namespaceReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.VARIABLE: {
				Variable variable = (Variable)theEObject;
				T result = caseVariable(variable);
				if (result == null) result = caseAtom(variable);
				if (result == null) result = caseUnary(variable);
				if (result == null) result = casePower(variable);
				if (result == null) result = caseProduct(variable);
				if (result == null) result = caseTerm(variable);
				if (result == null) result = caseComparison(variable);
				if (result == null) result = caseBooleanExpression(variable);
				if (result == null) result = caseIfElse(variable);
				if (result == null) result = caseExpression(variable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.ATOM: {
				Atom atom = (Atom)theEObject;
				T result = caseAtom(atom);
				if (result == null) result = caseUnary(atom);
				if (result == null) result = casePower(atom);
				if (result == null) result = caseProduct(atom);
				if (result == null) result = caseTerm(atom);
				if (result == null) result = caseComparison(atom);
				if (result == null) result = caseBooleanExpression(atom);
				if (result == null) result = caseIfElse(atom);
				if (result == null) result = caseExpression(atom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.UNARY: {
				Unary unary = (Unary)theEObject;
				T result = caseUnary(unary);
				if (result == null) result = casePower(unary);
				if (result == null) result = caseProduct(unary);
				if (result == null) result = caseTerm(unary);
				if (result == null) result = caseComparison(unary);
				if (result == null) result = caseBooleanExpression(unary);
				if (result == null) result = caseIfElse(unary);
				if (result == null) result = caseExpression(unary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.POWER: {
				Power power = (Power)theEObject;
				T result = casePower(power);
				if (result == null) result = caseProduct(power);
				if (result == null) result = caseTerm(power);
				if (result == null) result = caseComparison(power);
				if (result == null) result = caseBooleanExpression(power);
				if (result == null) result = caseIfElse(power);
				if (result == null) result = caseExpression(power);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.PRODUCT: {
				Product product = (Product)theEObject;
				T result = caseProduct(product);
				if (result == null) result = caseTerm(product);
				if (result == null) result = caseComparison(product);
				if (result == null) result = caseBooleanExpression(product);
				if (result == null) result = caseIfElse(product);
				if (result == null) result = caseExpression(product);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.TERM: {
				Term term = (Term)theEObject;
				T result = caseTerm(term);
				if (result == null) result = caseComparison(term);
				if (result == null) result = caseBooleanExpression(term);
				if (result == null) result = caseIfElse(term);
				if (result == null) result = caseExpression(term);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.COMPARISON: {
				Comparison comparison = (Comparison)theEObject;
				T result = caseComparison(comparison);
				if (result == null) result = caseBooleanExpression(comparison);
				if (result == null) result = caseIfElse(comparison);
				if (result == null) result = caseExpression(comparison);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.BOOLEAN_EXPRESSION: {
				BooleanExpression booleanExpression = (BooleanExpression)theEObject;
				T result = caseBooleanExpression(booleanExpression);
				if (result == null) result = caseIfElse(booleanExpression);
				if (result == null) result = caseExpression(booleanExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.IF_ELSE: {
				IfElse ifElse = (IfElse)theEObject;
				T result = caseIfElse(ifElse);
				if (result == null) result = caseExpression(ifElse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.TERM_EXPRESSION: {
				TermExpression termExpression = (TermExpression)theEObject;
				T result = caseTermExpression(termExpression);
				if (result == null) result = caseTerm(termExpression);
				if (result == null) result = caseComparison(termExpression);
				if (result == null) result = caseBooleanExpression(termExpression);
				if (result == null) result = caseIfElse(termExpression);
				if (result == null) result = caseExpression(termExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.PRODUCT_EXPRESSION: {
				ProductExpression productExpression = (ProductExpression)theEObject;
				T result = caseProductExpression(productExpression);
				if (result == null) result = caseProduct(productExpression);
				if (result == null) result = caseTerm(productExpression);
				if (result == null) result = caseComparison(productExpression);
				if (result == null) result = caseBooleanExpression(productExpression);
				if (result == null) result = caseIfElse(productExpression);
				if (result == null) result = caseExpression(productExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.PROBABILITY_FUNCTION_LITERAL: {
				ProbabilityFunctionLiteral probabilityFunctionLiteral = (ProbabilityFunctionLiteral)theEObject;
				T result = caseProbabilityFunctionLiteral(probabilityFunctionLiteral);
				if (result == null) result = caseAtom(probabilityFunctionLiteral);
				if (result == null) result = caseUnary(probabilityFunctionLiteral);
				if (result == null) result = casePower(probabilityFunctionLiteral);
				if (result == null) result = caseProduct(probabilityFunctionLiteral);
				if (result == null) result = caseTerm(probabilityFunctionLiteral);
				if (result == null) result = caseComparison(probabilityFunctionLiteral);
				if (result == null) result = caseBooleanExpression(probabilityFunctionLiteral);
				if (result == null) result = caseIfElse(probabilityFunctionLiteral);
				if (result == null) result = caseExpression(probabilityFunctionLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.PARENTHESIS: {
				Parenthesis parenthesis = (Parenthesis)theEObject;
				T result = caseParenthesis(parenthesis);
				if (result == null) result = caseAtom(parenthesis);
				if (result == null) result = caseUnary(parenthesis);
				if (result == null) result = casePower(parenthesis);
				if (result == null) result = caseProduct(parenthesis);
				if (result == null) result = caseTerm(parenthesis);
				if (result == null) result = caseComparison(parenthesis);
				if (result == null) result = caseBooleanExpression(parenthesis);
				if (result == null) result = caseIfElse(parenthesis);
				if (result == null) result = caseExpression(parenthesis);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.NUMERIC_LITERAL: {
				NumericLiteral numericLiteral = (NumericLiteral)theEObject;
				T result = caseNumericLiteral(numericLiteral);
				if (result == null) result = caseUnitCarryingElement(numericLiteral);
				if (result == null) result = caseAtom(numericLiteral);
				if (result == null) result = caseUnary(numericLiteral);
				if (result == null) result = casePower(numericLiteral);
				if (result == null) result = caseProduct(numericLiteral);
				if (result == null) result = caseTerm(numericLiteral);
				if (result == null) result = caseComparison(numericLiteral);
				if (result == null) result = caseBooleanExpression(numericLiteral);
				if (result == null) result = caseIfElse(numericLiteral);
				if (result == null) result = caseExpression(numericLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.INT_LITERAL: {
				IntLiteral intLiteral = (IntLiteral)theEObject;
				T result = caseIntLiteral(intLiteral);
				if (result == null) result = caseNumericLiteral(intLiteral);
				if (result == null) result = caseUnitCarryingElement(intLiteral);
				if (result == null) result = caseAtom(intLiteral);
				if (result == null) result = caseUnary(intLiteral);
				if (result == null) result = casePower(intLiteral);
				if (result == null) result = caseProduct(intLiteral);
				if (result == null) result = caseTerm(intLiteral);
				if (result == null) result = caseComparison(intLiteral);
				if (result == null) result = caseBooleanExpression(intLiteral);
				if (result == null) result = caseIfElse(intLiteral);
				if (result == null) result = caseExpression(intLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.DOUBLE_LITERAL: {
				DoubleLiteral doubleLiteral = (DoubleLiteral)theEObject;
				T result = caseDoubleLiteral(doubleLiteral);
				if (result == null) result = caseNumericLiteral(doubleLiteral);
				if (result == null) result = caseUnitCarryingElement(doubleLiteral);
				if (result == null) result = caseAtom(doubleLiteral);
				if (result == null) result = caseUnary(doubleLiteral);
				if (result == null) result = casePower(doubleLiteral);
				if (result == null) result = caseProduct(doubleLiteral);
				if (result == null) result = caseTerm(doubleLiteral);
				if (result == null) result = caseComparison(doubleLiteral);
				if (result == null) result = caseBooleanExpression(doubleLiteral);
				if (result == null) result = caseIfElse(doubleLiteral);
				if (result == null) result = caseExpression(doubleLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.COMPARE_EXPRESSION: {
				CompareExpression compareExpression = (CompareExpression)theEObject;
				T result = caseCompareExpression(compareExpression);
				if (result == null) result = caseComparison(compareExpression);
				if (result == null) result = caseBooleanExpression(compareExpression);
				if (result == null) result = caseIfElse(compareExpression);
				if (result == null) result = caseExpression(compareExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.BOOL_LITERAL: {
				BoolLiteral boolLiteral = (BoolLiteral)theEObject;
				T result = caseBoolLiteral(boolLiteral);
				if (result == null) result = caseAtom(boolLiteral);
				if (result == null) result = caseUnary(boolLiteral);
				if (result == null) result = casePower(boolLiteral);
				if (result == null) result = caseProduct(boolLiteral);
				if (result == null) result = caseTerm(boolLiteral);
				if (result == null) result = caseComparison(boolLiteral);
				if (result == null) result = caseBooleanExpression(boolLiteral);
				if (result == null) result = caseIfElse(boolLiteral);
				if (result == null) result = caseExpression(boolLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.STRING_LITERAL: {
				StringLiteral stringLiteral = (StringLiteral)theEObject;
				T result = caseStringLiteral(stringLiteral);
				if (result == null) result = caseAtom(stringLiteral);
				if (result == null) result = caseUnary(stringLiteral);
				if (result == null) result = casePower(stringLiteral);
				if (result == null) result = caseProduct(stringLiteral);
				if (result == null) result = caseTerm(stringLiteral);
				if (result == null) result = caseComparison(stringLiteral);
				if (result == null) result = caseBooleanExpression(stringLiteral);
				if (result == null) result = caseIfElse(stringLiteral);
				if (result == null) result = caseExpression(stringLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.POWER_EXPRESSION: {
				PowerExpression powerExpression = (PowerExpression)theEObject;
				T result = casePowerExpression(powerExpression);
				if (result == null) result = casePower(powerExpression);
				if (result == null) result = caseProduct(powerExpression);
				if (result == null) result = caseTerm(powerExpression);
				if (result == null) result = caseComparison(powerExpression);
				if (result == null) result = caseBooleanExpression(powerExpression);
				if (result == null) result = caseIfElse(powerExpression);
				if (result == null) result = caseExpression(powerExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.BOOLEAN_OPERATOR_EXPRESSION: {
				BooleanOperatorExpression booleanOperatorExpression = (BooleanOperatorExpression)theEObject;
				T result = caseBooleanOperatorExpression(booleanOperatorExpression);
				if (result == null) result = caseBooleanExpression(booleanOperatorExpression);
				if (result == null) result = caseIfElse(booleanOperatorExpression);
				if (result == null) result = caseExpression(booleanOperatorExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.NOT_EXPRESSION: {
				NotExpression notExpression = (NotExpression)theEObject;
				T result = caseNotExpression(notExpression);
				if (result == null) result = caseUnary(notExpression);
				if (result == null) result = casePower(notExpression);
				if (result == null) result = caseProduct(notExpression);
				if (result == null) result = caseTerm(notExpression);
				if (result == null) result = caseComparison(notExpression);
				if (result == null) result = caseBooleanExpression(notExpression);
				if (result == null) result = caseIfElse(notExpression);
				if (result == null) result = caseExpression(notExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.NEGATIVE_EXPRESSION: {
				NegativeExpression negativeExpression = (NegativeExpression)theEObject;
				T result = caseNegativeExpression(negativeExpression);
				if (result == null) result = caseUnary(negativeExpression);
				if (result == null) result = casePower(negativeExpression);
				if (result == null) result = caseProduct(negativeExpression);
				if (result == null) result = caseTerm(negativeExpression);
				if (result == null) result = caseComparison(negativeExpression);
				if (result == null) result = caseBooleanExpression(negativeExpression);
				if (result == null) result = caseIfElse(negativeExpression);
				if (result == null) result = caseExpression(negativeExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.FUNCTION_LITERAL: {
				FunctionLiteral functionLiteral = (FunctionLiteral)theEObject;
				T result = caseFunctionLiteral(functionLiteral);
				if (result == null) result = caseAtom(functionLiteral);
				if (result == null) result = caseUnary(functionLiteral);
				if (result == null) result = casePower(functionLiteral);
				if (result == null) result = caseProduct(functionLiteral);
				if (result == null) result = caseTerm(functionLiteral);
				if (result == null) result = caseComparison(functionLiteral);
				if (result == null) result = caseBooleanExpression(functionLiteral);
				if (result == null) result = caseIfElse(functionLiteral);
				if (result == null) result = caseExpression(functionLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.IF_ELSE_EXPRESSION: {
				IfElseExpression ifElseExpression = (IfElseExpression)theEObject;
				T result = caseIfElseExpression(ifElseExpression);
				if (result == null) result = caseIfElse(ifElseExpression);
				if (result == null) result = caseExpression(ifElseExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.RANDOM_VARIABLE: {
				RandomVariable randomVariable = (RandomVariable)theEObject;
				T result = caseRandomVariable(randomVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableReference(VariableReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Named Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Named Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractNamedReference(AbstractNamedReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespace Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespace Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamespaceReference(NamespaceReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariable(Variable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Atom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Atom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAtom(Atom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnary(Unary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Power</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Power</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePower(Power object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Product</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Product</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProduct(Product object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerm(Term object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Comparison</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comparison</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComparison(Comparison object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanExpression(BooleanExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Else</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Else</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfElse(IfElse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Term Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Term Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTermExpression(TermExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Random Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Random Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRandomVariable(RandomVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Product Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Product Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProductExpression(ProductExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Probability Function Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Probability Function Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProbabilityFunctionLiteral(ProbabilityFunctionLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parenthesis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parenthesis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParenthesis(Parenthesis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numeric Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numeric Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumericLiteral(NumericLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntLiteral(IntLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleLiteral(DoubleLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compare Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compare Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompareExpression(CompareExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bool Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bool Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoolLiteral(BoolLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLiteral(StringLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Power Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Power Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePowerExpression(PowerExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Operator Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Operator Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanOperatorExpression(BooleanOperatorExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotExpression(NotExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Negative Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Negative Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNegativeExpression(NegativeExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionLiteral(FunctionLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Else Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Else Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfElseExpression(IfElseExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit Carrying Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit Carrying Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitCarryingElement(UnitCarryingElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //StoexSwitch
