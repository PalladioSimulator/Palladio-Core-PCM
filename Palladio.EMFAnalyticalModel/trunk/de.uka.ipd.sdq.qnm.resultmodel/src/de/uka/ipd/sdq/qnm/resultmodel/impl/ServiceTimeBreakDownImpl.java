/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.resultmodel.impl;

import de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage;
import de.uka.ipd.sdq.qnm.resultmodel.ServiceTimeBreakDown;

import de.uka.ipd.sdq.spa.resourcemodel.Resource;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Time Break Down</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.ServiceTimeBreakDownImpl#getUsageProbability <em>Usage Probability</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.ServiceTimeBreakDownImpl#getUsageTime <em>Usage Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.ServiceTimeBreakDownImpl#getUsedResource <em>Used Resource</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.ServiceTimeBreakDownImpl#getLastUsageProbability <em>Last Usage Probability</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.ServiceTimeBreakDownImpl#getLastUsageTime <em>Last Usage Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceTimeBreakDownImpl extends EObjectImpl implements ServiceTimeBreakDown {
	/**
	 * The default value of the '{@link #getUsageProbability() <em>Usage Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsageProbability()
	 * @generated
	 * @ordered
	 */
	protected static final double USAGE_PROBABILITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getUsageProbability() <em>Usage Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsageProbability()
	 * @generated
	 * @ordered
	 */
	protected double usageProbability = USAGE_PROBABILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getUsageTime() <em>Usage Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsageTime()
	 * @generated
	 * @ordered
	 */
	protected static final double USAGE_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getUsageTime() <em>Usage Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsageTime()
	 * @generated
	 * @ordered
	 */
	protected double usageTime = USAGE_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUsedResource() <em>Used Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedResource()
	 * @generated
	 * @ordered
	 */
	protected Resource usedResource = null;

	/**
	 * The default value of the '{@link #getLastUsageProbability() <em>Last Usage Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastUsageProbability()
	 * @generated
	 * @ordered
	 */
	protected static final double LAST_USAGE_PROBABILITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLastUsageProbability() <em>Last Usage Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastUsageProbability()
	 * @generated
	 * @ordered
	 */
	protected double lastUsageProbability = LAST_USAGE_PROBABILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastUsageTime() <em>Last Usage Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastUsageTime()
	 * @generated
	 * @ordered
	 */
	protected static final double LAST_USAGE_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLastUsageTime() <em>Last Usage Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastUsageTime()
	 * @generated
	 * @ordered
	 */
	protected double lastUsageTime = LAST_USAGE_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceTimeBreakDownImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ResultModelPackage.Literals.SERVICE_TIME_BREAK_DOWN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getUsageProbability() {
		return usageProbability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsageProbability(double newUsageProbability) {
		double oldUsageProbability = usageProbability;
		usageProbability = newUsageProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultModelPackage.SERVICE_TIME_BREAK_DOWN__USAGE_PROBABILITY, oldUsageProbability, usageProbability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getUsageTime() {
		return usageTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsageTime(double newUsageTime) {
		double oldUsageTime = usageTime;
		usageTime = newUsageTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultModelPackage.SERVICE_TIME_BREAK_DOWN__USAGE_TIME, oldUsageTime, usageTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getUsedResource() {
		if (usedResource != null && usedResource.eIsProxy()) {
			InternalEObject oldUsedResource = (InternalEObject)usedResource;
			usedResource = (Resource)eResolveProxy(oldUsedResource);
			if (usedResource != oldUsedResource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultModelPackage.SERVICE_TIME_BREAK_DOWN__USED_RESOURCE, oldUsedResource, usedResource));
			}
		}
		return usedResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource basicGetUsedResource() {
		return usedResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsedResource(Resource newUsedResource) {
		Resource oldUsedResource = usedResource;
		usedResource = newUsedResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultModelPackage.SERVICE_TIME_BREAK_DOWN__USED_RESOURCE, oldUsedResource, usedResource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLastUsageProbability() {
		return lastUsageProbability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastUsageProbability(double newLastUsageProbability) {
		double oldLastUsageProbability = lastUsageProbability;
		lastUsageProbability = newLastUsageProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultModelPackage.SERVICE_TIME_BREAK_DOWN__LAST_USAGE_PROBABILITY, oldLastUsageProbability, lastUsageProbability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLastUsageTime() {
		return lastUsageTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastUsageTime(double newLastUsageTime) {
		double oldLastUsageTime = lastUsageTime;
		lastUsageTime = newLastUsageTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultModelPackage.SERVICE_TIME_BREAK_DOWN__LAST_USAGE_TIME, oldLastUsageTime, lastUsageTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResultModelPackage.SERVICE_TIME_BREAK_DOWN__USAGE_PROBABILITY:
				return new Double(getUsageProbability());
			case ResultModelPackage.SERVICE_TIME_BREAK_DOWN__USAGE_TIME:
				return new Double(getUsageTime());
			case ResultModelPackage.SERVICE_TIME_BREAK_DOWN__USED_RESOURCE:
				if (resolve) return getUsedResource();
				return basicGetUsedResource();
			case ResultModelPackage.SERVICE_TIME_BREAK_DOWN__LAST_USAGE_PROBABILITY:
				return new Double(getLastUsageProbability());
			case ResultModelPackage.SERVICE_TIME_BREAK_DOWN__LAST_USAGE_TIME:
				return new Double(getLastUsageTime());
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
			case ResultModelPackage.SERVICE_TIME_BREAK_DOWN__USAGE_PROBABILITY:
				setUsageProbability(((Double)newValue).doubleValue());
				return;
			case ResultModelPackage.SERVICE_TIME_BREAK_DOWN__USAGE_TIME:
				setUsageTime(((Double)newValue).doubleValue());
				return;
			case ResultModelPackage.SERVICE_TIME_BREAK_DOWN__USED_RESOURCE:
				setUsedResource((Resource)newValue);
				return;
			case ResultModelPackage.SERVICE_TIME_BREAK_DOWN__LAST_USAGE_PROBABILITY:
				setLastUsageProbability(((Double)newValue).doubleValue());
				return;
			case ResultModelPackage.SERVICE_TIME_BREAK_DOWN__LAST_USAGE_TIME:
				setLastUsageTime(((Double)newValue).doubleValue());
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
			case ResultModelPackage.SERVICE_TIME_BREAK_DOWN__USAGE_PROBABILITY:
				setUsageProbability(USAGE_PROBABILITY_EDEFAULT);
				return;
			case ResultModelPackage.SERVICE_TIME_BREAK_DOWN__USAGE_TIME:
				setUsageTime(USAGE_TIME_EDEFAULT);
				return;
			case ResultModelPackage.SERVICE_TIME_BREAK_DOWN__USED_RESOURCE:
				setUsedResource((Resource)null);
				return;
			case ResultModelPackage.SERVICE_TIME_BREAK_DOWN__LAST_USAGE_PROBABILITY:
				setLastUsageProbability(LAST_USAGE_PROBABILITY_EDEFAULT);
				return;
			case ResultModelPackage.SERVICE_TIME_BREAK_DOWN__LAST_USAGE_TIME:
				setLastUsageTime(LAST_USAGE_TIME_EDEFAULT);
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
			case ResultModelPackage.SERVICE_TIME_BREAK_DOWN__USAGE_PROBABILITY:
				return usageProbability != USAGE_PROBABILITY_EDEFAULT;
			case ResultModelPackage.SERVICE_TIME_BREAK_DOWN__USAGE_TIME:
				return usageTime != USAGE_TIME_EDEFAULT;
			case ResultModelPackage.SERVICE_TIME_BREAK_DOWN__USED_RESOURCE:
				return usedResource != null;
			case ResultModelPackage.SERVICE_TIME_BREAK_DOWN__LAST_USAGE_PROBABILITY:
				return lastUsageProbability != LAST_USAGE_PROBABILITY_EDEFAULT;
			case ResultModelPackage.SERVICE_TIME_BREAK_DOWN__LAST_USAGE_TIME:
				return lastUsageTime != LAST_USAGE_TIME_EDEFAULT;
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
		result.append(" (usageProbability: ");
		result.append(usageProbability);
		result.append(", usageTime: ");
		result.append(usageTime);
		result.append(", lastUsageProbability: ");
		result.append(lastUsageProbability);
		result.append(", lastUsageTime: ");
		result.append(lastUsageTime);
		result.append(')');
		return result.toString();
	}

} //ServiceTimeBreakDownImpl