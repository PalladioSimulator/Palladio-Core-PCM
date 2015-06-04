/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.mdsdprofiles.impl.StereotypableElementImpl;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.Workload;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Workload</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.WorkloadImpl#getUsageScenario_Workload <em>Usage
 * Scenario Workload</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class WorkloadImpl extends StereotypableElementImpl implements Workload {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected WorkloadImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsagemodelPackage.Literals.WORKLOAD;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public UsageScenario getUsageScenario_Workload() {
        if (this.eContainerFeatureID() != UsagemodelPackage.WORKLOAD__USAGE_SCENARIO_WORKLOAD) {
            return null;
        }
        return (UsageScenario) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetUsageScenario_Workload(final UsageScenario newUsageScenario_Workload,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newUsageScenario_Workload,
                UsagemodelPackage.WORKLOAD__USAGE_SCENARIO_WORKLOAD, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setUsageScenario_Workload(final UsageScenario newUsageScenario_Workload) {
        if (newUsageScenario_Workload != this.eInternalContainer()
                || (this.eContainerFeatureID() != UsagemodelPackage.WORKLOAD__USAGE_SCENARIO_WORKLOAD && newUsageScenario_Workload != null)) {
            if (EcoreUtil.isAncestor(this, newUsageScenario_Workload)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newUsageScenario_Workload != null) {
                msgs = ((InternalEObject) newUsageScenario_Workload).eInverseAdd(this,
                        UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO, UsageScenario.class, msgs);
            }
            msgs = this.basicSetUsageScenario_Workload(newUsageScenario_Workload, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.WORKLOAD__USAGE_SCENARIO_WORKLOAD, newUsageScenario_Workload,
                    newUsageScenario_Workload));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case UsagemodelPackage.WORKLOAD__USAGE_SCENARIO_WORKLOAD:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetUsageScenario_Workload((UsageScenario) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case UsagemodelPackage.WORKLOAD__USAGE_SCENARIO_WORKLOAD:
            return this.basicSetUsageScenario_Workload(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(final NotificationChain msgs) {
        switch (this.eContainerFeatureID()) {
        case UsagemodelPackage.WORKLOAD__USAGE_SCENARIO_WORKLOAD:
            return this.eInternalContainer().eInverseRemove(this,
                    UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO, UsageScenario.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case UsagemodelPackage.WORKLOAD__USAGE_SCENARIO_WORKLOAD:
            return this.getUsageScenario_Workload();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case UsagemodelPackage.WORKLOAD__USAGE_SCENARIO_WORKLOAD:
            this.setUsageScenario_Workload((UsageScenario) newValue);
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
    public void eUnset(final int featureID) {
        switch (featureID) {
        case UsagemodelPackage.WORKLOAD__USAGE_SCENARIO_WORKLOAD:
            this.setUsageScenario_Workload((UsageScenario) null);
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
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case UsagemodelPackage.WORKLOAD__USAGE_SCENARIO_WORKLOAD:
            return this.getUsageScenario_Workload() != null;
        }
        return super.eIsSet(featureID);
    }

} // WorkloadImpl
