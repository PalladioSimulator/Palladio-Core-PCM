/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.usagemodel.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.pcm.core.entity.impl.EntityImpl;

import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;
import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour;
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract User Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.usagemodel.impl.AbstractUserActionImpl#getSuccessor <em>Successor</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.usagemodel.impl.AbstractUserActionImpl#getPredecessor <em>Predecessor</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.usagemodel.impl.AbstractUserActionImpl#getScenarioBehaviour_AbstractUserAction <em>Scenario Behaviour Abstract User Action</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractUserActionImpl extends EntityImpl implements AbstractUserAction {

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
    protected AbstractUserActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsagemodelPackage.Literals.ABSTRACT_USER_ACTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AbstractUserAction getSuccessor() {
        return (AbstractUserAction) eDynamicGet(UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR,
                UsagemodelPackage.Literals.ABSTRACT_USER_ACTION__SUCCESSOR, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AbstractUserAction basicGetSuccessor() {
        return (AbstractUserAction) eDynamicGet(UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR,
                UsagemodelPackage.Literals.ABSTRACT_USER_ACTION__SUCCESSOR, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSuccessor(AbstractUserAction newSuccessor, NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject) newSuccessor, UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR,
                msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSuccessor(AbstractUserAction newSuccessor) {
        eDynamicSet(UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR,
                UsagemodelPackage.Literals.ABSTRACT_USER_ACTION__SUCCESSOR, newSuccessor);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AbstractUserAction getPredecessor() {
        return (AbstractUserAction) eDynamicGet(UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR,
                UsagemodelPackage.Literals.ABSTRACT_USER_ACTION__PREDECESSOR, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AbstractUserAction basicGetPredecessor() {
        return (AbstractUserAction) eDynamicGet(UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR,
                UsagemodelPackage.Literals.ABSTRACT_USER_ACTION__PREDECESSOR, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPredecessor(AbstractUserAction newPredecessor, NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject) newPredecessor, UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR,
                msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPredecessor(AbstractUserAction newPredecessor) {
        eDynamicSet(UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR,
                UsagemodelPackage.Literals.ABSTRACT_USER_ACTION__PREDECESSOR, newPredecessor);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ScenarioBehaviour getScenarioBehaviour_AbstractUserAction() {
        return (ScenarioBehaviour) eDynamicGet(
                UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION,
                UsagemodelPackage.Literals.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetScenarioBehaviour_AbstractUserAction(
            ScenarioBehaviour newScenarioBehaviour_AbstractUserAction, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newScenarioBehaviour_AbstractUserAction,
                UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setScenarioBehaviour_AbstractUserAction(ScenarioBehaviour newScenarioBehaviour_AbstractUserAction) {
        eDynamicSet(UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION,
                UsagemodelPackage.Literals.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION,
                newScenarioBehaviour_AbstractUserAction);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR:
            AbstractUserAction successor = basicGetSuccessor();
            if (successor != null)
                msgs = ((InternalEObject) successor).eInverseRemove(this,
                        UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR, AbstractUserAction.class, msgs);
            return basicSetSuccessor((AbstractUserAction) otherEnd, msgs);
        case UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR:
            AbstractUserAction predecessor = basicGetPredecessor();
            if (predecessor != null)
                msgs = ((InternalEObject) predecessor).eInverseRemove(this,
                        UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR, AbstractUserAction.class, msgs);
            return basicSetPredecessor((AbstractUserAction) otherEnd, msgs);
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetScenarioBehaviour_AbstractUserAction((ScenarioBehaviour) otherEnd, msgs);
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
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR:
            return basicSetSuccessor(null, msgs);
        case UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR:
            return basicSetPredecessor(null, msgs);
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION:
            return basicSetScenarioBehaviour_AbstractUserAction(null, msgs);
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
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION:
            return eInternalContainer().eInverseRemove(this,
                    UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR, ScenarioBehaviour.class, msgs);
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
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR:
            if (resolve)
                return getSuccessor();
            return basicGetSuccessor();
        case UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR:
            if (resolve)
                return getPredecessor();
            return basicGetPredecessor();
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION:
            return getScenarioBehaviour_AbstractUserAction();
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
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR:
            setSuccessor((AbstractUserAction) newValue);
            return;
        case UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR:
            setPredecessor((AbstractUserAction) newValue);
            return;
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION:
            setScenarioBehaviour_AbstractUserAction((ScenarioBehaviour) newValue);
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
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR:
            setSuccessor((AbstractUserAction) null);
            return;
        case UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR:
            setPredecessor((AbstractUserAction) null);
            return;
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION:
            setScenarioBehaviour_AbstractUserAction((ScenarioBehaviour) null);
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
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SUCCESSOR:
            return basicGetSuccessor() != null;
        case UsagemodelPackage.ABSTRACT_USER_ACTION__PREDECESSOR:
            return basicGetPredecessor() != null;
        case UsagemodelPackage.ABSTRACT_USER_ACTION__SCENARIO_BEHAVIOUR_ABSTRACT_USER_ACTION:
            return getScenarioBehaviour_AbstractUserAction() != null;
        }
        return super.eIsSet(featureID);
    }

} //AbstractUserActionImpl
