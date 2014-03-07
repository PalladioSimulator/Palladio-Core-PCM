/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Textual Ordinal Statistics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.TextualOrdinalStatistics#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.TextualOrdinalStatistics#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.TextualOrdinalStatistics#getMedian <em>Median</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getTextualOrdinalStatistics()
 * @model
 * @generated
 */
public interface TextualOrdinalStatistics extends TextualNominalStatistics {
	/**
     * Returns the value of the '<em><b>Minimum</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Minimum</em>' reference.
     * @see #setMinimum(Identifier)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getTextualOrdinalStatistics_Minimum()
     * @model required="true" ordered="false"
     * @generated
     */
	Identifier getMinimum();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.TextualOrdinalStatistics#getMinimum <em>Minimum</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Minimum</em>' reference.
     * @see #getMinimum()
     * @generated
     */
	void setMinimum(Identifier value);

	/**
     * Returns the value of the '<em><b>Maximum</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Maximum</em>' reference.
     * @see #setMaximum(Identifier)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getTextualOrdinalStatistics_Maximum()
     * @model required="true" ordered="false"
     * @generated
     */
	Identifier getMaximum();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.TextualOrdinalStatistics#getMaximum <em>Maximum</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Maximum</em>' reference.
     * @see #getMaximum()
     * @generated
     */
	void setMaximum(Identifier value);

	/**
     * Returns the value of the '<em><b>Median</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Median</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Median</em>' reference.
     * @see #setMedian(Identifier)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getTextualOrdinalStatistics_Median()
     * @model required="true" ordered="false"
     * @generated
     */
	Identifier getMedian();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.TextualOrdinalStatistics#getMedian <em>Median</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Median</em>' reference.
     * @see #getMedian()
     * @generated
     */
	void setMedian(Identifier value);

} // TextualOrdinalStatistics
