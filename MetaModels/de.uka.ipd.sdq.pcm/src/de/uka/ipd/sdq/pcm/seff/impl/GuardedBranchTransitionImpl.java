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

import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Guarded Branch Transition</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.impl.GuardedBranchTransitionImpl#getBranchCondition_GuardedBranchTransition
 * <em>Branch Condition Guarded Branch Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GuardedBranchTransitionImpl extends AbstractBranchTransitionImpl implements GuardedBranchTransition {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getBranchCondition_GuardedBranchTransition()
     * <em>Branch Condition Guarded Branch Transition</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getBranchCondition_GuardedBranchTransition()
     * @generated
     * @ordered
     */
    protected PCMRandomVariable branchCondition_GuardedBranchTransition;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected GuardedBranchTransitionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPackage.Literals.GUARDED_BRANCH_TRANSITION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PCMRandomVariable getBranchCondition_GuardedBranchTransition() {
        return this.branchCondition_GuardedBranchTransition;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetBranchCondition_GuardedBranchTransition(
            final PCMRandomVariable newBranchCondition_GuardedBranchTransition, NotificationChain msgs) {
        final PCMRandomVariable oldBranchCondition_GuardedBranchTransition = this.branchCondition_GuardedBranchTransition;
        this.branchCondition_GuardedBranchTransition = newBranchCondition_GuardedBranchTransition;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    SeffPackage.GUARDED_BRANCH_TRANSITION__BRANCH_CONDITION_GUARDED_BRANCH_TRANSITION,
                    oldBranchCondition_GuardedBranchTransition, newBranchCondition_GuardedBranchTransition);
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
    public void setBranchCondition_GuardedBranchTransition(
            final PCMRandomVariable newBranchCondition_GuardedBranchTransition) {
        if (newBranchCondition_GuardedBranchTransition != this.branchCondition_GuardedBranchTransition) {
            NotificationChain msgs = null;
            if (this.branchCondition_GuardedBranchTransition != null) {
                msgs = ((InternalEObject) this.branchCondition_GuardedBranchTransition).eInverseRemove(this,
                        CorePackage.PCM_RANDOM_VARIABLE__GUARDED_BRANCH_TRANSITION_PCM_RANDOM_VARIABLE,
                        PCMRandomVariable.class, msgs);
            }
            if (newBranchCondition_GuardedBranchTransition != null) {
                msgs = ((InternalEObject) newBranchCondition_GuardedBranchTransition).eInverseAdd(this,
                        CorePackage.PCM_RANDOM_VARIABLE__GUARDED_BRANCH_TRANSITION_PCM_RANDOM_VARIABLE,
                        PCMRandomVariable.class, msgs);
            }
            msgs = this.basicSetBranchCondition_GuardedBranchTransition(newBranchCondition_GuardedBranchTransition,
                    msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.GUARDED_BRANCH_TRANSITION__BRANCH_CONDITION_GUARDED_BRANCH_TRANSITION,
                    newBranchCondition_GuardedBranchTransition, newBranchCondition_GuardedBranchTransition));
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
        case SeffPackage.GUARDED_BRANCH_TRANSITION__BRANCH_CONDITION_GUARDED_BRANCH_TRANSITION:
            if (this.branchCondition_GuardedBranchTransition != null) {
                msgs = ((InternalEObject) this.branchCondition_GuardedBranchTransition).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                        - SeffPackage.GUARDED_BRANCH_TRANSITION__BRANCH_CONDITION_GUARDED_BRANCH_TRANSITION,
                        null, msgs);
            }
            return this.basicSetBranchCondition_GuardedBranchTransition((PCMRandomVariable) otherEnd, msgs);
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
        case SeffPackage.GUARDED_BRANCH_TRANSITION__BRANCH_CONDITION_GUARDED_BRANCH_TRANSITION:
            return this.basicSetBranchCondition_GuardedBranchTransition(null, msgs);
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
        case SeffPackage.GUARDED_BRANCH_TRANSITION__BRANCH_CONDITION_GUARDED_BRANCH_TRANSITION:
            return this.getBranchCondition_GuardedBranchTransition();
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
        case SeffPackage.GUARDED_BRANCH_TRANSITION__BRANCH_CONDITION_GUARDED_BRANCH_TRANSITION:
            this.setBranchCondition_GuardedBranchTransition((PCMRandomVariable) newValue);
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
        case SeffPackage.GUARDED_BRANCH_TRANSITION__BRANCH_CONDITION_GUARDED_BRANCH_TRANSITION:
            this.setBranchCondition_GuardedBranchTransition((PCMRandomVariable) null);
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
        case SeffPackage.GUARDED_BRANCH_TRANSITION__BRANCH_CONDITION_GUARDED_BRANCH_TRANSITION:
            return this.branchCondition_GuardedBranchTransition != null;
        }
        return super.eIsSet(featureID);
    }

} // GuardedBranchTransitionImpl
