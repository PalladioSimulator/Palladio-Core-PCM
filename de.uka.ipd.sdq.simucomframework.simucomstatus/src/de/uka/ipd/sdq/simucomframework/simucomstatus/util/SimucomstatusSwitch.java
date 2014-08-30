/**
 * Copyright 2008, sdq.ipd.uka.de, U KA
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucomframework.simucomstatus.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.simucomframework.simucomstatus.Action;
import de.uka.ipd.sdq.simucomframework.simucomstatus.ActiveResouce;
import de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedProcesses;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedResources;
import de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForAcquire;
import de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDelay;
import de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDemand;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage
 * @generated
 */
public class SimucomstatusSwitch<T> {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static SimucomstatusPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SimucomstatusSwitch() {
        if (modelPackage == null) {
            modelPackage = SimucomstatusPackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public T doSwitch(EObject theEObject) {
        return doSwitch(theEObject.eClass(), theEObject);
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        } else {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
        case SimucomstatusPackage.SIMU_COM_STATUS: {
            SimuComStatus simuComStatus = (SimuComStatus) theEObject;
            T result = caseSimuComStatus(simuComStatus);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case SimucomstatusPackage.SIMULATED_PROCESSES: {
            SimulatedProcesses simulatedProcesses = (SimulatedProcesses) theEObject;
            T result = caseSimulatedProcesses(simulatedProcesses);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case SimucomstatusPackage.PROCESS: {
            de.uka.ipd.sdq.simucomframework.simucomstatus.Process process = (de.uka.ipd.sdq.simucomframework.simucomstatus.Process) theEObject;
            T result = caseProcess(process);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case SimucomstatusPackage.ACTION: {
            Action action = (Action) theEObject;
            T result = caseAction(action);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case SimucomstatusPackage.SIMULATED_RESOURCES: {
            SimulatedResources simulatedResources = (SimulatedResources) theEObject;
            T result = caseSimulatedResources(simulatedResources);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case SimucomstatusPackage.ACTIVE_RESOUCE: {
            ActiveResouce activeResouce = (ActiveResouce) theEObject;
            T result = caseActiveResouce(activeResouce);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case SimucomstatusPackage.WAIT_FOR_DEMAND: {
            WaitForDemand waitForDemand = (WaitForDemand) theEObject;
            T result = caseWaitForDemand(waitForDemand);
            if (result == null)
                result = caseAction(waitForDemand);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case SimucomstatusPackage.PASSIVE_RESOURCE: {
            PassiveResource passiveResource = (PassiveResource) theEObject;
            T result = casePassiveResource(passiveResource);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case SimucomstatusPackage.WAIT_FOR_ACQUIRE: {
            WaitForAcquire waitForAcquire = (WaitForAcquire) theEObject;
            T result = caseWaitForAcquire(waitForAcquire);
            if (result == null)
                result = caseAction(waitForAcquire);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case SimucomstatusPackage.WAIT_FOR_DELAY: {
            WaitForDelay waitForDelay = (WaitForDelay) theEObject;
            T result = caseWaitForDelay(waitForDelay);
            if (result == null)
                result = caseAction(waitForDelay);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        default:
            return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Simu Com Status</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Simu Com Status</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSimuComStatus(SimuComStatus object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Simulated Processes</em>
     * '. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Simulated Processes</em>
     *         '.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSimulatedProcesses(SimulatedProcesses object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Process</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Process</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseProcess(de.uka.ipd.sdq.simucomframework.simucomstatus.Process object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Action</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAction(Action object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Simulated Resources</em>
     * '. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Simulated Resources</em>
     *         '.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSimulatedResources(SimulatedResources object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Active Resouce</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Active Resouce</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseActiveResouce(ActiveResouce object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Wait For Demand</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Wait For Demand</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWaitForDemand(WaitForDemand object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Passive Resource</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Passive Resource</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePassiveResource(PassiveResource object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Wait For Acquire</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Wait For Acquire</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWaitForAcquire(WaitForAcquire object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Wait For Delay</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Wait For Delay</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWaitForDelay(WaitForDelay object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    public T defaultCase(EObject object) {
        return null;
    }

} // SimucomstatusSwitch
