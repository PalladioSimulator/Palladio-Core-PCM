/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Characterised PCM Parameter Partition Interval</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * Specifies the interval for an characerization.
 * </p>
 * <p>
 * From is inclusive, To is exclusive. An Integer-based Interval from "0" to "1" would be the same
 * as a CharacterisedPCMParameterPartitionRange with the value "0". A Double-based Interval from "0"
 * to "1" would be denoted [0..1) mathematically.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionInterval#getFrom
 * <em>From</em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionInterval#getTo
 * <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getCharacterisedPCMParameterPartitionInterval()
 * @model
 * @generated
 */
public interface CharacterisedPCMParameterPartitionInterval extends CharacterisedPCMParameterPartition {

    /**
     * Returns the value of the '<em><b>From</b></em>' containment reference. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>From</em>' containment reference isn't clear, there really should
     * be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>From</em>' containment reference.
     * @see #setFrom(PCMRandomVariable)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getCharacterisedPCMParameterPartitionInterval_From()
     * @model containment="true" required="true" ordered="false"
     * @generated
     */
    PCMRandomVariable getFrom();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionInterval#getFrom
     * <em>From</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>From</em>' containment reference.
     * @see #getFrom()
     * @generated
     */
    void setFrom(PCMRandomVariable value);

    /**
     * Returns the value of the '<em><b>To</b></em>' containment reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>To</em>' containment reference isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>To</em>' containment reference.
     * @see #setTo(PCMRandomVariable)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getCharacterisedPCMParameterPartitionInterval_To()
     * @model containment="true" required="true" ordered="false"
     * @generated
     */
    PCMRandomVariable getTo();

    /**
     * Sets the value of the '
     * {@link de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionInterval#getTo
     * <em>To</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>To</em>' containment reference.
     * @see #getTo()
     * @generated
     */
    void setTo(PCMRandomVariable value);

} // CharacterisedPCMParameterPartitionInterval
