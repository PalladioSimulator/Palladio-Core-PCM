/**
 */
package org.palladiosimulator.pcmmeasuringpoint;

import org.eclipse.emf.cdo.CDOObject;

import org.palladiosimulator.pcm.usagemodel.UsageScenario;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Usage Scenario Reference</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.palladiosimulator.pcmmeasuringpoint.UsageScenarioReference#getUsageScenario <em>
 * Usage Scenario</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#getUsageScenarioReference()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface UsageScenarioReference extends CDOObject {

    /**
     * Returns the value of the '<em><b>Usage Scenario</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Usage Scenario</em>' reference isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Usage Scenario</em>' reference.
     * @see #setUsageScenario(UsageScenario)
     * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#getUsageScenarioReference_UsageScenario()
     * @model required="true"
     * @generated
     */
    UsageScenario getUsageScenario();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.UsageScenarioReference#getUsageScenario
     * <em>Usage Scenario</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Usage Scenario</em>' reference.
     * @see #getUsageScenario()
     * @generated
     */
    void setUsageScenario(UsageScenario value);

} // UsageScenarioReference
