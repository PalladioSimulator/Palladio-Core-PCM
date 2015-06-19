/**
 */
package org.palladiosimulator.pcmmeasuringpoint;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>System Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.palladiosimulator.pcmmeasuringpoint.SystemReference#getSystem <em>System</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#getSystemReference()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface SystemReference extends CDOObject {

    /**
     * Returns the value of the '<em><b>System</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>System</em>' reference isn't clear, there really should be more of
     * a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>System</em>' reference.
     * @see #setSystem(de.uka.ipd.sdq.pcm.system.System)
     * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#getSystemReference_System()
     * @model required="true"
     * @generated
     */
    de.uka.ipd.sdq.pcm.system.System getSystem();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.SystemReference#getSystem <em>System</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>System</em>' reference.
     * @see #getSystem()
     * @generated
     */
    void setSystem(de.uka.ipd.sdq.pcm.system.System value);

} // SystemReference
