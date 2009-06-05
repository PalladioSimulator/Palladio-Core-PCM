/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.schedulers;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Quantum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.Quantum#getTimeSlice <em>Time Slice</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage#getQuantum()
 * @model
 * @generated
 */
public interface Quantum extends EObject {
	/**
	 * Returns the value of the '<em><b>Time Slice</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Slice</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Slice</em>' attribute.
	 * @see #setTimeSlice(double)
	 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage#getQuantum_TimeSlice()
	 * @model default="0" required="true"
	 * @generated
	 */
	double getTimeSlice();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.schedulers.Quantum#getTimeSlice <em>Time Slice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Slice</em>' attribute.
	 * @see #getTimeSlice()
	 * @generated
	 */
	void setTimeSlice(double value);

} // Quantum
