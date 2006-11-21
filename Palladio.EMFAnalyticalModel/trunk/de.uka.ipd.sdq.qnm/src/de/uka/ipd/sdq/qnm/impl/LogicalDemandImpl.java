/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.impl;

import de.uka.ipd.sdq.qnm.ResourceUsage;
import de.uka.ipd.sdq.qnm.CompositeResourceUsage;
import de.uka.ipd.sdq.qnm.LogicalServer;
import de.uka.ipd.sdq.qnm.QnmPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Logical Demand</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.impl.LogicalDemandImpl#getLogicalserver <em>Logicalserver</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.impl.LogicalDemandImpl#getDemands <em>Demands</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LogicalDemandImpl extends DemandImpl implements CompositeResourceUsage {
	/**
	 * The cached value of the '{@link #getLogicalserver() <em>Logicalserver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogicalserver()
	 * @generated
	 * @ordered
	 */
	protected LogicalServer logicalserver = null;

	/**
	 * The cached value of the '{@link #getDemands() <em>Demands</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDemands()
	 * @generated
	 * @ordered
	 */
	protected EList demands = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LogicalDemandImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return QnmPackage.Literals.LOGICAL_DEMAND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalServer getLogicalserver() {
		if (logicalserver != null && logicalserver.eIsProxy()) {
			InternalEObject oldLogicalserver = (InternalEObject)logicalserver;
			logicalserver = (LogicalServer)eResolveProxy(oldLogicalserver);
			if (logicalserver != oldLogicalserver) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QnmPackage.LOGICAL_DEMAND__LOGICALSERVER, oldLogicalserver, logicalserver));
			}
		}
		return logicalserver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalServer basicGetLogicalserver() {
		return logicalserver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogicalserver(LogicalServer newLogicalserver) {
		LogicalServer oldLogicalserver = logicalserver;
		logicalserver = newLogicalserver;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QnmPackage.LOGICAL_DEMAND__LOGICALSERVER, oldLogicalserver, logicalserver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDemands() {
		if (demands == null) {
			demands = new EObjectContainmentEList(ResourceUsage.class, this, QnmPackage.LOGICAL_DEMAND__DEMANDS);
		}
		return demands;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QnmPackage.LOGICAL_DEMAND__DEMANDS:
				return ((InternalEList)getDemands()).basicRemove(otherEnd, msgs);
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
			case QnmPackage.LOGICAL_DEMAND__LOGICALSERVER:
				if (resolve) return getLogicalserver();
				return basicGetLogicalserver();
			case QnmPackage.LOGICAL_DEMAND__DEMANDS:
				return getDemands();
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
			case QnmPackage.LOGICAL_DEMAND__LOGICALSERVER:
				setLogicalserver((LogicalServer)newValue);
				return;
			case QnmPackage.LOGICAL_DEMAND__DEMANDS:
				getDemands().clear();
				getDemands().addAll((Collection)newValue);
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
			case QnmPackage.LOGICAL_DEMAND__LOGICALSERVER:
				setLogicalserver((LogicalServer)null);
				return;
			case QnmPackage.LOGICAL_DEMAND__DEMANDS:
				getDemands().clear();
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
			case QnmPackage.LOGICAL_DEMAND__LOGICALSERVER:
				return logicalserver != null;
			case QnmPackage.LOGICAL_DEMAND__DEMANDS:
				return demands != null && !demands.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LogicalDemandImpl