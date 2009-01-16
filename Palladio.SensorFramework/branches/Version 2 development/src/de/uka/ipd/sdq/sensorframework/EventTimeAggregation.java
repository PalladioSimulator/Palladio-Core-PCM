/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Time Aggregation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The aggregation interval is within the eventTime(s) of the measurements.
 * 
 * An Example is to calculate the throughput per event time second if the values stored are completions of processes and summing is used to generate the aggregated values.
 * <!-- end-model-doc -->
 *
 *
 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getEventTimeAggregation()
 * @model
 * @generated
 */
public interface EventTimeAggregation extends FixedWidthAggregation {
} // EventTimeAggregation
