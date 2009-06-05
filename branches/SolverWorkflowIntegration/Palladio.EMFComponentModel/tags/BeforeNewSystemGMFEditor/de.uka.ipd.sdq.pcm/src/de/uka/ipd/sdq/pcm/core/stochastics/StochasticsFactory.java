/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.stochastics;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage
 * @generated
 */
public interface StochasticsFactory extends EFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StochasticsFactory eINSTANCE = de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Random Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Random Variable</em>'.
	 * @generated
	 */
	RandomVariable createRandomVariable();

	/**
	 * Returns a new object of class '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable</em>'.
	 * @generated
	 */
	Variable createVariable();

	/**
	 * Returns a new object of class '<em>Parantesis</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parantesis</em>'.
	 * @generated
	 */
	Parantesis createParantesis();

	/**
	 * Returns a new object of class '<em>Int Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int Literal</em>'.
	 * @generated
	 */
	IntLiteral createIntLiteral();

	/**
	 * Returns a new object of class '<em>Double Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Literal</em>'.
	 * @generated
	 */
	DoubleLiteral createDoubleLiteral();

	/**
	 * Returns a new object of class '<em>Compare Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compare Expression</em>'.
	 * @generated
	 */
	CompareExpression createCompareExpression();

	/**
	 * Returns a new object of class '<em>Term Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Term Expression</em>'.
	 * @generated
	 */
	TermExpression createTermExpression();

	/**
	 * Returns a new object of class '<em>Product Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Product Expression</em>'.
	 * @generated
	 */
	ProductExpression createProductExpression();

	/**
	 * Returns a new object of class '<em>Probability Function Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Probability Function Literal</em>'.
	 * @generated
	 */
	ProbabilityFunctionLiteral createProbabilityFunctionLiteral();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StochasticsPackage getStochasticsPackage();

} //StochasticsFactory
