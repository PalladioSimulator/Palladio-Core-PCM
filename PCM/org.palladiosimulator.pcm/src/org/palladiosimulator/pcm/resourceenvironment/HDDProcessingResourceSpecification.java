/**
 * Copyright 2005-2017 by palladiosimulator.org
 */
package org.palladiosimulator.pcm.resourceenvironment;

import org.palladiosimulator.pcm.core.PCMRandomVariable;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>HDD Processing Resource
 * Specification</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.pcm.resourceenvironment.HDDProcessingResourceSpecification#getWriteProcessingRate
 * <em>Write Processing Rate</em>}</li>
 * <li>{@link org.palladiosimulator.pcm.resourceenvironment.HDDProcessingResourceSpecification#getReadProcessingRate
 * <em>Read Processing Rate</em>}</li>
 * <li>{@link org.palladiosimulator.pcm.resourceenvironment.HDDProcessingResourceSpecification#getResourceContainer
 * <em>Resource Container</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage#getHDDProcessingResourceSpecification()
 * @model
 * @generated
 */
public interface HDDProcessingResourceSpecification extends ProcessingResourceSpecification {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2005-2017 by palladiosimulator.org";

    /**
     * Returns the value of the '<em><b>Write Processing Rate</b></em>' containment reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Write Processing Rate</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Write Processing Rate</em>' containment reference.
     * @see #setWriteProcessingRate(PCMRandomVariable)
     * @see org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage#getHDDProcessingResourceSpecification_WriteProcessingRate()
     * @model containment="true" required="true" ordered="false"
     * @generated
     */
    PCMRandomVariable getWriteProcessingRate();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.pcm.resourceenvironment.HDDProcessingResourceSpecification#getWriteProcessingRate
     * <em>Write Processing Rate</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Write Processing Rate</em>' containment reference.
     * @see #getWriteProcessingRate()
     * @generated
     */
    void setWriteProcessingRate(PCMRandomVariable value);

    /**
     * Returns the value of the '<em><b>Read Processing Rate</b></em>' containment reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Read Processing Rate</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Read Processing Rate</em>' containment reference.
     * @see #setReadProcessingRate(PCMRandomVariable)
     * @see org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage#getHDDProcessingResourceSpecification_ReadProcessingRate()
     * @model containment="true" required="true" ordered="false"
     * @generated
     */
    PCMRandomVariable getReadProcessingRate();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.pcm.resourceenvironment.HDDProcessingResourceSpecification#getReadProcessingRate
     * <em>Read Processing Rate</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Read Processing Rate</em>' containment reference.
     * @see #getReadProcessingRate()
     * @generated
     */
    void setReadProcessingRate(PCMRandomVariable value);

    /**
     * Returns the value of the '<em><b>Resource Container</b></em>' reference. It is bidirectional
     * and its opposite is
     * '{@link org.palladiosimulator.pcm.resourceenvironment.ResourceContainer#getHddResourceSpecifications
     * <em>Hdd Resource Specifications</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Resource Container</em>' reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Resource Container</em>' reference.
     * @see #setResourceContainer(ResourceContainer)
     * @see org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage#getHDDProcessingResourceSpecification_ResourceContainer()
     * @see org.palladiosimulator.pcm.resourceenvironment.ResourceContainer#getHddResourceSpecifications
     * @model opposite="hddResourceSpecifications"
     * @generated
     */
    ResourceContainer getResourceContainer();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.pcm.resourceenvironment.HDDProcessingResourceSpecification#getResourceContainer
     * <em>Resource Container</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Resource Container</em>' reference.
     * @see #getResourceContainer()
     * @generated
     */
    void setResourceContainer(ResourceContainer value);

} // HDDProcessingResourceSpecification
