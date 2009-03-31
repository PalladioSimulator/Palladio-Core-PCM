/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel;

import javax.measure.Measure;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Intervals</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Describes the different aggregation intervals in detail. Includes start and end of each interval as well as two special intervals to reflect outliers. Intervals are not allowed to contain no value, there has to be a default. The default value is also saved to disc. The upper bound can be calculated as follows: upperBound = lowerBound + width * numberOfIntervals. The lower bound belongs to the first regular interval whereas the upper bound is the first value which is associated with the upper outlier interval.
 * 
 * The data structure is build up as follows for n=numberOfIntervals different requested measurement intervals:
 * First interval 'lower outlier interval': All measurements in the interval (-\infty, lowerBound).
 * Second to n-th interval 'regular interval': All measurements in the interval [lowerBound+width*(n-1), lowerBound+width*n).
 * n-th interval 'upper outlier interval': All measurements in the interval [lowerBound+width*n, \infty) = [upperBound+width*n, \infty).
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Intervals#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Intervals#getWidth <em>Width</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Intervals#getNumberOfIntervals <em>Number Of Intervals</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Intervals#getAggregatedMeasurements <em>Aggregated Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getIntervals()
 * @model
 * @generated
 */
public interface Intervals extends RawXSeries {
	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound</em>' attribute.
	 * @see #setLowerBound(Measure)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getIntervals_LowerBound()
	 * @model dataType="de.uka.ipd.sdq.edp2.models.emfmodel.EJSMeasure" required="true" ordered="false"
	 * @generated
	 */
	Measure getLowerBound();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Intervals#getLowerBound <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' attribute.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(Measure value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(Measure)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getIntervals_Width()
	 * @model dataType="de.uka.ipd.sdq.edp2.models.emfmodel.EJSMeasure" required="true" ordered="false"
	 * @generated
	 */
	Measure getWidth();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Intervals#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(Measure value);

	/**
	 * Returns the value of the '<em><b>Number Of Intervals</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Intervals</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Intervals</em>' attribute.
	 * @see #setNumberOfIntervals(long)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getIntervals_NumberOfIntervals()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	long getNumberOfIntervals();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Intervals#getNumberOfIntervals <em>Number Of Intervals</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Intervals</em>' attribute.
	 * @see #getNumberOfIntervals()
	 * @generated
	 */
	void setNumberOfIntervals(long value);

	/**
	 * Returns the value of the '<em><b>Aggregated Measurements</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregation#getRawXSeries <em>Raw XSeries</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregated Measurements</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregated Measurements</em>' container reference.
	 * @see #setAggregatedMeasurements(FixedWidthAggregation)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getIntervals_AggregatedMeasurements()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregation#getRawXSeries
	 * @model opposite="rawXSeries" required="true" transient="false" ordered="false"
	 * @generated
	 */
	FixedWidthAggregation getAggregatedMeasurements();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Intervals#getAggregatedMeasurements <em>Aggregated Measurements</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregated Measurements</em>' container reference.
	 * @see #getAggregatedMeasurements()
	 * @generated
	 */
	void setAggregatedMeasurements(FixedWidthAggregation value);

} // Intervals
