/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Measurements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.StateMeasurements#getObservedStates <em>Observed States</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getStateMeasurements()
 * @model
 * @generated
 */
public interface StateMeasurements extends RawYValues {
	/**
	 * Returns the value of the '<em><b>Observed States</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.sensorframework.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Observed States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Observed States</em>' reference list.
	 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getStateMeasurements_ObservedStates()
	 * @model ordered="false"
	 * @generated
	 */
	EList<State> getObservedStates();

} // StateMeasurements
