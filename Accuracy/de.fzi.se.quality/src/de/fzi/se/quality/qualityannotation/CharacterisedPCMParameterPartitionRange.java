/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Characterised PCM Parameter Partition Range</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionRange#getValues
 * <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getCharacterisedPCMParameterPartitionRange()
 * @model
 * @generated
 */
public interface CharacterisedPCMParameterPartitionRange extends CharacterisedPCMParameterPartition {

    /**
     * Returns the value of the '<em><b>Values</b></em>' containment reference list. The list
     * contents are of type {@link de.uka.ipd.sdq.pcm.core.PCMRandomVariable}. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Values</em>' containment reference list isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Values</em>' containment reference list.
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getCharacterisedPCMParameterPartitionRange_Values()
     * @model containment="true" ordered="false"
     * @generated
     */
    EList<PCMRandomVariable> getValues();

} // CharacterisedPCMParameterPartitionRange
