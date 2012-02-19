/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.uka.ipd.sdq.featuremodel.IntervalRange;
import de.uka.ipd.sdq.featuremodel.featuremodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interval Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.IntervalRangeImpl#isLowerBoundIncluded <em>Lower Bound Included</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.IntervalRangeImpl#isUpperBoundIncluded <em>Upper Bound Included</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class IntervalRangeImpl extends EObjectImpl implements IntervalRange {
	/**
	 * The default value of the '{@link #isLowerBoundIncluded() <em>Lower Bound Included</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLowerBoundIncluded()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOWER_BOUND_INCLUDED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLowerBoundIncluded() <em>Lower Bound Included</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLowerBoundIncluded()
	 * @generated
	 * @ordered
	 */
	protected boolean lowerBoundIncluded = LOWER_BOUND_INCLUDED_EDEFAULT;

	/**
	 * The default value of the '{@link #isUpperBoundIncluded() <em>Upper Bound Included</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUpperBoundIncluded()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UPPER_BOUND_INCLUDED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUpperBoundIncluded() <em>Upper Bound Included</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUpperBoundIncluded()
	 * @generated
	 * @ordered
	 */
	protected boolean upperBoundIncluded = UPPER_BOUND_INCLUDED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntervalRangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return featuremodelPackage.Literals.INTERVAL_RANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLowerBoundIncluded() {
		return lowerBoundIncluded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerBoundIncluded(boolean newLowerBoundIncluded) {
		boolean oldLowerBoundIncluded = lowerBoundIncluded;
		lowerBoundIncluded = newLowerBoundIncluded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featuremodelPackage.INTERVAL_RANGE__LOWER_BOUND_INCLUDED, oldLowerBoundIncluded, lowerBoundIncluded));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUpperBoundIncluded() {
		return upperBoundIncluded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperBoundIncluded(boolean newUpperBoundIncluded) {
		boolean oldUpperBoundIncluded = upperBoundIncluded;
		upperBoundIncluded = newUpperBoundIncluded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featuremodelPackage.INTERVAL_RANGE__UPPER_BOUND_INCLUDED, oldUpperBoundIncluded, upperBoundIncluded));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case featuremodelPackage.INTERVAL_RANGE__LOWER_BOUND_INCLUDED:
				return isLowerBoundIncluded();
			case featuremodelPackage.INTERVAL_RANGE__UPPER_BOUND_INCLUDED:
				return isUpperBoundIncluded();
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
			case featuremodelPackage.INTERVAL_RANGE__LOWER_BOUND_INCLUDED:
				setLowerBoundIncluded((Boolean)newValue);
				return;
			case featuremodelPackage.INTERVAL_RANGE__UPPER_BOUND_INCLUDED:
				setUpperBoundIncluded((Boolean)newValue);
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
			case featuremodelPackage.INTERVAL_RANGE__LOWER_BOUND_INCLUDED:
				setLowerBoundIncluded(LOWER_BOUND_INCLUDED_EDEFAULT);
				return;
			case featuremodelPackage.INTERVAL_RANGE__UPPER_BOUND_INCLUDED:
				setUpperBoundIncluded(UPPER_BOUND_INCLUDED_EDEFAULT);
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
			case featuremodelPackage.INTERVAL_RANGE__LOWER_BOUND_INCLUDED:
				return lowerBoundIncluded != LOWER_BOUND_INCLUDED_EDEFAULT;
			case featuremodelPackage.INTERVAL_RANGE__UPPER_BOUND_INCLUDED:
				return upperBoundIncluded != UPPER_BOUND_INCLUDED_EDEFAULT;
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
		result.append(" (lowerBoundIncluded: ");
		result.append(lowerBoundIncluded);
		result.append(", upperBoundIncluded: ");
		result.append(upperBoundIncluded);
		result.append(')');
		return result.toString();
	}

} //IntervalRangeImpl
