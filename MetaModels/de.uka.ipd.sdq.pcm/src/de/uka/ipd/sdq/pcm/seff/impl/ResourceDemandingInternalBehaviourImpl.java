/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.seff.ResourceDemandingInternalBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Resource Demanding Internal Behaviour</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.impl.ResourceDemandingInternalBehaviourImpl#getResourceDemandingSEFF_ResourceDemandingInternalBehaviour
 * <em>Resource Demanding SEFF Resource Demanding Internal Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceDemandingInternalBehaviourImpl extends ResourceDemandingBehaviourImpl implements
        ResourceDemandingInternalBehaviour {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ResourceDemandingInternalBehaviourImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPackage.Literals.RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceDemandingSEFF getResourceDemandingSEFF_ResourceDemandingInternalBehaviour() {
        if (eContainerFeatureID() != SeffPackage.RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR__RESOURCE_DEMANDING_SEFF_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR)
            return null;
        return (ResourceDemandingSEFF) eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetResourceDemandingSEFF_ResourceDemandingInternalBehaviour(
            ResourceDemandingSEFF newResourceDemandingSEFF_ResourceDemandingInternalBehaviour, NotificationChain msgs) {
        msgs = eBasicSetContainer(
                (InternalEObject) newResourceDemandingSEFF_ResourceDemandingInternalBehaviour,
                SeffPackage.RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR__RESOURCE_DEMANDING_SEFF_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR,
                msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setResourceDemandingSEFF_ResourceDemandingInternalBehaviour(
            ResourceDemandingSEFF newResourceDemandingSEFF_ResourceDemandingInternalBehaviour) {
        if (newResourceDemandingSEFF_ResourceDemandingInternalBehaviour != eInternalContainer()
                || (eContainerFeatureID() != SeffPackage.RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR__RESOURCE_DEMANDING_SEFF_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR && newResourceDemandingSEFF_ResourceDemandingInternalBehaviour != null)) {
            if (EcoreUtil.isAncestor(this, (EObject) newResourceDemandingSEFF_ResourceDemandingInternalBehaviour))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newResourceDemandingSEFF_ResourceDemandingInternalBehaviour != null)
                msgs = ((InternalEObject) newResourceDemandingSEFF_ResourceDemandingInternalBehaviour).eInverseAdd(
                        this, SeffPackage.RESOURCE_DEMANDING_SEFF__RESOURCE_DEMANDING_INTERNAL_BEHAVIOURS,
                        ResourceDemandingSEFF.class, msgs);
            msgs = basicSetResourceDemandingSEFF_ResourceDemandingInternalBehaviour(
                    newResourceDemandingSEFF_ResourceDemandingInternalBehaviour, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    SeffPackage.RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR__RESOURCE_DEMANDING_SEFF_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR,
                    newResourceDemandingSEFF_ResourceDemandingInternalBehaviour,
                    newResourceDemandingSEFF_ResourceDemandingInternalBehaviour));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case SeffPackage.RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR__RESOURCE_DEMANDING_SEFF_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetResourceDemandingSEFF_ResourceDemandingInternalBehaviour((ResourceDemandingSEFF) otherEnd,
                    msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case SeffPackage.RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR__RESOURCE_DEMANDING_SEFF_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR:
            return basicSetResourceDemandingSEFF_ResourceDemandingInternalBehaviour(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
        case SeffPackage.RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR__RESOURCE_DEMANDING_SEFF_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR:
            return eInternalContainer().eInverseRemove(this,
                    SeffPackage.RESOURCE_DEMANDING_SEFF__RESOURCE_DEMANDING_INTERNAL_BEHAVIOURS,
                    ResourceDemandingSEFF.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case SeffPackage.RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR__RESOURCE_DEMANDING_SEFF_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR:
            return getResourceDemandingSEFF_ResourceDemandingInternalBehaviour();
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
        case SeffPackage.RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR__RESOURCE_DEMANDING_SEFF_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR:
            setResourceDemandingSEFF_ResourceDemandingInternalBehaviour((ResourceDemandingSEFF) newValue);
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
        case SeffPackage.RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR__RESOURCE_DEMANDING_SEFF_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR:
            setResourceDemandingSEFF_ResourceDemandingInternalBehaviour((ResourceDemandingSEFF) null);
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
        case SeffPackage.RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR__RESOURCE_DEMANDING_SEFF_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR:
            return getResourceDemandingSEFF_ResourceDemandingInternalBehaviour() != null;
        }
        return super.eIsSet(featureID);
    }

} // ResourceDemandingInternalBehaviourImpl
