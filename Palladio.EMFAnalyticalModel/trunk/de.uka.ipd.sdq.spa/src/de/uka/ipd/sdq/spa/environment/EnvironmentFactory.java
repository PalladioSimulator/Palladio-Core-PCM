/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.environment;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.spa.environment.EnvironmentPackage
 * @generated
 */
public interface EnvironmentFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EnvironmentFactory eINSTANCE = de.uka.ipd.sdq.spa.environment.impl.EnvironmentFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Process Behaviour</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process Behaviour</em>'.
	 * @generated
	 */
	ProcessBehaviour createProcessBehaviour();

	/**
	 * Returns a new object of class '<em>SPA Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SPA Model</em>'.
	 * @generated
	 */
	SPAModel createSPAModel();

	/**
	 * Returns a new object of class '<em>Passive Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Passive Resource</em>'.
	 * @generated
	 */
	PassiveResource createPassiveResource();

	/**
	 * Returns a new object of class '<em>Processing Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Processing Resource</em>'.
	 * @generated
	 */
	ProcessingResource createProcessingResource();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EnvironmentPackage getEnvironmentPackage();

} //EnvironmentFactory
