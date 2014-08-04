/**
 * Copyright 2008, sdq.ipd.uka.de, U KA
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucomframework.simucomstatus;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Process</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.Process#getCurrentAction <em>Current
 * Action</em>}</li>
 * <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.Process#getId <em>Id</em>}</li>
 * <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.Process#getProcessStartTime <em>Process
 * Start Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getProcess()
 * @model
 * @generated
 */
public interface Process extends EObject {
    /**
     * Returns the value of the '<em><b>Current Action</b></em>' containment reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Current Action</em>' containment reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Current Action</em>' containment reference.
     * @see #setCurrentAction(Action)
     * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getProcess_CurrentAction()
     * @model containment="true" required="true" ordered="false"
     * @generated
     */
    Action getCurrentAction();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.simucomframework.simucomstatus.Process#getCurrentAction
     * <em>Current Action</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Current Action</em>' containment reference.
     * @see #getCurrentAction()
     * @generated
     */
    void setCurrentAction(Action value);

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getProcess_Id()
     * @model required="true" ordered="false"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link de.uka.ipd.sdq.simucomframework.simucomstatus.Process#getId
     * <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

    /**
     * Returns the value of the '<em><b>Process Start Time</b></em>' attribute. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Process Start Time</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Process Start Time</em>' attribute.
     * @see #setProcessStartTime(double)
     * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getProcess_ProcessStartTime()
     * @model required="true" ordered="false"
     * @generated
     */
    double getProcessStartTime();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.simucomframework.simucomstatus.Process#getProcessStartTime
     * <em>Process Start Time</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Process Start Time</em>' attribute.
     * @see #getProcessStartTime()
     * @generated
     */
    void setProcessStartTime(double value);

} // Process
