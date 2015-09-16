/**
 */
package org.palladiosimulator.pcmmeasuringpoint;

import org.eclipse.emf.cdo.CDOObject;
import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Active Resource Reference</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.pcmmeasuringpoint.ActiveResourceReference#getActiveResource
 * <em>Active Resource</em>}</li>
 * <li>{@link org.palladiosimulator.pcmmeasuringpoint.ActiveResourceReference#getReplicaID
 * <em>Replica ID</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#getActiveResourceReference()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface ActiveResourceReference extends CDOObject {

    /**
     * Returns the value of the '<em><b>Active Resource</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Active Resource</em>' reference isn't clear, there really should
     * be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Active Resource</em>' reference.
     * @see #setActiveResource(ProcessingResourceSpecification)
     * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#getActiveResourceReference_ActiveResource()
     * @model required="true"
     * @generated
     */
    ProcessingResourceSpecification getActiveResource();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ActiveResourceReference#getActiveResource
     * <em>Active Resource</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Active Resource</em>' reference.
     * @see #getActiveResource()
     * @generated
     */
    void setActiveResource(ProcessingResourceSpecification value);

    /**
     * Returns the value of the '<em><b>Replica ID</b></em>' attribute. The default value is
     * <code>"0"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Replica ID</em>' attribute isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Replica ID</em>' attribute.
     * @see #setReplicaID(int)
     * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#getActiveResourceReference_ReplicaID()
     * @model default="0" required="true"
     * @generated
     */
    int getReplicaID();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ActiveResourceReference#getReplicaID
     * <em>Replica ID</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Replica ID</em>' attribute.
     * @see #getReplicaID()
     * @generated
     */
    void setReplicaID(int value);

} // ActiveResourceReference
