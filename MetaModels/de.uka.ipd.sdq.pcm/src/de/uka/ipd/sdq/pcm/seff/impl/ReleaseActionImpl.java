/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Release Action</b></em>'.
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
    public PassiveResource getPassiveResource_ReleaseAction() {
        if (passiveResource_ReleaseAction != null && passiveResource_ReleaseAction.eIsProxy()) {
            InternalEObject oldPassiveResource_ReleaseAction = (InternalEObject) passiveResource_ReleaseAction;
            passiveResource_ReleaseAction = (PassiveResource) eResolveProxy(oldPassiveResource_ReleaseAction);
            if (passiveResource_ReleaseAction != oldPassiveResource_ReleaseAction) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SeffPackage.RELEASE_ACTION__PASSIVE_RESOURCE_RELEASE_ACTION,
                            oldPassiveResource_ReleaseAction, passiveResource_ReleaseAction));
            }
        }
        return passiveResource_ReleaseAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PassiveResource basicGetPassiveResource_ReleaseAction() {
        return passiveResource_ReleaseAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setPassiveResource_ReleaseAction(PassiveResource newPassiveResource_ReleaseAction) {
        PassiveResource oldPassiveResource_ReleaseAction = passiveResource_ReleaseAction;
        passiveResource_ReleaseAction = newPassiveResource_ReleaseAction;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.RELEASE_ACTION__PASSIVE_RESOURCE_RELEASE_ACTION, oldPassiveResource_ReleaseAction,
                    passiveResource_ReleaseAction));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case SeffPackage.RELEASE_ACTION__PASSIVE_RESOURCE_RELEASE_ACTION:
            if (resolve)
                return getPassiveResource_ReleaseAction();
            return basicGetPassiveResource_ReleaseAction();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case SeffPackage.RELEASE_ACTION__PASSIVE_RESOURCE_RELEASE_ACTION:
            setPassiveResource_ReleaseAction((PassiveResource) newValue);
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
    public void eUnset(int featureID) {
        switch (featureID) {
        case SeffPackage.RELEASE_ACTION__PASSIVE_RESOURCE_RELEASE_ACTION:
            setPassiveResource_ReleaseAction((PassiveResource) null);
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
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case SeffPackage.RELEASE_ACTION__PASSIVE_RESOURCE_RELEASE_ACTION:
            return passiveResource_ReleaseAction != null;
        }
        return super.eIsSet(featureID);
    }

} // ReleaseActionImpl
