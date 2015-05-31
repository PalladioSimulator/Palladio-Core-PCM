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
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Abstract Branch Transition</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.impl.AbstractBranchTransitionImpl#getBranchAction_AbstractBranchTransition
 * <em>Branch Action Abstract Branch Transition</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.impl.AbstractBranchTransitionImpl#getBranchBehaviour_BranchTransition
 * <em>Branch Behaviour Branch Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractBranchTransitionImpl extends EntityImpl implements AbstractBranchTransition {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getBranchBehaviour_BranchTransition()
     * <em>Branch Behaviour Branch Transition</em>}' containment reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getBranchBehaviour_BranchTransition()
     * @generated
     * @ordered
     */
    protected ResourceDemandingBehaviour branchBehaviour_BranchTransition;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected AbstractBranchTransitionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPackage.Literals.ABSTRACT_BRANCH_TRANSITION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public BranchAction getBranchAction_AbstractBranchTransition() {
        if (this.eContainerFeatureID() != SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_ACTION_ABSTRACT_BRANCH_TRANSITION) {
            return null;
        }
        return (BranchAction) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetBranchAction_AbstractBranchTransition(
            final BranchAction newBranchAction_AbstractBranchTransition, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newBranchAction_AbstractBranchTransition,
                SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_ACTION_ABSTRACT_BRANCH_TRANSITION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setBranchAction_AbstractBranchTransition(final BranchAction newBranchAction_AbstractBranchTransition) {
        if (newBranchAction_AbstractBranchTransition != this.eInternalContainer()
                || (this.eContainerFeatureID() != SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_ACTION_ABSTRACT_BRANCH_TRANSITION && newBranchAction_AbstractBranchTransition != null)) {
            if (EcoreUtil.isAncestor(this, newBranchAction_AbstractBranchTransition)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newBranchAction_AbstractBranchTransition != null) {
                msgs = ((InternalEObject) newBranchAction_AbstractBranchTransition).eInverseAdd(this,
                        SeffPackage.BRANCH_ACTION__BRANCHES_BRANCH, BranchAction.class, msgs);
            }
            msgs = this.basicSetBranchAction_AbstractBranchTransition(newBranchAction_AbstractBranchTransition, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_ACTION_ABSTRACT_BRANCH_TRANSITION,
                    newBranchAction_AbstractBranchTransition, newBranchAction_AbstractBranchTransition));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceDemandingBehaviour getBranchBehaviour_BranchTransition() {
        return this.branchBehaviour_BranchTransition;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetBranchBehaviour_BranchTransition(
            final ResourceDemandingBehaviour newBranchBehaviour_BranchTransition, NotificationChain msgs) {
        final ResourceDemandingBehaviour oldBranchBehaviour_BranchTransition = this.branchBehaviour_BranchTransition;
        this.branchBehaviour_BranchTransition = newBranchBehaviour_BranchTransition;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION,
                    oldBranchBehaviour_BranchTransition, newBranchBehaviour_BranchTransition);
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
    public void setBranchBehaviour_BranchTransition(final ResourceDemandingBehaviour newBranchBehaviour_BranchTransition) {
        if (newBranchBehaviour_BranchTransition != this.branchBehaviour_BranchTransition) {
            NotificationChain msgs = null;
            if (this.branchBehaviour_BranchTransition != null) {
                msgs = ((InternalEObject) this.branchBehaviour_BranchTransition)
                        .eInverseRemove(
                                this,
                                SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR,
                                ResourceDemandingBehaviour.class, msgs);
            }
            if (newBranchBehaviour_BranchTransition != null) {
                msgs = ((InternalEObject) newBranchBehaviour_BranchTransition)
                        .eInverseAdd(
                                this,
                                SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR,
                                ResourceDemandingBehaviour.class, msgs);
            }
            msgs = this.basicSetBranchBehaviour_BranchTransition(newBranchBehaviour_BranchTransition, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION,
                    newBranchBehaviour_BranchTransition, newBranchBehaviour_BranchTransition));
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
        case SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_ACTION_ABSTRACT_BRANCH_TRANSITION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetBranchAction_AbstractBranchTransition((BranchAction) otherEnd, msgs);
        case SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION:
            if (this.branchBehaviour_BranchTransition != null) {
                msgs = ((InternalEObject) this.branchBehaviour_BranchTransition).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION, null,
                        msgs);
            }
            return this.basicSetBranchBehaviour_BranchTransition((ResourceDemandingBehaviour) otherEnd, msgs);
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
        case SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_ACTION_ABSTRACT_BRANCH_TRANSITION:
            return this.basicSetBranchAction_AbstractBranchTransition(null, msgs);
        case SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION:
            return this.basicSetBranchBehaviour_BranchTransition(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(final NotificationChain msgs) {
        switch (this.eContainerFeatureID()) {
        case SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_ACTION_ABSTRACT_BRANCH_TRANSITION:
            return this.eInternalContainer().eInverseRemove(this, SeffPackage.BRANCH_ACTION__BRANCHES_BRANCH,
                    BranchAction.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_ACTION_ABSTRACT_BRANCH_TRANSITION:
            return this.getBranchAction_AbstractBranchTransition();
        case SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION:
            return this.getBranchBehaviour_BranchTransition();
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
        case SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_ACTION_ABSTRACT_BRANCH_TRANSITION:
            this.setBranchAction_AbstractBranchTransition((BranchAction) newValue);
            return;
        case SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION:
            this.setBranchBehaviour_BranchTransition((ResourceDemandingBehaviour) newValue);
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
        case SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_ACTION_ABSTRACT_BRANCH_TRANSITION:
            this.setBranchAction_AbstractBranchTransition((BranchAction) null);
            return;
        case SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION:
            this.setBranchBehaviour_BranchTransition((ResourceDemandingBehaviour) null);
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
        case SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_ACTION_ABSTRACT_BRANCH_TRANSITION:
            return this.getBranchAction_AbstractBranchTransition() != null;
        case SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION:
            return this.branchBehaviour_BranchTransition != null;
        }
        return super.eIsSet(featureID);
    }

} // AbstractBranchTransitionImpl
