/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.qnResult.impl;

import de.uka.ipd.sdq.probfunction.math.ManagedPDF;

import de.uka.ipd.sdq.qnm.Demand;

import de.uka.ipd.sdq.qnm.qnResult.DemandResult;
import de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage;
import de.uka.ipd.sdq.qnm.qnResult.QNResultPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Demand Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.DemandResultImpl#getResponseTime <em>Response Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.DemandResultImpl#getServerUsages <em>Server Usages</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.DemandResultImpl#getDemand <em>Demand</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.DemandResultImpl#getServiceTime <em>Service Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DemandResultImpl extends EObjectImpl implements DemandResult {
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
	 * The cached value of the '{@link #getServerUsages() <em>Server Usages</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerUsages()
	 * @generated
	 * @ordered
	 */
	protected EList serverUsages = null;

	/**
	 * The cached value of the '{@link #getDemand() <em>Demand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDemand()
	 * @generated
	 * @ordered
	 */
	protected Demand demand = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DemandResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return QNResultPackage.Literals.DEMAND_RESULT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, QNResultPackage.DEMAND_RESULT__RESPONSE_TIME, oldResponseTime, responseTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getServerUsages() {
		if (serverUsages == null) {
			serverUsages = new EObjectWithInverseResolvingEList(DemandServerUsage.class, this, QNResultPackage.DEMAND_RESULT__SERVER_USAGES, QNResultPackage.DEMAND_SERVER_USAGE__DEMAND);
		}
		return serverUsages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Demand getDemand() {
		if (demand != null && demand.eIsProxy()) {
			InternalEObject oldDemand = (InternalEObject)demand;
			demand = (Demand)eResolveProxy(oldDemand);
			if (demand != oldDemand) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QNResultPackage.DEMAND_RESULT__DEMAND, oldDemand, demand));
			}
		}
		return demand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Demand basicGetDemand() {
		return demand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDemand(Demand newDemand) {
		Demand oldDemand = demand;
		demand = newDemand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QNResultPackage.DEMAND_RESULT__DEMAND, oldDemand, demand));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QNResultPackage.DEMAND_RESULT__SERVICE_TIME, oldServiceTime, serviceTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QNResultPackage.DEMAND_RESULT__SERVER_USAGES:
				return ((InternalEList)getServerUsages()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QNResultPackage.DEMAND_RESULT__SERVER_USAGES:
				return ((InternalEList)getServerUsages()).basicRemove(otherEnd, msgs);
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
			case QNResultPackage.DEMAND_RESULT__RESPONSE_TIME:
				return getResponseTime();
			case QNResultPackage.DEMAND_RESULT__SERVER_USAGES:
				return getServerUsages();
			case QNResultPackage.DEMAND_RESULT__DEMAND:
				if (resolve) return getDemand();
				return basicGetDemand();
			case QNResultPackage.DEMAND_RESULT__SERVICE_TIME:
				return getServiceTime();
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
			case QNResultPackage.DEMAND_RESULT__RESPONSE_TIME:
				setResponseTime((ManagedPDF)newValue);
				return;
			case QNResultPackage.DEMAND_RESULT__SERVER_USAGES:
				getServerUsages().clear();
				getServerUsages().addAll((Collection)newValue);
				return;
			case QNResultPackage.DEMAND_RESULT__DEMAND:
				setDemand((Demand)newValue);
				return;
			case QNResultPackage.DEMAND_RESULT__SERVICE_TIME:
				setServiceTime((ManagedPDF)newValue);
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
			case QNResultPackage.DEMAND_RESULT__RESPONSE_TIME:
				setResponseTime(RESPONSE_TIME_EDEFAULT);
				return;
			case QNResultPackage.DEMAND_RESULT__SERVER_USAGES:
				getServerUsages().clear();
				return;
			case QNResultPackage.DEMAND_RESULT__DEMAND:
				setDemand((Demand)null);
				return;
			case QNResultPackage.DEMAND_RESULT__SERVICE_TIME:
				setServiceTime(SERVICE_TIME_EDEFAULT);
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
			case QNResultPackage.DEMAND_RESULT__RESPONSE_TIME:
				return RESPONSE_TIME_EDEFAULT == null ? responseTime != null : !RESPONSE_TIME_EDEFAULT.equals(responseTime);
			case QNResultPackage.DEMAND_RESULT__SERVER_USAGES:
				return serverUsages != null && !serverUsages.isEmpty();
			case QNResultPackage.DEMAND_RESULT__DEMAND:
				return demand != null;
			case QNResultPackage.DEMAND_RESULT__SERVICE_TIME:
				return SERVICE_TIME_EDEFAULT == null ? serviceTime != null : !SERVICE_TIME_EDEFAULT.equals(serviceTime);
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
		result.append(" (responseTime: ");
		result.append(responseTime);
		result.append(", serviceTime: ");
		result.append(serviceTime);
		result.append(')');
		return result.toString();
	}

} //DemandResultImpl