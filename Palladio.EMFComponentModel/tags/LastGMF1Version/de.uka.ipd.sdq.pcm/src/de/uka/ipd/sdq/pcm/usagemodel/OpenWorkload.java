
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Open Workload</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload#getInterArrivalTime_OpenWorkload <em>Inter Arrival Time Open Workload</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getOpenWorkload()
 * @model
 * @generated
 */
public interface OpenWorkload extends Workload {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Inter Arrival Time Open Workload</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inter Arrival Time Open Workload</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inter Arrival Time Open Workload</em>' containment reference.
	 * @see #setInterArrivalTime_OpenWorkload(InterArrivalTime)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getOpenWorkload_InterArrivalTime_OpenWorkload()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	InterArrivalTime getInterArrivalTime_OpenWorkload();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload#getInterArrivalTime_OpenWorkload <em>Inter Arrival Time Open Workload</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inter Arrival Time Open Workload</em>' containment reference.
	 * @see #getInterArrivalTime_OpenWorkload()
	 * @generated
	 */
	void setInterArrivalTime_OpenWorkload(InterArrivalTime value);

} // OpenWorkload