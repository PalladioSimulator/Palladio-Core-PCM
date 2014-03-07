/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;

import javax.measure.Measure;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numerical Interval Statistics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalIntervalStatistics#getArithmethicMean <em>Arithmethic Mean</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalIntervalStatistics#getVariance <em>Variance</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalIntervalStatistics#getStandardDeviation <em>Standard Deviation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalIntervalStatistics#getSum <em>Sum</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalIntervalStatistics()
 * @model
 * @generated
 */
public interface NumericalIntervalStatistics extends NumericalOrdinalStatistics {
	/**
     * Returns the value of the '<em><b>Arithmethic Mean</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arithmethic Mean</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Arithmethic Mean</em>' attribute.
     * @see #setArithmethicMean(Measure)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalIntervalStatistics_ArithmethicMean()
     * @model dataType="de.uka.ipd.sdq.edp2.models.ExperimentData.EJSMeasure" required="true" ordered="false"
     * @generated
     */
	Measure getArithmethicMean();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalIntervalStatistics#getArithmethicMean <em>Arithmethic Mean</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Arithmethic Mean</em>' attribute.
     * @see #getArithmethicMean()
     * @generated
     */
	void setArithmethicMean(Measure value);

	/**
     * Returns the value of the '<em><b>Variance</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * <p>
     *     Please note that the variance is a dimensionless value. Use Dimensionless.UNIT as unit for the measure.
     * </p>
     * <!-- end-model-doc -->
     * @return the value of the '<em>Variance</em>' attribute.
     * @see #setVariance(Measure)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalIntervalStatistics_Variance()
     * @model dataType="de.uka.ipd.sdq.edp2.models.ExperimentData.EJSMeasure" required="true" ordered="false"
     * @generated
     */
	Measure getVariance();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalIntervalStatistics#getVariance <em>Variance</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Variance</em>' attribute.
     * @see #getVariance()
     * @generated
     */
	void setVariance(Measure value);

	/**
     * Returns the value of the '<em><b>Standard Deviation</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * <p>
     *     Please note that the standard deviation is a dimensionless value. Use Dimensionless.UNIT as unit for the measure.
     * </p>
     * <!-- end-model-doc -->
     * @return the value of the '<em>Standard Deviation</em>' attribute.
     * @see #setStandardDeviation(Measure)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalIntervalStatistics_StandardDeviation()
     * @model dataType="de.uka.ipd.sdq.edp2.models.ExperimentData.EJSMeasure" required="true" ordered="false"
     * @generated
     */
	Measure getStandardDeviation();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalIntervalStatistics#getStandardDeviation <em>Standard Deviation</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Standard Deviation</em>' attribute.
     * @see #getStandardDeviation()
     * @generated
     */
	void setStandardDeviation(Measure value);

	/**
     * Returns the value of the '<em><b>Sum</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sum</em>' attribute.
     * @see #setSum(Measure)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalIntervalStatistics_Sum()
     * @model dataType="de.uka.ipd.sdq.edp2.models.ExperimentData.EJSMeasure" required="true" ordered="false"
     * @generated
     */
	Measure getSum();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalIntervalStatistics#getSum <em>Sum</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sum</em>' attribute.
     * @see #getSum()
     * @generated
     */
	void setSum(Measure value);

} // NumericalIntervalStatistics
