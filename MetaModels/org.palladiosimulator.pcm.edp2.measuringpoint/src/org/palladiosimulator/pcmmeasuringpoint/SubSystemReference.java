/**
 */
package org.palladiosimulator.pcmmeasuringpoint;

import de.uka.ipd.sdq.pcm.subsystem.SubSystem;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub System Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.palladiosimulator.pcmmeasuringpoint.SubSystemReference#getSubsystem <em>Subsystem</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#getSubSystemReference()
 * @model abstract="true"
 * @generated
 */
public interface SubSystemReference extends EObject {
    /**
     * Returns the value of the '<em><b>Subsystem</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Subsystem</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Subsystem</em>' reference.
     * @see #setSubsystem(SubSystem)
     * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#getSubSystemReference_Subsystem()
     * @model required="true"
     * @generated
     */
    SubSystem getSubsystem();

    /**
     * Sets the value of the '{@link org.palladiosimulator.pcmmeasuringpoint.SubSystemReference#getSubsystem <em>Subsystem</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Subsystem</em>' reference.
     * @see #getSubsystem()
     * @generated
     */
    void setSubsystem(SubSystem value);

} // SubSystemReference
