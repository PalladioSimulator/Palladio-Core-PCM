/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fixed Width Aggregation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.FixedWidthAggregation#getRawYValues <em>Raw YValues</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.FixedWidthAggregation#getRawXValues <em>Raw XValues</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getFixedWidthAggregation()
 * @model abstract="true"
 * @generated
 */
public interface FixedWidthAggregation extends AggregatedMeasurements {
	/**
	 * Returns the value of the '<em><b>Raw YValues</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw YValues</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw YValues</em>' containment reference.
	 * @see #setRawYValues(RawYValues)
	 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getFixedWidthAggregation_RawYValues()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	RawYValues getRawYValues();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.FixedWidthAggregation#getRawYValues <em>Raw YValues</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw YValues</em>' containment reference.
	 * @see #getRawYValues()
	 * @generated
	 */
	void setRawYValues(RawYValues value);

	/**
	 * Returns the value of the '<em><b>Raw XValues</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw XValues</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw XValues</em>' containment reference.
	 * @see #setRawXValues(Intervals)
	 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getFixedWidthAggregation_RawXValues()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Intervals getRawXValues();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.FixedWidthAggregation#getRawXValues <em>Raw XValues</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw XValues</em>' containment reference.
	 * @see #getRawXValues()
	 * @generated
	 */
	void setRawXValues(Intervals value);

} // FixedWidthAggregation
