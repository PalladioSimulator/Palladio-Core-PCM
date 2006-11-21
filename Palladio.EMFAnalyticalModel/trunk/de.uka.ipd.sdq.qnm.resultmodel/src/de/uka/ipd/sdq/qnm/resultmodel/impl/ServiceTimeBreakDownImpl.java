/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.resultmodel.impl;

import de.uka.ipd.sdq.qnm.resultmodel.ResultmodelPackage;
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
		return ResultmodelPackage.Literals.SERVICE_TIME_BREAK_DOWN;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResultmodelPackage.SERVICE_TIME_BREAK_DOWN__USAGE_PROBABILITY, oldUsageProbability, usageProbability));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResultmodelPackage.SERVICE_TIME_BREAK_DOWN__USAGE_TIME, oldUsageTime, usageTime));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultmodelPackage.SERVICE_TIME_BREAK_DOWN__USED_RESOURCE, oldUsedResource, usedResource));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResultmodelPackage.SERVICE_TIME_BREAK_DOWN__USED_RESOURCE, oldUsedResource, usedResource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResultmodelPackage.SERVICE_TIME_BREAK_DOWN__USAGE_PROBABILITY:
				return new Double(getUsageProbability());
			case ResultmodelPackage.SERVICE_TIME_BREAK_DOWN__USAGE_TIME:
				return new Double(getUsageTime());
			case ResultmodelPackage.SERVICE_TIME_BREAK_DOWN__USED_RESOURCE:
				if (resolve) return getUsedResource();
				return basicGetUsedResource();
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
			case ResultmodelPackage.SERVICE_TIME_BREAK_DOWN__USAGE_PROBABILITY:
				setUsageProbability(((Double)newValue).doubleValue());
				return;
			case ResultmodelPackage.SERVICE_TIME_BREAK_DOWN__USAGE_TIME:
				setUsageTime(((Double)newValue).doubleValue());
				return;
			case ResultmodelPackage.SERVICE_TIME_BREAK_DOWN__USED_RESOURCE:
				setUsedResource((Resource)newValue);
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
			case ResultmodelPackage.SERVICE_TIME_BREAK_DOWN__USAGE_PROBABILITY:
				setUsageProbability(USAGE_PROBABILITY_EDEFAULT);
				return;
			case ResultmodelPackage.SERVICE_TIME_BREAK_DOWN__USAGE_TIME:
				setUsageTime(USAGE_TIME_EDEFAULT);
				return;
			case ResultmodelPackage.SERVICE_TIME_BREAK_DOWN__USED_RESOURCE:
				setUsedResource((Resource)null);
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
			case ResultmodelPackage.SERVICE_TIME_BREAK_DOWN__USAGE_PROBABILITY:
				return usageProbability != USAGE_PROBABILITY_EDEFAULT;
			case ResultmodelPackage.SERVICE_TIME_BREAK_DOWN__USAGE_TIME:
				return usageTime != USAGE_TIME_EDEFAULT;
			case ResultmodelPackage.SERVICE_TIME_BREAK_DOWN__USED_RESOURCE:
				return usedResource != null;
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
		result.append(')');
		return result.toString();
	}

} //ServiceTimeBreakDownImpl