/**
 * Copyright 2008, sdq.ipd.uka.de, U KA
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucomframework.simucomstatus;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wait For Acquire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForAcquire#getResource <em>Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getWaitForAcquire()
 * @model
 * @generated
 */
public interface WaitForAcquire extends Action {
	/**
	 * Returns the value of the '<em><b>Resource</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource#getWaitingProcesses <em>Waiting Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' reference.
	 * @see #setResource(PassiveResource)
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getWaitForAcquire_Resource()
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource#getWaitingProcesses
	 * @model opposite="waitingProcesses" required="true" ordered="false"
	 * @generated
	 */
	PassiveResource getResource();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForAcquire#getResource <em>Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' reference.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(PassiveResource value);

} // WaitForAcquire
