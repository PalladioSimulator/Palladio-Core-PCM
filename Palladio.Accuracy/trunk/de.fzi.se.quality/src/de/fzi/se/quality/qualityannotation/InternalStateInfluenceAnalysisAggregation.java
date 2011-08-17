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
 *   <li>{@link de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation#getCallParameterDeviation <em>Call Parameter Deviation</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation#getNumberOfCallsDeviation <em>Number Of Calls Deviation</em>}</li>
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
	 * Returns the value of the '<em><b>Call Parameter Deviation</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.se.quality.qualityannotation.CallParameterDeviation}.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.quality.qualityannotation.CallParameterDeviation#getInternalStateInfluenceAnalysisAggregation <em>Internal State Influence Analysis Aggregation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call Parameter Deviation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call Parameter Deviation</em>' containment reference list.
	 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getInternalStateInfluenceAnalysisAggregation_CallParameterDeviation()
	 * @see de.fzi.se.quality.qualityannotation.CallParameterDeviation#getInternalStateInfluenceAnalysisAggregation
	 * @model opposite="internalStateInfluenceAnalysisAggregation" containment="true"
	 * @generated
	 */
	EList<CallParameterDeviation> getCallParameterDeviation();

	/**
	 * Returns the value of the '<em><b>Number Of Calls Deviation</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.se.quality.qualityannotation.NumberOfCallsDeviation}.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.quality.qualityannotation.NumberOfCallsDeviation#getInternalStateInfluenceAnalysisAggregation <em>Internal State Influence Analysis Aggregation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Calls Deviation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Calls Deviation</em>' containment reference list.
	 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getInternalStateInfluenceAnalysisAggregation_NumberOfCallsDeviation()
	 * @see de.fzi.se.quality.qualityannotation.NumberOfCallsDeviation#getInternalStateInfluenceAnalysisAggregation
	 * @model opposite="internalStateInfluenceAnalysisAggregation" containment="true"
	 * @generated
	 */
	EList<NumberOfCallsDeviation> getNumberOfCallsDeviation();

} // InternalStateInfluenceAnalysisAggregation
