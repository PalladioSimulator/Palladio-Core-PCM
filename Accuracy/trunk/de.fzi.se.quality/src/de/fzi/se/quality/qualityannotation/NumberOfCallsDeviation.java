/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Number Of Calls Deviation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.NumberOfCallsDeviation#getInternalStateInfluenceAnalysisAggregation <em>Internal State Influence Analysis Aggregation</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.NumberOfCallsDeviation#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.NumberOfCallsDeviation#getRequiredElement <em>Required Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getNumberOfCallsDeviation()
 * @model
 * @generated
 */
public interface NumberOfCallsDeviation extends EObject {
	/**
	 * Returns the value of the '<em><b>Internal State Influence Analysis Aggregation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation#getNumberOfCallsDeviation <em>Number Of Calls Deviation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal State Influence Analysis Aggregation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal State Influence Analysis Aggregation</em>' container reference.
	 * @see #setInternalStateInfluenceAnalysisAggregation(InternalStateInfluenceAnalysisAggregation)
	 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getNumberOfCallsDeviation_InternalStateInfluenceAnalysisAggregation()
	 * @see de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation#getNumberOfCallsDeviation
	 * @model opposite="numberOfCallsDeviation" required="true" transient="false" ordered="false"
	 * @generated
	 */
	InternalStateInfluenceAnalysisAggregation getInternalStateInfluenceAnalysisAggregation();

	/**
	 * Sets the value of the '{@link de.fzi.se.quality.qualityannotation.NumberOfCallsDeviation#getInternalStateInfluenceAnalysisAggregation <em>Internal State Influence Analysis Aggregation</em>}' container reference.
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
	 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getNumberOfCallsDeviation_Maximum()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getMaximum();

	/**
	 * Sets the value of the '{@link de.fzi.se.quality.qualityannotation.NumberOfCallsDeviation#getMaximum <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum</em>' attribute.
	 * @see #getMaximum()
	 * @generated
	 */
	void setMaximum(double value);

	/**
	 * Returns the value of the '<em><b>Required Element</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.quality.qualityannotation.RequiredElement#getNumberOfCallsDeviation <em>Number Of Calls Deviation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Element</em>' containment reference.
	 * @see #setRequiredElement(RequiredElement)
	 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getNumberOfCallsDeviation_RequiredElement()
	 * @see de.fzi.se.quality.qualityannotation.RequiredElement#getNumberOfCallsDeviation
	 * @model opposite="numberOfCallsDeviation" containment="true" required="true" ordered="false"
	 * @generated
	 */
	RequiredElement getRequiredElement();

	/**
	 * Sets the value of the '{@link de.fzi.se.quality.qualityannotation.NumberOfCallsDeviation#getRequiredElement <em>Required Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Element</em>' containment reference.
	 * @see #getRequiredElement()
	 * @generated
	 */
	void setRequiredElement(RequiredElement value);

} // NumberOfCallsDeviation
