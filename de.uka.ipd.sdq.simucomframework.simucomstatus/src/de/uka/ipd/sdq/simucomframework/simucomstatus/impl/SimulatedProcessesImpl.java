/**
 * Copyright 2008, sdq.ipd.uka.de, U KA
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucomframework.simucomstatus.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedProcesses;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Simulated Processes</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.simucomframework.simucomstatus.impl.SimulatedProcessesImpl#getProcesses
 * <em>Processes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimulatedProcessesImpl extends EObjectImpl implements SimulatedProcesses {
    /**
     * The cached value of the '{@link #getProcesses() <em>Processes</em>}' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getProcesses()
     * @generated
     * @ordered
     */
    protected EList<de.uka.ipd.sdq.simucomframework.simucomstatus.Process> processes;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected SimulatedProcessesImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SimucomstatusPackage.Literals.SIMULATED_PROCESSES;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<de.uka.ipd.sdq.simucomframework.simucomstatus.Process> getProcesses() {
        if (processes == null) {
            processes = new EObjectContainmentEList<de.uka.ipd.sdq.simucomframework.simucomstatus.Process>(
                    de.uka.ipd.sdq.simucomframework.simucomstatus.Process.class, this,
                    SimucomstatusPackage.SIMULATED_PROCESSES__PROCESSES);
        }
        return processes;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case SimucomstatusPackage.SIMULATED_PROCESSES__PROCESSES:
            return ((InternalEList<?>) getProcesses()).basicRemove(otherEnd, msgs);
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
        case SimucomstatusPackage.SIMULATED_PROCESSES__PROCESSES:
            return getProcesses();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case SimucomstatusPackage.SIMULATED_PROCESSES__PROCESSES:
            getProcesses().clear();
            getProcesses().addAll(
                    (Collection<? extends de.uka.ipd.sdq.simucomframework.simucomstatus.Process>) newValue);
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
        case SimucomstatusPackage.SIMULATED_PROCESSES__PROCESSES:
            getProcesses().clear();
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
        case SimucomstatusPackage.SIMULATED_PROCESSES__PROCESSES:
            return processes != null && !processes.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // SimulatedProcessesImpl
