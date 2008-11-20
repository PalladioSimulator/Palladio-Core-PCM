/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype;

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
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository#getAvailableResourceTypes_ResourceRepository <em>Available Resource Types Resource Repository</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getResourceRepository()
 * @model
 * @generated
 */
public interface ResourceRepository extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2008 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Available Resource Types Resource Repository</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.resourcetype.ResourceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available Resource Types Resource Repository</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Resource Types Resource Repository</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getResourceRepository_AvailableResourceTypes_ResourceRepository()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ResourceType> getAvailableResourceTypes_ResourceRepository();

} // ResourceRepository
