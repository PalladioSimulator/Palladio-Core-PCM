/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.OrdinalIntervalsType;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.PresentationPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ordinal Intervals Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.OrdinalIntervalsTypeImpl#isAllIntervalWidthsEqual <em>All Interval Widths Equal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrdinalIntervalsTypeImpl extends DataTypeImpl implements OrdinalIntervalsType {
	/**
	 * The default value of the '{@link #isAllIntervalWidthsEqual() <em>All Interval Widths Equal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllIntervalWidthsEqual()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALL_INTERVAL_WIDTHS_EQUAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllIntervalWidthsEqual() <em>All Interval Widths Equal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllIntervalWidthsEqual()
	 * @generated
	 * @ordered
	 */
	protected boolean allIntervalWidthsEqual = ALL_INTERVAL_WIDTHS_EQUAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrdinalIntervalsTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PresentationPackage.Literals.ORDINAL_INTERVALS_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllIntervalWidthsEqual() {
		return allIntervalWidthsEqual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllIntervalWidthsEqual(boolean newAllIntervalWidthsEqual) {
		boolean oldAllIntervalWidthsEqual = allIntervalWidthsEqual;
		allIntervalWidthsEqual = newAllIntervalWidthsEqual;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PresentationPackage.ORDINAL_INTERVALS_TYPE__ALL_INTERVAL_WIDTHS_EQUAL, oldAllIntervalWidthsEqual, allIntervalWidthsEqual));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void getBeginOfInterval(int i) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void getWidthOfInterval(int I) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void getNumberOfIntervals() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PresentationPackage.ORDINAL_INTERVALS_TYPE__ALL_INTERVAL_WIDTHS_EQUAL:
				return isAllIntervalWidthsEqual();
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
			case PresentationPackage.ORDINAL_INTERVALS_TYPE__ALL_INTERVAL_WIDTHS_EQUAL:
				setAllIntervalWidthsEqual((Boolean)newValue);
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
			case PresentationPackage.ORDINAL_INTERVALS_TYPE__ALL_INTERVAL_WIDTHS_EQUAL:
				setAllIntervalWidthsEqual(ALL_INTERVAL_WIDTHS_EQUAL_EDEFAULT);
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
			case PresentationPackage.ORDINAL_INTERVALS_TYPE__ALL_INTERVAL_WIDTHS_EQUAL:
				return allIntervalWidthsEqual != ALL_INTERVAL_WIDTHS_EQUAL_EDEFAULT;
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
		result.append(" (allIntervalWidthsEqual: ");
		result.append(allIntervalWidthsEqual);
		result.append(')');
		return result.toString();
	}

} //OrdinalIntervalsTypeImpl
