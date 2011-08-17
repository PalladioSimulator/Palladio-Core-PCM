/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.QualityProperties;

import de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numeric Quality Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.QualityProperties.NumericQualityProperty#getResultDecoratorRepository <em>Result Decorator Repository</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.QualityProperties.NumericQualityProperty#getConfidenceInterval <em>Confidence Interval</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.QualityProperties.QualityPropertiesPackage#getNumericQualityProperty()
 * @model abstract="true"
 * @generated
 */
public interface NumericQualityProperty extends QualityProperty {
	/**
	 * Returns the value of the '<em><b>Result Decorator Repository</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Result Decorator for Performance
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Result Decorator Repository</em>' reference.
	 * @see #setResultDecoratorRepository(ResultDecoratorRepository)
	 * @see de.uka.ipd.sdq.pcm.designdecision.QualityProperties.QualityPropertiesPackage#getNumericQualityProperty_ResultDecoratorRepository()
	 * @model ordered="false"
	 * @generated
	 */
	ResultDecoratorRepository getResultDecoratorRepository();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.QualityProperties.NumericQualityProperty#getResultDecoratorRepository <em>Result Decorator Repository</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Decorator Repository</em>' reference.
	 * @see #getResultDecoratorRepository()
	 * @generated
	 */
	void setResultDecoratorRepository(ResultDecoratorRepository value);

	/**
	 * Returns the value of the '<em><b>Confidence Interval</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Confidence Interval</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Confidence Interval</em>' reference.
	 * @see #setConfidenceInterval(ConfidenceInterval)
	 * @see de.uka.ipd.sdq.pcm.designdecision.QualityProperties.QualityPropertiesPackage#getNumericQualityProperty_ConfidenceInterval()
	 * @model ordered="false"
	 * @generated
	 */
	ConfidenceInterval getConfidenceInterval();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.QualityProperties.NumericQualityProperty#getConfidenceInterval <em>Confidence Interval</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Confidence Interval</em>' reference.
	 * @see #getConfidenceInterval()
	 * @generated
	 */
	void setConfidenceInterval(ConfidenceInterval value);

} // NumericQualityProperty
