/**
 */
package org.palladiosimulator.pcmmeasuringpoint;

import org.eclipse.emf.cdo.CDOObject;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Resource Container Reference</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.ResourceContainerReference#getResourceContainer
 * <em>Resource Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#getResourceContainerReference()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface ResourceContainerReference extends CDOObject {

    /**
     * Returns the value of the '<em><b>Resource Container</b></em>' reference. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Resource Container</em>' reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Resource Container</em>' reference.
     * @see #setResourceContainer(ResourceContainer)
     * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#getResourceContainerReference_ResourceContainer()
     * @model required="true"
     * @generated
     */
    ResourceContainer getResourceContainer();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ResourceContainerReference#getResourceContainer
     * <em>Resource Container</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Resource Container</em>' reference.
     * @see #getResourceContainer()
     * @generated
     */
    void setResourceContainer(ResourceContainer value);

} // ResourceContainerReference
