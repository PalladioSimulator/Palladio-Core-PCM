/**
 */
package org.palladiosimulator.pcmmeasuringpoint;

import org.eclipse.emf.cdo.CDOObject;

import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.Role;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Operation Reference</b></em>
 * '. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.palladiosimulator.pcmmeasuringpoint.OperationReference#getRole <em>Role</em>}</li>
 * <li>{@link org.palladiosimulator.pcmmeasuringpoint.OperationReference#getOperationSignature <em>
 * Operation Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#getOperationReference()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface OperationReference extends CDOObject {

    /**
     * Returns the value of the '<em><b>Role</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Role</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Role</em>' reference.
     * @see #setRole(Role)
     * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#getOperationReference_Role()
     * @model required="true"
     * @generated
     */
    Role getRole();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.OperationReference#getRole <em>Role</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Role</em>' reference.
     * @see #getRole()
     * @generated
     */
    void setRole(Role value);

    /**
     * Returns the value of the '<em><b>Operation Signature</b></em>' reference. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Operation Signature</em>' reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Operation Signature</em>' reference.
     * @see #setOperationSignature(OperationSignature)
     * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#getOperationReference_OperationSignature()
     * @model required="true"
     * @generated
     */
    OperationSignature getOperationSignature();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.OperationReference#getOperationSignature
     * <em>Operation Signature</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Operation Signature</em>' reference.
     * @see #getOperationSignature()
     * @generated
     */
    void setOperationSignature(OperationSignature value);

} // OperationReference
