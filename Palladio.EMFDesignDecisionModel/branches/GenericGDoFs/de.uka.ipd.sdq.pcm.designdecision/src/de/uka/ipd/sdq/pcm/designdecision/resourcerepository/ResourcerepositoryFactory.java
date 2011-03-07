/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.resourcerepository;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.designdecision.resourcerepository.ResourcerepositoryPackage
 * @generated
 */
public interface ResourcerepositoryFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResourcerepositoryFactory eINSTANCE = de.uka.ipd.sdq.pcm.designdecision.resourcerepository.impl.ResourcerepositoryFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Resource Description Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Description Repository</em>'.
	 * @generated
	 */
	ResourceDescriptionRepository createResourceDescriptionRepository();

	/**
	 * Returns a new object of class '<em>Resource Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Description</em>'.
	 * @generated
	 */
	ResourceDescription createResourceDescription();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ResourcerepositoryPackage getResourcerepositoryPackage();

} //ResourcerepositoryFactory
