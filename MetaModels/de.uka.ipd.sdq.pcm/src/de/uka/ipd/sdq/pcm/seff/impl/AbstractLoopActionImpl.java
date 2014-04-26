/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Abstract Loop Action</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.AbstractLoopActionImpl#getBodyBehaviour_Loop <em>Body Behaviour Loop</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractLoopActionImpl extends AbstractInternalControlFlowActionImpl implements
        AbstractLoopAction {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getBodyBehaviour_Loop() <em>Body Behaviour Loop</em>}' containment reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getBodyBehaviour_Loop()
     * @generated
     * @ordered
     */
    protected ResourceDemandingBehaviour bodyBehaviour_Loop;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected AbstractLoopActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPackage.Literals.ABSTRACT_LOOP_ACTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public ResourceDemandingBehaviour getBodyBehaviour_Loop() {
        return bodyBehaviour_Loop;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetBodyBehaviour_Loop(ResourceDemandingBehaviour newBodyBehaviour_Loop,
            NotificationChain msgs) {
        ResourceDemandingBehaviour oldBodyBehaviour_Loop = bodyBehaviour_Loop;
        bodyBehaviour_Loop = newBodyBehaviour_Loop;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP, oldBodyBehaviour_Loop, newBodyBehaviour_Loop);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setBodyBehaviour_Loop(ResourceDemandingBehaviour newBodyBehaviour_Loop) {
        if (newBodyBehaviour_Loop != bodyBehaviour_Loop) {
            NotificationChain msgs = null;
            if (bodyBehaviour_Loop != null)
                msgs = ((InternalEObject)bodyBehaviour_Loop).eInverseRemove(this, SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR, ResourceDemandingBehaviour.class, msgs);
            if (newBodyBehaviour_Loop != null)
                msgs = ((InternalEObject)newBodyBehaviour_Loop).eInverseAdd(this, SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR, ResourceDemandingBehaviour.class, msgs);
            msgs = basicSetBodyBehaviour_Loop(newBodyBehaviour_Loop, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP, newBodyBehaviour_Loop, newBodyBehaviour_Loop));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP:
                if (bodyBehaviour_Loop != null)
                    msgs = ((InternalEObject)bodyBehaviour_Loop).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP, null, msgs);
                return basicSetBodyBehaviour_Loop((ResourceDemandingBehaviour)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP:
                return basicSetBodyBehaviour_Loop(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP:
                return getBodyBehaviour_Loop();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP:
                setBodyBehaviour_Loop((ResourceDemandingBehaviour)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP:
                setBodyBehaviour_Loop((ResourceDemandingBehaviour)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP:
                return bodyBehaviour_Loop != null;
        }
        return super.eIsSet(featureID);
    }

} // AbstractLoopActionImpl
