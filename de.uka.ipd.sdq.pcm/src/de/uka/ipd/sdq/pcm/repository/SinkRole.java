/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Sink Role</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc --> A SinkRole, extending a ProvidedRole, identifies components that provide
 * an event handler for specific EventTypes. As for SourceRoles, the EventTypes, a SinkRole is
 * compatible with, are defined by the associated EventGroup. <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.SinkRole#getEventGroup__SinkRole <em>Event Group Sink
 * Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getSinkRole()
 * @model
 * @generated
 */
public interface SinkRole extends ProvidedRole {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '<em><b>Event Group Sink Role</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Event Group Sink Role</em>' reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Event Group Sink Role</em>' reference.
     * @see #setEventGroup__SinkRole(EventGroup)
     * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getSinkRole_EventGroup__SinkRole()
     * @model required="true" ordered="false"
     * @generated
     */
    EventGroup getEventGroup__SinkRole();

    /**
     * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.SinkRole#getEventGroup__SinkRole
     * <em>Event Group Sink Role</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Event Group Sink Role</em>' reference.
     * @see #getEventGroup__SinkRole()
     * @generated
     */
    void setEventGroup__SinkRole(EventGroup value);

} // SinkRole
