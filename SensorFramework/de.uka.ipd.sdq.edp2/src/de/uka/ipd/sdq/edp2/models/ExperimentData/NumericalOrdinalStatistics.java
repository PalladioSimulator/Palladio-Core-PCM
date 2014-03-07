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
 * A representation of the model object '<em><b>Numerical Ordinal Statistics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalOrdinalStatistics#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalOrdinalStatistics#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalOrdinalStatistics#getMedian <em>Median</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalOrdinalStatistics#getPercentiles <em>Percentiles</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalOrdinalStatistics()
 * @model
 * @generated
 */
public interface NumericalOrdinalStatistics extends NumericalNominalStatistics {
	/**
     * Returns the value of the '<em><b>Minimum</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Minimum</em>' attribute.
     * @see #setMinimum(Measure)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalOrdinalStatistics_Minimum()
     * @model dataType="de.uka.ipd.sdq.edp2.models.ExperimentData.EJSMeasure" required="true" ordered="false"
     * @generated
     */
	Measure getMinimum();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalOrdinalStatistics#getMinimum <em>Minimum</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Minimum</em>' attribute.
     * @see #getMinimum()
     * @generated
     */
	void setMinimum(Measure value);

	/**
     * Returns the value of the '<em><b>Maximum</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Maximum</em>' attribute.
     * @see #setMaximum(Measure)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalOrdinalStatistics_Maximum()
     * @model dataType="de.uka.ipd.sdq.edp2.models.ExperimentData.EJSMeasure" required="true" ordered="false"
     * @generated
     */
	Measure getMaximum();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalOrdinalStatistics#getMaximum <em>Maximum</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Maximum</em>' attribute.
     * @see #getMaximum()
     * @generated
     */
	void setMaximum(Measure value);

	/**
     * Returns the value of the '<em><b>Median</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Median</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Median</em>' attribute.
     * @see #setMedian(Measure)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalOrdinalStatistics_Median()
     * @model dataType="de.uka.ipd.sdq.edp2.models.ExperimentData.EJSMeasure" ordered="false"
     * @generated
     */
	Measure getMedian();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalOrdinalStatistics#getMedian <em>Median</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Median</em>' attribute.
     * @see #getMedian()
     * @generated
     */
	void setMedian(Measure value);

	/**
     * Returns the value of the '<em><b>Percentiles</b></em>' containment reference list.
     * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalPercentile}.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalPercentile#getOrdinalStatistics <em>Ordinal Statistics</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Percentiles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Percentiles</em>' containment reference list.
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalOrdinalStatistics_Percentiles()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalPercentile#getOrdinalStatistics
     * @model opposite="ordinalStatistics" containment="true" ordered="false"
     * @generated
     */
	EList<NumericalPercentile> getPercentiles();

} // NumericalOrdinalStatistics
