/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.resultmodel.impl;

import de.uka.ipd.sdq.probfunction.math.ManagedPDF;

import de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime;
import de.uka.ipd.sdq.qnm.resultmodel.ResultmodelPackage;
import de.uka.ipd.sdq.qnm.resultmodel.ServiceTimeBreakDown;

import de.uka.ipd.sdq.spa.resourcemodel.AbstractResourceUsage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Usage Time</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.ResourceUsageTimeImpl#getResourceUsage <em>Resource Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.ResourceUsageTimeImpl#getServiceTime <em>Service Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.ResourceUsageTimeImpl#getResponseTime <em>Response Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.ResourceUsageTimeImpl#getServiceTimeBreakDown <em>Service Time Break Down</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceUsageTimeImpl extends EObjectImpl implements ResourceUsageTime {
	/**
	 * The cached value of the '{@link #getResourceUsage() <em>Resource Usage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceUsage()
	 * @generated
	 * @ordered
	 */
	protected AbstractResourceUsage resourceUsage = null;

	/**
	 * The default value of the '{@link #getServiceTime() <em>Service Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceTime()
	 * @generated
	 * @ordered
	 */
	protected static final ManagedPDF SERVICE_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServiceTime() <em>Service Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceTime()
	 * @generated
	 * @ordered
	 */
	protected ManagedPDF serviceTime = SERVICE_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getResponseTime() <em>Response Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponseTime()
	 * @generated
	 * @ordered
	 */
	protected static final ManagedPDF RESPONSE_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResponseTime() <em>Response Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponseTime()
	 * @generated
	 * @ordered
	 */
	protected ManagedPDF responseTime = RESPONSE_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getServiceTimeBreakDown() <em>Service Time Break Down</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceTimeBreakDown()
	 * @generated
	 * @ordered
	 */
	protected EList serviceTimeBreakDown = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceUsageTimeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ResultmodelPackage.Literals.RESOURCE_USAGE_TIME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractResourceUsage getResourceUsage() {
		if (resourceUsage != null && resourceUsage.eIsProxy()) {
			InternalEObject oldResourceUsage = (InternalEObject)resourceUsage;
			resourceUsage = (AbstractResourceUsage)eResolveProxy(oldResourceUsage);
			if (resourceUsage != oldResourceUsage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultmodelPackage.RESOURCE_USAGE_TIME__RESOURCE_USAGE, oldResourceUsage, resourceUsage));
			}
		}
		return resourceUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractResourceUsage basicGetResourceUsage() {
		return resourceUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceUsage(AbstractResourceUsage newResourceUsage) {
		AbstractResourceUsage oldResourceUsage = resourceUsage;
		resourceUsage = newResourceUsage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultmodelPackage.RESOURCE_USAGE_TIME__RESOURCE_USAGE, oldResourceUsage, resourceUsage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedPDF getServiceTime() {
		return serviceTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceTime(ManagedPDF newServiceTime) {
		ManagedPDF oldServiceTime = serviceTime;
		serviceTime = newServiceTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultmodelPackage.RESOURCE_USAGE_TIME__SERVICE_TIME, oldServiceTime, serviceTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedPDF getResponseTime() {
		return responseTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponseTime(ManagedPDF newResponseTime) {
		ManagedPDF oldResponseTime = responseTime;
		responseTime = newResponseTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultmodelPackage.RESOURCE_USAGE_TIME__RESPONSE_TIME, oldResponseTime, responseTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getServiceTimeBreakDown() {
		if (serviceTimeBreakDown == null) {
			serviceTimeBreakDown = new EObjectContainmentEList(ServiceTimeBreakDown.class, this, ResultmodelPackage.RESOURCE_USAGE_TIME__SERVICE_TIME_BREAK_DOWN);
		}
		return serviceTimeBreakDown;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResultmodelPackage.RESOURCE_USAGE_TIME__SERVICE_TIME_BREAK_DOWN:
				return ((InternalEList)getServiceTimeBreakDown()).basicRemove(otherEnd, msgs);
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
			case ResultmodelPackage.RESOURCE_USAGE_TIME__RESOURCE_USAGE:
				if (resolve) return getResourceUsage();
				return basicGetResourceUsage();
			case ResultmodelPackage.RESOURCE_USAGE_TIME__SERVICE_TIME:
				return getServiceTime();
			case ResultmodelPackage.RESOURCE_USAGE_TIME__RESPONSE_TIME:
				return getResponseTime();
			case ResultmodelPackage.RESOURCE_USAGE_TIME__SERVICE_TIME_BREAK_DOWN:
				return getServiceTimeBreakDown();
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
			case ResultmodelPackage.RESOURCE_USAGE_TIME__RESOURCE_USAGE:
				setResourceUsage((AbstractResourceUsage)newValue);
				return;
			case ResultmodelPackage.RESOURCE_USAGE_TIME__SERVICE_TIME:
				setServiceTime((ManagedPDF)newValue);
				return;
			case ResultmodelPackage.RESOURCE_USAGE_TIME__RESPONSE_TIME:
				setResponseTime((ManagedPDF)newValue);
				return;
			case ResultmodelPackage.RESOURCE_USAGE_TIME__SERVICE_TIME_BREAK_DOWN:
				getServiceTimeBreakDown().clear();
				getServiceTimeBreakDown().addAll((Collection)newValue);
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
			case ResultmodelPackage.RESOURCE_USAGE_TIME__RESOURCE_USAGE:
				setResourceUsage((AbstractResourceUsage)null);
				return;
			case ResultmodelPackage.RESOURCE_USAGE_TIME__SERVICE_TIME:
				setServiceTime(SERVICE_TIME_EDEFAULT);
				return;
			case ResultmodelPackage.RESOURCE_USAGE_TIME__RESPONSE_TIME:
				setResponseTime(RESPONSE_TIME_EDEFAULT);
				return;
			case ResultmodelPackage.RESOURCE_USAGE_TIME__SERVICE_TIME_BREAK_DOWN:
				getServiceTimeBreakDown().clear();
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
			case ResultmodelPackage.RESOURCE_USAGE_TIME__RESOURCE_USAGE:
				return resourceUsage != null;
			case ResultmodelPackage.RESOURCE_USAGE_TIME__SERVICE_TIME:
				return SERVICE_TIME_EDEFAULT == null ? serviceTime != null : !SERVICE_TIME_EDEFAULT.equals(serviceTime);
			case ResultmodelPackage.RESOURCE_USAGE_TIME__RESPONSE_TIME:
				return RESPONSE_TIME_EDEFAULT == null ? responseTime != null : !RESPONSE_TIME_EDEFAULT.equals(responseTime);
			case ResultmodelPackage.RESOURCE_USAGE_TIME__SERVICE_TIME_BREAK_DOWN:
				return serviceTimeBreakDown != null && !serviceTimeBreakDown.isEmpty();
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
		result.append(" (serviceTime: ");
		result.append(serviceTime);
		result.append(", responseTime: ");
		result.append(responseTime);
		result.append(')');
		return result.toString();
	}

} //ResourceUsageTimeImpl