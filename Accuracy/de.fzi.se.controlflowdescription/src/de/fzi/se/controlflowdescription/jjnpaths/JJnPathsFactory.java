/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.jjnpaths;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage
 * @generated
 */
public interface JJnPathsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JJnPathsFactory eINSTANCE = de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>JJn Path Test Suite</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JJn Path Test Suite</em>'.
	 * @generated
	 */
	JJnPathTestSuite createJJnPathTestSuite();

	/**
	 * Returns a new object of class '<em>JJn Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JJn Path</em>'.
	 * @generated
	 */
	JJnPath createJJnPath();

	/**
	 * Returns a new object of class '<em>JJ Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JJ Path</em>'.
	 * @generated
	 */
	JJPath createJJPath();

	/**
	 * Returns a new object of class '<em>JJn Path Test Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JJn Path Test Case</em>'.
	 * @generated
	 */
	JJnPathTestCase createJJnPathTestCase();

	/**
	 * Returns a new object of class '<em>Effort Estimation Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Effort Estimation Result</em>'.
	 * @generated
	 */
	JJnPathsEffortEstimationResult createJJnPathsEffortEstimationResult();

	/**
	 * Returns a new object of class '<em>JJn Path Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JJn Path Set</em>'.
	 * @generated
	 */
	JJnPathSet createJJnPathSet();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	JJnPathsPackage getJJnPathsPackage();

} //JJnPathsFactory
