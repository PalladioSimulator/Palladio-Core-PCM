/**
 */
package org.palladiosimulator.pcmmeasuringpoint;

import org.eclipse.emf.cdo.CDOObject;

import org.palladiosimulator.pcm.repository.PassiveResource;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Passive Resource Reference</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.palladiosimulator.pcmmeasuringpoint.PassiveResourceReference#getPassiveResource
 * <em>Passive Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#getPassiveResourceReference()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface PassiveResourceReference extends CDOObject {

    /**
     * Returns the value of the '<em><b>Passive Resource</b></em>' reference. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Passive Resource</em>' reference isn't clear, there really should
     * be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Passive Resource</em>' reference.
     * @see #setPassiveResource(PassiveResource)
     * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#getPassiveResourceReference_PassiveResource()
     * @model required="true"
     * @generated
     */
    PassiveResource getPassiveResource();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.PassiveResourceReference#getPassiveResource
     * <em>Passive Resource</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Passive Resource</em>' reference.
     * @see #getPassiveResource()
     * @generated
     */
    void setPassiveResource(PassiveResource value);

} // PassiveResourceReference
