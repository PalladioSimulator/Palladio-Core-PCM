/**
 * Copyright 2008, sdq.ipd.uka.de, U KA
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucomframework.simucomstatus;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Simulated Resources</b></em>
 * '. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedResources#getActiveResources
 * <em>Active Resources</em>}</li>
 * <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedResources#getPassiveResources
 * <em>Passive Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getSimulatedResources()
 * @model
 * @generated
 */
public interface SimulatedResources extends EObject {
    /**
     * Returns the value of the '<em><b>Active Resources</b></em>' containment reference list. The
     * list contents are of type {@link de.uka.ipd.sdq.simucomframework.simucomstatus.ActiveResouce}
     * . <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Active Resources</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Active Resources</em>' containment reference list.
     * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getSimulatedResources_ActiveResources()
     * @model containment="true" ordered="false"
     * @generated
     */
    EList<ActiveResouce> getActiveResources();

    /**
     * Returns the value of the '<em><b>Passive Resources</b></em>' containment reference list. The
     * list contents are of type
     * {@link de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource}. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Passive Resources</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Passive Resources</em>' containment reference list.
     * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getSimulatedResources_PassiveResources()
     * @model containment="true" ordered="false"
     * @generated
     */
    EList<PassiveResource> getPassiveResources();

} // SimulatedResources
