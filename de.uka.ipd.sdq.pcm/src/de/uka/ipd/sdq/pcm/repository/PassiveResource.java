/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.reliability.ResourceTimeoutFailureType;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Passive Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> This entity represents a passive resource, e.g., a semaphore. <!--
 * end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.PassiveResource#getCapacity_PassiveResource <em>Capacity
 * Passive Resource</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.PassiveResource#getBasicComponent_PassiveResource <em>
 * Basic Component Passive Resource</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.repository.PassiveResource#getResourceTimeoutFailureType__PassiveResource
 * <em>Resource Timeout Failure Type Passive Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getPassiveResource()
 * @model
 * @generated
 */
public interface PassiveResource extends Entity {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '<em><b>Capacity Passive Resource</b></em>' containment reference.
     * It is bidirectional and its opposite is '
     * {@link de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getPassiveResource_capacity_PCMRandomVariable
     * <em>Passive Resource capacity PCM Random Variable</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc --> <!-- begin-model-doc --> This property holds the capacity of this passive
     * resource. <!-- end-model-doc -->
     *
     * @return the value of the '<em>Capacity Passive Resource</em>' containment reference.
     * @see #setCapacity_PassiveResource(PCMRandomVariable)
     * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getPassiveResource_Capacity_PassiveResource()
     * @see de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getPassiveResource_capacity_PCMRandomVariable
     * @model opposite="passiveResource_capacity_PCMRandomVariable" containment="true"
     *        required="true" ordered="false"
     * @generated
     */
    PCMRandomVariable getCapacity_PassiveResource();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.pcm.repository.PassiveResource#getCapacity_PassiveResource
     * <em>Capacity Passive Resource</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Capacity Passive Resource</em>' containment reference.
     * @see #getCapacity_PassiveResource()
     * @generated
     */
    void setCapacity_PassiveResource(PCMRandomVariable value);

    /**
     * Returns the value of the '<em><b>Basic Component Passive Resource</b></em>' container
     * reference. It is bidirectional and its opposite is '
     * {@link de.uka.ipd.sdq.pcm.repository.BasicComponent#getPassiveResource_BasicComponent
     * <em>Passive Resource Basic Component</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Basic Component Passive Resource</em>' container reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Basic Component Passive Resource</em>' container reference.
     * @see #setBasicComponent_PassiveResource(BasicComponent)
     * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getPassiveResource_BasicComponent_PassiveResource()
     * @see de.uka.ipd.sdq.pcm.repository.BasicComponent#getPassiveResource_BasicComponent
     * @model opposite="passiveResource_BasicComponent" required="true" transient="false"
     *        ordered="false"
     * @generated
     */
    BasicComponent getBasicComponent_PassiveResource();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.pcm.repository.PassiveResource#getBasicComponent_PassiveResource
     * <em>Basic Component Passive Resource</em>}' container reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Basic Component Passive Resource</em>' container
     *            reference.
     * @see #getBasicComponent_PassiveResource()
     * @generated
     */
    void setBasicComponent_PassiveResource(BasicComponent value);

    /**
     * Returns the value of the ' <em><b>Resource Timeout Failure Type Passive Resource</b></em>'
     * reference. It is bidirectional and its opposite is '
     * {@link de.uka.ipd.sdq.pcm.reliability.ResourceTimeoutFailureType#getPassiveResource__ResourceTimeoutFailureType
     * <em>Passive Resource Resource Timeout Failure Type</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the ' <em>Resource Timeout Failure Type Passive Resource</em>' reference
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc --> <!-- begin-model-doc --> The&nbsp;failure type that represents a
     * timeout&nbsp;failure of an acquiring action for this passive resource&nbsp;(see the
     * documentation of the "timeout" attribute of the "AcquireAction" for further information).
     * <!-- end-model-doc -->
     *
     * @return the value of the ' <em>Resource Timeout Failure Type Passive Resource</em>'
     *         reference.
     * @see #setResourceTimeoutFailureType__PassiveResource(ResourceTimeoutFailureType)
     * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getPassiveResource_ResourceTimeoutFailureType__PassiveResource()
     * @see de.uka.ipd.sdq.pcm.reliability.ResourceTimeoutFailureType#getPassiveResource__ResourceTimeoutFailureType
     * @model opposite="passiveResource__ResourceTimeoutFailureType" ordered="false"
     * @generated
     */
    ResourceTimeoutFailureType getResourceTimeoutFailureType__PassiveResource();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.pcm.repository.PassiveResource#getResourceTimeoutFailureType__PassiveResource
     * <em>Resource Timeout Failure Type Passive Resource</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Resource Timeout Failure Type Passive Resource</em>'
     *            reference.
     * @see #getResourceTimeoutFailureType__PassiveResource()
     * @generated
     */
    void setResourceTimeoutFailureType__PassiveResource(ResourceTimeoutFailureType value);

} // PassiveResource
