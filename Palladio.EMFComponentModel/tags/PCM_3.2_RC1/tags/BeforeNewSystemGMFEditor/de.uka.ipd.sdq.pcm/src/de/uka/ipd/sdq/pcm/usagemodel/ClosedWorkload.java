
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
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload#getThinkTime <em>Think Time</em>}</li>
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
	 * Returns the value of the '<em><b>Think Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Think Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Think Time</em>' attribute.
	 * @see #setThinkTime(double)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getClosedWorkload_ThinkTime()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getThinkTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload#getThinkTime <em>Think Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Think Time</em>' attribute.
	 * @see #getThinkTime()
	 * @generated
	 */
	void setThinkTime(double value);

} // ClosedWorkload