/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.fzi.se.validation.testbased.TestbasedPackage
 * @generated
 */
public interface TestbasedFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestbasedFactory eINSTANCE = de.fzi.se.validation.testbased.impl.TestbasedFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>TB Validation Quality</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TB Validation Quality</em>'.
	 * @generated
	 */
	TBValidationQuality createTBValidationQuality();

	/**
	 * Returns a new object of class '<em>Equidistant Partitions Random</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equidistant Partitions Random</em>'.
	 * @generated
	 */
	EquidistantPartitionsRandom createEquidistantPartitionsRandom();

	/**
	 * Returns a new object of class '<em>Number Testcases</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Number Testcases</em>'.
	 * @generated
	 */
	NumberTestcases createNumberTestcases();

	/**
	 * Returns a new object of class '<em>Number Generation Runs</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Number Generation Runs</em>'.
	 * @generated
	 */
	NumberGenerationRuns createNumberGenerationRuns();

	/**
	 * Returns a new object of class '<em>No ISIA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>No ISIA</em>'.
	 * @generated
	 */
	NoISIA createNoISIA();

	/**
	 * Returns a new object of class '<em>Reuse Instance ISIA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reuse Instance ISIA</em>'.
	 * @generated
	 */
	ReuseInstanceISIA createReuseInstanceISIA();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TestbasedPackage getTestbasedPackage();

} //TestbasedFactory
