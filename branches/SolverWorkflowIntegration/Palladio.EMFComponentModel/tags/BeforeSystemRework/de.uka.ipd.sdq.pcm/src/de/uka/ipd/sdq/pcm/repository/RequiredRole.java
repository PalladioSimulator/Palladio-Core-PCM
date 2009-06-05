
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Required Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.RequiredRole#getRequiredInterface__RequiredRole <em>Required Interface Required Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRequiredRole()
 * @model
 * @generated
 */
public interface RequiredRole extends Role {
	/**
	 * Returns the value of the '<em><b>Required Interface Required Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Interface Required Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Interface Required Role</em>' reference.
	 * @see #setRequiredInterface__RequiredRole(Interface)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRequiredRole_RequiredInterface__RequiredRole()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Interface getRequiredInterface__RequiredRole();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.RequiredRole#getRequiredInterface__RequiredRole <em>Required Interface Required Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Interface Required Role</em>' reference.
	 * @see #getRequiredInterface__RequiredRole()
	 * @generated
	 */
	void setRequiredInterface__RequiredRole(Interface value);

} // RequiredRole