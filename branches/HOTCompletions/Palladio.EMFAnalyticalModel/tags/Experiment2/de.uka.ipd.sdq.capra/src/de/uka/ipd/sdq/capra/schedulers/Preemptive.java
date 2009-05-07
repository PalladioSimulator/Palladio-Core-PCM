/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.schedulers;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Preemptive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.Preemptive#isImmediate <em>Immediate</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.Preemptive#getQuantum <em>Quantum</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage#getPreemptive()
 * @model
 * @generated
 */
public interface Preemptive extends Assignment {
	/**
	 * Returns the value of the '<em><b>Immediate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Immediate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Immediate</em>' attribute.
	 * @see #setImmediate(boolean)
	 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage#getPreemptive_Immediate()
	 * @model required="true"
	 * @generated
	 */
	boolean isImmediate();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.schedulers.Preemptive#isImmediate <em>Immediate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Immediate</em>' attribute.
	 * @see #isImmediate()
	 * @generated
	 */
	void setImmediate(boolean value);

	/**
	 * Returns the value of the '<em><b>Quantum</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quantum</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quantum</em>' containment reference.
	 * @see #setQuantum(Quantum)
	 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage#getPreemptive_Quantum()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Quantum getQuantum();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.schedulers.Preemptive#getQuantum <em>Quantum</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quantum</em>' containment reference.
	 * @see #getQuantum()
	 * @generated
	 */
	void setQuantum(Quantum value);

} // Preemptive
