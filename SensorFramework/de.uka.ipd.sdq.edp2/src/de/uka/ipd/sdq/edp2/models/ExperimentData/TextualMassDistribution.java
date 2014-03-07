/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Textual Mass Distribution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.TextualMassDistribution#getFrequency <em>Frequency</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.TextualMassDistribution#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.TextualMassDistribution#getTextualNominalStatistics <em>Textual Nominal Statistics</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getTextualMassDistribution()
 * @model
 * @generated
 */
public interface TextualMassDistribution extends EObject {
	/**
     * Returns the value of the '<em><b>Frequency</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Frequency</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Frequency</em>' attribute.
     * @see #setFrequency(long)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getTextualMassDistribution_Frequency()
     * @model required="true" ordered="false"
     * @generated
     */
	long getFrequency();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.TextualMassDistribution#getFrequency <em>Frequency</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Frequency</em>' attribute.
     * @see #getFrequency()
     * @generated
     */
	void setFrequency(long value);

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
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getTextualMassDistribution_Identifier()
     * @model required="true" ordered="false"
     * @generated
     */
	Identifier getIdentifier();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.TextualMassDistribution#getIdentifier <em>Identifier</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Identifier</em>' reference.
     * @see #getIdentifier()
     * @generated
     */
	void setIdentifier(Identifier value);

	/**
     * Returns the value of the '<em><b>Textual Nominal Statistics</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.TextualNominalStatistics#getMassDistribution <em>Mass Distribution</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Textual Nominal Statistics</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Textual Nominal Statistics</em>' container reference.
     * @see #setTextualNominalStatistics(TextualNominalStatistics)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getTextualMassDistribution_TextualNominalStatistics()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.TextualNominalStatistics#getMassDistribution
     * @model opposite="massDistribution" required="true" transient="false" ordered="false"
     * @generated
     */
	TextualNominalStatistics getTextualNominalStatistics();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.TextualMassDistribution#getTextualNominalStatistics <em>Textual Nominal Statistics</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Textual Nominal Statistics</em>' container reference.
     * @see #getTextualNominalStatistics()
     * @generated
     */
	void setTextualNominalStatistics(TextualNominalStatistics value);

} // TextualMassDistribution
