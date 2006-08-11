/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ipd.uka.sdq.pcm.seff.impl;

import de.ipd.uka.sdq.pcm.seff.BranchTransition;
import de.ipd.uka.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.ipd.uka.sdq.pcm.seff.SeffPackage;

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
 *   <li>{@link de.ipd.uka.sdq.pcm.seff.impl.BranchTransitionImpl#getBranchProbability <em>Branch Probability</em>}</li>
 *   <li>{@link de.ipd.uka.sdq.pcm.seff.impl.BranchTransitionImpl#getBranchBehaviour_BranchTransition <em>Branch Behaviour Branch Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BranchTransitionImpl extends EObjectImpl implements BranchTransition {
	/**
	 * The default value of the '{@link #getBranchProbability() <em>Branch Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranchProbability()
	 * @generated
	 * @ordered
	 */
	protected static final String BRANCH_PROBABILITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBranchProbability() <em>Branch Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranchProbability()
	 * @generated
	 * @ordered
	 */
	protected String branchProbability = BRANCH_PROBABILITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBranchBehaviour_BranchTransition() <em>Branch Behaviour Branch Transition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranchBehaviour_BranchTransition()
	 * @generated
	 * @ordered
	 */
	protected ResourceDemandingBehaviour branchBehaviour_BranchTransition = null;

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
	protected EClass eStaticClass() {
		return SeffPackage.Literals.BRANCH_TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBranchProbability() {
		return branchProbability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBranchProbability(String newBranchProbability) {
		String oldBranchProbability = branchProbability;
		branchProbability = newBranchProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.BRANCH_TRANSITION__BRANCH_PROBABILITY, oldBranchProbability, branchProbability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDemandingBehaviour getBranchBehaviour_BranchTransition() {
		return branchBehaviour_BranchTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBranchBehaviour_BranchTransition(ResourceDemandingBehaviour newBranchBehaviour_BranchTransition, NotificationChain msgs) {
		ResourceDemandingBehaviour oldBranchBehaviour_BranchTransition = branchBehaviour_BranchTransition;
		branchBehaviour_BranchTransition = newBranchBehaviour_BranchTransition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SeffPackage.BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION, oldBranchBehaviour_BranchTransition, newBranchBehaviour_BranchTransition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBranchBehaviour_BranchTransition(ResourceDemandingBehaviour newBranchBehaviour_BranchTransition) {
		if (newBranchBehaviour_BranchTransition != branchBehaviour_BranchTransition) {
			NotificationChain msgs = null;
			if (branchBehaviour_BranchTransition != null)
				msgs = ((InternalEObject)branchBehaviour_BranchTransition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SeffPackage.BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION, null, msgs);
			if (newBranchBehaviour_BranchTransition != null)
				msgs = ((InternalEObject)newBranchBehaviour_BranchTransition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SeffPackage.BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION, null, msgs);
			msgs = basicSetBranchBehaviour_BranchTransition(newBranchBehaviour_BranchTransition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION, newBranchBehaviour_BranchTransition, newBranchBehaviour_BranchTransition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION:
				return basicSetBranchBehaviour_BranchTransition(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SeffPackage.BRANCH_TRANSITION__BRANCH_PROBABILITY:
				return getBranchProbability();
			case SeffPackage.BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION:
				return getBranchBehaviour_BranchTransition();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SeffPackage.BRANCH_TRANSITION__BRANCH_PROBABILITY:
				setBranchProbability((String)newValue);
				return;
			case SeffPackage.BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION:
				setBranchBehaviour_BranchTransition((ResourceDemandingBehaviour)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case SeffPackage.BRANCH_TRANSITION__BRANCH_PROBABILITY:
				setBranchProbability(BRANCH_PROBABILITY_EDEFAULT);
				return;
			case SeffPackage.BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION:
				setBranchBehaviour_BranchTransition((ResourceDemandingBehaviour)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SeffPackage.BRANCH_TRANSITION__BRANCH_PROBABILITY:
				return BRANCH_PROBABILITY_EDEFAULT == null ? branchProbability != null : !BRANCH_PROBABILITY_EDEFAULT.equals(branchProbability);
			case SeffPackage.BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION:
				return branchBehaviour_BranchTransition != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (branchProbability: ");
		result.append(branchProbability);
		result.append(')');
		return result.toString();
	}

} //BranchTransitionImpl