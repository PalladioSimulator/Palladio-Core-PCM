/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.resources;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.capra.resources.ResourcesPackage
 * @generated
 */
public interface ResourcesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResourcesFactory eINSTANCE = de.uka.ipd.sdq.capra.resources.impl.ResourcesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Processing Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Processing Resource</em>'.
	 * @generated
	 */
	ProcessingResource createProcessingResource();

	/**
	 * Returns a new object of class '<em>Delay Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delay Resource</em>'.
	 * @generated
	 */
	DelayResource createDelayResource();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ResourcesPackage getResourcesPackage();

} //ResourcesFactory
