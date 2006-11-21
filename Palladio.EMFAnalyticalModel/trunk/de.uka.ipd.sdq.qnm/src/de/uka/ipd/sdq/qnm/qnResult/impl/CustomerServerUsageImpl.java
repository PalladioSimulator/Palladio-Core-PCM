/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.qnResult.impl;

import de.uka.ipd.sdq.probfunction.math.ManagedPDF;

import de.uka.ipd.sdq.probfunction.math.ManagedPMF;

import de.uka.ipd.sdq.qnm.qnResult.CustomerResult;
import de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage;
import de.uka.ipd.sdq.qnm.qnResult.DemandResult;
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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Customer Server Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.CustomerServerUsageImpl#getCustomerResult <em>Customer Result</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.CustomerServerUsageImpl#getServerResult <em>Server Result</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.CustomerServerUsageImpl#getCausedWaitingTime <em>Caused Waiting Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.CustomerServerUsageImpl#getCausedWaitingTimeOneLess <em>Caused Waiting Time One Less</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.CustomerServerUsageImpl#getQueueLength <em>Queue Length</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.CustomerServerUsageImpl#getQueueLengthOneLess <em>Queue Length One Less</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.CustomerServerUsageImpl#getDemandsToServer <em>Demands To Server</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.impl.CustomerServerUsageImpl#getCustomerServiceTime <em>Customer Service Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomerServerUsageImpl extends EObjectImpl implements CustomerServerUsage {
	/**
	 * The cached value of the '{@link #getCustomerResult() <em>Customer Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomerResult()
	 * @generated
	 * @ordered
	 */
	protected CustomerResult customerResult = null;

	/**
	 * The cached value of the '{@link #getServerResult() <em>Server Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerResult()
	 * @generated
	 * @ordered
	 */
	protected ServerResult serverResult = null;

	/**
	 * The default value of the '{@link #getCausedWaitingTime() <em>Caused Waiting Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCausedWaitingTime()
	 * @generated
	 * @ordered
	 */
	protected static final ManagedPDF CAUSED_WAITING_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCausedWaitingTime() <em>Caused Waiting Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCausedWaitingTime()
	 * @generated
	 * @ordered
	 */
	protected ManagedPDF causedWaitingTime = CAUSED_WAITING_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCausedWaitingTimeOneLess() <em>Caused Waiting Time One Less</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCausedWaitingTimeOneLess()
	 * @generated
	 * @ordered
	 */
	protected static final ManagedPDF CAUSED_WAITING_TIME_ONE_LESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCausedWaitingTimeOneLess() <em>Caused Waiting Time One Less</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCausedWaitingTimeOneLess()
	 * @generated
	 * @ordered
	 */
	protected ManagedPDF causedWaitingTimeOneLess = CAUSED_WAITING_TIME_ONE_LESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueueLength() <em>Queue Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueLength()
	 * @generated
	 * @ordered
	 */
	protected static final ManagedPMF QUEUE_LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueueLength() <em>Queue Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueLength()
	 * @generated
	 * @ordered
	 */
	protected ManagedPMF queueLength = QUEUE_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueueLengthOneLess() <em>Queue Length One Less</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueLengthOneLess()
	 * @generated
	 * @ordered
	 */
	protected static final ManagedPMF QUEUE_LENGTH_ONE_LESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueueLengthOneLess() <em>Queue Length One Less</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueLengthOneLess()
	 * @generated
	 * @ordered
	 */
	protected ManagedPMF queueLengthOneLess = QUEUE_LENGTH_ONE_LESS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDemandsToServer() <em>Demands To Server</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDemandsToServer()
	 * @generated
	 * @ordered
	 */
	protected EList demandsToServer = null;

	/**
	 * The default value of the '{@link #getCustomerServiceTime() <em>Customer Service Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomerServiceTime()
	 * @generated
	 * @ordered
	 */
	protected static final ManagedPDF CUSTOMER_SERVICE_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCustomerServiceTime() <em>Customer Service Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomerServiceTime()
	 * @generated
	 * @ordered
	 */
	protected ManagedPDF customerServiceTime = CUSTOMER_SERVICE_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomerServerUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return QNResultPackage.Literals.CUSTOMER_SERVER_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomerResult getCustomerResult() {
		if (customerResult != null && customerResult.eIsProxy()) {
			InternalEObject oldCustomerResult = (InternalEObject)customerResult;
			customerResult = (CustomerResult)eResolveProxy(oldCustomerResult);
			if (customerResult != oldCustomerResult) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QNResultPackage.CUSTOMER_SERVER_USAGE__CUSTOMER_RESULT, oldCustomerResult, customerResult));
			}
		}
		return customerResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomerResult basicGetCustomerResult() {
		return customerResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCustomerResult(CustomerResult newCustomerResult, NotificationChain msgs) {
		CustomerResult oldCustomerResult = customerResult;
		customerResult = newCustomerResult;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QNResultPackage.CUSTOMER_SERVER_USAGE__CUSTOMER_RESULT, oldCustomerResult, newCustomerResult);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomerResult(CustomerResult newCustomerResult) {
		if (newCustomerResult != customerResult) {
			NotificationChain msgs = null;
			if (customerResult != null)
				msgs = ((InternalEObject)customerResult).eInverseRemove(this, QNResultPackage.CUSTOMER_RESULT__SERVER_USAGE, CustomerResult.class, msgs);
			if (newCustomerResult != null)
				msgs = ((InternalEObject)newCustomerResult).eInverseAdd(this, QNResultPackage.CUSTOMER_RESULT__SERVER_USAGE, CustomerResult.class, msgs);
			msgs = basicSetCustomerResult(newCustomerResult, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QNResultPackage.CUSTOMER_SERVER_USAGE__CUSTOMER_RESULT, newCustomerResult, newCustomerResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServerResult getServerResult() {
		if (serverResult != null && serverResult.eIsProxy()) {
			InternalEObject oldServerResult = (InternalEObject)serverResult;
			serverResult = (ServerResult)eResolveProxy(oldServerResult);
			if (serverResult != oldServerResult) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QNResultPackage.CUSTOMER_SERVER_USAGE__SERVER_RESULT, oldServerResult, serverResult));
			}
		}
		return serverResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServerResult basicGetServerResult() {
		return serverResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetServerResult(ServerResult newServerResult, NotificationChain msgs) {
		ServerResult oldServerResult = serverResult;
		serverResult = newServerResult;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QNResultPackage.CUSTOMER_SERVER_USAGE__SERVER_RESULT, oldServerResult, newServerResult);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerResult(ServerResult newServerResult) {
		if (newServerResult != serverResult) {
			NotificationChain msgs = null;
			if (serverResult != null)
				msgs = ((InternalEObject)serverResult).eInverseRemove(this, QNResultPackage.SERVER_RESULT__USING_CUSTOMERS, ServerResult.class, msgs);
			if (newServerResult != null)
				msgs = ((InternalEObject)newServerResult).eInverseAdd(this, QNResultPackage.SERVER_RESULT__USING_CUSTOMERS, ServerResult.class, msgs);
			msgs = basicSetServerResult(newServerResult, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QNResultPackage.CUSTOMER_SERVER_USAGE__SERVER_RESULT, newServerResult, newServerResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedPDF getCausedWaitingTime() {
		return causedWaitingTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCausedWaitingTime(ManagedPDF newCausedWaitingTime) {
		ManagedPDF oldCausedWaitingTime = causedWaitingTime;
		causedWaitingTime = newCausedWaitingTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QNResultPackage.CUSTOMER_SERVER_USAGE__CAUSED_WAITING_TIME, oldCausedWaitingTime, causedWaitingTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedPDF getCausedWaitingTimeOneLess() {
		return causedWaitingTimeOneLess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCausedWaitingTimeOneLess(ManagedPDF newCausedWaitingTimeOneLess) {
		ManagedPDF oldCausedWaitingTimeOneLess = causedWaitingTimeOneLess;
		causedWaitingTimeOneLess = newCausedWaitingTimeOneLess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QNResultPackage.CUSTOMER_SERVER_USAGE__CAUSED_WAITING_TIME_ONE_LESS, oldCausedWaitingTimeOneLess, causedWaitingTimeOneLess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedPMF getQueueLength() {
		return queueLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueLength(ManagedPMF newQueueLength) {
		ManagedPMF oldQueueLength = queueLength;
		queueLength = newQueueLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QNResultPackage.CUSTOMER_SERVER_USAGE__QUEUE_LENGTH, oldQueueLength, queueLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedPMF getQueueLengthOneLess() {
		return queueLengthOneLess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueLengthOneLess(ManagedPMF newQueueLengthOneLess) {
		ManagedPMF oldQueueLengthOneLess = queueLengthOneLess;
		queueLengthOneLess = newQueueLengthOneLess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QNResultPackage.CUSTOMER_SERVER_USAGE__QUEUE_LENGTH_ONE_LESS, oldQueueLengthOneLess, queueLengthOneLess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDemandsToServer() {
		if (demandsToServer == null) {
			demandsToServer = new EObjectResolvingEList(DemandResult.class, this, QNResultPackage.CUSTOMER_SERVER_USAGE__DEMANDS_TO_SERVER);
		}
		return demandsToServer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedPDF getCustomerServiceTime() {
		return customerServiceTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomerServiceTime(ManagedPDF newCustomerServiceTime) {
		ManagedPDF oldCustomerServiceTime = customerServiceTime;
		customerServiceTime = newCustomerServiceTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QNResultPackage.CUSTOMER_SERVER_USAGE__CUSTOMER_SERVICE_TIME, oldCustomerServiceTime, customerServiceTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QNResultPackage.CUSTOMER_SERVER_USAGE__CUSTOMER_RESULT:
				if (customerResult != null)
					msgs = ((InternalEObject)customerResult).eInverseRemove(this, QNResultPackage.CUSTOMER_RESULT__SERVER_USAGE, CustomerResult.class, msgs);
				return basicSetCustomerResult((CustomerResult)otherEnd, msgs);
			case QNResultPackage.CUSTOMER_SERVER_USAGE__SERVER_RESULT:
				if (serverResult != null)
					msgs = ((InternalEObject)serverResult).eInverseRemove(this, QNResultPackage.SERVER_RESULT__USING_CUSTOMERS, ServerResult.class, msgs);
				return basicSetServerResult((ServerResult)otherEnd, msgs);
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
			case QNResultPackage.CUSTOMER_SERVER_USAGE__CUSTOMER_RESULT:
				return basicSetCustomerResult(null, msgs);
			case QNResultPackage.CUSTOMER_SERVER_USAGE__SERVER_RESULT:
				return basicSetServerResult(null, msgs);
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
			case QNResultPackage.CUSTOMER_SERVER_USAGE__CUSTOMER_RESULT:
				if (resolve) return getCustomerResult();
				return basicGetCustomerResult();
			case QNResultPackage.CUSTOMER_SERVER_USAGE__SERVER_RESULT:
				if (resolve) return getServerResult();
				return basicGetServerResult();
			case QNResultPackage.CUSTOMER_SERVER_USAGE__CAUSED_WAITING_TIME:
				return getCausedWaitingTime();
			case QNResultPackage.CUSTOMER_SERVER_USAGE__CAUSED_WAITING_TIME_ONE_LESS:
				return getCausedWaitingTimeOneLess();
			case QNResultPackage.CUSTOMER_SERVER_USAGE__QUEUE_LENGTH:
				return getQueueLength();
			case QNResultPackage.CUSTOMER_SERVER_USAGE__QUEUE_LENGTH_ONE_LESS:
				return getQueueLengthOneLess();
			case QNResultPackage.CUSTOMER_SERVER_USAGE__DEMANDS_TO_SERVER:
				return getDemandsToServer();
			case QNResultPackage.CUSTOMER_SERVER_USAGE__CUSTOMER_SERVICE_TIME:
				return getCustomerServiceTime();
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
			case QNResultPackage.CUSTOMER_SERVER_USAGE__CUSTOMER_RESULT:
				setCustomerResult((CustomerResult)newValue);
				return;
			case QNResultPackage.CUSTOMER_SERVER_USAGE__SERVER_RESULT:
				setServerResult((ServerResult)newValue);
				return;
			case QNResultPackage.CUSTOMER_SERVER_USAGE__CAUSED_WAITING_TIME:
				setCausedWaitingTime((ManagedPDF)newValue);
				return;
			case QNResultPackage.CUSTOMER_SERVER_USAGE__CAUSED_WAITING_TIME_ONE_LESS:
				setCausedWaitingTimeOneLess((ManagedPDF)newValue);
				return;
			case QNResultPackage.CUSTOMER_SERVER_USAGE__QUEUE_LENGTH:
				setQueueLength((ManagedPMF)newValue);
				return;
			case QNResultPackage.CUSTOMER_SERVER_USAGE__QUEUE_LENGTH_ONE_LESS:
				setQueueLengthOneLess((ManagedPMF)newValue);
				return;
			case QNResultPackage.CUSTOMER_SERVER_USAGE__DEMANDS_TO_SERVER:
				getDemandsToServer().clear();
				getDemandsToServer().addAll((Collection)newValue);
				return;
			case QNResultPackage.CUSTOMER_SERVER_USAGE__CUSTOMER_SERVICE_TIME:
				setCustomerServiceTime((ManagedPDF)newValue);
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
			case QNResultPackage.CUSTOMER_SERVER_USAGE__CUSTOMER_RESULT:
				setCustomerResult((CustomerResult)null);
				return;
			case QNResultPackage.CUSTOMER_SERVER_USAGE__SERVER_RESULT:
				setServerResult((ServerResult)null);
				return;
			case QNResultPackage.CUSTOMER_SERVER_USAGE__CAUSED_WAITING_TIME:
				setCausedWaitingTime(CAUSED_WAITING_TIME_EDEFAULT);
				return;
			case QNResultPackage.CUSTOMER_SERVER_USAGE__CAUSED_WAITING_TIME_ONE_LESS:
				setCausedWaitingTimeOneLess(CAUSED_WAITING_TIME_ONE_LESS_EDEFAULT);
				return;
			case QNResultPackage.CUSTOMER_SERVER_USAGE__QUEUE_LENGTH:
				setQueueLength(QUEUE_LENGTH_EDEFAULT);
				return;
			case QNResultPackage.CUSTOMER_SERVER_USAGE__QUEUE_LENGTH_ONE_LESS:
				setQueueLengthOneLess(QUEUE_LENGTH_ONE_LESS_EDEFAULT);
				return;
			case QNResultPackage.CUSTOMER_SERVER_USAGE__DEMANDS_TO_SERVER:
				getDemandsToServer().clear();
				return;
			case QNResultPackage.CUSTOMER_SERVER_USAGE__CUSTOMER_SERVICE_TIME:
				setCustomerServiceTime(CUSTOMER_SERVICE_TIME_EDEFAULT);
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
			case QNResultPackage.CUSTOMER_SERVER_USAGE__CUSTOMER_RESULT:
				return customerResult != null;
			case QNResultPackage.CUSTOMER_SERVER_USAGE__SERVER_RESULT:
				return serverResult != null;
			case QNResultPackage.CUSTOMER_SERVER_USAGE__CAUSED_WAITING_TIME:
				return CAUSED_WAITING_TIME_EDEFAULT == null ? causedWaitingTime != null : !CAUSED_WAITING_TIME_EDEFAULT.equals(causedWaitingTime);
			case QNResultPackage.CUSTOMER_SERVER_USAGE__CAUSED_WAITING_TIME_ONE_LESS:
				return CAUSED_WAITING_TIME_ONE_LESS_EDEFAULT == null ? causedWaitingTimeOneLess != null : !CAUSED_WAITING_TIME_ONE_LESS_EDEFAULT.equals(causedWaitingTimeOneLess);
			case QNResultPackage.CUSTOMER_SERVER_USAGE__QUEUE_LENGTH:
				return QUEUE_LENGTH_EDEFAULT == null ? queueLength != null : !QUEUE_LENGTH_EDEFAULT.equals(queueLength);
			case QNResultPackage.CUSTOMER_SERVER_USAGE__QUEUE_LENGTH_ONE_LESS:
				return QUEUE_LENGTH_ONE_LESS_EDEFAULT == null ? queueLengthOneLess != null : !QUEUE_LENGTH_ONE_LESS_EDEFAULT.equals(queueLengthOneLess);
			case QNResultPackage.CUSTOMER_SERVER_USAGE__DEMANDS_TO_SERVER:
				return demandsToServer != null && !demandsToServer.isEmpty();
			case QNResultPackage.CUSTOMER_SERVER_USAGE__CUSTOMER_SERVICE_TIME:
				return CUSTOMER_SERVICE_TIME_EDEFAULT == null ? customerServiceTime != null : !CUSTOMER_SERVICE_TIME_EDEFAULT.equals(customerServiceTime);
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
		result.append(" (causedWaitingTime: ");
		result.append(causedWaitingTime);
		result.append(", causedWaitingTimeOneLess: ");
		result.append(causedWaitingTimeOneLess);
		result.append(", queueLength: ");
		result.append(queueLength);
		result.append(", queueLengthOneLess: ");
		result.append(queueLengthOneLess);
		result.append(", customerServiceTime: ");
		result.append(customerServiceTime);
		result.append(')');
		return result.toString();
	}

} //CustomerServerUsageImpl