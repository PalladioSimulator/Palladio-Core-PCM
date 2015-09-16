/**
 */
package org.palladiosimulator.pcmmeasuringpoint;

import org.eclipse.emf.cdo.CDOObject;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Entry Level System Call Reference</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.EntryLevelSystemCallReference#getEntryLevelSystemCall
 * <em>Entry Level System Call</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#getEntryLevelSystemCallReference()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface EntryLevelSystemCallReference extends CDOObject {

    /**
     * Returns the value of the '<em><b>Entry Level System Call</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Entry Level System Call</em>' reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Entry Level System Call</em>' reference.
     * @see #setEntryLevelSystemCall(EntryLevelSystemCall)
     * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#getEntryLevelSystemCallReference_EntryLevelSystemCall()
     * @model required="true"
     * @generated
     */
    EntryLevelSystemCall getEntryLevelSystemCall();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.EntryLevelSystemCallReference#getEntryLevelSystemCall
     * <em>Entry Level System Call</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Entry Level System Call</em>' reference.
     * @see #getEntryLevelSystemCall()
     * @generated
     */
    void setEntryLevelSystemCall(EntryLevelSystemCall value);

} // EntryLevelSystemCallReference
