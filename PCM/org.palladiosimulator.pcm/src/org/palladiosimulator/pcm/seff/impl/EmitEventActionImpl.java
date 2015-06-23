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

import org.palladiosimulator.pcm.parameter.VariableUsage;

import org.palladiosimulator.pcm.repository.EventType;
import org.palladiosimulator.pcm.repository.SourceRole;

import org.palladiosimulator.pcm.seff.CallAction;
import org.palladiosimulator.pcm.seff.EmitEventAction;
import org.palladiosimulator.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Emit Event Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.seff.impl.EmitEventActionImpl#getInputVariableUsages__CallAction <em>Input Variable Usages Call Action</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.seff.impl.EmitEventActionImpl#getEventType__EmitEventAction <em>Event Type Emit Event Action</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.seff.impl.EmitEventActionImpl#getSourceRole__EmitEventAction <em>Source Role Emit Event Action</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EmitEventActionImpl extends AbstractActionImpl implements EmitEventAction {

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
    protected EmitEventActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPackage.Literals.EMIT_EVENT_ACTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<VariableUsage> getInputVariableUsages__CallAction() {
        return (EList<VariableUsage>) eDynamicGet(SeffPackage.EMIT_EVENT_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION,
                SeffPackage.Literals.CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EventType getEventType__EmitEventAction() {
        return (EventType) eDynamicGet(SeffPackage.EMIT_EVENT_ACTION__EVENT_TYPE_EMIT_EVENT_ACTION,
                SeffPackage.Literals.EMIT_EVENT_ACTION__EVENT_TYPE_EMIT_EVENT_ACTION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EventType basicGetEventType__EmitEventAction() {
        return (EventType) eDynamicGet(SeffPackage.EMIT_EVENT_ACTION__EVENT_TYPE_EMIT_EVENT_ACTION,
                SeffPackage.Literals.EMIT_EVENT_ACTION__EVENT_TYPE_EMIT_EVENT_ACTION, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEventType__EmitEventAction(EventType newEventType__EmitEventAction) {
        eDynamicSet(SeffPackage.EMIT_EVENT_ACTION__EVENT_TYPE_EMIT_EVENT_ACTION,
                SeffPackage.Literals.EMIT_EVENT_ACTION__EVENT_TYPE_EMIT_EVENT_ACTION, newEventType__EmitEventAction);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SourceRole getSourceRole__EmitEventAction() {
        return (SourceRole) eDynamicGet(SeffPackage.EMIT_EVENT_ACTION__SOURCE_ROLE_EMIT_EVENT_ACTION,
                SeffPackage.Literals.EMIT_EVENT_ACTION__SOURCE_ROLE_EMIT_EVENT_ACTION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SourceRole basicGetSourceRole__EmitEventAction() {
        return (SourceRole) eDynamicGet(SeffPackage.EMIT_EVENT_ACTION__SOURCE_ROLE_EMIT_EVENT_ACTION,
                SeffPackage.Literals.EMIT_EVENT_ACTION__SOURCE_ROLE_EMIT_EVENT_ACTION, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSourceRole__EmitEventAction(SourceRole newSourceRole__EmitEventAction) {
        eDynamicSet(SeffPackage.EMIT_EVENT_ACTION__SOURCE_ROLE_EMIT_EVENT_ACTION,
                SeffPackage.Literals.EMIT_EVENT_ACTION__SOURCE_ROLE_EMIT_EVENT_ACTION, newSourceRole__EmitEventAction);
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
        case SeffPackage.EMIT_EVENT_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getInputVariableUsages__CallAction())
                    .basicAdd(otherEnd, msgs);
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
        case SeffPackage.EMIT_EVENT_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
            return ((InternalEList<?>) getInputVariableUsages__CallAction()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case SeffPackage.EMIT_EVENT_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
            return getInputVariableUsages__CallAction();
        case SeffPackage.EMIT_EVENT_ACTION__EVENT_TYPE_EMIT_EVENT_ACTION:
            if (resolve)
                return getEventType__EmitEventAction();
            return basicGetEventType__EmitEventAction();
        case SeffPackage.EMIT_EVENT_ACTION__SOURCE_ROLE_EMIT_EVENT_ACTION:
            if (resolve)
                return getSourceRole__EmitEventAction();
            return basicGetSourceRole__EmitEventAction();
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
        case SeffPackage.EMIT_EVENT_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
            getInputVariableUsages__CallAction().clear();
            getInputVariableUsages__CallAction().addAll((Collection<? extends VariableUsage>) newValue);
            return;
        case SeffPackage.EMIT_EVENT_ACTION__EVENT_TYPE_EMIT_EVENT_ACTION:
            setEventType__EmitEventAction((EventType) newValue);
            return;
        case SeffPackage.EMIT_EVENT_ACTION__SOURCE_ROLE_EMIT_EVENT_ACTION:
            setSourceRole__EmitEventAction((SourceRole) newValue);
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
        case SeffPackage.EMIT_EVENT_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
            getInputVariableUsages__CallAction().clear();
            return;
        case SeffPackage.EMIT_EVENT_ACTION__EVENT_TYPE_EMIT_EVENT_ACTION:
            setEventType__EmitEventAction((EventType) null);
            return;
        case SeffPackage.EMIT_EVENT_ACTION__SOURCE_ROLE_EMIT_EVENT_ACTION:
            setSourceRole__EmitEventAction((SourceRole) null);
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
        case SeffPackage.EMIT_EVENT_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
            return !getInputVariableUsages__CallAction().isEmpty();
        case SeffPackage.EMIT_EVENT_ACTION__EVENT_TYPE_EMIT_EVENT_ACTION:
            return basicGetEventType__EmitEventAction() != null;
        case SeffPackage.EMIT_EVENT_ACTION__SOURCE_ROLE_EMIT_EVENT_ACTION:
            return basicGetSourceRole__EmitEventAction() != null;
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
        if (baseClass == CallAction.class) {
            switch (derivedFeatureID) {
            case SeffPackage.EMIT_EVENT_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
                return SeffPackage.CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION;
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
        if (baseClass == CallAction.class) {
            switch (baseFeatureID) {
            case SeffPackage.CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
                return SeffPackage.EMIT_EVENT_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} //EmitEventActionImpl
