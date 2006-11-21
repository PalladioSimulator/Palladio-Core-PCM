/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.qnResult.impl;

import de.uka.ipd.sdq.qnm.qnResult.DemandResult;
import de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage;
import de.uka.ipd.sdq.qnm.qnResult.QNResultPackage;
import de.uka.ipd.sdq.qnm.qnResult.ServerResult;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Demand Server Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.DemandServerUsageImpl#getDemand <em>Demand</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.DemandServerUsageImpl#getServer <em>Server</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.DemandServerUsageImpl#getUsageProbability <em>Usage Probability</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.DemandServerUsageImpl#getMeanUsageTime <em>Mean Usage Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DemandServerUsageImpl extends EObjectImpl implements DemandServerUsage {
	/**
	 * The cached value of the '{@link #getDemand() <em>Demand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDemand()
	 * @generated
	 * @ordered
	 */
	protected DemandResult demand = null;

	/**
	 * The cached value of the '{@link #getServer() <em>Server</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServer()
	 * @generated
	 * @ordered
	 */
	protected ServerResult server = null;

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
	 * The default value of the '{@link #getMeanUsageTime() <em>Mean Usage Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeanUsageTime()
	 * @generated
	 * @ordered
	 */
	protected static final double MEAN_USAGE_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMeanUsageTime() <em>Mean Usage Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeanUsageTime()
	 * @generated
	 * @ordered
	 */
	protected double meanUsageTime = MEAN_USAGE_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DemandServerUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return QNResultPackage.Literals.DEMAND_SERVER_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DemandResult getDemand() {
		if (demand != null && demand.eIsProxy()) {
			InternalEObject oldDemand = (InternalEObject)demand;
			demand = (DemandResult)eResolveProxy(oldDemand);
			if (demand != oldDemand) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QNResultPackage.DEMAND_SERVER_USAGE__DEMAND, oldDemand, demand));
			}
		}
		return demand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DemandResult basicGetDemand() {
		return demand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDemand(DemandResult newDemand, NotificationChain msgs) {
		DemandResult oldDemand = demand;
		demand = newDemand;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QNResultPackage.DEMAND_SERVER_USAGE__DEMAND, oldDemand, newDemand);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDemand(DemandResult newDemand) {
		if (newDemand != demand) {
			NotificationChain msgs = null;
			if (demand != null)
				msgs = ((InternalEObject)demand).eInverseRemove(this, QNResultPackage.DEMAND_RESULT__SERVER_USAGES, DemandResult.class, msgs);
			if (newDemand != null)
				msgs = ((InternalEObject)newDemand).eInverseAdd(this, QNResultPackage.DEMAND_RESULT__SERVER_USAGES, DemandResult.class, msgs);
			msgs = basicSetDemand(newDemand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QNResultPackage.DEMAND_SERVER_USAGE__DEMAND, newDemand, newDemand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServerResult getServer() {
		if (server != null && server.eIsProxy()) {
			InternalEObject oldServer = (InternalEObject)server;
			server = (ServerResult)eResolveProxy(oldServer);
			if (server != oldServer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QNResultPackage.DEMAND_SERVER_USAGE__SERVER, oldServer, server));
			}
		}
		return server;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServerResult basicGetServer() {
		return server;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetServer(ServerResult newServer, NotificationChain msgs) {
		ServerResult oldServer = server;
		server = newServer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QNResultPackage.DEMAND_SERVER_USAGE__SERVER, oldServer, newServer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServer(ServerResult newServer) {
		if (newServer != server) {
			NotificationChain msgs = null;
			if (server != null)
				msgs = ((InternalEObject)server).eInverseRemove(this, QNResultPackage.SERVER_RESULT__USAGE_DEMANDS, ServerResult.class, msgs);
			if (newServer != null)
				msgs = ((InternalEObject)newServer).eInverseAdd(this, QNResultPackage.SERVER_RESULT__USAGE_DEMANDS, ServerResult.class, msgs);
			msgs = basicSetServer(newServer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QNResultPackage.DEMAND_SERVER_USAGE__SERVER, newServer, newServer));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QNResultPackage.DEMAND_SERVER_USAGE__USAGE_PROBABILITY, oldUsageProbability, usageProbability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMeanUsageTime() {
		return meanUsageTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeanUsageTime(double newMeanUsageTime) {
		double oldMeanUsageTime = meanUsageTime;
		meanUsageTime = newMeanUsageTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QNResultPackage.DEMAND_SERVER_USAGE__MEAN_USAGE_TIME, oldMeanUsageTime, meanUsageTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QNResultPackage.DEMAND_SERVER_USAGE__DEMAND:
				if (demand != null)
					msgs = ((InternalEObject)demand).eInverseRemove(this, QNResultPackage.DEMAND_RESULT__SERVER_USAGES, DemandResult.class, msgs);
				return basicSetDemand((DemandResult)otherEnd, msgs);
			case QNResultPackage.DEMAND_SERVER_USAGE__SERVER:
				if (server != null)
					msgs = ((InternalEObject)server).eInverseRemove(this, QNResultPackage.SERVER_RESULT__USAGE_DEMANDS, ServerResult.class, msgs);
				return basicSetServer((ServerResult)otherEnd, msgs);
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
			case QNResultPackage.DEMAND_SERVER_USAGE__DEMAND:
				return basicSetDemand(null, msgs);
			case QNResultPackage.DEMAND_SERVER_USAGE__SERVER:
				return basicSetServer(null, msgs);
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
			case QNResultPackage.DEMAND_SERVER_USAGE__DEMAND:
				if (resolve) return getDemand();
				return basicGetDemand();
			case QNResultPackage.DEMAND_SERVER_USAGE__SERVER:
				if (resolve) return getServer();
				return basicGetServer();
			case QNResultPackage.DEMAND_SERVER_USAGE__USAGE_PROBABILITY:
				return new Double(getUsageProbability());
			case QNResultPackage.DEMAND_SERVER_USAGE__MEAN_USAGE_TIME:
				return new Double(getMeanUsageTime());
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
			case QNResultPackage.DEMAND_SERVER_USAGE__DEMAND:
				setDemand((DemandResult)newValue);
				return;
			case QNResultPackage.DEMAND_SERVER_USAGE__SERVER:
				setServer((ServerResult)newValue);
				return;
			case QNResultPackage.DEMAND_SERVER_USAGE__USAGE_PROBABILITY:
				setUsageProbability(((Double)newValue).doubleValue());
				return;
			case QNResultPackage.DEMAND_SERVER_USAGE__MEAN_USAGE_TIME:
				setMeanUsageTime(((Double)newValue).doubleValue());
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
			case QNResultPackage.DEMAND_SERVER_USAGE__DEMAND:
				setDemand((DemandResult)null);
				return;
			case QNResultPackage.DEMAND_SERVER_USAGE__SERVER:
				setServer((ServerResult)null);
				return;
			case QNResultPackage.DEMAND_SERVER_USAGE__USAGE_PROBABILITY:
				setUsageProbability(USAGE_PROBABILITY_EDEFAULT);
				return;
			case QNResultPackage.DEMAND_SERVER_USAGE__MEAN_USAGE_TIME:
				setMeanUsageTime(MEAN_USAGE_TIME_EDEFAULT);
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
			case QNResultPackage.DEMAND_SERVER_USAGE__DEMAND:
				return demand != null;
			case QNResultPackage.DEMAND_SERVER_USAGE__SERVER:
				return server != null;
			case QNResultPackage.DEMAND_SERVER_USAGE__USAGE_PROBABILITY:
				return usageProbability != USAGE_PROBABILITY_EDEFAULT;
			case QNResultPackage.DEMAND_SERVER_USAGE__MEAN_USAGE_TIME:
				return meanUsageTime != MEAN_USAGE_TIME_EDEFAULT;
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
		result.append(", meanUsageTime: ");
		result.append(meanUsageTime);
		result.append(')');
		return result.toString();
	}

} //DemandServerUsageImpl