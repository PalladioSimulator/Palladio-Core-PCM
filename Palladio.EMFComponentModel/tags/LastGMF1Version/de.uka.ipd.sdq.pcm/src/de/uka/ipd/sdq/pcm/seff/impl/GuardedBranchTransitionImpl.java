
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import de.uka.ipd.sdq.pcm.seff.BranchCondition;
import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Guarded Branch Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.GuardedBranchTransitionImpl#getBranchCondition_BranchTransition <em>Branch Condition Branch Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GuardedBranchTransitionImpl extends AbstractBranchTransitionImpl implements GuardedBranchTransition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GuardedBranchTransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SeffPackage.Literals.GUARDED_BRANCH_TRANSITION;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SeffPackage.GUARDED_BRANCH_TRANSITION__BRANCH_CONDITION_BRANCH_TRANSITION, oldBranchCondition_BranchTransition, newBranchCondition_BranchTransition);
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
				msgs = ((InternalEObject)branchCondition_BranchTransition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SeffPackage.GUARDED_BRANCH_TRANSITION__BRANCH_CONDITION_BRANCH_TRANSITION, null, msgs);
			if (newBranchCondition_BranchTransition != null)
				msgs = ((InternalEObject)newBranchCondition_BranchTransition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SeffPackage.GUARDED_BRANCH_TRANSITION__BRANCH_CONDITION_BRANCH_TRANSITION, null, msgs);
			msgs = basicSetBranchCondition_BranchTransition(newBranchCondition_BranchTransition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.GUARDED_BRANCH_TRANSITION__BRANCH_CONDITION_BRANCH_TRANSITION, newBranchCondition_BranchTransition, newBranchCondition_BranchTransition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.GUARDED_BRANCH_TRANSITION__BRANCH_CONDITION_BRANCH_TRANSITION:
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
			case SeffPackage.GUARDED_BRANCH_TRANSITION__BRANCH_CONDITION_BRANCH_TRANSITION:
				return getBranchCondition_BranchTransition();
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
			case SeffPackage.GUARDED_BRANCH_TRANSITION__BRANCH_CONDITION_BRANCH_TRANSITION:
				setBranchCondition_BranchTransition((BranchCondition)newValue);
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
			case SeffPackage.GUARDED_BRANCH_TRANSITION__BRANCH_CONDITION_BRANCH_TRANSITION:
				setBranchCondition_BranchTransition((BranchCondition)null);
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
			case SeffPackage.GUARDED_BRANCH_TRANSITION__BRANCH_CONDITION_BRANCH_TRANSITION:
				return branchCondition_BranchTransition != null;
		}
		return super.eIsSet(featureID);
	}

} //GuardedBranchTransitionImpl