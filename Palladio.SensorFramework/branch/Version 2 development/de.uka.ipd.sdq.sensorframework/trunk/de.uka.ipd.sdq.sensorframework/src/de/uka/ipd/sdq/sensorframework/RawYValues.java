/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Raw YValues</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.RawYValues#getStatistics <em>Statistics</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getRawYValues()
 * @model abstract="true"
 * @generated
 */
public interface RawYValues extends EObject {
	/**
	 * Returns the value of the '<em><b>Statistics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statistics</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statistics</em>' containment reference.
	 * @see #setStatistics(Statistics)
	 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getRawYValues_Statistics()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Statistics getStatistics();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.RawYValues#getStatistics <em>Statistics</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statistics</em>' containment reference.
	 * @see #getStatistics()
	 * @generated
	 */
	void setStatistics(Statistics value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.statistics->size()=1 implies not self.oclIsKindOf(StateMeasurements)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean Statisticsonlyformeasurablevalues(DiagnosticChain diagnostics, Map context);

} // RawYValues
