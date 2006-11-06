
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Internal Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.InternalActionImpl#getFailureProbability <em>Failure Probability</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InternalActionImpl extends AbstractResourceDemandingActionImpl implements InternalAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The default value of the '{@link #getFailureProbability() <em>Failure Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureProbability()
	 * @generated
	 * @ordered
	 */
	protected static final String FAILURE_PROBABILITY_EDEFAULT = null;


	/**
	 * The cached value of the '{@link #getFailureProbability() <em>Failure Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureProbability()
	 * @generated
	 * @ordered
	 */
	protected String failureProbability = FAILURE_PROBABILITY_EDEFAULT;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InternalActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SeffPackage.Literals.INTERNAL_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFailureProbability() {
		return failureProbability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailureProbability(String newFailureProbability) {
		String oldFailureProbability = failureProbability;
		failureProbability = newFailureProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.INTERNAL_ACTION__FAILURE_PROBABILITY, oldFailureProbability, failureProbability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SeffPackage.INTERNAL_ACTION__FAILURE_PROBABILITY:
				return getFailureProbability();
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
			case SeffPackage.INTERNAL_ACTION__FAILURE_PROBABILITY:
				setFailureProbability((String)newValue);
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
			case SeffPackage.INTERNAL_ACTION__FAILURE_PROBABILITY:
				setFailureProbability(FAILURE_PROBABILITY_EDEFAULT);
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
			case SeffPackage.INTERNAL_ACTION__FAILURE_PROBABILITY:
				return FAILURE_PROBABILITY_EDEFAULT == null ? failureProbability != null : !FAILURE_PROBABILITY_EDEFAULT.equals(failureProbability);
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
		result.append(" (failureProbability: ");
		result.append(failureProbability);
		result.append(')');
		return result.toString();
	}

} //InternalActionImpl