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
 * A representation of the model object '<em><b>Numerical Percentile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalPercentile#getPercentile <em>Percentile</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalPercentile#getValue <em>Value</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalPercentile#getOrdinalStatistics <em>Ordinal Statistics</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalPercentile()
 * @model
 * @generated
 */
public interface NumericalPercentile extends Identifiable {
	/**
     * Returns the value of the '<em><b>Percentile</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Percentile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Percentile</em>' attribute.
     * @see #setPercentile(double)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalPercentile_Percentile()
     * @model required="true" ordered="false"
     * @generated
     */
	double getPercentile();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalPercentile#getPercentile <em>Percentile</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Percentile</em>' attribute.
     * @see #getPercentile()
     * @generated
     */
	void setPercentile(double value);

	/**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(Measure)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalPercentile_Value()
     * @model dataType="de.uka.ipd.sdq.edp2.models.ExperimentData.EJSMeasure" required="true" ordered="false"
     * @generated
     */
	Measure getValue();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalPercentile#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
	void setValue(Measure value);

	/**
     * Returns the value of the '<em><b>Ordinal Statistics</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalOrdinalStatistics#getPercentiles <em>Percentiles</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordinal Statistics</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Ordinal Statistics</em>' container reference.
     * @see #setOrdinalStatistics(NumericalOrdinalStatistics)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalPercentile_OrdinalStatistics()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalOrdinalStatistics#getPercentiles
     * @model opposite="percentiles" required="true" transient="false" ordered="false"
     * @generated
     */
	NumericalOrdinalStatistics getOrdinalStatistics();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalPercentile#getOrdinalStatistics <em>Ordinal Statistics</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ordinal Statistics</em>' container reference.
     * @see #getOrdinalStatistics()
     * @generated
     */
	void setOrdinalStatistics(NumericalOrdinalStatistics value);

} // NumericalPercentile
