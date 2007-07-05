/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.extension;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.capra.extension.ExtensionPackage
 * @generated
 */
public interface ExtensionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExtensionFactory eINSTANCE = de.uka.ipd.sdq.capra.extension.impl.ExtensionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Acquire Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Acquire Action</em>'.
	 * @generated
	 */
	AcquireAction createAcquireAction();

	/**
	 * Returns a new object of class '<em>Release Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Release Action</em>'.
	 * @generated
	 */
	ReleaseAction createReleaseAction();

	/**
	 * Returns a new object of class '<em>Weak Semaphore</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Weak Semaphore</em>'.
	 * @generated
	 */
	WeakSemaphore createWeakSemaphore();

	/**
	 * Returns a new object of class '<em>Strong Semaphore</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Strong Semaphore</em>'.
	 * @generated
	 */
	StrongSemaphore createStrongSemaphore();

	/**
	 * Returns a new object of class '<em>Scheduling Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduling Strategy</em>'.
	 * @generated
	 */
	SchedulingStrategy createSchedulingStrategy();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExtensionPackage getExtensionPackage();

} //ExtensionFactory
