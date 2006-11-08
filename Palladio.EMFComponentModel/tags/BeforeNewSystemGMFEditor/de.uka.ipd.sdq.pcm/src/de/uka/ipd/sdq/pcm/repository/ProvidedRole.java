
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Provided Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.ProvidedRole#getProvidedInterface__ProvidedRole <em>Provided Interface Provided Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.ProvidedRole#getProvidingComponent__ProvidedRole <em>Providing Component Provided Role</em>}</li>
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
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

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
	 * Returns the value of the '<em><b>Providing Component Provided Role</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.ProvidesComponentType#getProvidedRoles__ProvidesComponentType <em>Provided Roles Provides Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Providing Component Provided Role</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Providing Component Provided Role</em>' container reference.
	 * @see #setProvidingComponent__ProvidedRole(ProvidesComponentType)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getProvidedRole_ProvidingComponent__ProvidedRole()
	 * @see de.uka.ipd.sdq.pcm.repository.ProvidesComponentType#getProvidedRoles__ProvidesComponentType
	 * @model opposite="providedRoles__ProvidesComponentType" required="true" ordered="false"
	 * @generated
	 */
	ProvidesComponentType getProvidingComponent__ProvidedRole();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.ProvidedRole#getProvidingComponent__ProvidedRole <em>Providing Component Provided Role</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Providing Component Provided Role</em>' container reference.
	 * @see #getProvidingComponent__ProvidedRole()
	 * @generated
	 */
	void setProvidingComponent__ProvidedRole(ProvidesComponentType value);

} // ProvidedRole