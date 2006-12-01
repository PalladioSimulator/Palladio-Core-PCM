
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import de.uka.ipd.sdq.pcm.seff.BranchCondition;
import de.uka.ipd.sdq.pcm.seff.BranchTransition;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

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
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.BranchTransitionImpl#getBranchBehaviour_BranchTransition <em>Branch Behaviour Branch Transition</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.BranchTransitionImpl#getBranchCondition_BranchTransition <em>Branch Condition Branch Transition</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.BranchTransitionImpl#getBranchProbability <em>Branch Probability</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BranchTransitionImpl extends IdentifierImpl implements BranchTransition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

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
	 * The cached value of the '{@link #getBranchCondition_BranchTransition() <em>Branch Condition Branch Transition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranchCondition_BranchTransition()
	 * @generated
	 * @ordered
	 */
	protected BranchCondition branchCondition_BranchTransition = null;

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
	public BranchCondition getBranchCondition_BranchTransition() {
		return branchCondition_BranchTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBranchCondition_BranchTransition(BranchCondition newBranchCondition_BranchTransition, NotificationChain msgs) {
		BranchCondition oldBranchCondition_BranchTransition = branchCondition_BranchTransition;
		branchCondition_BranchTransition = newBranchCondition_BranchTransition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SeffPackage.BRANCH_TRANSITION__BRANCH_CONDITION_BRANCH_TRANSITION, oldBranchCondition_BranchTransition, newBranchCondition_BranchTransition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBranchCondition_BranchTransition(BranchCondition newBranchCondition_BranchTransition) {
		if (newBranchCondition_BranchTransition != branchCondition_BranchTransition) {
			NotificationChain msgs = null;
			if (branchCondition_BranchTransition != null)
				msgs = ((InternalEObject)branchCondition_BranchTransition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SeffPackage.BRANCH_TRANSITION__BRANCH_CONDITION_BRANCH_TRANSITION, null, msgs);
			if (newBranchCondition_BranchTransition != null)
				msgs = ((InternalEObject)newBranchCondition_BranchTransition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SeffPackage.BRANCH_TRANSITION__BRANCH_CONDITION_BRANCH_TRANSITION, null, msgs);
			msgs = basicSetBranchCondition_BranchTransition(newBranchCondition_BranchTransition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.BRANCH_TRANSITION__BRANCH_CONDITION_BRANCH_TRANSITION, newBranchCondition_BranchTransition, newBranchCondition_BranchTransition));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.BRANCH_TRANSITION__BRANCH_PROBABILITY, oldBranchProbability, branchProbability));
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
			case SeffPackage.BRANCH_TRANSITION__BRANCH_CONDITION_BRANCH_TRANSITION:
				return basicSetBranchCondition_BranchTransition(null, msgs);
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
			case SeffPackage.BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION:
				return getBranchBehaviour_BranchTransition();
			case SeffPackage.BRANCH_TRANSITION__BRANCH_CONDITION_BRANCH_TRANSITION:
				return getBranchCondition_BranchTransition();
			case SeffPackage.BRANCH_TRANSITION__BRANCH_PROBABILITY:
				return new Double(getBranchProbability());
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
			case SeffPackage.BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION:
				setBranchBehaviour_BranchTransition((ResourceDemandingBehaviour)newValue);
				return;
			case SeffPackage.BRANCH_TRANSITION__BRANCH_CONDITION_BRANCH_TRANSITION:
				setBranchCondition_BranchTransition((BranchCondition)newValue);
				return;
			case SeffPackage.BRANCH_TRANSITION__BRANCH_PROBABILITY:
				setBranchProbability(((Double)newValue).doubleValue());
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
			case SeffPackage.BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION:
				setBranchBehaviour_BranchTransition((ResourceDemandingBehaviour)null);
				return;
			case SeffPackage.BRANCH_TRANSITION__BRANCH_CONDITION_BRANCH_TRANSITION:
				setBranchCondition_BranchTransition((BranchCondition)null);
				return;
			case SeffPackage.BRANCH_TRANSITION__BRANCH_PROBABILITY:
				setBranchProbability(BRANCH_PROBABILITY_EDEFAULT);
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
			case SeffPackage.BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION:
				return branchBehaviour_BranchTransition != null;
			case SeffPackage.BRANCH_TRANSITION__BRANCH_CONDITION_BRANCH_TRANSITION:
				return branchCondition_BranchTransition != null;
			case SeffPackage.BRANCH_TRANSITION__BRANCH_PROBABILITY:
				return branchProbability != BRANCH_PROBABILITY_EDEFAULT;
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