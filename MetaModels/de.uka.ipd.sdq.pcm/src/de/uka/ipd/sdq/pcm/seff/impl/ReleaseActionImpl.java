/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Release Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ReleaseActionImpl#getPassiveResource_ReleaseAction <em>
 * Passive Resource Release Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReleaseActionImpl extends AbstractInternalControlFlowActionImpl implements ReleaseAction {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getPassiveResource_ReleaseAction()
     * <em>Passive Resource Release Action</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getPassiveResource_ReleaseAction()
     * @generated
     * @ordered
     */
    protected PassiveResource passiveResource_ReleaseAction;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ReleaseActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPackage.Literals.RELEASE_ACTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PassiveResource getPassiveResource_ReleaseAction() {
        if (this.passiveResource_ReleaseAction != null && ((EObject) this.passiveResource_ReleaseAction).eIsProxy()) {
            final InternalEObject oldPassiveResource_ReleaseAction = (InternalEObject) this.passiveResource_ReleaseAction;
            this.passiveResource_ReleaseAction = (PassiveResource) this.eResolveProxy(oldPassiveResource_ReleaseAction);
            if (this.passiveResource_ReleaseAction != oldPassiveResource_ReleaseAction) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SeffPackage.RELEASE_ACTION__PASSIVE_RESOURCE_RELEASE_ACTION,
                            oldPassiveResource_ReleaseAction, this.passiveResource_ReleaseAction));
                }
            }
        }
        return this.passiveResource_ReleaseAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public PassiveResource basicGetPassiveResource_ReleaseAction() {
        return this.passiveResource_ReleaseAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPassiveResource_ReleaseAction(final PassiveResource newPassiveResource_ReleaseAction) {
        final PassiveResource oldPassiveResource_ReleaseAction = this.passiveResource_ReleaseAction;
        this.passiveResource_ReleaseAction = newPassiveResource_ReleaseAction;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.RELEASE_ACTION__PASSIVE_RESOURCE_RELEASE_ACTION, oldPassiveResource_ReleaseAction,
                    this.passiveResource_ReleaseAction));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case SeffPackage.RELEASE_ACTION__PASSIVE_RESOURCE_RELEASE_ACTION:
            if (resolve) {
                return this.getPassiveResource_ReleaseAction();
            }
            return this.basicGetPassiveResource_ReleaseAction();
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
        case SeffPackage.RELEASE_ACTION__PASSIVE_RESOURCE_RELEASE_ACTION:
            this.setPassiveResource_ReleaseAction((PassiveResource) newValue);
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
        case SeffPackage.RELEASE_ACTION__PASSIVE_RESOURCE_RELEASE_ACTION:
            this.setPassiveResource_ReleaseAction((PassiveResource) null);
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
        case SeffPackage.RELEASE_ACTION__PASSIVE_RESOURCE_RELEASE_ACTION:
            return this.passiveResource_ReleaseAction != null;
        }
        return super.eIsSet(featureID);
    }

} // ReleaseActionImpl
