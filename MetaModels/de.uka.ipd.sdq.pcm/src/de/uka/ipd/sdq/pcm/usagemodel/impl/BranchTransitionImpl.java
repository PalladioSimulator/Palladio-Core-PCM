/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import de.uka.ipd.sdq.pcm.usagemodel.Branch;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Branch Transition</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.BranchTransitionImpl#getBranchProbability <em>
 * Branch Probability</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.BranchTransitionImpl#getBranch_BranchTransition
 * <em>Branch Branch Transition</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.usagemodel.impl.BranchTransitionImpl#getBranchedBehaviour_BranchTransition
 * <em>Branched Behaviour Branch Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BranchTransitionImpl extends CDOObjectImpl implements BranchTransition {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The default value of the '{@link #getBranchProbability() <em>Branch Probability</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getBranchProbability()
     * @generated
     * @ordered
     */
    protected static final double BRANCH_PROBABILITY_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getBranchProbability() <em>Branch Probability</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getBranchProbability()
     * @generated
     * @ordered
     */
    protected double branchProbability = BRANCH_PROBABILITY_EDEFAULT;

    /**
     * The cached value of the '{@link #getBranchedBehaviour_BranchTransition()
     * <em>Branched Behaviour Branch Transition</em>}' containment reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #getBranchedBehaviour_BranchTransition()
     * @generated
     * @ordered
     */
    protected ScenarioBehaviour branchedBehaviour_BranchTransition;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected BranchTransitionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsagemodelPackage.Literals.BRANCH_TRANSITION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getBranchProbability() {
        return this.branchProbability;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setBranchProbability(final double newBranchProbability) {
        final double oldBranchProbability = this.branchProbability;
        this.branchProbability = newBranchProbability;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.BRANCH_TRANSITION__BRANCH_PROBABILITY, oldBranchProbability,
                    this.branchProbability));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Branch getBranch_BranchTransition() {
        if (this.eContainerFeatureID() != UsagemodelPackage.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION) {
            return null;
        }
        return (Branch) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetBranch_BranchTransition(final Branch newBranch_BranchTransition,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newBranch_BranchTransition,
                UsagemodelPackage.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setBranch_BranchTransition(final Branch newBranch_BranchTransition) {
        if (newBranch_BranchTransition != this.eInternalContainer()
                || (this.eContainerFeatureID() != UsagemodelPackage.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION && newBranch_BranchTransition != null)) {
            if (EcoreUtil.isAncestor(this, newBranch_BranchTransition)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newBranch_BranchTransition != null) {
                msgs = ((InternalEObject) newBranch_BranchTransition).eInverseAdd(this,
                        UsagemodelPackage.BRANCH__BRANCH_TRANSITIONS_BRANCH, Branch.class, msgs);
            }
            msgs = this.basicSetBranch_BranchTransition(newBranch_BranchTransition, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION, newBranch_BranchTransition,
                    newBranch_BranchTransition));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ScenarioBehaviour getBranchedBehaviour_BranchTransition() {
        return this.branchedBehaviour_BranchTransition;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetBranchedBehaviour_BranchTransition(
            final ScenarioBehaviour newBranchedBehaviour_BranchTransition, NotificationChain msgs) {
        final ScenarioBehaviour oldBranchedBehaviour_BranchTransition = this.branchedBehaviour_BranchTransition;
        this.branchedBehaviour_BranchTransition = newBranchedBehaviour_BranchTransition;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION,
                    oldBranchedBehaviour_BranchTransition, newBranchedBehaviour_BranchTransition);
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
    public void setBranchedBehaviour_BranchTransition(final ScenarioBehaviour newBranchedBehaviour_BranchTransition) {
        if (newBranchedBehaviour_BranchTransition != this.branchedBehaviour_BranchTransition) {
            NotificationChain msgs = null;
            if (this.branchedBehaviour_BranchTransition != null) {
                msgs = ((InternalEObject) this.branchedBehaviour_BranchTransition).eInverseRemove(this,
                        UsagemodelPackage.SCENARIO_BEHAVIOUR__BRANCH_TRANSITION_SCENARIO_BEHAVIOUR,
                        ScenarioBehaviour.class, msgs);
            }
            if (newBranchedBehaviour_BranchTransition != null) {
                msgs = ((InternalEObject) newBranchedBehaviour_BranchTransition).eInverseAdd(this,
                        UsagemodelPackage.SCENARIO_BEHAVIOUR__BRANCH_TRANSITION_SCENARIO_BEHAVIOUR,
                        ScenarioBehaviour.class, msgs);
            }
            msgs = this.basicSetBranchedBehaviour_BranchTransition(newBranchedBehaviour_BranchTransition, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION,
                    newBranchedBehaviour_BranchTransition, newBranchedBehaviour_BranchTransition));
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
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetBranch_BranchTransition((Branch) otherEnd, msgs);
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION:
            if (this.branchedBehaviour_BranchTransition != null) {
                msgs = ((InternalEObject) this.branchedBehaviour_BranchTransition)
                        .eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                                - UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION, null, msgs);
            }
            return this.basicSetBranchedBehaviour_BranchTransition((ScenarioBehaviour) otherEnd, msgs);
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
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION:
            return this.basicSetBranch_BranchTransition(null, msgs);
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION:
            return this.basicSetBranchedBehaviour_BranchTransition(null, msgs);
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
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION:
            return this.eInternalContainer().eInverseRemove(this, UsagemodelPackage.BRANCH__BRANCH_TRANSITIONS_BRANCH,
                    Branch.class, msgs);
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
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCH_PROBABILITY:
            return this.getBranchProbability();
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION:
            return this.getBranch_BranchTransition();
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION:
            return this.getBranchedBehaviour_BranchTransition();
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
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCH_PROBABILITY:
            this.setBranchProbability((Double) newValue);
            return;
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION:
            this.setBranch_BranchTransition((Branch) newValue);
            return;
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION:
            this.setBranchedBehaviour_BranchTransition((ScenarioBehaviour) newValue);
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
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCH_PROBABILITY:
            this.setBranchProbability(BRANCH_PROBABILITY_EDEFAULT);
            return;
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION:
            this.setBranch_BranchTransition((Branch) null);
            return;
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION:
            this.setBranchedBehaviour_BranchTransition((ScenarioBehaviour) null);
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
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCH_PROBABILITY:
            return this.branchProbability != BRANCH_PROBABILITY_EDEFAULT;
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION:
            return this.getBranch_BranchTransition() != null;
        case UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION:
            return this.branchedBehaviour_BranchTransition != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        if (this.eIsProxy()) {
            return super.toString();
        }

        final StringBuffer result = new StringBuffer(super.toString());
        result.append(" (branchProbability: ");
        result.append(this.branchProbability);
        result.append(')');
        return result.toString();
    }

} // BranchTransitionImpl
