/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.models.emfmodel;

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
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.Statistics#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.Statistics#getMean <em>Mean</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.Statistics#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.Statistics#getSum <em>Sum</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.Statistics#getCount <em>Count</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.Statistics#getRawYValues <em>Raw YValues</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getStatistics()
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
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getStatistics_Minimum()
	 * @model dataType="de.uka.ipd.sdq.sensorframework.models.emfmodel.EJSMeasure" required="true" ordered="false"
	 * @generated
	 */
	Measure getMinimum();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.Statistics#getMinimum <em>Minimum</em>}' attribute.
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
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getStatistics_Mean()
	 * @model dataType="de.uka.ipd.sdq.sensorframework.models.emfmodel.EJSMeasure" required="true" ordered="false"
	 * @generated
	 */
	Measure getMean();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.Statistics#getMean <em>Mean</em>}' attribute.
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
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getStatistics_Maximum()
	 * @model dataType="de.uka.ipd.sdq.sensorframework.models.emfmodel.EJSMeasure" required="true" ordered="false"
	 * @generated
	 */
	Measure getMaximum();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.Statistics#getMaximum <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum</em>' attribute.
	 * @see #getMaximum()
	 * @generated
	 */
	void setMaximum(Measure value);

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
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getStatistics_Sum()
	 * @model dataType="de.uka.ipd.sdq.sensorframework.models.emfmodel.EJSMeasure" required="true" ordered="false"
	 * @generated
	 */
	Measure getSum();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.Statistics#getSum <em>Sum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sum</em>' attribute.
	 * @see #getSum()
	 * @generated
	 */
	void setSum(Measure value);

	/**
	 * Returns the value of the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count</em>' attribute.
	 * @see #setCount(long)
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getStatistics_Count()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	long getCount();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.Statistics#getCount <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count</em>' attribute.
	 * @see #getCount()
	 * @generated
	 */
	void setCount(long value);

	/**
	 * Returns the value of the '<em><b>Raw YValues</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.RawYValues#getStatistics <em>Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw YValues</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw YValues</em>' container reference.
	 * @see #setRawYValues(RawYValues)
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getStatistics_RawYValues()
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.RawYValues#getStatistics
	 * @model opposite="statistics" required="true" transient="false" ordered="false"
	 * @generated
	 */
	RawYValues getRawYValues();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.Statistics#getRawYValues <em>Raw YValues</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw YValues</em>' container reference.
	 * @see #getRawYValues()
	 * @generated
	 */
	void setRawYValues(RawYValues value);

} // Statistics
