
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
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload#getArrivalRate <em>Arrival Rate</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getOpenWorkload()
 * @model
 * @generated
 */
public interface OpenWorkload extends Workload {
	/**
	 * Returns the value of the '<em><b>Arrival Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arrival Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arrival Rate</em>' attribute.
	 * @see #setArrivalRate(double)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getOpenWorkload_ArrivalRate()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getArrivalRate();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload#getArrivalRate <em>Arrival Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arrival Rate</em>' attribute.
	 * @see #getArrivalRate()
	 * @generated
	 */
	void setArrivalRate(double value);

} // OpenWorkload