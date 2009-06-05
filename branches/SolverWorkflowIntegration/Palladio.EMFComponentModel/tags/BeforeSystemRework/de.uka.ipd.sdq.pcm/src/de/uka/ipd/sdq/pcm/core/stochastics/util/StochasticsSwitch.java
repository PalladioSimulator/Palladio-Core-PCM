/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.stochastics.util;

import de.uka.ipd.sdq.pcm.core.stochastics.*;

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
 * @see de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage
 * @generated
 */
public class StochasticsSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StochasticsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StochasticsSwitch() {
		if (modelPackage == null) {
			modelPackage = StochasticsPackage.eINSTANCE;
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
			case StochasticsPackage.RANDOM_VARIABLE: {
				RandomVariable randomVariable = (RandomVariable)theEObject;
				Object result = caseRandomVariable(randomVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StochasticsPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				Object result = caseExpression(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StochasticsPackage.COMPARISON: {
				Comparison comparison = (Comparison)theEObject;
				Object result = caseComparison(comparison);
				if (result == null) result = caseExpression(comparison);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StochasticsPackage.TERM: {
				Term term = (Term)theEObject;
				Object result = caseTerm(term);
				if (result == null) result = caseComparison(term);
				if (result == null) result = caseExpression(term);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StochasticsPackage.PRODUCT: {
				Product product = (Product)theEObject;
				Object result = caseProduct(product);
				if (result == null) result = caseTerm(product);
				if (result == null) result = caseComparison(product);
				if (result == null) result = caseExpression(product);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StochasticsPackage.POWER: {
				Power power = (Power)theEObject;
				Object result = casePower(power);
				if (result == null) result = caseProduct(power);
				if (result == null) result = caseTerm(power);
				if (result == null) result = caseComparison(power);
				if (result == null) result = caseExpression(power);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StochasticsPackage.ATOM: {
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
			case StochasticsPackage.VARIABLE: {
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
			case StochasticsPackage.PARANTESIS: {
				Parantesis parantesis = (Parantesis)theEObject;
				Object result = caseParantesis(parantesis);
				if (result == null) result = caseAtom(parantesis);
				if (result == null) result = casePower(parantesis);
				if (result == null) result = caseProduct(parantesis);
				if (result == null) result = caseTerm(parantesis);
				if (result == null) result = caseComparison(parantesis);
				if (result == null) result = caseExpression(parantesis);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StochasticsPackage.NUMERIC_LITERAL: {
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
			case StochasticsPackage.INT_LITERAL: {
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
			case StochasticsPackage.DOUBLE_LITERAL: {
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
			case StochasticsPackage.COMPARE_EXPRESSION: {
				CompareExpression compareExpression = (CompareExpression)theEObject;
				Object result = caseCompareExpression(compareExpression);
				if (result == null) result = caseComparison(compareExpression);
				if (result == null) result = caseExpression(compareExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StochasticsPackage.TERM_EXPRESSION: {
				TermExpression termExpression = (TermExpression)theEObject;
				Object result = caseTermExpression(termExpression);
				if (result == null) result = caseTerm(termExpression);
				if (result == null) result = caseComparison(termExpression);
				if (result == null) result = caseExpression(termExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StochasticsPackage.PRODUCT_EXPRESSION: {
				ProductExpression productExpression = (ProductExpression)theEObject;
				Object result = caseProductExpression(productExpression);
				if (result == null) result = caseProduct(productExpression);
				if (result == null) result = caseTerm(productExpression);
				if (result == null) result = caseComparison(productExpression);
				if (result == null) result = caseExpression(productExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StochasticsPackage.PROBABILITY_FUNCTION_LITERAL: {
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
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpretting the object as an instance of '<em>Parantesis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Parantesis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseParantesis(Parantesis object) {
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

} //StochasticsSwitch
