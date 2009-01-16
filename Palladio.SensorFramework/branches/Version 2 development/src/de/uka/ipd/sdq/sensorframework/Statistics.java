/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework;

import javax.measure.Measure;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statistics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.Statistics#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.Statistics#getMean <em>Mean</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.Statistics#getMaximum <em>Maximum</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getStatistics()
 * @model
 * @generated
 */
public interface Statistics extends EObject {
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
	 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getStatistics_Minimum()
	 * @model dataType="de.uka.ipd.sdq.sensorframework.EJSMeasure" required="true" ordered="false"
	 * @generated
	 */
	Measure getMinimum();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.Statistics#getMinimum <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum</em>' attribute.
	 * @see #getMinimum()
	 * @generated
	 */
	void setMinimum(Measure value);

	/**
	 * Returns the value of the '<em><b>Mean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mean</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mean</em>' attribute.
	 * @see #setMean(Measure)
	 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getStatistics_Mean()
	 * @model dataType="de.uka.ipd.sdq.sensorframework.EJSMeasure" required="true" ordered="false"
	 * @generated
	 */
	Measure getMean();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.Statistics#getMean <em>Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mean</em>' attribute.
	 * @see #getMean()
	 * @generated
	 */
	void setMean(Measure value);

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
	 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getStatistics_Maximum()
	 * @model dataType="de.uka.ipd.sdq.sensorframework.EJSMeasure" required="true" ordered="false"
	 * @generated
	 */
	Measure getMaximum();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.Statistics#getMaximum <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum</em>' attribute.
	 * @see #getMaximum()
	 * @generated
	 */
	void setMaximum(Measure value);

} // Statistics
