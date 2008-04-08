/**
 * Copyright 2008, sdq.ipd.uka.de, U KA
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucomframework.simucomstatus;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.Action#getActionStartTime <em>Action Start Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.Action#getActionDuration <em>Action Duration</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getAction()
 * @model abstract="true"
 * @generated
 */
public interface Action extends EObject {
	/**
	 * Returns the value of the '<em><b>Action Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Start Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Start Time</em>' attribute.
	 * @see #setActionStartTime(double)
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getAction_ActionStartTime()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getActionStartTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.Action#getActionStartTime <em>Action Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Start Time</em>' attribute.
	 * @see #getActionStartTime()
	 * @generated
	 */
	void setActionStartTime(double value);

	/**
	 * Returns the value of the '<em><b>Action Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Duration</em>' attribute.
	 * @see #setActionDuration(double)
	 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getAction_ActionDuration()
	 * @model required="true" transient="true" volatile="true" ordered="false"
	 * @generated
	 */
	double getActionDuration();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.Action#getActionDuration <em>Action Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Duration</em>' attribute.
	 * @see #getActionDuration()
	 * @generated
	 */
	void setActionDuration(double value);

} // Action
