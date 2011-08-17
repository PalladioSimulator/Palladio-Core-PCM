/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probfunction;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.probfunction.ProbfunctionPackage
 * @generated
 */
public interface ProbfunctionFactory extends EFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007-2009, SDQ, IPD, U Karlsruhe";
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProbfunctionFactory eINSTANCE = de.uka.ipd.sdq.probfunction.impl.ProbfunctionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Boxed PDF</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boxed PDF</em>'.
	 * @generated
	 */
	BoxedPDF createBoxedPDF();

	/**
	 * Returns a new object of class '<em>Continuous Sample</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Continuous Sample</em>'.
	 * @generated
	 */
	ContinuousSample createContinuousSample();

	/**
	 * Returns a new object of class '<em>Probability Mass Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Probability Mass Function</em>'.
	 * @generated
	 */
	ProbabilityMassFunction createProbabilityMassFunction();

	/**
	 * Returns a new object of class '<em>Sample</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sample</em>'.
	 * @generated
	 */
	<T> Sample<T> createSample();

	/**
	 * Returns a new object of class '<em>Sample PDF</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sample PDF</em>'.
	 * @generated
	 */
	SamplePDF createSamplePDF();

	/**
	 * Returns a new object of class '<em>Complex</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex</em>'.
	 * @generated
	 */
	Complex createComplex();

	/**
	 * Returns a new object of class '<em>Exponential Distribution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exponential Distribution</em>'.
	 * @generated
	 */
	ExponentialDistribution createExponentialDistribution();

	/**
	 * Returns a new object of class '<em>Normal Distribution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Normal Distribution</em>'.
	 * @generated
	 */
	NormalDistribution createNormalDistribution();

	/**
	 * Returns a new object of class '<em>Lognormal Distribution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lognormal Distribution</em>'.
	 * @generated
	 */
	LognormalDistribution createLognormalDistribution();

	/**
	 * Returns a new object of class '<em>Gamma Distribution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gamma Distribution</em>'.
	 * @generated
	 */
	GammaDistribution createGammaDistribution();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ProbfunctionPackage getProbfunctionPackage();

} //ProbfunctionFactory
