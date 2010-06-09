/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
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
 * <!-- begin-model-doc -->
 * Required role for resource interface access of a component
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.ResourceRequiredRole#getRequiredInterface__ResourceRequiredRole <em>Required Interface Resource Required Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.ResourceRequiredRole#getResourceRequiringEntity__ResourceRequiredRole <em>Resource Requiring Entity Resource Required Role</em>}</li>
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
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Required Interface Resource Required Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Interface Resource Required Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Interface Resource Required Role</em>' reference.
	 * @see #setRequiredInterface__ResourceRequiredRole(Interface)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getResourceRequiredRole_RequiredInterface__ResourceRequiredRole()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Interface getRequiredInterface__ResourceRequiredRole();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.ResourceRequiredRole#getRequiredInterface__ResourceRequiredRole <em>Required Interface Resource Required Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Interface Resource Required Role</em>' reference.
	 * @see #getRequiredInterface__ResourceRequiredRole()
	 * @generated
	 */
	void setRequiredInterface__ResourceRequiredRole(Interface value);

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
	 * @see #setResourceRequiringEntity__ResourceRequiredRole(ResourceInterfaceRequiringEntity)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getResourceRequiredRole_ResourceRequiringEntity__ResourceRequiredRole()
	 * @see de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceRequiringEntity#getResourceRequiredRoles_ResourceInterfaceRequiringEntity
	 * @model opposite="resourceRequiredRoles_ResourceInterfaceRequiringEntity" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ResourceInterfaceRequiringEntity getResourceRequiringEntity__ResourceRequiredRole();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.ResourceRequiredRole#getResourceRequiringEntity__ResourceRequiredRole <em>Resource Requiring Entity Resource Required Role</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Requiring Entity Resource Required Role</em>' container reference.
	 * @see #getResourceRequiringEntity__ResourceRequiredRole()
	 * @generated
	 */
	void setResourceRequiringEntity__ResourceRequiredRole(ResourceInterfaceRequiringEntity value);

} // ResourceRequiredRole
