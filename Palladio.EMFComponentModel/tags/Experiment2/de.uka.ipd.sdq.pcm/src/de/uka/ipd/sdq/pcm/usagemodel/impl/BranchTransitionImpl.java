
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.impl;

import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Branch Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.BranchTransitionImpl#getBranchProbability <em>Branch Probability</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.BranchTransitionImpl#getBranchedBehaviour_BranchTransition <em>Branched Behaviour Branch Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BranchTransitionImpl extends EObjectImpl implements BranchTransition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

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
	 * The cached value of the '{@link #getBranchProbability() <em>Branch Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranchProbability()
	 * @generated
	 * @ordered
	 */
	protected double branchProbability = BRANCH_PROBABILITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBranchedBehaviour_BranchTransition() <em>Branched Behaviour Branch Transition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranchedBehaviour_BranchTransition()
	 * @generated
	 * @ordered
	 */
	protected ScenarioBehaviour branchedBehaviour_BranchTransition;


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
	public double getBranchProbability() {
		return branchProbability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBranchProbability(double newBranchProbability) {
		double oldBranchProbability = branchProbability;
		branchProbability = newBranchProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.BRANCH_TRANSITION__BRANCH_PROBABILITY, oldBranchProbability, branchProbability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScenarioBehaviour getBranchedBehaviour_BranchTransition() {
		return branchedBehaviour_BranchTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBranchedBehaviour_BranchTransition(ScenarioBehaviour newBranchedBehaviour_BranchTransition, NotificationChain msgs) {
		ScenarioBehaviour oldBranchedBehaviour_BranchTransition = branchedBehaviour_BranchTransition;
		branchedBehaviour_BranchTransition = newBranchedBehaviour_BranchTransition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION, oldBranchedBehaviour_BranchTransition, newBranchedBehaviour_BranchTransition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBranchedBehaviour_BranchTransition(ScenarioBehaviour newBranchedBehaviour_BranchTransition) {
		if (newBranchedBehaviour_BranchTransition != branchedBehaviour_BranchTransition) {
			NotificationChain msgs = null;
			if (branchedBehaviour_BranchTransition != null)
				msgs = ((InternalEObject)branchedBehaviour_BranchTransition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION, null, msgs);
			if (newBranchedBehaviour_BranchTransition != null)
				msgs = ((InternalEObject)newBranchedBehaviour_BranchTransition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION, null, msgs);
			msgs = basicSetBranchedBehaviour_BranchTransition(newBranchedBehaviour_BranchTransition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION, newBranchedBehaviour_BranchTransition, newBranchedBehaviour_BranchTransition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UsagemodelPackage.BRANCH_TRANSITION__BRANCH_PROBABILITY:
				return new Double(getBranchProbability());
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
				setBranchProbability(((Double)newValue).doubleValue());
				return;
			case UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION:
				setBranchedBehaviour_BranchTransition((ScenarioBehaviour)newValue);
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
			case UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION:
				setBranchedBehaviour_BranchTransition((ScenarioBehaviour)null);
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
				return branchProbability != BRANCH_PROBABILITY_EDEFAULT;
			case UsagemodelPackage.BRANCH_TRANSITION__BRANCHED_BEHAVIOUR_BRANCH_TRANSITION:
				return branchedBehaviour_BranchTransition != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (branchProbability: ");
		result.append(branchProbability);
		result.append(')');
		return result.toString();
	}

} //BranchTransitionImpl
