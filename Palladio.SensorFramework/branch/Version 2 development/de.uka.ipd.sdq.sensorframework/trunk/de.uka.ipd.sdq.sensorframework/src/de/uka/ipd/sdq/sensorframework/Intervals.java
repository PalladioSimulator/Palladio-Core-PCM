/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework;

import javax.measure.Measure;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Intervals</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.Intervals#getOffset <em>Offset</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.Intervals#getIntervalWidth <em>Interval Width</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.Intervals#getNumberOfIntervals <em>Number Of Intervals</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getIntervals()
 * @model
 * @generated
 */
public interface Intervals extends RawXValues {
	/**
	 * Returns the value of the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' attribute.
	 * @see #setOffset(Measure)
	 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getIntervals_Offset()
	 * @model dataType="de.uka.ipd.sdq.sensorframework.EJSMeasure" required="true" ordered="false"
	 * @generated
	 */
	Measure getOffset();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.Intervals#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(Measure value);

	/**
	 * Returns the value of the '<em><b>Interval Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interval Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interval Width</em>' attribute.
	 * @see #setIntervalWidth(Measure)
	 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getIntervals_IntervalWidth()
	 * @model dataType="de.uka.ipd.sdq.sensorframework.EJSMeasure" required="true" ordered="false"
	 * @generated
	 */
	Measure getIntervalWidth();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.Intervals#getIntervalWidth <em>Interval Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interval Width</em>' attribute.
	 * @see #getIntervalWidth()
	 * @generated
	 */
	void setIntervalWidth(Measure value);

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
	 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getIntervals_NumberOfIntervals()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	long getNumberOfIntervals();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.Intervals#getNumberOfIntervals <em>Number Of Intervals</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Intervals</em>' attribute.
	 * @see #getNumberOfIntervals()
	 * @generated
	 */
	void setNumberOfIntervals(long value);

} // Intervals
