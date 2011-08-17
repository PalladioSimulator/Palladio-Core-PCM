/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation;

import de.fzi.se.quality.parameters.ParameterPartition;

import de.fzi.se.quality.parameters.pcm.PCMParameterReference;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PCM Parameter Partition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.PCMParameterPartition#getCharacerisedParameterPartitions <em>Characerised Parameter Partitions</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.PCMParameterPartition#getParameterReference <em>Parameter Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getPCMParameterPartition()
 * @model
 * @generated
 */
public interface PCMParameterPartition extends ParameterPartition {
	/**
	 * Returns the value of the '<em><b>Characerised Parameter Partitions</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition}.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition#getPcmParameterPartition <em>Pcm Parameter Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Characerised Parameter Partitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Characerised Parameter Partitions</em>' containment reference list.
	 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getPCMParameterPartition_CharacerisedParameterPartitions()
	 * @see de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition#getPcmParameterPartition
	 * @model opposite="pcmParameterPartition" containment="true" ordered="false"
	 * @generated
	 */
	EList<CharacterisedPCMParameterPartition> getCharacerisedParameterPartitions();

	/**
	 * Returns the value of the '<em><b>Parameter Reference</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.quality.parameters.pcm.PCMParameterReference#getParameterPartition <em>Parameter Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Reference</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Reference</em>' containment reference.
	 * @see #setParameterReference(PCMParameterReference)
	 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getPCMParameterPartition_ParameterReference()
	 * @see de.fzi.se.quality.parameters.pcm.PCMParameterReference#getParameterPartition
	 * @model opposite="parameterPartition" containment="true" required="true" ordered="false"
	 * @generated
	 */
	PCMParameterReference getParameterReference();

	/**
	 * Sets the value of the '{@link de.fzi.se.quality.qualityannotation.PCMParameterPartition#getParameterReference <em>Parameter Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Reference</em>' containment reference.
	 * @see #getParameterReference()
	 * @generated
	 */
	void setParameterReference(PCMParameterReference value);

} // PCMParameterPartition
