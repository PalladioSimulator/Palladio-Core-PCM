/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Internal State Influence Analysis Aggregation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation#getQualityAnnotation <em>Quality Annotation</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation#getParameterValueDeviations <em>Parameter Value Deviations</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation#getRequiredElementDeviations <em>Required Element Deviations</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getInternalStateInfluenceAnalysisAggregation()
 * @model
 * @generated
 */
public interface InternalStateInfluenceAnalysisAggregation extends Identifier {
	/**
	 * Returns the value of the '<em><b>Quality Annotation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.quality.qualityannotation.QualityAnnotation#getInternalStateInfluenceAnalysisResult <em>Internal State Influence Analysis Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality Annotation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality Annotation</em>' container reference.
	 * @see #setQualityAnnotation(QualityAnnotation)
	 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getInternalStateInfluenceAnalysisAggregation_QualityAnnotation()
	 * @see de.fzi.se.quality.qualityannotation.QualityAnnotation#getInternalStateInfluenceAnalysisResult
	 * @model opposite="internalStateInfluenceAnalysisResult" required="true" transient="false" ordered="false"
	 * @generated
	 */
	QualityAnnotation getQualityAnnotation();

	/**
	 * Sets the value of the '{@link de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation#getQualityAnnotation <em>Quality Annotation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quality Annotation</em>' container reference.
	 * @see #getQualityAnnotation()
	 * @generated
	 */
	void setQualityAnnotation(QualityAnnotation value);

	/**
	 * Returns the value of the '<em><b>Parameter Value Deviations</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.se.quality.qualityannotation.ParameterValueDeviation}.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.quality.qualityannotation.ParameterValueDeviation#getInternalStateInfluenceAnalysisAggregation <em>Internal State Influence Analysis Aggregation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Value Deviations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Value Deviations</em>' containment reference list.
	 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getInternalStateInfluenceAnalysisAggregation_ParameterValueDeviations()
	 * @see de.fzi.se.quality.qualityannotation.ParameterValueDeviation#getInternalStateInfluenceAnalysisAggregation
	 * @model opposite="internalStateInfluenceAnalysisAggregation" containment="true"
	 * @generated
	 */
	EList<ParameterValueDeviation> getParameterValueDeviations();

	/**
	 * Returns the value of the '<em><b>Required Element Deviations</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.se.quality.qualityannotation.RequiredElementDeviation}.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.quality.qualityannotation.RequiredElementDeviation#getInternalStateInfluenceAnalysisAggregation <em>Internal State Influence Analysis Aggregation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Element Deviations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Element Deviations</em>' containment reference list.
	 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getInternalStateInfluenceAnalysisAggregation_RequiredElementDeviations()
	 * @see de.fzi.se.quality.qualityannotation.RequiredElementDeviation#getInternalStateInfluenceAnalysisAggregation
	 * @model opposite="internalStateInfluenceAnalysisAggregation" containment="true"
	 * @generated
	 */
	EList<RequiredElementDeviation> getRequiredElementDeviations();

} // InternalStateInfluenceAnalysisAggregation
