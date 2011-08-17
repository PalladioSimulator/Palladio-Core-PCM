/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm;

import de.fzi.se.quality.parameters.InfrastructureOperationReference;

import de.uka.ipd.sdq.pcm.core.entity.ResourceRequiredRole;

import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Infrastructure Operation Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.pcm.PCMInfrastructureOperationReference#getResourceRequiredRole <em>Resource Required Role</em>}</li>
 *   <li>{@link de.fzi.se.quality.parameters.pcm.PCMInfrastructureOperationReference#getSignature <em>Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.parameters.pcm.PCMPackage#getPCMInfrastructureOperationReference()
 * @model
 * @generated
 */
public interface PCMInfrastructureOperationReference extends InfrastructureOperationReference {
	/**
	 * Returns the value of the '<em><b>Resource Required Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Required Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Required Role</em>' reference.
	 * @see #setResourceRequiredRole(ResourceRequiredRole)
	 * @see de.fzi.se.quality.parameters.pcm.PCMPackage#getPCMInfrastructureOperationReference_ResourceRequiredRole()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ResourceRequiredRole getResourceRequiredRole();

	/**
	 * Sets the value of the '{@link de.fzi.se.quality.parameters.pcm.PCMInfrastructureOperationReference#getResourceRequiredRole <em>Resource Required Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Required Role</em>' reference.
	 * @see #getResourceRequiredRole()
	 * @generated
	 */
	void setResourceRequiredRole(ResourceRequiredRole value);

	/**
	 * Returns the value of the '<em><b>Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signature</em>' reference.
	 * @see #setSignature(Signature)
	 * @see de.fzi.se.quality.parameters.pcm.PCMPackage#getPCMInfrastructureOperationReference_Signature()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Signature getSignature();

	/**
	 * Sets the value of the '{@link de.fzi.se.quality.parameters.pcm.PCMInfrastructureOperationReference#getSignature <em>Signature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signature</em>' reference.
	 * @see #getSignature()
	 * @generated
	 */
	void setSignature(Signature value);

} // PCMInfrastructureOperationReference
