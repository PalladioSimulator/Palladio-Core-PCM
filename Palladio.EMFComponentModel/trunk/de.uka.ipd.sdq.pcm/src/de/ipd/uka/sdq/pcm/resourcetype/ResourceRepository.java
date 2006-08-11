/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ipd.uka.sdq.pcm.resourcetype;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ipd.uka.sdq.pcm.resourcetype.ResourceRepository#getAvailableResourceTypes_ResourceRepository <em>Available Resource Types Resource Repository</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ipd.uka.sdq.pcm.resourcetype.ResourcetypePackage#getResourceRepository()
 * @model
 * @generated
 */
public interface ResourceRepository extends EObject {
	/**
	 * Returns the value of the '<em><b>Available Resource Types Resource Repository</b></em>' containment reference list.
	 * The list contents are of type {@link de.ipd.uka.sdq.pcm.resourcetype.ResourceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available Resource Types Resource Repository</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Resource Types Resource Repository</em>' containment reference list.
	 * @see de.ipd.uka.sdq.pcm.resourcetype.ResourcetypePackage#getResourceRepository_AvailableResourceTypes_ResourceRepository()
	 * @model type="de.ipd.uka.sdq.pcm.resourcetype.ResourceType" containment="true" ordered="false"
	 * @generated
	 */
	EList getAvailableResourceTypes_ResourceRepository();

} // ResourceRepository