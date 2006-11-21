/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.qnResult.impl;

import de.uka.ipd.sdq.qnm.Customer;
import de.uka.ipd.sdq.qnm.Server;

import de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage;
import de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage;
import de.uka.ipd.sdq.qnm.qnResult.QNResultPackage;
import de.uka.ipd.sdq.qnm.qnResult.ServerResult;

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
 * An implementation of the model object '<em><b>Server Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.ServerResultImpl#getUsingCustomers <em>Using Customers</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.ServerResultImpl#getServer <em>Server</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.ServerResultImpl#getUsageDemands <em>Usage Demands</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServerResultImpl extends EObjectImpl implements ServerResult {
	/**
	 * The cached value of the '{@link #getUsingCustomers() <em>Using Customers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsingCustomers()
	 * @generated
	 * @ordered
	 */
	protected EList usingCustomers = null;

	/**
	 * The cached value of the '{@link #getServer() <em>Server</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServer()
	 * @generated
	 * @ordered
	 */
	protected Server server = null;

	/**
	 * The cached value of the '{@link #getUsageDemands() <em>Usage Demands</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsageDemands()
	 * @generated
	 * @ordered
	 */
	protected EList usageDemands = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServerResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return QNResultPackage.Literals.SERVER_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getUsingCustomers() {
		if (usingCustomers == null) {
			usingCustomers = new EObjectWithInverseResolvingEList(CustomerServerUsage.class, this, QNResultPackage.SERVER_RESULT__USING_CUSTOMERS, QNResultPackage.CUSTOMER_SERVER_USAGE__SERVER_RESULT);
		}
		return usingCustomers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Server getServer() {
		if (server != null && server.eIsProxy()) {
			InternalEObject oldServer = (InternalEObject)server;
			server = (Server)eResolveProxy(oldServer);
			if (server != oldServer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QNResultPackage.SERVER_RESULT__SERVER, oldServer, server));
			}
		}
		return server;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Server basicGetServer() {
		return server;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServer(Server newServer) {
		Server oldServer = server;
		server = newServer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QNResultPackage.SERVER_RESULT__SERVER, oldServer, server));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getUsageDemands() {
		if (usageDemands == null) {
			usageDemands = new EObjectWithInverseResolvingEList(DemandServerUsage.class, this, QNResultPackage.SERVER_RESULT__USAGE_DEMANDS, QNResultPackage.DEMAND_SERVER_USAGE__SERVER);
		}
		return usageDemands;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomerServerUsage getUsageByCustomer(Customer customer) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QNResultPackage.SERVER_RESULT__USING_CUSTOMERS:
				return ((InternalEList)getUsingCustomers()).basicAdd(otherEnd, msgs);
			case QNResultPackage.SERVER_RESULT__USAGE_DEMANDS:
				return ((InternalEList)getUsageDemands()).basicAdd(otherEnd, msgs);
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
			case QNResultPackage.SERVER_RESULT__USING_CUSTOMERS:
				return ((InternalEList)getUsingCustomers()).basicRemove(otherEnd, msgs);
			case QNResultPackage.SERVER_RESULT__USAGE_DEMANDS:
				return ((InternalEList)getUsageDemands()).basicRemove(otherEnd, msgs);
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
			case QNResultPackage.SERVER_RESULT__USING_CUSTOMERS:
				return getUsingCustomers();
			case QNResultPackage.SERVER_RESULT__SERVER:
				if (resolve) return getServer();
				return basicGetServer();
			case QNResultPackage.SERVER_RESULT__USAGE_DEMANDS:
				return getUsageDemands();
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
			case QNResultPackage.SERVER_RESULT__USING_CUSTOMERS:
				getUsingCustomers().clear();
				getUsingCustomers().addAll((Collection)newValue);
				return;
			case QNResultPackage.SERVER_RESULT__SERVER:
				setServer((Server)newValue);
				return;
			case QNResultPackage.SERVER_RESULT__USAGE_DEMANDS:
				getUsageDemands().clear();
				getUsageDemands().addAll((Collection)newValue);
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
			case QNResultPackage.SERVER_RESULT__USING_CUSTOMERS:
				getUsingCustomers().clear();
				return;
			case QNResultPackage.SERVER_RESULT__SERVER:
				setServer((Server)null);
				return;
			case QNResultPackage.SERVER_RESULT__USAGE_DEMANDS:
				getUsageDemands().clear();
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
			case QNResultPackage.SERVER_RESULT__USING_CUSTOMERS:
				return usingCustomers != null && !usingCustomers.isEmpty();
			case QNResultPackage.SERVER_RESULT__SERVER:
				return server != null;
			case QNResultPackage.SERVER_RESULT__USAGE_DEMANDS:
				return usageDemands != null && !usageDemands.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ServerResultImpl