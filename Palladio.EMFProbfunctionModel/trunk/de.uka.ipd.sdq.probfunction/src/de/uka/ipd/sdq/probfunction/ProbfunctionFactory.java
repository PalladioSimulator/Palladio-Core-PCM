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
	Sample createSample();

	/**
	 * Returns a new object of class '<em>Sample PDF</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sample PDF</em>'.
	 * @generated
	 */
	SamplePDF createSamplePDF();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ProbfunctionPackage getProbfunctionPackage();

} //ProbfunctionFactory
