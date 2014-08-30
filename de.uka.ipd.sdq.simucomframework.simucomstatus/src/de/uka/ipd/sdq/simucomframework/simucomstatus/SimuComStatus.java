/**
 * Copyright 2008, sdq.ipd.uka.de, U KA
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucomframework.simucomstatus;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Simu Com Status</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus#getProcessStatus <em>
 * Process Status</em>}</li>
 * <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus#getResourceStatus <em>
 * Resource Status</em>}</li>
 * <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus#getCurrentSimulationTime
 * <em>Current Simulation Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getSimuComStatus()
 * @model
 * @generated
 */
public interface SimuComStatus extends EObject {
    /**
     * Returns the value of the '<em><b>Process Status</b></em>' containment reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Process Status</em>' containment reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Process Status</em>' containment reference.
     * @see #setProcessStatus(SimulatedProcesses)
     * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getSimuComStatus_ProcessStatus()
     * @model containment="true" required="true" ordered="false"
     * @generated
     */
    SimulatedProcesses getProcessStatus();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus#getProcessStatus
     * <em>Process Status</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Process Status</em>' containment reference.
     * @see #getProcessStatus()
     * @generated
     */
    void setProcessStatus(SimulatedProcesses value);

    /**
     * Returns the value of the '<em><b>Resource Status</b></em>' containment reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Resource Status</em>' containment reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Resource Status</em>' containment reference.
     * @see #setResourceStatus(SimulatedResources)
     * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getSimuComStatus_ResourceStatus()
     * @model containment="true" required="true" ordered="false"
     * @generated
     */
    SimulatedResources getResourceStatus();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus#getResourceStatus
     * <em>Resource Status</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Resource Status</em>' containment reference.
     * @see #getResourceStatus()
     * @generated
     */
    void setResourceStatus(SimulatedResources value);

    /**
     * Returns the value of the '<em><b>Current Simulation Time</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Current Simulation Time</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Current Simulation Time</em>' attribute.
     * @see #setCurrentSimulationTime(double)
     * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getSimuComStatus_CurrentSimulationTime()
     * @model required="true" ordered="false"
     * @generated
     */
    double getCurrentSimulationTime();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus#getCurrentSimulationTime
     * <em>Current Simulation Time</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Current Simulation Time</em>' attribute.
     * @see #getCurrentSimulationTime()
     * @generated
     */
    void setCurrentSimulationTime(double value);

} // SimuComStatus
