/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Observed Identifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifier#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifier#getObservedIdentifierBasedMeasurements <em>Observed Identifier Based Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getObservedIdentifier()
 * @model
 * @generated
 */
public interface ObservedIdentifier extends Identifiable {
	/**
     * Returns the value of the '<em><b>Identifier</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Identifier</em>' reference.
     * @see #setIdentifier(Identifier)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getObservedIdentifier_Identifier()
     * @model required="true" ordered="false"
     * @generated
     */
	Identifier getIdentifier();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifier#getIdentifier <em>Identifier</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Identifier</em>' reference.
     * @see #getIdentifier()
     * @generated
     */
	void setIdentifier(Identifier value);

	/**
     * Returns the value of the '<em><b>Observed Identifier Based Measurements</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifierBasedMeasurements#getObservedIdentifiers <em>Observed Identifiers</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Observed Identifier Based Measurements</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Observed Identifier Based Measurements</em>' container reference.
     * @see #setObservedIdentifierBasedMeasurements(ObservedIdentifierBasedMeasurements)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getObservedIdentifier_ObservedIdentifierBasedMeasurements()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifierBasedMeasurements#getObservedIdentifiers
     * @model opposite="observedIdentifiers" required="true" transient="false" ordered="false"
     * @generated
     */
	ObservedIdentifierBasedMeasurements getObservedIdentifierBasedMeasurements();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifier#getObservedIdentifierBasedMeasurements <em>Observed Identifier Based Measurements</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Observed Identifier Based Measurements</em>' container reference.
     * @see #getObservedIdentifierBasedMeasurements()
     * @generated
     */
	void setObservedIdentifierBasedMeasurements(ObservedIdentifierBasedMeasurements value);

} // ObservedIdentifier
