/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage
 * @generated
 */
public interface ResourceenvironmentFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResourceenvironmentFactory eINSTANCE = de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceenvironmentFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Resource Environment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Environment</em>'.
	 * @generated
	 */
	ResourceEnvironment createResourceEnvironment();

	/**
	 * Returns a new object of class '<em>Linking Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Linking Resource</em>'.
	 * @generated
	 */
	LinkingResource createLinkingResource();

	/**
	 * Returns a new object of class '<em>Communication Link Resource Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Communication Link Resource Specification</em>'.
	 * @generated
	 */
	CommunicationLinkResourceSpecification createCommunicationLinkResourceSpecification();

	/**
	 * Returns a new object of class '<em>Processing Resource Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Processing Resource Specification</em>'.
	 * @generated
	 */
	ProcessingResourceSpecification createProcessingResourceSpecification();

	/**
	 * Returns a new object of class '<em>Passive Resource Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Passive Resource Specification</em>'.
	 * @generated
	 */
	PassiveResourceSpecification createPassiveResourceSpecification();

	/**
	 * Returns a new object of class '<em>Resource Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Container</em>'.
	 * @generated
	 */
	ResourceContainer createResourceContainer();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ResourceenvironmentPackage getResourceenvironmentPackage();

} //ResourceenvironmentFactory
