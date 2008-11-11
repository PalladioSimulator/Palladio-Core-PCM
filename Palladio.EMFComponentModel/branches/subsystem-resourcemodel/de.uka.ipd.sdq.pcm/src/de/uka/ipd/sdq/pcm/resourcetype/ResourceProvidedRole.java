/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype;

import de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceProvidingEntity;

import de.uka.ipd.sdq.pcm.repository.Role;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Provided Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceProvidedRole#getProvidedResourceInterface_ResourceProvidedRole <em>Provided Resource Interface Resource Provided Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceProvidedRole#getResourceInterfaceProvidingEntity_ResourceProvidedRole <em>Resource Interface Providing Entity Resource Provided Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getResourceProvidedRole()
 * @model
 * @generated
 */
public interface ResourceProvidedRole extends Role {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Provided Resource Interface Resource Provided Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Resource Interface Resource Provided Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Resource Interface Resource Provided Role</em>' reference.
	 * @see #setProvidedResourceInterface_ResourceProvidedRole(ResourceInterface)
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getResourceProvidedRole_ProvidedResourceInterface_ResourceProvidedRole()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ResourceInterface getProvidedResourceInterface_ResourceProvidedRole();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceProvidedRole#getProvidedResourceInterface_ResourceProvidedRole <em>Provided Resource Interface Resource Provided Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provided Resource Interface Resource Provided Role</em>' reference.
	 * @see #getProvidedResourceInterface_ResourceProvidedRole()
	 * @generated
	 */
	void setProvidedResourceInterface_ResourceProvidedRole(ResourceInterface value);

	/**
	 * Returns the value of the '<em><b>Resource Interface Providing Entity Resource Provided Role</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceProvidingEntity#getResourceProvidedRoles_ResourceInterfaceProvidingEntity <em>Resource Provided Roles Resource Interface Providing Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Interface Providing Entity Resource Provided Role</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Interface Providing Entity Resource Provided Role</em>' container reference.
	 * @see #setResourceInterfaceProvidingEntity_ResourceProvidedRole(ResourceInterfaceProvidingEntity)
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getResourceProvidedRole_ResourceInterfaceProvidingEntity_ResourceProvidedRole()
	 * @see de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceProvidingEntity#getResourceProvidedRoles_ResourceInterfaceProvidingEntity
	 * @model opposite="resourceProvidedRoles_ResourceInterfaceProvidingEntity" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ResourceInterfaceProvidingEntity getResourceInterfaceProvidingEntity_ResourceProvidedRole();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceProvidedRole#getResourceInterfaceProvidingEntity_ResourceProvidedRole <em>Resource Interface Providing Entity Resource Provided Role</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Interface Providing Entity Resource Provided Role</em>' container reference.
	 * @see #getResourceInterfaceProvidingEntity_ResourceProvidedRole()
	 * @generated
	 */
	void setResourceInterfaceProvidingEntity_ResourceProvidedRole(ResourceInterfaceProvidingEntity value);

} // ResourceProvidedRole
