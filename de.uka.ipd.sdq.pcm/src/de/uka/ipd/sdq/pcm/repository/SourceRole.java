/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.SourceRole#getEventgroup__SourceRole <em>Eventgroup Source Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getSourceRole()
 * @model
 * @generated
 */
public interface SourceRole extends Role {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Eventgroup Source Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eventgroup Source Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eventgroup Source Role</em>' reference.
	 * @see #setEventgroup__SourceRole(EventGroup)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getSourceRole_Eventgroup__SourceRole()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EventGroup getEventgroup__SourceRole();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.SourceRole#getEventgroup__SourceRole <em>Eventgroup Source Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eventgroup Source Role</em>' reference.
	 * @see #getEventgroup__SourceRole()
	 * @generated
	 */
	void setEventgroup__SourceRole(EventGroup value);

} // SourceRole
