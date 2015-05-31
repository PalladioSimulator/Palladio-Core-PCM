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
 * <li>{@link de.uka.ipd.sdq.pcm.seff.impl.AbstractLoopActionImpl#getBodyBehaviour_Loop <em>Body
 * Behaviour Loop</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractLoopActionImpl extends AbstractInternalControlFlowActionImpl implements
AbstractLoopAction {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getBodyBehaviour_Loop() <em>Body Behaviour Loop</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getBodyBehaviour_Loop()
     * @generated
     * @ordered
     */
    protected ResourceDemandingBehaviour bodyBehaviour_Loop;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected AbstractLoopActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPackage.Literals.ABSTRACT_LOOP_ACTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceDemandingBehaviour getBodyBehaviour_Loop() {
        return this.bodyBehaviour_Loop;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetBodyBehaviour_Loop(final ResourceDemandingBehaviour newBodyBehaviour_Loop,
            NotificationChain msgs) {
        final ResourceDemandingBehaviour oldBodyBehaviour_Loop = this.bodyBehaviour_Loop;
        this.bodyBehaviour_Loop = newBodyBehaviour_Loop;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP, oldBodyBehaviour_Loop, newBodyBehaviour_Loop);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setBodyBehaviour_Loop(final ResourceDemandingBehaviour newBodyBehaviour_Loop) {
        if (newBodyBehaviour_Loop != this.bodyBehaviour_Loop) {
            NotificationChain msgs = null;
            if (this.bodyBehaviour_Loop != null) {
                msgs = ((InternalEObject) this.bodyBehaviour_Loop).eInverseRemove(this,
                        SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR,
                        ResourceDemandingBehaviour.class, msgs);
            }
            if (newBodyBehaviour_Loop != null) {
                msgs = ((InternalEObject) newBodyBehaviour_Loop).eInverseAdd(this,
                        SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR,
                        ResourceDemandingBehaviour.class, msgs);
            }
            msgs = this.basicSetBodyBehaviour_Loop(newBodyBehaviour_Loop, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP, newBodyBehaviour_Loop, newBodyBehaviour_Loop));
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
        case SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP:
            if (this.bodyBehaviour_Loop != null) {
                msgs = ((InternalEObject) this.bodyBehaviour_Loop).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP, null, msgs);
            }
            return this.basicSetBodyBehaviour_Loop((ResourceDemandingBehaviour) otherEnd, msgs);
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
        case SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP:
            return this.basicSetBodyBehaviour_Loop(null, msgs);
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
        case SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP:
            return this.getBodyBehaviour_Loop();
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
        case SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP:
            this.setBodyBehaviour_Loop((ResourceDemandingBehaviour) newValue);
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
        case SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP:
            this.setBodyBehaviour_Loop((ResourceDemandingBehaviour) null);
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
        case SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP:
            return this.bodyBehaviour_Loop != null;
        }
        return super.eIsSet(featureID);
    }

} // AbstractLoopActionImpl
