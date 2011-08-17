/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters;

import de.fzi.se.quality.qualityannotation.QualityAnnotation;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Partition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.ParameterPartition#getValidatedSetting <em>Validated Setting</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.parameters.ParametersPackage#getParameterPartition()
 * @model abstract="true"
 * @generated
 */
public interface ParameterPartition extends Identifier {
	/**
	 * Returns the value of the '<em><b>Validated Setting</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.quality.qualityannotation.QualityAnnotation#getValidForParameterPartitions <em>Valid For Parameter Partitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validated Setting</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validated Setting</em>' container reference.
	 * @see #setValidatedSetting(QualityAnnotation)
	 * @see de.fzi.se.quality.parameters.ParametersPackage#getParameterPartition_ValidatedSetting()
	 * @see de.fzi.se.quality.qualityannotation.QualityAnnotation#getValidForParameterPartitions
	 * @model opposite="validForParameterPartitions" required="true" transient="false" ordered="false"
	 * @generated
	 */
	QualityAnnotation getValidatedSetting();

	/**
	 * Sets the value of the '{@link de.fzi.se.quality.parameters.ParameterPartition#getValidatedSetting <em>Validated Setting</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validated Setting</em>' container reference.
	 * @see #getValidatedSetting()
	 * @generated
	 */
	void setValidatedSetting(QualityAnnotation value);

} // ParameterPartition
