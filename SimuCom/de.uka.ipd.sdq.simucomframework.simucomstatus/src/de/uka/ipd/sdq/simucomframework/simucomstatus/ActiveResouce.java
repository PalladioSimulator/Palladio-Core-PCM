/**
 * Copyright 2008, sdq.ipd.uka.de, U KA
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucomframework.simucomstatus;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Active Resouce</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.ActiveResouce#getWaitingDemands <em>Waiting Demands</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.ActiveResouce#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getActiveResouce()
 * @model
 * @generated
 */
public interface ActiveResouce extends EObject {
	/**
	 * Returns the value of the '<em><b>Waiting Demands</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDemand}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDemand#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Waiting Demands</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Waiting Demands</em>' reference list.
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getActiveResouce_WaitingDemands()
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDemand#getResource
	 * @model opposite="resource" ordered="false"
	 * @generated
	 */
	EList<WaitForDemand> getWaitingDemands();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getActiveResouce_Id()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.ActiveResouce#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // ActiveResouce
