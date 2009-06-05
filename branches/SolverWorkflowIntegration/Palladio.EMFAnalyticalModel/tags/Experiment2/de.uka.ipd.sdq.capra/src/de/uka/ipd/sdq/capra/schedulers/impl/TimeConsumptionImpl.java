/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.schedulers.impl;

import de.uka.ipd.sdq.capra.schedulers.BigOClass;
import de.uka.ipd.sdq.capra.schedulers.SchedulersPackage;
import de.uka.ipd.sdq.capra.schedulers.TimeConsumption;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Consumption</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.impl.TimeConsumptionImpl#getTime <em>Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.impl.TimeConsumptionImpl#getScaling <em>Scaling</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimeConsumptionImpl extends EObjectImpl implements TimeConsumption {
	/**
	 * The cached value of the '{@link #getTime() <em>Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected EObject time;

	/**
	 * The default value of the '{@link #getScaling() <em>Scaling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScaling()
	 * @generated
	 * @ordered
	 */
	protected static final BigOClass SCALING_EDEFAULT = BigOClass.CONSTANT;

	/**
	 * The cached value of the '{@link #getScaling() <em>Scaling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScaling()
	 * @generated
	 * @ordered
	 */
	protected BigOClass scaling = SCALING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeConsumptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulersPackage.Literals.TIME_CONSUMPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getTime() {
		if (time != null && time.eIsProxy()) {
			InternalEObject oldTime = (InternalEObject)time;
			time = eResolveProxy(oldTime);
			if (time != oldTime) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulersPackage.TIME_CONSUMPTION__TIME, oldTime, time));
			}
		}
		return time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetTime() {
		return time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTime(EObject newTime) {
		EObject oldTime = time;
		time = newTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulersPackage.TIME_CONSUMPTION__TIME, oldTime, time));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigOClass getScaling() {
		return scaling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScaling(BigOClass newScaling) {
		BigOClass oldScaling = scaling;
		scaling = newScaling == null ? SCALING_EDEFAULT : newScaling;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulersPackage.TIME_CONSUMPTION__SCALING, oldScaling, scaling));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulersPackage.TIME_CONSUMPTION__TIME:
				if (resolve) return getTime();
				return basicGetTime();
			case SchedulersPackage.TIME_CONSUMPTION__SCALING:
				return getScaling();
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
			case SchedulersPackage.TIME_CONSUMPTION__TIME:
				setTime((EObject)newValue);
				return;
			case SchedulersPackage.TIME_CONSUMPTION__SCALING:
				setScaling((BigOClass)newValue);
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
			case SchedulersPackage.TIME_CONSUMPTION__TIME:
				setTime((EObject)null);
				return;
			case SchedulersPackage.TIME_CONSUMPTION__SCALING:
				setScaling(SCALING_EDEFAULT);
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
			case SchedulersPackage.TIME_CONSUMPTION__TIME:
				return time != null;
			case SchedulersPackage.TIME_CONSUMPTION__SCALING:
				return scaling != SCALING_EDEFAULT;
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
		result.append(" (scaling: ");
		result.append(scaling);
		result.append(')');
		return result.toString();
	}

} //TimeConsumptionImpl
