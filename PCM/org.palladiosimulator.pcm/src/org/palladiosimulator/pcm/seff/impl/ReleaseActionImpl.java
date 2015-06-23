/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.seff.impl;

import org.eclipse.emf.ecore.EClass;

import org.palladiosimulator.pcm.repository.PassiveResource;

import org.palladiosimulator.pcm.seff.ReleaseAction;
import org.palladiosimulator.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Release Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.seff.impl.ReleaseActionImpl#getPassiveResource_ReleaseAction <em>Passive Resource Release Action</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReleaseActionImpl extends AbstractInternalControlFlowActionImpl implements ReleaseAction {

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
    protected ReleaseActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPackage.Literals.RELEASE_ACTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PassiveResource getPassiveResource_ReleaseAction() {
        return (PassiveResource) eDynamicGet(SeffPackage.RELEASE_ACTION__PASSIVE_RESOURCE_RELEASE_ACTION,
                SeffPackage.Literals.RELEASE_ACTION__PASSIVE_RESOURCE_RELEASE_ACTION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PassiveResource basicGetPassiveResource_ReleaseAction() {
        return (PassiveResource) eDynamicGet(SeffPackage.RELEASE_ACTION__PASSIVE_RESOURCE_RELEASE_ACTION,
                SeffPackage.Literals.RELEASE_ACTION__PASSIVE_RESOURCE_RELEASE_ACTION, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPassiveResource_ReleaseAction(PassiveResource newPassiveResource_ReleaseAction) {
        eDynamicSet(SeffPackage.RELEASE_ACTION__PASSIVE_RESOURCE_RELEASE_ACTION,
                SeffPackage.Literals.RELEASE_ACTION__PASSIVE_RESOURCE_RELEASE_ACTION, newPassiveResource_ReleaseAction);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case SeffPackage.RELEASE_ACTION__PASSIVE_RESOURCE_RELEASE_ACTION:
            return basicGetPassiveResource_ReleaseAction() != null;
        }
        return super.eIsSet(featureID);
    }

} //ReleaseActionImpl
