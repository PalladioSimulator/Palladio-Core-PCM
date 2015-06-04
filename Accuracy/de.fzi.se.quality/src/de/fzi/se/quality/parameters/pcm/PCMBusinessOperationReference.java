/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm;

import de.fzi.se.quality.parameters.OperationReference;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Business Operation Reference</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.fzi.se.quality.parameters.pcm.PCMBusinessOperationReference#getRole <em>Role</em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.pcm.PCMBusinessOperationReference#getSignature <em>
 * Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.parameters.pcm.PCMPackage#getPCMBusinessOperationReference()
 * @model
 * @generated
 */
public interface PCMBusinessOperationReference extends OperationReference {

    /**
     * Returns the value of the '<em><b>Role</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Role</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Role</em>' reference.
     * @see #setRole(OperationRequiredRole)
     * @see de.fzi.se.quality.parameters.pcm.PCMPackage#getPCMBusinessOperationReference_Role()
     * @model required="true" ordered="false"
     * @generated
     */
    OperationRequiredRole getRole();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.parameters.pcm.PCMBusinessOperationReference#getRole <em>Role</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Role</em>' reference.
     * @see #getRole()
     * @generated
     */
    void setRole(OperationRequiredRole value);

    /**
     * Returns the value of the '<em><b>Signature</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Signature</em>' reference isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Signature</em>' reference.
     * @see #setSignature(OperationSignature)
     * @see de.fzi.se.quality.parameters.pcm.PCMPackage#getPCMBusinessOperationReference_Signature()
     * @model required="true" ordered="false"
     * @generated
     */
    OperationSignature getSignature();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.parameters.pcm.PCMBusinessOperationReference#getSignature
     * <em>Signature</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Signature</em>' reference.
     * @see #getSignature()
     * @generated
     */
    void setSignature(OperationSignature value);

} // PCMBusinessOperationReference
