/**
 */
package org.palladiosimulator.pcmmeasuringpoint;

import org.eclipse.emf.cdo.CDOObject;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Resource Environment Reference</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.ResourceEnvironmentReference#getResourceEnvironment
 * <em>Resource Environment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#getResourceEnvironmentReference()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface ResourceEnvironmentReference extends CDOObject {

    /**
     * Returns the value of the '<em><b>Resource Environment</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Resource Environment</em>' reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Resource Environment</em>' reference.
     * @see #setResourceEnvironment(ResourceEnvironment)
     * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#getResourceEnvironmentReference_ResourceEnvironment()
     * @model required="true"
     * @generated
     */
    ResourceEnvironment getResourceEnvironment();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ResourceEnvironmentReference#getResourceEnvironment
     * <em>Resource Environment</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Resource Environment</em>' reference.
     * @see #getResourceEnvironment()
     * @generated
     */
    void setResourceEnvironment(ResourceEnvironment value);

} // ResourceEnvironmentReference
