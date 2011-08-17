/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcerepository;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Description Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcerepository.ResourceDescriptionRepository#getAvailableProcessingResources_ResourceRepository <em>Available Processing Resources Resource Repository</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resourcerepository.resourcerepositoryPackage#getResourceDescriptionRepository()
 * @model
 * @generated
 */
public interface ResourceDescriptionRepository extends EObject {
	/**
	 * Returns the value of the '<em><b>Available Processing Resources Resource Repository</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.resourcerepository.ResourceDescription}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available Processing Resources Resource Repository</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Processing Resources Resource Repository</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.resourcerepository.resourcerepositoryPackage#getResourceDescriptionRepository_AvailableProcessingResources_ResourceRepository()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ResourceDescription> getAvailableProcessingResources_ResourceRepository();

} // ResourceDescriptionRepository
