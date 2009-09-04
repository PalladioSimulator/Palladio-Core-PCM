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
 * A representation of the model object '<em><b>Interval Statistics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.IntervalStatistics#getArithmethicMean <em>Arithmethic Mean</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.IntervalStatistics#getVariance <em>Variance</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.IntervalStatistics#getStandardDeviation <em>Standard Deviation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.IntervalStatistics#getSum <em>Sum</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.EmfmodelPackage#getIntervalStatistics()
 * @model
 * @generated
 */
public interface IntervalStatistics extends OrdinalStatistics {
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
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.EmfmodelPackage#getIntervalStatistics_ArithmethicMean()
	 * @model dataType="de.uka.ipd.sdq.edp2.models.emfmodel.EJSMeasure" required="true" ordered="false"
	 * @generated
	 */
	Measure getArithmethicMean();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.IntervalStatistics#getArithmethicMean <em>Arithmethic Mean</em>}' attribute.
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
	 * <p>
	 * If the meaning of the '<em>Variance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variance</em>' attribute.
	 * @see #setVariance(double)
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.EmfmodelPackage#getIntervalStatistics_Variance()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getVariance();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.IntervalStatistics#getVariance <em>Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variance</em>' attribute.
	 * @see #getVariance()
	 * @generated
	 */
	void setVariance(double value);

	/**
	 * Returns the value of the '<em><b>Standard Deviation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Standard Deviation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Standard Deviation</em>' attribute.
	 * @see #setStandardDeviation(double)
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.EmfmodelPackage#getIntervalStatistics_StandardDeviation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getStandardDeviation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.IntervalStatistics#getStandardDeviation <em>Standard Deviation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Standard Deviation</em>' attribute.
	 * @see #getStandardDeviation()
	 * @generated
	 */
	void setStandardDeviation(double value);

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
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.EmfmodelPackage#getIntervalStatistics_Sum()
	 * @model dataType="de.uka.ipd.sdq.edp2.models.emfmodel.EJSMeasure" required="true" ordered="false"
	 * @generated
	 */
	Measure getSum();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.IntervalStatistics#getSum <em>Sum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sum</em>' attribute.
	 * @see #getSum()
	 * @generated
	 */
	void setSum(Measure value);

} // IntervalStatistics
