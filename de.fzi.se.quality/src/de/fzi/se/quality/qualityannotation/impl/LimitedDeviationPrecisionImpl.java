/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import de.fzi.se.quality.qualityannotation.LimitedDeviationPrecision;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Limited Deviation Precision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.LimitedDeviationPrecisionImpl#getAbsolute <em>Absolute</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.LimitedDeviationPrecisionImpl#getRelative <em>Relative</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LimitedDeviationPrecisionImpl extends PrecisionImpl implements LimitedDeviationPrecision {
	/**
	 * The default value of the '{@link #getAbsolute() <em>Absolute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbsolute()
	 * @generated
	 * @ordered
	 */
	protected static final double ABSOLUTE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAbsolute() <em>Absolute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbsolute()
	 * @generated
	 * @ordered
	 */
	protected double absolute = ABSOLUTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRelative() <em>Relative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelative()
	 * @generated
	 * @ordered
	 */
	protected static final double RELATIVE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRelative() <em>Relative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelative()
	 * @generated
	 * @ordered
	 */
	protected double relative = RELATIVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LimitedDeviationPrecisionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QualityAnnotationPackage.Literals.LIMITED_DEVIATION_PRECISION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAbsolute() {
		return absolute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbsolute(double newAbsolute) {
		double oldAbsolute = absolute;
		absolute = newAbsolute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__ABSOLUTE, oldAbsolute, absolute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRelative() {
		return relative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelative(double newRelative) {
		double oldRelative = relative;
		relative = newRelative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__RELATIVE, oldRelative, relative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__ABSOLUTE:
				return getAbsolute();
			case QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__RELATIVE:
				return getRelative();
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
			case QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__ABSOLUTE:
				setAbsolute((Double)newValue);
				return;
			case QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__RELATIVE:
				setRelative((Double)newValue);
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
			case QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__ABSOLUTE:
				setAbsolute(ABSOLUTE_EDEFAULT);
				return;
			case QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__RELATIVE:
				setRelative(RELATIVE_EDEFAULT);
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
			case QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__ABSOLUTE:
				return absolute != ABSOLUTE_EDEFAULT;
			case QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__RELATIVE:
				return relative != RELATIVE_EDEFAULT;
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
		result.append(" (absolute: ");
		result.append(absolute);
		result.append(", relative: ");
		result.append(relative);
		result.append(')');
		return result.toString();
	}

} //LimitedDeviationPrecisionImpl
