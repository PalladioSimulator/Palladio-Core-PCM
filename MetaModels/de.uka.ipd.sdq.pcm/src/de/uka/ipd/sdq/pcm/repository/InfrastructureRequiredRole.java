/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Infrastructure Required Role</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole#getRequiredInterface__InfrastructureRequiredRole <em>Required Interface Infrastructure Required Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getInfrastructureRequiredRole()
 * @model
 * @generated
 */
public interface InfrastructureRequiredRole extends RequiredRole {
    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
	 * Returns the value of the '<em><b>Required Interface Infrastructure Required Role</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Required Interface Infrastructure Required Role</em>' reference
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Interface Infrastructure Required Role</em>' reference.
	 * @see #setRequiredInterface__InfrastructureRequiredRole(InfrastructureInterface)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getInfrastructureRequiredRole_RequiredInterface__InfrastructureRequiredRole()
	 * @model required="true" ordered="false"
	 * @generated
	 */
    InfrastructureInterface getRequiredInterface__InfrastructureRequiredRole();

    /**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole#getRequiredInterface__InfrastructureRequiredRole <em>Required Interface Infrastructure Required Role</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Interface Infrastructure Required Role</em>' reference.
	 * @see #getRequiredInterface__InfrastructureRequiredRole()
	 * @generated
	 */
    void setRequiredInterface__InfrastructureRequiredRole(InfrastructureInterface value);

} // InfrastructureRequiredRole
