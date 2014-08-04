/**
 * Copyright 2008, sdq.ipd.uka.de, U KA
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucomframework.simucomstatus;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Simulated Processes</b></em>
 * '. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedProcesses#getProcesses <em>
 * Processes</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getSimulatedProcesses()
 * @model
 * @generated
 */
public interface SimulatedProcesses extends EObject {
    /**
     * Returns the value of the '<em><b>Processes</b></em>' containment reference list. The list
     * contents are of type {@link de.uka.ipd.sdq.simucomframework.simucomstatus.Process}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Processes</em>' containment reference list isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Processes</em>' containment reference list.
     * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getSimulatedProcesses_Processes()
     * @model containment="true" ordered="false"
     * @generated
     */
    EList<de.uka.ipd.sdq.simucomframework.simucomstatus.Process> getProcesses();

} // SimulatedProcesses
