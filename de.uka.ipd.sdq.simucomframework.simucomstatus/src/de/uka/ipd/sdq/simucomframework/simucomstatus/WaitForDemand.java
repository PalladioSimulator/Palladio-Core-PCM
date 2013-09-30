/**
 * Copyright 2008, sdq.ipd.uka.de, U KA
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucomframework.simucomstatus;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wait For Demand</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDemand#getDemand <em>Demand</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDemand#getResource <em>Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getWaitForDemand()
 * @model
 * @generated
 */
public interface WaitForDemand extends Action {
	/**
	 * Returns the value of the '<em><b>Demand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Demand</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Demand</em>' attribute.
	 * @see #setDemand(double)
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getWaitForDemand_Demand()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getDemand();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDemand#getDemand <em>Demand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Demand</em>' attribute.
	 * @see #getDemand()
	 * @generated
	 */
	void setDemand(double value);

	/**
	 * Returns the value of the '<em><b>Resource</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.ActiveResouce#getWaitingDemands <em>Waiting Demands</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' reference.
	 * @see #setResource(ActiveResouce)
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getWaitForDemand_Resource()
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.ActiveResouce#getWaitingDemands
	 * @model opposite="waitingDemands" required="true" ordered="false"
	 * @generated
	 */
	ActiveResouce getResource();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDemand#getResource <em>Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' reference.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(ActiveResouce value);

} // WaitForDemand
