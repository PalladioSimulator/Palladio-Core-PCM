/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.usagemodel.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.palladiosimulator.pcm.usagemodel.UsageScenario;
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;
import org.palladiosimulator.pcm.usagemodel.Workload;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workload</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.usagemodel.impl.WorkloadImpl#getUsageScenario_Workload <em>Usage Scenario Workload</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class WorkloadImpl extends CDOObjectImpl implements Workload {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WorkloadImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsagemodelPackage.Literals.WORKLOAD;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected int eStaticFeatureCount() {
        return 0;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UsageScenario getUsageScenario_Workload() {
        return (UsageScenario) eDynamicGet(UsagemodelPackage.WORKLOAD__USAGE_SCENARIO_WORKLOAD,
                UsagemodelPackage.Literals.WORKLOAD__USAGE_SCENARIO_WORKLOAD, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetUsageScenario_Workload(UsageScenario newUsageScenario_Workload,
            NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newUsageScenario_Workload,
                UsagemodelPackage.WORKLOAD__USAGE_SCENARIO_WORKLOAD, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUsageScenario_Workload(UsageScenario newUsageScenario_Workload) {
        eDynamicSet(UsagemodelPackage.WORKLOAD__USAGE_SCENARIO_WORKLOAD,
                UsagemodelPackage.Literals.WORKLOAD__USAGE_SCENARIO_WORKLOAD, newUsageScenario_Workload);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case UsagemodelPackage.WORKLOAD__USAGE_SCENARIO_WORKLOAD:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetUsageScenario_Workload((UsageScenario) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case UsagemodelPackage.WORKLOAD__USAGE_SCENARIO_WORKLOAD:
            return basicSetUsageScenario_Workload(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
        case UsagemodelPackage.WORKLOAD__USAGE_SCENARIO_WORKLOAD:
            return eInternalContainer().eInverseRemove(this, UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO,
                    UsageScenario.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case UsagemodelPackage.WORKLOAD__USAGE_SCENARIO_WORKLOAD:
            return getUsageScenario_Workload();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case UsagemodelPackage.WORKLOAD__USAGE_SCENARIO_WORKLOAD:
            setUsageScenario_Workload((UsageScenario) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case UsagemodelPackage.WORKLOAD__USAGE_SCENARIO_WORKLOAD:
            setUsageScenario_Workload((UsageScenario) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case UsagemodelPackage.WORKLOAD__USAGE_SCENARIO_WORKLOAD:
            return getUsageScenario_Workload() != null;
        }
        return super.eIsSet(featureID);
    }

} //WorkloadImpl
