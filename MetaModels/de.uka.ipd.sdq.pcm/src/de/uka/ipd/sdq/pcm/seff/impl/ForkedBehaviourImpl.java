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

import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.SynchronisationPoint;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Forked Behaviour</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ForkedBehaviourImpl#getSynchronisationPoint_ForkedBehaviour <em>Synchronisation Point Forked Behaviour</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ForkedBehaviourImpl#getForkAction_ForkedBehaivour <em>Fork Action Forked Behaivour</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForkedBehaviourImpl extends ResourceDemandingBehaviourImpl implements ForkedBehaviour {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected ForkedBehaviourImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPackage.Literals.FORKED_BEHAVIOUR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public SynchronisationPoint getSynchronisationPoint_ForkedBehaviour() {
        if (eContainerFeatureID() != SeffPackage.FORKED_BEHAVIOUR__SYNCHRONISATION_POINT_FORKED_BEHAVIOUR) return null;
        return (SynchronisationPoint)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSynchronisationPoint_ForkedBehaviour(
            SynchronisationPoint newSynchronisationPoint_ForkedBehaviour, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newSynchronisationPoint_ForkedBehaviour, SeffPackage.FORKED_BEHAVIOUR__SYNCHRONISATION_POINT_FORKED_BEHAVIOUR, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setSynchronisationPoint_ForkedBehaviour(SynchronisationPoint newSynchronisationPoint_ForkedBehaviour) {
        if (newSynchronisationPoint_ForkedBehaviour != eInternalContainer() || (eContainerFeatureID() != SeffPackage.FORKED_BEHAVIOUR__SYNCHRONISATION_POINT_FORKED_BEHAVIOUR && newSynchronisationPoint_ForkedBehaviour != null)) {
            if (EcoreUtil.isAncestor(this, (EObject)newSynchronisationPoint_ForkedBehaviour))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newSynchronisationPoint_ForkedBehaviour != null)
                msgs = ((InternalEObject)newSynchronisationPoint_ForkedBehaviour).eInverseAdd(this, SeffPackage.SYNCHRONISATION_POINT__SYNCHRONOUS_FORKED_BEHAVIOURS_SYNCHRONISATION_POINT, SynchronisationPoint.class, msgs);
            msgs = basicSetSynchronisationPoint_ForkedBehaviour(newSynchronisationPoint_ForkedBehaviour, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.FORKED_BEHAVIOUR__SYNCHRONISATION_POINT_FORKED_BEHAVIOUR, newSynchronisationPoint_ForkedBehaviour, newSynchronisationPoint_ForkedBehaviour));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public ForkAction getForkAction_ForkedBehaivour() {
        if (eContainerFeatureID() != SeffPackage.FORKED_BEHAVIOUR__FORK_ACTION_FORKED_BEHAIVOUR) return null;
        return (ForkAction)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetForkAction_ForkedBehaivour(ForkAction newForkAction_ForkedBehaivour,
            NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newForkAction_ForkedBehaivour, SeffPackage.FORKED_BEHAVIOUR__FORK_ACTION_FORKED_BEHAIVOUR, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setForkAction_ForkedBehaivour(ForkAction newForkAction_ForkedBehaivour) {
        if (newForkAction_ForkedBehaivour != eInternalContainer() || (eContainerFeatureID() != SeffPackage.FORKED_BEHAVIOUR__FORK_ACTION_FORKED_BEHAIVOUR && newForkAction_ForkedBehaivour != null)) {
            if (EcoreUtil.isAncestor(this, (EObject)newForkAction_ForkedBehaivour))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newForkAction_ForkedBehaivour != null)
                msgs = ((InternalEObject)newForkAction_ForkedBehaivour).eInverseAdd(this, SeffPackage.FORK_ACTION__ASYNCHRONOUS_FORKED_BEHAVIOURS_FORK_ACTION, ForkAction.class, msgs);
            msgs = basicSetForkAction_ForkedBehaivour(newForkAction_ForkedBehaivour, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.FORKED_BEHAVIOUR__FORK_ACTION_FORKED_BEHAIVOUR, newForkAction_ForkedBehaivour, newForkAction_ForkedBehaivour));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SeffPackage.FORKED_BEHAVIOUR__SYNCHRONISATION_POINT_FORKED_BEHAVIOUR:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetSynchronisationPoint_ForkedBehaviour((SynchronisationPoint)otherEnd, msgs);
            case SeffPackage.FORKED_BEHAVIOUR__FORK_ACTION_FORKED_BEHAIVOUR:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetForkAction_ForkedBehaivour((ForkAction)otherEnd, msgs);
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
            case SeffPackage.FORKED_BEHAVIOUR__SYNCHRONISATION_POINT_FORKED_BEHAVIOUR:
                return basicSetSynchronisationPoint_ForkedBehaviour(null, msgs);
            case SeffPackage.FORKED_BEHAVIOUR__FORK_ACTION_FORKED_BEHAIVOUR:
                return basicSetForkAction_ForkedBehaivour(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case SeffPackage.FORKED_BEHAVIOUR__SYNCHRONISATION_POINT_FORKED_BEHAVIOUR:
                return eInternalContainer().eInverseRemove(this, SeffPackage.SYNCHRONISATION_POINT__SYNCHRONOUS_FORKED_BEHAVIOURS_SYNCHRONISATION_POINT, SynchronisationPoint.class, msgs);
            case SeffPackage.FORKED_BEHAVIOUR__FORK_ACTION_FORKED_BEHAIVOUR:
                return eInternalContainer().eInverseRemove(this, SeffPackage.FORK_ACTION__ASYNCHRONOUS_FORKED_BEHAVIOURS_FORK_ACTION, ForkAction.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SeffPackage.FORKED_BEHAVIOUR__SYNCHRONISATION_POINT_FORKED_BEHAVIOUR:
                return getSynchronisationPoint_ForkedBehaviour();
            case SeffPackage.FORKED_BEHAVIOUR__FORK_ACTION_FORKED_BEHAIVOUR:
                return getForkAction_ForkedBehaivour();
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
            case SeffPackage.FORKED_BEHAVIOUR__SYNCHRONISATION_POINT_FORKED_BEHAVIOUR:
                setSynchronisationPoint_ForkedBehaviour((SynchronisationPoint)newValue);
                return;
            case SeffPackage.FORKED_BEHAVIOUR__FORK_ACTION_FORKED_BEHAIVOUR:
                setForkAction_ForkedBehaivour((ForkAction)newValue);
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
            case SeffPackage.FORKED_BEHAVIOUR__SYNCHRONISATION_POINT_FORKED_BEHAVIOUR:
                setSynchronisationPoint_ForkedBehaviour((SynchronisationPoint)null);
                return;
            case SeffPackage.FORKED_BEHAVIOUR__FORK_ACTION_FORKED_BEHAIVOUR:
                setForkAction_ForkedBehaivour((ForkAction)null);
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
            case SeffPackage.FORKED_BEHAVIOUR__SYNCHRONISATION_POINT_FORKED_BEHAVIOUR:
                return getSynchronisationPoint_ForkedBehaviour() != null;
            case SeffPackage.FORKED_BEHAVIOUR__FORK_ACTION_FORKED_BEHAIVOUR:
                return getForkAction_ForkedBehaivour() != null;
        }
        return super.eIsSet(featureID);
    }

} // ForkedBehaviourImpl
