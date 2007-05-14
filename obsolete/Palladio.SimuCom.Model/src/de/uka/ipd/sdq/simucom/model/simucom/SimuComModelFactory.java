/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucom.model.simucom;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.simucom.model.simucom.SimuComModelPackage
 * @generated
 */
public interface SimuComModelFactory extends EFactory{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by Steffen Becker, 2006"; //$NON-NLS-1$

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimuComModelFactory eINSTANCE = new de.uka.ipd.sdq.simucom.model.simucom.impl.SimuComModelFactoryImpl();

	/**
	 * Returns a new object of class '<em>Simulated Architecture</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simulated Architecture</em>'.
	 * @generated
	 */
	SimulatedArchitecture createSimulatedArchitecture();

	/**
	 * Returns a new object of class '<em>Simulated Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simulated Component</em>'.
	 * @generated
	 */
	SimulatedComponent createSimulatedComponent();

	/**
	 * Returns a new object of class '<em>Simulated Method</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simulated Method</em>'.
	 * @generated
	 */
	SimulatedMethod createSimulatedMethod();

	/**
	 * Returns a new object of class '<em>Service Effect</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Effect</em>'.
	 * @generated
	 */
	ServiceEffect createServiceEffect();

	/**
	 * Returns a new object of class '<em>Simulated World</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simulated World</em>'.
	 * @generated
	 */
	SimulatedWorld createSimulatedWorld();

	/**
	 * Returns a new object of class '<em>Simulated User</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simulated User</em>'.
	 * @generated
	 */
	SimulatedUser createSimulatedUser();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SimuComModelPackage getSimuComModelPackage();

} //SimuComModelFactory
