/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
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
 * <!-- begin-model-doc -->
 * Provided roles list the interfaces offered by a component.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.ProvidedRole#getProvidingEntity__ProvidedRole <em>Providing Entity Provided Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getProvidedRole()
 * @model abstract="true"
 * @generated
 */
public interface ProvidedRole extends Role {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Providing Entity Provided Role</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity#getProvidedRoles_InterfaceProvidingEntity <em>Provided Roles Interface Providing Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This property represents the providing entity that is providing the interface associated with this role.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Providing Entity Provided Role</em>' container reference.
	 * @see #setProvidingEntity__ProvidedRole(InterfaceProvidingEntity)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getProvidedRole_ProvidingEntity__ProvidedRole()
	 * @see de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity#getProvidedRoles_InterfaceProvidingEntity
	 * @model opposite="providedRoles_InterfaceProvidingEntity" required="true" transient="false" ordered="false"
	 * @generated
	 */
	InterfaceProvidingEntity getProvidingEntity__ProvidedRole();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.ProvidedRole#getProvidingEntity__ProvidedRole <em>Providing Entity Provided Role</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Providing Entity Provided Role</em>' container reference.
	 * @see #getProvidingEntity__ProvidedRole()
	 * @generated
	 */
	void setProvidingEntity__ProvidedRole(InterfaceProvidingEntity value);

} // ProvidedRole
