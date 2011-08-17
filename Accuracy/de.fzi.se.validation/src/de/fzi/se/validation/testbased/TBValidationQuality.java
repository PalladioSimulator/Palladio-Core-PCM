/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased;

import de.fzi.se.quality.QualityStatement;

import de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation;
import de.fzi.se.quality.qualityannotation.QualityAnnotation;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TB Validation Quality</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.TBValidationQuality#getStopStrategy <em>Stop Strategy</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.TBValidationQuality#getGenerationStrategy <em>Generation Strategy</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.TBValidationQuality#getInternalStateInfluenceAnalysisStrategy <em>Internal State Influence Analysis Strategy</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.TBValidationQuality#getQualityAnnotations <em>Quality Annotations</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.TBValidationQuality#getInternalStateInfluenceAnalysisAggregationResults <em>Internal State Influence Analysis Aggregation Results</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.validation.testbased.TestbasedPackage#getTBValidationQuality()
 * @model
 * @generated
 */
public interface TBValidationQuality extends QualityStatement, Identifier {
	/**
	 * Returns the value of the '<em><b>Stop Strategy</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.validation.testbased.TestcaseExecutionStopStrategy#getValidationQuality <em>Validation Quality</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stop Strategy</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stop Strategy</em>' containment reference.
	 * @see #setStopStrategy(TestcaseExecutionStopStrategy)
	 * @see de.fzi.se.validation.testbased.TestbasedPackage#getTBValidationQuality_StopStrategy()
	 * @see de.fzi.se.validation.testbased.TestcaseExecutionStopStrategy#getValidationQuality
	 * @model opposite="validationQuality" containment="true" required="true" ordered="false"
	 * @generated
	 */
	TestcaseExecutionStopStrategy getStopStrategy();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.TBValidationQuality#getStopStrategy <em>Stop Strategy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop Strategy</em>' containment reference.
	 * @see #getStopStrategy()
	 * @generated
	 */
	void setStopStrategy(TestcaseExecutionStopStrategy value);

	/**
	 * Returns the value of the '<em><b>Generation Strategy</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.validation.testbased.TestcaseGenerationStrategy#getValidationQuality <em>Validation Quality</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generation Strategy</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generation Strategy</em>' containment reference.
	 * @see #setGenerationStrategy(TestcaseGenerationStrategy)
	 * @see de.fzi.se.validation.testbased.TestbasedPackage#getTBValidationQuality_GenerationStrategy()
	 * @see de.fzi.se.validation.testbased.TestcaseGenerationStrategy#getValidationQuality
	 * @model opposite="validationQuality" containment="true" required="true" ordered="false"
	 * @generated
	 */
	TestcaseGenerationStrategy getGenerationStrategy();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.TBValidationQuality#getGenerationStrategy <em>Generation Strategy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generation Strategy</em>' containment reference.
	 * @see #getGenerationStrategy()
	 * @generated
	 */
	void setGenerationStrategy(TestcaseGenerationStrategy value);

	/**
	 * Returns the value of the '<em><b>Internal State Influence Analysis Strategy</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.validation.testbased.InternalStateInfluenceAnalysisStrategy#getTbValidationQuality <em>Tb Validation Quality</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal State Influence Analysis Strategy</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal State Influence Analysis Strategy</em>' containment reference.
	 * @see #setInternalStateInfluenceAnalysisStrategy(InternalStateInfluenceAnalysisStrategy)
	 * @see de.fzi.se.validation.testbased.TestbasedPackage#getTBValidationQuality_InternalStateInfluenceAnalysisStrategy()
	 * @see de.fzi.se.validation.testbased.InternalStateInfluenceAnalysisStrategy#getTbValidationQuality
	 * @model opposite="tbValidationQuality" containment="true" required="true" ordered="false"
	 * @generated
	 */
	InternalStateInfluenceAnalysisStrategy getInternalStateInfluenceAnalysisStrategy();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.TBValidationQuality#getInternalStateInfluenceAnalysisStrategy <em>Internal State Influence Analysis Strategy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal State Influence Analysis Strategy</em>' containment reference.
	 * @see #getInternalStateInfluenceAnalysisStrategy()
	 * @generated
	 */
	void setInternalStateInfluenceAnalysisStrategy(InternalStateInfluenceAnalysisStrategy value);

	/**
	 * Returns the value of the '<em><b>Quality Annotations</b></em>' reference list.
	 * The list contents are of type {@link de.fzi.se.quality.qualityannotation.QualityAnnotation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * References the QualityAnnotations which are valid given this TBValidationQuality instance.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Quality Annotations</em>' reference list.
	 * @see de.fzi.se.validation.testbased.TestbasedPackage#getTBValidationQuality_QualityAnnotations()
	 * @model ordered="false"
	 * @generated
	 */
	EList<QualityAnnotation> getQualityAnnotations();

	/**
	 * Returns the value of the '<em><b>Internal State Influence Analysis Aggregation Results</b></em>' reference list.
	 * The list contents are of type {@link de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal State Influence Analysis Aggregation Results</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal State Influence Analysis Aggregation Results</em>' reference list.
	 * @see de.fzi.se.validation.testbased.TestbasedPackage#getTBValidationQuality_InternalStateInfluenceAnalysisAggregationResults()
	 * @model ordered="false"
	 * @generated
	 */
	EList<InternalStateInfluenceAnalysisAggregation> getInternalStateInfluenceAnalysisAggregationResults();

} // TBValidationQuality
