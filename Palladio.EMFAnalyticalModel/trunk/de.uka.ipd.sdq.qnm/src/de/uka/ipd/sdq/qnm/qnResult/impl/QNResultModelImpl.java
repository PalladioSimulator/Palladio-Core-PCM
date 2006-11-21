/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.qnResult.impl;

import de.uka.ipd.sdq.qnm.Customer;
import de.uka.ipd.sdq.qnm.Demand;
import de.uka.ipd.sdq.qnm.QNModel;

import de.uka.ipd.sdq.qnm.Server;

import de.uka.ipd.sdq.qnm.qnResult.CustomerResult;
import de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage;
import de.uka.ipd.sdq.qnm.qnResult.DemandResult;
import de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage;
import de.uka.ipd.sdq.qnm.qnResult.QNResultModel;
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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.QNResultModelImpl#getCustomerServerUsage <em>Customer Server Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.QNResultModelImpl#getQnModel <em>Qn Model</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.QNResultModelImpl#getCustomerResults <em>Customer Results</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.QNResultModelImpl#getServerResults <em>Server Results</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.QNResultModelImpl#getDemandResults <em>Demand Results</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.QNResultModelImpl#getDemandServerUsages <em>Demand Server Usages</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QNResultModelImpl extends EObjectImpl implements QNResultModel {
	/**
	 * The cached value of the '{@link #getCustomerServerUsage() <em>Customer Server Usage</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomerServerUsage()
	 * @generated
	 * @ordered
	 */
	protected EList customerServerUsage = null;

	/**
	 * The cached value of the '{@link #getQnModel() <em>Qn Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQnModel()
	 * @generated
	 * @ordered
	 */
	protected QNModel qnModel = null;

	/**
	 * The cached value of the '{@link #getCustomerResults() <em>Customer Results</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomerResults()
	 * @generated
	 * @ordered
	 */
	protected EList customerResults = null;

	/**
	 * The cached value of the '{@link #getServerResults() <em>Server Results</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerResults()
	 * @generated
	 * @ordered
	 */
	protected EList serverResults = null;

	/**
	 * The cached value of the '{@link #getDemandResults() <em>Demand Results</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDemandResults()
	 * @generated
	 * @ordered
	 */
	protected EList demandResults = null;

	/**
	 * The cached value of the '{@link #getDemandServerUsages() <em>Demand Server Usages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDemandServerUsages()
	 * @generated
	 * @ordered
	 */
	protected EList demandServerUsages = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QNResultModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return QNResultPackage.Literals.QN_RESULT_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCustomerServerUsage() {
		if (customerServerUsage == null) {
			customerServerUsage = new EObjectContainmentEList(CustomerServerUsage.class, this, QNResultPackage.QN_RESULT_MODEL__CUSTOMER_SERVER_USAGE);
		}
		return customerServerUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QNModel getQnModel() {
		if (qnModel != null && qnModel.eIsProxy()) {
			InternalEObject oldQnModel = (InternalEObject)qnModel;
			qnModel = (QNModel)eResolveProxy(oldQnModel);
			if (qnModel != oldQnModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QNResultPackage.QN_RESULT_MODEL__QN_MODEL, oldQnModel, qnModel));
			}
		}
		return qnModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QNModel basicGetQnModel() {
		return qnModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQnModel(QNModel newQnModel) {
		QNModel oldQnModel = qnModel;
		qnModel = newQnModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QNResultPackage.QN_RESULT_MODEL__QN_MODEL, oldQnModel, qnModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCustomerResults() {
		if (customerResults == null) {
			customerResults = new EObjectContainmentEList(CustomerResult.class, this, QNResultPackage.QN_RESULT_MODEL__CUSTOMER_RESULTS);
		}
		return customerResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getServerResults() {
		if (serverResults == null) {
			serverResults = new EObjectContainmentEList(ServerResult.class, this, QNResultPackage.QN_RESULT_MODEL__SERVER_RESULTS);
		}
		return serverResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDemandResults() {
		if (demandResults == null) {
			demandResults = new EObjectContainmentEList(DemandResult.class, this, QNResultPackage.QN_RESULT_MODEL__DEMAND_RESULTS);
		}
		return demandResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDemandServerUsages() {
		if (demandServerUsages == null) {
			demandServerUsages = new EObjectContainmentEList(DemandServerUsage.class, this, QNResultPackage.QN_RESULT_MODEL__DEMAND_SERVER_USAGES);
		}
		return demandServerUsages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServerResult getResultForServer(Server server) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomerResult getResultForCustomer(Customer customer) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DemandResult getResultForDemand(Demand demand) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QNResultPackage.QN_RESULT_MODEL__CUSTOMER_SERVER_USAGE:
				return ((InternalEList)getCustomerServerUsage()).basicRemove(otherEnd, msgs);
			case QNResultPackage.QN_RESULT_MODEL__CUSTOMER_RESULTS:
				return ((InternalEList)getCustomerResults()).basicRemove(otherEnd, msgs);
			case QNResultPackage.QN_RESULT_MODEL__SERVER_RESULTS:
				return ((InternalEList)getServerResults()).basicRemove(otherEnd, msgs);
			case QNResultPackage.QN_RESULT_MODEL__DEMAND_RESULTS:
				return ((InternalEList)getDemandResults()).basicRemove(otherEnd, msgs);
			case QNResultPackage.QN_RESULT_MODEL__DEMAND_SERVER_USAGES:
				return ((InternalEList)getDemandServerUsages()).basicRemove(otherEnd, msgs);
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
			case QNResultPackage.QN_RESULT_MODEL__CUSTOMER_SERVER_USAGE:
				return getCustomerServerUsage();
			case QNResultPackage.QN_RESULT_MODEL__QN_MODEL:
				if (resolve) return getQnModel();
				return basicGetQnModel();
			case QNResultPackage.QN_RESULT_MODEL__CUSTOMER_RESULTS:
				return getCustomerResults();
			case QNResultPackage.QN_RESULT_MODEL__SERVER_RESULTS:
				return getServerResults();
			case QNResultPackage.QN_RESULT_MODEL__DEMAND_RESULTS:
				return getDemandResults();
			case QNResultPackage.QN_RESULT_MODEL__DEMAND_SERVER_USAGES:
				return getDemandServerUsages();
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
			case QNResultPackage.QN_RESULT_MODEL__CUSTOMER_SERVER_USAGE:
				getCustomerServerUsage().clear();
				getCustomerServerUsage().addAll((Collection)newValue);
				return;
			case QNResultPackage.QN_RESULT_MODEL__QN_MODEL:
				setQnModel((QNModel)newValue);
				return;
			case QNResultPackage.QN_RESULT_MODEL__CUSTOMER_RESULTS:
				getCustomerResults().clear();
				getCustomerResults().addAll((Collection)newValue);
				return;
			case QNResultPackage.QN_RESULT_MODEL__SERVER_RESULTS:
				getServerResults().clear();
				getServerResults().addAll((Collection)newValue);
				return;
			case QNResultPackage.QN_RESULT_MODEL__DEMAND_RESULTS:
				getDemandResults().clear();
				getDemandResults().addAll((Collection)newValue);
				return;
			case QNResultPackage.QN_RESULT_MODEL__DEMAND_SERVER_USAGES:
				getDemandServerUsages().clear();
				getDemandServerUsages().addAll((Collection)newValue);
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
			case QNResultPackage.QN_RESULT_MODEL__CUSTOMER_SERVER_USAGE:
				getCustomerServerUsage().clear();
				return;
			case QNResultPackage.QN_RESULT_MODEL__QN_MODEL:
				setQnModel((QNModel)null);
				return;
			case QNResultPackage.QN_RESULT_MODEL__CUSTOMER_RESULTS:
				getCustomerResults().clear();
				return;
			case QNResultPackage.QN_RESULT_MODEL__SERVER_RESULTS:
				getServerResults().clear();
				return;
			case QNResultPackage.QN_RESULT_MODEL__DEMAND_RESULTS:
				getDemandResults().clear();
				return;
			case QNResultPackage.QN_RESULT_MODEL__DEMAND_SERVER_USAGES:
				getDemandServerUsages().clear();
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
			case QNResultPackage.QN_RESULT_MODEL__CUSTOMER_SERVER_USAGE:
				return customerServerUsage != null && !customerServerUsage.isEmpty();
			case QNResultPackage.QN_RESULT_MODEL__QN_MODEL:
				return qnModel != null;
			case QNResultPackage.QN_RESULT_MODEL__CUSTOMER_RESULTS:
				return customerResults != null && !customerResults.isEmpty();
			case QNResultPackage.QN_RESULT_MODEL__SERVER_RESULTS:
				return serverResults != null && !serverResults.isEmpty();
			case QNResultPackage.QN_RESULT_MODEL__DEMAND_RESULTS:
				return demandResults != null && !demandResults.isEmpty();
			case QNResultPackage.QN_RESULT_MODEL__DEMAND_SERVER_USAGES:
				return demandServerUsages != null && !demandServerUsages.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //QNResultModelImpl