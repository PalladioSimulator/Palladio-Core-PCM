/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm;

import de.fzi.se.quality.parameters.ParameterReference;

import de.fzi.se.quality.qualityannotation.PCMParameterPartition;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.pcm.PCMParameterReference#getParameterPartition <em>Parameter Partition</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.parameters.pcm.PCMPackage#getPCMParameterReference()
 * @model abstract="true"
 * @generated
 */
public interface PCMParameterReference extends ParameterReference {
	/**
	 * Returns the value of the '<em><b>Parameter Partition</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.quality.qualityannotation.PCMParameterPartition#getParameterReference <em>Parameter Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Partition</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Partition</em>' container reference.
	 * @see #setParameterPartition(PCMParameterPartition)
	 * @see de.fzi.se.quality.parameters.pcm.PCMPackage#getPCMParameterReference_ParameterPartition()
	 * @see de.fzi.se.quality.qualityannotation.PCMParameterPartition#getParameterReference
	 * @model opposite="parameterReference" transient="false" ordered="false"
	 * @generated
	 */
	PCMParameterPartition getParameterPartition();

	/**
	 * Sets the value of the '{@link de.fzi.se.quality.parameters.pcm.PCMParameterReference#getParameterPartition <em>Parameter Partition</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Partition</em>' container reference.
	 * @see #getParameterPartition()
	 * @generated
	 */
	void setParameterPartition(PCMParameterPartition value);

} // PCMParameterReference
