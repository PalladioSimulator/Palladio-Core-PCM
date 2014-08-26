/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ResourceCall;
import de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Abstract Internal Control Flow Action</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.impl.AbstractInternalControlFlowActionImpl#getResourceDemand_Action
 * <em>Resource Demand Action</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.impl.AbstractInternalControlFlowActionImpl#getInfrastructureCall__Action
 * <em>Infrastructure Call Action</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.impl.AbstractInternalControlFlowActionImpl#getResourceCall__Action
 * <em>Resource Call Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractInternalControlFlowActionImpl extends AbstractActionImpl implements
AbstractInternalControlFlowAction {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getResourceDemand_Action() <em>Resource Demand Action</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getResourceDemand_Action()
     * @generated
     * @ordered
     */
    protected EList<ParametricResourceDemand> resourceDemand_Action;

    /**
     * The cached value of the '{@link #getInfrastructureCall__Action()
     * <em>Infrastructure Call Action</em>}' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getInfrastructureCall__Action()
     * @generated
     * @ordered
     */
    protected EList<InfrastructureCall> infrastructureCall__Action;

    /**
     * The cached value of the '{@link #getResourceCall__Action() <em>Resource Call Action</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getResourceCall__Action()
     * @generated
     * @ordered
     */
    protected EList<ResourceCall> resourceCall__Action;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected AbstractInternalControlFlowActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPackage.Literals.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<ParametricResourceDemand> getResourceDemand_Action() {
        if (this.resourceDemand_Action == null) {
            this.resourceDemand_Action = new EObjectContainmentWithInverseEList<ParametricResourceDemand>(
                    ParametricResourceDemand.class, this,
                    SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION,
                    SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND);
        }
        return this.resourceDemand_Action;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<InfrastructureCall> getInfrastructureCall__Action() {
        if (this.infrastructureCall__Action == null) {
            this.infrastructureCall__Action = new EObjectContainmentWithInverseEList<InfrastructureCall>(
                    InfrastructureCall.class, this,
                    SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__INFRASTRUCTURE_CALL_ACTION,
                    SeffPerformancePackage.INFRASTRUCTURE_CALL__ACTION_INFRASTRUCTURE_CALL);
        }
        return this.infrastructureCall__Action;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<ResourceCall> getResourceCall__Action() {
        if (this.resourceCall__Action == null) {
            this.resourceCall__Action = new EObjectContainmentWithInverseEList<ResourceCall>(ResourceCall.class, this,
                    SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_CALL_ACTION,
                    SeffPerformancePackage.RESOURCE_CALL__ACTION_RESOURCE_CALL);
        }
        return this.resourceCall__Action;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getResourceDemand_Action()).basicAdd(
                    otherEnd, msgs);
        case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__INFRASTRUCTURE_CALL_ACTION:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getInfrastructureCall__Action()).basicAdd(
                    otherEnd, msgs);
        case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_CALL_ACTION:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getResourceCall__Action()).basicAdd(
                    otherEnd, msgs);
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
        case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION:
            return ((InternalEList<?>) this.getResourceDemand_Action()).basicRemove(otherEnd, msgs);
        case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__INFRASTRUCTURE_CALL_ACTION:
            return ((InternalEList<?>) this.getInfrastructureCall__Action()).basicRemove(otherEnd, msgs);
        case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_CALL_ACTION:
            return ((InternalEList<?>) this.getResourceCall__Action()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION:
            return this.getResourceDemand_Action();
        case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__INFRASTRUCTURE_CALL_ACTION:
            return this.getInfrastructureCall__Action();
        case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_CALL_ACTION:
            return this.getResourceCall__Action();
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
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION:
            this.getResourceDemand_Action().clear();
            this.getResourceDemand_Action().addAll((Collection<? extends ParametricResourceDemand>) newValue);
            return;
        case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__INFRASTRUCTURE_CALL_ACTION:
            this.getInfrastructureCall__Action().clear();
            this.getInfrastructureCall__Action().addAll((Collection<? extends InfrastructureCall>) newValue);
            return;
        case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_CALL_ACTION:
            this.getResourceCall__Action().clear();
            this.getResourceCall__Action().addAll((Collection<? extends ResourceCall>) newValue);
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
        case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION:
            this.getResourceDemand_Action().clear();
            return;
        case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__INFRASTRUCTURE_CALL_ACTION:
            this.getInfrastructureCall__Action().clear();
            return;
        case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_CALL_ACTION:
            this.getResourceCall__Action().clear();
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
        case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION:
            return this.resourceDemand_Action != null && !this.resourceDemand_Action.isEmpty();
        case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__INFRASTRUCTURE_CALL_ACTION:
            return this.infrastructureCall__Action != null && !this.infrastructureCall__Action.isEmpty();
        case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_CALL_ACTION:
            return this.resourceCall__Action != null && !this.resourceCall__Action.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // AbstractInternalControlFlowActionImpl
