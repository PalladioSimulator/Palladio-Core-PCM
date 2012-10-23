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
 *   <li>{@link de.fzi.se.quality.parameters.ParameterPartition#getQualityAnnotation <em>Quality Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.parameters.ParametersPackage#getParameterPartition()
 * @model abstract="true"
 * @generated
 */
public interface ParameterPartition extends Identifier {
	/**
	 * Returns the value of the '<em><b>Quality Annotation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.quality.qualityannotation.QualityAnnotation#getValidForParameterPartitions <em>Valid For Parameter Partitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality Annotation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality Annotation</em>' container reference.
	 * @see #setQualityAnnotation(QualityAnnotation)
	 * @see de.fzi.se.quality.parameters.ParametersPackage#getParameterPartition_QualityAnnotation()
	 * @see de.fzi.se.quality.qualityannotation.QualityAnnotation#getValidForParameterPartitions
	 * @model opposite="validForParameterPartitions" required="true" transient="false" ordered="false"
	 * @generated
	 */
	QualityAnnotation getQualityAnnotation();

	/**
	 * Sets the value of the '{@link de.fzi.se.quality.parameters.ParameterPartition#getQualityAnnotation <em>Quality Annotation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quality Annotation</em>' container reference.
	 * @see #getQualityAnnotation()
	 * @generated
	 */
	void setQualityAnnotation(QualityAnnotation value);

} // ParameterPartition
