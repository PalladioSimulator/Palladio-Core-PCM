/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.seff.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.AbstractInternalControlFlowAction;
import org.palladiosimulator.pcm.seff.InternalCallAction;
import org.palladiosimulator.pcm.seff.ResourceDemandingBehaviour;
import org.palladiosimulator.pcm.seff.ResourceDemandingInternalBehaviour;
import org.palladiosimulator.pcm.seff.SeffPackage;

import org.palladiosimulator.pcm.seff.seff_performance.InfrastructureCall;
import org.palladiosimulator.pcm.seff.seff_performance.ParametricResourceDemand;
import org.palladiosimulator.pcm.seff.seff_performance.ResourceCall;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Internal Call Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.seff.impl.InternalCallActionImpl#getPredecessor_AbstractAction <em>Predecessor Abstract Action</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.seff.impl.InternalCallActionImpl#getSuccessor_AbstractAction <em>Successor Abstract Action</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.seff.impl.InternalCallActionImpl#getResourceDemandingBehaviour_AbstractAction <em>Resource Demanding Behaviour Abstract Action</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.seff.impl.InternalCallActionImpl#getResourceDemand_Action <em>Resource Demand Action</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.seff.impl.InternalCallActionImpl#getInfrastructureCall__Action <em>Infrastructure Call Action</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.seff.impl.InternalCallActionImpl#getResourceCall__Action <em>Resource Call Action</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.seff.impl.InternalCallActionImpl#getCalledResourceDemandingInternalBehaviour <em>Called Resource Demanding Internal Behaviour</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InternalCallActionImpl extends CallActionImpl implements InternalCallAction {

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
    protected InternalCallActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPackage.Literals.INTERNAL_CALL_ACTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AbstractAction getPredecessor_AbstractAction() {
        return (AbstractAction) eDynamicGet(SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION,
                SeffPackage.Literals.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AbstractAction basicGetPredecessor_AbstractAction() {
        return (AbstractAction) eDynamicGet(SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION,
                SeffPackage.Literals.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPredecessor_AbstractAction(AbstractAction newPredecessor_AbstractAction,
            NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject) newPredecessor_AbstractAction,
                SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPredecessor_AbstractAction(AbstractAction newPredecessor_AbstractAction) {
        eDynamicSet(SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION,
                SeffPackage.Literals.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION, newPredecessor_AbstractAction);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AbstractAction getSuccessor_AbstractAction() {
        return (AbstractAction) eDynamicGet(SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION,
                SeffPackage.Literals.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AbstractAction basicGetSuccessor_AbstractAction() {
        return (AbstractAction) eDynamicGet(SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION,
                SeffPackage.Literals.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSuccessor_AbstractAction(AbstractAction newSuccessor_AbstractAction,
            NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject) newSuccessor_AbstractAction,
                SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSuccessor_AbstractAction(AbstractAction newSuccessor_AbstractAction) {
        eDynamicSet(SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION,
                SeffPackage.Literals.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION, newSuccessor_AbstractAction);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceDemandingBehaviour getResourceDemandingBehaviour_AbstractAction() {
        return (ResourceDemandingBehaviour) eDynamicGet(
                SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION,
                SeffPackage.Literals.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetResourceDemandingBehaviour_AbstractAction(
            ResourceDemandingBehaviour newResourceDemandingBehaviour_AbstractAction, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newResourceDemandingBehaviour_AbstractAction,
                SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setResourceDemandingBehaviour_AbstractAction(
            ResourceDemandingBehaviour newResourceDemandingBehaviour_AbstractAction) {
        eDynamicSet(SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION,
                SeffPackage.Literals.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION,
                newResourceDemandingBehaviour_AbstractAction);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<ParametricResourceDemand> getResourceDemand_Action() {
        return (EList<ParametricResourceDemand>) eDynamicGet(SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION,
                SeffPackage.Literals.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<InfrastructureCall> getInfrastructureCall__Action() {
        return (EList<InfrastructureCall>) eDynamicGet(SeffPackage.INTERNAL_CALL_ACTION__INFRASTRUCTURE_CALL_ACTION,
                SeffPackage.Literals.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__INFRASTRUCTURE_CALL_ACTION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<ResourceCall> getResourceCall__Action() {
        return (EList<ResourceCall>) eDynamicGet(SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_CALL_ACTION,
                SeffPackage.Literals.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_CALL_ACTION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceDemandingInternalBehaviour getCalledResourceDemandingInternalBehaviour() {
        return (ResourceDemandingInternalBehaviour) eDynamicGet(
                SeffPackage.INTERNAL_CALL_ACTION__CALLED_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR,
                SeffPackage.Literals.INTERNAL_CALL_ACTION__CALLED_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceDemandingInternalBehaviour basicGetCalledResourceDemandingInternalBehaviour() {
        return (ResourceDemandingInternalBehaviour) eDynamicGet(
                SeffPackage.INTERNAL_CALL_ACTION__CALLED_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR,
                SeffPackage.Literals.INTERNAL_CALL_ACTION__CALLED_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCalledResourceDemandingInternalBehaviour(
            ResourceDemandingInternalBehaviour newCalledResourceDemandingInternalBehaviour) {
        eDynamicSet(SeffPackage.INTERNAL_CALL_ACTION__CALLED_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR,
                SeffPackage.Literals.INTERNAL_CALL_ACTION__CALLED_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR,
                newCalledResourceDemandingInternalBehaviour);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            AbstractAction predecessor_AbstractAction = basicGetPredecessor_AbstractAction();
            if (predecessor_AbstractAction != null)
                msgs = ((InternalEObject) predecessor_AbstractAction).eInverseRemove(this,
                        SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION, AbstractAction.class, msgs);
            return basicSetPredecessor_AbstractAction((AbstractAction) otherEnd, msgs);
        case SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            AbstractAction successor_AbstractAction = basicGetSuccessor_AbstractAction();
            if (successor_AbstractAction != null)
                msgs = ((InternalEObject) successor_AbstractAction).eInverseRemove(this,
                        SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION, AbstractAction.class, msgs);
            return basicSetSuccessor_AbstractAction((AbstractAction) otherEnd, msgs);
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetResourceDemandingBehaviour_AbstractAction((ResourceDemandingBehaviour) otherEnd, msgs);
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getResourceDemand_Action()).basicAdd(otherEnd,
                    msgs);
        case SeffPackage.INTERNAL_CALL_ACTION__INFRASTRUCTURE_CALL_ACTION:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getInfrastructureCall__Action())
                    .basicAdd(otherEnd, msgs);
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_CALL_ACTION:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getResourceCall__Action()).basicAdd(otherEnd,
                    msgs);
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
        case SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            return basicSetPredecessor_AbstractAction(null, msgs);
        case SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            return basicSetSuccessor_AbstractAction(null, msgs);
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            return basicSetResourceDemandingBehaviour_AbstractAction(null, msgs);
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION:
            return ((InternalEList<?>) getResourceDemand_Action()).basicRemove(otherEnd, msgs);
        case SeffPackage.INTERNAL_CALL_ACTION__INFRASTRUCTURE_CALL_ACTION:
            return ((InternalEList<?>) getInfrastructureCall__Action()).basicRemove(otherEnd, msgs);
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_CALL_ACTION:
            return ((InternalEList<?>) getResourceCall__Action()).basicRemove(otherEnd, msgs);
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
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            return eInternalContainer().eInverseRemove(this, SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
                    ResourceDemandingBehaviour.class, msgs);
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
        case SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            if (resolve)
                return getPredecessor_AbstractAction();
            return basicGetPredecessor_AbstractAction();
        case SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            if (resolve)
                return getSuccessor_AbstractAction();
            return basicGetSuccessor_AbstractAction();
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            return getResourceDemandingBehaviour_AbstractAction();
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION:
            return getResourceDemand_Action();
        case SeffPackage.INTERNAL_CALL_ACTION__INFRASTRUCTURE_CALL_ACTION:
            return getInfrastructureCall__Action();
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_CALL_ACTION:
            return getResourceCall__Action();
        case SeffPackage.INTERNAL_CALL_ACTION__CALLED_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR:
            if (resolve)
                return getCalledResourceDemandingInternalBehaviour();
            return basicGetCalledResourceDemandingInternalBehaviour();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            setPredecessor_AbstractAction((AbstractAction) newValue);
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            setSuccessor_AbstractAction((AbstractAction) newValue);
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            setResourceDemandingBehaviour_AbstractAction((ResourceDemandingBehaviour) newValue);
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION:
            getResourceDemand_Action().clear();
            getResourceDemand_Action().addAll((Collection<? extends ParametricResourceDemand>) newValue);
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__INFRASTRUCTURE_CALL_ACTION:
            getInfrastructureCall__Action().clear();
            getInfrastructureCall__Action().addAll((Collection<? extends InfrastructureCall>) newValue);
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_CALL_ACTION:
            getResourceCall__Action().clear();
            getResourceCall__Action().addAll((Collection<? extends ResourceCall>) newValue);
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__CALLED_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR:
            setCalledResourceDemandingInternalBehaviour((ResourceDemandingInternalBehaviour) newValue);
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
        case SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            setPredecessor_AbstractAction((AbstractAction) null);
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            setSuccessor_AbstractAction((AbstractAction) null);
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            setResourceDemandingBehaviour_AbstractAction((ResourceDemandingBehaviour) null);
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION:
            getResourceDemand_Action().clear();
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__INFRASTRUCTURE_CALL_ACTION:
            getInfrastructureCall__Action().clear();
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_CALL_ACTION:
            getResourceCall__Action().clear();
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__CALLED_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR:
            setCalledResourceDemandingInternalBehaviour((ResourceDemandingInternalBehaviour) null);
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
        case SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION:
            return basicGetPredecessor_AbstractAction() != null;
        case SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION:
            return basicGetSuccessor_AbstractAction() != null;
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
            return getResourceDemandingBehaviour_AbstractAction() != null;
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION:
            return !getResourceDemand_Action().isEmpty();
        case SeffPackage.INTERNAL_CALL_ACTION__INFRASTRUCTURE_CALL_ACTION:
            return !getInfrastructureCall__Action().isEmpty();
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_CALL_ACTION:
            return !getResourceCall__Action().isEmpty();
        case SeffPackage.INTERNAL_CALL_ACTION__CALLED_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR:
            return basicGetCalledResourceDemandingInternalBehaviour() != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == AbstractAction.class) {
            switch (derivedFeatureID) {
            case SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION:
                return SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION;
            case SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION:
                return SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION;
            case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
                return SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION;
            default:
                return -1;
            }
        }
        if (baseClass == AbstractInternalControlFlowAction.class) {
            switch (derivedFeatureID) {
            case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION:
                return SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION;
            case SeffPackage.INTERNAL_CALL_ACTION__INFRASTRUCTURE_CALL_ACTION:
                return SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__INFRASTRUCTURE_CALL_ACTION;
            case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_CALL_ACTION:
                return SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_CALL_ACTION;
            default:
                return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == AbstractAction.class) {
            switch (baseFeatureID) {
            case SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION:
                return SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION;
            case SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION:
                return SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION;
            case SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION:
                return SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION;
            default:
                return -1;
            }
        }
        if (baseClass == AbstractInternalControlFlowAction.class) {
            switch (baseFeatureID) {
            case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION:
                return SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION;
            case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__INFRASTRUCTURE_CALL_ACTION:
                return SeffPackage.INTERNAL_CALL_ACTION__INFRASTRUCTURE_CALL_ACTION;
            case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_CALL_ACTION:
                return SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_CALL_ACTION;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} //InternalCallActionImpl
