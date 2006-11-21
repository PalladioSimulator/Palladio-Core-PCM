/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.impl;

import de.uka.ipd.sdq.qnm.Task;
import de.uka.ipd.sdq.qnm.QNModel;
import de.uka.ipd.sdq.qnm.QnmPackage;
import de.uka.ipd.sdq.qnm.Resource;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>QN Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.impl.QNModelImpl#getCustomers <em>Customers</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.impl.QNModelImpl#getServers <em>Servers</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.impl.QNModelImpl#getINFINITE <em>INFINITE</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QNModelImpl extends EObjectImpl implements QNModel {
	/**
	 * The cached value of the '{@link #getCustomers() <em>Customers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomers()
	 * @generated
	 * @ordered
	 */
	protected EList customers = null;

	/**
	 * The cached value of the '{@link #getServers() <em>Servers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServers()
	 * @generated
	 * @ordered
	 */
	protected EList servers = null;

	/**
	 * The default value of the '{@link #getINFINITE() <em>INFINITE</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getINFINITE()
	 * @generated
	 * @ordered
	 */
	protected static final int INFINITE_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getINFINITE() <em>INFINITE</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getINFINITE()
	 * @generated
	 * @ordered
	 */
	protected int infinite = INFINITE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QNModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return QnmPackage.Literals.QN_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCustomers() {
		if (customers == null) {
			customers = new EObjectContainmentEList(Task.class, this, QnmPackage.QN_MODEL__CUSTOMERS);
		}
		return customers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getServers() {
		if (servers == null) {
			servers = new EObjectContainmentEList(Resource.class, this, QnmPackage.QN_MODEL__SERVERS);
		}
		return servers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getINFINITE() {
		return infinite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QnmPackage.QN_MODEL__CUSTOMERS:
				return ((InternalEList)getCustomers()).basicRemove(otherEnd, msgs);
			case QnmPackage.QN_MODEL__SERVERS:
				return ((InternalEList)getServers()).basicRemove(otherEnd, msgs);
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
			case QnmPackage.QN_MODEL__CUSTOMERS:
				return getCustomers();
			case QnmPackage.QN_MODEL__SERVERS:
				return getServers();
			case QnmPackage.QN_MODEL__INFINITE:
				return new Integer(getINFINITE());
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
			case QnmPackage.QN_MODEL__CUSTOMERS:
				getCustomers().clear();
				getCustomers().addAll((Collection)newValue);
				return;
			case QnmPackage.QN_MODEL__SERVERS:
				getServers().clear();
				getServers().addAll((Collection)newValue);
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
			case QnmPackage.QN_MODEL__CUSTOMERS:
				getCustomers().clear();
				return;
			case QnmPackage.QN_MODEL__SERVERS:
				getServers().clear();
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
			case QnmPackage.QN_MODEL__CUSTOMERS:
				return customers != null && !customers.isEmpty();
			case QnmPackage.QN_MODEL__SERVERS:
				return servers != null && !servers.isEmpty();
			case QnmPackage.QN_MODEL__INFINITE:
				return infinite != INFINITE_EDEFAULT;
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
		result.append(" (INFINITE: ");
		result.append(infinite);
		result.append(')');
		return result.toString();
	}

} //QNModelImpl