/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Required Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> Required roles list the interfaces required by a component. <!--
 * end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.RequiredRole#getRequiringEntity_RequiredRole <em>
 * Requiring Entity Required Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRequiredRole()
 * @model abstract="true"
 * @generated
 */
public interface RequiredRole extends Role {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '<em><b>Requiring Entity Required Role</b></em>' container
     * reference. It is bidirectional and its opposite is '
     * {@link de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity#getRequiredRoles_InterfaceRequiringEntity
     * <em>Required Roles Interface Requiring Entity</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc --> <!-- begin-model-doc --> This property represents the interface requiring
     * entity that requires this interface. <!-- end-model-doc -->
     *
     * @return the value of the '<em>Requiring Entity Required Role</em>' container reference.
     * @see #setRequiringEntity_RequiredRole(InterfaceRequiringEntity)
     * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRequiredRole_RequiringEntity_RequiredRole()
     * @see de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity#getRequiredRoles_InterfaceRequiringEntity
     * @model opposite="requiredRoles_InterfaceRequiringEntity" required="true" transient="false"
     *        ordered="false"
     * @generated
     */
    InterfaceRequiringEntity getRequiringEntity_RequiredRole();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.pcm.repository.RequiredRole#getRequiringEntity_RequiredRole
     * <em>Requiring Entity Required Role</em>}' container reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Requiring Entity Required Role</em>' container
     *            reference.
     * @see #getRequiringEntity_RequiredRole()
     * @generated
     */
    void setRequiringEntity_RequiredRole(InterfaceRequiringEntity value);

} // RequiredRole
