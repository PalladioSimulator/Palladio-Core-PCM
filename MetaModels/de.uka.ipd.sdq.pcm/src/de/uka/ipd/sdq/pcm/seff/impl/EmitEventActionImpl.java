/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.EventType;
import de.uka.ipd.sdq.pcm.repository.SourceRole;
import de.uka.ipd.sdq.pcm.seff.CallAction;
import de.uka.ipd.sdq.pcm.seff.EmitEventAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Emit Event Action</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.seff.impl.EmitEventActionImpl#getInputVariableUsages__CallAction
 * <em>Input Variable Usages Call Action</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.seff.impl.EmitEventActionImpl#getEventType__EmitEventAction <em>
 * Event Type Emit Event Action</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.seff.impl.EmitEventActionImpl#getSourceRole__EmitEventAction <em>
 * Source Role Emit Event Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EmitEventActionImpl extends AbstractActionImpl implements EmitEventAction {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getInputVariableUsages__CallAction()
     * <em>Input Variable Usages Call Action</em>}' containment reference list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #getInputVariableUsages__CallAction()
     * @generated
     * @ordered
     */
    protected EList<VariableUsage> inputVariableUsages__CallAction;
    /**
     * The cached value of the '{@link #getEventType__EmitEventAction()
     * <em>Event Type Emit Event Action</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #getEventType__EmitEventAction()
     * @generated
     * @ordered
     */
    protected EventType eventType__EmitEventAction;
    /**
     * The cached value of the '{@link #getSourceRole__EmitEventAction()
     * <em>Source Role Emit Event Action</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #getSourceRole__EmitEventAction()
     * @generated
     * @ordered
     */
    protected SourceRole sourceRole__EmitEventAction;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected EmitEventActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPackage.Literals.EMIT_EVENT_ACTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<VariableUsage> getInputVariableUsages__CallAction() {
        if (this.inputVariableUsages__CallAction == null) {
            this.inputVariableUsages__CallAction = new EObjectContainmentWithInverseEList<VariableUsage>(
                    VariableUsage.class, this, SeffPackage.EMIT_EVENT_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION,
                    ParameterPackage.VARIABLE_USAGE__CALL_ACTION_VARIABLE_USAGE);
        }
        return this.inputVariableUsages__CallAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EventType getEventType__EmitEventAction() {
        if (this.eventType__EmitEventAction != null && this.eventType__EmitEventAction.eIsProxy()) {
            final InternalEObject oldEventType__EmitEventAction = (InternalEObject) this.eventType__EmitEventAction;
            this.eventType__EmitEventAction = (EventType) this.eResolveProxy(oldEventType__EmitEventAction);
            if (this.eventType__EmitEventAction != oldEventType__EmitEventAction) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SeffPackage.EMIT_EVENT_ACTION__EVENT_TYPE_EMIT_EVENT_ACTION, oldEventType__EmitEventAction,
                            this.eventType__EmitEventAction));
                }
            }
        }
        return this.eventType__EmitEventAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public EventType basicGetEventType__EmitEventAction() {
        return this.eventType__EmitEventAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setEventType__EmitEventAction(final EventType newEventType__EmitEventAction) {
        final EventType oldEventType__EmitEventAction = this.eventType__EmitEventAction;
        this.eventType__EmitEventAction = newEventType__EmitEventAction;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.EMIT_EVENT_ACTION__EVENT_TYPE_EMIT_EVENT_ACTION, oldEventType__EmitEventAction,
                    this.eventType__EmitEventAction));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public SourceRole getSourceRole__EmitEventAction() {
        if (this.sourceRole__EmitEventAction != null && this.sourceRole__EmitEventAction.eIsProxy()) {
            final InternalEObject oldSourceRole__EmitEventAction = (InternalEObject) this.sourceRole__EmitEventAction;
            this.sourceRole__EmitEventAction = (SourceRole) this.eResolveProxy(oldSourceRole__EmitEventAction);
            if (this.sourceRole__EmitEventAction != oldSourceRole__EmitEventAction) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SeffPackage.EMIT_EVENT_ACTION__SOURCE_ROLE_EMIT_EVENT_ACTION,
                            oldSourceRole__EmitEventAction, this.sourceRole__EmitEventAction));
                }
            }
        }
        return this.sourceRole__EmitEventAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public SourceRole basicGetSourceRole__EmitEventAction() {
        return this.sourceRole__EmitEventAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSourceRole__EmitEventAction(final SourceRole newSourceRole__EmitEventAction) {
        final SourceRole oldSourceRole__EmitEventAction = this.sourceRole__EmitEventAction;
        this.sourceRole__EmitEventAction = newSourceRole__EmitEventAction;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.EMIT_EVENT_ACTION__SOURCE_ROLE_EMIT_EVENT_ACTION, oldSourceRole__EmitEventAction,
                    this.sourceRole__EmitEventAction));
        }
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
        case SeffPackage.EMIT_EVENT_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getInputVariableUsages__CallAction())
                    .basicAdd(otherEnd, msgs);
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
        case SeffPackage.EMIT_EVENT_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
            return ((InternalEList<?>) this.getInputVariableUsages__CallAction()).basicRemove(otherEnd, msgs);
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
        case SeffPackage.EMIT_EVENT_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
            return this.getInputVariableUsages__CallAction();
        case SeffPackage.EMIT_EVENT_ACTION__EVENT_TYPE_EMIT_EVENT_ACTION:
            if (resolve) {
                return this.getEventType__EmitEventAction();
            }
            return this.basicGetEventType__EmitEventAction();
        case SeffPackage.EMIT_EVENT_ACTION__SOURCE_ROLE_EMIT_EVENT_ACTION:
            if (resolve) {
                return this.getSourceRole__EmitEventAction();
            }
            return this.basicGetSourceRole__EmitEventAction();
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
        case SeffPackage.EMIT_EVENT_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
            this.getInputVariableUsages__CallAction().clear();
            this.getInputVariableUsages__CallAction().addAll((Collection<? extends VariableUsage>) newValue);
            return;
        case SeffPackage.EMIT_EVENT_ACTION__EVENT_TYPE_EMIT_EVENT_ACTION:
            this.setEventType__EmitEventAction((EventType) newValue);
            return;
        case SeffPackage.EMIT_EVENT_ACTION__SOURCE_ROLE_EMIT_EVENT_ACTION:
            this.setSourceRole__EmitEventAction((SourceRole) newValue);
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
        case SeffPackage.EMIT_EVENT_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
            this.getInputVariableUsages__CallAction().clear();
            return;
        case SeffPackage.EMIT_EVENT_ACTION__EVENT_TYPE_EMIT_EVENT_ACTION:
            this.setEventType__EmitEventAction((EventType) null);
            return;
        case SeffPackage.EMIT_EVENT_ACTION__SOURCE_ROLE_EMIT_EVENT_ACTION:
            this.setSourceRole__EmitEventAction((SourceRole) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case SeffPackage.EMIT_EVENT_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
            return this.inputVariableUsages__CallAction != null && !this.inputVariableUsages__CallAction.isEmpty();
        case SeffPackage.EMIT_EVENT_ACTION__EVENT_TYPE_EMIT_EVENT_ACTION:
            return this.eventType__EmitEventAction != null;
        case SeffPackage.EMIT_EVENT_ACTION__SOURCE_ROLE_EMIT_EVENT_ACTION:
            return this.sourceRole__EmitEventAction != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(final int derivedFeatureID, final Class<?> baseClass) {
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(final int baseFeatureID, final Class<?> baseClass) {
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

} // EmitEventActionImpl
