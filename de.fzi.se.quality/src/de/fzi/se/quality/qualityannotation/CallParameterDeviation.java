/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation;

import de.fzi.se.quality.parameters.ParameterReference;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Parameter Deviation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.CallParameterDeviation#getParameterReference <em>Parameter Reference</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.CallParameterDeviation#getInternalStateInfluenceAnalysisAggregation <em>Internal State Influence Analysis Aggregation</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.CallParameterDeviation#getMaximum <em>Maximum</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getCallParameterDeviation()
 * @model
 * @generated
 */
public interface CallParameterDeviation extends EObject {
	/**
	 * Returns the value of the '<em><b>Parameter Reference</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.se.quality.parameters.ParameterReference}.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.quality.parameters.ParameterReference#getCallParameterDeviation <em>Call Parameter Deviation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Reference</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Reference</em>' containment reference list.
	 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getCallParameterDeviation_ParameterReference()
	 * @see de.fzi.se.quality.parameters.ParameterReference#getCallParameterDeviation
	 * @model opposite="callParameterDeviation" containment="true" ordered="false"
	 * @generated
	 */
	EList<ParameterReference> getParameterReference();

	/**
	 * Returns the value of the '<em><b>Internal State Influence Analysis Aggregation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation#getCallParameterDeviation <em>Call Parameter Deviation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal State Influence Analysis Aggregation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal State Influence Analysis Aggregation</em>' container reference.
	 * @see #setInternalStateInfluenceAnalysisAggregation(InternalStateInfluenceAnalysisAggregation)
	 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getCallParameterDeviation_InternalStateInfluenceAnalysisAggregation()
	 * @see de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation#getCallParameterDeviation
	 * @model opposite="callParameterDeviation" required="true" transient="false" ordered="false"
	 * @generated
	 */
	InternalStateInfluenceAnalysisAggregation getInternalStateInfluenceAnalysisAggregation();

	/**
	 * Sets the value of the '{@link de.fzi.se.quality.qualityannotation.CallParameterDeviation#getInternalStateInfluenceAnalysisAggregation <em>Internal State Influence Analysis Aggregation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal State Influence Analysis Aggregation</em>' container reference.
	 * @see #getInternalStateInfluenceAnalysisAggregation()
	 * @generated
	 */
	void setInternalStateInfluenceAnalysisAggregation(InternalStateInfluenceAnalysisAggregation value);

	/**
	 * Returns the value of the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum</em>' attribute.
	 * @see #setMaximum(double)
	 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getCallParameterDeviation_Maximum()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getMaximum();

	/**
	 * Sets the value of the '{@link de.fzi.se.quality.qualityannotation.CallParameterDeviation#getMaximum <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum</em>' attribute.
	 * @see #getMaximum()
	 * @generated
	 */
	void setMaximum(double value);

} // CallParameterDeviation
