/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;

import javax.measure.Measure;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numerical Nominal Statistics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * !self.dataSeries.oclIsKindOf(IdentifierBasedMeasurements)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalNominalStatistics#getNumberMeasurements <em>Number Measurements</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalNominalStatistics#getNumericalMassDistribution <em>Numerical Mass Distribution</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalNominalStatistics#getDataSeries <em>Data Series</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalNominalStatistics()
 * @model
 * @generated
 */
public interface NumericalNominalStatistics extends Identifiable {
	/**
     * Returns the value of the '<em><b>Number Measurements</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Number of measurements in the data series.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Number Measurements</em>' attribute.
     * @see #setNumberMeasurements(Measure)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalNominalStatistics_NumberMeasurements()
     * @model dataType="de.uka.ipd.sdq.edp2.models.ExperimentData.EJSMeasure" required="true" ordered="false"
     * @generated
     */
	Measure getNumberMeasurements();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalNominalStatistics#getNumberMeasurements <em>Number Measurements</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Number Measurements</em>' attribute.
     * @see #getNumberMeasurements()
     * @generated
     */
	void setNumberMeasurements(Measure value);

	/**
     * Returns the value of the '<em><b>Numerical Mass Distribution</b></em>' containment reference list.
     * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalMassDistribution}.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalMassDistribution#getNumericalNominalStatistics <em>Numerical Nominal Statistics</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Numerical Mass Distribution</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Numerical Mass Distribution</em>' containment reference list.
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalNominalStatistics_NumericalMassDistribution()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalMassDistribution#getNumericalNominalStatistics
     * @model opposite="numericalNominalStatistics" containment="true" ordered="false"
     * @generated
     */
	EList<NumericalMassDistribution> getNumericalMassDistribution();

	/**
     * Returns the value of the '<em><b>Data Series</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries#getNumericalStatistics <em>Numerical Statistics</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Series</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Data Series</em>' container reference.
     * @see #setDataSeries(DataSeries)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalNominalStatistics_DataSeries()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries#getNumericalStatistics
     * @model opposite="numericalStatistics" required="true" transient="false" ordered="false"
     * @generated
     */
	DataSeries getDataSeries();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalNominalStatistics#getDataSeries <em>Data Series</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Series</em>' container reference.
     * @see #getDataSeries()
     * @generated
     */
	void setDataSeries(DataSeries value);

} // NumericalNominalStatistics
