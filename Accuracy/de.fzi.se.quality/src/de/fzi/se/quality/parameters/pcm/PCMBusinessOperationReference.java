/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm;

import de.fzi.se.quality.parameters.BusinessOperationReference;

import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Business Operation Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.pcm.PCMBusinessOperationReference#getRequiredRole <em>Required Role</em>}</li>
 *   <li>{@link de.fzi.se.quality.parameters.pcm.PCMBusinessOperationReference#getSignature <em>Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.parameters.pcm.PCMPackage#getPCMBusinessOperationReference()
 * @model
 * @generated
 */
public interface PCMBusinessOperationReference extends BusinessOperationReference {
	/**
	 * Returns the value of the '<em><b>Required Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Role</em>' reference.
	 * @see #setRequiredRole(OperationRequiredRole)
	 * @see de.fzi.se.quality.parameters.pcm.PCMPackage#getPCMBusinessOperationReference_RequiredRole()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	OperationRequiredRole getRequiredRole();

	/**
	 * Sets the value of the '{@link de.fzi.se.quality.parameters.pcm.PCMBusinessOperationReference#getRequiredRole <em>Required Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Role</em>' reference.
	 * @see #getRequiredRole()
	 * @generated
	 */
	void setRequiredRole(OperationRequiredRole value);

	/**
	 * Returns the value of the '<em><b>Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signature</em>' reference.
	 * @see #setSignature(OperationSignature)
	 * @see de.fzi.se.quality.parameters.pcm.PCMPackage#getPCMBusinessOperationReference_Signature()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	OperationSignature getSignature();

	/**
	 * Sets the value of the '{@link de.fzi.se.quality.parameters.pcm.PCMBusinessOperationReference#getSignature <em>Signature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signature</em>' reference.
	 * @see #getSignature()
	 * @generated
	 */
	void setSignature(OperationSignature value);

} // PCMBusinessOperationReference
