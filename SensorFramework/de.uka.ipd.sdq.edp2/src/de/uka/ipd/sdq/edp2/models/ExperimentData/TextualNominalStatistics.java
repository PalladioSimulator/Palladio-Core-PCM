/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Textual Nominal Statistics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * self.dataSeries.oclIsKindOf(IdentifierBasedMeasurements)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.TextualNominalStatistics#getNumberMeasurements <em>Number Measurements</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.TextualNominalStatistics#getMassDistribution <em>Mass Distribution</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.TextualNominalStatistics#getDataSeries <em>Data Series</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getTextualNominalStatistics()
 * @model
 * @generated
 */
public interface TextualNominalStatistics extends EObject {
	/**
     * Returns the value of the '<em><b>Number Measurements</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Measurements</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Number Measurements</em>' attribute.
     * @see #setNumberMeasurements(long)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getTextualNominalStatistics_NumberMeasurements()
     * @model required="true" ordered="false"
     * @generated
     */
	long getNumberMeasurements();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.TextualNominalStatistics#getNumberMeasurements <em>Number Measurements</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Number Measurements</em>' attribute.
     * @see #getNumberMeasurements()
     * @generated
     */
	void setNumberMeasurements(long value);

	/**
     * Returns the value of the '<em><b>Mass Distribution</b></em>' containment reference list.
     * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.ExperimentData.TextualMassDistribution}.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.TextualMassDistribution#getTextualNominalStatistics <em>Textual Nominal Statistics</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mass Distribution</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Mass Distribution</em>' containment reference list.
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getTextualNominalStatistics_MassDistribution()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.TextualMassDistribution#getTextualNominalStatistics
     * @model opposite="textualNominalStatistics" containment="true" ordered="false"
     * @generated
     */
	EList<TextualMassDistribution> getMassDistribution();

	/**
     * Returns the value of the '<em><b>Data Series</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries#getTextualStatistics <em>Textual Statistics</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Series</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Data Series</em>' container reference.
     * @see #setDataSeries(DataSeries)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getTextualNominalStatistics_DataSeries()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries#getTextualStatistics
     * @model opposite="textualStatistics" required="true" transient="false" ordered="false"
     * @generated
     */
	DataSeries getDataSeries();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.TextualNominalStatistics#getDataSeries <em>Data Series</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Series</em>' container reference.
     * @see #getDataSeries()
     * @generated
     */
	void setDataSeries(DataSeries value);

} // TextualNominalStatistics
