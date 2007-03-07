
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Closed Workload</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload#getPopulation <em>Population</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload#getThinkTime_ClosedWorkload <em>Think Time Closed Workload</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getClosedWorkload()
 * @model
 * @generated
 */
public interface ClosedWorkload extends Workload {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Population</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Population</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Population</em>' attribute.
	 * @see #setPopulation(int)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getClosedWorkload_Population()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getPopulation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload#getPopulation <em>Population</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Population</em>' attribute.
	 * @see #getPopulation()
	 * @generated
	 */
	void setPopulation(int value);

	/**
	 * Returns the value of the '<em><b>Think Time Closed Workload</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Think Time Closed Workload</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Think Time Closed Workload</em>' containment reference.
	 * @see #setThinkTime_ClosedWorkload(ThinkTime)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getClosedWorkload_ThinkTime_ClosedWorkload()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ThinkTime getThinkTime_ClosedWorkload();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload#getThinkTime_ClosedWorkload <em>Think Time Closed Workload</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Think Time Closed Workload</em>' containment reference.
	 * @see #getThinkTime_ClosedWorkload()
	 * @generated
	 */
	void setThinkTime_ClosedWorkload(ThinkTime value);

} // ClosedWorkload