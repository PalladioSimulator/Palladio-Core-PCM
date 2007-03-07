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
public class StoexSwitch {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ, IPD, U Karlsruhe (TH)";

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
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case StoexPackage.VARIABLE_REFERENCE: {
				VariableReference variableReference = (VariableReference)theEObject;
				Object result = caseVariableReference(variableReference);
				if (result == null) result = caseAbstractNamedReference(variableReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.ABSTRACT_NAMED_REFERENCE: {
				AbstractNamedReference abstractNamedReference = (AbstractNamedReference)theEObject;
				Object result = caseAbstractNamedReference(abstractNamedReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.NAMESPACE_REFERENCE: {
				NamespaceReference namespaceReference = (NamespaceReference)theEObject;
				Object result = caseNamespaceReference(namespaceReference);
				if (result == null) result = caseAbstractNamedReference(namespaceReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.VARIABLE: {
				Variable variable = (Variable)theEObject;
				Object result = caseVariable(variable);
				if (result == null) result = caseAtom(variable);
				if (result == null) result = casePower(variable);
				if (result == null) result = caseProduct(variable);
				if (result == null) result = caseTerm(variable);
				if (result == null) result = caseComparison(variable);
				if (result == null) result = caseExpression(variable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.ATOM: {
				Atom atom = (Atom)theEObject;
				Object result = caseAtom(atom);
				if (result == null) result = casePower(atom);
				if (result == null) result = caseProduct(atom);
				if (result == null) result = caseTerm(atom);
				if (result == null) result = caseComparison(atom);
				if (result == null) result = caseExpression(atom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.POWER: {
				Power power = (Power)theEObject;
				Object result = casePower(power);
				if (result == null) result = caseProduct(power);
				if (result == null) result = caseTerm(power);
				if (result == null) result = caseComparison(power);
				if (result == null) result = caseExpression(power);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.PRODUCT: {
				Product product = (Product)theEObject;
				Object result = caseProduct(product);
				if (result == null) result = caseTerm(product);
				if (result == null) result = caseComparison(product);
				if (result == null) result = caseExpression(product);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.TERM: {
				Term term = (Term)theEObject;
				Object result = caseTerm(term);
				if (result == null) result = caseComparison(term);
				if (result == null) result = caseExpression(term);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.COMPARISON: {
				Comparison comparison = (Comparison)theEObject;
				Object result = caseComparison(comparison);
				if (result == null) result = caseExpression(comparison);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				Object result = caseExpression(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.TERM_EXPRESSION: {
				TermExpression termExpression = (TermExpression)theEObject;
				Object result = caseTermExpression(termExpression);
				if (result == null) result = caseTerm(termExpression);
				if (result == null) result = caseComparison(termExpression);
				if (result == null) result = caseExpression(termExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.RANDOM_VARIABLE: {
				RandomVariable randomVariable = (RandomVariable)theEObject;
				Object result = caseRandomVariable(randomVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.PRODUCT_EXPRESSION: {
				ProductExpression productExpression = (ProductExpression)theEObject;
				Object result = caseProductExpression(productExpression);
				if (result == null) result = caseProduct(productExpression);
				if (result == null) result = caseTerm(productExpression);
				if (result == null) result = caseComparison(productExpression);
				if (result == null) result = caseExpression(productExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.PROBABILITY_FUNCTION_LITERAL: {
				ProbabilityFunctionLiteral probabilityFunctionLiteral = (ProbabilityFunctionLiteral)theEObject;
				Object result = caseProbabilityFunctionLiteral(probabilityFunctionLiteral);
				if (result == null) result = caseAtom(probabilityFunctionLiteral);
				if (result == null) result = casePower(probabilityFunctionLiteral);
				if (result == null) result = caseProduct(probabilityFunctionLiteral);
				if (result == null) result = caseTerm(probabilityFunctionLiteral);
				if (result == null) result = caseComparison(probabilityFunctionLiteral);
				if (result == null) result = caseExpression(probabilityFunctionLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.PARENTHESIS: {
				Parenthesis parenthesis = (Parenthesis)theEObject;
				Object result = caseParenthesis(parenthesis);
				if (result == null) result = caseAtom(parenthesis);
				if (result == null) result = casePower(parenthesis);
				if (result == null) result = caseProduct(parenthesis);
				if (result == null) result = caseTerm(parenthesis);
				if (result == null) result = caseComparison(parenthesis);
				if (result == null) result = caseExpression(parenthesis);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.NUMERIC_LITERAL: {
				NumericLiteral numericLiteral = (NumericLiteral)theEObject;
				Object result = caseNumericLiteral(numericLiteral);
				if (result == null) result = caseAtom(numericLiteral);
				if (result == null) result = casePower(numericLiteral);
				if (result == null) result = caseProduct(numericLiteral);
				if (result == null) result = caseTerm(numericLiteral);
				if (result == null) result = caseComparison(numericLiteral);
				if (result == null) result = caseExpression(numericLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.INT_LITERAL: {
				IntLiteral intLiteral = (IntLiteral)theEObject;
				Object result = caseIntLiteral(intLiteral);
				if (result == null) result = caseNumericLiteral(intLiteral);
				if (result == null) result = caseAtom(intLiteral);
				if (result == null) result = casePower(intLiteral);
				if (result == null) result = caseProduct(intLiteral);
				if (result == null) result = caseTerm(intLiteral);
				if (result == null) result = caseComparison(intLiteral);
				if (result == null) result = caseExpression(intLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.DOUBLE_LITERAL: {
				DoubleLiteral doubleLiteral = (DoubleLiteral)theEObject;
				Object result = caseDoubleLiteral(doubleLiteral);
				if (result == null) result = caseNumericLiteral(doubleLiteral);
				if (result == null) result = caseAtom(doubleLiteral);
				if (result == null) result = casePower(doubleLiteral);
				if (result == null) result = caseProduct(doubleLiteral);
				if (result == null) result = caseTerm(doubleLiteral);
				if (result == null) result = caseComparison(doubleLiteral);
				if (result == null) result = caseExpression(doubleLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.COMPARE_EXPRESSION: {
				CompareExpression compareExpression = (CompareExpression)theEObject;
				Object result = caseCompareExpression(compareExpression);
				if (result == null) result = caseComparison(compareExpression);
				if (result == null) result = caseExpression(compareExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.BOOL_LITERAL: {
				BoolLiteral boolLiteral = (BoolLiteral)theEObject;
				Object result = caseBoolLiteral(boolLiteral);
				if (result == null) result = caseAtom(boolLiteral);
				if (result == null) result = casePower(boolLiteral);
				if (result == null) result = caseProduct(boolLiteral);
				if (result == null) result = caseTerm(boolLiteral);
				if (result == null) result = caseComparison(boolLiteral);
				if (result == null) result = caseExpression(boolLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.STRING_LITERAL: {
				StringLiteral stringLiteral = (StringLiteral)theEObject;
				Object result = caseStringLiteral(stringLiteral);
				if (result == null) result = caseAtom(stringLiteral);
				if (result == null) result = casePower(stringLiteral);
				if (result == null) result = caseProduct(stringLiteral);
				if (result == null) result = caseTerm(stringLiteral);
				if (result == null) result = caseComparison(stringLiteral);
				if (result == null) result = caseExpression(stringLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StoexPackage.POWER_EXPRESSION: {
				PowerExpression powerExpression = (PowerExpression)theEObject;
				Object result = casePowerExpression(powerExpression);
				if (result == null) result = casePower(powerExpression);
				if (result == null) result = caseProduct(powerExpression);
				if (result == null) result = caseTerm(powerExpression);
				if (result == null) result = caseComparison(powerExpression);
				if (result == null) result = caseExpression(powerExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Variable Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Variable Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVariableReference(VariableReference object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Abstract Named Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Abstract Named Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbstractNamedReference(AbstractNamedReference object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Namespace Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Namespace Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNamespaceReference(NamespaceReference object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVariable(Variable object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Atom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Atom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAtom(Atom object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Power</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Power</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePower(Power object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Product</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Product</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProduct(Product object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTerm(Term object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Comparison</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Comparison</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseComparison(Comparison object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Term Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Term Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTermExpression(TermExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Random Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Random Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRandomVariable(RandomVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Product Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Product Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProductExpression(ProductExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Probability Function Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Probability Function Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProbabilityFunctionLiteral(ProbabilityFunctionLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Parenthesis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Parenthesis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseParenthesis(Parenthesis object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Numeric Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Numeric Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNumericLiteral(NumericLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Int Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Int Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIntLiteral(IntLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Double Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Double Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDoubleLiteral(DoubleLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Compare Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Compare Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCompareExpression(CompareExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Bool Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Bool Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBoolLiteral(BoolLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>String Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStringLiteral(StringLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Power Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Power Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePowerExpression(PowerExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //StoexSwitch
