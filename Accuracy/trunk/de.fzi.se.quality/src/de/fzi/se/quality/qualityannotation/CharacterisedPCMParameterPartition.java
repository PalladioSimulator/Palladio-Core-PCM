/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation;

import de.uka.ipd.sdq.identifier.Identifier;

import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Characterised PCM Parameter Partition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition#getForCharacterisation <em>For Characterisation</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition#getPcmParameterPartition <em>Pcm Parameter Partition</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getCharacterisedPCMParameterPartition()
 * @model abstract="true"
 * @generated
 */
public interface CharacterisedPCMParameterPartition extends Identifier {
	/**
	 * Returns the value of the '<em><b>For Characterisation</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>For Characterisation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>For Characterisation</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType
	 * @see #setForCharacterisation(VariableCharacterisationType)
	 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getCharacterisedPCMParameterPartition_ForCharacterisation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	VariableCharacterisationType getForCharacterisation();

	/**
	 * Sets the value of the '{@link de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition#getForCharacterisation <em>For Characterisation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>For Characterisation</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType
	 * @see #getForCharacterisation()
	 * @generated
	 */
	void setForCharacterisation(VariableCharacterisationType value);

	/**
	 * Returns the value of the '<em><b>Pcm Parameter Partition</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.quality.qualityannotation.PCMParameterPartition#getCharacerisedParameterPartitions <em>Characerised Parameter Partitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pcm Parameter Partition</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pcm Parameter Partition</em>' container reference.
	 * @see #setPcmParameterPartition(PCMParameterPartition)
	 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getCharacterisedPCMParameterPartition_PcmParameterPartition()
	 * @see de.fzi.se.quality.qualityannotation.PCMParameterPartition#getCharacerisedParameterPartitions
	 * @model opposite="characerisedParameterPartitions" required="true" transient="false" ordered="false"
	 * @generated
	 */
	PCMParameterPartition getPcmParameterPartition();

	/**
	 * Sets the value of the '{@link de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition#getPcmParameterPartition <em>Pcm Parameter Partition</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pcm Parameter Partition</em>' container reference.
	 * @see #getPcmParameterPartition()
	 * @generated
	 */
	void setPcmParameterPartition(PCMParameterPartition value);

} // CharacterisedPCMParameterPartition
