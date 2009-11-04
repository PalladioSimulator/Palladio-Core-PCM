/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceRequiringEntity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Required Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.ResourceRequiredRole#getRequiredInterface_ResourceRequiredRole <em>Required Interface Resource Required Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.ResourceRequiredRole#getResourceRequiringEntity_ResourceRequiredRole <em>Resource Requiring Entity Resource Required Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getResourceRequiredRole()
 * @model
 * @generated
 */
public interface ResourceRequiredRole extends Role {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, Karlsruhe Institute of Technology / University of Karlsruhe, Germany and SE, FZI Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Required Interface Resource Required Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Interface Resource Required Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Interface Resource Required Role</em>' reference.
	 * @see #setRequiredInterface_ResourceRequiredRole(Interface)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getResourceRequiredRole_RequiredInterface_ResourceRequiredRole()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Interface getRequiredInterface_ResourceRequiredRole();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.ResourceRequiredRole#getRequiredInterface_ResourceRequiredRole <em>Required Interface Resource Required Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Interface Resource Required Role</em>' reference.
	 * @see #getRequiredInterface_ResourceRequiredRole()
	 * @generated
	 */
	void setRequiredInterface_ResourceRequiredRole(Interface value);

	/**
	 * Returns the value of the '<em><b>Resource Requiring Entity Resource Required Role</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceRequiringEntity#getResourceRequiredRoles_ResourceInterfaceRequiringEntity <em>Resource Required Roles Resource Interface Requiring Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Requiring Entity Resource Required Role</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Requiring Entity Resource Required Role</em>' container reference.
	 * @see #setResourceRequiringEntity_ResourceRequiredRole(ResourceInterfaceRequiringEntity)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getResourceRequiredRole_ResourceRequiringEntity_ResourceRequiredRole()
	 * @see de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceRequiringEntity#getResourceRequiredRoles_ResourceInterfaceRequiringEntity
	 * @model opposite="resourceRequiredRoles_ResourceInterfaceRequiringEntity" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ResourceInterfaceRequiringEntity getResourceRequiringEntity_ResourceRequiredRole();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.ResourceRequiredRole#getResourceRequiringEntity_ResourceRequiredRole <em>Resource Requiring Entity Resource Required Role</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Requiring Entity Resource Required Role</em>' container reference.
	 * @see #getResourceRequiringEntity_ResourceRequiredRole()
	 * @generated
	 */
	void setResourceRequiringEntity_ResourceRequiredRole(ResourceInterfaceRequiringEntity value);

} // ResourceRequiredRole
