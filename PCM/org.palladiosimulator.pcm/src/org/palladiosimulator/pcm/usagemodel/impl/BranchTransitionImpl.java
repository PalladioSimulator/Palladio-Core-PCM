/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.usagemodel.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.palladiosimulator.pcm.usagemodel.Branch;
import org.palladiosimulator.pcm.usagemodel.BranchTransition;
import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour;
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Branch Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.usagemodel.impl.BranchTransitionImpl#getBranchProbability <em>Branch Probability</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.usagemodel.impl.BranchTransitionImpl#getBranch_BranchTransition <em>Branch Branch Transition</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.usagemodel.impl.BranchTransitionImpl#getBranchedBehaviour_BranchTransition <em>Branched Behaviour Branch Transition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BranchTransitionImpl extends CDOObjectImpl implements BranchTransition {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The default value of the '{@link #getBranchProbability() <em>Branch Probability</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBranchProbability()
     * @generated
     * @ordered
     */
    protected static final double BRANCH_PROBABILITY_EDEFAULT = 0.0;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BranchTransitionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsagemodelPackage.Literals.BRANCH_TRANSITION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected int eStaticFeatureCount() {
        return 0;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getBranchProbability() {
        return (Double) eDynamicGet(UsagemodelPackage.BRANCH_TRANSITION__BRANCH_PROBABILITY,
                UsagemodelPackage.Literals.BRANCH_TRANSITION__BRANCH_PROBABILITY, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBranchProbability(double newBranchProbability) {
        eDynamicSet(UsagemodelPackage.BRANCH_TRANSITION__BRANCH_PROBABILITY,
                UsagemodelPackage.Literals.BRANCH_TRANSITION__BRANCH_PROBABILITY, newBranchProbability);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Branch getBranch_BranchTransition() {
        return (Branch) eDynamicGet(UsagemodelPackage.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION,
                UsagemodelPackage.Literals.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetBranch_BranchTransition(Branch newBranch_BranchTransition,
            NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newBranch_BranchTransition,
                UsagemodelPackage.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBranch_BranchTransition(Branch newBranch_BranchTransition) {
        eDynamicSet(UsagemodelPackage.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION,
                UsagemodelPackage.Literals.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION, newBranch_BranchTransition);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ScenarioBehaviour getBranchedBehaviour_BranchTransition() {
        return (ScenarioBehaviour) eDynamicGet(
                UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION,
                UsagemodelPackage.Literals.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetBranchedBehaviour_BranchTransition(
            ScenarioBehaviour newBranchedBehaviour_BranchTransition, NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject) newBranchedBehaviour_BranchTransition,
                UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBranchedBehaviour_BranchTransition(ScenarioBehaviour newBranchedBehaviour_BranchTransition) {
        eDynamicSet(UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION,
                UsagemodelPackage.Literals.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION,
                newBranchedBehaviour_BranchTransition);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetBranch_BranchTransition((Branch) otherEnd, msgs);
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION:
            ScenarioBehaviour branchedBehaviour_BranchTransition = getBranchedBehaviour_BranchTransition();
            if (branchedBehaviour_BranchTransition != null)
                msgs = ((InternalEObject) branchedBehaviour_BranchTransition).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION,
                        null, msgs);
            return basicSetBranchedBehaviour_BranchTransition((ScenarioBehaviour) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION:
            return basicSetBranch_BranchTransition(null, msgs);
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION:
            return basicSetBranchedBehaviour_BranchTransition(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION:
            return eInternalContainer().eInverseRemove(this, UsagemodelPackage.BRANCH__BRANCH_TRANSITIONS_BRANCH,
                    Branch.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCH_PROBABILITY:
            return getBranchProbability();
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION:
            return getBranch_BranchTransition();
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION:
            return getBranchedBehaviour_BranchTransition();
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
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCH_PROBABILITY:
            setBranchProbability((Double) newValue);
            return;
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION:
            setBranch_BranchTransition((Branch) newValue);
            return;
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION:
            setBranchedBehaviour_BranchTransition((ScenarioBehaviour) newValue);
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
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCH_PROBABILITY:
            setBranchProbability(BRANCH_PROBABILITY_EDEFAULT);
            return;
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION:
            setBranch_BranchTransition((Branch) null);
            return;
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION:
            setBranchedBehaviour_BranchTransition((ScenarioBehaviour) null);
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
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCH_PROBABILITY:
            return getBranchProbability() != BRANCH_PROBABILITY_EDEFAULT;
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION:
            return getBranch_BranchTransition() != null;
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION:
            return getBranchedBehaviour_BranchTransition() != null;
        }
        return super.eIsSet(featureID);
    }

} //BranchTransitionImpl
