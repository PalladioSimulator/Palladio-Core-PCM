/**
 * Copyright 2008, sdq.ipd.uka.de, U KA
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucomframework.simucomstatus.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedProcesses;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedResources;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Simu Com Status</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimuComStatusImpl#getProcessStatus
 * <em>Process Status</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimuComStatusImpl#getResourceStatus
 * <em>Resource Status</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimuComStatusImpl#getCurrentSimulationTime
 * <em>Current Simulation Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimuComStatusImpl extends EObjectImpl implements SimuComStatus {
    /**
     * The cached value of the '{@link #getProcessStatus() <em>Process Status</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getProcessStatus()
     * @generated
     * @ordered
     */
    protected SimulatedProcesses processStatus;

    /**
     * The cached value of the '{@link #getResourceStatus() <em>Resource Status</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getResourceStatus()
     * @generated
     * @ordered
     */
    protected SimulatedResources resourceStatus;

    /**
     * The default value of the '{@link #getCurrentSimulationTime()
     * <em>Current Simulation Time</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getCurrentSimulationTime()
     * @generated
     * @ordered
     */
    protected static final double CURRENT_SIMULATION_TIME_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getCurrentSimulationTime() <em>Current Simulation Time</em>}
     * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getCurrentSimulationTime()
     * @generated
     * @ordered
     */
    protected double currentSimulationTime = CURRENT_SIMULATION_TIME_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected SimuComStatusImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SimucomstatusPackage.Literals.SIMU_COM_STATUS;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SimulatedProcesses getProcessStatus() {
        return processStatus;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetProcessStatus(SimulatedProcesses newProcessStatus, NotificationChain msgs) {
        SimulatedProcesses oldProcessStatus = processStatus;
        processStatus = newProcessStatus;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    SimucomstatusPackage.SIMU_COM_STATUS__PROCESS_STATUS, oldProcessStatus, newProcessStatus);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setProcessStatus(SimulatedProcesses newProcessStatus) {
        if (newProcessStatus != processStatus) {
            NotificationChain msgs = null;
            if (processStatus != null)
                msgs = ((InternalEObject) processStatus).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - SimucomstatusPackage.SIMU_COM_STATUS__PROCESS_STATUS, null, msgs);
            if (newProcessStatus != null)
                msgs = ((InternalEObject) newProcessStatus).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - SimucomstatusPackage.SIMU_COM_STATUS__PROCESS_STATUS, null, msgs);
            msgs = basicSetProcessStatus(newProcessStatus, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimucomstatusPackage.SIMU_COM_STATUS__PROCESS_STATUS,
                    newProcessStatus, newProcessStatus));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SimulatedResources getResourceStatus() {
        return resourceStatus;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetResourceStatus(SimulatedResources newResourceStatus, NotificationChain msgs) {
        SimulatedResources oldResourceStatus = resourceStatus;
        resourceStatus = newResourceStatus;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    SimucomstatusPackage.SIMU_COM_STATUS__RESOURCE_STATUS, oldResourceStatus, newResourceStatus);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setResourceStatus(SimulatedResources newResourceStatus) {
        if (newResourceStatus != resourceStatus) {
            NotificationChain msgs = null;
            if (resourceStatus != null)
                msgs = ((InternalEObject) resourceStatus).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - SimucomstatusPackage.SIMU_COM_STATUS__RESOURCE_STATUS, null, msgs);
            if (newResourceStatus != null)
                msgs = ((InternalEObject) newResourceStatus).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - SimucomstatusPackage.SIMU_COM_STATUS__RESOURCE_STATUS, null, msgs);
            msgs = basicSetResourceStatus(newResourceStatus, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    SimucomstatusPackage.SIMU_COM_STATUS__RESOURCE_STATUS, newResourceStatus, newResourceStatus));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public double getCurrentSimulationTime() {
        return currentSimulationTime;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setCurrentSimulationTime(double newCurrentSimulationTime) {
        double oldCurrentSimulationTime = currentSimulationTime;
        currentSimulationTime = newCurrentSimulationTime;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    SimucomstatusPackage.SIMU_COM_STATUS__CURRENT_SIMULATION_TIME, oldCurrentSimulationTime,
                    currentSimulationTime));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case SimucomstatusPackage.SIMU_COM_STATUS__PROCESS_STATUS:
            return basicSetProcessStatus(null, msgs);
        case SimucomstatusPackage.SIMU_COM_STATUS__RESOURCE_STATUS:
            return basicSetResourceStatus(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case SimucomstatusPackage.SIMU_COM_STATUS__PROCESS_STATUS:
            return getProcessStatus();
        case SimucomstatusPackage.SIMU_COM_STATUS__RESOURCE_STATUS:
            return getResourceStatus();
        case SimucomstatusPackage.SIMU_COM_STATUS__CURRENT_SIMULATION_TIME:
            return new Double(getCurrentSimulationTime());
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case SimucomstatusPackage.SIMU_COM_STATUS__PROCESS_STATUS:
            setProcessStatus((SimulatedProcesses) newValue);
            return;
        case SimucomstatusPackage.SIMU_COM_STATUS__RESOURCE_STATUS:
            setResourceStatus((SimulatedResources) newValue);
            return;
        case SimucomstatusPackage.SIMU_COM_STATUS__CURRENT_SIMULATION_TIME:
            setCurrentSimulationTime(((Double) newValue).doubleValue());
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case SimucomstatusPackage.SIMU_COM_STATUS__PROCESS_STATUS:
            setProcessStatus((SimulatedProcesses) null);
            return;
        case SimucomstatusPackage.SIMU_COM_STATUS__RESOURCE_STATUS:
            setResourceStatus((SimulatedResources) null);
            return;
        case SimucomstatusPackage.SIMU_COM_STATUS__CURRENT_SIMULATION_TIME:
            setCurrentSimulationTime(CURRENT_SIMULATION_TIME_EDEFAULT);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case SimucomstatusPackage.SIMU_COM_STATUS__PROCESS_STATUS:
            return processStatus != null;
        case SimucomstatusPackage.SIMU_COM_STATUS__RESOURCE_STATUS:
            return resourceStatus != null;
        case SimucomstatusPackage.SIMU_COM_STATUS__CURRENT_SIMULATION_TIME:
            return currentSimulationTime != CURRENT_SIMULATION_TIME_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (currentSimulationTime: ");
        result.append(currentSimulationTime);
        result.append(')');
        return result.toString();
    }

} // SimuComStatusImpl
