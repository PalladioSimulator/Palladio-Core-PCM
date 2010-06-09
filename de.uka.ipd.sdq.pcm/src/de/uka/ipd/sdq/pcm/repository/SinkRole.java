/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sink Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.SinkRole#getEventgroup__SinkRole <em>Eventgroup Sink Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getSinkRole()
 * @model
 * @generated
 */
public interface SinkRole extends Role {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Eventgroup Sink Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eventgroup Sink Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eventgroup Sink Role</em>' reference.
	 * @see #setEventgroup__SinkRole(EventGroup)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getSinkRole_Eventgroup__SinkRole()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EventGroup getEventgroup__SinkRole();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.SinkRole#getEventgroup__SinkRole <em>Eventgroup Sink Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eventgroup Sink Role</em>' reference.
	 * @see #getEventgroup__SinkRole()
	 * @generated
	 */
	void setEventgroup__SinkRole(EventGroup value);

} // SinkRole
