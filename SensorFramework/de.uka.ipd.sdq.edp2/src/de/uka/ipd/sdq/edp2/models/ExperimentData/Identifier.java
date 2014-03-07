/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Identifier&nbsp;for a certain measurable/observable state of the measured object. Identifiers
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Identifier#getLiteral <em>Literal</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Identifier#getTextualBaseMetricDescription <em>Textual Base Metric Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getIdentifier()
 * @model
 * @generated
 */
public interface Identifier extends Identifiable {
	/**
     * Returns the value of the '<em><b>Literal</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Literal</em>' attribute.
     * @see #setLiteral(String)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getIdentifier_Literal()
     * @model required="true" ordered="false"
     * @generated
     */
	String getLiteral();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Identifier#getLiteral <em>Literal</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Literal</em>' attribute.
     * @see #getLiteral()
     * @generated
     */
	void setLiteral(String value);

	/**
     * Returns the value of the '<em><b>Textual Base Metric Description</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.TextualBaseMetricDescription#getIdentifiers <em>Identifiers</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Textual Base Metric Description</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Textual Base Metric Description</em>' container reference.
     * @see #setTextualBaseMetricDescription(TextualBaseMetricDescription)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getIdentifier_TextualBaseMetricDescription()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.TextualBaseMetricDescription#getIdentifiers
     * @model opposite="identifiers" required="true" transient="false" ordered="false"
     * @generated
     */
	TextualBaseMetricDescription getTextualBaseMetricDescription();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Identifier#getTextualBaseMetricDescription <em>Textual Base Metric Description</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Textual Base Metric Description</em>' container reference.
     * @see #getTextualBaseMetricDescription()
     * @generated
     */
	void setTextualBaseMetricDescription(TextualBaseMetricDescription value);

} // Identifier
