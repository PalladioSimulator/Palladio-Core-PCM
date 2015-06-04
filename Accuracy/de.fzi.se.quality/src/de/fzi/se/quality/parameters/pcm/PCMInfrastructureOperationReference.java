/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm;

import de.fzi.se.quality.parameters.OperationReference;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Infrastructure Operation Reference</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.fzi.se.quality.parameters.pcm.PCMInfrastructureOperationReference#getRole <em>Role
 * </em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.pcm.PCMInfrastructureOperationReference#getSignature <em>
 * Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.parameters.pcm.PCMPackage#getPCMInfrastructureOperationReference()
 * @model
 * @generated
 */
public interface PCMInfrastructureOperationReference extends OperationReference {

    /**
     * Returns the value of the '<em><b>Role</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Role</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Role</em>' reference.
     * @see #setRole(InfrastructureRequiredRole)
     * @see de.fzi.se.quality.parameters.pcm.PCMPackage#getPCMInfrastructureOperationReference_Role()
     * @model required="true" ordered="false"
     * @generated
     */
    InfrastructureRequiredRole getRole();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.parameters.pcm.PCMInfrastructureOperationReference#getRole
     * <em>Role</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Role</em>' reference.
     * @see #getRole()
     * @generated
     */
    void setRole(InfrastructureRequiredRole value);

    /**
     * Returns the value of the '<em><b>Signature</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Signature</em>' reference isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Signature</em>' reference.
     * @see #setSignature(InfrastructureSignature)
     * @see de.fzi.se.quality.parameters.pcm.PCMPackage#getPCMInfrastructureOperationReference_Signature()
     * @model required="true" ordered="false"
     * @generated
     */
    InfrastructureSignature getSignature();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.parameters.pcm.PCMInfrastructureOperationReference#getSignature
     * <em>Signature</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Signature</em>' reference.
     * @see #getSignature()
     * @generated
     */
    void setSignature(InfrastructureSignature value);

} // PCMInfrastructureOperationReference
