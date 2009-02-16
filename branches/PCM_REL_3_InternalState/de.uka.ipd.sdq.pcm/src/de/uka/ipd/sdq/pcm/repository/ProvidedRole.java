/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Provided Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.ProvidedRole#getProvidedInterface__ProvidedRole <em>Provided Interface Provided Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.ProvidedRole#getProvidingEntity_ProvidedRole <em>Providing Entity Provided Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getProvidedRole()
 * @model
 * @generated
 */
public interface ProvidedRole extends Role {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Provided Interface Provided Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Interface Provided Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Interface Provided Role</em>' reference.
	 * @see #setProvidedInterface__ProvidedRole(Interface)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getProvidedRole_ProvidedInterface__ProvidedRole()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Interface getProvidedInterface__ProvidedRole();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.ProvidedRole#getProvidedInterface__ProvidedRole <em>Provided Interface Provided Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provided Interface Provided Role</em>' reference.
	 * @see #getProvidedInterface__ProvidedRole()
	 * @generated
	 */
	void setProvidedInterface__ProvidedRole(Interface value);

	/**
	 * Returns the value of the '<em><b>Providing Entity Provided Role</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity#getProvidedRoles_InterfaceProvidingEntity <em>Provided Roles Interface Providing Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Providing Entity Provided Role</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Providing Entity Provided Role</em>' container reference.
	 * @see #setProvidingEntity_ProvidedRole(InterfaceProvidingEntity)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getProvidedRole_ProvidingEntity_ProvidedRole()
	 * @see de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity#getProvidedRoles_InterfaceProvidingEntity
	 * @model opposite="providedRoles_InterfaceProvidingEntity" required="true" transient="false" ordered="false"
	 * @generated
	 */
	InterfaceProvidingEntity getProvidingEntity_ProvidedRole();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.ProvidedRole#getProvidingEntity_ProvidedRole <em>Providing Entity Provided Role</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Providing Entity Provided Role</em>' container reference.
	 * @see #getProvidingEntity_ProvidedRole()
	 * @generated
	 */
	void setProvidingEntity_ProvidedRole(InterfaceProvidingEntity value);

} // ProvidedRole
